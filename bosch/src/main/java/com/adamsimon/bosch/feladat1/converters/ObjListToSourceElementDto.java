package com.adamsimon.bosch.feladat1.converters;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.adamsimon.bosch.feladat1.dtos.ListElementDto;

@Component
public class ObjListToSourceElementDto extends AbstractConverter {
	
	@SuppressWarnings("unchecked")
	@Override
	public Object convert(Object oh) {
		if (oh == null) {
			return new ArrayList<ListElementDto>();
		}
		List<Object[]> objList = (List<Object[]>) oh; 
		
		if (objList.size() == 0) {
			return new ArrayList<ListElementDto>();
		}
		List<ListElementDto> dtoList = new ArrayList<>();
		
		for (Object[] o : objList) {
			ListElementDto dto = new ListElementDto();
			dto.setId(Integer.parseInt(String.valueOf(o[0])));
			dto.setOwner(String.valueOf(o[1]));
			dto.setCar(String.valueOf(o[2]));
			dto.setGuaranteed(Boolean.parseBoolean(String.valueOf(o[3])));
			dto.setAge(String.valueOf(o[4]));
			String rawDateString =String.valueOf(o[5]);
			String[] strs = rawDateString.split("T");
			String[] strs2 = strs[1].split("\\.");
			dto.setServiceStart(String.format("%s%s%s", strs[0], " ", strs2[0]));
			dtoList.add(dto);
		}
		
		 return dtoList;
		
	}

}
