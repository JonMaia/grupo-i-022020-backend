package ar.edu.grupoi.backend.desappbackend.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.grupoi.backend.desappbackend.dto.DtoDonation;
import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.service.DonorService;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ErrorLogin;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ExistingUser;

@RestController
@RequestMapping("/crowdfunding/user")
public class DonorController {

	@Autowired
	private DonorService donorService;

	@CrossOrigin
	@PostMapping("/create")
	public ResponseEntity<Donor> create(@RequestBody Donor donor) throws ExistingUser {
		Donor newDonor = donorService.create(donor);
		return new ResponseEntity<>(newDonor, HttpStatus.OK);
	}

	@CrossOrigin
	@PostMapping("/login")
	public ResponseEntity<Donor> login(@RequestBody Donor donor) throws ErrorLogin {
		Donor donorLogin = donorService.login(donor.getMail(), donor.getPassword());
		return new ResponseEntity<>(donorLogin, HttpStatus.OK);
	}
	
	/*
	 * 
	 * {
			"idDonor": "1" ,
			"idProject": "4",
			"amount": 1000,
			"comment": "primera donacion"
		}
		
		debe retornar 1000 puntos
		y con amuont menos 0
	 * */

	@CrossOrigin
	@PostMapping("/donate")
	public DtoDonation donate(@RequestBody DtoDonation dtoDonation) {
		return donorService.donate(dtoDonation);
	}

	@CrossOrigin
	@GetMapping("/project")
	public List<Project> projects() {
		return donorService.findAllProjects();
	}
	
	@CrossOrigin
	@GetMapping("/location")
	public List<Location> locations() {
		return donorService.findAllLocations();
	}

}
