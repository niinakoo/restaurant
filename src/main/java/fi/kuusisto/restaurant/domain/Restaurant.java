package fi.kuusisto.restaurant.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Restaurant {
	
	@Id													// Uniikki id
	@GeneratedValue(strategy=GenerationType.AUTO) 		// Tietokanta luo automaattisesti id:n
	private long id;
	private String name, address, phone;
	
	
	public Restaurant() {
		super();
	}

	public Restaurant(String name, String address, String phone) {
		super();
		this.name = name;
		this.address = address;
		this.phone = phone;
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

}