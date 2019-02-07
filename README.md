# CoffeeShop
This is an example application that shows the usage of much of the spring framework plus some other interesting aspects and concepts on building real world applications.

![Architecture diagram](https://github.com/Matt-st/CoffeeShop/img/cs-architecture.html  "Architecture Diagram")

## CoffeeShop-Command
This is a sample application that presents rest api's that allow for Create, Update, and Delete operations.  We are using the CQRS design pattern, this pattern allows us to scale the functionality of our application separately.

## CoffeeShop-Query
This is a sample application that presents rest api's that allow for retrieve operations.  We are using the CQRS design pattern, this pattern allows us to scale the functionality of our application separately.


## CoffeeShop-EventLog
This application reads from a Kafka topic that captures the event logs from our middleware applications.  Currently the event log only captures the event that occurred but in the future it will capture information about the user that triggered the event.

By storing our logs in the database then we can hook up a search tool where we can easily search for logs when we our troubleshooting application issues.

## CoffeeShop-Eureka
This application is the spring-boot eureka server which allows for service discovery and registration.

# Technologies
Thymeleaf templating
Feign rest client
Spring Cloud Api  
Spring Discovery/Registration Service - Eureka  
Spring-boot  
Kafka - application communication  
Cassandra -  datastore for our set of applications  
Zipkin Service  
Hystrix  
Spring Cloud Config  
Swagger


# Design Patterns
API Gateway
Command Query Response Segregation
Service Discovery and Registration
Fault Tolerance
Event Sourcing
Eventual Consistency Data Model


## Cassandra Database

Keyspace `menuitems`:  
` create keyspace menuitems
   ... with replication = {'class':'SimpleStrategy', 'replication_factor' : 3};`  
  
 `create table items (id int primary key, name text, description text);`  


Keyspace `menulogs`:  
`create keyspace menulogs
   ... with replication = {'class':'SimpleStrategy', 'replication_factor' : 3};`  
`create table logs (id UUID PRIMARY KEY, description text, log_timestamp text);`  
