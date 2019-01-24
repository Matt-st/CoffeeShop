# CoffeeShop Event Log
The event log service is an idea I have for saving events and storing them in a database table.  Right now this service consumes messages from a kafak topic and stores them in a cassandra database.  I think in the future we will leverage these events for business purposes.

## Getting Started
* Start the cs-eureka service
* Start the cs-config service
* Start the cs-eventlog by running `mvn spring-boot:run`
