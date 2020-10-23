Feature: Email Validation on Juice shop page

  Scenario Outline: Check email validation
    Given user on SignUp page
    When user enters the email "<email>"
    And user enter tab
    Then user verify error "<error>"
    Examples:
    |email | error|
    |@gmail.com|Email address is not valid.|
    |Иван@gmail.com|Email address is not valid.|
    |smth@@rambler.ru|Email address is not valid.|
    |sa_*212!^&*)@aa.com|Email address is not valid.|
    |wizdmak|Email address is not valid.|
