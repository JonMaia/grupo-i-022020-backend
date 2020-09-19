package ar.edu.grupoi.backend.desappbackend.model.project;

import java.time.LocalDate;
import java.util.List;
import ar.edu.grupoi.backend.desappbackend.model.user.Donor;

public class Project {

	private final String name;
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

	public List<Donor> getDonors() {
		// Pasarlo a System
		// TODO Auto-generated method stub
		return null;
	}

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

	public void changeEndDate(LocalDate newEndDate) { endDate = newEndDate; }

	public double getFactor() { return factor; }

	public void changeFactor(double newFactor) { factor = newFactor; }

	public LocalDate getInitialDate() { return initialDate; }

	public double getPercentage() { return percentage; }
}
