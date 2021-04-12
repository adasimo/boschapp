package com.adamsimon.bosch.feladat1.interfaces;

import java.util.List;

import com.adamsimon.bosch.feladat1.dtos.ListElementDto;
import com.adamsimon.bosch.feladat1.paging.Page;
import com.adamsimon.bosch.feladat1.paging.Paged;


public interface ListingServiceI {
	
	public Paged<ListElementDto> getActiveServiceBooksPage(int pageNumber, int size);
	public ListElementDto deleteService(Integer id, Integer pageNumber, Integer size);
	
}
