package ar.edu.grupoi.backend.desappbackend.webservice;

import java.util.HashMap;
import java.util.Map;

import ar.edu.grupoi.backend.desappbackend.dto.DtoAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import ar.edu.grupoi.backend.desappbackend.dto.DtoProject;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.model.user.Admin;
import ar.edu.grupoi.backend.desappbackend.service.AdminService;
import ar.edu.grupoi.backend.desappbackend.service.exception.ErrorLogin;
import ar.edu.grupoi.backend.desappbackend.service.exception.ErrorProjectFinished;

import javax.validation.Valid;

@RestController
@RequestMapping("/backoffice")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Admin> login(@Valid @RequestBody DtoAdmin admin) throws ErrorLogin {
		Admin adminLogin = adminService.login(admin.getMail(), admin.getPassword());
		return new ResponseEntity<>(adminLogin, HttpStatus.OK);
	}
	
	@CrossOrigin
	@PostMapping("/create_project")
	public Project createProject(@Valid @RequestBody DtoProject project) {
		return adminService.createProject(project);
	}
	
	@CrossOrigin
	@PutMapping(value = "/finish_collection", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity finishCollection(@Valid @RequestBody DtoProject project) {
		try {
			Project new_project = adminService.finishCollection(project);
			return new ResponseEntity<>(new_project, HttpStatus.OK);
		} catch (ErrorProjectFinished e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
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
