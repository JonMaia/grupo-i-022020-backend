package ar.edu.grupoi.backend.desappbackend.model.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.grupoi.backend.desappbackend.model.project.Donation;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;

public class Donor extends User{

	private String nickname;
	private final List<Donation> donations;

	public Donor(String name, String mail, String password, String nickname) {
		super(name, mail, password);
		this.nickname = nickname;
		this.donations = new ArrayList<>();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer accumulatedPoints() {
		return totalDonationsMoth() + totalPointsDonations();
	}

	private Integer totalPointsDonations() {
		return donations.stream()
				.mapToInt(Donation::getPoints)
				.sum();
	}

	private Integer totalDonationsMoth() {
		// Ver de separar en dos métodos y quizá debería ir en donación el conteo de puntos y en sistema las donaciones
		// que realizó el usuario en tal mes.
		int totalDonationsMoth = (int) donations.stream()
				.filter((donation) -> donation.getDate().getMonth() == LocalDate.now().getMonth())
				.count();
		return totalDonationsMoth >= 2 ? 500 : 0;
	}

	public void donate(Project project, Integer amount, String nickname, String comment) {
		Donation donation = new Donation(LocalDate.now(), amount, project, nickname, comment);
		donation.calculatePointsEarned();
		this.donations.add(donation);
	}
	
}
