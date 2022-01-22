Feature: Home Page
  Scenario: Add an order using the search to find a specific product
    Given I navigate to home page
    And Search for a product "Macbook Pro"
    And Select the first result displayed to add to the cart
    Then The product should be added to the shopping cart "1 item(s) - $602.00"

  Scenario: Verify a product price is displayed in the selected currency.
    Given I navigate to home page
    And Look for the currency dropdown
    And Change the currency to € Euro
    Then Verify that the currency in the shopping cart match with the currency preselected "€"