package ar.edu.grupoi.backend.desappbackend.webservice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import ar.edu.grupoi.backend.desappbackend.dto.DtoProject;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.model.user.Admin;
import ar.edu.grupoi.backend.desappbackend.service.AdminService;
import ar.edu.grupoi.backend.desappbackend.service.exception.ErrorLogin;

import javax.validation.Valid;

@RestController
@RequestMapping("/backoffice")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Admin> login(@Valid @RequestBody Admin admin) throws ErrorLogin {
		Admin adminLogin = adminService.login(admin.getMail(), admin.getPassword());
		return new ResponseEntity<>(adminLogin, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/create_project")
	public Project createProject(@Valid @RequestBody DtoProject project) {
		return adminService.createProject(project);
	}
	
	@CrossOrigin
	@PutMapping("/finish_collection")
	public Project finishCollection(@Valid @RequestBody DtoProject project) {
		return adminService.finishCollection(project);
	}
	
	@CrossOrigin
	@GetMapping("/top10_donations")
	public void top10() {
		adminService.top10Donations();
	}
	
	@CrossOrigin
	@GetMapping("/top10_locations")
	public void top10Location() {
		adminService.top10Locations();
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(
			MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}
}
