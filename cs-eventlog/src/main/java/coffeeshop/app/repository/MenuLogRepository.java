package coffeeshop.app.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

import coffeeshop.app.domain.MenuLog;

public interface MenuLogRepository extends CrudRepository<MenuLog, UUID> {
	
}

