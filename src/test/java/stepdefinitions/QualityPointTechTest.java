package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//import com.relevantcodes.extentreports.ExtentReports;
//import com.relevantcodes.extentreports.ExtentTest;
//import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.EmployeeDetailsPageWithPageFactory;
import pages.LoginPageWithPageFactory;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;



import base.LaunchBrowser;
import base.Screenshot;
import pages.EmployeeDetailsPageWithPageFactory;
import pages.LoginPageWithPageFactory;
import utility.ExcelRead;
import cucumber.api.java.en.*;


public class QualityPointTechTest extends ExcelRead{
	WebDriver driver;
	
	LoginPageWithPageFactory login;
	EmployeeDetailsPageWithPageFactory emp;
	Screenshot sc;
	
	/**
	 * method to get extentreports
	 */
//	public static ExtentReports report = new ExtentReports("./Reports/ExtentReport.html");
//	ExtentTest test = report.startTest("QualityPointTech");
	
	//Screenshot ob=new Screenshot(driver);	
	
	//Logger logger;
	
@Given("^Open chrome and start application$")
public void open_chrome_and_start_application() throws Throwable {
	System.out.println("1"); 
    read();
	driver=LaunchBrowser.Launch_Browser("url");
	System.out.println("2"); 
	sc=new Screenshot(driver);
	
}

@When("Entering Username,Password and Click on Login button")
public void entering_Username_Password_and_Click_on_Login_button() {
	System.out.println("3"); 
	login=new LoginPageWithPageFactory(driver);
	System.out.println("3"); 
	login.enterUserName();
	System.out.println("3"); 
	login.enterPassword();
	//login.typeUserNameAndPassword();
    sc.getScreenshot(driver);
    login.clickOnLoginButton();
    System.out.println("3"); 
}


@Then("^user should be able to login$")
public void user_should_be_able_to_login() throws Throwable {
	login.clickOnLoginButton();

	Assert.assertEquals("http://qualitypointtech.net/timesheetdemo/report.php", driver.getCurrentUrl());
	
	
	System.out.println(driver.getCurrentUrl());
	System.out.println("login sucessfull"); 
	sc.getScreenshot(driver);
	//logger.info("login sucessful");
}
@When("^user clicks on Employee Details Button$")
public void user_clicks_on_Employee_Details_Button() throws Throwable {
	emp=PageFactory.initElements(driver, EmployeeDetailsPageWithPageFactory.class);
	emp.clickonEmployeeDetails();
//	logger.info("clicked on employee details button");
	Assert.assertEquals("http://qualitypointtech.net/timesheetdemo/edit_employee.php", driver.getCurrentUrl());
		System.out.println(driver.getCurrentUrl());
	System.out.println("edit emp details page is displayed"); 
	sc.getScreenshot(driver);
}
@And("^user clicks on edit option$")
public void user_clicks_on_edit_option() throws Throwable {
	emp.clickonEdit();
	
	System.out.println(" edit emp details page is displayed"); 
	sc.getScreenshot(driver);
//	logger.info("username entered");
}

@And("^user update mail id$")
public void user_update_mail_id() throws Throwable {
	emp.typeEmailid(" ");
	emp.typeEmailid("abc@gmail.com");
//	logger.info("updated email address");
	sc.getScreenshot(driver);
	
}

@And("^user clicks on update employee details$")
public void user_clicks_on_update_employee_details() throws Throwable {
	emp.clickonUpdateEmp();
	System.out.println(" Employee Details updated Successfully"); 
	sc.getScreenshot(driver);
//	logger.info("employee details updated");
}

@And("^user clicks on logout$")
public void user_clicks_on_logout() throws Throwable {
	emp.clickonLogout();
	System.out.println(" logout successfully");
	sc.getScreenshot(driver);
//	logger.info("logout sucessful");
}



@Then("^application should be closed$")
public void application_should_be_closed() throws Throwable {
	TimeUnit.SECONDS.sleep(5);
	driver.quit();
//	report.endTest(test);
//	report.flush();
}


}
