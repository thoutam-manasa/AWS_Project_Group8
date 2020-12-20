package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.Logs;
import utility.ExcelRead;




/**
 * class for logging into website with valid credentials
 */
public class LoginPageWithPageFactory {
	WebDriver driver;
	ExcelRead excel=new ExcelRead();
	Logs log;
	String[][] test1=new String[1][1];
	
	
	/**
	 * locating username
	 */
	@FindBy(how=How.XPATH,using="//input[@id='username']")
	@CacheLookup
	WebElement username;
	/**
	 * locating password
	 */
	@FindBy(how=How.XPATH,using="//td[text()='Log In']//following::input[2]")
	@CacheLookup
	WebElement password;
	/**
	 * locating login button
	 */
	@FindBy(how=How.XPATH,using="//td[text()='Log In']//following::input[3]")
	@CacheLookup
	WebElement Login_button;
	/**
	 * method for Initializing the Objects
	 * @param driver
	 */
	public LoginPageWithPageFactory(WebDriver driver)  {
		this.driver=driver;
		log=new Logs(driver);
	}
	/**
	 * method for Specifiying email and psswd
	 * @param userid
	 * @param pass
	 * @throws InterruptedException 
	 */
	//Entering username
	public void enterUserName()        
		{
				test1=excel.read();
				String userName1=test1[0][1];
				
			//	WebElement username=driverWait.visibility(userName,20);         
				username.sendKeys(userName1);
				
				System.out.println("UserName is entered");
				log.update("******UserName is entered*****");
		}
	//Entering username
	public void enterPassword()        
		{
				test1=excel.read();
				String password1=test1[0][1];
				
				//WebElement a=driverWait.visibility(password,20);         
				password.sendKeys(password1);
				
				System.out.println("Password is entered");
				log.update("******Password is entered*****");
		}
//	public void typeUserNameAndPassword(String userid,String pass) {
//		username.sendKeys(userid);
//		password.sendKeys(pass);
//	}
	/**
	 * method for Clicking on Login button
	 */
	public void clickOnLoginButton() {
		 WebDriverWait wait = new WebDriverWait(driver, 20);
	        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[4]/td[2]/input[1]")));
	        Login_button.click();
		

	}
}
