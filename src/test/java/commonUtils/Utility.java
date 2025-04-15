package commonUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Utility {

	public static String getScreenshotPath(WebDriver driver) {
		TakesScreenshot screen = (TakesScreenshot)driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String srcFile = System.getProperty("user.dir")
				+"/screenshots/"
				+System.currentTimeMillis()
				+".png";
		File dest = new File(srcFile);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return srcFile;
	}
	
	public static void HandleAlert (WebDriver driver, String StrMsg) throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		System.out.println(alert.getText());
		Assert.assertEquals(alert.getText(), StrMsg); 
		alert.accept();
		Thread.sleep(2000);
		
	}
}
