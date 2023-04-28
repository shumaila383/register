package tutorialsninja;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.Tutrial.QA.TestBase.TestBase;

import testData.java.SupplyTestData;

public class Register_TestCases_Part3 extends TestBase{
	public Register_TestCases_Part3() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	WebDriver driver;
	SoftAssert softassert;
	
	
	
//	@BeforeMethod
//	public void setup() {
//		driver =	initializeBrowserAndOpenApplication(prop.getProperty("browserName"));
//		driver.get("https://tutorialsninja.com/demo/");
//		
//		
//		
//		
//		//driver.findElement(By.cssSelector("span.caret")).click();
//	//	driver.findElement(By.xpath("//li[@class='dropdown open']/descendant::ul/descendant::a[1]")).click();
//	
//	
//	}
	
	
	
@Test(priority=1)
public void MandatoryFieldsRegisterAccountPageAcceptingOnlySpaces() {
	
	
	driver.get("https://tutorialsninja.com/demo/");
	
	driver.findElement(By.name("firstname")). sendKeys(prop.getProperty("OnlySpaces1"));
	driver.findElement(By.name("lastname")). sendKeys(prop.getProperty("OnlySpaces1"));
	driver.findElement(By.name("email")). sendKeys(prop.getProperty("OnlySpaces1"));
	driver.findElement(By.name("telephone")).sendKeys(prop.getProperty("OnlySpaces1"));
	driver.findElement(By.name("password")). sendKeys(prop.getProperty("OnlySpaces1"));
	driver.findElement(By.name("confirm")). sendKeys(prop.getProperty("OnlySpaces1"));
	driver.findElement(By.name("agree")). click();
	driver.findElement(By.cssSelector("input.btn.btn-primary")). click();

}
@Test(priority=2)
public void PasswordFieldsInRegisterAccountPageFollowingPasswordComplexityStandards() {
	
	driver.findElement(By.name("firstname")). sendKeys(prop.getProperty("firstName"));
	driver.findElement(By.name("lastname")). sendKeys(prop.getProperty("lastName"));
	driver.findElement(By.name("email")). sendKeys(prop.getProperty("email"));
	driver.findElement(By.name("telephone")).sendKeys(prop.getProperty("phoneNumber"));
	driver.findElement(By.name("password")). sendKeys(prop.getProperty(dataprop.getProperty("password")));
	driver.findElement(By.name("confirm")). sendKeys(dataprop.getProperty("confromPassword"));
	driver.findElement(By.name("agree")). click();
	driver.findElement(By.cssSelector("input.btn.btn-primary")). click();
	String actualWarningMessage = driver.findElement(By.className("text-danger")).getText();
	String ExpectedWarningMessage = "Password must be between 4 and 20 characters!";
	softassert.assertTrue(actualWarningMessage.contains(ExpectedWarningMessage), "warning messageis not correct");
	softassert.assertAll();
	
	}

@Test(priority=3)
public void VerifyWhetherTheLeadingTrailingSpacesEnteredIntoTheRegisterAccountFieldsareTrimmed() {
	
	driver.findElement(By.name("firstname")). sendKeys(prop.getProperty("firstName"));
	driver.findElement(By.name("lastname")). sendKeys(prop.getProperty("lastName"));
	driver.findElement(By.name("email")). sendKeys(prop.getProperty("email"));
	driver.findElement(By.name("telephone")).sendKeys(dataprop.getProperty("phoneNumberWithSpace"));
	driver.findElement(By.name("password")). sendKeys(prop.getProperty("ValidPassword"));
	driver.findElement(By.name("confirm")). sendKeys(prop.getProperty("ValidConfirmPassword"));
	driver.findElement(By.name("agree")). click();
	driver.findElement(By.cssSelector("input.btn.btn-primary")). click();
	softassert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/child::h1")).isDisplayed());
	softassert.assertAll();
	
			}
@Test(priority=4)
public void VerifyWhetherThePrivacyPolicyCheckboxOptionIsNotSelectedByDefault() {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--star-maximized");
options.addArguments("--remote-allow-origins=*");
	WebDriver driver = new ChromeDriver(options);
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(100));
	driver.get("https://tutorialsninja.com/demo/index.php?route=account/register");
	
}

@Test(priority=5)
public void VerifyzRegisteringtheAccountwWithoutSelectingThePrivacyPolicyCheckboxOption() {
	
	driver.findElement(By.name("firstname")). sendKeys(prop.getProperty("firstName"));
	driver.findElement(By.name("lastname")). sendKeys(prop.getProperty("lastName"));
	driver.findElement(By.name("email")). sendKeys(prop.getProperty("email"));
	driver.findElement(By.name("telephone")).sendKeys(prop.getProperty(prop.getProperty("phoneNumber")));
	driver.findElement(By.name("password")). sendKeys(prop.getProperty("ValidPassword"));
	driver.findElement(By.name("confirm")). sendKeys(prop.getProperty("ValidConfirmPassword"));
	driver.findElement(By.cssSelector("input.btn.btn-primary")). click();
	String actualWarningMessage = driver.findElement(By.cssSelector("div.alert.alert-danger.alert-dismissible")).getText();
	String ExpectedWarningMessage = "Warning: You must agree to the Privacy Policy!";
	softassert.assertTrue(actualWarningMessage.contains(ExpectedWarningMessage), "warning messageis not correct");
	softassert.assertAll();
	
	}
//@AfterMethod
//public void tearDown() {
//	driver.quit();
//}
}
