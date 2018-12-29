package coffeeshop.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import coffeeshop.app.domain.MenuLog;
import coffeeshop.app.services.MenuLogService;

@SpringBootApplication
public class CoffeeShopEventLog {

	 private MenuLogService menuLogService;

	@Autowired
	  public void setProductService(MenuLogService menuLogService) {
	      this.menuLogService = menuLogService;
	  }
	
    public static void main(String[] args) {
        SpringApplication.run(CoffeeShopEventLog.class, args);
    }
    
    @KafkaListener(topics = "${message.topic.name}", groupId = "logs", containerFactory = "logsKafkaListenerContainerFactory")
    public void listenGroupLogs(String message) {
        System.out.println("Received Messasge in group 'logs': " + message);
        
        MenuLog log = new MenuLog();
        log.setDescription(message);
        
        menuLogService.createLog(log);
        
        
    }
}