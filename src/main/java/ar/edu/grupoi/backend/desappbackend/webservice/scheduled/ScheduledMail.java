package ar.edu.grupoi.backend.desappbackend.webservice.scheduled;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.service.AdminService;
import ar.edu.grupoi.backend.desappbackend.service.DonorService;
import ar.edu.grupoi.backend.desappbackend.service.EmailService;
import ar.edu.grupoi.backend.desappbackend.service.LocationService;
import ar.edu.grupoi.backend.desappbackend.service.ProjectService;

@Component
@Controller
public class ScheduledMail {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private LocationService locationService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private DonorService donorService;
	
	@Transactional
	@Scheduled(cron = "0 25 11 * * *")
	public void sendDailyEmail() {
//		adminService.top10Donations();
	//	adminService.top10Locations();
		List<Project> projects = projectService.top10ProjectDonationes();
		List<Donor> donors = donorService.findAll();
		emailService.sendTop10Projects(projects, donors);
	}

}
