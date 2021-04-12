package com.adamsimon.bosch.feladat2.domains;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table(name = "user_car")
public class UserCar {

	@EmbeddedId
	UserCarKey id = new UserCarKey();

	@ManyToOne
	@MapsId("user")
	@JoinColumn(name = "user")
	User user;

	@ManyToOne
	@MapsId("car")
	@JoinColumn(name = "car")
	Car car;

	public UserCarKey getId() {
		return id;
	}

	public void setId(UserCarKey id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	
	 
}
