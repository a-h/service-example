import json
import os
import datetime
import time
from pymongo.errors import AutoReconnect
from pymongo import MongoClient, WriteConcern
from flask import Flask
from queue import Queue, Empty
import threading
from servicestatus import Status, ServiceStatus
import logging
import jsonpickle

_status_lock = threading.Lock()
_app = Flask(__name__)
_status = ServiceStatus(status=Status.not_started, operations=0, exceptions=0)
_start_time = datetime.datetime.now()


def main():
    file_name = "../data.json"

    if not os.path.exists(file_name):
        raise Exception("The required data file isn't present. "
         "Run the download_data.py script")

    # Create a queue to handle cross-thread communication between the process
    # and the Web server.

    print("Starting import")
    client = MongoClient("mongodb://localhost/establishments", j=True)
    db = client.establishments
    batch_size = 10
    import_thread = threading.Thread(target=database_import,
                                     args=(file_name, db, batch_size))
    import_thread.start()

    print("Running web server")
    #log = logging.getLogger('werkzeug')
    #log.setLevel(logging.ERROR)
    _app.run()


@_app.route('/status')
def status():
    with _status_lock:
        return jsonpickle.encode(_status, unpicklable=False)


def fake_import():
    while True:
        with _status_lock:
            _status.update(status=Status.running, operations_successful=1,
                           operations_failed=0)

        time.sleep(1)


def database_import(file_name, db, batch_size = 10):
    import_to_mongo(db=db, input_lines=open(file_name, "r"),
                    batch_size=batch_size)


def import_to_mongo(db, input_lines, batch_size):
    start = datetime.datetime.now()

    idx = 0
    # Read the lines in as batches
    for lines in extract_slices(input_lines, batch_size):
        # Convert each line to JSON
        establishments = [json.loads(line) for line in lines]

        # Retry behaviour for insert operation, see
        # http://www.arngarden.com/2013/04/29/handling-mongodb-autoreconnect-exceptions-in-python-using-a-proxy/
        for i in range(5):
            try:
                db.establishments.insert_many(establishments)
                break
            except AutoReconnect:
                print("Sleeping while a new primary is elected.")
                time.sleep(pow(2, i))

        record_count = idx + len(lines)
        time_diff = (datetime.datetime.now() - start)
        seconds = time_diff.total_seconds()
        minutes = seconds / 60
        records_per_second = record_count / seconds

        if idx == 0 or idx % 100 == 0:
            print(str.format("Inserted {0} records in {1} minutes - averaging at {2} per second", record_count,
                             int(minutes), int(records_per_second)))

        idx += 1


def extract_slices(iterable, batch_size):
    cache = []

    for value in iterable:
        cache.append(value)

        if len(cache) == batch_size:
            yield cache
            cache = []

    if len(cache) > 0:
        yield cache


if __name__ == "__main__":
    main()
