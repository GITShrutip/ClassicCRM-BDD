package com.classicCRM.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {

	public static List<HashMap<String, String>> getExcelData_HashMap(String fileName) throws IOException {

		// D:\\SeleniumWorkspace\\BasicsPractice\\src\\test\\java\\ExcelReadWriteOperationsPractice\\Data.xlsx
		// filename =Data
		FileInputStream fin = new FileInputStream(
				new File(System.getProperty("user.dir") + "\\TestDataFiles\\" + fileName + ".xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(fin);

		XSSFSheet sheet = workbook.getSheet("Sheet1");

		// to collect data
		// key and value hashmap. now make list of keys 1st
		// row will be key.
		// List of hashmap should be returned

		Iterator<Row> rows = sheet.rowIterator();
		Row row = rows.next();
		Iterator<Cell> cellit = row.cellIterator();

		// extracting keys into one arraylist

		ArrayList<String> Keys = new ArrayList<String>();

		while (cellit.hasNext()) {
			Cell cell = cellit.next();
			String str = cell.getCellType() == CellType.STRING ? cell.getStringCellValue()
					: cell.getNumericCellValue() + "";
			Keys.add(str);
			System.out.println(str + " added");
		}

		// Iterate through each row and add values into hashmap

		List<HashMap<String, String>> li = new ArrayList<HashMap<String, String>>();
		int i = 0;
		while (rows.hasNext()) {

			HashMap<String, String> map = new HashMap<String, String>();
			Row rowVal = rows.next();
			i = 0;
			Iterator<Cell> cell = rowVal.cellIterator();
			while (cell.hasNext()) {

				Cell cel = cell.next();
				String str = cel.getCellType() == CellType.STRING ? cel.getStringCellValue()
						: cel.getNumericCellValue() + "";

				map.put(Keys.get(i), str);

				System.out.println("map.put " + Keys.get(i) + " And " + str);

				i++;
			}

			li.add(map);

		}

		fin.close();
		return li;
	}

}
