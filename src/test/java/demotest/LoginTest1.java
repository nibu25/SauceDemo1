package demotest;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class LoginTest1 {
  WebDriver driver;
  @BeforeTest
  public void beforeTest() {
	  //pre conditions
	  WebDriverManager.chromedriver().clearDriverCache();
	  WebDriverManager.chromedriver().clearResolutionCache();
	  WebDriverManager.chromedriver().setup();
	  driver= new ChromeDriver();
	  
	  //open site
	  
	  driver.get("https://www.saucedemo.com/");
	  driver.manage().window().maximize();
	  
  }
  
  @Test
  public void Test_valid_Login() {
	  driver.findElement(By.id("user-name")).sendKeys(" standard_user");
	  driver.findElement(By.id("password")).sendKeys("secret_sauce");
	  driver.findElement(By.id("login-button")).click();
	  
	  String expected="https://www.saucedemo.com/inventory.html";
	  String actual=driver.getCurrentUrl();
	  Assert.assertEquals(expected, actual);

  }

  @AfterTest
  public void afterTest() {
	  //post conditions
	  driver.close();
  }

}
