package ar.edu.grupoi.backend.desappbackend.service.builder;

import java.time.LocalDate;

import ar.edu.grupoi.backend.desappbackend.model.project.Location;
import ar.edu.grupoi.backend.desappbackend.model.project.Project;

public class ProjectBuilder {

	private String name;
	private double minPercentage;
	private LocalDate initialDate;
	private LocalDate endDate;
	private Location location;
	private double factor;

	public static ProjectBuilder withName(String name) {
		ProjectBuilder builder = new ProjectBuilder();
		builder.name = name;
		return builder;
	}

	public Project builder() {
		return new Project(name, endDate, location, minPercentage, factor);
	}

	public ProjectBuilder whitMinPercentage(double minPercentage) {
		this.minPercentage = minPercentage;
		return this;
	}

	public ProjectBuilder withInitialDate(LocalDate initialDate) {
		this.initialDate = initialDate;
		return this;
	}

	public ProjectBuilder withEndDate(LocalDate endDate) {
		this.endDate = endDate;
		return this;
	}

	public ProjectBuilder withLocation(Location location) {
		this.location = location;
		return this;
	}

	public ProjectBuilder withFactor(double factor) {
		this.factor = factor;
		return this;
	}
}
