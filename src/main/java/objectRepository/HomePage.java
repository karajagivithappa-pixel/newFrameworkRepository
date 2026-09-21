package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(linkText="Organizations")
	private WebElement orgLink;
	
	@FindBy(xpath = "//a[contains(@href,'Contacts&action=index')]")
	private WebElement contactLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;

	@FindBy(xpath ="//img[@src='themes/softed/images/user.PNG']")
	private WebElement userImg;
	
	@FindBy(xpath = "//td[contains(.,'Sign Out')]")
	private WebElement signout;
	
	public WebElement getUserImg() {
		return userImg;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
	
	
}
