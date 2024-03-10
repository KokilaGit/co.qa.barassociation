package com.ba.utils;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	XSSFWorkbook ws;

	public ExcelUtil(String excelpath) {

		try {
			File file = new File(excelpath);
			FileInputStream fistr = new FileInputStream(file);
			ws = new XSSFWorkbook(fistr);
		} catch (Exception e) {
			System.out.println("Unable to read excel sheet");
			e.printStackTrace();
		}

	}

	public int getRowCount(int sheetNum) {
		int count = ws.getSheetAt(sheetNum).getLastRowNum() + 1;
		return count;
	}

	public int getColCount(int sheet) {
		int colCount = ws.getSheetAt(sheet).getRow(0).getLastCellNum();
		return colCount;
	}

	public String getCellValue(int sheetNum, int row, int col) {

		String data = ws.getSheetAt(sheetNum).getRow(row).getCell(col).toString();
		return data;

	}
}
