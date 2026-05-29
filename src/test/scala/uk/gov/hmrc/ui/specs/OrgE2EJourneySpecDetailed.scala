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

class OrgE2EJourneySpecDetailed
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation - E2E journeys") {
    Scenario(
      "User navigates through a full Org user journey - No Regulator - Excepted - Trustee - UK Address"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "ORGE2EJOURNEY1")
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
      RepaymentClaimDetailsPage.validateParagraph()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigation()
      RepaymentCheckboxPage.validateHint()
      Then(
        "User validates the 'no input' error on the 'Which type of repayment claim do you want to make?' checkbox page"
      )
      RepaymentCheckboxPage.validateErrorMessage()
      And("User selects all 3 checkboxes and clicks continue")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GiftAid, true)
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.OtherIncome, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigation()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContent()
      Then(
        "User validates the 'no input' error on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page"
      )
      GASDSCheckboxPage.validateErrorMessage()
      And("User selects all 3 checkboxes and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSTopUp, true)
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSBuilding, true)
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
      Then("User validates the 'no input' error on the 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateErrorMessage()
      And("User selects 'Yes' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.yes)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      Then("User validates the 'no input' error on the 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateErrorMessage()
      And("User selects 'Yes' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.yes)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      And("User navigates to 'What is your claim reference number?' page")
      WhatIsYourClaimReferenceNumberPage.validateNavigation()
      Then("User validates the elements on the 'What is your claim reference number?' page")
      WhatIsYourClaimReferenceNumberPage.validateHint()
      Then("User validates the 'no input' error on the 'What is your claim reference number?' page")
      WhatIsYourClaimReferenceNumberPage.validateErrorMessage()
      And("User enters their claim reference number and clicks continue")
      WhatIsYourClaimReferenceNumberPage.enterClaimReferenceNumber("TESTREF123")
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      Then("User Validates the Key and Value pairs on 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.assertAllSummaryPairsExactlyAt(0)(
        CheckYourRepaymentClaimPage.repaymentClaimType     -> "Gift Aid Top-up payments for small cash donations under Gift Aid Small Donations Scheme (GASDS) UK tax deducted from Other Income",
        CheckYourRepaymentClaimPage.claimReferenceProvided -> "Yes",
        CheckYourRepaymentClaimPage.claimReferenceNumber   -> "TESTREF123",
        CheckYourRepaymentClaimPage.GASDSClaimType         -> "GASDS top-up payment Community Buildings top-up payment Connected Charity or CASC claim",
        CheckYourRepaymentClaimPage.GASDSAdjustment        -> "Yes"
      )
      Then("User navigates to 'Make a charity repayment claim' page")
      CheckYourRepaymentClaimPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      ClaimsTaskListPage_InProgress.validateTaskList1_RC_OI_GI()
      ClaimsTaskListPage_InProgress.validateTaskList2_GA_OI_CB_CC()
      ClaimsTaskListPage_InProgress.validateTaskList3_NoDeclaration()
      And("User clicks the link to navigate to 'About the organisation' page")
      ClaimsTaskListPage_InProgress.clickProvideOrganisationDetails()
      AboutTheOrganisationPage.validateNavigation()
      AboutTheOrganisationPage.validatePageContent()
      Then("User selects continue on 'About the organisation' page")
      AboutTheOrganisationPage.clickContinue()
      And("User navigates to 'What is the name of the charity regulator?' page")
      WhatIsTheNameOfTheCharityRegulatorPage.validateNavigation()
      Then("User validates the 'no input' error on the 'What is the name of the charity regulator?' page")
      WhatIsTheNameOfTheCharityRegulatorPage.validateErrorMessage()
      And("User clicks 'Charity is not registered with a regulator' radio button option")
      WhatIsTheNameOfTheCharityRegulatorPage.radioButton(WhatIsTheNameOfTheCharityRegulatorPage.None)
      And("User clicks 'Continue' button")
      WhatIsTheNameOfTheCharityRegulatorPage.clickContinue()
      And("User navigates to 'Why is the charity not registered with a regulator?' page")
      WhyIsTheCharityNotRegisteredPage.validateNavigation()
      Then("User validates the 'no input' error on the 'Why is the charity not registered with a regulator?' page")
      WhyIsTheCharityNotRegisteredPage.validateErrorMessage()
      And("User clicks 'Charity is not registered with a regulator' radio button option")
      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.Excepted)
      And("User clicks 'Continue' button")
      WhyIsTheCharityNotRegisteredPage.clickContinue()
      And("User navigates to 'Your charity is excepted' page")
      YourCharityIsExceptedPage.validateNavigation()
      Then("User validates the elements on the 'Your charity is excepted' page")
      YourCharityIsExceptedPage.validateParagraph()
      Then("User selects continue on 'Your charity is excepted' page")
      YourCharityIsExceptedPage.clickContinue()
      And("User navigates to 'Is a corporate trustee making this claim?' page")
      IsACorporateTrusteeMakingThisClaimPage.validateNavigation()
      Then("User validates the 'no input' error on the 'Is a corporate trustee making this claim?' page")
      IsACorporateTrusteeMakingThisClaimPage.validateErrorMessage()
      And("User selects a corporate trustee is making this claim")
      IsACorporateTrusteeMakingThisClaimPage.radioButton(IsACorporateTrusteeMakingThisClaimPage.yes)
      IsACorporateTrusteeMakingThisClaimPage.clickContinue()
      And("User navigates to 'Does the corporate trustee have a UK address?' page")
      DoesTheCorporateTrusteeHaveAUKAddressPage.validateNavigation()
      Then("User validates the 'no input' error on the 'Does the corporate trustee have a UK address?' page")
      DoesTheCorporateTrusteeHaveAUKAddressPage.validateErrorMessage()
      And("User selects a corporate trustee does have a UK address")
      DoesTheCorporateTrusteeHaveAUKAddressPage.radioButton(DoesTheCorporateTrusteeHaveAUKAddressPage.yes)
      DoesTheCorporateTrusteeHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateNavigation()
      Then("User validates the 'no input' error on the UK address 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateUKAddressErrorMessages()
      Then("User validates the name errors on the 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateCorporateTrusteeNameErrorMessages()
      Then("User validates the phone number errors on the 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateCorporateTrusteePhoneErrorMessages()
      Then("User validates the postcode errors on the 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateCorporateTrusteePostcodeErrorMessages()
      And("User enters their Non UK Trustee details and clicks continue")
      CorporateTrusteeDetailsPage.enterUKTrusteeDetails("TEST TRUSTEE", "01632 960999", "WG7 7FU")
      And("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.validateNavigation()
      Then("User Validates the Key and Value pairs on 'CYA Organisation Details' page and Submits")
      CheckYourOrganisationDetailsPage.assertAllSummaryPairsExactlyAt(0)(
        "Charity regulator name"                           -> "Charity is not registered with a regulator",
        "Registered with regulator"                        -> "Your charity is excepted Your charity is excepted as the charity’s annual income is £100,000 or less and is classed as one of the following: a church or chapel a charity that provides premises for schools a scout or guide group a charitable service of the armed forces a students’ union",
        "Is the corporate trustee making this claim?"      -> "Yes"
      )
      CheckYourOrganisationDetailsPage.assertAllSummaryPairsExactlyAt(1)(
        "UK address"                                       -> "Yes",
        "Trustee’s details"                                -> "TEST TRUSTEE 01632 960999 WG7 7FU"
      )
      And("User navigates to 'Make a charity repayment claim' task list page")
      CheckYourOrganisationDetailsPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      ClaimsTaskListPage_InProgress.validateTaskList1_RC_OC_GI()
      And("User clicks the link to navigate to 'About Gift Aid Small Donations Scheme schedule' page")
      ClaimsTaskListPage_InProgress.clickProvideGASDSDetails()
      And("User Validates the navigation to 'About Gift Aid Small Donations Scheme schedule' page")
      AboutGASDSPage.validateNavigation()
      Then("User Validates page content heading/caption/paragraph/button texts on about GASDS page")
      AboutGASDSPage.validatePageContent()
      Then("User navigates to 'What is the adjustment amount for Gift Aid previously overclaimed?' page")
      AboutGASDSPage.clickContinue()
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.validateNavigation()
      Then("User validates content on 'What is the adjustment amount for Gift Aid previously overclaimed?' page")
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.verifyAmountHintText()
      Then("User validates error messages on 'What is the adjustment amount for Gift Aid previously overclaimed?' page")
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.validateErrorMessage()
      Then("User navigates to 'Check your GASDS adjustment amount' page")
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.enterAdjustmentAmountValue("123.45")
      And("Validates Navigation of the 'Check your GASDS adjustment amount' page")
      CheckYourGASDSAdjustmentAmountPage.validateNavigation()
      Then("User validates content on 'Check your GASDS adjustment amount' page")
      CheckYourGASDSAdjustmentAmountPage.assertAllSummaryPairsExactlyAt(0)(
        "Amount of GASDS previously overclaimed"           -> "£123.45"
      )
      Then("User navigates to 'Which tax year are you claiming for?' year 1 page")
      CheckYourGASDSAdjustmentAmountPage.clickContinue()
      WhichTaxYearAreYouClaimingForPage.validateNavigation1()
      Then("User validates the error messages on 'Which Tax Year Are You Claiming For' Page 1")
      WhichTaxYearAreYouClaimingForPage.validateErrorMessages1()
      Then(
        s"User inputs " + WhichTaxYearAreYouClaimingForPage.earliestTaxYear + " on 'Which tax year are you claiming for?' page"
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(WhichTaxYearAreYouClaimingForPage.earliestTaxYear)
      Then("User navigates to 'What donation amount are you claiming, in pounds?' for the first year page")
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateNavigation_Year1()
      Then(
        "User Validates hint text on 'What donation amount are you claiming, in pounds?' for the first year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyAmountHintText()
      Then(
        "User Validates error messages on 'What donation amount are you claiming, in pounds?' for the first year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateErrorMessage_Year1()
      Then(
        "User inputs a value on 'What donation amount are you claiming under GASDS, in pounds?' for the first year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.enterDonationAmount("1.11")
      Then("User navigates to 'Check your claim details for tax year 1' page")
      CheckYourClaimDetailsForTaxYearPage.validateNavigation1()
      CheckYourClaimDetailsForTaxYearPage.assertAllSummaryPairsExactlyAt(0)(
        "Tax year"                                         -> WhichTaxYearAreYouClaimingForPage.earliestTaxYear,
        "Donation amount"                                  -> "£1.11"
      )
      Then("User navigates to 'You have added a claim for 1 tax year' page")
      CheckYourClaimDetailsForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation1()
      YouHaveAddedAClaimForXTaxYearPage.validateFormFieldset_Year1()
      Then(
        "User validates the 'no input' error on the 'You have added a claim for X tax year' checkbox page"
      )
      YouHaveAddedAClaimForXTaxYearPage.validateErrorMessage()
      Then("User selects 'Yes' on 'You have added a claim for 1 tax year' page to add another tax year")
      YouHaveAddedAClaimForXTaxYearPage.radioButton(YouHaveAddedAClaimForXTaxYearPage.yes)
      YouHaveAddedAClaimForXTaxYearPage.clickContinue()
      Then("User navigates to 'Which tax year are you claiming for?' year 2 page")
      WhichTaxYearAreYouClaimingForPage.validateNavigation2()
      Then(
        s"User navigates to 'Which tax year are you claiming for?' page and inputs to generate duplicate error: " + WhichTaxYearAreYouClaimingForPage.earliestTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.inputDuplicateTaxYear(WhichTaxYearAreYouClaimingForPage.earliestTaxYear)
      WhichTaxYearAreYouClaimingForPage.validateDuplicateErrorMessage(
        WhichTaxYearAreYouClaimingForPage.pageErrorDuplicateYear,
        WhichTaxYearAreYouClaimingForPage.yearInputErrorLocator
      )
      Then(
        s"User on 'Which tax year are you claiming for?' page inputs: " + WhichTaxYearAreYouClaimingForPage.secondEarliestTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(WhichTaxYearAreYouClaimingForPage.secondEarliestTaxYear)
      Then("User navigates to 'What donation amount are you claiming under GASDS, in pounds?' for the second year page")
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateNavigation_Year2()
      Then(
        "User Validates error messages on 'What donation amount are you claiming, in pounds?' for the second year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.validateErrorMessage_Year2()
      Then(
        "User inputs a value on 'What donation amount are you claiming under GASDS, in pounds?' for the second year page"
      )
      WhatDonationAmountAreYouClaimingUnderGASDSPage.enterDonationAmount("2.22")
      Then("User navigates to 'Check your claim details for tax year 2' page")
      CheckYourClaimDetailsForTaxYearPage.validateNavigation2()
      CheckYourClaimDetailsForTaxYearPage.assertAllSummaryPairsExactlyAt(0)(
        "Tax year"                                         -> WhichTaxYearAreYouClaimingForPage.secondEarliestTaxYear,
        "Donation amount"                                  -> "£2.22"
      )
      Then("User navigates to 'You have added a claim for 2 tax years' page")
      CheckYourClaimDetailsForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation2()
      YouHaveAddedAClaimForXTaxYearPage.validateFormFieldset_Year2()
      Then("User selects 'Yes' on 'You have added a claim for 2 tax year' page to add another tax year")
      YouHaveAddedAClaimForXTaxYearPage.radioButton(YouHaveAddedAClaimForXTaxYearPage.yes)
      YouHaveAddedAClaimForXTaxYearPage.clickContinue()
      Then("User navigates to 'Which tax year are you claiming for?' year 3 page")
      WhichTaxYearAreYouClaimingForPage.validateNavigation3()
      Then(
        s"User navigates to 'Which tax year are you claiming for?' page and inputs: " + WhichTaxYearAreYouClaimingForPage.recentTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(WhichTaxYearAreYouClaimingForPage.recentTaxYear)
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
      Then("User validates error messages on 'Remove claim for tax year' page")
      RemoveClaimForTaxYearPage.validateErrorMessage()
      Then("User confirms to remove the 2nd tax year from 'You have added a claim for 3 tax years' page")
      RemoveClaimForTaxYearPage.radioButton(RemoveClaimForTaxYearPage.yes)
      Then("User navigates to 'You have added a claim for 2 tax years' page")
      RemoveClaimForTaxYearPage.clickContinue()
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation2()
      Then("User selects 'No' on 'You have added a claim for 2 tax year' page to add another tax year")
      YouHaveAddedAClaimForXTaxYearPage.radioButton(YouHaveAddedAClaimForXTaxYearPage.no)
      YouHaveAddedAClaimForXTaxYearPage.clickContinue()
      Then("User navigates to 'Check your GASDS donation details' page and validates page details")
      CheckYourGASDSDonationDetailsPage.validateNavigation()
      And("User validates the sub-headings of Adjustment Amount and GASDS Claims Tax Years")
      CheckYourGASDSDonationDetailsPage.validateGASDSAdjustmentHeading()
      CheckYourGASDSDonationDetailsPage.validateGASDSClaimTaxHeading()
      Then("User Validates the Key and Value pairs on 'Check your GASDS Donation Details' Page")
      CheckYourGASDSDonationDetailsPage.assertAllSummaryPairsExactlyAt(0)(
        "Amount of GASDS previously overclaimed"           -> "£123.45"
      )
      CheckYourGASDSDonationDetailsPage.assertAllSummaryPairsExactlyAt(1)(
        "Number of tax years added"                        -> "2"
      )
      Then("User Clicks 'Change' Link of GASDS Previously overclaimed Adjustment Amount")
      CheckYourGASDSDonationDetailsPage.clickChangeGASDSAdjustmentAmount()
      And("User navigates to 'Check Your GASDS Adjustment Amount page' and validates Navigation")
      CheckYourGASDSAdjustmentAmountPage.validateChangeNavigation()
      Then("User Clicks CONTINUE to reach directly to 'Check your GASDS Donation details' Page")
      CheckYourGASDSAdjustmentAmountPage.clickContinue()
      And("Validates Navigation of Check your GASDS Donation Details Page")
      CheckYourGASDSDonationDetailsPage.validateNavigation()
      Then("User Clicks 'Change' Link of GASDS Number of Tax Years Added ")
      CheckYourGASDSDonationDetailsPage.clickChangeGASDSTaxYears()
      Then("User navigates to 'You have added a claim for 2 tax years' page")
      YouHaveAddedAClaimForXTaxYearPage.validateNavigation2()
      Then("User selects 'No' on 'You have added a claim for 2 tax year' page to add another tax year")
      YouHaveAddedAClaimForXTaxYearPage.radioButton(YouHaveAddedAClaimForXTaxYearPage.no)
      YouHaveAddedAClaimForXTaxYearPage.clickContinue()
      Then("User navigates to 'Check your GASDS donation details' page and validates page details")
      CheckYourGASDSDonationDetailsPage.validateNavigation()
      Then("User clicks CONTINUE to reach task list: 'Make a repayment Claim' Page")
      CheckYourGASDSDonationDetailsPage.clickConfirmAndSubmit()
      And("User validates navigation to 'Make a repayment Claim' Page")
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      And("User clicks the link to navigate to 'Add Gift Aid schedule' page")
      ClaimsTaskListPage_InProgress.clickAddGiftAidSchedule()
      Then("User navigates to 'About Gift Aid schedule' page")
      AboutGiftAidSchedulePage.validateNavigation()
      AboutGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.validateNavigation()
      Then("User validates the elements on the 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.validatePageContent()
      Then("User selects a file to upload in the 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.selectFile("GiftAidSpreadsheets/Gift-Aid-Schedule-SIMPLEFAIL")
      UploadAGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Your Gift Aid schedule upload' page")
      YourGiftAidScheduleUploadPage.validateNavigation()
      YourGiftAidScheduleUploadPage.waitForFileUpload()
      YourGiftAidScheduleUploadPage.clickContinue()
      Then("User navigates to 'There is a problem with the data in your Gift Aid schedule' page")
      CheckYourGiftAidScheduleErrorPage.validateNavigation()
      And("User selects 'Delete Schedule' on 'There is a problem with the data in your Gift Aid schedule' page")
      CheckYourGiftAidScheduleErrorPage.clickDeleteScheduleLink()
      Then("User navigates to 'Do you want to delete this Gift Aid schedule?' page")
      DeleteGiftAidSchedulePage.validateNavigation()
      Then("User validates the 'no input' error on the 'Do you want to delete this Gift Aid schedule?' page")
      DeleteGiftAidSchedulePage.validateErrorMessage()
      And("User selects 'Yes' and clicks continue on 'Do you want to delete this Gift Aid schedule?' page")
      DeleteGiftAidSchedulePage.radioButton(DeleteGiftAidSchedulePage.yes)
      DeleteGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      Then("User navigates to 'About Gift Aid schedule' page")
      And("User clicks the link to navigate to 'Add Gift Aid schedule' page")
      ClaimsTaskListPage_InProgress.clickAddGiftAidSchedule()
      AboutGiftAidSchedulePage.validateNavigation()
      AboutGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.validateNavigation()
      Then("User selects a file to upload in the 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.selectFile("GiftAidSpreadsheets/Gift-Aid-Schedule-SIMPLEPASS_MAX_ROWS_OVERCLAIMED")
      UploadAGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Your Gift Aid schedule upload' page")
      YourGiftAidScheduleUploadPage.validateNavigation()
      YourGiftAidScheduleUploadPage.waitForFileUpload()
      YourGiftAidScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your Gift Aid schedule' page")
      CheckYourGiftAidSchedulePage.validateNavigation()
      // TODO no input error
      CheckYourGiftAidSchedulePage.radioButton(CheckYourGiftAidSchedulePage.no)
      CheckYourGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Successful Gift Aid Upload' page")
      GiftAidUploadSuccessfulPage.validateNavigation()
      Then("User navigates to 'Make a charity repayment claim' page")
      GiftAidUploadSuccessfulPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      // TODO docs in progress
      ClaimsTaskListPage_InProgress.clickAddOtherIncomeSchedule()
      Then("User navigates to 'About Other Income schedule' page")
      AboutOtherIncomeSchedulePage.validateNavigation()
      AboutOtherIncomeSchedulePage.clickContinue()
      Then("User navigates to 'Upload an Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.validateNavigation()
      Then("User validates the elements on the 'Upload an Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.validatePageContent()
      Then("User validates the 'no input' error on the 'Upload an Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.validateNoInputErrorMessage()
      Then("User selects a file of over 250KB to upload in the 'Upload an Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.selectFile("OtherIncomeSpreadsheets/Other-Income-Schedule-Oversize")
      UploadAnOtherIncomeSchedulePage.clickContinue()
      Then("User validates the 'file must be smaller than 250KB' error on the 'Upload an Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.validateOversizeErrorMessage()
      Then("User selects a file to upload in the 'Upload an Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.selectFile("OtherIncomeSpreadsheets/Other-Income-Schedule-BadData")
      UploadAnOtherIncomeSchedulePage.clickContinue()
      Then("User navigates to 'Your Other Income schedule upload' page")
      YourOtherIncomeScheduleUploadPage.validateNavigation()
      YourOtherIncomeScheduleUploadPage.waitForFileUpload()
      YourOtherIncomeScheduleUploadPage.clickContinue()
      Then("User navigates to 'Problem with your Other Income schedule data' page and validates page")
      CheckYourOtherIncomeScheduleErrorPage.validateNavigation()
      Then("User validates the static text on 'Problem with your Other Income schedule data' page")
      CheckYourOtherIncomeScheduleErrorPage.validatePageContent()
      Then("User clicks on the Delete Schedule link and reaches the Delete Schedule WRN 1.0 page")
      CheckYourOtherIncomeScheduleErrorPage.clickDeleteScheduleLink()
      Then("User validates navigation of Delete Schedule WRN 1.0 page")
      DeleteOtherIncomeSchedulePage.validateNavigation()
      Then("User clicks back to reach 'problem with your Other Income schedule' page")
      DeleteOtherIncomeSchedulePage.clickBackLink()
      Then("User reaches the 'problem with your Other Income schedule page' and validates the navigation")
      CheckYourOtherIncomeScheduleErrorPage.validateNavigation()
      Then(
        "User clicks on 'Attach an updated Other Income schedule' that deletes the invalid ODS and navigates to" +
          " 'upload a Other Income schedule page O1.1' "
      )
      CheckYourOtherIncomeScheduleErrorPage.clickAttachUpdatedSchedule()
      Then("User validates navigation of 'upload a Other Income schedule page O1.1' ")
      UploadAnOtherIncomeSchedulePage.validateNavigation()
      Then("User selects a file to upload in the 'Upload a Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.selectFile("OtherIncomeSpreadsheets/Other-Income-Schedule-GoodData")
      UploadAnOtherIncomeSchedulePage.clickContinue()
      Then("User navigates to 'Your Other Income schedule upload' page")
      YourOtherIncomeScheduleUploadPage.validateNavigation()
      YourOtherIncomeScheduleUploadPage.waitForFileUpload()
      YourOtherIncomeScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your Other Income schedule' page")
      CheckYourOtherIncomeSchedulePage.validateNavigation()
      Then("User validates content on 'Check your Other Income schedule' page")
      CheckYourOtherIncomeSchedulePage.validateSummaryCard()
      CheckYourOtherIncomeSchedulePage.validateFormFieldset()
      Then("User validates the 'no input' error on the 'Check your Other Income schedule' page")
      CheckYourOtherIncomeSchedulePage.validateErrorMessage()
      Then("User selects the 'no' to upload another spreadsheet on the 'Check your Other Income schedule' page")
      CheckYourOtherIncomeSchedulePage.radioButton(CheckYourOtherIncomeSchedulePage.no)
      CheckYourOtherIncomeSchedulePage.clickContinue()
      Then("User navigates and validates 'Successful Other Income Upload' page")
      OtherIncomeUploadSuccessfulPage.validateNavigation()
      OtherIncomeUploadSuccessfulPage.validatePageContent()
      Then("User navigates to 'Make a charity repayment claim' page")
      OtherIncomeUploadSuccessfulPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      // TODO docs in progress
      And("User clicks the link to navigate to 'Add Community Buildings schedule' page")
      ClaimsTaskListPage_InProgress.clickAddCommunityBuildingsSchedule()
      Then("User navigates to 'About Community Buildings schedule' page")
      AboutCommunityBuildingsSchedulePage.validateNavigation()
      AboutCommunityBuildingsSchedulePage.validatePageContent()
      Then("User navigates to 'Upload a Community Buildings schedule' page")
      AboutCommunityBuildingsSchedulePage.clickContinue()
      UploadACommunityBuildingsSchedulePage.validateNavigation()
      Then("User validates the elements on the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.validatePageContent()
      Then("User validates the 'no input' error on the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.validateNoInputErrorMessage()
      Then("User selects a file to upload in the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.selectFile("GiftAidSpreadsheets/Gift-Aid-Schedule-TESTSIZE")
      UploadACommunityBuildingsSchedulePage.clickContinue()
      Then("User validates the 'file above size limit' error on the 'Check your Gift Aid schedule' page")
      UploadACommunityBuildingsSchedulePage.validateOversizeErrorMessage()
      Then("User selects a file to upload in the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.selectFile(
        "CommunityBuildingsSpreadsheets/community-buildings-excel-BadData"
      )
      UploadACommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Your Community Buildings schedule upload' page")
      YourCommunityBuildingsScheduleUploadPage.validateNavigation()
      YourCommunityBuildingsScheduleUploadPage.waitForFileUpload()
      YourCommunityBuildingsScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your Community Buildings schedule' page")
      CheckYourCommunityBuildingsScheduleErrorPage.validateNavigation()
      Then("User validates the static text on 'Problem with your Community Buildings schedule data' page")
      CheckYourCommunityBuildingsScheduleErrorPage.validatePageContent()
      Then("User clicks on the Delete Schedule link and reaches the Delete Schedule WRN 1.2 page")
      CheckYourCommunityBuildingsScheduleErrorPage.clickDeleteScheduleLink()
      Then("User validates navigation of Delete Schedule WRN 1.2 page")
      DeleteGASDSCommunityBuildingsSchedulePage.validateNavigation()
      Then("User clicks back to reach 'problem with your CBS' page")
      DeleteGASDSCommunityBuildingsSchedulePage.clickBackLink()
      Then("User reaches the 'problem with your CBS page' and validates the navigation")
      CheckYourCommunityBuildingsScheduleErrorPage.validateNavigation()
      Then(
        "User clicks on 'Attach an updated Community Buildings schedule' that deletes the invalid ODS and navigates to" +
          " 'upload a CBS page B1.1' "
      )
      CheckYourCommunityBuildingsScheduleErrorPage.clickAttachUpdatedSchedule()
      Then("User validates navigation of 'upload a CBS page B1.1'")
      UploadACommunityBuildingsSchedulePage.validateNavigation()
      Then("User selects the service navigation to return to the initial dashboard")
      UploadACommunityBuildingsSchedulePage.clickServiceNavLink()
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Continue claim' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickContinueClaimLink()
      // TODO task in progress validation
      And("User clicks the link to navigate to 'Add Community Buildings schedule' page")
      ClaimsTaskListPage_InProgress.clickAddCommunityBuildingsSchedule()
      Then("User navigates to 'About Community Buildings schedule' page")
      AboutCommunityBuildingsSchedulePage.validateNavigation()
      Then("User navigates to 'Upload a Community Buildings schedule' page")
      AboutCommunityBuildingsSchedulePage.clickContinue()
      UploadACommunityBuildingsSchedulePage.validateNavigation()
      Then("User selects a file to upload in the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.selectFile(
        "CommunityBuildingsSpreadsheets/CommunityBuildingsPassRows"
      )
      UploadACommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Your Community Buildings schedule upload' page")
      YourCommunityBuildingsScheduleUploadPage.validateNavigation()
      YourCommunityBuildingsScheduleUploadPage.waitForFileUpload()
      YourCommunityBuildingsScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your Community Buildings schedule' page")
      CheckYourCommunityBuildingsSchedulePage.validateNavigation()
      Then("User validates content on 'Check your Community Buildings schedule' page")
      CheckYourCommunityBuildingsSchedulePage.validateSummaryCard()
      CheckYourCommunityBuildingsSchedulePage.validateFormFieldset()
      Then("User validates the 'no input' error on the 'Check your Community Buildings schedule' page")
      CheckYourCommunityBuildingsSchedulePage.validateErrorMessage()
      Then("User selects the 'no' to upload another spreadsheet on the 'Check your Community Buildings schedule' page")
      CheckYourCommunityBuildingsSchedulePage.radioButton(CheckYourCommunityBuildingsSchedulePage.no)
      CheckYourCommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates and validates 'Successful Community Buildings Upload' page")
      CommunityBuildingsScheduleUploadSuccessfulPage.validateNavigation()
      CommunityBuildingsScheduleUploadSuccessfulPage.validatePageParagraph()
      Then("User navigates to 'Make a charity repayment claim' page")
      CommunityBuildingsScheduleUploadSuccessfulPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
//      //TODO task list progress validation
      And("User clicks the link to navigate to 'Add Connected Charities schedule' page")
      ClaimsTaskListPage_InProgress.clickAddConnectedCharitiesSchedule()
      Then("User navigates to 'About Connected Charities schedule' page")
      AboutConnectedCharitiesSchedulePage.validateNavigation()
      AboutConnectedCharitiesSchedulePage.validatePageContent()
      AboutConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNavigation()
      Then("User validates the elements on the 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.validatePageContent()
      Then("User validates the 'no input' error on the 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNoInputErrorMessage()
      Then("User selects a file of over 250KB to upload in the 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.selectFile(
        "ConnectedCharitiesSpreadsheets/Connected-Charities-schedule-oversize"
      )
      UploadAConnectedCharitiesSchedulePage.clickContinue()
      Then(
        "User validates the 'file must be smaller than 250KB' error on the 'Upload a Connected Charities schedule' page"
      )
      UploadAConnectedCharitiesSchedulePage.validateOversizeErrorMessage()
      Then("User selects a file to upload in the 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.selectFile(
        "ConnectedCharitiesSpreadsheets/Connected-Charities-schedule-Excel-BadData"
      )
      UploadAConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Your Connected Charities schedule upload' page")
      YourConnectedCharitiesScheduleUploadPage.validateNavigation()
      YourConnectedCharitiesScheduleUploadPage.waitForFileUpload()
      YourConnectedCharitiesScheduleUploadPage.clickContinue()
      Then("User navigates to 'Problem with your Connected Charities schedule data' page and validates page")
      CheckYourConnectedCharitiesScheduleErrorPage.validateNavigation()
      Then("User validates the static text on 'Problem with your Connected Charities schedule data' page")
      CheckYourConnectedCharitiesScheduleErrorPage.validatePageContent()
      Then("User clicks on the Delete Schedule link and reaches the Delete Schedule WRN 1.0 page")
      CheckYourConnectedCharitiesScheduleErrorPage.clickDeleteScheduleLink()
      Then("User validates navigation of Delete Schedule WRN 1.0 page")
      DeleteGASDSConnectedCharitiesSchedulePage.validateNavigation()
      Then("User clicks back to reach 'problem with your Connected Charities schedule' page")
      DeleteGASDSConnectedCharitiesSchedulePage.clickBackLink()
      Then("User reaches the 'problem with your Connected Charities schedule page' and validates the navigation")
      CheckYourConnectedCharitiesScheduleErrorPage.validateNavigation()
      Then(
        "User clicks on 'Attach an updated Connected Charities schedule' that deletes the invalid ODS and navigates to" +
          " 'upload a Connected Charities schedule page CC1.1' "
      )
      CheckYourConnectedCharitiesScheduleErrorPage.clickAttachUpdatedSchedule()
      Then("User validates navigation of 'upload a Connected Charities schedule page CC1.1' ")
      UploadAConnectedCharitiesSchedulePage.validateNavigation()
      Then("User selects a file to upload in the 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.selectFile(
        "ConnectedCharitiesSpreadsheets/Connected-Charities-schedule-Excel-GoodData"
      )
      UploadAConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Your Connected Charities upload' page")
      YourConnectedCharitiesScheduleUploadPage.validateNavigation()
      YourConnectedCharitiesScheduleUploadPage.waitForFileUpload()
      YourConnectedCharitiesScheduleUploadPage.validateParagraph()
      YourConnectedCharitiesScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your Connected Charities schedule' page")
      CheckYourConnectedCharitiesSchedulePage.validateNavigation()
      Then("User validates content on 'Check your Connected Charities schedule' page")
      CheckYourConnectedCharitiesSchedulePage.validateFormFieldset()
      Then("User validates the 'no input' error on the 'Check your Connected Charities schedule' page")
      CheckYourConnectedCharitiesSchedulePage.validateErrorMessage()
      Then("User selects the 'no' to upload another spreadsheet on the 'Check your Connected Charities schedule' page")
      CheckYourConnectedCharitiesSchedulePage.radioButton(CheckYourConnectedCharitiesSchedulePage.no)
      CheckYourConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates and validates 'Successful Connected Charities Upload' page")
      ConnectedCharitiesUploadSuccessfulPage.validateNavigation()
      ConnectedCharitiesUploadSuccessfulPage.validatePageParagraph()
      Then("User navigates to 'Make a charity repayment claim' page")
      ConnectedCharitiesUploadSuccessfulPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      Then("User navigates to 'What adjustments have you made to this claim?' page")
      ClaimsTaskListPage_InProgress.clickReadDeclaration()
      WhatAdjustmentsHaveYouMadeToThisClaimPage.validateNavigation()
      And("User validates 'What adjustments have you made to this claim?' page elements")
      WhatAdjustmentsHaveYouMadeToThisClaimPage.validatePageContent()
      And("User validates 'What adjustments have you made to this claim?' page error message")
      WhatAdjustmentsHaveYouMadeToThisClaimPage.validateErrorMessage()
      Then("User inputs details on 'Declaration' page")
      WhatAdjustmentsHaveYouMadeToThisClaimPage.enterAdjustmentDetails("TEST ADJUSTMENT INPUT")
      DeclarationPage.validateNavigation()
      And("User validates 'Declaration' page elements")
      DeclarationPage.validatePageContent()
      Then("User navigates to 'Claim complete' page")
      DeclarationPage.clickConfirmAndSubmit()
      ClaimCompletePage.validateNavigation()
//      And("User validates 'Claim complete' page elements")
//      ClaimCompletePage.validatePageContent()
//      And("User validates Submission Reference Number is in BASE32 format")
//      ClaimCompletePage.verifySubmissionReferenceBase32()
//      And("User validates Gift Aid, Other Income and Adjustment Headings on Page")
//      CharityRepaymentClaimSummaryPage.validateGiftAidHeading()
//      CharityRepaymentClaimSummaryPage.validateOtherIncomeHeading()
//      CharityRepaymentClaimSummaryPage.validateAdjustmentHeading()
//      Then("User Validates the Gift aid data extracted from GA ODS")
//      CharityRepaymentClaimSummaryPage.assertAllSummaryPairsExactlyAt(1)(
//        "Number of Gift Aid donations" -> "1000",
//        "Total value of Gift Aid donations claimed" -> "£1000.00"
//      )
//      Then("User Validates the Other Income data extracted from OI ODS")
//      CharityRepaymentClaimSummaryPage.assertAllSummaryPairsExactlyAt(2)(
//        "Number of Other Income items" -> "5",
//        "Total value of Other Income claimed" -> "£126.00"
//      )
//      And("User Validates the Adjustment overclaimed amount summation of GA and OI")
//      CharityRepaymentClaimSummaryPage.assertAllSummaryPairsExactlyAt(3)(
//        "Total tax relief overclaimed in Gift Aid and Other Income" -> "£1000000000.00"
//      )
//      Then(
//        "User Validates the 3 links: 'Print Summary', 'Log out and go back HMRC online services' and 'Go to Your HMRC services exist'"
//      )
//      CharityRepaymentClaimSummaryPage.validateSummaryPageLinks()
    }
  }
}
