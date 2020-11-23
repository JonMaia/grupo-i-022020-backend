package ar.edu.grupoi.backend.desappbackend.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.grupoi.backend.desappbackend.dto.DtoLocation;
import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.service.LocationService;

@RestController
@RequestMapping("/crowdfunding/location")
public class LocationController {

	@Autowired
	private LocationService locationService;
	
	@CrossOrigin
	@GetMapping("/findAll")
	public List<DtoLocation> findAll() {
		return locationService.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public Location findById(@PathVariable(value = "id") Integer id) {
		return locationService.findById(id);
	}
}
