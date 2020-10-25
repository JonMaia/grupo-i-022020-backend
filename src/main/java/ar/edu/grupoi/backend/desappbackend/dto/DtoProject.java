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
	private String locationProvince;
	private int locationPopulation;
	private boolean locationState;
	private Integer cantDonations;
	
	public Integer getIdAdmin() {
		return idAdmin;
	}
	public void setIdAdmin(Integer idAdmin) {
		this.idAdmin = idAdmin;
	}
	public Integer getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(Integer idLocation) {
		this.idLocation = idLocation;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMinPercentage() {
		return minPercentage;
	}
	public void setMinPercentage(double minPercentage) {
		this.minPercentage = minPercentage;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Double getFactor() {
		return factor;
	}
	public void setFactor(Double factor) {
		this.factor = factor;
	}
	public String getLocationName() {
		return locationName;
	}
	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}
	public Integer getIdProject() {
		return idProject;
	}
	public void setIdProject(Integer idProject) {
		this.idProject = idProject;
	}
	public String getLocationProvince() {
		return locationProvince;
	}
	public void setLocationProvince(String locationProvince) {
		this.locationProvince = locationProvince;
	}
	public int getLocationPopulation() {
		return locationPopulation;
	}
	public void setLocationPopulation(int locationPopulation) {
		this.locationPopulation = locationPopulation;
	}
	public boolean isLocationState() {
		return locationState;
	}
	public void setLocationState(boolean locationState) {
		this.locationState = locationState;
	}

	public void setCantDonations(Integer cantDonations) {
		this.cantDonations = cantDonations;
	}
	
	public Integer getCantDonations() {
		return cantDonations;
	}

}
