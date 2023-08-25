package com.selenium.cucumber.testcase;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.selenium.cucumber.pageobject.Login;

import StepDefinitions.FacebookLogin;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="Features",glue= {"StepDefinitions"},
monochrome=true,
plugin= {"pretty","html:target/HtmlReports"})
public class FBTest {
  
	WebDriver driver;
	FacebookLogin fblog;
	//Register reg;
	Login log;
	//ForgetPass forPass;
	//extent Reports
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test;
	
	//extent report configuration before executing tests
	@BeforeTest
	public void beforeTest() {
		//to create the report file
		this.spark=new ExtentSparkReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
		spark.config().setDocumentTitle("Automation Report");//title of the report
		spark.config().setReportName("Orange HRM Report");//name of the report
		spark.config().setTheme(Theme.DARK);
		
		//create entry in report 
		
		this.extent=new ExtentReports();
		extent.attachReporter(this.spark);
		extent.setSystemInfo("Host Name", "LocalHost");
		extent.setSystemInfo("os","Windows 10");
		extent.setSystemInfo("Tester Name", "Swet Sheersh");
		extent.setSystemInfo("Browser", "Chrome");
		
	}
	@AfterTest
	public void afterTest() {
		extent.flush();
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed is "+result.getName());//to add name in extent report
			test.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());//to add error/exception
			
			String screenshotpath=FBTest.getScreenShot(driver, result.getName());
			
			test.addScreenCaptureFromPath(screenshotpath);
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skipped is "+result.getName());
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed is "+result.getName());
		}
	}
	
	//capture screenshot in case of failure
	
	public static String getScreenShot(WebDriver driver,String screenshotName)throws Exception{
		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		//after execution ,you could see a folder "failedTestsScreenshots" under src folder
		String destination =System.getProperty("user-dir")+"/Screenshots/"+screenshotName+dateName+".png";			File finalDestination=new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
			
	}
