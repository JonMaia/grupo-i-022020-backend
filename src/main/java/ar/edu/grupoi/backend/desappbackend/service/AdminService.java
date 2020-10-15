package ar.edu.grupoi.backend.desappbackend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.grupoi.backend.desappbackend.dto.DtoProject;
import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.model.user.Admin;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;
import ar.edu.grupoi.backend.desappbackend.repositories.AdminRepository;
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
		Admin admin = adminRepository.findById(dtoProject.getIdAdmin()).get();

		String locationName = dtoProject.getLocationName();
		String province = dtoProject.getLocationProvince();
		int population = dtoProject.getLocationPopulation();
		boolean state = dtoProject.isLocationState();

		String name = dtoProject.getName();
		double minPercentage = dtoProject.getMinPercentage();
		LocalDate endDate = dtoProject.getEndDate();
		Double factor = dtoProject.getFactor();

		Location newlocation = new Location(locationName, province, population, state);
		Location location = locationService.save(newlocation);

		Project project = admin.createProject(name, minPercentage, endDate, location, factor);
		Project newProject = projectService.save(project);
		return newProject;
	}

	public Project finishCollection(DtoProject dtoProject) {
		Admin admin = adminRepository.findById(dtoProject.getIdAdmin()).get();
		Project projectId = projectService.findById(dtoProject.getIdProject());

		admin.finishCollection(projectId);
		Project project = projectService.save(projectId);

		List<Donor> donors = donorService.findDonors(dtoProject.getIdProject());
		emailService.notifyNews(donors, project);
		return project;
	}

	public void top10Donations() {
		List<Project> projects = projectService.top10ProjectDonationes();
		List<Donor> donors = donorService.findAll();
		emailService.sendTop10(projects, donors);
	}

}
