package com.Tutrial.QA.TestBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Utilities.Tutrial.Utilities;

public class TestBase {
	
	public WebDriver driver;
	public Properties prop;
	public Properties dataprop;
	public 	FileInputStream ip;
	public TestBase() throws IOException {
		Properties prop = new Properties();
		ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\Tutrial\\Config\\config.properties");
prop.load(ip);

dataprop = new Properties();
ip = new FileInputStream(System.getProperty("user.dir" + "\\src\\test\\java\\testData\\java\\testData.properties"));
dataprop.load(ip);
	}
	
	public WebDriver initializeBrowserAndOpenApplication(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();	
		}
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--star-maximized");
	options.addArguments("--remote-allow-origins=*");
		 driver = new ChromeDriver(options);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.impliWaitTime));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.pageLoadime));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Utilities.scriptTime));
		driver.get(prop.getProperty("url"));
		return driver;
	}

}
