package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticleInfoPage {
	
	@FindBy(css = "div.article-content > div > p")
	WebElement descField;
	
	@FindBy(className = "container")
	WebElement bannerElement;
	
	@FindBy(className = "ion-edit")
	WebElement EditBtn;
	
	@FindBy(className = "ion-trash-a")
	WebElement DelBtn;
	
	public ArticleInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean checkArticleContentIsCorrect(String strDesc) {	
		if(descField.getText().equals(strDesc))
			return true;
		else
			return false;
	}
	
	
	public boolean checkEditbtnIsDisplayed() {	
		if(EditBtn.isDisplayed())
			return true;
		else
			return false;
	}
	
	public void EditArticle() {
		EditBtn.click();
	}
	public void deleteArticle() {
		DelBtn.click();
	}
	
	public void descinfo() {
		System.out.println("description is: " + descField.getText());
	}
}



