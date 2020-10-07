package ar.edu.grupoi.backend.desappbackend.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.edu.grupoi.backend.desappbackend.model.project.Project;
import ar.edu.grupoi.backend.desappbackend.service.ProjectService;

@RestController
@RequestMapping("/crowdfunding/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@CrossOrigin
	@GetMapping("/open_projects")
	public List<Project> openProjects() {
		return projectService.openProject();
	}

	@CrossOrigin
	@GetMapping("/next_finish")
	public List<Project> nextFinish() {
		return projectService.nextFinish();
	}
}
