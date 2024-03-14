package contactsTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import genericUtility.ExcelFileUtility;
import genericUtility.PropertyFileUtility;
import genericUtility.SeleniumUtility;
import objectRepository.ContactInfoPage;
import objectRepository.ContactPage;
import objectRepository.CreateNewContactPage;
import objectRepository.HomePage;
import objectRepository.LoginPage;

public class CreateContactaWithLeadsourceTest 
{
	@Test
	public void createContactWithLeadSource() throws IOException 
	{
		
		//Step 1: Create Object of utility class

		ExcelFileUtility eUtil=new ExcelFileUtility();
		PropertyFileUtility putil=new PropertyFileUtility();
		SeleniumUtility sUtil=new SeleniumUtility();

		//Read common data - property file
		String URL = putil.readDataFromPropertyFile("url");
		String USERNAME = putil.readDataFromPropertyFile("username");
		String PASSWORD = putil.readDataFromPropertyFile("password");

		//Read data -  Excel File
		String LASTNAME = eUtil.readDataFromExcel("Contacts", 1, 2);
		String LEADSOURCE = eUtil.readDataFromExcel("Contacts", 5, 3);

		//Launch the browser
		ChromeOptions options=new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "/home/pensionbox-dewesh/Downloads/chromedriver-linux64/chromedriver");
		options.setBinary("/home/pensionbox-dewesh/Downloads/chrome-linux64/chrome");
		WebDriver driver=new ChromeDriver(options);
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitelyWait(driver);
		driver.get(URL);

		//login to application
						
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		
		// Navigate to contact link
		
		HomePage hp=new HomePage(driver);
		hp.clicKOnAppMenu();
		hp.clickOncontactLink(driver);
		
		// click on create contact lookup image
		ContactPage cp = new ContactPage(driver);
		cp.clickOnCreateContactLookUpImg();

		// create contact with mandatory field

		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME, LEADSOURCE);

		
		// Verify Contact details
		ContactInfoPage cip=new ContactInfoPage(driver);
		String contactHeader = cip.captureContactHeader();
		if(contactHeader.contains(LASTNAME))
		{
			System.out.println("PASS");
		}
		else
		{
			System.out.println("FAIL");
		}

		// Logout from application

		hp.logOutOfApp(driver);			
		System.out.println("Logout is successfull");

	}

}
