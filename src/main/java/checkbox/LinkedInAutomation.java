package checkbox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LinkedInAutomation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20000));

		driver.get("https://www.linkedin.com/login");

		wait.until(ExpectedConditions.urlContains("login"));

		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
		username.sendKeys("abhimechvit@gmail.com");

		driver.findElement(By.id("password")).sendKeys("Chocopie@12");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

	}

}
