package ar.edu.grupoi.backend.desappbackend.model.user;

import java.time.LocalDate;

import ar.edu.grupoi.backend.desappbackend.model.project.Donation;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;

public class Donor extends User{

	private String nickname;

	public Donor(String name, String mail, String password, String nickname) {
		super(name, mail, password);
		this.nickname = nickname;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Donation donate(Project project, Integer amount, String nickname, String comment) {
		Donation donation = new Donation(LocalDate.now(), amount, project, nickname, comment);
		donation.calculatePointsEarned();
		return donation;
	}
	
}
