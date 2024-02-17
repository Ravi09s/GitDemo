package Selenium_CG_frame;

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

import Selenium_CG_frame.pageobject.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAlone {

	public static void main(String[] args) throws InterruptedException {
		
		//String productName="ZARA COAT 3";
		// TODO Auto-generated method stub
    WebDriverManager.edgedriver().setup();
    WebDriver driver=new EdgeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
 
    driver.get("https://rahulshettyacademy.com/client/");
    LandingPage landingPage=new LandingPage(driver);
    driver.manage().window().maximize();
    
    driver.findElement(By.id("userEmail")).sendKeys("esravi013@gmail.com");
    driver.findElement(By.id("userPassword")).sendKeys("ESravi013");
    driver.findElement(By.id("login")).click();
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3 ")));
    
  List<WebElement> products=  driver.findElements(By.cssSelector(".mb-3 "));
  
 WebElement prod= products.stream().filter(product->
    product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
    prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
    
   
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
    wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
    
    driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
    
  List<WebElement> cartProducts= driver.findElements(By.xpath("//*[@class='cartSection']/h3"));
  Boolean match=  cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
  Assert.assertTrue(match);
  
  driver.findElement(By.cssSelector(".totalRow button")).click();
  
  //Actions a= new Actions(driver);
  //a.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "india").build().perform();
 driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("india");
  Thread.sleep(3000);
  
 // wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results:nth-of-type(1)")));
  //driver.findElement(By.xpath("(//span[@class='ng-star-inserted']//i)[2]")).click();
  driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
  driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
  }

}
