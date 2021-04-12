package com.adamsimon.bosch.feladat1.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adamsimon.bosch.feladat1.converters.AbstractConverter;
import com.adamsimon.bosch.feladat1.converters.AdditionFormToSzervizkonyv;
import com.adamsimon.bosch.feladat1.converters.ConverterFactory;
import com.adamsimon.bosch.feladat1.domains.Szervizkonyv;
import com.adamsimon.bosch.feladat1.enums.ConversionTypesEnum;
import com.adamsimon.bosch.feladat1.forms.AdditionForm;
import com.adamsimon.bosch.feladat1.interfaces.AddControllerI;
import com.adamsimon.bosch.feladat1.interfaces.AdditionServiceI;


@Controller
@RequestMapping(value = "/add", produces = "application/json;charset=UTF-8")
public class AddController implements AddControllerI {
	
	@Autowired
	private AdditionServiceI additionService;
	
	@Override
	@GetMapping("/")
	public String getAdd(Model model) {

		model.addAttribute("additionForm", this.additionService.fillAdditionForm());
		return "feladat1/add.html";
	}
	
	@Override
	@PostMapping("/save")
	public String saveAddition(@Valid @ModelAttribute("additionForm") AdditionForm additionForm, BindingResult bindingResult, Model model) {
		
		if (bindingResult.hasErrors()) {
			
			model.addAttribute("additionForm", this.additionService.fillAdditionForm(additionForm));
		} else {
			
			AbstractConverter c = ConverterFactory.getConverter(ConversionTypesEnum.ADDITION_FORM_TO_SERVICEBOOK);
			this.additionService.saveServiceBook((Szervizkonyv) c.convert(additionForm));
			model.addAttribute("additionForm", this.additionService.fillAdditionForm());
			model.addAttribute("success", true);
		}

		
		return "feladat1/add.html";
	}
}
