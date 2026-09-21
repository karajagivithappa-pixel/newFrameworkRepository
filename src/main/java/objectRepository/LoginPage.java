package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	private WebElement uName;
	
	@FindBy(name="user_password")
	private WebElement uPass;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath="//input[@value='Login']")})
	private WebElement login;
	
	/**
	 * login to application based on username, password, url arguments
	 * @param username
	 * @param password
	 * @throws Exception 
	 */
	public void userLogin(String username,String password) throws Exception {
		
		uName.sendKeys(username);
		uPass.sendKeys(password);
		login.click();
	}
}
