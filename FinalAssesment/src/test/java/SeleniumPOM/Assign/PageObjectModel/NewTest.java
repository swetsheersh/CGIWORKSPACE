package SeleniumPOM.Assign.PageObjectModel;

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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class NewTest {
	WebDriver driver;
	Cart reg;
	Login log;
	
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
		spark.config().setReportName("Final Assesment");//name of the report
		spark.config().setTheme(Theme.DARK);
		
		//create entry in report 
		
		this.extent=new ExtentReports();
		extent.attachReporter(this.spark);
		extent.setSystemInfo("Host Name", "LocalHost");
		extent.setSystemInfo("os","Windows 10");
		extent.setSystemInfo("Tester Name", "Swet Sheersh");
		extent.setSystemInfo("Browser", "Chrome");
		
	/*	//Cross Browser Test
		if(br.equals("chrome")) {
			  ChromeOptions options=new ChromeOptions();
			  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			  this.driver=new ChromeDriver(options);
		  }else if(br.equals("firefox")) {
			  FirefoxOptions options=new FirefoxOptions();
			  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			  this.driver=new FirefoxDriver(options);
		  }else if(br.equals("edge")) {
			  EdgeOptions options=new EdgeOptions();
			  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			  this.driver=new EdgeDriver(options);
		  }*/
		
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
			
			String screenshotpath=NewTest.getScreenShot(driver, result.getName());
			String screenshotpath1="D:\\Projects\\Cgi\\FinalAssesment\\"+screenshotpath;
			
			test.addScreenCaptureFromPath(screenshotpath1);
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
		String destination =System.getProperty("user-dir")+"screenshots/"+screenshotName+dateName+".jpg";			
		File finalDestination=new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
			
	}
	
	
	  @Test(dataProvider = "dp",priority = 0)
	  public void verifyRegister(String uname , String pass,String exp) throws Exception {
		
		  this.test=extent.createTest("verifyLogin");
		  driver.navigate().to("https://www.saucedemo.com/");
		  
		  log.sendUser(uname);
		  log.sendPass(pass);
		  log.clickSubmit();
		  Thread.sleep(3000);
		  
		  
		  test.createNode("Login With UserName : "+uname+", Password: "+pass);
		  assertEquals(driver.getCurrentUrl().contains("https://www.saucedemo.com/inventory.html"), Boolean.parseBoolean(exp));
		  Thread.sleep(2000);
	  }
	  
	  @Test(dataProvider = "dp1",priority = 1)
	  public void loginTest(String uname,String lname,String zip) throws Exception {
		  this.test=extent.createTest("CartTest");
		  
		  reg.clickadd();
		  reg.clicklogo();
		  reg.clickcheckout();
		  reg.sendFname(uname);
		  reg.sendLname(lname);
		  reg.sendZip(zip);
		  reg.clickContinue();
		  reg.clickfinish();
		  
		  
		  Thread.sleep(4000);
		  test.createNode("Cart With Name : "+uname);
		  assertEquals(this.driver.getPageSource().contains("Thank you for your order!"),true);
		  
		  Thread.sleep(1000);
		  driver.manage().deleteAllCookies();
		  
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("Executing Test...");
		  this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		  this.reg=new Cart(driver);
		  this.log=new Login(driver);
	  }
	  
	  @DataProvider
	  public Object[][] dp() throws Exception {
		  FileInputStream file=new FileInputStream("D:\\Projects\\Cgi\\FinalAssesment\\data.xlsx");
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
	  
	  @AfterSuite
	  public void afterSuite() {
		  this.driver.quit();
	  }
	  
	  @BeforeSuite
	  public void beforeSuite(/*String br*/) {
		  System.out.println("Register Test...");
		  ChromeOptions options=new ChromeOptions();
		  options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		  this.driver=new ChromeDriver(options);
		  driver.get("https://www.saucedemo.com/");
		  driver.manage().window().maximize();
	  }
	  @DataProvider
	  public Object[][] dp1() throws Exception {
		  FileInputStream file=new FileInputStream("D:\\Projects\\Cgi\\FinalAssesment\\data.xlsx");
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
}
