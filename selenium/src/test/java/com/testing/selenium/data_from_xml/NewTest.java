package com.testing.selenium.data_from_xml;

import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;

public class NewTest {
  @Test(dataProvider = "dp")
  public void f(String n, String s) {
	  System.out.println(n+" "+s);
  }
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }


  @DataProvider
  public Object[][] dp() throws Exception {
	  Object[][] obj=new Object[1][2];
     /* FileInputStream file=new FileInputStream("C:/Users/HARSH/Desktop/Test.xlsx");
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
    return myobj;*/
	  File xmlfile=new File("D:\\Projects\\Cgi\\selenium\\logindetail.xml");
	  DocumentBuilderFactory dbfactory=DocumentBuilderFactory.newInstance();
	  DocumentBuilder dbbuilder=dbfactory.newDocumentBuilder();
	  Document doc=dbbuilder.parse(xmlfile);
	  NodeList n1=doc.getChildNodes();
	  Node n=n1.item(0);
	  Element ele=(Element) n;
	  obj[0][0]=ele.getElementsByTagName("username").item(0).getTextContent();
	  obj[0][1]=ele.getElementsByTagName("password").item(0).getTextContent();
	  return obj;
  }
}
