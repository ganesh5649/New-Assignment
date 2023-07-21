package selenium.program;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ECommerce {

    WebDriver driver;
    
   

    @BeforeMethod
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "D://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.amazon.in/log-in/s?k=log+in&captcha_verified=1&ref=nav_ya_signin");
        Thread.sleep(4000);
       
        

        // Replace with the actual URL
    }

    //@AfterMethod
   // public void tearDown() {
    //    driver.quit();
    //}

    @Test
    public void printProductsOnFirstPage() throws InterruptedException {
        // Find the elements containing the product information
        driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
        WebElement login= driver.findElement(By.xpath("//input[@type='email']"));
        login.sendKeys("8975593234");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='continue']")).click();
        WebElement password=driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("Ganesh@5649");
        Thread.sleep(4000);
        driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
        Thread.sleep(4000);
//        WebElement veriCode=driver.findElement(By.xpath("//input[@id='input-box-otp']"));
//        veriCode.sendKeys("215954");
//        Thread.sleep(4000);
//        driver.findElement(By.xpath("//span[@id='cvf-submit-otp-button']")).click();
    	
    	
          WebElement searchProduct=driver.findElement(By.xpath("//input[@type='text']"));
          searchProduct.sendKeys("Mobile");
          Thread.sleep(4000);
          driver.findElement(By.xpath("//input[@type='submit']")).click();
          WebElement selectAllProduct=driver.findElement(By.xpath("(//span[text()='All'])[2]"));
          Thread.sleep(4000);
          selectAllProduct.click();
          
          
          
          List<WebElement> allProductList=driver.findElements(By.xpath("//div[contains(@class,'hmenu')]"));
          for(int i=0; i<allProductList.size(); i++)
          {
        	  WebElement allProductNameList=allProductList.get(i);
        	  Thread.sleep(3000);
        	  String printAllProduct=allProductNameList.getText();
        	  System.out.print(printAllProduct);
          }
          
          driver.findElement(By.xpath("//div[contains(@class,'hmenu-close-icon')]")).click();
          Thread.sleep(3000);
          JavascriptExecutor js= ((JavascriptExecutor)driver);
          js.executeScript("window.scrollBy(0, 500);");
          Thread.sleep(3000);
          driver.findElement(By.xpath("(//span[contains(text(), 'Vivo Y02t (Cosmic Grey, 4GB RAM, 64GB Storage) with No Cost EMI/Additional Exchange Offers')])[2]")).click();
          Thread.sleep(4000);
          
          JavascriptExecutor js1= ((JavascriptExecutor)driver);
          js1.executeScript("window.scrollBy(0,document.body.scrollHeight)");
          Thread.sleep(4000);
          driver.findElement(By.xpath("//input[@value='Add to Cart']")).click();
          Thread.sleep(4000);
          driver.findElement(By.xpath("//span[contains(@class,'attach-cart-button')]")).click();
          Thread.sleep(3000);
          List<WebElement> cartUpdateValue=driver.findElements(By.xpath("//ul[@role='listbox']//li"));
          for(int i=0; i<cartUpdateValue.size(); i++)
          {
        	  WebElement element=cartUpdateValue.get(i);
        	  if(element.equals("3"))
        	  {
        		  element.click();
        		  break;
        	  }
          }
          
          driver.findElement(By.xpath("//span[contains(@class,'nav-cart-count')]")).click();
          driver.findElement(By.xpath("//input[@name='submit.delete.C00ca4684-152b-4399-9a17-5fb3c2080bf7']")).click();
		
          
          
          
        
       

        //driver.findElement(By.xpath("//*[@id='mobile_number']"));
        // Add your code here to complete the printProductsOnFirstPage test step
    }

   // @Test(dependsOnMethods = "printProductsOnFirstPage")
   // public void addProductToCart() {
        // Test Step 4: Add a product to the cart
        // Add your code here to complete the addProductToCart test step
   // }

   // @Test(dependsOnMethods = "addProductToCart")
   // public void updateProductInCart() {
        // Test Step 5: Update a product in the cart
        // Add your code here to complete the updateProductInCart test step
    //}

    //@Test(dependsOnMethods = "updateProductInCart")
    //public void deleteProductFromCart() {
        // Test Step 6: Delete a product from the cart
        // Add your code here to complete the deleteProductFromCart test step
    //}

   // @Test(dependsOnMethods = "deleteProductFromCart")
    //public void logout() {
        // Test Step 7: Logout
        // Add your code here to complete the logout test step
    
}

