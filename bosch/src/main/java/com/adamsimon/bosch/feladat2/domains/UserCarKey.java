package com.adamsimon.bosch.feladat2.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserCarKey implements Serializable {

	@Column(name = "user", nullable = false, length = 10)
	Integer user;
	
	@Column(name = "car", nullable = false, length = 10)
	Integer car;

	public Integer getUser() {
		return user;
	}
	
	public void setUser(Integer user) {
		this.user = user;
	}
	
	public Integer getCar() {
		return car;
	}
	
	public void setCar(Integer car) {
		this.car = car;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((car == null) ? 0 : car.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserCarKey other = (UserCarKey) obj;
		if (car == null) {
			if (other.car != null)
				return false;
		} else if (!car.equals(other.car))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}
 
  
}

