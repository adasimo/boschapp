package com.adamsimon.bosch.feladat1.converters;

import com.adamsimon.bosch.feladat1.enums.ConversionTypesEnum;

public class ConverterFactory {

	public ConverterFactory() {}
	
	public static AbstractConverter getConverter(ConversionTypesEnum c) {
		String type = c.getType();
		try {
			return (AbstractConverter) Class.forName(type).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			// TODO SOME LOGGING HERE
			e.printStackTrace();
			return null;
		}
	}
}
