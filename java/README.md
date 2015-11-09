# A Java / Dropwizard Example

Compilation
-----------

```"C:\Program Files (x86)\JetBrains\IntelliJ IDEA Community Edition 15.0\plugins\maven\lib\maven3\bin\mvn.bat" compile```

Prepare the jar for usage.

```mvn package```

Running
-------

Establishment HTTP Service
--------------------------

```java -jar .\target\establishmentservice-1.0-SNAPSHOT.jar server .\settings.yaml```

Establishment Importer
--------------------------

```java -jar .\target\establishmentimporter-1.0-SNAPSHOT.jar server .\settings.yaml```
