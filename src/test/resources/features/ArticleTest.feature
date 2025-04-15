Feature: Conduit CRUD Functions

Scenario: Login into App
	Given User is on Login Page
	When User Provide "AutoTester@test.com" and "Test@test111"
	Then User should be on Home Page

Scenario: Create new Article
	Given User should be on New Article Page
	When User enters Article Details
	| title | Desc | Content | tag |
	| Article Title 101 | Article Desc | Article content | ArticleTag |
	Then Article must be created
	| Article content |

Scenario: View Article
	Given User should be on Global Feed Page
	When User select an article "Article Title 101"
	Then Article detail page must be displayed

Scenario: Update an Article
	Given Article detail page must be displayed
	When User Update article detail
	Then Article detail must be updated

Scenario: Delete an Article
	Given Article detail page must be displayed
	When user delete article
	Then Article must be deleted
