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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ToolTip {
	WebDriver driver;
	Properties prop=new Properties();
	@Test
public void toolTip() {
	try {
	JavascriptExecutor j = (JavascriptExecutor) driver;
	WebElement alert = driver.findElement(By.xpath(prop.getProperty("widgets")));
	j.executeScript(prop.getProperty("args"), alert);
	alert.click();
	WebElement tool=driver.findElement(By.xpath(prop.getProperty("tool")));
	tool.click();
	Actions actions = new Actions(driver);
    WebElement hover = driver.findElement(By.xpath(prop.getProperty("hover")));
    actions.moveToElement(hover).perform();
    driver.quit();
	}catch(Exception e) {
		System.out.println(e);
	}
}
	@BeforeMethod
	public void beforeMethod() throws IOException{
		try {
		FileInputStream input = new FileInputStream("C:\\Users\\Admin\\Desktop\\ExcelrDemoQAProject-2\\src\\test\\resources\\Properties\\ToolTip.properties");
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
