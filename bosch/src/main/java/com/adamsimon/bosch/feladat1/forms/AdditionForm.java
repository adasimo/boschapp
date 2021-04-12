package com.adamsimon.bosch.feladat1.forms;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.adamsimon.bosch.feladat1.enums.CarAgeEnum;

import javax.validation.constraints.*;


public class AdditionForm {

	@NotBlank(message = "feladat1.error.owner-empty")
	@Size(max=50, message = "feladat1.error.owner-max")
	private String owner;
	
	@NotBlank(message = "feladat1.error.car-empty")
	private String car;
	private List<String> carList;
	private List<CarAgeEnum> ageList;
	@NotNull(message = "feladat1.error.guaranteed-empty")
	private Boolean guaranteed;
	@NotNull(message = "feladat1.error.age-empty")
	private CarAgeEnum age;
	@NotNull(message = "feladat1.error.serviceStart-empty")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
	private LocalDateTime serviceStart;
	
	public AdditionForm() {}
	
	public AdditionForm(String owner, String car, List<String> carList, List<CarAgeEnum> ageList, Boolean guaranteed, CarAgeEnum age, LocalDateTime serviceStart) {
		super();
		this.owner = owner;
		this.car = car;
		this.carList = carList;
		this.ageList = ageList;
		this.guaranteed = guaranteed;
		this.age = age;
		this.serviceStart = serviceStart;
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
	
	public List<String> getCarList() {
		return List.copyOf(carList);
	}

	public void setCarList(List<String> carList) {
		this.carList = carList;
	}
	
	public List<CarAgeEnum> getAgeList() {
		return List.copyOf(ageList);
	}

	public void setAgeList(List<CarAgeEnum> ageList) {
		this.ageList = ageList;
	}

	public void addToCarList(String car) {
		this.carList.add(car);
	}
	
	public void removeFromCarList(String car) {
		this.carList.remove(car);
	}
	
	public void addToAgeList(CarAgeEnum age) {
		this.ageList.add(age);
	}
	
	public void removeFromAgeList(CarAgeEnum age) {
		this.ageList.remove(age);
	}
	
	public Boolean getGuaranteed() {
		return guaranteed;
	}

	public void setGuaranteed(Boolean guaranteed) {
		this.guaranteed = guaranteed;
	}

	public CarAgeEnum getAge() {
		return age;
	}

	public void setAge(CarAgeEnum age) {
		this.age = age;
	}

	public LocalDateTime getServiceStart() {
		return serviceStart;
	}

	public void setServiceStart(LocalDateTime serviceStart) {
		this.serviceStart = serviceStart;
	}

	@Override
	public String toString() {
		return "AdditionForm [owner=" + owner + ", car=" + car + ", guaranteed=" + guaranteed + ", age=" + age
				+ ", serviceStart=" + serviceStart + "]";
	}
	
	
	
}
