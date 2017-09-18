package com.democart.Commonlib;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	
	public String getData(int rowNo,String val){
		String data="";
		XSSFSheet sh;
		XSSFWorkbook wb = null;
		try {
		FileInputStream fi=new FileInputStream("testData.xlsx");
			wb = new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(rowNo);
		sh=wb.getSheetAt(0);
		Row r=sh.getRow(rowNo);
		
		switch (val){
		case "UserName":data=r.getCell(0).getStringCellValue();break;
		case "Password":data=r.getCell(1).getStringCellValue();break;
		case "Emailid":data=r.getCell(2).getStringCellValue();break;
		case "FirstName":data=r.getCell(3).getStringCellValue();break;
		case "LastName":data=r.getCell(4).getStringCellValue();break;
		case "Address":data=r.getCell(5).getStringCellValue();break;
		case "City":data=r.getCell(6).getStringCellValue();break;
		case "Country":data=r.getCell(7).getStringCellValue();break;
		case "State":data=r.getCell(8).getStringCellValue();break;
		case "Pincode":data=String.valueOf(r.getCell(9).getNumericCellValue());break;
		case "PhoneNumber":data=String.valueOf(r.getCell(10).getNumericCellValue());break;
		}
		
		System.out.println(data);
		return data;
	}
}
