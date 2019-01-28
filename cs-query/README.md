# CoffeeShop Query Service
The query service is the 'Q' in CQRS which stands for command query response segregation.  To learn more you can research this topic.  In the terms of this project we can scale our retrieve operation such that performance is not degraded as more users onboard.

## Getting Started
* Start the cs-query service by running `mvn spring-boot:run`


## Operations

Post   localhost:8081/menu requestbody: MenuItem   
Put    localhost:8081/menu requestbody: MenuItem   
Get    localhost:8081/menu   
Delete localhost:8081/menu{id}   


