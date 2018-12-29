package coffeeshop.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coffeeshop.app.domain.MenuLog;
import coffeeshop.app.repository.MenuLogRepository;

@Service
public class MenuLogServiceImpl implements MenuLogService{

	private MenuLogRepository menuLogRepository;
	
	@Autowired
	public MenuLogServiceImpl(MenuLogRepository menuLogRepository) {
		this.menuLogRepository = menuLogRepository;
	}
	
	public void createLog(MenuLog log) {
		menuLogRepository.save(log);
	}

}
