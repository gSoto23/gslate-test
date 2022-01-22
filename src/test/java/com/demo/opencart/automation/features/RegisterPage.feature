Feature: Register Page

  Scenario: Verify that the web site allows new customers to register.
    Given Go to home page
    And Click on my account button
    And Click on register
    And Fill up the form to create a user Name: "Automated" LastName: "TesUser" Email: "testgslate5@test.com" Phone: "8888 8888" Password: "ready2go"
    And Click in the checkbox to accept Privacy Policy
    And Click on continue
    Then Verify that user was created successfully