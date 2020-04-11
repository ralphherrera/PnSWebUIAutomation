# new feature
# Tags: optional
@web @sampleItemSearch
Feature: Item Search
  As a performance test engineer
  I should be able to select search for my favorite item
  So that I can view my favorite item

  @quickViewItemDetails
  Scenario Outline: View item details via quick view
    Given I access my favorite shopping website
    And I enter '<Item>' in the search text field
    And I click on search button
    When I click the quick view button
    Then I should see the item details and item description '<Description>'

    Examples:
      | Item   | Description                                                                                                                   |
      | Blouse | Short sleeved blouse with feminine draped sleeve detail.                                                                      |
      | Dress  | Long printed dress with thin adjustable straps. V-neckline and wiring under the bust with ruffles at the bottom of the dress. |