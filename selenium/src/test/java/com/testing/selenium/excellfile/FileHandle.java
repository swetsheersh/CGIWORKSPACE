package com.testing.selenium.excellfile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class FileHandle {
  @Test
  public void f() throws Exception {
	  FileInputStream file=new FileInputStream("C:/Users/HARSH/Desktop/Test.xlsx");
	  XSSFWorkbook workbook =new XSSFWorkbook(file);
	  XSSFSheet sheet=workbook.getSheetAt(0);
	  int rowNum=sheet.getLastRowNum();
	  int colNum=sheet.getRow(0).getLastCellNum();
	  for(int i=0;i<=rowNum;i++) {
		  XSSFRow row=sheet.getRow(i);
		  for(int j=0;j<colNum;j++) {
			  String value=row.getCell(j).toString();
			  System.out.print(value+" ");
		  }
		  row.createCell(colNum).setCellValue("Pass");
		  
		  System.out.println("");
	  }
	  OutputStream file1=new FileOutputStream("C:/Users/HARSH/Desktop/Test.xlsx");
	  workbook.write(file1);
	  file1.close();
  }
  
}
