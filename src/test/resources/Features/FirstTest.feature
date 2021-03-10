Feature: First Tests Feature

  Scenario: First test of first tests
    Given homepage is opened
    When I click Contact Link
    Then ContactUs page is opened

  Scenario Outline: Second test
    Given homepage is opened
    When I click Contact Link
    Then "<parameter>" is displayed
    And "<parameter2>" is displayed
    And "ggg" is displayed 2
    But "zzz" is displayed
    # But is exactly the same as And
    Examples:
    |parameter|parameter2|
    |aaa      |bbb       |
    |ccc      |ddd       |
    |eee      |fff       |
