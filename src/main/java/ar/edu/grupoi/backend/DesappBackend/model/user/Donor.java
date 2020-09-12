package ar.edu.grupoi.backend.DesappBackend.model.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ar.edu.grupoi.backend.DesappBackend.model.project.Donation;
import ar.edu.grupoi.backend.DesappBackend.model.project.Project;

public class Donor extends User{

	private String nickname;
	private List<Donation> donations;

	public Donor(String name, String mail, String password, String nickname) {
		super(name, mail, password);
		this.nickname = nickname;
		this.donations = new ArrayList<Donation>();
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
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

	public List<Donation> getDonations() {
		return donations;
	}

	public void setDonations(List<Donation> donations) {
		this.donations = donations;
	}

	public Integer accumulatedPoints() {
		Integer totalAccumulatedPoints = 0;
		
		totalAccumulatedPoints += totalDonationsMoth() + totalPointsDonations();
		
		return totalAccumulatedPoints;
	}

	private Integer totalPointsDonations() {
		return donations.stream()
				.mapToInt((donation) -> donation.getPoints())
				.sum();
	}

	private Integer totalDonationsMoth() {
		Integer totalDonationsMoth = (int) donations.stream()
				.filter((donation) -> donation.getDate().getMonth() == LocalDate.now().getMonth())
				.count();
		if(totalDonationsMoth >= 2) {
			return 500;
		}
		
		return 0;
	}

	public void donar(Project project, Integer amount, String nickname, String comment) {
		Donation donation = new Donation(LocalDate.now(), amount, project, nickname, comment);
		donation.calculatePointsEarned();
		this.donations.add(donation);
	}
	
	
}
