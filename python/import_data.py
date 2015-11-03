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
    #import_to_mongo(file_name)
    import_thread = threading.Thread(target=fake_import)
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
            _status.update(status=Status.running, operations_successful=1, operations_failed=0)

        time.sleep(1)


def import_to_mongo(file_name):
    db_name = "establishments"
    client = MongoClient("mongodb://food_standards:123456@mongo1:27017,mongo2:27017,mongo3:27017/" + db_name + "?replicaSet="
                         "mongo_replication&authMechanism=SCRAM-SHA-1", w=3, j=True)

    db = client.establishments

    # use establishments
    # db.createUser({ user: "food_standards", pwd: "123456", roles: [ "readWrite" ] })

    start = datetime.datetime.now()

    idx = 0
    for line in open(file_name, "r"):
        j = json.loads(line)

        # Retry behaviour for insert operation, see
        # http://www.arngarden.com/2013/04/29/handling-mongodb-autoreconnect-exceptions-in-python-using-a-proxy/
        for i in range(5):
            try:
                db.establishments.insert(j)
                break
            except AutoReconnect:
                print("Sleeping while a new primary is elected.")
                time.sleep(pow(2, i))

        record_count = idx + 1
        time_diff = (datetime.datetime.now() - start)
        seconds = time_diff.total_seconds()
        minutes = seconds / 60
        records_per_second = record_count / seconds

        if idx == 0 or idx % 100 == 0:
            print(str.format("Inserted {0} records in {1} minutes - averaging at {2} per second", record_count,
                             int(minutes), int(records_per_second)))

        idx += 1


if __name__ == "__main__":
    main()
