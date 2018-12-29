# CoffeeShop
This is a sample application that shows the backend portion of an application that provides CRUD features for CoffeeShop menu.

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
Spring-boot  
Kafka - application communication  
Cassandra -  datastore for our set of applications  



## Cassandra Database

Keyspace `menuitems`:  
` create keyspace menuitems
   ... with replication = {'class':'SimpleStrategy', 'replication_factor' : 3};`  
  
 `create table items (id int primary key, name text, description text);`  


Keyspace `menulogs`:  
`create keyspace menulogs
   ... with replication = {'class':'SimpleStrategy', 'replication_factor' : 3};`  
`create table logs (id UUID PRIMARY KEY, description text, log_timestamp text);`  
