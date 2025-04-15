package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ArticleHomePage {

	@FindBy(xpath = "//a[@href='#/editor']")
	WebElement newArt;
	
	@FindBy(linkText = "Home")
	WebElement homeIcon;
	
	@FindBy(xpath = "(//li[@class='nav-item']//button)[2]")
	WebElement ListAll;
		
	@FindAll(value = @FindBy(xpath = "//a[@class='preview-link']//h1"))
	List<WebElement> Articles;
	
	// initialize constructor using pagefactory
	public ArticleHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// add items
	public void createNewArticle() {
		newArt.click();
	}
	
	public void NavigateHome() {
		homeIcon.click();
	}
	
	public void OpenPublicFeed() {
		ListAll.click();
	}
			
	public boolean CreateNewArticleisDisplayed() {
		if(newArt.isDisplayed())
			return true;
		else
			return false;
	}
		
  
    public void clickArticleWithTitle(String title) {
        // Loop through the list of elements
        for (WebElement article : Articles) {
        	System.out.println("Article text: " + article.getText());
            // If the article's text matches the passed title, click it
            if (article.getText().contains(title)) {
                article.click();
                break; // Exit loop once we find the correct article
            }
        }
        
    }
    
}
