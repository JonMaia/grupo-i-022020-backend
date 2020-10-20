package ar.edu.grupoi.backend.desappbackend.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import ar.edu.grupoi.backend.desappbackend.dto.DtoDonation;
import ar.edu.grupoi.backend.desappbackend.dto.DtoDonor;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.service.DonorService;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ErrorLogin;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ExistingUser;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/crowdfunding/user")
public class DonorController {

	@Autowired
	private DonorService donorService;

	@CrossOrigin
	@PostMapping("/create")
	public ResponseEntity<Donor> create(@Valid @RequestBody Donor donor) throws ExistingUser {
		Donor newDonor = donorService.create(donor);
		return new ResponseEntity<>(newDonor, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Donor> login(@Valid @RequestBody Donor donor) throws ErrorLogin {
		Donor donorLogin = donorService.login(donor.getMail(), donor.getPassword());
		return new ResponseEntity<>(donorLogin, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/donate")
	public DtoDonation donate(@Valid @RequestBody DtoDonation dtoDonation) {
		return donorService.donate(dtoDonation);
	}

	@CrossOrigin
	@GetMapping("/points/{id}")
	public DtoDonor donorId(@PathVariable(value = "id") Integer id) {
		return donorService.donorId(id);
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
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Map<String, String> handleServiceError(
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
