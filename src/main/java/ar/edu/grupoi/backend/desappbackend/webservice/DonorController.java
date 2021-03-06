package ar.edu.grupoi.backend.desappbackend.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import ar.edu.grupoi.backend.desappbackend.dto.DtoDonation;
import ar.edu.grupoi.backend.desappbackend.dto.DtoDonor;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.service.DonorService;
import ar.edu.grupoi.backend.desappbackend.service.exception.ErrorLogin;
import ar.edu.grupoi.backend.desappbackend.service.exception.ExistingUser;

import javax.validation.Valid;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/crowdfunding/user")
public class DonorController {

	@Autowired
	private DonorService donorService;

	@PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity create(@Valid @RequestBody Donor donor) {
		try {
			Donor newDonor = donorService.create(donor);
			return new ResponseEntity<>(newDonor, HttpStatus.OK);
		} catch (ExistingUser e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity login(@Valid @RequestBody DtoDonor donor) {
		try {
			Donor donorLogin = donorService.login(donor.getMail(), donor.getPassword());
			return new ResponseEntity<>(donorLogin, HttpStatus.OK);
		} catch (ErrorLogin e) {
			return ResponseEntity.status(400).body(e.getMessage());
		}
	}

	@PostMapping("/donate")
	public DtoDonation donate(@Valid @RequestBody DtoDonation dtoDonation) {
		return donorService.donate(dtoDonation);
	}

	@GetMapping("/info/{id}")
	public DtoDonor donorId(@PathVariable(value = "id") Integer id) {
		return donorService.donorId(id);
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return errors;
	}

}
