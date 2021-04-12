package com.adamsimon.bosch.feladat1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adamsimon.bosch.feladat1.converters.AbstractConverter;
import com.adamsimon.bosch.feladat1.converters.ConverterFactory;
import com.adamsimon.bosch.feladat1.domains.Szervizkonyv;
import com.adamsimon.bosch.feladat1.dtos.ListElementDto;
import com.adamsimon.bosch.feladat1.enums.ConversionTypesEnum;
import com.adamsimon.bosch.feladat1.forms.AdditionForm;
import com.adamsimon.bosch.feladat1.interfaces.AdditionServiceI;
import com.adamsimon.bosch.feladat1.interfaces.ConfigMockServiceI;
import com.adamsimon.bosch.feladat1.repositories.ServiceBookRepository;

@Service
public class AdditionService implements AdditionServiceI {

	@Autowired
	private ConfigMockServiceI configMockService;

	@Autowired
	private ServiceBookRepository serviceBookRepository;
	
	@Override
	public AdditionForm fillAdditionForm() {
		AdditionForm form = new AdditionForm();
		this.configMockService.setAutoTypes(form);
		return form;
	}
	
	@Override
	public AdditionForm fillAdditionForm(AdditionForm form) {
		this.configMockService.setAutoTypes(form);
		return form;
	}

	@Override
	public void saveServiceBook(Szervizkonyv sz) {
		this.serviceBookRepository.save(sz);
	}

}
