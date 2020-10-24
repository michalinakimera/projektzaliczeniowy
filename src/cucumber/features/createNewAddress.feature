Feature: MyStore
  Scenario Outline: create new address
    Given user is on the my store main page
    And user click on the SignIn button
    When user completes email field with ania.kowalska01012020@o2.pl
    And user completes password with qwertyqwerty
    And user submits credentials
    Then user click on the Addresses button
    And user click on the Create new address button
    When user completes alias field with <alias>
    And user completes address field with <address>
    And user completes city field with <city>
    Then user completes zip field with <zip>
    And user completes phone field with <phone>
    And user chooses country from combobox
    Then user click on the save button
    When user check the save is correct
#    Then user delete address
#    And user check the delete is correct



    Examples:

      | alias | address   | city   | zip | phone     | password |  email|
      | AniaK | Street 13 | London | E17AA           | 666777888 | qwertyqwerty | ania.kowalska01012020@o2.pl |