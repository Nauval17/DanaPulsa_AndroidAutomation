@Android @ForgotPIN
Feature: Check the Forgot PIN feature functionality
  #BEFORE YOU RUN THE TEST MAKE SURE TO CHANGE YOUR PHONE NUMBER, YOUR ACCOUNT USER ID, AND YOUR DEVICE TYPE ON PASTE SCENARIO
  #RUN THIS EXACTLY BEFORE RUNNING CHANGE PIN.
  #Device type name format example = 6.0 , 8.0 , 10.0
  Background:
    Given User in the sign in page

  @FP_001
  Scenario: Successfully change pin using Forgot Pin feature with valid otp and PIN
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08126022339"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2048"
    And User click next button on the otp page
    And User input new PIN "909090"
    And User click next button on the new pin page
    And User input the new pin on confirmation page
    And User click finish button on the confirmation page
    And User click yes on the dialog box
    And User in the sign in page
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    And User input registered phone number "08126022339"
    And User click the sign in button
    And User input new pin number on the pin page
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the sign out menu
    And User click yes on the dialog box
    Then User is back at the sign in page


  @FP_002
  Scenario: Successfully change pin using Forgot PIN with valid resended OTP, and PIN
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08126022339"
    And User click the sign in button
    And User click the forgot pin text
    And User wait for the otp to expire in three minutes.
    And User Click resend OTP
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2048"
    And User click next button on the otp page
    And User input new PIN "919191"
    And User click next button on the new pin page
    And User input the new pin on confirmation page
    And User click finish button on the confirmation page
    And User click yes on the dialog box
    And User in the sign in page
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    And User input registered phone number "08126022339"
    And User click the sign in button
    And User input new pin number on the pin page
    And User is in the main page
    And User click the profile menu on the bottom bar
    And User click the sign out menu
    And User click yes on the dialog box
    Then User is back at the sign in page

  @FP_003
  Scenario: Forgot PIN with invalid OTP
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08126022339"
    And User click the sign in button
    And User click the forgot pin text
    And User input invalid otp number "1234"
    And User click next button on the otp page
    Then User see display error "incorrect OTP"

  @FP_004-009
  Scenario Outline: Forgot PIN with invalid OTP (symbols and alphabets)
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    And User input invalid otp number "<OTP>"
    And User click next button on the otp page
    Then User see display error "invalid OTP"
    Examples:
      | OTP  |
      | 90*9 |
      | #909 |
      | 909+ |
      | 9.09 |
      | 9-90 |
      | P90A |

  @FP_010
  Scenario: Forgot PIN with empty OTP
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    Then User cannot click next the button is disabled

  @FP_011
  Scenario: Forgot PIN but inputting with only 2 digits of OTP number
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input two digits otp number with user id "2040"
    Then User cannot click next the button is disabled

  @FP_012
  Scenario: Forgot PIN but with expired OTP
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User get otp number with user id "2040"
    And User wait for the otp to expire in three minutes.
    And User input the old otp
    And User click next button on the otp page
    Then User see display error "Code is expired. Please tap Resend button"

  @FP_013
  Scenario: Forgot PIN with valid OTP but empty new PIN
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    Then User cannot click next the button is disabled

  @FP_014
  Scenario: Forgot PIN with valid OTP but invalid new PIN
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "91919"
    Then User cannot click next the button is disabled

  @FP_015-020
  Scenario Outline: Forgot PIN with valid OTP but invalid new PIN (symbols and alphabets)
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "<PIN>"
    Then User see display error "Must be 6 digits and cannot start with 0"
    Examples:
      | PIN    |
      | 90*909 |
      | #90909 |
      | 90909+ |
      | 9.0909 |
      | 909-09 |
      | P90AS9 |

  @FP_021
  Scenario: Forgot PIN with valid OTP but empty confirmation PIN
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "898989"
    And User click next button on the new pin page
    Then User cannot click finish button the button is disabled

  @FP_022
  Scenario: Forgot PIN with valid OTP but with incorrect confirmation PIN
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "898989"
    And User click next button on the new pin page
    And User input incorrect pin on the confirmation page "818181"
    Then User see display error "PIN doesn't match"

  @FP_023-028
  Scenario Outline: Forgot PIN with valid OTP but with incorrect confirmation PIN (symbols and alphabets)
     #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "898989"
    And User click next button on the new pin page
    And User input incorrect pin on the confirmation page "<PIN>"
    Then User see display error "Must be 6 digits and cannot start with 0"
    Examples:
      | PIN    |
      | 90*909 |
      | #90909 |
      | 90909+ |
      | 9.0909 |
      | 909-09 |
      | P90AS9 |

  @FP_029
  Scenario: Successfully do Forgot PIN with valid otp and PIN, but Login with Old PIN
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08126022339"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2048"
    And User click next button on the otp page
    And User input new PIN "909090"
    And User click next button on the new pin page
    And User input the new pin on confirmation page
    And User click finish button on the confirmation page
    And User click yes on the dialog box
    And User in the sign in page
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    And User input registered phone number "08126022339"
    And User click the sign in button
    And User input old pin number on the page "919191"
    Then User see display error "incorrect pin"

  @FP_030
  Scenario: Forgot PIN with valid OTP but invalid new PIN (symbols and alphabets)
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "012345"
    Then User see display error "Must be 6 digits and cannot start with 0"

  @FP_031
  Scenario: Forgot PIN with valid OTP but with incorrect confirmation PIN (symbols and alphabets)
     #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "898989"
    And User click next button on the new pin page
    And User input incorrect pin on the confirmation page "012345"
    Then User see display error "Must be 6 digits and cannot start with 0"

  @FP-OTP_001
  Scenario: Go back to Sign In PIN Screen Using the Arrow Icon Button
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    And User is in otp page
    And User click the back arrow icon on top bar
    Then User is in the pin page

  @FP-OTP_002
  Scenario: Proceed to Sign In Screen Using the device back button
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    And User is in otp page
    And User click device back button
    Then User is in the pin page

  @FP-OTP_003
  Scenario: Back to OTP Screen by opening the app after tapping the device home button
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    And User is in otp page
    And User click home button and reopen the app
    Then User is in otp page

  @FP-OTP_004
  Scenario: Still on OTP Screen by opening the app after locking and unlocking the device
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    And User is in otp page
    And User lock the device
    And User unlock the device
    Then User is in otp page

  @FP-OTP_005
  Scenario: Resend button tapped without waiting for 3 minutes
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    Then User cannot click resend the button is disabled

  @FP-OTP_006
  Scenario: Resend button tapped after it has been tapped before
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    And User wait for the otp to expire in three minutes.
    And User Click resend OTP
    Then User cannot click resend the button is disabled

  @FP-OTP_007
  Scenario: Resend button tapped after waiting for 3 minutes but can't connect to the server
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    And User wait for the otp to expire in three minutes.
    And User turn internet off
    And User Click resend OTP
    Then User see display error "Connection Error"
    And User turn internet on

  @FP-OTP_008
  Scenario: Pasted Valid OTP from clipboard
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input otp via pasting with user id "2040"
    Then User cant perform paste on the OTP input "10.0"

  @FP-OTP_009
  Scenario: Click next with valid OTP but can't connect to server
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User turn internet off
    And User click next button on the otp page
    Then User see display error "Connection Error"
    And User turn internet on

  @FP-NP_001 @FNP
  Scenario: Go back to Sign-In PIN Screen Using the Arrow Icon Button
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User is in the new pin page
    And User click the back arrow icon on top bar
    Then User is in the pin page

  @FP-NP_002 @FNP
  Scenario: Go back to Sign-In PIN Screen using the device back button
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User is in the new pin page
    And User click device back button
    Then User is in the pin page

  @FP-NP_003 @FNP
  Scenario: Back to New PIN screen by opening the app after tapping the device home button
     #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User is in the new pin page
    And User click home button and reopen the app
    Then User is in the new pin page

  @FP-NP_004 @FNP
  Scenario: Still on New PIN screen by opening the app after locking and unlocking the device
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User is in the new pin page
    And User lock the device
    And User unlock the device
    Then User is in the new pin page

  @FP-NP_005 @FNP
  Scenario: Pasted Valid PIN from clipboard into New PIN input
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User is in the new pin page
    And User input new pin via pasting "909090"
    Then User cant perform paste on the new pin input "10.0"

  @FP-CP_001 @FCP
  Scenario: Go back to Forgot PIN - New PIN Screen Using the Arrow Icon Button
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "919191"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User click the back arrow icon on top bar
    Then User is in the new pin page

  @FP-CP_002 @FCP
  Scenario: Go back to Forgot PIN-New PIN Screen using the device back button
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "919191"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User click device back button
    Then User is in the new pin page

  @FP-CP_003 @FCP
  Scenario: Back to Confirm PIN screen screen by opening the app after tapping the device home button
      #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "919191"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User click home button and reopen the app
    Then User is in the confirmation page

  @FP-CP_004 @FCP
  Scenario: Still on Confirm PIN screen screen by opening the app after locking and unlocking the device
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "919191"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User lock the device
    And User unlock the device
    Then User is in the confirmation page

  @FP-CP_005 @FCP
  Scenario: Pasted Valid PIN from clipboard into Confirm PIN input
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "919191"
    And User click next button on the new pin page
    And User is in the confirmation page
    And User input confirm pin via pasting
    Then User cant perform paste on the confirm input "10.0"

  @FP-CP_006 @FCP
  Scenario: Input all valid OTP, new PIN, and confirm PIN, but can't connect to server when clicking finish button
    #YOUR ACCOUNT PHONE NUMBER CHANGE THIS MANUALLY
    When User input registered phone number "08555222333"
    And User click the sign in button
    And User click the forgot pin text
    #YOUR ACCOUNT USER ID CHANGE THIS MANUALLY
    And User input valid otp number with user id "2040"
    And User click next button on the otp page
    And User input new PIN "919191"
    And User click next button on the new pin page
    And User input the new pin on confirmation page
    And User turn internet off
    And User click finish button on the confirmation page
    Then User see display error "Connection Error"
    And User turn internet on