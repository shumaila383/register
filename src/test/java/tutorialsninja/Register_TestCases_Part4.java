package tutorialsninja;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Tutrial.QA.TestBase.TestBase;


public class Register_TestCases_Part4 extends TestBase{
	public Register_TestCases_Part4() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	WebDriver driver;
	SoftAssert softassert;
	
	@BeforeMethod
	public void SetUp() {
	driver =	initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
		driver.findElement(By.cssSelector("span.caret")).click();
		driver.findElement(By.xpath("//li[@class='dropdown open']/descendant::ul/descendant::a[1]")).click();
	}
	
	
	
	@Test(priority=1)
	public void VerifythePasswordTextEnteredIntoThePasswordAndPasswordConfirmFieldOfRegisterAccountFunctionalityIsToggledToHideItsVisibility() throws InterruptedException {
		
		Thread.sleep(4000);
		driver.findElement(By.name("password")). sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.name("confirm")). sendKeys(prop.getProperty("ValidConfirmPassword"));
		Thread.sleep(4000);
		
	}
	
	@Test(priority=2)
	public void VerifyNavigatingOtherPageUsingTheOptionsOrLinksProvidedOnTheRegisterAccountPage () throws InterruptedException {
	
		driver.findElement(By.cssSelector("span.caret")).click();
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(4000);
		
}
	
	@Test(priority=3)
	public void VerifyRegistringAccountbyFillingPasswordFieldAndNotFillingPasswordConfirmField() {
	
		driver.findElement(By.name("firstname")). sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.name("lastname")). sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.name("email")). sendKeys(prop.getProperty("email"));
		driver.findElement(By.name("telephone")).sendKeys(prop.getProperty("phoneNumber"));
		driver.findElement(By.name("password")). sendKeys(prop.getProperty("ValidPassword"));
		driver.findElement(By.name("confirm")). sendKeys("");
		driver.findElement(By.name("agree")). click();
		driver.findElement(By.cssSelector("input.btn.btn-primary")). click();
		String actualWarningMessage = driver.findElement(By.cssSelector("div.text-danger")).getText();
		String ExpectedWarningMessage = "Password confirmation does not match password!";
		softassert.assertTrue(actualWarningMessage.contains(ExpectedWarningMessage), "warning messageis not correct");
		softassert.assertAll();
		

			
		}
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
}}