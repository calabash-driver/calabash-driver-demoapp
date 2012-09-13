Feature: Login feature

  Scenario: As a valid user I can log into my app
    When I press "DE Button"
    Then I wait to see "This will end the activity"
    When I press "No, no"
    Then I wait for dialog to close
    Then I see "CalabashAndroidDemo"
    
    			
