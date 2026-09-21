package genericUtility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	 
	Actions a;
	//Browser related methods
	public WebDriver launchDriver(String browserName) {
		WebDriver driver;
		if(browserName.equalsIgnoreCase("chrome"))
			driver=new ChromeDriver();
		else if(browserName.equalsIgnoreCase("firefox"))
			driver=new FirefoxDriver();
		else if(browserName.equalsIgnoreCase("edge"))
			driver=new EdgeDriver();
		else
			driver=new ChromeDriver();
		return driver;
	}
	
	public void maximizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	//Synchronization methods
	public void implicitWait(WebDriver driver ) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	
	//handling child window
	public void switchToChildWindow(WebDriver driver,String parentId) {
		Set<String> windowIDs=driver.getWindowHandles();
		for(String window:windowIDs) {
			driver.switchTo().window(window);
			if(!window.equals(parentId))
				break;
		}
	}
	
	//switching to parent window
	public void switchToParentWindow(WebDriver driver,String parentId) {
		
		driver.switchTo().window(parentId);
	}
	
	
	
	//select class methods
	public void selectFromDD(WebElement ele,String visibleText) {
		Select s=new Select(ele);
		s.selectByVisibleText(visibleText);
	}
	
	public void selectFromDD(WebElement ele,int index) {
		Select s=new Select(ele);
		s.selectByIndex(index);
	}
	
	public void selectFromDD(String value,WebElement ele) {
		Select s=new Select(ele);
		s.selectByValue(value);
	}
	
	//Actions class utility methods
	public void moveToElementAction(WebDriver driver,WebElement ele) {
		a=new Actions(driver);
		a.moveToElement(ele).perform();
	}
	
	public void sendKeysAction(WebDriver driver,WebElement ele,String keys) {
		a=new Actions(driver);
		a.sendKeys(ele,keys).perform();
		
	}
	
	public void dragAndDropAction(WebDriver driver,WebElement source,WebElement target) {
		a=new Actions(driver);
		a.dragAndDrop(source, target).perform();
		
	}
	
	public void clickOnWebElement(WebDriver driver,WebElement ele) {
		a=new Actions(driver);
		a.click(ele).perform();
	}
	
}
