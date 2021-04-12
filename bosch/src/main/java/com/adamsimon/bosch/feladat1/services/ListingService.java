package com.adamsimon.bosch.feladat1.services;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import com.adamsimon.bosch.feladat1.converters.AbstractConverter;
import com.adamsimon.bosch.feladat1.converters.ConverterFactory;
import com.adamsimon.bosch.feladat1.dtos.ListElementDto;
import com.adamsimon.bosch.feladat1.enums.ConversionTypesEnum;
import com.adamsimon.bosch.feladat1.interfaces.ListingServiceI;

import com.adamsimon.bosch.feladat1.paging.Paging;
import com.adamsimon.bosch.feladat1.paging.Page;
import com.adamsimon.bosch.feladat1.paging.Paged;
import com.adamsimon.bosch.feladat1.repositories.ServiceBookRepository;

@Service
public class ListingService implements ListingServiceI{

	private static final Comparator<ListElementDto> EMPTY_COMPARATOR = (e1, e2) -> 0;
	
	@Autowired
	private ServiceBookRepository serviceBookRepository;
	
	
	@SuppressWarnings("unchecked")
	private List<ListElementDto> getActiveServiceBooks() {
		List<Object[]> objList = this.serviceBookRepository.getActiveServices();
		AbstractConverter c = ConverterFactory.getConverter(ConversionTypesEnum.OBJ_ARRAY_TO_LIST_ELEMENT_DTO);
		return (List<ListElementDto>) c.convert(objList);
	}
	
	@Override
	public Paged<ListElementDto> getActiveServiceBooksPage(int pageNumber, int size) {
		
		List<ListElementDto> dtoList = this.getActiveServiceBooks();

		List<ListElementDto> paged = dtoList.stream()
                .skip((pageNumber - 1) * size)
                .limit(size)
                .collect(Collectors.toList());

		Double totalPages = Double.parseDouble(dtoList.size() + "") / Double.parseDouble(size + "");
		return new Paged<>(new Page<>(paged, Double.valueOf(Math.ceil(totalPages)).intValue()),
				Paging.of(Double.valueOf(Math.ceil(totalPages)).intValue(), pageNumber, size));
		
	}
	
	@Override
	public ListElementDto deleteService(Integer id, Integer pageNumber, Integer size) {
		List<ListElementDto> dtoList = this.getActiveServiceBooks();
		
		ListElementDto returnDto = null;
		if (dtoList.size() > pageNumber * size) {
			returnDto = dtoList.get(pageNumber * size);
		}
		
		this.serviceBookRepository.deleteService(id, LocalDateTime.now());
		return returnDto;
	}


	
}
