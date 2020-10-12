package fi.kuusisto.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Restaurant {
	
	@Id													// Uniikki id
	@GeneratedValue(strategy=GenerationType.AUTO)		// Tietokanta luo automaattisesti id:n
	private long id;
	private String name, address, phone;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "cuisineid")
	private Cuisine cuisine;
	
	
	public Restaurant() {
		super();
	}

	public Restaurant(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public Restaurant(String name, String address, String phone, Cuisine cuisine) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.cuisine = cuisine;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", name=" + name + ", address=" + address + ", phone=" + phone + ", cuisine="
				+ cuisine + "]";
	}

}