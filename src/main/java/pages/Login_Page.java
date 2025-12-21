package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page {

	private WebDriver driver;
	private By userNameTextBox = By.id("Email");
	private By userPasswordTextBox = By.id("Password");
	private By loginButton = By.xpath("//button[contains(text(),'Log in')]");

	public Login_Page(WebDriver driver) {
		this.driver = driver;
	}

	public void enterUserName(String username) {
		driver.findElement(userNameTextBox).clear();
		driver.findElement(userNameTextBox).sendKeys(username);;
	}

	public void enterpassword(String password) {
		driver.findElement(userPasswordTextBox).clear();
		driver.findElement(userPasswordTextBox).sendKeys(password);;
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}
}
