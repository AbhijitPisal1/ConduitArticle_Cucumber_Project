package stepDefs;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.TestBase;
import commonUtils.Utility;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ArticleEditPage;
import pages.ArticleHomePage;
import pages.ArticleInfoPage;
import pages.ArticleLoginPage;


public class stepDefs {
	WebDriver driver = TestBase.getDriver();
	ArticleLoginPage loginPage;
	ArticleHomePage homepage;
	ArticleEditPage editPage;
	ArticleInfoPage infoPage;
	
	public stepDefs() {
		loginPage = new ArticleLoginPage(driver);
		homepage = new ArticleHomePage(driver);
		editPage = new ArticleEditPage(driver);
		infoPage = new ArticleInfoPage(driver);
	}
	
	
	@Given("User is on Login Page")
	public void user_is_on_login_page() {
		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/login");
	    
	}
	
	@When("User Provide {string} and {string}")
	public void user_provide_and(String strUser, String strPwd) {
		loginPage.loginIntoApp(strUser, strPwd);
	    
	}
	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() {
		Assert.assertTrue(homepage.CreateNewArticleisDisplayed());
		
	}
	
	
	@Given("User should be on New Article Page")
	public void user_should_be_on_new_article_page() {
		homepage.createNewArticle();
		Assert.assertTrue(editPage.NewArtilceFormIsOpened());    
	}
	@When("User enters Article Details")
	public void user_enters_article_details(DataTable userData) {
		List<Map<String, String>> data = userData.asMaps();
		String Strtitle = data.get(0).get("title");
		String strDesc = data.get(0).get("Desc");
		String strContent = data.get(0).get("Content");
		String strtag = data.get(0).get("tag");
		
		editPage.EnterTitleDetails(Strtitle);
		editPage.EnterDescDetails(strDesc);
		editPage.EnterContentDetails(strContent);
		editPage.EnterTagDetails(strtag);
		editPage.SubmitInfo();
	}
	@Then("Article must be created")
	public void article_must_be_created(DataTable userData) {
		List<List<String>> data = userData.asLists();
		String strMsg = data.get(0).get(0);
		Assert.assertTrue(infoPage.checkArticleContentIsCorrect(strMsg));
		homepage.NavigateHome();
	}
	
	
	@Given("User should be on Global Feed Page")
	public void user_should_be_on_global_feed_page() {
		homepage.OpenPublicFeed();
		
	    
	}
	@When("User select an article {string}")
	public void user_select_an_article(String stringTitle) {
		homepage.clickArticleWithTitle(stringTitle);
	    
	}
	
	@Given("Article detail page must be displayed")
	public void article_detail_page_must_be_displayed() {
		Assert.assertTrue(infoPage.checkEditbtnIsDisplayed());
		System.out.println("Current Page URL: "+ driver.getCurrentUrl());
	}
	
	@When("User Update article detail")
	public void user_update_article_detail() {
		infoPage.EditArticle();
		editPage.EnterTitleDetails("Updated title 101");
		editPage.EnterDescDetails("Updated Desc of article");
		editPage.EnterContentDetails("New Content");
		editPage.EnterTagDetails("NewTag");
		editPage.SubmitInfo();
	    
	}
	@Then("Article detail must be updated")
	public void article_detail_must_be_updated() {
		Assert.assertTrue(infoPage.checkArticleContentIsCorrect("New Content"));
	    
	}
	
	@When("user delete article")
	public void user_delete_article() throws InterruptedException {
		infoPage.deleteArticle();
		Utility.HandleAlert(driver, "Want to delete the article?");
	    
	}
	@Then("Article must be deleted")
	public void article_must_be_deleted() {
		
		Assert.assertFalse(driver.getCurrentUrl().contains("/article/"), "Article is still present");
		// if the deletion does not work- article will be still present and url will have article text in url
		// this will return true and hence the assertFalse will fail and return the message given
		// in that case a screenshot will be added in report
		
	}
}
