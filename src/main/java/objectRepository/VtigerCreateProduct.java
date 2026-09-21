package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VtigerCreateProduct {
	
	public VtigerCreateProduct(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css = "input[name='productname']")
	private WebElement productName;
	
	@FindBy(css = "input[name='sales_start_date']")
	private WebElement salesStartDate;

	@FindBy(css = "input[name='sales_end_date']")
	private WebElement salesEndDate;
		
	public WebElement getProductName() {
		return productName;
	}
	
	public WebElement getSalesStartDate() {
		return salesStartDate;
	}
	
	public WebElement getSalesEndDate() {
		return salesEndDate;
	}
	

}
