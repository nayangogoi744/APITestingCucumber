Feature: Test GitHub API

Scenario Outline: User is able to validate the GitHub API 
	Given User sets the base API request "<URL>" 
	And User authenticate the API using "<token>" 
	When User sends the request to get all the repositories 
	Then User validates the response status is <code>
	
	Examples: 
		|URL					|token									 |code|
		|https://api.github.com |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|200 |
		
		
	