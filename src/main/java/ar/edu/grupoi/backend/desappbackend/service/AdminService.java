package ar.edu.grupoi.backend.desappbackend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import ar.edu.grupoi.backend.desappbackend.dto.DtoProject;
import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.model.user.Admin;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.repositories.AdminRepository;
import ar.edu.grupoi.backend.desappbackend.repositories.DonorRepository;
import ar.edu.grupoi.backend.desappbackend.repositories.LocationRepository;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ErrorLogin;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private LocationService locationService;

	@Autowired
	private ProjectService projectService;
		
	@Autowired
    private EmailService emailService;
	
	@Autowired
	private DonorService donorService;


	public Admin login(String mail, String password) throws ErrorLogin {
		try {
			Admin adminLogin = adminRepository.findByMail(mail);
			if (!(adminLogin.getPassword().equals(password))) {
				throw new ErrorLogin();
			}
			return adminLogin;
		} catch (Exception e) {
			throw new ErrorLogin();
		}
	}

	public Project createProject(DtoProject dtoProject) {
		Admin admin = adminRepository.findById(dtoProject.getAdminId()).get();
		
		String locationName = dtoProject.getLocationName();
		String province = dtoProject.getLocationProvince();
		int population = dtoProject.getLocationPopulation();
		boolean state = dtoProject.getLocationState();
		
		String name = dtoProject.getName();
		double minPercentage = dtoProject.getMinPercentage();
		LocalDate endDate = dtoProject.getEndDate();
		Double factor = dtoProject.getFactor();

		Location location = new Location(locationName, province, population, state);
		locationService.save(location);;

		Project project = admin.createProject(name, minPercentage, endDate, location, factor);
		return projectService.save(project);
	}

	public Project finishCollection(DtoProject dtoProject) {
		Admin admin = adminRepository.findById(dtoProject.getAdminId()).get();
		Project projectId = projectService.findById(dtoProject.getProjectId());
		
		admin.finishCollection(projectId);
		Project project = projectService.save(projectId);
		return project;
	}

	public void notifyNews(DtoProject dtoProject) {
		Project project = projectService.findById(dtoProject.getProjectId());
		List<Donor> donors = donorService.findDonors(dtoProject.getProjectId());
		
		emailService.notifyNews(donors, project);
	}

	public void top10DonationsLocalidations() {
		List<Project> projects = projectService.top10ProjectDonationes();
		List<Donor> donors = donorService.findAll();

		emailService.sendTop10(projects, donors);
	}

}
