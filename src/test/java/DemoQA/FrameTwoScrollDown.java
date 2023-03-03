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

public class FrameTwoScrollDown {
	WebDriver driver;
	Properties prop=new Properties();
	@Test
public void scrollDown() {
	try {
	JavascriptExecutor j = (JavascriptExecutor) driver;
	WebElement alert = driver.findElement(By.xpath(prop.getProperty("alerts")));
	j.executeScript(prop.getProperty("args"), alert);
	alert.click();
	WebElement frames=driver.findElement(By.xpath(prop.getProperty("frame")));
	frames.click();
	driver.getPageSource().contains(prop.getProperty("Frames"));
	
	//verifying the frame display
	
	WebElement frames1=driver.findElement(By.xpath(prop.getProperty("frameOne")));
	frames1.isDisplayed();
	WebElement frames2=driver.findElement(By.xpath(prop.getProperty("frameTwo")));
	frames2.isDisplayed();
	driver.switchTo().frame("frame2");
	JavascriptExecutor js=(JavascriptExecutor) driver;
	js.executeScript("scroll");
	driver.quit();
	}catch(Exception e) {
		System.out.println(e);
	}
	

}
	@BeforeMethod
public void beforeMethod() throws IOException{
	try {
	FileInputStream input = new FileInputStream("C:\\Users\\Admin\\Desktop\\ExcelrDemoQAProject-2\\src\\test\\resources\\Properties\\FrameToScrollDown.properties");
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
