package pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.utility.RandomString;

public class ArticleEditPage {
	
	@FindBy(name = "title")
	WebElement TitleField;
	
	@FindBy(xpath = "//input[@name='description']")
	WebElement DescField;
	
	@FindBy(xpath = "//textarea[@name='body']")
	WebElement BodyField;
	
	@FindBy(name = "tags")
	WebElement tagField;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitBtn;
	
	

	public ArticleEditPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void EnterTitleDetails(String strTitle) {
		TitleField.clear();
		TitleField.sendKeys(strTitle);
	}
	public void EnterDescDetails(String strDesc) {
		DescField.clear();
		DescField.sendKeys(strDesc);
	}
	public void EnterContentDetails(String strContent) {
		BodyField.clear();
		BodyField.sendKeys(strContent);
	}
	public void EnterTagDetails(String strTag) {
		tagField.clear();
		tagField.sendKeys(strTag);
	}
	
	public boolean NewArtilceFormIsOpened() {
		if(TitleField.isDisplayed())
			return true;
		else
			return false;
	}
	
	public void SubmitInfo() {
		submitBtn.click();
	}
	
}
