package DemoQA;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewMessage {
	WebDriver driver;
	Properties prop=new Properties();
	@Test
public void newMessage() {
		try {
	String parent=driver.getWindowHandle();
	JavascriptExecutor j = (JavascriptExecutor) driver;
	WebElement alert = driver.findElement(By.xpath(prop.getProperty("alerts")));
	j.executeScript(prop.getProperty("agrs"), alert);
	alert.click();
	driver.findElement(By.xpath(prop.getProperty("browser"))).click();
	driver.getPageSource().contains(prop.getProperty("browserContent"));
	WebElement button=driver.findElement(By.xpath(prop.getProperty("newWindow")));
	Set<String>  s= driver.getWindowHandles();
	button.click();
	driver.getPageSource().contains(prop.getProperty("content"));
	driver.switchTo().window(parent);
		}catch(Exception e) {
			System.out.println(e);
		}

}
	@BeforeMethod
	public void beforeMethod() throws IOException{
		try {
		FileInputStream input = new FileInputStream("C:\\Users\\Admin\\Desktop\\ExcelrDemoQAProject-2\\src\\test\\resources\\Properties\\NewMessage.properties");
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
