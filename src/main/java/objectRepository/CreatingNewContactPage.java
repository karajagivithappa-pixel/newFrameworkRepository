package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
		
	public CreatingNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath ="//input[@name='lastname']")
	private WebElement lastName;
	
	@FindBy(id = "mobile")
	private WebElement mobileNo;
	
	@FindBy(xpath = "//img[@tabindex]")
	private WebElement orgSelectBtn;
	
	@FindBy(linkText = "Vtiger813")
	private WebElement orgType;
	
	@FindBy(xpath ="//input[@title='Save [Alt+S]']")
	private WebElement save;

	@FindBy(xpath = "//input[@name='support_end_date']")
	private WebElement endDate;
	
	@FindBy(xpath = "//input[@name='support_start_date']")
	private WebElement startDate;
	
	public WebElement getEndDate() {
		return endDate;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getMobileNo() {
		return mobileNo;
	}

	public WebElement getOrgSelectBtn() {
		return orgSelectBtn;
	}

	public WebElement getOrgType() {
		return orgType;
	}
	
	public WebElement getSave() {
		return save;
	}
	
	
	
	
}
