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

class testSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation - Declaration Page Validations") {

    Scenario(
      "User navigates to the 'What adjustments have you made to this claim?' page from the Other Income flow and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE-TEST-D1-1-OI")
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
      And("User selects 'Uk tax deducted from Other Income' checkbox and clicks continue")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.OtherIncome, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
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
      And("User selects they are not registered with a regulator")
      WhatIsTheNameOfTheCharityRegulatorPage.radioButton(WhatIsTheNameOfTheCharityRegulatorPage.None)
      WhatIsTheNameOfTheCharityRegulatorPage.clickContinue()
      And("User navigates to 'Why is the charity not registered with a regulator?' page")
      WhyIsTheCharityNotRegisteredPage.validateNavigation()
      And("User selects they are excepted")
      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.LowIncome)
      WhyIsTheCharityNotRegisteredPage.clickContinue()
      And("User navigates to 'Is a corporate trustee making this claim?' page")
      IsACorporateTrusteeMakingThisClaimPage.validateNavigation()
      And("User selects a corporate trustee is making this claim")
      IsACorporateTrusteeMakingThisClaimPage.radioButton(IsACorporateTrusteeMakingThisClaimPage.yes)
      IsACorporateTrusteeMakingThisClaimPage.clickContinue()
      And("User navigates to 'Does the corporate trustee have a UK address?' page")
      DoesTheCorporateTrusteeHaveAUKAddressPage.validateNavigation()
      And("User selects a corporate trustee does not have a UK address")
      DoesTheCorporateTrusteeHaveAUKAddressPage.radioButton(DoesTheCorporateTrusteeHaveAUKAddressPage.yes)
      DoesTheCorporateTrusteeHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateNavigation()
      And("User enters their Non UK Trustee details and clicks continue")
      CorporateTrusteeDetailsPage.enterUKTrusteeDetails("TEST TRUSTEE", "01632 960999", "WG7 7FU")
      And("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.validateNavigation()
      Then("User navigates to 'Make a charity repayment claim' page")
      CheckYourOrganisationDetailsPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation()
      And("User clicks the link to navigate to 'Add Other Income schedule' page")
      ClaimsTaskListPage_InProgress.clickAddOtherIncomeSchedule()
      Then("User navigates to 'About Other Income schedule' page")
      AboutOtherIncomeSchedulePage.validateNavigation()
      AboutOtherIncomeSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Other Income schedule' page")
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
      CheckYourOtherIncomeSchedulePage.radioButton(CheckYourOtherIncomeSchedulePage.no)
      CheckYourOtherIncomeSchedulePage.clickContinue()
      Then("User navigates to 'Successful Other Income Upload' page")
      OtherIncomeUploadSuccessfulPage.validateNavigation()
      Then("User navigates to 'Make a charity repayment claim' page")
      OtherIncomeUploadSuccessfulPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation()
      Then("User navigates to 'What adjustments have you made to this claim?' page")
      ClaimsTaskListPage_InProgress.clickReadDeclaration()
      WhatAdjustmentsHaveYouMadeToThisClaimPage.validateNavigation()
      And("User validates 'What adjustments have you made to this claim?' page elements")
      WhatAdjustmentsHaveYouMadeToThisClaimPage.validatePageContent()
      And("User validates 'What adjustments have you made to this claim?' page error message")
      WhatAdjustmentsHaveYouMadeToThisClaimPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'What adjustments have you made to this claim?' page from the GASDS flow and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE-TEST-D1-1-OI")
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
      And("User selects 'Uk tax deducted from Other Income' checkbox and clicks continue")
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
      ClaimsTaskListPage_InProgress.validateNavigation()
      And("User clicks the link to navigate to 'About the organisation' page")
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
      And("User selects they are excepted")
      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.LowIncome)
      WhyIsTheCharityNotRegisteredPage.clickContinue()
      And("User navigates to 'Is a corporate trustee making this claim?' page")
      IsACorporateTrusteeMakingThisClaimPage.validateNavigation()
      And("User selects a corporate trustee is making this claim")
      IsACorporateTrusteeMakingThisClaimPage.radioButton(IsACorporateTrusteeMakingThisClaimPage.yes)
      IsACorporateTrusteeMakingThisClaimPage.clickContinue()
      And("User navigates to 'Does the corporate trustee have a UK address?' page")
      DoesTheCorporateTrusteeHaveAUKAddressPage.validateNavigation()
      And("User selects a corporate trustee does not have a UK address")
      DoesTheCorporateTrusteeHaveAUKAddressPage.radioButton(DoesTheCorporateTrusteeHaveAUKAddressPage.no)
      DoesTheCorporateTrusteeHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateNavigation()
      And("User enters their Non UK Trustee details and clicks continue")
      CorporateTrusteeDetailsPage.enterNonUKTrusteeDetails("TEST TRUSTEE", "01632 960999")
      And("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.validateNavigation()
      Then("User navigates to 'Make a charity repayment claim' page")
      CheckYourOrganisationDetailsPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation()
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
        s"User navigates to 'Which tax year are you claiming for?' page and inputs: " + WhichTaxYearAreYouClaimingForPage.earliestTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(WhichTaxYearAreYouClaimingForPage.earliestTaxYear)
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
        s"User navigates to 'Which tax year are you claiming for?' page and inputs: " + WhichTaxYearAreYouClaimingForPage.secondEarliestTaxYear
      )
      WhichTaxYearAreYouClaimingForPage.enterValidTaxYear(WhichTaxYearAreYouClaimingForPage.secondEarliestTaxYear)
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
      Then("User navigates to 'Check your GASDS donation details' page and validates page details")
      CheckYourGASDSDonationDetailsPage.validateNavigation()
      Then("User clicks CONTINUE to reach task list: 'Make a repayment Claim' Page")
      CheckYourGASDSDonationDetailsPage.clickContinue()
      And("User validates navigation to 'Make a repayment Claim' Page")
      ClaimsTaskListPage_InProgress.validateNavigation()
      Then("User navigates to 'What adjustments have you made to this claim?' page")
      ClaimsTaskListPage_InProgress.clickReadDeclaration()
      WhatAdjustmentsHaveYouMadeToThisClaimPage.validateNavigation()
      And("User validates 'What adjustments have you made to this claim?' page elements")
      WhatAdjustmentsHaveYouMadeToThisClaimPage.validatePageContent()
      And("User validates 'What adjustments have you made to this claim?' page error message")
      WhatAdjustmentsHaveYouMadeToThisClaimPage.validateErrorMessage()
    }

  }
}
