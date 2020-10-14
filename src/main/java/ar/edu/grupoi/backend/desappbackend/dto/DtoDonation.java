package ar.edu.grupoi.backend.desappbackend.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DtoDonation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer idDonor;
	private Integer idProject;
	private String nameProject;
	private Integer amount;
	private String comment;
	private Integer points;

	public DtoDonation() {}

	public DtoDonation(Integer idDonor, Integer idProject, String nameProject, Integer amount, String comment) {
		this.idDonor = idDonor;
		this.idProject = idProject;
		this.nameProject = nameProject;
		this.amount = amount;
		this.comment = comment;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdDonor() {
		return idDonor;
	}

	public void setIdDonor(Integer idDonor) {
		this.idDonor = idDonor;
	}

	public Integer getIdProject() {
		return idProject;
	}

	public void setIdProject(Integer idProject) {
		this.idProject = idProject;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	};

}
