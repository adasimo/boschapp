package com.adamsimon.bosch.feladat1.enums;

import java.util.Arrays;
import java.util.Set;

public enum CarAgeEnum {
	
	NULLFIVE("0-5"),
	FIVETEN("5-10"),
	TENPLUS("10+");
	
	private String age;
	
	private CarAgeEnum(String age) {
		this.age = age;
	}
	public String getAge() {
		return age;
	}
	
}
