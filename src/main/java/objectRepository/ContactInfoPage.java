package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage 
{
	//Rule 1: create a seperate POM class

	//Rule 2: Identify the WebElement using @FindBy
	@FindBy(xpath = "//span[@class=\"lastname\"]")
	private  WebElement contactHeader;

	//Rule 3:create a constructor 
	public ContactInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Rule 4 : provide Getters
	public WebElement getContactHeader() {
		return contactHeader;
	}


	//Business library
	
	/**
	 * This method will capture header text and return it to caller
	 * @return
	 */
	public String captureContactHeader()
	{
		return contactHeader.getText();
	}


}
