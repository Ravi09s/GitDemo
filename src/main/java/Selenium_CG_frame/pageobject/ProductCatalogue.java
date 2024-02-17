package Selenium_CG_frame.pageobject;

import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Selenium_CG_frame.AbstractComponent.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	
WebDriver driver;

public ProductCatalogue(WebDriver driver) {
	//initialization
	super(driver);
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
//List<WebElement> products=  driver.findElements(By.cssSelector(".mb-3 "));

 @FindBy(css=".mb-3")
List <WebElement> products;
 
 @FindBy(css=".ng-animating")
 WebElement spinner;
 
 By productsBy=By.cssSelector(".mb-3");
 By addToCart=By.cssSelector(".card-body button:last-of-type");
 By toast=By.cssSelector("#toast-container");

public Collection<WebElement> getProductByName;
 
 public List<WebElement> getProductList() {
	 waitForElementToAppear(productsBy);
	 return products;
 }
 
 public WebElement getProductByName(String productName) {
	 WebElement prod= getProductByName.stream().filter(product->
	    product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
	 return prod;
 }
 public void addProductToCart(String productName ) {
	WebElement prod= getProductByName(productName);
	 prod.findElement(addToCart).click();
	 waitForElementToAppear(toast);
	 waitElementToDisappear(spinner);
 }


 
 
 
	

}
