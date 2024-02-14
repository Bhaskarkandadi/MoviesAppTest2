Feature: Movie Details Page

  Scenario: View Movie Details Page from Home Page
    Given the user is on homepage
    When the user clicks on a movie link from the Home Page
    Then the movie title is displayed
    And the movie image is displayed
    And the movie watch time is displayed
    And the movie sensor rating is displayed
    And the movie release year is displayed
    And the movie overview is displayed
    And the play button is displayed

  Scenario: View Movie Details Page from Popular Page
    Given the user is on homepage
    When the user clicks on the "Popular" link
    And clicks on a movie link
    Then the movie title is displayed
    And the movie image is displayed
    And the movie watch time is displayed
    And the movie sensor rating is displayed
    And the movie release year is displayed
    And the movie overview is displayed
    And the play button is displayed
