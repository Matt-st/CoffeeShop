# CoffeeShop Query Service
The query service is the 'Q' in CQRS which stands for command query response segregation.  To learn more you can research this topic.  In the terms of this project we can scale our retrieve operation such that performance is not degraded as more users onboard.

## Getting Started
* Start the cs-eureka service
* Start the cs-config service
* Start the cs-edgeservice service
* Start the cs-query service by running `mvn spring-boot:run`
