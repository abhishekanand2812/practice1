package CheckboxAutomation;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Checkbox {
	WebDriver driver;

	@BeforeTest
	public void setup() {

		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");

	}

	@Test(invocationCount=13)
	public void clickCheckBox() {
		// click on login button
		driver.findElement(By.id("login_Layer")).click();

		// login with the cred
		driver.findElement(By.xpath("//input[@placeholder='Enter your active Email ID / Username']"))
				.sendKeys("abhimechvit@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Chocopie@12");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// goto jobs link
		driver.findElement(By.xpath("//div[text()='Jobs']")).click();

		// click on chckbox
		List<WebElement> chckboxList = driver
				.findElements(By.xpath("//div[@class='dspIB saveJobContainer tuple-check-box']"));
		int count = 0;
		for (WebElement e : chckboxList) {
			e.click();
			count++;
			if (count == 5) {
				break;
			}

		}

		// click on apply
		driver.findElement(By.xpath("//button[@class='multi-apply-button typ-16Bold ']")).click();
	}

	@AfterTest
	public void closeBrowser() {
		driver.quit();
	}

}
