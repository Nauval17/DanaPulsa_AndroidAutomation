@Android @NegativeCase
Feature: Mobile Recharge

  Background:
    Given User is on sign in page
    When User input phone number "088245593542"
    And User input pin number "123456"

  @MRN001
  Scenario Outline: Top up any valid provider number without voucher and the balance is not sufficient
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    And User check status voucher availability "<statusVoucher>"
    And User pick a voucher
    And User choose voucher value "<chooseVoucher>"
    When User see payment detail page
    Then User cannot pay the bill
    Examples:
      | phoneNumber   | topUp | statusVoucher | chooseVoucher |
      | 0859233333333 | 15K   | available     | cashback 1K   |

  @MRN002
  Scenario Outline: Top up any valid provider number with voucher but the balance is not sufficient
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    When User see payment detail page
    Then User cannot pay the bill
    Examples:
      | phoneNumber   | topUp |
      | 0859233333333 | 5k    |

  @MRN003
  Scenario: Input invalid provider
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    Then User didn't see provider icon

  @MRN004
  Scenario: Input mobile phone number but in incorrect format (starting with +62)
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    Then User didn't see provider icon

  @MRN005
  Scenario: Input mobile phone number but in incorrect format (9 digit)
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    Then User see invalid format message

  @MRN006
  Scenario: Input mobile phone number but in incorrect format (14 digit)
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    And User choose "<topUp>" nominal
    Then User see invalid format message

  @MRN007
  Scenario: Input mobile phone number but in incorrect format (did not start with 0)
    Given User is on homepage
    When User click mobile recharge icon
    And User input "<phoneNumber>"
    Then User didn't see provider icon
