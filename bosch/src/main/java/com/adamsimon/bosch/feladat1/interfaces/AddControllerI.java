package com.adamsimon.bosch.feladat1.interfaces;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import com.adamsimon.bosch.feladat1.forms.AdditionForm;

public interface AddControllerI {

	public String getAdd(Model model);
	public String saveAddition(AdditionForm additionForm, BindingResult bindingResult, Model model);
}
