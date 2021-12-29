package com.main;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.util.database.DatabaseUtil;

import com.util.LengthConverter;

public class Application {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		while (true) {
			System.out.println("-----------------------------------");
			System.out.println("1.Convert");
			System.out.println("2.show top 10 records");
			System.out.println("3.exit");
			System.out.println("-----------------------------------");
			System.out.println("Enter your option:");
			String opt=scan.nextLine();
			switch (opt) {
					case "1": 
						System.out.println("Enter unit");
						String unit=scan.nextLine();
						
						System.out.println("Enter Length");
						double length=Double.parseDouble(scan.nextLine());
						boolean inserted=DatabaseUtil.saveResult(LengthConverter.convert(length, unit), String.valueOf(length)+" "+unit);
						if(inserted){
							System.out.println("Data inserte Successfuly");
						}
						else{
							System.out.println("ERROR");
						}
						break;
					case "2":
						List<Map<String, Object>> tenResults = DatabaseUtil.getTenResults();
						for(Map<String, Object> record:tenResults){
							System.out.println(record);
						}
						break;
					case "3": System.exit(0);
						break ;
					default:
						System.out.println("Invalid input");
			}
			
		}
	}
}
