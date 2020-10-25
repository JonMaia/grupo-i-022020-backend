package ar.edu.grupoi.backend.desappbackend.model.user;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;

import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;

@Entity
public class Admin extends User {

	public Admin() {}
	
	public Admin(String name, String mail, String password) {
		super(name, mail, password);
	}

	public void finishCollection(Project project) {
		if(project.compledCollection()) {
			project.closedProject();
		}
	}
	
	public void notifyNews(Project project, List<Donor> donors) {
		for (Donor donor : donors) {
			sendNews(donor, project);
		}
	}

	private void sendNews(Donor donor, Project project) {
		System.out.println("from: Admin"
				+ "to:" +donor.mail
				+ "subjec: news project " +project.getName()
				+ "Dear " +donor.getName()
				+ "We inform you that project " +project.getName()
				+ "will be started."
				+ "Thanks to your donation." 
				+ "The Team Admin."
				);
	}

	public Project createProject(String name, double minPercentage, LocalDate endDate, Location location, Double factor) {
		return new Project(name, endDate, location, minPercentage, factor);
	}
}
