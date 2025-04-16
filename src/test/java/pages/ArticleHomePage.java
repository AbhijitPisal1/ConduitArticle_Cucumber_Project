package pages;

import java.util.List;

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
	
	@FindBy(xpath = "//button[@class='nav-link active']")
	WebElement ActiveFeed;
	
	@FindAll(value = @FindBy(xpath = "//a[@class='preview-link']//h1"))
	List<WebElement> Articles;
	
	@FindBy(css = "img.user-pic")
	WebElement UserProfile;
	
	@FindBy(xpath = "//i[@class='ion-log-out']")
	WebElement logOutBtn;
	
	// initialize constructor using page factory
	public ArticleHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	// click on create new article link
	public void createNewArticle() {
		newArt.click();
	}
	
	// click on home icon to return to home page
	public void NavigateHome() {
		homeIcon.click();
	}
	
	// Opens the public feed section
	public void OpenPublicFeed() {
		ListAll.click();
	}
	
	// check if create new article option is present
	public boolean CreateNewArticleisDisplayed() {
		if(newArt.isDisplayed())
			return true;
		else
			return false;
	}
	
	// Verifies if article is present in global feed and opens it
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
    
	// checks if global feed section is opened
	public boolean checkIfGlobalFeedOpened(String strMsg) {
    	if(ActiveFeed.getText().equals(strMsg))
    		return true;
		else
			return false;
    }
	
	public void userLogout() {
		UserProfile.click();
		logOutBtn.click();
		
	}
}
