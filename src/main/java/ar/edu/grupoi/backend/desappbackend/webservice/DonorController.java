package ar.edu.grupoi.backend.desappbackend.webservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import ar.edu.grupoi.backend.desappbackend.dto.DtoDonation;
import ar.edu.grupoi.backend.desappbackend.dto.DtoDonor;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.service.DonorService;
import ar.edu.grupoi.backend.desappbackend.service.exception.ErrorLogin;
import ar.edu.grupoi.backend.desappbackend.service.exception.ExistingUser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.validation.Valid;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/crowdfunding/user")
public class DonorController {

	@Autowired
	private DonorService donorService;

	@CrossOrigin
	@PostMapping("/create")
	public ResponseEntity create(@Valid @RequestBody Donor donor) {
		try {
			Donor newDonor = donorService.create(donor);
			return new ResponseEntity<>(newDonor, HttpStatus.OK);
		} catch (ExistingUser e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}
/*
	cambiar todo los post requesbody por como esta acac
	por el security*/
	@CrossOrigin
	@PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity login(@Valid @RequestBody DtoDonor donor) {
		try {
			Donor donorLogin = donorService.login(donor.getMail(), donor.getPassword());
			return new ResponseEntity<>(donorLogin, HttpStatus.OK);
		} catch (ErrorLogin e) {
			return ResponseEntity.status(500).body(e.getMessage());
		}
	}

	@CrossOrigin
	@PostMapping("/donate")
	public DtoDonation donate(@Valid @RequestBody DtoDonation dtoDonation) {
		return donorService.donate(dtoDonation);
	}

	@CrossOrigin
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
