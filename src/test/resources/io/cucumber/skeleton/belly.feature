Feature: Belly

  Scenario: a few cukes
    Given I have 42 cukes in my belly
    When I wait 1 hour
    Then my belly should growl

  @mobile
  Scenario: home screen
    Given I tap on Accessibility
    Then Four accessibility elements are displayed
