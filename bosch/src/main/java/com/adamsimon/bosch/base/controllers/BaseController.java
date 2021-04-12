package com.adamsimon.bosch.base.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adamsimon.bosch.base.interfaces.BaseControllerI;

@Controller
@RequestMapping(value = "/", produces = "application/json;charset=UTF-8")
public class BaseController implements BaseControllerI{

	
	@Override
	@GetMapping("/")
	public String getBase() {

		return "base/base.html";
	}
}
