package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage //Rule 1: create a seperate POM class
{
	//Rule 2: Identify the WebElement using @FindBy
	
		@FindBy(id="username")
		private WebElement usernameEdt;
		
		@FindBy(id="password")
		private WebElement passwordEdt;
		
		@FindBy(xpath="//button[.=\"Sign in\"]")
		private WebElement loginBtn;
		
		//Rule 3:create a constructor 
		public LoginPage(WebDriver driver)
		{
			PageFactory.initElements(driver,this);
		}

		//Rule 4 : provide Getters
		public WebElement getUsernameEdt() {
			return usernameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		
		//Business Library
		/**
		 * This method will perform login operation
		 * @param username
		 * @param password
		 */
		public void loginToApp(String username,String password)
		{
			usernameEdt.clear();
			usernameEdt.sendKeys(username);
			passwordEdt.clear();
			passwordEdt.sendKeys(password);
			loginBtn.click();
			
		}
		
		
		
		
		
		

}
