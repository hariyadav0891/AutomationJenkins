package tests;

import java.io.File;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.Login_Page;

public class LoginTest extends BaseTest {
	
	@Test
	public void testValidLogin() {
		
		Login_Page loginpage= new Login_Page(driver);
		
		loginpage.enterUserName("admin@yourstore.com");
		loginpage.enterpassword("admin");
		loginpage.clickLogin();
		
		//System.out.println("Title of the page is :- "+driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Just a moment...");
		
		Wait<WebDriver> wait = new FluentWait<>(driver)
		        .withTimeout(Duration.ofSeconds(15))
		        .pollingEvery(Duration.ofMillis(500))
		        .ignoring(NoSuchElementException.class)
		        .ignoring(StaleElementReferenceException.class);

//		WebElement loginBtn = wait.until(driver -> driver.findElement(By.id("loginBtn")));
//		loginBtn.click();
		
		File dest = new File("screenshots/page.png");
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
	}

}
