package com.adamsimon.bosch.feladat1.interfaces;

import java.util.List;

import com.adamsimon.bosch.feladat1.domains.Szervizkonyv;
import com.adamsimon.bosch.feladat1.dtos.ListElementDto;
import com.adamsimon.bosch.feladat1.forms.AdditionForm;

public interface AdditionServiceI {
	public AdditionForm fillAdditionForm();
	public AdditionForm fillAdditionForm(AdditionForm form);
	public void saveServiceBook(Szervizkonyv sz);
}
