package ar.edu.grupoi.backend.desappbackend.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.grupoi.backend.desappbackend.dto.DtoProject;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.model.user.Admin;
import ar.edu.grupoi.backend.desappbackend.service.AdminService;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ErrorLogin;

@RestController
@RequestMapping("/backoffice")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Admin> login(@RequestBody Admin admin) throws ErrorLogin {
		Admin adminLogin = adminService.login(admin.getMail(), admin.getPassword());
		return new ResponseEntity<>(adminLogin, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/create_project")
	public Project createProject(@RequestBody DtoProject project) {
		return adminService.createProject(project);
	}
	
	@CrossOrigin
	@PostMapping("/finish_collection")
	public Project finishCollection(@RequestBody DtoProject project) {
		return adminService.finishCollection(project);
	}
	
	@CrossOrigin
	@PostMapping("/top10_donations")
	public void top10() {
		adminService.top10Donations();
	}
}
