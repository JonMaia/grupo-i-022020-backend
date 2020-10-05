package ar.edu.grupoi.backend.desappbackend.dto;

import java.time.LocalDate;

public class DtoProject {

	private Integer adminId;
	private Integer locationId;
	private String name;
	private double minPercentage;
	private LocalDate endDate;
	private Double factor;
	private String locationName;
	private Integer projectId;

	public Integer getAdminId() {
		return adminId;
	}

	public Integer getLocationId() {
		return locationId;
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

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer id) {
		this.projectId = id;
	}

}
