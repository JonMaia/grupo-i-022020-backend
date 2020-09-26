package ar.edu.grupoi.backend.desappbackend.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.service.DonorService;

@RestController
@RequestMapping("/crowdfunding/user")
public class DonorController {
	
	@Autowired
	private DonorService donorService;
	
	@CrossOrigin
    @PostMapping("/create")
	public void create(@RequestBody Donor donor) {
		donorService.create(donor);
	}
	
	@CrossOrigin
    @GetMapping("/login/{mail}")
	public Donor login(@PathVariable(value = "mail") String mail) {
		return donorService.login(mail);
	}
	
	@CrossOrigin
    @GetMapping("/todos")
	public List<Donor> findAll() {
		return donorService.findAll();
	}
}
