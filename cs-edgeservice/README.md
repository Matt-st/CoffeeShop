# CoffeeShop Edge Service
The edge service is the spring cloud gateway project.  This service performs routeing to our applications by way of the Eureka server.

## Getting Started
* Start the cs-eureka Server
* Start the cs-config Server
* Start the cs-edgeservice by running `mvn spring-boot:run`
* Start the cs-commands or cs-query service
* Test the edgeservice by hitting the endpoint `localhost:9999/menu`
