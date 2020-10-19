package ar.edu.grupoi.backend.desappbackend.model.project;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Location {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@NotBlank(message = "Name is mandatory")
	private String name;
	@NotBlank(message = "Province is mandatory")
	private String province;
	@NotNull(message = "Population is mandatory")
	@Min(1000)
	private int population;
	private boolean state;

	public Location() {}
	
	public Location(String name, String province, int population, boolean state) {
		this.name       = name;
		this.province   = province;
		this.population = population;
		this.state      = state;
	}

	public Integer getId() {return id; }
	
	public String getName() { return name; }

	public String getProvince() { return province; }

	public int getPopulation() { return population; }

	public boolean getState() { return state; }

	public void setName(String name) {
		this.name = name;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public void setPopulation(int population) {
		this.population = population;
	}

	public void setState(boolean state) {
		this.state = state;
	}

}
