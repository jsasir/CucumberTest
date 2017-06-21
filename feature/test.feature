Feature: Validating the given/result page

  Scenario Outline: verify the populated values are correct
    Given Web page is displayed with Value 1 to Value 5
    When Verify the value of "Value_label" is $"value"
    Then The value of "Value_label" is $"value"

    Examples: 
      | Value_label | value      |
      | Value 1     | 122,365.24 |
      | Value 2     |     599.00 |
      | Value 3     | 850,139.99 |
      | Value 4     |  23,329.50 |
      | Value 5     |     566.27 |
