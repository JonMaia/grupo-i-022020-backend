package ar.edu.grupoi.backend.desappbackend.model.project;

import java.time.LocalDate;

public class Donation {
	
	private LocalDate date;
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

	public void setPoints(Integer points) {
		this.points = points;
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
		if(this.project.getLocation().getPopulation() < 2000) {
			return this.amount * 2;
		}
		return 0;
	}

	private Integer bonusMoney() {
		if(this.amount >= 1000) {
			return this.amount;
		}
		return 0;
	}
	
}
