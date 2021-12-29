package com.util;
import java.util.*;

public class LengthConverter {
	
	private static double  getMM(double len,String unit) {
		float res=0;
		System.out.println("yess next is this");
		switch (unit) {
		case "mm": return len; 
		case "cm": return 10d*len; 
		case "m": return 1000d*len;
		case "km": return 1000000d*len;
		}
		return res;
	}
	public static  Map<String,Double> convert(double len,String unit){
		/*
		 * 	input="12 cm" ->len=12 unit="cm"
		 * 
		 * */
		Map<String,Double> map=new HashMap<>();
		double mm=getMM(len, unit);
		map.put("mm",mm);
		map.put("cm",mm/10d);
		map.put("m",mm/1000d);
		map.put("km",mm/1000000d);
		return map;
	}
}

