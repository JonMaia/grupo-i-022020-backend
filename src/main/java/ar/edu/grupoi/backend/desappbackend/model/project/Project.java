package ar.edu.grupoi.backend.desappbackend.model.project;

import java.time.LocalDate;

public class Project {

	private final String name; // El nombre del proyecto es único en el sistema.
	private double minPercentage;
	private double percentage = 0;
	private double collection = 0;
	private boolean active = true;
	private final LocalDate initialDate;
	private LocalDate endDate;
	private final Location location;
	private double factor;

	public Project(String name, LocalDate endDate, Location location, Double minPercentage, Double factor) {
		this.name          = name;
		this.minPercentage = minPercentage != null ? minPercentage : 50;
		this.endDate       = endDate;
		this.location      = location;
		this.factor        = factor != null ? factor : 1000;
		this.initialDate   = LocalDate.now();
	}

	public Location getLocation() { return location; }

	public String getName() { return name; }

	public double getCumulativePercentage() { return percentage; }

	public double getCollection() { return collection; }

	public void updateCollection(double newCollection) {
		collection += newCollection;
		percentage += (newCollection * minPercentage) / moneyRequired();
	}

	public double moneyRequired() { return location.getPopulation() * factor; }

	public boolean getActive() { return active; }

	public void closedProject() { active = false; }

	public double getMinPercentage() { return minPercentage; }

	public void modifyMinPercentage(double newMinPercentage) {
		if (newMinPercentage < 50.0 || newMinPercentage > 100) {
			throw new IllegalArgumentException("The min percentage value should be within 50 and 100");
		} else {
			minPercentage = newMinPercentage;
		}
	}

	public LocalDate getEndDate() { return endDate;	}

	public void changeEndDate(LocalDate newEndDate) {
		if (newEndDate.isAfter(initialDate) && newEndDate.isAfter(LocalDate.now())) {
			endDate = newEndDate;
		} else {
			throw new IllegalArgumentException("Date used is not allowed, please try another date");
		}
	}

	public double getFactor() { return factor; }

	public void changeFactor(double newFactor) {
		if (newFactor <= 0 || newFactor > 100000) {
			throw new IllegalArgumentException("The factor must be greater than 0 and less than 100000");
		} else {
			factor = newFactor;
		}
	}

	public LocalDate getInitialDate() { return initialDate; }

	public double getPercentage() { return percentage; }

	public boolean compledCollection() {
		return requeridPercentage() >= getCumulativePercentage();
	}

	private double requeridPercentage() {
		return (getCollection()*100) / moneyRequired();
	}
}
