package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTest1 {
	@Parameters("Browser")
	@Test
	public void testValidLogin(String browseName) {
		 WebDriver driver=null;
		System.out.println("Parameter name is :"+browseName);
		if(browseName.contains("Chrome")) {
			 driver= new ChromeDriver();
		}else if (browseName.contains("Edge")){
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		
		System.out.println(driver.getTitle());
	//	assert.assertTrue(driver.getTitle().contains("Google")," Title does not match");
		driver.quit();
	}

}
