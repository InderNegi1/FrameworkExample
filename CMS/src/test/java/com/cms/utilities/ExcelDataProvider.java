package com.cms.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	XSSFWorkbook wb;

	public ExcelDataProvider() {
		File src = new File("./TestData/TestData.xlsx");

		try {
			FileInputStream FIS = new FileInputStream(src);

			wb = new XSSFWorkbook(FIS);
		}

		catch (Exception e) {
			System.out.println("Could not read the excel file." + e.getMessage());
		}
	}

	public String getStringData(int SheetIndex, int row, int col) {
		return wb.getSheetAt(SheetIndex).getRow(row).getCell(col).getStringCellValue();
	}

	public String getStringData(String sheetName, int Row, int Col) {
		return wb.getSheet(sheetName).getRow(Row).getCell(Col).getStringCellValue();
	}

	public double getNumericData(String sheetName, int row, int Col) {
		return wb.getSheet(sheetName).getRow(row).getCell(Col).getNumericCellValue();
	}
}
