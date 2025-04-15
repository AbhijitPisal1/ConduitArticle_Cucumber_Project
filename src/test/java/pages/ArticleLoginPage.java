package pages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ArticleLoginPage {
	
	@FindBy(name = "email")
	WebElement emailInput;

	@FindBy(name = "password")
	WebElement pwd;
	
	@FindBy(className = "btn-primary")
	WebElement loginbtn;
	
	@FindBy(xpath = "//ul[@class='error-messages']//li")
	WebElement ErrorMsg;
	//constructor to initialize
	public ArticleLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// Action
	public void loginIntoApp(String strUser, String strpwd) {
		emailInput.clear();
		emailInput.sendKeys(strUser);
		pwd.clear();
		pwd.sendKeys(strpwd);
		loginbtn.click();
	}
	
	public void ExpectedError(String expectedMsg) throws InterruptedException {
		Thread.sleep(3000);
		String actMsg = ErrorMsg.getText();
		assertTrue(actMsg.contains(expectedMsg));
		
		
	}
}
