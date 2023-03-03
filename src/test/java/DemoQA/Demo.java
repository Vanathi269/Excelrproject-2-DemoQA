package DemoQA;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo {
	WebDriver driver;
	Properties prop=new Properties();
	@Test	
public void demo() {
		try {
		JavascriptExecutor j = (JavascriptExecutor) driver;
		WebElement alerts = driver.findElement(By.xpath(prop.getProperty("alerts")));
		j.executeScript(prop.getProperty("args"), alerts);
		alerts.click();
		driver.findElement(By.className(prop.getProperty("header")));
		driver.findElement(By.xpath(prop.getProperty("practice")));
		}catch(Exception e) {
			System.out.println(e);
		}
}
	@BeforeMethod
	public void beforeMethod() throws IOException{
		try {
		FileInputStream input = new FileInputStream("C:\\Users\\Admin\\Desktop\\ExcelrDemoQAProject-2\\src\\test\\resources\\Properties\\Demo.properties");
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
