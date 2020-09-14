package ar.edu.grupoi.backend.DesappBackend.model.user;

import java.time.LocalDate;

import ar.edu.grupoi.backend.DesappBackend.model.project.Location;
import ar.edu.grupoi.backend.DesappBackend.model.project.Project;

public class Admin extends User{

	public Admin(String name, String mail, String password) {
		super(name, mail, password);
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getMail() {
		return this.mail;
	}

	@Override
	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	public void finishCollection(Project project) {
		if(this.compledCollection(project)) {
			project.closedProject();
		}
	}

	private boolean compledCollection(Project project) {
		return this.requeridPercentage(project) >= project.getCumulativePercentage();
	}

	private double requeridPercentage(Project project) {
		return (project.getCollection()*100) / project.moneyRequerid();
	}
	
	public void notifyNews(Project project) {
		project.getDonors().forEach((donor) -> {
			this.sendNews(donor, project);
		});
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

	public Project createProject(String name, double minPercentage, LocalDate endDate, Location location, int factor) {
		return new Project(name, minPercentage, endDate, location, factor);
	}
}
