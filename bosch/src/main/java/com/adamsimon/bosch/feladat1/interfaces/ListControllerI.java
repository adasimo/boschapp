package com.adamsimon.bosch.feladat1.interfaces;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;


public interface ListControllerI {

	public String getList(int pageNumber, int size, Model model);
	public ResponseEntity deleteService(Integer id, Integer pageNumber);
}
