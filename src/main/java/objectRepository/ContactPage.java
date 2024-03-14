package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage //Rule 1: create a seperate POM class
{
	//Rule 2: Identify the WebElement using @FindBy
	@FindBy(xpath = "//button[contains(@id,\"Contacts_listView_basicAction\")]")
	private WebElement createContactBtn;

	//Rule 3:create a constructor 
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	//Rule 4 : provide Getters
	public WebElement getCreateContactBtn() {
		return createContactBtn;
	}
	
	//Business library
	
	/*
	 * This method will perform click on  create contact lookup Image
	 */
	public void clickOnCreateContactLookUpImg()
	{
		createContactBtn.click();
	}
	



}
