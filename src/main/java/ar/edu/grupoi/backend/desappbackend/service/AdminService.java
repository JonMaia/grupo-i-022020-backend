package ar.edu.grupoi.backend.desappbackend.service;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.grupoi.backend.desappbackend.dto.DtoProject;
import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.model.user.Admin;
import ar.edu.grupoi.backend.desappbackend.repositories.AdminRepository;
import ar.edu.grupoi.backend.desappbackend.repositories.LocationRepository;
import ar.edu.grupoi.backend.desappbackend.repositories.ProjectRepository;
import ar.edu.grupoi.backend.desappbackend.webservice.exception.ErrorLogin;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private LocationRepository locationRepository;

	@Autowired
	private ProjectRepository projectRepository;

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
		Admin admin = adminRepository.findById(dtoProject.getAdminId()).get();
		Location locationId = locationRepository.findById(dtoProject.getLocationId()).get();

		String name = dtoProject.getName();
		double minPercentage = dtoProject.getMinPercentage();
		LocalDate endDate = dtoProject.getEndDate();
		Location location = locationId;
		Double factor = dtoProject.getFactor();

		Project project = admin.createProject(name, minPercentage, endDate, location, factor);
		Project projectId = projectRepository.save(project);

		dtoProject.setProjectId(projectId.getId());
		dtoProject.setNameLocation(projectId.getLocation().getName());

		return dtoProject;
	}

	public Project finishCollection(DtoProject dtoProject) {
		Admin admin = adminRepository.findById(dtoProject.getAdminId()).get();
		Project projectId = projectRepository.findById(dtoProject.getProjectId()).get();
		
		admin.finishCollection(projectId);
		Project project = projectRepository.save(projectId);
		return project;
	}

}
