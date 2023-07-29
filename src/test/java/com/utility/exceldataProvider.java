package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class exceldataProvider {

	XSSFWorkbook wb;

	public exceldataProvider() {

		File src = new File("C:\\Users\\milan\\eclipse-workspace\\Framework\\TestData\\Data.xlsx");
		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {

			System.out.println("Unable to read excel" + e.getMessage());
		}

	}

	public String getStringdata(int sheetIndex, int row, int col) {

		return wb.getSheetAt(sheetIndex).getRow(row).getCell(col).getStringCellValue();
	}

	public String getStringdata(String sheetname, int row, int col) {

		return wb.getSheet(sheetname).getRow(row).getCell(col).getStringCellValue();
	}

	public double getNumericData(String sheetname, int row, int col) {

		return wb.getSheet(sheetname).getRow(row).getCell(col).getNumericCellValue();
	}

}
