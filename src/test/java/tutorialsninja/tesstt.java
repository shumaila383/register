package tutorialsninja;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.Utilities.Tutrial.Utilities;

public class tesstt {
	
	@Test(priority=1)
	public void MandatoryFieldsRegisterAccountPageAcceptingOnlySpaces() {
		WebDriver driver;
		
		ChromeOptions options = new ChromeOptions();
		options = new ChromeOptions();
		options.addArguments("--star-maximized");
	options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.impliWaitTime));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.pageLoadime));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utilities.scriptTime));
		
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.name("firstname")). sendKeys("ksjfkdhsafjhasf");
//		driver.findElement(By.name("lastname")). sendKeys(prop.getProperty("OnlySpaces1"));
//		driver.findElement(By.name("email")). sendKeys(prop.getProperty("OnlySpaces1"));
//		driver.findElement(By.name("telephone")).sendKeys(prop.getProperty("OnlySpaces1"));
//		driver.findElement(By.name("password")). sendKeys(prop.getProperty("OnlySpaces1"));
//		driver.findElement(By.name("confirm")). sendKeys(prop.getProperty("OnlySpaces1"));
//		driver.findElement(By.name("agree")). click();
//		driver.findElement(By.cssSelector("input.btn.btn-primary")). click();

	}



}
