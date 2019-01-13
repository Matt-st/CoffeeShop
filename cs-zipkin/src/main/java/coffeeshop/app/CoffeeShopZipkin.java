package coffeeshop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;


@SpringBootApplication
@EnableZipkinServer
public class CoffeeShopZipkin {

	public static void main(String[] args) {
        SpringApplication.run(CoffeeShopZipkin.class, args);
    }
}
