package DemoQA;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfirmAlert {
	WebDriver driver;
	Properties prop=new Properties();
	@Test
public void confirmAlert() {
		try {
	
	JavascriptExecutor j = (JavascriptExecutor) driver;
	WebElement alert = driver.findElement(By.xpath(prop.getProperty("alert")));
	j.executeScript(prop.getProperty("args"), alert);
	alert.click();
	driver.findElement(By.xpath(prop.getProperty("alertButton"))).click();
	driver.getPageSource().contains("Alerts");
	driver.findElement(By.xpath(prop.getProperty("confirmAlert"))).click();
	Alert a1 = driver.switchTo().alert();
	a1.accept();
	driver.findElement(By.xpath(prop.getProperty("confirmResult"))).isDisplayed();
	
		}catch(Exception e) {
			System.out.println(e);
		}
}
	@BeforeMethod
	public void beforeMethod() throws IOException{
		try {
		FileInputStream input = new FileInputStream("C:\\Users\\Admin\\Desktop\\ExcelrDemoQAProject-2\\src\\test\\resources\\Properties\\ConfirmAlert.properties");
		prop.load(input);
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

}
