/*
 * Copyright 2026 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.ui.specs

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.ui.pages.*
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.Agent

class AgentGASDSJourneySpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Agent - GASDS Page Validations") {
    Scenario(
      "User navigates a GASDS Journey for multiple years and verifies 'Check your GASDS donation details' page"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETEST-C16")
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      Then("User Clicks Continue and navigates to 'Enter HMRC Charities Reference' page")
      RepaymentClaimDetailsPage.clickContinue()
      And("User Validates Navigation/hint for the 'Enter HMRC Charities Reference' page")
      WhatIsYourHMRCReferenceNumberPage.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber("X1")
      And("User Navigates to 'What is the Name of your Charity or CASC' page and validates the page elements and text")
      WhatIsTheNameOfCharityOrCASC.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsTheNameOfCharityOrCASC.enterCharityName("Charity of X1")
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigationAgent()
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigationAgent()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContentAgent()
      And("User selects 'GASDS top-up' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSTopUp, true)
      GASDSCheckboxPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigationAgent()
      And("User selects 'Yes' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.yes)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigationAgent()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
      And("User clicks the link to navigate to 'About Gift Aid Small Donations Scheme schedule' page")
      ClaimsTaskListPage_InProgress.clickProvideGASDSDetails()
      And("User Validates the navigation to 'About Gift Aid Small Donations Scheme schedule' page")
      AboutGASDSPage.validateNavigationAgent()
      Then("User navigates to 'What is the adjustment amount for Gift Aid previously overclaimed?' page")
      AboutGASDSPage.clickContinue()
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.validateNavigationAgent()
      Then("User navigates to 'Check your GASDS adjustment amount' page")
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.enterAdjustmentAmountValue("123.45")
      CheckYourGASDSAdjustmentAmountPage.validateNavigationAgent()
      Then("User navigates to 'Which tax year are you claiming for?' year 1 page")
      CheckYourGASDSAdjustmentAmountPage.clickContinue()
      WhichTaxYearAreYouClaimingForPage.validateNavigation1Agent()
      Then(
        s"User navigates to 'Which tax year are you claiming for?' page and inputs: " + WhichTaxYearAreYouClaimingForPage.earliestTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(WhichTaxYearAreYouClaimingForPage.earliestTaxYear)
      Then("User navigates to 'What donation amount are you claiming under GASDS, in pounds?' for the first year page")
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateNavigationAgent_Year1()
      Then(
        "User inputs a value on 'What donation amount are you claiming under GASDS, in pounds?' for the first year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.enterDonationAmount("543.21")
      Then("User navigates to 'Check your claim details for tax year 1' page")
      CheckYourClaimDetailsForTaxYearPage.validateNavigation1Agent()
      Then("User navigates to 'You have added a claim for 1 tax year' page")
      CheckYourClaimDetailsForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation1Agent()
      Then("User selects 'Yes' on 'You have added a claim for 1 tax year' page to add another tax year")
      YouHaveAddedAClaimForXTaxYearPage.radioButton(YouHaveAddedAClaimForXTaxYearPage.yes)
      YouHaveAddedAClaimForXTaxYearPage.clickContinue()
      Then("User navigates to 'Which tax year are you claiming for?' year 2 page")
      WhichTaxYearAreYouClaimingForPage.validateNavigation2Agent()
      Then(
        s"User navigates to 'Which tax year are you claiming for?' page and inputs: " + WhichTaxYearAreYouClaimingForPage.secondEarliestTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(WhichTaxYearAreYouClaimingForPage.secondEarliestTaxYear)
      Then("User navigates to 'What donation amount are you claiming under GASDS, in pounds?' for the second year page")
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateNavigationAgent_Year2()
      Then(
        "User inputs a value on 'What donation amount are you claiming under GASDS, in pounds?' for the second year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.enterDonationAmount("111.11")
      Then("User navigates to 'Check your claim details for tax year 2' page")
      CheckYourClaimDetailsForTaxYearPage.validateNavigation2Agent()
      Then("User navigates to 'You have added a claim for 2 tax years' page")
      CheckYourClaimDetailsForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation2Agent()
      Then("User selects 'Yes' on 'You have added a claim for 2 tax year' page to add another tax year")
      YouHaveAddedAClaimForXTaxYearPage.radioButton(YouHaveAddedAClaimForXTaxYearPage.yes)
      YouHaveAddedAClaimForXTaxYearPage.clickContinue()
      Then("User navigates to 'Which tax year are you claiming for?' year 3 page")
      WhichTaxYearAreYouClaimingForPage.validateNavigation3Agent()
      Then(
        s"User navigates to 'Which tax year are you claiming for?' page and inputs: " + WhichTaxYearAreYouClaimingForPage.recentTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(WhichTaxYearAreYouClaimingForPage.recentTaxYear)
      Then("User navigates to 'What donation amount are you claiming under GASDS, in pounds?' for the third year page")
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateNavigationAgent_Year3()
      Then(
        "User inputs a value on 'What donation amount are you claiming under GASDS, in pounds?' for the third year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.enterDonationAmount("3.33")
      Then("User navigates to 'Check your claim details for tax year 3' page")
      CheckYourClaimDetailsForTaxYearPage.validateNavigation3Agent()
      Then("User navigates to 'You have added a claim for 3 tax years' page")
      CheckYourClaimDetailsForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation3Agent()
      Then("User selects to remove the 2nd tax year from 'You have added a claim for 3 tax years' page")
      YouHaveAddedAClaimForXTaxYearPage.clickRemoveRow2Link()
      Then("User navigates to 'Do you want to remove the claim for tax year 2025?' page")
      RemoveClaimForTaxYearPage.validateNavigation2()
      Then("User confirms to remove the 2nd tax year from 'You have added a claim for 3 tax years' page")
      RemoveClaimForTaxYearPage.radioButton(RemoveClaimForTaxYearPage.yes)
      Then("User navigates to 'You have added a claim for 2 tax years' page")
      RemoveClaimForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation2Agent()
      Then("User selects 'No' on 'You have added a claim for 2 tax year' page to add another tax year")
      YouHaveAddedAClaimForXTaxYearPage.radioButton(YouHaveAddedAClaimForXTaxYearPage.no)
      YouHaveAddedAClaimForXTaxYearPage.clickContinue()
      Then("User navigates to 'Check your GASDS donation details' page and validates page details")
      CheckYourGASDSDonationDetailsPage.validateNavigationAgent()
      And("User validates the sub-headings of Adjustment Amount and GASDS Claims Tax Years")
      CheckYourGASDSDonationDetailsPage.validateGASDSAdjustmentHeading()
      CheckYourGASDSDonationDetailsPage.validateGASDSClaimTaxHeading()
      Then("User Validates the Key and Value pairs on 'Check your GASDS Donation Details' Page")
      CheckYourGASDSDonationDetailsPage.assertAllSummaryPairsExactlyAt(0)(
        "Amount of GASDS previously overclaimed" -> "£123.45"
      )
      CheckYourGASDSDonationDetailsPage.assertAllSummaryPairsExactlyAt(1)(
        "Number of tax years added"              -> "2"
      )
      Then("User Clicks 'Change' Link of GASDS Previously overclaimed Adjustment Amount")
      CheckYourGASDSDonationDetailsPage.clickChangeGASDSAdjustmentAmount()
      And("User navigates to 'Check Your GASDS Adjustment Amount page' and validates Navigation")
      CheckYourGASDSAdjustmentAmountPage.validateChangeNavigation()
      Then("User Clicks CONTINUE to reach directly to 'Check your GASDS Donation details' Page")
      CheckYourGASDSAdjustmentAmountPage.clickContinue()
      And("Validates Navigation of Check your GASDS Donation Details Page")
      CheckYourGASDSDonationDetailsPage.validateNavigationAgent()
      Then("User Clicks 'Change' Link of GASDS Number of Tax Years Added ")
      CheckYourGASDSDonationDetailsPage.clickChangeGASDSTaxYears()
      Then("User navigates to 'You have added a claim for 2 tax years' page")
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation2Agent()
      Then("User selects 'No' on 'You have added a claim for 2 tax year' page to add another tax year")
      YouHaveAddedAClaimForXTaxYearPage.radioButton(YouHaveAddedAClaimForXTaxYearPage.no)
      YouHaveAddedAClaimForXTaxYearPage.clickContinue()
      Then("User navigates to 'Check your GASDS donation details' page and validates page details")
      CheckYourGASDSDonationDetailsPage.validateNavigationAgent()
      Then("User clicks CONTINUE to reach task list: 'Make a repayment Claim' Page")
      CheckYourGASDSDonationDetailsPage.clickContinue()
      And("User validates navigation to 'Make a repayment Claim' Page")
      ClaimsTaskListPage_InProgress.validateNavigationGASDSOnlyComplete()
    }
    
    
    Scenario(
      "User navigates to the 'About, Adjustment amount, CYA Adjustment,Tax year 1 pages, CYA Final' pages from the GASDS flow and validates the Page Elements and errors"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETEST-C16")
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      Then("User Clicks Continue and navigates to 'Enter HMRC Charities Reference' page")
      RepaymentClaimDetailsPage.clickContinue()
      And("User Validates Navigation/hint for the 'Enter HMRC Charities Reference' page")
      WhatIsYourHMRCReferenceNumberPage.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber("X1")
      And("User Navigates to 'What is the Name of your Charity or CASC' page and validates the page elements and text")
      WhatIsTheNameOfCharityOrCASC.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsTheNameOfCharityOrCASC.enterCharityName("Charity of X1")
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigationAgent()
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigationAgent()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContentAgent()
      And("User selects 'GASDS top-up' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSTopUp, true)
      GASDSCheckboxPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigationAgent()
      And("User selects 'Yes' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.yes)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigationAgent()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
      And("User clicks the link to navigate to 'About Gift Aid Small Donations Scheme schedule' page")
      ClaimsTaskListPage_InProgress.clickProvideGASDSDetails()
      And("User Validates the navigation to 'About Gift Aid Small Donations Scheme schedule' page")
      AboutGASDSPage.validateNavigationAgent()
      Then("User Validates page content heading/caption/paragraph/button texts on about GASDS page")
      AboutGASDSPage.validatePageContentAgent()
      Then("User navigates to 'What is the adjustment amount for Gift Aid previously overclaimed?' page")
      AboutGASDSPage.clickContinue()
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.validateNavigationAgent()
      Then("User navigates to 'Check your GASDS adjustment amount' page")
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.enterAdjustmentAmountValue("55.00")
      And("Validates Navigation of the 'Check your GASDS adjustment amount' page")
      CheckYourGASDSAdjustmentAmountPage.validateNavigationAgent()
      Then("User validates content on 'Check your GASDS adjustment amount' page")
      CheckYourGASDSAdjustmentAmountPage.assertAllSummaryPairsExactlyAt(0)(
        "Amount of GASDS previously overclaimed" -> "£55.00"
      )
      Then("User Clicks Continue CYA Adjustment")
      CheckYourGASDSAdjustmentAmountPage.validateNavigationAgent()
      CheckYourGASDSAdjustmentAmountPage.clickContinue()
      Then("User validates the navigation to 'Which Tax Year Are You Claiming For' page 1 ")
      WhichTaxYearAreYouClaimingForPage.validateNavigation1Agent()
      Then("User validates the page properties on 'Which Tax Year Are You Claiming For' page 1")
      WhichTaxYearAreYouClaimingForPage.validatePageProperties1()
      Then("User validates the error messages on 'Which Tax Year Are You Claiming For ' Page 1")
      WhichTaxYearAreYouClaimingForPage.validateErrorMessages1()
      Then(
        s"User navigates to 'Which tax year are you claiming for?' page and inputs: " + WhichTaxYearAreYouClaimingForPage.earliestTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(WhichTaxYearAreYouClaimingForPage.earliestTaxYear)
      Then("User navigates to 'What donation amount are you claiming under GASDS, in pounds?' for the first year page")
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateNavigationAgent_Year1()
      Then(
        "User Validates hint text on 'What donation amount are you claiming under GASDS, in pounds?' for the first year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyAmountHintText()
      Then(
        "User Validates error messages on 'What donation amount are you claiming under GASDS, in pounds?' for the first year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateErrorMessage_Year1()
      Then(
        "User inputs a value on 'What donation amount are you claiming under GASDS, in pounds?' for the first year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.enterDonationAmount("999.00")
      Then("User navigates to 'Check your claim details for tax year 1' page")
      CheckYourClaimDetailsForTaxYearPage.validateNavigation1Agent()
      CheckYourClaimDetailsForTaxYearPage.assertAllSummaryPairsExactlyAt(0)(
        "Tax year" -> WhichTaxYearAreYouClaimingForPage.earliestTaxYear,
        "Donation amount" -> "£123.45"
      )
      Then("User navigates to 'You have added a claim for 1 tax year' page")
      CheckYourClaimDetailsForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation1Agent()
      Then("User selects 'Yes' on 'You have added a claim for 1 tax year' page to add another tax year")
      YouHaveAddedAClaimForXTaxYearPage.radioButton(YouHaveAddedAClaimForXTaxYearPage.yes)
      YouHaveAddedAClaimForXTaxYearPage.clickContinue()
      Then("User navigates to 'Which tax year are you claiming for?' year 2 page")
      WhichTaxYearAreYouClaimingForPage.validateNavigation2Agent()
      Then(
        s"User navigates to 'Which tax year are you claiming for?' page and inputs to generate duplicate error: " + WhichTaxYearAreYouClaimingForPage.earliestTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.validateDuplicateErrorMessage(WhichTaxYearAreYouClaimingForPage.pageErrorDuplicateYear,WhichTaxYearAreYouClaimingForPage.yearInputErrorLocator)
      Then(
        s"User on 'Which tax year are you claiming for?' page inputs: " + WhichTaxYearAreYouClaimingForPage.secondEarliestTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(WhichTaxYearAreYouClaimingForPage.secondEarliestTaxYear)
      Then("User navigates to 'What donation amount are you claiming under GASDS, in pounds?' for the second year page")
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateNavigationAgent_Year2()
      Then(
        "User inputs a value on 'What donation amount are you claiming under GASDS, in pounds?' for the second year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.enterDonationAmount("1000.00")
      Then("User navigates to 'Check your claim details for tax year 2' page")
      CheckYourClaimDetailsForTaxYearPage.validateNavigation2Agent()
      Then("User navigates to 'You have added a claim for 2 tax years' page")
      CheckYourClaimDetailsForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation2Agent()
      Then("User selects 'Yes' on 'You have added a claim for 2 tax year' page to add another tax year")
      YouHaveAddedAClaimForXTaxYearPage.radioButton(YouHaveAddedAClaimForXTaxYearPage.yes)
      YouHaveAddedAClaimForXTaxYearPage.clickContinue()
      Then("User navigates to 'Which tax year are you claiming for?' year 3 page")
      WhichTaxYearAreYouClaimingForPage.validateNavigation3Agent()
      Then(
        s"User navigates to 'Which tax year are you claiming for?' page and inputs: " + WhichTaxYearAreYouClaimingForPage.recentTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(WhichTaxYearAreYouClaimingForPage.recentTaxYear)
      Then("User navigates to 'What donation amount are you claiming under GASDS, in pounds?' for the third year page")
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateNavigationAgent_Year3()
      Then(
        "User inputs a value on 'What donation amount are you claiming under GASDS, in pounds?' for the third year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.enterDonationAmount("333.00")
      Then("User navigates to 'Check your claim details for tax year 3' page")
      CheckYourClaimDetailsForTaxYearPage.validateNavigation3Agent()
      Then("User navigates to 'You have added a claim for 3 tax years' page")
      CheckYourClaimDetailsForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation3Agent()
      Then("User navigates to 'Check your GASDS donation details' page")
      YouHaveAddedAClaimForXTaxYearPage.clickContinue()
      Then("User navigates to 'Check your GASDS donation details' page and validates page details")
      CheckYourGASDSDonationDetailsPage.validateNavigationAgent()
      And("User validates the sub-headings of Adjustment Amount and GASDS Claims Tax Years")
      CheckYourGASDSDonationDetailsPage.validateGASDSAdjustmentHeading()
      CheckYourGASDSDonationDetailsPage.validateGASDSClaimTaxHeading()
      Then("User Validates the Key and Value pairs on 'Check your GASDS Donation Details' Page")
      CheckYourGASDSDonationDetailsPage.assertAllSummaryPairsExactlyAt(0)(
        "Amount of GASDS previously overclaimed" -> "£55.00"
      )
      CheckYourGASDSDonationDetailsPage.assertAllSummaryPairsExactlyAt(1)(
        "Number of tax years added" -> "3"
      )

    }
  }
}
