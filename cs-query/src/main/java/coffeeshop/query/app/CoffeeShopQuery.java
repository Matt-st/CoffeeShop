package coffeeshop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication

public class CoffeeShopQuery {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopQuery.class, args);
    }
    
}

