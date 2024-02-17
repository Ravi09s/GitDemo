package Selenium_CG_frame.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium_CG_frame.AbstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent {
	
WebDriver driver;

public LandingPage(WebDriver driver) {
	
	super(driver);
	//initialization
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
 @FindBy(id="userEmail")
 WebElement userEmail;
 
 @FindBy(id="userPassword")
 WebElement passwordEls;
 
 @FindBy(id="login")
 WebElement submit;
 
 public void loginPage(String email,String password) {
	 userEmail.sendKeys(email);
	 passwordEls.sendKeys(password);
	 submit.click();
 }
 public void goTo() {
	 
	 driver.get("https://rahulshettyacademy.com/client/");
	 
 }
	

}
