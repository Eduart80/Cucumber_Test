Feature: hotel
  Scenario: search hotel vacations
    When i enter 'Lake York' in search bar
    And i select 'Lake George, New York, Unite' from autosuggestion
    And i click search button
   And i verify search header contains text selected from autosuggestion
   And i verify text under 'Destination, property, or landmark is the same text selected from autosuggestion

