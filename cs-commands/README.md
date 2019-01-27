# CoffeeShop Commands Service

This application represents the operational commands for the menu backend application.  Based on the command query response segregation model I tried to build this architecture in such a way that I could scale the commands differently from the retrieve functionality.  Considering that most likely more folks woudl want to retrieve the data than update it at any given time.

## Getting started
To start the application run: `mvn spring-boot:run`  
Based on the application properties this application will startup on `localhost:8080`  
To view the swagger documentation: `localhost:8080/swagger-ui.html`  


## Operations
![Swagger UI Image](img/swagger-docs.png?raw=true "Title")
