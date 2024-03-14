package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.SeleniumUtility;

public class HomePage extends SeleniumUtility //Rule 1: create a seperate POM class
{
	//Rule 2: Identify the WebElement using @FindBy
		@FindBy(xpath = "//div[@class=\"container-fluid global-nav\"]/descendant::span[@class=\"app-icon fa fa-bars\"]")
		private WebElement aapIconMenu;

		@FindBy(xpath = "//div[@data-app-name=\"MARKETING\"]")
		private WebElement marketingLink;

		@FindBy(xpath = "//ul[@aria-labelledby=\"MARKETING_modules_dropdownMenu\"]/descendant::span[text()=\" Contacts\"]")
		private WebElement contactLink;

		@FindBy(xpath = "//li[@class=\"dropdown\"]")
		private WebElement administratorImg;
		
		@FindBy(xpath = "//a[.=\"Sign Out\"]")
		private WebElement signOutLink;

		//Rule 3:create a constructor 
		public HomePage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

		//Rule 4 : provide Getters

		public WebElement getAapIconMenu() {
			return aapIconMenu;
		}

		public WebElement getMarketingLink() {
			return marketingLink;
		}

		public WebElement getContactLink() {
			return contactLink;
		}
		
		public WebElement getadministratorImg() {
			return administratorImg;
		}

		public WebElement getSignOutLink() {
			return signOutLink;
		}
		
		
		//Business library
		
		/**
		 * This method will click on contact link
		 * @param driver
		 */
		
		public void clicKOnAppMenu()
		{
			aapIconMenu.click();
		}
		public void clickOncontactLink(WebDriver driver)
		{
			waitForElementToBeVissible(driver, aapIconMenu);
			mouseHoverAction(driver, marketingLink);
			waitForElementToBeClickable(driver, contactLink);
			mouseHoverActionAndClick(driver, contactLink);
					
		}
		
		/**
		 * This method will perform logout of app
		 * @param driver
		 */
		public void logOutOfApp(WebDriver driver)
		{
			administratorImg.click();
			waitForElementToBeVissible(driver,signOutLink);
			signOutLink.click();
		}



}
