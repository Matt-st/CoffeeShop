# CoffeeShop Configuration Server
This project is the configuration server.  To allow for scalability and refresh capabilities the configuration server serves up a rest api that other applications can call to retrieve there configuration files.

## Getting Started
Start the Eureka server first.  
To start the application run `mvn spring-boot:run`
To hit the endpoint directly use `http://localhost:8888/cs-edgeservice/default`  
It should register with Eureka as well.  
Start any other application in the architecture and you should see logging at startup that the application is fetching it's configuration from the config server.  
