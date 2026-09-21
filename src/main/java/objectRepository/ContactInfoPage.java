package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	public ContactInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
	
	@FindBy(className = "dvHeaderText")
	private WebElement infoHeader;
	
	@FindBy(id = "dtlview_Last Name")
	private WebElement infoLastName;
	
	@FindBy(id = "dtlview_Support End Date")
	private WebElement infoEndDate;
	
	@FindBy(id = "dtlview_Support Start Date")
	private WebElement infoStartDate;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement infoOrgName;
	
	
	public WebElement getInfoOrgName() {
		return infoOrgName;
	}

	public WebElement getInfoEndDate() {
		return infoEndDate;
	}

	public WebElement getInfoStartDate() {
		return infoStartDate;
	}
	
	public WebElement getInfoHeader() {
		return infoHeader;
	}

	public WebElement getInfoLastName() {
		return infoLastName;
	}

}
