package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LaunchingBrowser 
{
	public static void main(String[] args) 
	{
		ChromeOptions options=new ChromeOptions();
		System.setProperty("webdriver.chrome.driver", "/home/pensionbox-dewesh/Downloads/chromedriver-linux64/chromedriver");
		options.setBinary("/home/pensionbox-dewesh/Downloads/chrome-linux64/chrome");
		WebDriver driver=new ChromeDriver(options);
		
		//WebDriver driver=new FirefoxDriver();
	}
}
