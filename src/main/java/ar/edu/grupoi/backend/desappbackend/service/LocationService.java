package ar.edu.grupoi.backend.desappbackend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.grupoi.backend.desappbackend.dto.DtoLocation;
import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.repositories.LocationRepository;

@Service
public class LocationService {

	@Autowired
	private LocationRepository locationRepository;

	public Location save(Location location) {
		return locationRepository.save(location);
	}

	public List<DtoLocation> findAll() {
		List<Location> locations = locationRepository.findAll();
		List<DtoLocation> dtoLocations = new ArrayList<DtoLocation>();
		locations.forEach((location) -> {
			DtoLocation dtoLocation = new DtoLocation();
			dtoLocation.setId(location.getId());
			dtoLocation.setName(location.getName());
			dtoLocations.add(dtoLocation);
		});
		return dtoLocations;
	}

	public Location findById(Integer id) {
		return locationRepository.findById(id).get();
	}

	public List<Location> top10() {
		return locationRepository.top10();
	}
}
