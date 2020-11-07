package ar.edu.grupoi.backend.desappbackend.model.project;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Donation {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private LocalDate date;
	@NotNull(message = "Amount is mandatory")
	@Min(1)
	private Integer amount;
	@OneToOne
	private Project project;
	@NotBlank(message = "Nickname is mandatory")
	private String nickname;
	private Integer points;
	private String comment;
	
	public Donation() {}
	
	public Donation(LocalDate date, Integer amount, Project project, String nickname, String comment) {
		this.date = date;
		this.amount = amount;
		this.project = project;
		this.nickname = nickname;
		this.comment = comment;
		this.points = 0;
	}

	public Integer getId() {
		return id;
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
