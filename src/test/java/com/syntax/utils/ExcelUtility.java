package com.syntax.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	/*
	 * 1. Create an object of Workbook 2. Create an object Sheet 3. Write a logic to
	 * read excel file by using FileIputStream 4. Find the number of rows 5. Find
	 * the number of columns 6. Write a logic to access and read cell 7. Write a
	 * logic to save information as Object[][], List<Map>, List<List>
	 */

	private static Workbook wBook;
	private static Sheet sheet;

	public static void openExcel(String filePath, String sheetName) {

		try {
			FileInputStream fis = new FileInputStream(filePath);
			wBook = new XSSFWorkbook(fis);
			sheet = wBook.getSheet(sheetName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public static int colCount() {
		return sheet.getRow(0).getLastCellNum();
	}

	public static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}

	public static Object[][] excelIntoArray(String filePath, String sheetName) {
		openExcel(filePath, sheetName);

		Object[][] data = new Object[rowCount() - 1][colCount()];

		for (int i = 1; i < rowCount(); i++) {
			for (int j = 0; j < colCount(); j++) {
				data[i - 1][j] = cellData(i, j);
			}
		}
		return data;
	}

	public static List<Map<String, String>> excelIntoListOfMaps(String filePath, String sheetName) {
		openExcel(filePath, sheetName);

		List<Map<String, String>> data = new ArrayList<>();

		for (int i = 1; i < rowCount(); i++) {
			Map<String, String> map = new HashMap<String, String>();
			for (int j = 0; j < colCount(); j++) {
				map.put(cellData(0, j), cellData(i, j));
			}
			data.add(map);
		}
		return data;
	}

}
