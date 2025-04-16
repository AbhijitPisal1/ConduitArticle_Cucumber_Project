package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	// clear any existing text and enter details
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
	
	// if form is opened then an input field for title should be displayed
	public boolean NewArtilceFormIsOpened() {
		if(TitleField.isDisplayed())
			return true;
		else
			return false;
	}
	
	// click on submit button to complete form filling
	public void SubmitInfo() {
		submitBtn.click();
	}
	
}
