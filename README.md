<img src="https://github.com/weso/turbine/blob/master/.github/turbine-logo@small.png" alt="Snomed logo" height="125">

## Welcome to turbine
Turbine is a library that allows to validate RDF streams against a given schema.

## How to use turbine

```java

// Turbine will connect to kafka at the given ip address and to the given topic.
Turbine turbine = new Turbine( new KafkaConsumer("127.0.0.1", "rdf-streams-topic"),
                               Validator.DEFAULT_SHACLEX_VALIDATOR);

// Start turbine
turbine.run();

// Do whatever you want...

// Will tear down the connection to kafka.
turbine.stop();

```
