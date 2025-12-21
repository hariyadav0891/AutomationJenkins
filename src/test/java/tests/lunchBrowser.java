package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class lunchBrowser {
	
	//@Test
	public void setup() {
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.google.com");
		
		String baseTitlr=driver.getTitle();
		
		WebElement searchbox = driver.findElement(By.xpath("//textarea[@name='q']"));
		searchbox.click();
		
		searchbox.sendKeys("Selenium Automation"+ Keys.ENTER);
		
		System.out.println("Title is : "+baseTitlr);
	}

}
