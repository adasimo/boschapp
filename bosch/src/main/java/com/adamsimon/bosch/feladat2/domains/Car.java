package com.adamsimon.bosch.feladat2.domains;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "car")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, length = 10)
	private Integer id;
	
	@Column(name = "brand", length = 45)
	private String brand;
	
	@Column(name = "model", length = 45)
	private String model;

	@OneToMany(mappedBy = "car", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<UserCar> users = new ArrayList<>();

	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public List<UserCar> getUsers() {
		return users;
	}

	public void setUsers(List<UserCar> users) {
		this.users = users;
	}
	
	
	
}