/*	
  @Test(dataProvider = "dp",priority = 2)
  public void verifyRegister(String fname, String lname,String email,String reemail, String pass,String day,String mon, String year,String gen,String exp) throws Exception {
	  //driver.get("https://www.facebook.com/");
	  //driver.manage().window().maximize();
	  this.test=extent.createTest("verifyRegister");
	  driver.navigate().to("https://www.facebook.com/");
	  
	 // Thread.sleep(3000);
	  //reg=new Register(driver);
	  reg.create();
	  reg.sendfirstName(fname);
	  reg.sendlastName(lname);
	  reg.sendEmail(email);
	  reg.resendEmail(reemail);
	  reg.sendpass(pass);
	  reg.sendday(String.valueOf((int)Double.parseDouble(day)));
	  reg.sendmonth(String.valueOf((int)Double.parseDouble(mon)));
	  reg.sendyear(String.valueOf((int)Double.parseDouble(year)));
	  reg.clickgender(gen);
	  reg.clickSubmit();
	  Thread.sleep(6000);
	  test.createNode("Register with Name : "+fname+", Email: "+email);
	  assertEquals(driver.getCurrentUrl().contains("recover"), Boolean.parseBoolean(exp));
	  Thread.sleep(2000);
  }*/
  @Test(dataProvider ="dp1" ,priority = 1)
  public void loginTest(String uname,String pass,String exp) throws Exception {
	  this.test=extent.createTest("loginTest");
	  //this.fblog.navigate_to_the_url(log);
	  
	  //this.fblog.enter_the_username_and_password(uname, pass);
	  
	  this.fblog.clickon_submit_button();
	  
	  Thread.sleep(4000);
	  test.createNode("Login With UserName : "+uname+", password: "+pass);
	  assertEquals(this.driver.getPageSource().contains("mind"),Boolean.parseBoolean(exp));
	  
	  Thread.sleep(1000);
	  driver.manage().deleteAllCookies();
	  
  }
 /* 
  @Test(dataProvider = "dp2",priority = 0)
  public void forgetTest(String email,String exp) throws InterruptedException {
	  this.test=extent.createTest("forgetTest");
	  driver.navigate().to("https://www.facebook.com/");
	  this.forPass.clickFPass();;
	  Thread.sleep(2000);
	  this.forPass.sendEmail(email);
	  this.forPass.clickSearch();
	  Thread.sleep(5000);
	  test.createNode("Forget Password With Email : "+email);
	  assertEquals(this.driver.getPageSource().contains("Recover"), Boolean.parseBoolean(exp));
	  driver.manage().deleteAllCookies();
  }*/
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Executing Test...");
	  this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	 // this.reg=new Register(driver);
	  this.log=new Login(driver);
	 // this.forPass=new ForgetPass(driver);
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Register Test...");
	  ChromeOptions options=new ChromeOptions();
	  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
	  this.driver=new ChromeDriver(options);
  }
  
  @DataProvider(parallel = true)
  public Object[][] dp() throws Exception {
	  FileInputStream file=new FileInputStream("C:/Users/HARSH/Desktop/fb.xlsx");
  	  XSSFWorkbook workbook =new XSSFWorkbook(file);
  	  XSSFSheet sheet=workbook.getSheetAt(0);
  	  int rowNum=sheet.getLastRowNum();
  	  int colNum=sheet.getRow(0).getLastCellNum();
  	  Object[][] myobj = new Object[rowNum][colNum];
  	  for(int i=1;i<=rowNum;i++) {
  		  XSSFRow row=sheet.getRow(i);
  		  for(int j=0;j<colNum;j++) {
  			  try {
  			  String value=row.getCell(j).toString();
  			  System.out.print(value+" ");
  			  myobj[i-1][j]=value;
  			  }catch(Exception e) {}
  		  }
  		  //row.createCell(colNum).setCellValue("Pass");
  		  
  		  System.out.println("");
  	  }
  	 // OutputStream file1=new FileOutputStream("C:/Users/HARSH/Desktop/Test.xlsx");
  	 // workbook.write(file1);
  	 // file1.close();
    return myobj;
  }
  
  @DataProvider(parallel = true)
  public Object[][] dp1() throws Exception {
	  FileInputStream file=new FileInputStream("C:/Users/HARSH/Desktop/fb.xlsx");
  	  XSSFWorkbook workbook =new XSSFWorkbook(file);
  	  XSSFSheet sheet=workbook.getSheetAt(1);
  	  int rowNum=sheet.getLastRowNum();
  	  int colNum=sheet.getRow(0).getLastCellNum();
  	  Object[][] myobj = new Object[rowNum][colNum];
  	  for(int i=1;i<=rowNum;i++) {
  		  XSSFRow row=sheet.getRow(i);
  		  for(int j=0;j<colNum;j++) {
  			  try {
  			  String value=row.getCell(j).toString();
  			  System.out.print(value+" ");
  			  myobj[i-1][j]=value;
  			  }catch(Exception e) {}
  		  }
  		  //row.createCell(colNum).setCellValue("Pass");
  		  
  		  System.out.println("");
  	  }
  	 // OutputStream file1=new FileOutputStream("C:/Users/HARSH/Desktop/Test.xlsx");
  	 // workbook.write(file1);
  	 // file1.close();
    return myobj;
  }
  
  @DataProvider(parallel = true)
  public Object[][] dp2() throws Exception {
	  FileInputStream file=new FileInputStream("C:/Users/HARSH/Desktop/fb.xlsx");
  	  XSSFWorkbook workbook =new XSSFWorkbook(file);
  	  XSSFSheet sheet=workbook.getSheetAt(2);
  	  int rowNum=sheet.getLastRowNum();
  	  int colNum=sheet.getRow(0).getLastCellNum();
  	  Object[][] myobj = new Object[rowNum][colNum];
  	  for(int i=1;i<=rowNum;i++) {
  		  XSSFRow row=sheet.getRow(i);
  		  for(int j=0;j<colNum;j++) {
  			  try {
  			  String value=row.getCell(j).toString();
  			  System.out.print(value+" ");
  			  myobj[i-1][j]=value;
  			  }catch(Exception e) {}
  		  }
  		  //row.createCell(colNum).setCellValue("Pass");
  		  
  		  System.out.println("");
  	  }
  	 // OutputStream file1=new FileOutputStream("C:/Users/HARSH/Desktop/Test.xlsx");
  	 // workbook.write(file1);
  	 // file1.close();
    return myobj;
  }

  @AfterSuite
  public void afterSuite() {
	  this.driver.quit();
  }
  
}
