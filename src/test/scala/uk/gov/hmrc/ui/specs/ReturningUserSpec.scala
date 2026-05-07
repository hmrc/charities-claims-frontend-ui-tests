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
import uk.gov.hmrc.ui.pages.AuthWizard.hostname
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

class ReturningUserSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation User returning to an unsubmitted claim after logout") {
    Scenario(
      "User completes Repayment and Organisation sections, uploads GAS, Logout->Login, then update sections"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(
        HASDIRECT,
        Organisation,
        "Organisation",
        "HMRC-CHAR-ORG",
        "CHARID",
        "RE1234",
        "returnuser"
      )
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
      And("User selects 'Tax repayments on Gift Aid' checkbox and clicks continue")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GiftAid, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      Then("User Validates the Key and Value pairs on 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(0)(
        CheckYourRepaymentClaimPage.repaymentClaimType     -> "Gift Aid",
        CheckYourRepaymentClaimPage.claimReferenceProvided -> "No"
      )
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation()
      And("User clicks the link to navigate to 'About the organisation' page")
      ClaimsTaskListPage_InProgress.clickProvideOrganisationDetails()
      AboutTheOrganisationPage.validateNavigation()
      Then("User selects continue on 'About the organisation' page")
      AboutTheOrganisationPage.clickContinue()
      And("User navigates to 'What is the name of the charity regulator?' page")
      WhatIsTheNameOfTheCharityRegulatorPage.validateNavigation()
      And("User selects they are registered with the England and Wales regulator")
      WhatIsTheNameOfTheCharityRegulatorPage.radioButton(WhatIsTheNameOfTheCharityRegulatorPage.EngWal)
      WhatIsTheNameOfTheCharityRegulatorPage.clickContinue()
      And("User navigates to 'What is the charity regulator number?' page")
      WhatIsYourCharityRegulatorNumberPage.validateNavigation()
      And("User enters their charity regulator number and clicks continue")
      WhatIsYourCharityRegulatorNumberPage.enterCharityRegulatorNumber("1234567890")
      And("User navigates to 'Is a corporate trustee making this claim?' page")
      IsACorporateTrusteeMakingThisClaimPage.validateNavigation()
      And("User selects a corporate trustee is making this claim")
      IsACorporateTrusteeMakingThisClaimPage.radioButton(IsACorporateTrusteeMakingThisClaimPage.yes)
      IsACorporateTrusteeMakingThisClaimPage.clickContinue()
      And("User navigates to 'Does the corporate trustee have a UK address?' page")
      DoesTheCorporateTrusteeHaveAUKAddressPage.validateNavigation()
      And("User selects a corporate trustee has a UK address")
      DoesTheCorporateTrusteeHaveAUKAddressPage.radioButton(DoesTheCorporateTrusteeHaveAUKAddressPage.yes)
      DoesTheCorporateTrusteeHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateNavigation()
      And("User enters their Non UK Trustee details and clicks continue")
      CorporateTrusteeDetailsPage.enterUKTrusteeDetails("TEST TRUSTEE", "01632 960999", "WG7 7FU")
      And("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.validateNavigation()
      Then("User Validates the Key and Value pairs on 'CYA Organisation Details' page and Submits")
      CheckYourOrganisationDetailsPage.assertAllSummaryPairsExactlyAt(0)(
        "Charity regulator name"                           -> "Charity Commission for England and Wales",
        "Charity regulator number"                         -> "1234567890",
        "Corporate trustee claim"                          -> "Yes",
        "Corporate trustee UK address"                     -> "Yes",
        "Corporate trustee details"                        -> "TEST TRUSTEE 01632 960999 WG7 7FU"
      )
      And("User navigates to 'Make a charity repayment claim' task list page")
      CheckYourOrganisationDetailsPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation()
      And("User clicks the link to navigate to 'Add Gift Aid schedule' page")
      ClaimsTaskListPage_InProgress.clickAddGiftAidSchedule()
      Then("User navigates to 'About Gift Aid schedule' page")
      AboutGiftAidSchedulePage.validateNavigation()
      AboutGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.validateNavigation()
      Then("User selects a file to upload in the 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.selectFile("GiftAidSpreadsheets/Gift-Aid-Schedule-TEST")
      UploadAGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Your Gift Aid schedule upload' page")
      YourGiftAidScheduleUploadPage.validateNavigation()
      YourGiftAidScheduleUploadPage.waitForFileUpload()
      YourGiftAidScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your Gift Aid schedule' page")
      CheckYourGiftAidSchedulePage.validateNavigation()
      CheckYourGiftAidSchedulePage.radioButton(CheckYourGiftAidSchedulePage.no)
      CheckYourGiftAidSchedulePage.clickContinue()
      Then("User navigates and validates 'Successful Gift Aid Upload' page")
      GiftAidUploadSuccessfulPage.validateNavigation()
      GiftAidUploadSuccessfulPage.validatePageParagraph()
      GiftAidUploadSuccessfulPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' task list page")
      ClaimsTaskListPage_InProgress.validateNavigation()
      Then("User Signs out from the top link")
      ClaimsTaskListPage_InProgress.signOut()
      ClaimsTaskListPage_InProgress.verifySignInPage("Sign in")
      Then("the user logs in through the Authority Wizard page with the same user")
      AuthWizard.login(
        HASDIRECT,
        Organisation,
        "Organisation",
        "HMRC-CHAR-ORG",
        "CHARID",
        "RE1234",
        "returnuser"
      )
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_InProgress.clickCheckYourRepaymentClaimDetails()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      Then("User Validates the Key and Value pairs on 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(0)(
        CheckYourRepaymentClaimPage.repaymentClaimType     -> "Gift Aid",
        CheckYourRepaymentClaimPage.claimReferenceProvided -> "No"
      )
      Then("User clicks Change link for 'Repayment claim type' and navigates to that page")
      CheckYourRepaymentClaimPage.clickChangeRepaymentClaimType()
      RepaymentCheckboxPage.verifyPageUrl(RepaymentCheckboxPage.changePageUrl)
      RepaymentCheckboxPage.verifyPageHeading(RepaymentCheckboxPage.pageHeading)
      Then(
        "User unselects 'Tax repayments on Gift aid' checkbox and selects 'UK tax deducted from Other Income'checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GiftAid, false)
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.OtherIncome, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Update repayment claim details' Page")
      UpdateRepaymentClaimDetails.validateNavigation()
      UpdateRepaymentClaimDetails.validateErrorMessages()
      UpdateRepaymentClaimDetails.radioButton(UpdateRepaymentClaimDetails.yes)
      UpdateRepaymentClaimDetails.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      Then("User Validates the Key and Value pairs on 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(0)(
        CheckYourRepaymentClaimPage.repaymentClaimType     -> "UK tax deducted from Other Income",
        CheckYourRepaymentClaimPage.claimReferenceProvided -> "No"
      )
      Then("User clicks Change link for 'Claim reference number' and navigates to that page")
      CheckYourRepaymentClaimPage.clickChangeClaimReference()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.verifyPageUrl(s"$hostname/change-claim-reference-number")
      DoYouHaveAClaimReferenceNumberPage.verifyPageHeading(DoYouHaveAClaimReferenceNumberPage.pageHeading)
      And("User selects 'Yes' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.yes)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'What is your claim reference number?' page")
      WhatIsYourClaimReferenceNumberPage.verifyPageUrl(s"$hostname/change-enter-claim-reference-number")
      WhatIsYourClaimReferenceNumberPage.verifyPageHeading(WhatIsYourClaimReferenceNumberPage.pageHeading)
      And("User enters their claim reference number and clicks continue")
      WhatIsYourClaimReferenceNumberPage.enterClaimReferenceNumber("TESTREF123")
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      Then("User Validates the Key and Value pairs on 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(0)(
        CheckYourRepaymentClaimPage.repaymentClaimType     -> "UK tax deducted from Other Income",
        CheckYourRepaymentClaimPage.claimReferenceProvided -> "Yes",
        CheckYourRepaymentClaimPage.claimReferenceNumber   -> "TESTREF123"
      )
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_InProgress.clickCheckYourRepaymentClaimDetails()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      Then("User Validates the Key and Value pairs on 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(0)(
        CheckYourRepaymentClaimPage.repaymentClaimType     -> "UK tax deducted from Other Income",
        CheckYourRepaymentClaimPage.claimReferenceProvided -> "Yes",
        CheckYourRepaymentClaimPage.claimReferenceNumber   -> "TESTREF123"
      )
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation()
      And("User clicks the link to navigate to 'Organisation details' page")
      ClaimsTaskListPage_InProgress.clickCheckYourOrganisationDetails()
      Then("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.validateNavigation()
      Then("User Validates the Key and Value pairs on 'CYA Organisation Details' page and Submits")
      CheckYourOrganisationDetailsPage.assertAllSummaryPairsExactlyAt(0)(
        "Charity regulator name"                           -> "Charity Commission for England and Wales",
        "Charity regulator number"                         -> "1234567890",
        "Corporate trustee claim"                          -> "Yes",
        "Corporate trustee UK address"                     -> "Yes",
        "Corporate trustee details"                        -> "TEST TRUSTEE 01632 960999 WG7 7FU"
      )
      Then("User clicks on Change Link for Corporate trustee and navigates to that page")
      CheckYourOrganisationDetailsPage.clickChangeCorporateTrusteeClaim()
      And("User navigates to 'Is a corporate trustee making this claim?' page")
      IsACorporateTrusteeMakingThisClaimPage.verifyPageUrl(s"$hostname/change-corporate-trustee-claim")
      IsACorporateTrusteeMakingThisClaimPage.verifyPageHeading(IsACorporateTrusteeMakingThisClaimPage.pageHeading)
      And("User selects a corporate trustee is not making this claim")
      IsACorporateTrusteeMakingThisClaimPage.radioButton(IsACorporateTrusteeMakingThisClaimPage.no)
      IsACorporateTrusteeMakingThisClaimPage.clickContinue()
      And("User navigates to 'Does the authorised official have a UK address?' page")
      DoesTheAuthorisedOfficialHaveAUKAddressPage.verifyPageUrl(s"$hostname/change-authorised-official-address")
      DoesTheAuthorisedOfficialHaveAUKAddressPage.verifyPageHeading(
        DoesTheAuthorisedOfficialHaveAUKAddressPage.pageHeading
      )
      And("User selects a authorised official does have a UK address")
      DoesTheAuthorisedOfficialHaveAUKAddressPage.radioButton(DoesTheAuthorisedOfficialHaveAUKAddressPage.yes)
      DoesTheAuthorisedOfficialHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What are the authorised official details?' page")
      AuthorisedOfficialDetailsPage.verifyPageUrl(s"$hostname/change-authorised-official-details")
      AuthorisedOfficialDetailsPage.verifyPageHeading(AuthorisedOfficialDetailsPage.pageHeading)
      And("User enters their UK Authorised Official details and clicks continue")
      AuthorisedOfficialDetailsPage.enterUKAuthOfficialDetails(
        "TEST",
        "TESTFORENAME",
        "TESTSURNAME",
        "01632 960999",
        "WG7 7FU"
      )
      CheckYourOrganisationDetailsPage.clickContinue()
      And("User navigates to 'Make a charity repayment claim' task list page")
      ClaimsTaskListPage_InProgress.validateNavigation()
      And("User clicks the link to navigate to 'Organisation details' page")
      ClaimsTaskListPage_InProgress.clickCheckYourOrganisationDetails()
      Then("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.validateNavigation()
      Then("User Validates the Key and Value pairs on 'CYA Organisation Details' page and Submits")
      CheckYourOrganisationDetailsPage.assertAllSummaryPairsExactlyAt(0)(
        "Charity regulator name"                           -> "Charity Commission for England and Wales",
        "Charity regulator number"                         -> "1234567890",
        "Corporate trustee claim"                          -> "No",
        "Authorised official’s UK address"                 -> "Yes",
        "Authorised official’s details"                    -> "TEST TESTFORENAME TESTSURNAME 01632 960999 WG7 7FU"
      )
      CheckYourOrganisationDetailsPage.clickContinue()
      And("User navigates to 'Make a charity repayment claim' task list page")
      ClaimsTaskListPage_InProgress.validateNavigation()
      Then("User navigates to 'Are you sure you want to delete this repayment claim?' page")
      ClaimsTaskListPage_InProgress.clickDeleteClaim()
      DeleteRepaymentClaimPage.validateNavigation()
      Then("User selects Yes and CONTINUE to delete the claim")
      DeleteRepaymentClaimPage.radioButton(DeleteRepaymentClaimPage.yes)
      DeleteRepaymentClaimPage.clickContinue()
      Then("User navigates to Charities Management Frontend page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
    }
  }
}
