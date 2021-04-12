package com.adamsimon.bosch.feladat1.dtos;


public class ListElementDto {
	private Integer id;
	private String owner;
	private String car;
	private Boolean guaranteed;
	private String age;
	private String serviceStart;
	
	public ListElementDto() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public Boolean getGuaranteed() {
		return guaranteed;
	}

	public void setGuaranteed(Boolean guaranteed) {
		this.guaranteed = guaranteed;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getServiceStart() {
		return serviceStart;
	}

	public void setServiceStart(String serviceStart) {
		this.serviceStart = serviceStart;
	}
	
	
}
