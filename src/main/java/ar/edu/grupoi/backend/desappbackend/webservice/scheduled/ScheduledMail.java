package ar.edu.grupoi.backend.desappbackend.webservice.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoi.backend.desappbackend.service.AdminService;

@Component
@Controller
public class ScheduledMail {
	
	@Autowired
	private AdminService adminService;
	
	@Transactional
	@Scheduled(cron = "0 10 11 * * *")
	public void sendDailyEmail() {
		adminService.top10Donations();
		adminService.top10Locations();
	}

}
