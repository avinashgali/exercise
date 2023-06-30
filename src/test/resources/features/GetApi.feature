
Feature: Get User Details from REQRES API

  
  Scenario: Get User from the UserData
    Given User can access the "/api/users/2" api
    Then User should get reponse code as 200
    Then Response message contain user data with id 2
    Then Retrieved response should have only 1 user
