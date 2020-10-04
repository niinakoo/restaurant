package fi.kuusisto.restaurant.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cuisine {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long cuisineid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cuisine")
	private List<Restaurant> restaurants;

	public Cuisine() {
		super();
	}

	public Cuisine(String name) {
		super();
		this.name = name;
	}

	public long getCuisineid() {
		return cuisineid;
	}

	public void setCuisineid(long cuisineid) {
		this.cuisineid = cuisineid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	@Override
	public String toString() {
		return "Cuisine [cuisineid=" + cuisineid + ", name=" + name + "]";
	}
	
}

	