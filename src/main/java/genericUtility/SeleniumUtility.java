package genericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

public class SeleniumUtility 
{
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * This method will add implicitly wait for 10 sec
	 * @param driver
	 */
	public void addImplicitelyWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method will wait for 10 sec for webElement to be visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVissible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method will wait for particular element to be clickable
	 * @param driver
	 * @param element
	 */
	public  void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}
	
	/**
	 * This method will perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHoverActionAndClick(WebDriver driver,WebElement element)
	{
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
		action.click(element).perform();
	}
	/**
	 * This method will perform right click
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.contextClick().perform();
	}
	/**
	 * This method will move the cursor based on offset and click on web page
	 * @param driver
	 */
	public void moveAndClick(WebDriver driver)
	{
		Actions action = new Actions(driver);
		action.moveByOffset(10, 10).click().perform();
	}
	/**
	 * This method will perform double click
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act = new Actions(driver);
		act.doubleClick().perform();
	}


	
	/**
	 * This method will switch to frame based on Frame Web Element
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/**
	 *  This method will switch to frame based on Frame Name or Id
	 * @param driver
	 * @param frameNameOrId
	 */
	public void switchToFrame(WebDriver driver,String frameNameOrId)
	{
		driver.switchTo().frame(frameNameOrId);
	}
	
	/**
	 *  This method will switch to frame based on Frame index
	 * @param driver
	 * @param frameIndex
	 */
	public void switchToFrame(WebDriver driver,int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	/**
	 * This method will accept the  alert pop up
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will cancel the  alert pop up
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver )
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will send data into alert pop up
	 * @param driver
	 * @param text
	 */
	public void sendAlertText(WebDriver driver ,String text)
	{
		driver.switchTo().alert().sendKeys(text);
	}
	/**
	 * This method will capture the alert text and return value to caller
	 * @param driver
	 * @return
	 */
	public String  getAlertText(WebDriver driver )
	{
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method will scroll up the page by 500 units
	 * @param driver
	 */
	
	public void scrollUpActions(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("Window.ScrollBy(0,-500);", "");
	}
	/**
	 * This method will scroll down the page by 500 units
	 * @param driver
	 */
	public void scrollDownActions(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("Window.ScrollBy(0,500);", "");
	}
	
	public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots"+screenShotName+".png");
		Files.copy(src, dst);
		return dst.getAbsolutePath();
	}
	/**
	 * This method will handle drop-down by index
	 * @param element
	 * @param index
	 */
	public void handleDropdown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method will handle drop-down by value
	 * @param element
	 * @param value
	 */
	public void handleDropdown(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method will handle drop down by visible text
	 * @param text
	 * @param element
	 */
	public void handleDropdown(String text,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void dragAndDrop(WebDriver driver,WebElement drag,WebElement drop)
	{
		Actions a = new Actions(driver);
		a.clickAndHold(drop).perform();
		a.release(drop).perform();
		
	}
	/**
	 * This method will be used to slide of web element
	 * @param driver
	 * @param slider
	 * @param desiredValue
	 */
    public  void setSliderToValue(WebDriver driver, WebElement slider, int retirementAge,int currentAge) 
    {
        int min= currentAge;
        int maxValue = 60;
        int range = maxValue - min;
        int pixelPerUnit = slider.getSize().getWidth() / range;
        int targetPixel = (retirementAge - min) * pixelPerUnit;
        Actions actions = new Actions(driver);
       // actions.clickAndHold(slider).moveByOffset(targetPixel, 0).release().build().perform();
        actions.dragAndDropBy(slider, targetPixel, 0).perform();
    }
    /**
     * This method is used to Scroll to the WebElement
     * @param driver
     * @param element
     */
    public void scrollToWebElement(WebDriver driver, WebElement element) 
    {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        
    }
    /**
     * This method is used to scroll to list of WebElement and perform click operation
     * @param options
     * @param optionText
     */
    public void selectByText(List<WebElement> options, String optionText)
    {
        for(WebElement ele : options) {
            if(ele.getText().equals(optionText)) {
                ele.click();
                break;
            }
        }
    }
    
    /**
     * This method is used to move slider to a given unit
     * @param driver
     * @param slider
     * @param sliderRail
     * @param percentage
     */
    public void moveSlider(WebDriver driver, WebElement slider, WebElement sliderRail, int percentage)  
    {   
    	int sliderRailWidth = sliderRail.getSize().getWidth();
    	int desiredPosition = (int) (sliderRailWidth * (percentage / 100.0));
    	Actions actions = new Actions(driver);
    	actions.dragAndDropBy(slider, desiredPosition, 0).perform();
    }




	
	
	
	
	
	
	
	
	
	

}
