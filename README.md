# Microservices Example

Example implementations of:
 * A background process which:
   * Imports data from flat files into a MongoDB instance
   * Provides basic metrics to a HTTP endpoint
 * A REST interface which:
   * Reads data from the MongoDB instance
   * Provides basic metrics to a HTTP endpoint

The example uses the UK Food Standards Agency dataset, which rates restaurants
by the hygeine of their establishments.

# Example Platforms

 * Node.js / Express
 * Python / Tornado
 * Java / Dropwizard

# How to Use

 * Install a MongoDB replicaset using the Ansible playbook at:
   * https://github.com/a-h/ansible-mongodb-cluster
 * Create a user which has permission to write to the establishments collection
   at the Mongo shell.

```
use establishments
db.createUser({ user: "food_standards", pwd: "123456", roles: [ "readWrite" ] })
```

 * Use the download_data.py script to download the latest set of data. The
   script then converts the XML files into a single file containing a JSON
   object per line.
   * To run the setup.py file, you'll need to add the xmltodict package:
     * ```pip install xmltodict```
 * Each service example includes an import program.
