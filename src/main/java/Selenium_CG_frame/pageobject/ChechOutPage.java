package Selenium_CG_frame.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium_CG_frame.AbstractComponent.AbstractComponent;

public class ChechOutPage extends AbstractComponent{
  WebDriver driver;
	public ChechOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	@FindBy(xpath="//*[@class='actions']/a")
	WebElement submit;
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement county;
	
	
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	By results=By.cssSelector(".ta-results");
	
	public void selectCountry(String countryName) {
		Actions a= new Actions(driver);
		a.sendKeys(county, countryName).build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}
	
	public void submitOrder() {
		submit.click();
	}
	
	

}
