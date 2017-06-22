Feature: Validating the Web page

  Scenario: To verify the Web page elements and calculatuions.
  
    Given Launch the test Webpage 
    
    When The webpage is displayed with set of Values
     
    Then Verify the name of value label
    
    And Verify the actual value text
    And Verify the values on the screen are greater than Zero
    And varify the total balance is correctly calculated
    And verify the values are formatted in currencies
