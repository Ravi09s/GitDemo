package Selenium_CG_frame;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Selenium_CG_frame.TestComponents.BaseTest;
import Selenium_CG_frame.pageobject.LandingPage;
import Selenium_CG_frame.pageobject.ProductCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest extends BaseTest {

	@Test 
	public void submitOrder() throws IOException
	{
		
		//String productName="ZARA COAT 3";
		// TODO Auto-generated method stub
		launchApplication();
    WebDriverManager.edgedriver().setup();
    WebDriver driver=new EdgeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 
    
    LandingPage landingPage=new LandingPage(driver);
    landingPage.goTo();
    landingPage.loginPage("esravi013@gmail.com", "ESravi013");
    ProductCatalogue productCatalogue=new ProductCatalogue(driver);
  List<WebElement>products= productCatalogue.getProductList();
	
	productCatalogue.addProductToCart("ZARA COAT 3");
	
	productCatalogue.goToCartPage();
	
   
  
 WebElement prod= products.stream().filter(product->
    product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
    prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
    
   
    
    driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
    
  List<WebElement> cartProducts= driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
  Boolean match=  cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
  Assert.assertTrue(match);
  
  driver.findElement(By.cssSelector(".totalRow button")).click();
  
  Actions a= new Actions(driver);
  a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
  
 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results:nth-of-type(1)")));
  driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
  driver.findElement(By.xpath("//*[@class='actions']/a")).click();
  }

}
