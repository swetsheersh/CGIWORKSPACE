package SeleniumPOM.capstone.testcases;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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

import SeleniumPOM.capstone.PageObjectModel.SearchProduct;
import SeleniumPOM.capstone.PageObjectModel.ComparePrice;
import SeleniumPOM.capstone.PageObjectModel.FilterAndVerify;
import SeleniumPOM.capstone.PageObjectModel.AddToCart;
import SeleniumPOM.capstone.PageObjectModel.RemoveCart;
import SeleniumPOM.capstone.utilities.MyUtility;

public class NewTest {
	//variables
	//WebDriver object
	WebDriver driver;
	
	//POM Class Objects
	SearchProduct reg;
	AddToCart log;
	ComparePrice cp;
	FilterAndVerify filter;
	RemoveCart remove;
	
	//Utility class objects
	MyUtility utility;
	//HashMap for saving data
	HashMap<String,String> map;
	
	//extent Reports
	public ExtentSparkReporter spark;
	public ExtentReports extent;
	public ExtentTest test;
	
	//extent report configuration before executing tests
	@BeforeTest
	public void beforeTest() throws Exception {
		//to create the report file
		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		this.spark=new ExtentSparkReporter(this.utility.getPathOfReport()+"/"+dateName+"myReport.html");
		spark.config().setDocumentTitle("Automation Report");//title of the report
		spark.config().setReportName("Capstone_Project_Selenium");//name of the report
		spark.config().setTheme(Theme.DARK);
		
		//create entry in report 
		
		this.extent=new ExtentReports();
		extent.attachReporter(this.spark);
		extent.setSystemInfo("Host Name", this.utility.getDataFromProperties("host"));
		extent.setSystemInfo("os",this.utility.getDataFromProperties("os"));
		extent.setSystemInfo("Tester Name", this.utility.getDataFromProperties("tester"));
		extent.setSystemInfo("Browser", this.utility.getDataFromProperties("browser"));
		
	}
	//Logging Results to Extent Report
	@AfterMethod
	public void tearDown(ITestResult result) throws Exception {
		if(result.getStatus()==ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed is "+result.getName());//to add name in extent report
			test.log(Status.FAIL, "Test Case Failed is "+result.getThrowable());//to add error/exception
			
			String screenshotpath=NewTest.getScreenShot(driver, result.getName());
		
			test.addScreenCaptureFromPath(screenshotpath);
		}else if(result.getStatus()==ITestResult.SKIP) {
			test.log(Status.SKIP, "Test Case Skipped is "+result.getName());
		}else if(result.getStatus()==ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed is "+result.getName());
		}
	}
	
	//capture screenshot in case of failure
	
