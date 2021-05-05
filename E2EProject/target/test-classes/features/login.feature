Feature: Application login 

Scenario Outline: Postive login case
Given Initialize the chrome browser
And Navigate to the required url
And Click on the Login button
When User enters username <username> and password <password> and clicks on submit button
Then User should be able to login successfully
And Close the browsers

Examples:
|username	|password	|
|nsubhankar70@gmail.com	|Maa@12345	|
#|nandi.subhankar43@gmail.com	|Maa@12345	|