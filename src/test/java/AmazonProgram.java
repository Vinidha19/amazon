import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonProgram {
	static WebDriver driver;
	static long startTime;
	@BeforeClass
	public static void BrowserLaunch() throws Exception{
		System.out.println("Launch Method");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vinidhapalanivel\\eclipse-workspace\\AmazonBase\\driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	@Before
	public void beforemethod() {
		System.out.println("BeforeMethod");
		startTime = System.currentTimeMillis();
	}
	@After
	public void aftermethod() {
		System.out.println("Aftermethod");
		long endTime = System.currentTimeMillis();
		System.out.println("Time Taken is :"+(endTime-startTime));
	}
	@AfterClass
	public static void browserquit() {
		System.out.println("Browserquit");
		}
	@Test
	public void method1() {
		WebElement search=driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("lg tv 55 inch",Keys.ENTER);
		WebElement Choose=driver.findElement(By.xpath("//div[contains(@class,'small s-title-instructions-style')]"));
		Choose.click();
	}
	@Test
	public void method3() throws IOException {
		TakesScreenshot screenshot=(TakesScreenshot)driver;
		File source=screenshot.getScreenshotAs(OutputType.FILE);
		File target=new File("C:\\Users\\Vinidhapalanivel\\eclipse-workspace\\AmazonBase\\target\\fk.png");
		FileUtils.copyFile(source,target);
	}
}
