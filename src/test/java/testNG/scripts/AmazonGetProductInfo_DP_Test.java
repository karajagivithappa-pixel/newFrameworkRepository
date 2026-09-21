package testNG.scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import genericUtility.WebDriverUtility;

public class AmazonGetProductInfo_DP_Test {
	
	@Test
	public void productInfoTest() {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("https://www.amazon.in/");
		
		driver.findElement(By.id("twotabsearchtextbox")).clear();
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
		
		//capture product info
		String xpath="(//h2[contains(@aria-label,'Ultramarine')])[2]/../../../descendant::span[@class='a-price-whole']";
		String price=driver.findElement(By.xpath(xpath)).getText();
		
		System.out.println(price);
		
		driver.quit();
	
	}
	
	/*@DataProvider
	public Object[][] getData(){
		Object [][] objArr=new Object[3][2];
		objArr[0][0]="iphone";
		objArr[0][1]="Ultramarine";
		objArr[1][0]="iphone";
		objArr[1][1]="Pink";
		objArr[2][0]="iphone";
		objArr[2][1]="White";
		
		return objArr; 
	}*/
}
