package genericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.HomePage;
import objectRepository.LoginPage;

public class BaseClass 
{
	public ExcelFileUtility eUtil=new ExcelFileUtility();
	public PropertyFileUtility putil=new PropertyFileUtility();
	public SeleniumUtility sUtil=new SeleniumUtility();
	public WebDriver driver;
	public static WebDriver sdriver;
	@BeforeSuite
	public void bsConfig()
	{
		System.out.println("=========DB Connection successful===========");
	}
	@BeforeClass
	public void bcConfig() throws IOException
	{
		String URL = putil.readDataFromPropertyFile("url");
		
		ChromeOptions options=new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "/home/pensionbox-dewesh/Downloads/chromedriver-linux64/chromedriver");
		options.setBinary("/home/pensionbox-dewesh/Downloads/chrome-linux64/chrome");
		driver=new ChromeDriver(options);
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitelyWait(driver);
		driver.get(URL);
		
		sdriver=driver;
		
		System.out.println("=============Browser Launch successful ==============");
		
	}
	@BeforeMethod
	public void bmCofig() throws IOException
	{
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		System.out.println("=============Login To App successful============");
	}
	
	@AfterMethod
	public void amConfig()
	{
		HomePage hp=new HomePage(driver);
		hp.logOutOfApp(driver);			
		System.out.println("==========Logout is successfull====================");
	}

	@AfterClass
	public void acConfig()
	{
		driver.quit();
		System.out.println("-----------Browser class----------");
	}
	@AfterSuite
	public void asConfig()
	{
		System.out.println("----------DB Connection closed---------");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
