Feature: hotel.com
  Background:
    Given remove add popup

  Scenario: Verify user selection from autosuggestion appears on search page
    When i enter 'Lake York' in search bar
    And i select 'Lake George, New York, Unite' from autosuggestion
    And i click search button
    And i verify search header contains text selected from autosuggestion
    And i verify text under 'Destination, property, or landmark is the same text selected from autosuggestion


    Scenario: Verify the cheapest hotel is less than $100
      When i enter 'Lake York' in search bar
      And i select 'Lake George, New York, Unite' from autosuggestion
      When i select 2 in children
      When i enter children 1 age as 4
      And i enter children 2 age as <1
      Then i click search to find
      When i sort the result by "Price Low to high"
      And i print the lowest price and hotel name in the console
      Then i verify the lowest price id less than 100

