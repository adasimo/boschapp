package com.adamsimon.bosch.feladat1.enums;

import com.adamsimon.bosch.feladat1.converters.AdditionFormToSzervizkonyv;
import com.adamsimon.bosch.feladat1.converters.ObjListToSourceElementDto;
import com.adamsimon.bosch.feladat1.dtos.ListElementDto;

public enum ConversionTypesEnum {
	ADDITION_FORM_TO_SERVICEBOOK(AdditionFormToSzervizkonyv.class.getCanonicalName()),
	OBJ_ARRAY_TO_LIST_ELEMENT_DTO(ObjListToSourceElementDto.class.getCanonicalName());
		
	private String type;
	
	private ConversionTypesEnum(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
}
