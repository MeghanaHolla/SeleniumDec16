package kdf;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Methods {

	WebDriver driver;
	
	public void openBrowser() {
		driver = new ChromeDriver();
	}
	
	public void maximizeBrowserWindow() {
		driver.manage().window().maximize();
	}
	
	public void ImplementimplicitWait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	public void navigateToApplication(String url) {
		driver.get(url);
	}
	
	public void enterInEditBox(String locValue,String value) {
		driver.findElement(By.id(locValue)).sendKeys(value);
	}
	
	public void clickAButton(String loc, String locValue) {
		if(loc.equals("name")) {
			driver.findElement(By.name(locValue)).click();
		}
		else if(loc.equals("xPath")) {
			driver.findElement(By.xpath(locValue)).click();
		}
	}
	
	public String getErrorMsg(String loc, String locValue) {
		String actualText = null;
		if(loc.equals("cssSelector")) {
			actualText = driver.findElement(By.cssSelector(locValue)).getText();
		}
		else if(loc.equals("id")) {
			actualText = driver.findElement(By.id(locValue)).getText();
		}
		return actualText;
	}
	
	public void closeApplicationWindow() {
		driver.close();
	}
}
