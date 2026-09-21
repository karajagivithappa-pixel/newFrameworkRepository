package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewOrgPage {
	
	public CreatingNewOrgPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//input[@name='accountname']")
    private WebElement orgName;

    @FindBy(xpath="//input[@name='website']")
    private WebElement website;

    @FindBy(xpath="//select[@name='industry']")
    private WebElement industry;

    @FindBy(xpath="//input[@name='phone']")
    private WebElement phone;

    @FindBy(xpath="//input[@id='email1']")
    private WebElement email;

    @FindBy(xpath="//textarea[@name='bill_street']")
    private WebElement billingAdd;

    @FindBy(id="bill_city")
    private WebElement billingCity;

    @FindBy(id="bill_state")
    private WebElement billinState;

    @FindBy(id="bill_code")
    private WebElement billcode;

    @FindBy(xpath="//input[@name='cpy' and contains(@onclick,'Right(EditView)')]")
    private WebElement copyBillAdd;

    @FindBy(xpath="//input[@title='Save [Alt+S]']")
    private WebElement saveBtn;

    @FindBy(xpath="//input[@title='Cancel [Alt+X]']")
    private WebElement cancelBtn;
    
    @FindBy(xpath ="(//input[@type='radio'])[1]")
    private WebElement assignedToUserButton;
    
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getWebsite() {
		return website;
	}

	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getPhone() {
		return phone;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getBillingAdd() {
		return billingAdd;
	}

	public WebElement getBillingCity() {
		return billingCity;
	}

	public WebElement getBillinState() {
		return billinState;
	}

	public WebElement getBillcode() {
		return billcode;
	}

	public WebElement getCopyBillAdd() {
		return copyBillAdd;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getCancelBtn() {
		return cancelBtn;
	}
	
	public WebElement getAssignedToUserButton() {
		return assignedToUserButton;
	}

	
}
