package com.syntax.practice;

import java.util.List;
import java.util.Map;

import com.syntax.utils.ExcelUtility;

public class TestExcelUtil {
	public static void main(String[] args) {
		String filePath = System.getProperty("user.dir") + "/src/test/resources/testData/TestData.xlsx";
//		ExcelUtility.openExcel(filePath, "addEmp");
//		
//		int rowCount=ExcelUtility.rowCount();
//		System.out.println("Number of rows: "+rowCount);
//		
//		System.out.println("Number of Columns: "+ExcelUtility.colCount());

//		Object[][] data = ExcelUtility.excelIntoArray(filePath, "addEmp");
//		
//		
//		for(Object[] row:data) {
//			for(Object cell:row) {
//				System.out.print(cell+ " ");
//			}
//			System.out.println();
//		}

		List<Map<String, String>> data = ExcelUtility.excelIntoListOfMaps(filePath, "addEmp");
		
		for (Map<String, String> map : data) {
			String name=map.get("name");			
			String lastname=map.get("lastname");
			String middleName=map.get("middleName");
			
			System.out.println(name + " "+middleName+ " "+ lastname);
			
			System.out.println(map.get("username")+ " "+map.get("password"));

			
		}

	}

}
