package ar.edu.grupoi.backend.desappbackend.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.grupoi.backend.desappbackend.dto.DtoProject;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	public List<Project> openProject() {
		return projectRepository.findAllByActive(true);
	}

	public List<Project> nextFinish() {
		return projectRepository.findAllByEndDate(LocalDate.now());
	}

	public Project save(Project project) {
		return projectRepository.save(project);
	}

	public Project findById(Integer idProject) {
		return projectRepository.findById(idProject).get();
	}

	public List<Project> top10ProjectDonationes() {
		return projectRepository.top10();
	}

	public DtoProject projectId(Integer id) {
		Project project = projectRepository.findById(id).get();
		Integer cantDonations = projectRepository.cantDonations(id);
		
		DtoProject dtoProject = new DtoProject();
		dtoProject.setName(project.getName());
		dtoProject.setEndDate(project.getEndDate());
		dtoProject.setMinPercentage(project.getMinPercentage());
		dtoProject.setFactor(project.getFactor());
		dtoProject.setLocationName(project.getLocation().getName());
		dtoProject.setLocationProvince(project.getLocation().getProvince());
		dtoProject.setLocationPopulation(project.getLocation().getPopulation());
		dtoProject.setLocationState(project.getLocation().getState());
		dtoProject.setCantDonations(cantDonations);
		return dtoProject;
	}

}
