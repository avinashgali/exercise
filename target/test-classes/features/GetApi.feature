
Feature: Get User Details from REQRES API

  Scenario: Validate no of users and presence of User Named Michael
    Given User can access the "/api/users" api
    Then User should get reponse code as 200
    Then Retrieved response should have only 6 user
    Then Response user data should have user with Id 12
