@Android @SignUpCreatePIN
Feature: Functionality on Sign up - Create PIN page
  
  Background:
    Given User is on "Sign In" page
    And User tap the Sign Up button on Sign In page
    And User input "Zaki Akhmad Faridzan" on "Full Name" page
    And User tap Next button on "Full Name" page
    And User input "zakiakhmadfaridzan12@gmail.com" on "Email" page
    And User tap Next button on "Email" page
    And User input "081120203030" on "Phone Number" page
    And User tap Next button on "Phone Number" page
    And User is on "Create PIN" page

  @SU-P_001
  Scenario: Back to the Phone Number page by tapping Back button on Create PIN page
    When User tap Back button on "Create PIN" page
    Then User is on "Phone Number" page

  @SU-P_002
  Scenario: Back to the Phone Number page by tapping the device's Back button
    When User tap the device's "Back" button
    Then User is on "Phone Number" page

  @SU-P_003
  Scenario: Display the Create PIN page again by reopening the app after the device's Home button is tapped
    When User tap the device's "Home" button
    And User tap the device's "Overview" button
    And User tap the app on the device's overview
    Then User is on "Create PIN" page

  @SU-P_004
  Scenario: Display the Create PIN page again by unlocking the device after it's been locked before
    When User lock the device
    And User unlock the device by swiping up the screen
    Then User is on "Create PIN" page

  @SU-P_005
  Scenario: Relaunch the app after it's been closed before when User is on Create PIN page
    When User close the app
    And User open the app
    Then User is on "Sign In" page