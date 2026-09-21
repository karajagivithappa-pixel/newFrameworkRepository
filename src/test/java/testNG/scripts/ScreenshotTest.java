package testNG.scripts;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class ScreenshotTest {
	@Test
	public void amazonTest() throws IOException{
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des=new File(".screenshot/amazon.png");
		FileHandler.copy(src, des);
	
	
	}
}
