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

class GASDSJourneySpec
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
      "User navigates to the 'About Gift Aid Small Donations Scheme schedule' page from the Gift Aid flow and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE-TEST-S1-0")
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
      ClaimsTaskListPage_InProgress.verifyPageHeading("Make a charity repayment claim")
      And("User clicks the link to navigate to 'About Gift Aid Small Donations Scheme schedule' page")
      ClaimsTaskListPage_InProgress.clickProvideGASDSDetails()
      And("User Validates the navigation to 'About Gift Aid Small Donations Scheme schedule' page")
      AboutGASDSPage.validateNavigation()
      Then("User Validates page content  heading/caption/paragraph/button texts on about GASDS page")
      AboutGASDSPage.validatePageContent()
    }

    Scenario(
      "User navigates a GASDS Journey for multiple years"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "JOURNEY-TEST-GASDS-FLOW")
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
        "User selects 'Yes' and clicks continue on 'Do you want to claim for donations collected in community buildings?' page"
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.radioButton(
        DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.yes
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
      And("User selects 'Yes' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.yes)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.validateNavigation()
      And("User selects 'Yes' and clicks continue on 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.radioButton(ConnectedCharitiesPage.yes)
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
      CheckYourGASDSAdjustmentAmountPage.validateNavigation()
      Then("User navigates to 'Which tax year are you claiming for?' year 1 page")
      CheckYourGASDSAdjustmentAmountPage.clickContinue()
      WhichTaxYearAreYouClaimingForPage.validateNavigation1()
      Then(
        s"User navigates to 'Which tax year are you claiming for?' page and inputs: " + RemoveClaimForTaxYearPage.earliestTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(RemoveClaimForTaxYearPage.earliestTaxYear)
      Then("User navigates to 'What donation amount are you claiming under GASDS, in pounds?' for the first year page")
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateNavigation_Year1()
      Then(
        "User inputs a value on 'What donation amount are you claiming under GASDS, in pounds?' for the first year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.enterDonationAmount("543.21")
      Then("User navigates to 'Check your claim details for tax year 1' page")
      CheckYourClaimDetailsForTaxYearPage.validateNavigation1()
      Then("User navigates to 'You have added a claim for 1 tax year' page")
      CheckYourClaimDetailsForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation1()
      Then("User selects 'Yes' on 'You have added a claim for 1 tax year' page to add another tax year")
      YouHaveAddedAClaimForXTaxYearPage.radioButton(YouHaveAddedAClaimForXTaxYearPage.yes)
      YouHaveAddedAClaimForXTaxYearPage.clickContinue()
      Then("User navigates to 'Which tax year are you claiming for?' year 2 page")
      WhichTaxYearAreYouClaimingForPage.validateNavigation2()
      Then(
        s"User navigates to 'Which tax year are you claiming for?' page and inputs: " + RemoveClaimForTaxYearPage.secondEarliestTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(RemoveClaimForTaxYearPage.secondEarliestTaxYear)
      Then("User navigates to 'What donation amount are you claiming under GASDS, in pounds?' for the second year page")
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateNavigation_Year2()
      Then(
        "User inputs a value on 'What donation amount are you claiming under GASDS, in pounds?' for the second year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.enterDonationAmount("111.11")
      Then("User navigates to 'Check your claim details for tax year 2' page")
      CheckYourClaimDetailsForTaxYearPage.validateNavigation2()
      Then("User navigates to 'You have added a claim for 2 tax years' page")
      CheckYourClaimDetailsForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation2()
      Then("User selects 'Yes' on 'You have added a claim for 2 tax year' page to add another tax year")
      YouHaveAddedAClaimForXTaxYearPage.radioButton(YouHaveAddedAClaimForXTaxYearPage.yes)
      YouHaveAddedAClaimForXTaxYearPage.clickContinue()
      Then("User navigates to 'Which tax year are you claiming for?' year 3 page")
      WhichTaxYearAreYouClaimingForPage.validateNavigation3()
      Then(
        s"User navigates to 'Which tax year are you claiming for?' page and inputs: " + RemoveClaimForTaxYearPage.recentTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(RemoveClaimForTaxYearPage.recentTaxYear)
      Then("User navigates to 'What donation amount are you claiming under GASDS, in pounds?' for the third year page")
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateNavigation_Year3()
      Then(
        "User inputs a value on 'What donation amount are you claiming under GASDS, in pounds?' for the third year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.enterDonationAmount("3.33")
      Then("User navigates to 'Check your claim details for tax year 3' page")
      CheckYourClaimDetailsForTaxYearPage.validateNavigation3()
      Then("User navigates to 'You have added a claim for 3 tax years' page")
      CheckYourClaimDetailsForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation3()
      Then("User selects to remove the 2nd tax year from 'You have added a claim for 3 tax years' page")
      YouHaveAddedAClaimForXTaxYearPage.clickRemoveRow2Link()
      Then("User navigates to 'Do you want to remove the claim for tax year 2025?' page")
      RemoveClaimForTaxYearPage.validateNavigation2()
      Then("User confirms to remove the 2nd tax year from 'You have added a claim for 3 tax years' page")
      RemoveClaimForTaxYearPage.radioButton(RemoveClaimForTaxYearPage.yes)
      Then("User navigates to 'You have added a claim for 2 tax years' page")
      RemoveClaimForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation2()
      Then("User selects 'No' on 'You have added a claim for 2 tax year' page to add another tax year")
      YouHaveAddedAClaimForXTaxYearPage.radioButton(YouHaveAddedAClaimForXTaxYearPage.no)
      YouHaveAddedAClaimForXTaxYearPage.clickContinue()
      Then("User navigates to 'Check your GASDS donation details' page")
      // TODO CYA
    }
  }
}
