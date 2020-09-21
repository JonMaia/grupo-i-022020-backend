package ar.edu.grupoi.backend.desappbackend.model.project;

import java.time.LocalDate;

public class Donation {
	
	private final LocalDate date;
	private Integer amount;
	private Project project;
	private String nickname;
	private Integer points;
	private String comment;
	
	public Donation(LocalDate date, Integer amount, Project project, String nickname, String comment) {
		this.date = date;
		this.amount = amount;
		this.project = project;
		this.nickname = nickname;
		this.comment = comment;
		this.points = 0;
	}

	public LocalDate getDate() {
		return date;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getPoints() {
		return points;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public void calculatePointsEarned() {
		Integer money = this.bonusMoney();
		Integer inhabitants = this.bonusInhabitants();
		this.points += money + inhabitants;
	}

	private Integer bonusInhabitants() {
		return this.project.getLocation().getPopulation() < 2000 ? this.amount * 2 : 0;
	}

	private Integer bonusMoney() {
		return this.amount >= 1000 ? this.amount : 0;
	}

	public String getNameProject() {
		return project.getName();
	}
	
}
