package com.adamsimon.bosch.feladat1.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.adamsimon.bosch.feladat1.dtos.ListElementDto;
import com.adamsimon.bosch.feladat1.interfaces.ListControllerI;
import com.adamsimon.bosch.feladat1.interfaces.ListingServiceI;

@Controller
@RequestMapping(value = "/list", produces = "application/json;charset=UTF-8")
public class ListController implements ListControllerI {

	@Autowired
	private ListingServiceI listService;
	
	
	@Override
	@GetMapping("/")
	 public String getList(@RequestParam(value = "pageNumber", required = false, defaultValue = "1") int pageNumber,
	            @RequestParam(value = "size", required = false, defaultValue = "10") int size, Model model) {
		
	    model.addAttribute("activeServices", listService.getActiveServiceBooksPage(pageNumber, size));
		return "feladat1/list.html";
	}
	
	@Override
	@DeleteMapping("/del/{id}")
	public ResponseEntity deleteService(@PathVariable Integer id, @RequestParam("pageNumber") Integer pageNumber) {
		
		ListElementDto dto = listService.deleteService(id, pageNumber, 10);
		return ResponseEntity.ok().body(dto);
	}

}
