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
import ar.edu.grupoi.backend.desappbackend.repositories.DonorRepository;
import ar.edu.grupoi.backend.desappbackend.repositories.LocationRepository;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ErrorLogin;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private ProjectService projectService;
		
	@Autowired
    private EmailService emailService;
	
	@Autowired
	private DonorRepository donorRepository;

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

	public DtoProject createProject(DtoProject dtoProject) {
		Admin admin = adminRepository.findById(dtoProject.getIdAdmin()).get();
		Location locationId = locationRepository.findById(dtoProject.getIdLocation()).get();

		String name = dtoProject.getName();
		double minPercentage = dtoProject.getMinPercentage();
		LocalDate endDate = dtoProject.getEndDate();
		Location location = locationId;
		Double factor = dtoProject.getFactor();

		Project project = admin.createProject(name, minPercentage, endDate, location, factor);
		Project projectId = projectService.save(project);

		dtoProject.setIdProject(projectId.getId());
		dtoProject.setNameLocation(projectId.getLocation().getName());

		return dtoProject;
	}

	public Project finishCollection(DtoProject dtoProject) {
		Admin admin = adminRepository.findById(dtoProject.getIdAdmin()).get();
		Project projectId = projectService.findById(dtoProject.getIdProject());
		
		admin.finishCollection(projectId);
		Project project = projectService.save(projectId);
		return project;
	}

	public void notifyNews(DtoProject dtoProject) {
		Project project = projectService.findById(dtoProject.getIdProject());
		List<Donor> donors = donorRepository.findDonors(dtoProject.getIdProject());
		
		emailService.notifyNews(donors, project);
	}

}
