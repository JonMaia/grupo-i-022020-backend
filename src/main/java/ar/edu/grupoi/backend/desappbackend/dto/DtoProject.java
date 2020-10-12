package ar.edu.grupoi.backend.desappbackend.dto;

import java.time.LocalDate;

public class DtoProject {

	private Integer idAdmin;
	private Integer idLocation;
	private String name;
	private double minPercentage;
	private LocalDate endDate;
	private Double factor;
	private String locationName;
	private Integer idProject;

	public Integer getIdAdmin() {
		return idAdmin;
	}

	public Integer getIdLocation() {
		return idLocation;
	}

	public String getName() {
		return name;
	}

	public double getMinPercentage() {
		return minPercentage;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public Double getFactor() {
		return factor;
	}

	public String getNameLocation() {
		return locationName;
	}

	public void setNameLocation(String name) {
		this.locationName = name;
	}

	public Integer getIdProject() {
		return idProject;
	}

	public void setIdProject(Integer id) {
		this.idProject = id;
	}

}
