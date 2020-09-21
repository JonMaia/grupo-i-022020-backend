package ar.edu.grupoi.backend.desappbackend.model.project;

public class Location {

	private final String name;
	private final String province;
	private final int population;
	private final boolean state;

	public Location(String name, String province, int population, boolean state) {
		this.name       = name;
		this.province   = province;
		this.population = population;
		this.state      = state;
	}

	public String getName() { return name; }

	public String getProvince() { return province; }

	public int getPopulation() { return population; }

	public boolean getState() { return state; }

}
