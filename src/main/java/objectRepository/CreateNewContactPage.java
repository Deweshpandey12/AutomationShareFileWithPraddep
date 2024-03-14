package objectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class CreateNewContactPage extends SeleniumUtility //Rule 1: create a seperate POM class
{
	//Rule 2: Identify the WebElement using @FindBy
		@FindBy(name = "lastname")
		private WebElement lastNameEdt;

		@FindBy(xpath = "//button[text()=\"Save\"]")
		private WebElement saveBtn;

		@FindBy(xpath = "//span[.=\"Select an Option\"]")
		private WebElement leadSourceDropdown;
		
		@FindBy(xpath = "//li[@role=\"presentation\"]")
		private List<WebElement> dropdownText;
		
		//Rule 3:create a constructor 
		public CreateNewContactPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

		//Rule 4 : provide Getters
		public WebElement getLastNameEdt() {
			return lastNameEdt;
		}

		public WebElement getSaveBtn() {
			return saveBtn;
		}
		
		public WebElement getLeadSourceDropdown() {
			return leadSourceDropdown;
		}

		public List<WebElement> getDropdownText() {
			return dropdownText;
		}

		
		//Business Library
		
		/**
		 * This method create new contact and save
		 * @param LASTNAME
		 */
		public void createNewContact(String LASTNAME)
		{
			lastNameEdt.sendKeys(LASTNAME);
			saveBtn.click();
		}

		/**
		 * This method create new contact with lead source drop down and save
		 * @param LASTNAME
		 * @param LEADSOURCE
		 */
		public void createNewContact(String LASTNAME, String LEADSOURCE)
		{
			lastNameEdt.sendKeys(LASTNAME);
			leadSourceDropdown.click();
			selectByText(dropdownText, LEADSOURCE);
			saveBtn.click();
			
		}
		




}
