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
import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

class GASDSPagesSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation - GASDS Page Validations") {
    Scenario(
      "User navigates to the 'About Gift Aid Small Donations Scheme schedule' page from the GASDS flow and validates the 'About Gift Aid Small Donations Scheme schedule' page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE-TEST-S2.1")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigation()
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page")
      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
      And(
        "User selects 'Yes' and clicks continue on 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
      )
      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouWantToClaimATopUpUnderGASDSPage.yes)
      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
      Then("User navigates to 'Do you want to claim for donations collected in community buildings?' page")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
      And(
        "User selects 'No' and clicks continue on 'Do you want to claim for donations collected in community buildings?' page"
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.radioButton(
        DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.no
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
      And("User selects 'Yes' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.yes)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.radioButton(ConnectedCharitiesPage.no)
      ConnectedCharitiesPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
      And("User clicks the link to navigate to 'About Gift Aid Small Donations Scheme schedule' page")
      ClaimsTaskListPage_InProgress.clickProvideGASDSDetails()
      And("User Validates the navigation to 'About Gift Aid Small Donations Scheme schedule' page")
      AboutGASDSPage.validateNavigation()
      Then("User Validates page content heading/caption/paragraph/button texts on about GASDS page")
      AboutGASDSPage.validatePageContent()
    }

    Scenario(
      "User navigates to the 'About Gift Aid Small Donations Scheme schedule' page from the GASDS flow and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE-TEST-S2.2")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigation()
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page")
      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
      And(
        "User selects 'Yes' and clicks continue on 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
      )
      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouWantToClaimATopUpUnderGASDSPage.yes)
      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
      Then("User navigates to 'Do you want to claim for donations collected in community buildings?' page")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
      And(
        "User selects 'No' and clicks continue on 'Do you want to claim for donations collected in community buildings?' page"
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.radioButton(
        DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.no
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
      And("User selects 'Yes' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.yes)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.radioButton(ConnectedCharitiesPage.no)
      ConnectedCharitiesPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
      And("User clicks the link to navigate to 'About Gift Aid Small Donations Scheme schedule' page")
      ClaimsTaskListPage_InProgress.clickProvideGASDSDetails()
      And("User Validates the navigation to 'About Gift Aid Small Donations Scheme schedule' page")
      AboutGASDSPage.validateNavigation()
      Then("User navigates to 'What is the adjustment amount for Gift Aid previously overclaimed?' page")
      AboutGASDSPage.clickContinue()
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.validateNavigation()
      Then("User validates content on 'What is the adjustment amount for Gift Aid previously overclaimed?' page")
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.verifyAmountHintText()
      Then("User validates error messages on 'What is the adjustment amount for Gift Aid previously overclaimed?' page")
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Check your GASDS adjustment amount' page from the GASDS flow and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE-TEST-S2.3")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigation()
      And("User selects 'Top up payments for donations under the GASDS' checkbox and clicks continue")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page")
      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
      And(
        "User selects 'Yes' and clicks continue on 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
      )
      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouWantToClaimATopUpUnderGASDSPage.yes)
      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
      Then("User navigates to 'Do you want to claim for donations collected in community buildings?' page")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
      And(
        "User selects 'No' and clicks continue on 'Do you want to claim for donations collected in community buildings?' page"
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.radioButton(
        DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.no
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
      And("User selects 'Yes' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.yes)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.radioButton(ConnectedCharitiesPage.no)
      ConnectedCharitiesPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
      And("User clicks the link to navigate to 'About Gift Aid Small Donations Scheme schedule' page")
      ClaimsTaskListPage_InProgress.clickProvideGASDSDetails()
      And("User Validates the navigation to 'About Gift Aid Small Donations Scheme schedule' page")
      AboutGASDSPage.validateNavigation()
      Then("User navigates to 'What is the adjustment amount for Gift Aid previously overclaimed?' page")
      AboutGASDSPage.clickContinue()
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.validateNavigation()
      Then("User navigates to 'Check your GASDS adjustment amount' page")
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.enterAdjustmentAmountValue("123.45")
      And("Validates Navigation of the 'Check your GASDS adjustment amount' page")
      CheckYourGASDSAdjustmentAmountPage.validateNavigation()
      Then("User validates content on 'Check your GASDS adjustment amount' page")
      CheckYourGASDSAdjustmentAmountPage.assertAllSummaryPairsExactlyAt(0)(
        "Amount of GASDS previously overclaimed" -> "£123.45"
      )
      Then("User clicks 'Change' link on 'Check your GASDS adjustment amount' page")
      CheckYourGASDSAdjustmentAmountPage.clickChangeGASDSAdjustmentAmount()
      Then(
        "User navigates to 'What is the adjustment amount for Gift Aid previously overclaimed?' page and validates page heading"
      )
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.verifyPageHeading(
        WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.pageHeading
      )
    }

    Scenario(
      "User navigates to the 'Which Tax Year Are You Claiming For' page 1 from the GASDS flow and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE-TEST-S2.4")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigation()
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page")
      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
      And(
        "User selects 'Yes' and clicks continue on 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
      )
      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouWantToClaimATopUpUnderGASDSPage.yes)
      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
      Then("User navigates to 'Do you want to claim for donations collected in community buildings?' page")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
      And(
        "User selects 'No' and clicks continue on 'Do you want to claim for donations collected in community buildings?' page"
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.radioButton(
        DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.no
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
      And("User selects 'Yes' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.no)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.radioButton(ConnectedCharitiesPage.no)
      ConnectedCharitiesPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
      And("User clicks the link to navigate to 'About Gift Aid Small Donations Scheme schedule' page")
      ClaimsTaskListPage_InProgress.clickProvideGASDSDetails()
      And("User Validates the navigation to 'About Gift Aid Small Donations Scheme schedule' page and clicks continue")
      AboutGASDSPage.validateNavigation()
      AboutGASDSPage.clickContinue()
      Then("User validates the navigation to 'Which Tax Year Are You Claiming For' page 1 ")
      WhichTaxYearAreYouClaimingForPage.validateNavigation1()
      Then("User validates the page properties on 'Which Tax Year Are You Claiming For' page 1")
      WhichTaxYearAreYouClaimingForPage.validatePageProperties1()
      Then("User validates the error messages on 'Which Tax Year Are You Claiming For ' Page 1")
      WhichTaxYearAreYouClaimingForPage.validateErrorMessages1()
    }

    Scenario(
      "User navigates to the 'What donation amount are you claiming under GASDS, in pounds?' page from the GASDS flow and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE-TEST-S2.5")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigation()
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page")
      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
      And(
        "User selects 'Yes' and clicks continue on 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
      )
      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouWantToClaimATopUpUnderGASDSPage.yes)
      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
      Then("User navigates to 'Do you want to claim for donations collected in community buildings?' page")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
      And(
        "User selects 'No' and clicks continue on 'Do you want to claim for donations collected in community buildings?' page"
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.radioButton(
        DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.no
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.no)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.radioButton(ConnectedCharitiesPage.no)
      ConnectedCharitiesPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
      And("User clicks the link to navigate to 'About Gift Aid Small Donations Scheme schedule' page")
      ClaimsTaskListPage_InProgress.clickProvideGASDSDetails()
      And("User Validates the navigation to 'About Gift Aid Small Donations Scheme schedule' page")
      AboutGASDSPage.validateNavigation()
      Then("User navigates to 'Which tax year are you claiming for?' page")
      AboutGASDSPage.clickContinue()
      WhichTaxYearAreYouClaimingForPage.validateNavigation1()
      Then(
        s"User navigates to 'Which tax year are you claiming for?' page and inputs: " + WhichTaxYearAreYouClaimingForPage.earliestTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(WhichTaxYearAreYouClaimingForPage.earliestTaxYear)
      Then("User navigates to 'What donation amount are you claiming under GASDS, in pounds?' for the first year page")
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateNavigation_Year1()
      Then(
        "User Validates hint text on 'What donation amount are you claiming under GASDS, in pounds?' for the first year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyAmountHintText()
      Then(
        "User Validates error messages on 'What donation amount are you claiming under GASDS, in pounds?' for the first year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateErrorMessage_Year1()
    }

    Scenario(
      "User navigates to the 'Check your claim details for tax year 1' page from the GASDS flow and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE-TEST-S2.6")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigation()
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page")
      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
      And(
        "User selects 'Yes' and clicks continue on 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
      )
      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouWantToClaimATopUpUnderGASDSPage.yes)
      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
      Then("User navigates to 'Do you want to claim for donations collected in community buildings?' page")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
      And(
        "User selects 'No' and clicks continue on 'Do you want to claim for donations collected in community buildings?' page"
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.radioButton(
        DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.no
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.no)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.radioButton(ConnectedCharitiesPage.no)
      ConnectedCharitiesPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
      And("User clicks the link to navigate to 'About Gift Aid Small Donations Scheme schedule' page")
      ClaimsTaskListPage_InProgress.clickProvideGASDSDetails()
      And("User Validates the navigation to 'About Gift Aid Small Donations Scheme schedule' page")
      AboutGASDSPage.validateNavigation()
      Then("User navigates to 'Which tax year are you claiming for?' page")
      AboutGASDSPage.clickContinue()
      WhichTaxYearAreYouClaimingForPage.validateNavigation1()
      Then(
        s"User navigates to 'Which tax year are you claiming for?' page and inputs: " + WhichTaxYearAreYouClaimingForPage.earliestTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(WhichTaxYearAreYouClaimingForPage.earliestTaxYear)
      Then("User navigates to 'What donation amount are you claiming under GASDS, in pounds?' for the first year page")
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateNavigation_Year1()
      Then(
        "User inputs a value on 'What donation amount are you claiming under GASDS, in pounds?' for the first year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.enterDonationAmount("123.45")
      Then("User navigates to 'Check your claim details for tax year 1' page")
      CheckYourClaimDetailsForTaxYearPage.validateNavigation1()
      CheckYourClaimDetailsForTaxYearPage.assertAllSummaryPairsExactlyAt(0)(
        "Tax year"        -> WhichTaxYearAreYouClaimingForPage.earliestTaxYear,
        "Donation amount" -> "£123.45"
      )
    }

    Scenario(
      "User navigates to the 'You have added a claim for 1 tax year' page from the GASDS flow and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE-TEST-S2.7")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigation()
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page")
      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
      And(
        "User selects 'Yes' and clicks continue on 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
      )
      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouWantToClaimATopUpUnderGASDSPage.yes)
      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
      Then("User navigates to 'Do you want to claim for donations collected in community buildings?' page")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
      And(
        "User selects 'No' and clicks continue on 'Do you want to claim for donations collected in community buildings?' page"
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.radioButton(
        DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.no
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.no)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.radioButton(ConnectedCharitiesPage.no)
      ConnectedCharitiesPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
      And("User clicks the link to navigate to 'About Gift Aid Small Donations Scheme schedule' page")
      ClaimsTaskListPage_InProgress.clickProvideGASDSDetails()
      And("User Validates the navigation to 'About Gift Aid Small Donations Scheme schedule' page")
      AboutGASDSPage.validateNavigation()
      Then("User navigates to 'Which tax year are you claiming for?' page")
      AboutGASDSPage.clickContinue()
      WhichTaxYearAreYouClaimingForPage.validateNavigation1()
      Then(
        s"User navigates to 'Which tax year are you claiming for?' page and inputs: " + WhichTaxYearAreYouClaimingForPage.earliestTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(WhichTaxYearAreYouClaimingForPage.earliestTaxYear)
      Then("User navigates to 'What donation amount are you claiming under GASDS, in pounds?' for the first year page")
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateNavigation_Year1()
      Then(
        "User inputs a value on 'What donation amount are you claiming under GASDS, in pounds?' for the first year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.enterDonationAmount("123.45")
      Then("User navigates to 'Check your claim details for tax year 1' page")
      CheckYourClaimDetailsForTaxYearPage.validateNavigation1()
      Then("User navigates to 'You have added a claim for 1 tax year' page")
      CheckYourClaimDetailsForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation1()
      Then("User validates content on 'You have added a claim for 1 tax year' page")
      // TODO Need to validate table, but only has 1 column, current approach doesnt count the 'Change' / 'Remove' links
    }
////    Scenario(
////      "User navigates to the 'Which Tax Year Are You Claiming For' page 2 from the GASDS flow and validates the page elements"
////    ) {
////      Given("the user logs in through the Authority Wizard page")
////      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE-TEST-S2.8")
////      Then("User navigates to 'Make a charity repayment claim' page")
////      ClaimsTaskListPage_Empty.validateNavigation()
////      And("User clicks the link to navigate to 'Repayment claim details' page")
////      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
////      Then("User validates the 'Repayment claim details' page")
////      RepaymentClaimDetailsPage.validateNavigation()
////      And("User clicks continue on 'Repayment claim details' page")
////      RepaymentClaimDetailsPage.clickContinue()
////      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
////      RepaymentCheckboxPage.validateNavigation()
////      And(
////        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
////      )
////      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
////      RepaymentCheckboxPage.clickContinue()
////      Then(
////        "User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
////      )
////      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
////      And(
////        "User selects 'Yes' and clicks continue on 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
////      )
////      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouWantToClaimATopUpUnderGASDSPage.yes)
////      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
////      Then("User navigates to 'Do you want to claim for donations collected in community buildings?' page")
////      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
////      And(
////        "User selects 'No' and clicks continue on 'Do you want to claim for donations collected in community buildings?' page"
////      )
////      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.radioButton(
////        DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.no
////      )
////      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.clickContinue()
////      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
////      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
////      And("User selects 'Yes' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
////      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.no)
////      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
////      Then("User navigates to 'Connected charities and Community Amateur Sports Clubs' page")
////      ConnectedCharitiesPage.validateNavigation()
////      And("User selects 'No' and clicks continue on 'Connected charities and Community Amateur Sports Clubs' page")
////      ConnectedCharitiesPage.radioButton(ConnectedCharitiesPage.no)
////      ConnectedCharitiesPage.clickContinue()
////      Then("User navigates to 'Do you have a claim reference number?' page")
////      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
////      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
////      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
////      DoYouHaveAClaimReferenceNumberPage.clickContinue()
////      Then("User navigates to 'Check your repayment claim' page")
////      CheckYourRepaymentClaimPage.validateNavigation()
////      CheckYourRepaymentClaimPage.clickContinue()
////      Then("User navigates to 'Make a charity repayment claim' page")
////      ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
////      And("User clicks the link to navigate to 'About Gift Aid Small Donations Scheme schedule' page")
////      ClaimsTaskListPage_InProgress.clickProvideGASDSDetails()
////      And(
////        "User Validates the navigation to 'About Gift Aid Small Donations Scheme schedule' page and clicks continue"
////      )
////      AboutGASDSPage.validateNavigation()
////      AboutGASDSPage.clickContinue()
////      Then("User validates the navigation to 'Which Tax Year Are You Claiming For' page 1 ")
////      WhichTaxYearPage.validateNavigation1()
////      WhichTaxYearPage.enterValidTaxYear("2024")
////      WhichTaxYearPage.clickContinue()
////      //TODO To complete when other S2.5/S2.6/S2.7 Automation completed
////      Then("User validates the navigation to 'Which Tax Year Are You Claiming For' page 2 ")
////      WhichTaxYearPage.validateNavigation2()
////      Then("User validates the page properties on 'Which Tax Year Are You Claiming For' page 2")
////      WhichTaxYearPage.validatePageProperties2()
////      Then("User validates the error messages on 'Which Tax Year Are You Claiming For ' Page 2")
////      WhichTaxYearPage.validateErrorMessages2()
////    }
////
////    Scenario(
////      "User navigates to the 'Which Tax Year Are You Claiming For' page 3 from the GASDS flow and validates the page elements"
////    ) {
////      Given("the user logs in through the Authority Wizard page")
////      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE-TEST-S2.12")
////      Then("User navigates to 'Make a charity repayment claim' page")
////      ClaimsTaskListPage_Empty.validateNavigation()
////      And("User clicks the link to navigate to 'Repayment claim details' page")
////      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
////      Then("User validates the 'Repayment claim details' page")
////      RepaymentClaimDetailsPage.validateNavigation()
////      And("User clicks continue on 'Repayment claim details' page")
////      RepaymentClaimDetailsPage.clickContinue()
////      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
////      RepaymentCheckboxPage.validateNavigation()
////      And(
////        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
////      )
////      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
////      RepaymentCheckboxPage.clickContinue()
////      Then(
////        "User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
////      )
////      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
////      And(
////        "User selects 'Yes' and clicks continue on 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
////      )
////      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouWantToClaimATopUpUnderGASDSPage.yes)
////      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
////      Then("User navigates to 'Do you want to claim for donations collected in community buildings?' page")
////      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
////      And(
////        "User selects 'No' and clicks continue on 'Do you want to claim for donations collected in community buildings?' page"
////      )
////      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.radioButton(
////        DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.no
////      )
////      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.clickContinue()
////      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
////      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
////      And("User selects 'Yes' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
////      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.no)
////      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
////      Then("User navigates to 'Connected charities and Community Amateur Sports Clubs' page")
////      ConnectedCharitiesPage.validateNavigation()
////      And("User selects 'No' and clicks continue on 'Connected charities and Community Amateur Sports Clubs' page")
////      ConnectedCharitiesPage.radioButton(ConnectedCharitiesPage.no)
////      ConnectedCharitiesPage.clickContinue()
////      Then("User navigates to 'Do you have a claim reference number?' page")
////      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
////      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
////      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
////      DoYouHaveAClaimReferenceNumberPage.clickContinue()
////      Then("User navigates to 'Check your repayment claim' page")
////      CheckYourRepaymentClaimPage.validateNavigation()
////      CheckYourRepaymentClaimPage.clickContinue()
////      Then("User navigates to 'Make a charity repayment claim' page")
////      ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
////      And("User clicks the link to navigate to 'About Gift Aid Small Donations Scheme schedule' page")
////      ClaimsTaskListPage_InProgress.clickProvideGASDSDetails()
////      And(
////        "User Validates the navigation to 'About Gift Aid Small Donations Scheme schedule' page and clicks continue"
////      )
////      AboutGASDSPage.validateNavigation()
////      AboutGASDSPage.clickContinue()
////      Then("User validates the navigation to 'Which Tax Year Are You Claiming For' page 1 ")
////      WhichTaxYearPage.validateNavigation1()
////      WhichTaxYearPage.enterValidTaxYear("2024")
////      WhichTaxYearPage.clickContinue()
////      //TODO To complete when other S2.5/S2.6/S2.7 Automation completed
////      Then("User validates the navigation to 'Which Tax Year Are You Claiming For' page 2 ")
////      WhichTaxYearPage.validateNavigation2()
////      Then("User validates the page properties on 'Which Tax Year Are You Claiming For' page 2")
////      WhichTaxYearPage.validatePageProperties2()
////      Then("User validates the error messages on 'Which Tax Year Are You Claiming For ' Page 2")
////      WhichTaxYearPage.validateErrorMessages2()
////      //TODO To complete when other S2.9/S2.10/S2.11 Automation completed
////      Then("User validates the navigation to 'Which Tax Year Are You Claiming For' page 3 ")
////      WhichTaxYearPage.validateNavigation3()
////      Then("User validates the page properties on 'Which Tax Year Are You Claiming For' page 3")
////      WhichTaxYearPage.validatePageProperties3()
////      Then("User validates the error messages on 'Which Tax Year Are You Claiming For ' Page 3")
////      WhichTaxYearPage.validateErrorMessages3()
////    }
  }
}
