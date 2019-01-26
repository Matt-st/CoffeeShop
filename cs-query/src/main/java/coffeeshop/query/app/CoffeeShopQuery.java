package coffeeshop.query.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

//@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
public class CoffeeShopQuery {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopQuery.class, args);
    }
    
    
}

