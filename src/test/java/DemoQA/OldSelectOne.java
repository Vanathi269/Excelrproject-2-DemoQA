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
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OldSelectOne {
	WebDriver driver;
	Properties prop=new Properties();
	@Test
public void oldSelectOne() {
		try {
			JavascriptExecutor j = (JavascriptExecutor) driver;
			WebElement alert = driver.findElement(By.xpath(prop.getProperty("widgets")));
			j.executeScript(prop.getProperty("args"), alert);
			alert.click();
			driver.findElement(By.xpath(prop.getProperty("menu"))).click();
			Select select = new Select(driver.findElement(By.id(prop.getProperty("select"))));
			select.selectByIndex(4);
			driver.quit();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
@BeforeMethod
public void beforeMethod() throws IOException{
			try {
			FileInputStream input = new FileInputStream("C:\\Users\\Admin\\Desktop\\ExcelrDemoQAProject-2\\src\\test\\resources\\Properties\\OldSelectOne.properties");
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
			driver.quit();
		}

}


