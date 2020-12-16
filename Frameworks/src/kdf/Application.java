package kdf;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;


import utils.GenericMethods;

public class Application {
	
	@Test
	public void invalidLoginTest() throws IOException {
		String[][] data = GenericMethods.getData("D:\\SelNov25\\TestData.xlsx", "Sheet2");
		Methods mtd = new Methods();
		for(int i = 1;i<data.length;i++) {
			switch(data[i][3]) {
			case "openBrowser":
				mtd.openBrowser();
				break;
			case "maxBrowser":
				mtd.maximizeBrowserWindow();
				break;
			case "impWait":
				mtd.ImplementimplicitWait();
				break;
			case "navigateToApp":
				mtd.navigateToApplication(data[i][6]);
				break;
			case "enterInTextBox":
				mtd.enterInEditBox(data[i][5], data[i][6]);
				break;
			case "clickButton":
				mtd.clickAButton(data[i][4],data[i][5]);
				break;
			case "verifyErrMsg":
				String actualMsg = mtd.getErrorMsg(data[i][4],data[i][5]);
				String expectedMsg = data[i][6];
				Assert.assertEquals(expectedMsg, actualMsg);
				break;
			case "closeApp":
				mtd.closeApplicationWindow();
			}
		}
	}

}
