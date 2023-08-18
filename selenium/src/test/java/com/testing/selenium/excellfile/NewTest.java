package com.testing.selenium.excellfile;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class NewTest {
  @Test(dataProvider = "dp")
  public void f(String n, String s,String l) {
	  System.out.println(n+" "+s+" "+l);
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() throws Exception {
      FileInputStream file=new FileInputStream("C:/Users/HARSH/Desktop/Test.xlsx");
  	  XSSFWorkbook workbook =new XSSFWorkbook(file);
  	  XSSFSheet sheet=workbook.getSheetAt(0);
  	  int rowNum=sheet.getLastRowNum();
  	  int colNum=sheet.getRow(0).getLastCellNum();
  	  Object[][] myobj = new Object[rowNum+1][colNum];
  	  for(int i=0;i<=rowNum;i++) {
  		  XSSFRow row=sheet.getRow(i);
  		  for(int j=0;j<colNum;j++) {
  			  String value=row.getCell(j).toString();
  			  System.out.print(value+" ");
  			  myobj[i][j]=value;
  		  }
  		  //row.createCell(colNum).setCellValue("Pass");
  		  
  		  System.out.println("");
  	  }
  	 // OutputStream file1=new FileOutputStream("C:/Users/HARSH/Desktop/Test.xlsx");
  	 // workbook.write(file1);
  	 // file1.close();
    return myobj;
  }
}
