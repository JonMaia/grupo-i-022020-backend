package ar.edu.grupoi.backend.desappbackend.model.user;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import ar.edu.grupoi.backend.desappbackend.model.project.Donation;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;

@Entity
public class Donor extends User{

	@NotBlank(message = "Nickname is mandatory")
	@Size(min = 4, max = 10)
	private String nickname;

	public Donor() {}
	
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

	public Donation donate(Project project, Integer amount, String comment) {
		Donation donation = new Donation(LocalDate.now(), amount, project, nickname, comment);
		donation.calculatePointsEarned();
		return donation;
	}
	
}
