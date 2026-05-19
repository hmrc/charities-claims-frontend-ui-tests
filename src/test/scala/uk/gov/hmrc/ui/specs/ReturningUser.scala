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
import uk.gov.hmrc.ui.pages.CharitiesManagementAgent.RandomUsername
import uk.gov.hmrc.ui.pages.CharitiesManagementPlaceholder.RandomUsernameOrg
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

class ReturningUser
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation and Agent Users returning to an unsubmitted claim after logout") {
    Scenario(
      "Organisation User completes Repayment and Organisation sections, uploads GAS, Logout->Login, then update sections"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(
        HASDIRECT,
        Organisation,
        "Organisation",
        "HMRC-CHAR-ORG",
        "CHARID",
        "RE1234",
        RandomUsernameOrg
      )
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
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
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
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
        "Is the corporate trustee making this claim?"      -> "Yes"
      )
      CheckYourOrganisationDetailsPage.assertAllSummaryPairsExactlyAt(1)(
        "UK address"                                       -> "Yes",
        "Trustee’s details"                                -> "TEST TRUSTEE 01632 960999 WG7 7FU"
      )
      And("User navigates to 'Make a charity repayment claim' task list page")
      CheckYourOrganisationDetailsPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
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
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
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
        RandomUsernameOrg
      )
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Continue with draft claim' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickContinueClaimLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
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
      DoYouHaveAClaimReferenceNumberPage.verifyPageUrl(DoYouHaveAClaimReferenceNumberPage.changePageUrl)
      DoYouHaveAClaimReferenceNumberPage.verifyPageHeading(DoYouHaveAClaimReferenceNumberPage.pageHeading)
      And("User selects 'Yes' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.yes)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'What is your claim reference number?' page")
      WhatIsYourClaimReferenceNumberPage.verifyPageUrl(WhatIsYourClaimReferenceNumberPage.changePageUrl)
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
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
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
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      And("User clicks the link to navigate to 'Organisation details' page")
      ClaimsTaskListPage_InProgress.clickCheckYourOrganisationDetails()
      Then("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.validateNavigation()
      Then("User Validates the Key and Value pairs on 'CYA Organisation Details' page and Submits")
      CheckYourOrganisationDetailsPage.assertAllSummaryPairsExactlyAt(0)(
        "Charity regulator name"                           -> "Charity Commission for England and Wales",
        "Charity regulator number"                         -> "1234567890",
        "Is the corporate trustee making this claim?"      -> "Yes"
      )
      CheckYourOrganisationDetailsPage.assertAllSummaryPairsExactlyAt(1)(
        "UK address"                                       -> "Yes",
        "Trustee’s details"                                -> "TEST TRUSTEE 01632 960999 WG7 7FU"
      )
      Then("User clicks on Change Link for Corporate trustee and navigates to that page")
      CheckYourOrganisationDetailsPage.clickChangeCorporateTrusteeClaim()
      And("User navigates to 'Is a corporate trustee making this claim?' page")
      IsACorporateTrusteeMakingThisClaimPage.verifyPageUrl(IsACorporateTrusteeMakingThisClaimPage.changePageUrl)
      IsACorporateTrusteeMakingThisClaimPage.verifyPageHeading(IsACorporateTrusteeMakingThisClaimPage.pageHeading)
      And("User selects a corporate trustee is not making this claim")
      IsACorporateTrusteeMakingThisClaimPage.radioButton(IsACorporateTrusteeMakingThisClaimPage.no)
      IsACorporateTrusteeMakingThisClaimPage.clickContinue()
      And("User navigates to 'Does the authorised official have a UK address?' page")
      DoesTheAuthorisedOfficialHaveAUKAddressPage.verifyPageUrl(
        DoesTheAuthorisedOfficialHaveAUKAddressPage.changePageUrl
      )
      DoesTheAuthorisedOfficialHaveAUKAddressPage.verifyPageHeading(
        DoesTheAuthorisedOfficialHaveAUKAddressPage.pageHeading
      )
      And("User selects a authorised official does have a UK address")
      DoesTheAuthorisedOfficialHaveAUKAddressPage.radioButton(DoesTheAuthorisedOfficialHaveAUKAddressPage.yes)
      DoesTheAuthorisedOfficialHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What are the authorised official details?' page")
      AuthorisedOfficialDetailsPage.validateChangeNavigation()
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
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      And("User clicks the link to navigate to 'Organisation details' page")
      ClaimsTaskListPage_InProgress.clickCheckYourOrganisationDetails()
      Then("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.validateNavigation()
      Then("User Validates the Key and Value pairs on 'CYA Organisation Details' page and Submits")
      CheckYourOrganisationDetailsPage.assertAllSummaryPairsExactlyAt(0)(
        "Charity regulator name"                           -> "Charity Commission for England and Wales",
        "Charity regulator number"                         -> "1234567890",
        "Is the corporate trustee making this claim?"      -> "No"
      )
      CheckYourOrganisationDetailsPage.assertAllSummaryPairsExactlyAt(1)(
        "UK address"                                       -> "Yes",
        "Official’s details"                               -> "TEST TESTFORENAME TESTSURNAME 01632 960999 WG7 7FU"
      )
      CheckYourOrganisationDetailsPage.clickContinue()
      And("User navigates to 'Make a charity repayment claim' task list page")
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      Then("User navigates to 'Are you sure you want to delete this repayment claim?' page")
      ClaimsTaskListPage_InProgress.clickDeleteClaim()
      DeleteRepaymentClaimPage.validateNavigation()
      Then("User selects Yes and CONTINUE to delete the claim")
      DeleteRepaymentClaimPage.radioButton(DeleteRepaymentClaimPage.yes)
      DeleteRepaymentClaimPage.clickContinue()
      Then("User navigates to Charities Management Frontend page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
    }

    Scenario(
      "Agent User completes Repayment and Organisation sections, uploads GAS, Logout->Login, then update sections"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(
        HASDIRECT,
        Organisation,
        "Agent",
        "HMRC-CHAR-AGENT",
        "AGENTCHARID",
        "AG1234",
        RandomUsername
      )
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
      WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber("X12345")
      And("User Navigates to 'What is the Name of your Charity or CASC' page and validates the page elements and text")
      WhatIsTheNameOfCharityOrCASC.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsTheNameOfCharityOrCASC.enterCharityName("TEST AGENT CASC")
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
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigationAgent()
      Then("User navigates and validates the 'Repayment claim details' page")
      CheckYourRepaymentClaimPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadingsAgent()
      Then("User clicks 'Provide Organisation Details' link and navigates to 'About the Organisation' page")
      ClaimsTaskListPage_InProgress.clickProvideOrganisationDetails()
      AboutTheOrganisationPage.validateNavigation()
      Then("User selects continue on 'About the organisation' page")
      AboutTheOrganisationPage.clickContinue()
      And("User navigates to 'What is the name of the charity regulator?' page")
      WhatIsTheNameOfTheCharityRegulatorPage.validateNavigation()
      And("User selects they are not registered with a regulator")
      WhatIsTheNameOfTheCharityRegulatorPage.radioButton(WhatIsTheNameOfTheCharityRegulatorPage.None)
      WhatIsTheNameOfTheCharityRegulatorPage.clickContinue()
      And("User navigates to 'Why is the charity not registered with a regulator?' page")
      WhyIsTheCharityNotRegisteredPage.validateNavigation()
      WhyIsTheCharityNotRegisteredPage.validateFormFieldsetAgent()
      And("User selects they are exempt")
      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.Exempt)
      WhyIsTheCharityNotRegisteredPage.clickContinue()
      And("User navigates to 'The charity is exempt' page")
      YourCharityIsExemptPage.validateNavigationAgent()
      YourCharityIsExemptPage.validateParagraphAgent()
      And("User clicks back link to reach 'Why is the charity not registered with a regulator?' page")
      YourCharityIsExemptPage.clickBackLink()
      WhyIsTheCharityNotRegisteredPage.validateNavigation()
      And("User selects they are excepted")
      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.Excepted)
      WhyIsTheCharityNotRegisteredPage.clickContinue()
      And("User navigates to 'The charity is excepted' page")
      YourCharityIsExceptedPage.validateNavigationAgent()
      YourCharityIsExceptedPage.validateParagraphAgent()
      Then("User selects continue on 'The charity is excepted' page")
      YourCharityIsExceptedPage.clickContinue()
      And("User navigates to 'Who should HMRC send payment to?' page")
      WhoShouldHMRCSendPaymentToPage.validateNavigationAgent()
      And("User selects to send payment to Agent/Trustee")
      WhoShouldHMRCSendPaymentToPage.radioButton(WhoShouldHMRCSendPaymentToPage.AgtTtee)
      Then("User selects continue on 'Who should HMRC send payment to?' page")
      WhoShouldHMRCSendPaymentToPage.clickContinue()
      And("User navigates to 'What is your telephone number?' page")
      WhatIsYourTelephoneNumberPage.validateNavigationAgent()
      WhatIsYourTelephoneNumberPage.validatePageContentAgent()
      Then("User Inputs a Telephone Number on 'What is your telephone number?' page and clicks CONTINUE")
      WhatIsYourTelephoneNumberPage.enterAgentTelephoneNumber("0044 (0123) 456-7890")
      And("User navigates to 'Do you have a UK address?' page")
      DoYouHaveAUKAddressPage.validateNavigationAgent()
      And("User selects 'Yes' to 'Do you have a UK address'")
      DoYouHaveAUKAddressPage.radioButton(DoYouHaveAUKAddressPage.yes)
      DoYouHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What is your postcode?' page")
      WhatIsYourPostcodePage.validateNavigationAgent()
      Then(
        "User Enters Postcode and clicks CONTINUE to navigate to 'Agent's CYA Organisation' page and validates navigation"
      )
      WhatIsYourPostcodePage.enterAgentPostcode("AB1 1BA")
      CheckYourOrganisationDetailsPage.validateNavigationAgent()
      Then("User clicks CONTINUE to navigate to 'Agent's R2' page")
      CheckYourOrganisationDetailsPage.clickContinue()
      And("User navigates to 'Make a charity repayment claim' task list page")
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadingsAgent()
      And("User clicks the link to navigate to 'Add Gift Aid schedule' page")
      ClaimsTaskListPage_InProgress.clickAddGiftAidSchedule()
      Then("User navigates to 'About Gift Aid schedule' page")
      AboutGiftAidSchedulePage.validateNavigationAgent()
      AboutGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.validateNavigationAgent()
      Then("User selects a file to upload in the 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.selectFile("GiftAidSpreadsheets/Gift-Aid-Schedule-TEST")
      UploadAGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Your Gift Aid schedule upload' page")
      YourGiftAidScheduleUploadPage.validateNavigationAgent()
      YourGiftAidScheduleUploadPage.waitForFileUpload()
      YourGiftAidScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your Gift Aid schedule' page")
      CheckYourGiftAidSchedulePage.validateNavigationAgent()
      CheckYourGiftAidSchedulePage.radioButton(CheckYourGiftAidSchedulePage.no)
      CheckYourGiftAidSchedulePage.clickContinue()
      Then("User navigates and validates 'Successful Gift Aid Upload' page")
      GiftAidUploadSuccessfulPage.validateNavigationAgent()
      GiftAidUploadSuccessfulPage.validatePageParagraphAgent()
      GiftAidUploadSuccessfulPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' task list page")
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadingsAgent()
      Then("User Signs out from the top link")
      ClaimsTaskListPage_InProgress.signOut()
      ClaimsTaskListPage_InProgress.verifySignInPage("Sign in")
      Then("the user logs in through the Authority Wizard page with the same user")
      AuthWizard.login(
        HASDIRECT,
        Organisation,
        "Agent",
        "HMRC-CHAR-AGENT",
        "AGENTCHARID",
        "AG1234",
        RandomUsername
      )
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link of the Charity name of the existing unsubmitted claim, to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickFirstUnsubmittedClaimLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadingsAgent()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_InProgress.clickCheckYourRepaymentClaimDetails()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigationAgent()
      Then("User Validates the Key and Value pairs on 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(0)(
        CheckYourRepaymentClaimPage.charityNameAgent        -> "TEST AGENT CASC",
        CheckYourRepaymentClaimPage.charitiesReferenceAgent -> "X12345"
      )
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(1)(
        CheckYourRepaymentClaimPage.repaymentClaimType      -> "Gift Aid",
        CheckYourRepaymentClaimPage.claimReferenceProvided  -> "No"
      )
      Then("User clicks Change link for 'HMRC Charity Reference Number' and navigates to that page")
      CheckYourRepaymentClaimPage.clickChangeHMRCCharityReference()
      WhatIsYourHMRCReferenceNumberPage.verifyPageUrl(WhatIsYourHMRCReferenceNumberPage.changePageUrl)
      WhatIsYourHMRCReferenceNumberPage.verifyPageHeading(WhatIsYourHMRCReferenceNumberPage.pageHeadingAgent)
      Then(
        "User updates the 'HMRC Charity Reference to CH/CF' clicks continue"
      )
      WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber("CH12345")
      Then("User navigates to 'Update repayment claim details' Page")
      UpdateRepaymentClaimDetails.validateNavigation()
      UpdateRepaymentClaimDetails.radioButton(UpdateRepaymentClaimDetails.yes)
      UpdateRepaymentClaimDetails.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigationAgent()
      Then("User Validates the Key and Value pairs on 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(0)(
        CheckYourRepaymentClaimPage.charityNameAgent        -> "TEST AGENT CASC",
        CheckYourRepaymentClaimPage.charitiesReferenceAgent -> "CH12345"
      )
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(1)(
        CheckYourRepaymentClaimPage.repaymentClaimType      -> "Gift Aid",
        CheckYourRepaymentClaimPage.claimReferenceProvided  -> "No"
      )
      Then("user clicks CONTINUE from Repayment CYA")
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadingsAgent()
      And("User clicks the link to navigate to 'Provide Organisation details' page")
      ClaimsTaskListPage_InProgress.clickProvideOrganisationDetails()
      Then("User navigates to 'About the Organisation' page")
      AboutTheOrganisationPage.validateNavigation()
      And("User navigates to 'Make a charity repayment claim' task list page")
      AboutTheOrganisationPage.navigateToPage(ClaimsTaskListPage_InProgress.pageUrl)
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadingsAgent()
      Then("User navigates to 'Delete Charity Repayment claim' page")
      ClaimsTaskListPage_InProgress.clickDeleteCharityClaim()
      DeleteCharityRepaymentAgentPage.validateNavigationAgent()
      Then("User selects Yes and CONTINUE to delete the claim")
      DeleteCharityRepaymentAgentPage.radioButton(DeleteCharityRepaymentAgentPage.yes)
      DeleteCharityRepaymentAgentPage.clickContinue()
      Then("User navigates to Charities Management Frontend Agent page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
    }
  }
}
