Feature: Google Test Scenarios
  Scenario Outline: TC1 get google search result number
     Given I navigate to google home
     When I Can verify the expected title as google
     When I type a car <cars> in google search field
     And I submit or click on google search
     Then I capture and extract the search number

     Examples:
       |cars|
       |BMW |
       |Lexus|
       |Mercedes|



  Scenario: TC2 login with invalid credentials