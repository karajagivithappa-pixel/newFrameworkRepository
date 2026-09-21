package genericUtility;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://49.249.29.4:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing");
		
		String n="john";
		String o="butterfly123";
		
		driver.findElement(By.xpath("//img[@tabindex]")).click();
		
		String parentId=driver.getWindowHandle();
		Set<String> windowIDs=driver.getWindowHandles();
		for(String window:windowIDs) {
			driver.switchTo().window(window);
			if(!driver.getCurrentUrl().equals(parentId))
				break;
		}
		
		driver.findElement(By.id("search_txt")).sendKeys(o,Keys.ENTER);
		
		driver.findElement(By.linkText("+o+")).click();
		
	}
}
