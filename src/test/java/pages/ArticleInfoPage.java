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
	
	// check if the article content of displayed article is matching
	public boolean checkArticleContentIsCorrect(String strDesc) {	
		if(descField.getText().equals(strDesc))
			return true;
		else
			return false;
	}
	
	// checks if the edit button is displayed i.e. check for if article details are displayed
	public boolean checkEditbtnIsDisplayed() {	
		if(EditBtn.isDisplayed())
			return true;
		else
			return false;
	}
	
	// click on edit button
	public void EditArticle() {
		EditBtn.click();
	}
	
	// click on delete button
	public void deleteArticle() {
		DelBtn.click();
	}
}



