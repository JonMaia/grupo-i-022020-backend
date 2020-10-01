package ar.edu.grupoi.backend.desappbackend.service.builder;

import ar.edu.grupoi.backend.desappbackend.model.project.Location;

public class LocationBuilder {

	private String name;
	private String province;
	private int population;
	private boolean state;

	public static LocationBuilder withName(String name) {
		LocationBuilder builder = new LocationBuilder();
		builder.name = name;
		return builder;
	}

	public Location builder() {
		return new Location(name, province, population, state);
	}

	public LocationBuilder whitProvince(String province) {
		this.province = province;
		return this;
	}

	public LocationBuilder whitPopulation(int population) {
		this.population = population;
		return this;
	}

	public LocationBuilder withState(boolean state) {
		this.state = state;
		return this;
	}
}
