package objectRepository;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	
	public OrgInfoPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

	@FindBy(id = "dtlview_Organization Name")
    private WebElement infoOrgName;
	
	@FindBy(id = "mouseArea_Phone")
	private WebElement infoPhone;
	
	@FindBy(id = "mouseArea_Industry")
	private WebElement infoIndustry;
	
    @FindBy(xpath="//input[@name='Edit']")
    private WebElement editbtn;

    @FindBy(xpath="//input[@name='Duplicate']")
    private WebElement duplicatebtn;

    @FindBy(xpath="//input[@name='Delete']")
    private WebElement deletebtn;

    public WebElement getInfoOrgName() {
        return infoOrgName;
    }
    
    public WebElement getInfoPhone() {
    	return infoPhone;
    }
    
    public WebElement getInfoIndustry() {
    	return infoIndustry;
    }
    
    public WebElement getEditbtn() {
        return editbtn;
    }

    public WebElement getDuplicatebtn() {
        return duplicatebtn;
    }

    public WebElement getDeletebtn() {
        return deletebtn;
    }
}
