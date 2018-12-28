package coffeeshop.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class CoffeeShopEventLog {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopEventLog.class, args);
    }
    
    @KafkaListener(topics = "${message.topic.name}", groupId = "foo", containerFactory = "testKafkaListenerContainerFactory")
    public void listenGroupFoo(String message) {
        System.out.println("Received Messasge in group 'foo': " + message);
    }
}