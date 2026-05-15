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

class AgentGiftAidJourneySpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Agent - Gift Aid Repayment Journey Validations") {
    Scenario(
      "User navigates to the 'Check your Repayment claim details' page and validates the page elements - Non GASDS and no reference number"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "TESTR10")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
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
      And("User selects 'Tax repayments on Gift Aid donations' checkbox and clicks continue")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GiftAid, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page and validates heading and subheadings")
      CheckYourRepaymentClaimPage.validateNavigationAgent()
      CheckYourRepaymentClaimPage.verifyClaimDetailsH2Agent(CheckYourRepaymentClaimPage.pageSubheadingClaimDetailsAgent)
      CheckYourRepaymentClaimPage.verifyCharityDetailsH2Agent(
        CheckYourRepaymentClaimPage.pageSubheadingCharityDetailsAgent
      )
      Then("User Validates the Key and Value pairs on 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(0)(
        CheckYourRepaymentClaimPage.charityNameAgent        -> "Charity of X1",
        CheckYourRepaymentClaimPage.charitiesReferenceAgent -> "X1"
      )
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(1)(
        CheckYourRepaymentClaimPage.repaymentClaimType      -> "Gift Aid",
        CheckYourRepaymentClaimPage.claimReferenceProvided  -> "No"
      )
    }

    Scenario(
      "User navigates to the 'Check your Repayment claim details' page and validates the page elements - Non GASDS with reference number"
    ) {
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "TESTR11")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
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
      And("User selects 'Gift Aid 'and ' Other Income' checkboxes and clicks continue")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GiftAid, true)
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.OtherIncome, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
      And("User selects 'Yes' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.yes)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'What is your claim reference number?' page")
      WhatIsYourClaimReferenceNumberPage.validateNavigationAgent()
      And("User enters their claim reference number and clicks continue")
      WhatIsYourClaimReferenceNumberPage.enterClaimReferenceNumber("TESTREF123")
      Then("User navigates to 'Check your repayment claim' page and validates navigationn/headings/subheadings")
      CheckYourRepaymentClaimPage.validateNavigationAgent()
      CheckYourRepaymentClaimPage.verifyClaimDetailsH2Agent(CheckYourRepaymentClaimPage.pageSubheadingClaimDetailsAgent)
      CheckYourRepaymentClaimPage.verifyCharityDetailsH2Agent(
        CheckYourRepaymentClaimPage.pageSubheadingCharityDetailsAgent
      )
      Then("User Validates the Key and Value pairs on 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(0)(
        CheckYourRepaymentClaimPage.charityNameAgent        -> "Charity of X1",
        CheckYourRepaymentClaimPage.charitiesReferenceAgent -> "X1"
      )
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(1)(
        CheckYourRepaymentClaimPage.repaymentClaimType      -> "Gift Aid UK tax deducted from Other Income",
        CheckYourRepaymentClaimPage.claimReferenceProvided  -> "Yes",
        CheckYourRepaymentClaimPage.claimReferenceNumber    -> "TESTREF123"
      )
    }

    Scenario(
      "User navigates to the 'Check your Repayment claim details' page and validates the page elements - GASDS without reference number"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "TESTR12")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
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
      And("User selects 'Top up payments for donations under the GASDS' checkbox and clicks continue")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigationAgent()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContentAgent()
      And("User selects 'GASDS Connected Charities' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page and validates navigationn/headings/subheadings")
      CheckYourRepaymentClaimPage.validateNavigationAgent()
      CheckYourRepaymentClaimPage.verifyClaimDetailsH2Agent(CheckYourRepaymentClaimPage.pageSubheadingClaimDetailsAgent)
      CheckYourRepaymentClaimPage.verifyCharityDetailsH2Agent(
        CheckYourRepaymentClaimPage.pageSubheadingCharityDetailsAgent
      )
      Then("User Validates the Key and Value pairs on 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(0)(
        CheckYourRepaymentClaimPage.charityNameAgent        -> "Charity of X1",
        CheckYourRepaymentClaimPage.charitiesReferenceAgent -> "X1"
      )
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(1)(
        CheckYourRepaymentClaimPage.repaymentClaimType      -> "Top-up payments for small cash donations under Gift Aid Small Donations Scheme (GASDS)",
        CheckYourRepaymentClaimPage.claimReferenceProvided  -> "No",
        CheckYourRepaymentClaimPage.GASDSClaimType          -> "Connected charity or CASC claim"
      )
    }

    Scenario(
      "User navigates to the 'Repayment claim details' page and validates the page elements - GASDS,GA,OI with reference number"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "TESTR13")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
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
      And("User selects all of the checkboxes and clicks continue")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GiftAid, true)
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.OtherIncome, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigationAgent()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContentAgent()
      And("User selects 'GASDS top-up', 'Community Building' and 'Connected Charities' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSTopUp, true)
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSBuilding, true)
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigationAgent()
      And("User selects 'Yes' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.yes)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
      And("User selects 'Yes' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.yes)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'What is your claim reference number?' page")
      WhatIsYourClaimReferenceNumberPage.validateNavigationAgent()
      And("User enters their claim reference number and clicks continue")
      WhatIsYourClaimReferenceNumberPage.enterClaimReferenceNumber("TESTREF123")
      Then("User navigates to 'Check your repayment claim' page and validates navigationn/headings/subheadings")
      CheckYourRepaymentClaimPage.validateNavigationAgent()
      CheckYourRepaymentClaimPage.verifyClaimDetailsH2Agent(CheckYourRepaymentClaimPage.pageSubheadingClaimDetailsAgent)
      CheckYourRepaymentClaimPage.verifyCharityDetailsH2Agent(
        CheckYourRepaymentClaimPage.pageSubheadingCharityDetailsAgent
      )
      Then("User Validates the Key and Value pairs on 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(0)(
        CheckYourRepaymentClaimPage.charityNameAgent        -> "Charity of X1",
        CheckYourRepaymentClaimPage.charitiesReferenceAgent -> "X1"
      )
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(1)(
        CheckYourRepaymentClaimPage.repaymentClaimType      -> "Gift Aid Top-up payments for small cash donations under Gift Aid Small Donations Scheme (GASDS) UK tax deducted from Other Income",
        CheckYourRepaymentClaimPage.claimReferenceProvided  -> "Yes",
        CheckYourRepaymentClaimPage.claimReferenceNumber    -> "TESTREF123",
        CheckYourRepaymentClaimPage.GASDSClaimType          -> "GASDS top-up payment Community buildings top-up payment Connected charity or CASC claim",
        CheckYourRepaymentClaimPage.GASDSAdjustment         -> "Yes"
      )
      Then("User Clicks Continue from CYA page and navigates to R2 Task List page and validates Navigation")
      CheckYourRepaymentClaimPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadingsAgent()
    }

    Scenario(
      "User Creates claim with Community Buildings and Connected Charities, and attempts to create a new claim with same HMRC Ref Number"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "TESTR14")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
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
      And("User selects GASDS Checkbox and clicks continue")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigationAgent()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContentAgent()
      And("User selects 'Community Building' and 'Connected Charities' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSBuilding, true)
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigationAgent()
      And("User selects 'No' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.no)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
      And("User selects 'Yes' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.yes)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'What is your claim reference number?' page")
      WhatIsYourClaimReferenceNumberPage.validateNavigationAgent()
      And("User enters their claim reference number and clicks continue")
      WhatIsYourClaimReferenceNumberPage.enterClaimReferenceNumber("TESTREF123")
      Then("User navigates to 'Check your repayment claim' page and validates navigationn/headings/subheadings")
      CheckYourRepaymentClaimPage.validateNavigationAgent()
      CheckYourRepaymentClaimPage.verifyClaimDetailsH2Agent(CheckYourRepaymentClaimPage.pageSubheadingClaimDetailsAgent)
      CheckYourRepaymentClaimPage.verifyCharityDetailsH2Agent(
        CheckYourRepaymentClaimPage.pageSubheadingCharityDetailsAgent
      )
      Then("User Validates the Key and Value pairs on 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(0)(
        CheckYourRepaymentClaimPage.charityNameAgent        -> "Charity of X1",
        CheckYourRepaymentClaimPage.charitiesReferenceAgent -> "X1"
      )
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(1)(
        CheckYourRepaymentClaimPage.repaymentClaimType      -> "Top-up payments for small cash donations under Gift Aid Small Donations Scheme (GASDS)",
        CheckYourRepaymentClaimPage.claimReferenceProvided  -> "Yes",
        CheckYourRepaymentClaimPage.claimReferenceNumber    -> "TESTREF123",
        CheckYourRepaymentClaimPage.GASDSClaimType          -> "Community buildings top-up payment Connected charity or CASC claim",
        CheckYourRepaymentClaimPage.GASDSAdjustment         -> "No"
      )
      Then("User Clicks Continue from CYA page and navigates to R2 Task List page and validates Navigation")
      CheckYourRepaymentClaimPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadingsAgent()
      Then(
        "User Clicks on Link to go back to Charity Management Agent Portal and Attempts to create a claim with same HMRC Charity Ref"
      )
      ClaimsTaskListPage_InProgress.clickGoToCharityManagementAgent()
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      Then("User Clicks Continue and navigates to 'Enter HMRC Charities Reference' page")
      RepaymentClaimDetailsPage.clickContinue()
      And("User Validates Navigation/hint for the 'Enter HMRC Charities Reference' page")
      WhatIsYourHMRCReferenceNumberPage.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber("X1")
      And("User Validates the duplicate Error message that Reference Exists")
      WhatIsYourHMRCReferenceNumberPage.validateErrorMessageClaimAlreadyExists()
    }

//     TODO Real validation to check community building does not exist on GASDS page
//    Scenario(
//      "User Creates claim with CH or CF HMRC Charity Reference and validates GASDS Page does not have community building section"
//    ) {
//      Given("the user logs in through the Authority Wizard page")
//      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "TESTR14")
//      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
//      CharitiesManagementAgent.validateNavigationAgent()
//      And(
//        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
//      )
//      CharitiesManagementAgent.clickUseTheCharitiesLink()
//      Then("User navigates and validates the 'Repayment claim details' page")
//      RepaymentClaimDetailsPage.validateNavigationAgent()
//      Then("User Clicks Continue and navigates to 'Enter HMRC Charities Reference' page")
//      RepaymentClaimDetailsPage.clickContinue()
//      And("User Validates Navigation/hint for the 'Enter HMRC Charities Reference' page")
//      WhatIsYourHMRCReferenceNumberPage.validateNavigationAgent()
//      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
//      WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber("X1")
//      And("User Navigates to 'What is the Name of your Charity or CASC' page and validates the page elements and text")
//      WhatIsTheNameOfCharityOrCASC.validateNavigationAgent()
//      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
//      WhatIsTheNameOfCharityOrCASC.enterCharityName("Charity of X1")
//      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
//      RepaymentCheckboxPage.validateNavigationAgent()
//      And("User selects GASDS Checkbox and clicks continue")
//      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
//      RepaymentCheckboxPage.clickContinue()
//      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
//      GASDSCheckboxPage.validateNavigationAgent()
//      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
//      GASDSCheckboxPage.validatePageContentAgent()
//      And("User selects 'Community Building' and 'Connected Charities' checkbox and clicks continue")
//      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSBuilding, true)
//      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
//      GASDSCheckboxPage.clickContinue()
//    }
  }
}
