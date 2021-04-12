package com.adamsimon.bosch.feladat3.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.adamsimon.bosch.feladat3.interfaces.SqlQueryControllerI;

@Controller
@RequestMapping(value = "/sqls", produces = "application/json;charset=UTF-8")
public class SqlQueryController implements SqlQueryControllerI {

	@Override
	@GetMapping("/")
	public String getSqls() {
		
		return "feladat3/sqls.html";
	}
}
