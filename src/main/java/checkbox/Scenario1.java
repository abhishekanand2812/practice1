package checkbox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Scenario1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com/");

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

}