	public static String getScreenShot(WebDriver driver,String screenshotName)throws Exception{
		MyUtility util=new MyUtility();
		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		//after execution ,you could see a folder "failedTestsScreenshots" under src folder
		String destination =util.getPathOfScreenShots()+"\\"+screenshotName+dateName+".jpg";
		File finalDestination=new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
			
	}
	  //It will execute before each test case
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Executing Test...");
		  this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  this.reg=new SearchProduct(driver);
		  this.log=new AddToCart(driver);
		  this.cp=new ComparePrice(driver);
		  this.filter=new FilterAndVerify(driver);
		  this.remove=new RemoveCart(driver);
	  }
	  
	  //After all Test cases ,saving the report
	  @AfterTest
		public void afterTest() {
			extent.flush();
	  }
	  
	  //Execute before suite
	  @BeforeSuite
	  public void beforeSuite() throws Exception {
		  System.out.println("Register Test...");
		  this.utility=new MyUtility();
		  this.map= new HashMap<String, String>();
		//Cross Browser Test
		 if(this.utility.getDataFromProperties("browser").equals("chrome")) {
			ChromeOptions options=new ChromeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			this.driver=new ChromeDriver(options);
		 }else if(this.utility.getDataFromProperties("browser").equals("firefox")) {
			FirefoxOptions options=new FirefoxOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			this.driver=new FirefoxDriver(options);
		 }else if(this.utility.getDataFromProperties("browser").equals("edge")) {
			EdgeOptions options=new EdgeOptions();
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			this.driver=new EdgeDriver(options);
		 }
		  driver.get("https://www.flipkart.com/");
		  driver.manage().window().maximize();
	  }
	  
	  //After suite ,it will quit the browser
	  @AfterSuite
	  public void afterSuite() {
		  this.driver.quit();
	  }
	  
	  //TestCases
	  
	  @Test(dataProvider = "dp",priority = 0)
	  public void searchProduct(String d1,String d2,String exp) throws Exception {

		  this.test=extent.createTest("search Product");
		  //Automation code using POM class
		  
		  //remove this statement only to show how data is taken from data provider
		  System.out.println("Data1: "+d1+", Data2: "+d2);
		  
		  
		  
		  
		  
		  
		  test.createNode("add any name");
		  assertEquals(this.driver.getPageSource().contains(""),Boolean.parseBoolean(exp));
		  Thread.sleep(1000);
		  driver.manage().deleteAllCookies();
		  
		  
	  }
	  
	  @Test(dataProvider = "dp1",priority = 1)
	  public void addToCart(String d1,String d2,String exp) throws Exception {
		  
		  this.test=extent.createTest("Add To Cart");
		  //Automation code using POM class
		  
		  
		//remove this statement only to show how data is taken from data provider
		  System.out.println("Data1: "+d1+", Data2: "+d2);
		  
		  
		  
		  
		  
		  test.createNode("add any name");
		  assertEquals(this.driver.getPageSource().contains(""),Boolean.parseBoolean(exp));
		  Thread.sleep(1000);
		  driver.manage().deleteAllCookies();
		  
		  
	  }
	  
	  @Test(dataProvider = "dp2",priority = 2)
	  public void filterAndVerify(String d1,String d2,String exp) throws Exception {
		  
		  this.test=extent.createTest("Filter And Verify the Product");
		  //Automation code using POM class
		  
		  
		//remove this statement only to show how data is taken from data provider
		  System.out.println("Data1: "+d1+", Data2: "+d2);
		  
		  
		  
		  
		  
		  test.createNode("add any name");
		  assertEquals(this.driver.getPageSource().contains(""),Boolean.parseBoolean(exp));
		  Thread.sleep(1000);
		  driver.manage().deleteAllCookies();
		  
	  }
	  
	  @Test(dataProvider = "dp3",priority = 3)
	  public void comparePrice(String d1,String d2,String exp) throws Exception {
		  
		  this.test=extent.createTest("Compare Price");
		  //Automation code using POM class
		  
		  
		//remove this statement only to show how data is taken from data provider
		  System.out.println("Data1: "+d1+", Data2: "+d2);
		  
		  
		  
		  
		  
		  test.createNode("add any name");
		  assertEquals(this.driver.getPageSource().contains(""),Boolean.parseBoolean(exp));
		  Thread.sleep(1000);
		  driver.manage().deleteAllCookies();
		  
	  }
	  
	  @Test(dataProvider = "dp4",priority = 4)
	  public void removeProductFromCart(String d1,String d2,String exp) throws Exception {
		  
		  this.test=extent.createTest("Remove Product From Cart");
		  //Automation code using POM class
		  
		  
		//remove this statement only to show how data is taken from data provider
		  System.out.println("Data1: "+d1+", Data2: "+d2);
		  
		  
		  
		  
		  
		  test.createNode("add any name");
		  assertEquals(this.driver.getPageSource().contains(""),Boolean.parseBoolean(exp));
		  Thread.sleep(1000);
		  driver.manage().deleteAllCookies();
		  
	  }
	  
	  
	  //Data Provider

	  @DataProvider
	  public Object[][] dp() throws Exception {
		  FileInputStream file=new FileInputStream(this.utility.getPathOfXlsx());
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
	  		  
	  		  System.out.println("");
	  	  }
	    return myobj;
	  }
	  
	  @DataProvider
	  public Object[][] dp1() throws Exception {
		  FileInputStream file=new FileInputStream(this.utility.getPathOfXlsx());
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
	  		  
	  		  System.out.println("");
	  	  }
	    return myobj;
	  }
	  
	  @DataProvider
	  public Object[][] dp2() throws Exception {
		  FileInputStream file=new FileInputStream(this.utility.getPathOfXlsx());
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
	  		  
	  		  System.out.println("");
	  	  }
	    return myobj;
	  }
	  
	  @DataProvider
	  public Object[][] dp3() throws Exception {
		  FileInputStream file=new FileInputStream(this.utility.getPathOfXlsx());
	  	  XSSFWorkbook workbook =new XSSFWorkbook(file);
	  	  XSSFSheet sheet=workbook.getSheetAt(3);
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
	  		  
	  		  System.out.println("");
	  	  }
	    return myobj;
	  }
	  
	  @DataProvider
	  public Object[][] dp4() throws Exception {
		  FileInputStream file=new FileInputStream(this.utility.getPathOfXlsx());
	  	  XSSFWorkbook workbook =new XSSFWorkbook(file);
	  	  XSSFSheet sheet=workbook.getSheetAt(4);
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
	  		  
	  		  System.out.println("");
	  	  }
	    return myobj;
	  }
}
