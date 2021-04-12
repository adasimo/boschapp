package com.adamsimon.bosch.feladat2.services;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.adamsimon.bosch.feladat2.interfaces.ReadWriteServiceI;
import com.adamsimon.bosch.feladat2.repositories.UserWithCarRepository;

@Service
public class ReadWriteService implements ReadWriteServiceI {

	private Integer[] intArray = new Integer[50];
	
	@Autowired
	private UserWithCarRepository userWithCarRepository;
	
	
	public ReadWriteService() {
		for (int i = 0; i < intArray.length; i++) {
			intArray[i] = i + 1;
		}
	}
	@Override
	public boolean doReadWrite() {
		List<Integer> intList = Arrays.asList(intArray);
		
		Collections.shuffle(intList);
		intList = intList.subList(0, 9);
	    
	    List<Integer> idList = this.openAFileToIdList("static/olvass.txt", "\n", "|", intList);
	    
	    
	    List<Object[]> objList = this.userWithCarRepository.getUserCarForUserIds(idList);
	    
		return writeToFile(objList);
		
	}
	
	private boolean writeToFile(List<Object[]> list) {
		final String COLUMN_DELIMITER = "\t";
		final String ROW_DELIMITER = "\n";
		final String HEADER = String.format("%s%s%s%s%s%s", "tulajdonos", COLUMN_DELIMITER, "márka", COLUMN_DELIMITER, "típus", ROW_DELIMITER);
		
		StringBuilder sb = new StringBuilder(HEADER);
		for (Object[] o : list) {
			sb.append(String.valueOf(o[0]))
				.append(COLUMN_DELIMITER)
				.append(String.valueOf(o[1]))
				.append(COLUMN_DELIMITER)
				.append(String.valueOf(o[2]))
				.append(ROW_DELIMITER);
		}
		
				
		try {
			File resource = new File("FELADAT2MEGOLDAS.txt");
			resource.delete();
			Files.write(resource.toPath(), sb.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private List<Integer> openAFileToIdList(String fileName, String lineDelimiter, String cellDelimiter, List<Integer> keys) {
		
		List<Integer> returnList = new ArrayList<>();
		byte[] existingData = null;
		
		try {
			File resource = new ClassPathResource(fileName).getFile();
			existingData = Files.readAllBytes(resource.toPath());
			List<byte[]> existingList = split(lineDelimiter.getBytes(StandardCharsets.UTF_8), existingData);

			for (byte[] bl : existingList) {
				List<byte[]> existingListRow = split(cellDelimiter.getBytes(StandardCharsets.UTF_8), bl);
			
				if (existingListRow != null && existingListRow.size() > 1) {
					String trimmed0 = new String(existingListRow.get(0), StandardCharsets.UTF_8).trim();
					String trimmed1 = new String(existingListRow.get(1), StandardCharsets.UTF_8).trim();
					
					if (trimmed0 != null && trimmed1 != null) {

						if (trimmed0 != null && trimmed1 != null &&
								trimmed0.matches("[0-9]+") && trimmed1.matches("[0-9]+")) {
						
							Integer key = Integer.parseInt(trimmed0);
							Integer value = Integer.parseInt(trimmed1);
													
							if (keys.contains(key) && value > 0) {
							
								returnList.add(value);
							}
							
						}
					}
				}
			}
			return returnList;
		} catch (Exception e1) {
			 e1.printStackTrace();
			 return returnList;
		}
	    
	}

	private List<byte[]> split(byte[] pattern, byte[] input) {
	    List<byte[]> l = new LinkedList<byte[]>();
	    int blockStart = 0;
	    for(int i = 0; i < input.length; i++) {
	       if(isMatch(pattern, input, i)) {
	          l.add(Arrays.copyOfRange(input, blockStart, i));
	          blockStart = i+pattern.length;
	          i = blockStart;
	       }
	    }
	    l.add(Arrays.copyOfRange(input, blockStart, input.length ));
	    return l;
	}
	
	private boolean isMatch(byte[] pattern, byte[] input, int pos) {
        for(int i = 0; i< pattern.length; i++) {
            if(pattern[i] != input[pos+i]) {
                return false;
            }
        }
        return true;
    }
	
}
