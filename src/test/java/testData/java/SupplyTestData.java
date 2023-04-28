package testData.java;

import org.testng.annotations.DataProvider;

public class SupplyTestData {
	
@DataProvider(name ="NinjaTDataProviderSupply")

public static Object[][] datasupplyfrom2dimensialobjectArrays() {
	Object[][] data = {{"shumaila383@gmail.com","Love0774"},
			{"seleniumpanda@ninjatutorial.com","Selenium"}
	};
	return data;
	
}
	}
