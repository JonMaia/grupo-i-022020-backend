package ar.edu.grupoi.backend.desappbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public Location save(Location location) {
		return locationRepository.save(location);
	}

	public List<Location> findAll() {
		return locationRepository.findAll();
	}

	public Location findById(Integer id) {
		return locationRepository.findById(id).get();
	}
}
