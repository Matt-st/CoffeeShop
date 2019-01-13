package coffeeshop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient
@SpringBootApplication
public class EdgeServiceApplication {
	
	 public static void main(String[] args) {
	        SpringApplication.run(EdgeServiceApplication.class, args);
	    }
	 
//		@Bean
//		RouteLocator routeLocator(RouteLocatorBuilder rlb) {
//			return rlb
//					.routes()
//					.route(spec -> spec
//							.path("/menu-localhost")
//							.uri("http://localhost:8081/menu")
//					)
//					.route("route_id",
//							route -> route
//                            .path("/menu") 
//                            .uri("lb://cs-query")
//            )
//					// you can add as many routes as you want
//					// the routes can have custom filters that
//					// rate limit the requests, contribute
//					// custom headers, rewrite the URLs, etc.
//					.build();
//		}

}
