package testProjectpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpage {
	
	
	WebDriver driver;
	
	By fullname=By.xpath("//input[@placeholder='Enter your full name']");
	
	By passwd=By.xpath("//input[@placeholder='Enter your password']");
	
	By lgnbtn=By.id("login");
	
	public loginpage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void us_name(String username) {
		driver.findElement(fullname).sendKeys(username);
	}
	public void us_pass(String password) {
		driver.findElement(passwd).sendKeys(password);
	}
	
	public void loginbuton() {
		driver.findElement(lgnbtn).click();
	}

}
