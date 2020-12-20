package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EmployeeDetailsPageWithPageFactory {
	WebDriver driver;


	@FindBy(how=How.LINK_TEXT,using="Employee Details")
	@CacheLookup
	WebElement empdet;
	@FindBy(how=How.XPATH,using="//tbody/tr[2]/td[4]/a[1]/img[1]")
	@CacheLookup
	WebElement edit;
	@FindBy(how=How.XPATH,using="//tbody/tr[3]/td[4]/input[1]")
	@CacheLookup
	WebElement email;
	@FindBy(how=How.XPATH,using="//tbody/tr[8]/td[1]/input[1]")
	@CacheLookup
	WebElement updateempdetails;
	@FindBy(how=How.XPATH,using="//a[contains(text(),'Logout')]")
	@CacheLookup
	WebElement logout;

	public  EmployeeDetailsPageWithPageFactory(WebDriver driver) {
		this.driver=driver;
	}
	public void clickonEmployeeDetails()
	{
		empdet.click();
	}
	public void clickonEdit() {
		edit.click();
	}
	public void typeEmailid(String mail) {
	email.clear();
	email.sendKeys("abc@gmail.com");
	}
	public void clickonUpdateEmp() {
		updateempdetails.click();
		}
	public void clickonLogout() {
		logout.click();
		}
	
	}
	

