from tornado.ioloop import IOLoop
from tornado.web import Application, url
from establishment_handler import EstablishmentHandler
from establishment_repository import EstablishmentRepository

_uri = "mongodb://localhost:27017"

def make_app():
    return Application(get_handlers())


def get_handlers():
    return [
        url(r"/establishment/?", EstablishmentHandler, dict(establishment_repository=EstablishmentRepository(_uri))),
        url(r"/establishment/(.+)", EstablishmentHandler, dict(establishment_repository=EstablishmentRepository(_uri))),
    ]


def main():
    app = make_app()
    app.listen(8888)
    IOLoop.current().start()


if __name__ == "__main__":
    if len(sys.argv) > 1:
        _uri = sys.argv[1]

    print(str.format("Connecting to MongoDB {0}", _uri))

    main()
