package com.adamsimon.bosch.feladat1.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adamsimon.bosch.feladat1.enums.CarAgeEnum;
import com.adamsimon.bosch.feladat1.forms.AdditionForm;
import com.adamsimon.bosch.feladat1.interfaces.ConfigMockServiceI;

@Service
public class ConfigMockService implements ConfigMockServiceI{
	
	/**********************************************************************************************************/
	/**********************************************************************************************************/
	/******** Ez egy mock service, az időigény rövidítésére a valóságban ezek adatbázisból jönnének ***********/
	/**********************************************************************************************************/
	/**********************************************************************************************************/
	
	private static final String[] VEHICLES_FROM_CONFIG = {"Ford Mondeo", "Skoda Octavia", "Kia Ceed"};
		
	
	@Override
	public void setAutoTypes(AdditionForm form) {
		form.setCarList(Arrays.asList(VEHICLES_FROM_CONFIG));
		form.setAgeList(Arrays.asList(CarAgeEnum.values()));
	}

}
