package Selenium_CG_frame.AbstractComponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
@FindBy(css="['routerlink*=cart']")
WebElement cartHeader;
	public void waitForElementToAppear(By findBy) {

    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitElementToDisappear(WebElement ele) {
	  WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
	  wait.until(ExpectedConditions.invisibilityOf(ele));
		
	}
	public void goToCartPage() {
		cartHeader.click();
	}
	
}
