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

class SubmissionSpec

  extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation - Submission Validations") {
    Scenario(
      "User submits gift aid from ConnectedCharities/CommunityBuildings and validates submission"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE-TEST-Submission-CC-CB")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue")
      RepaymentCheckboxPage.validateNavigation()
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page")
      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
      And(
        "User selects 'No' and clicks continue on 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
      )
      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouWantToClaimATopUpUnderGASDSPage.no)
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
      And("User selects 'No' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.no)
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
      ClaimsTaskListPage_InProgress.validateNavigation()
      And("User clicks the link to navigate to 'About the organisation' page")
      ClaimsTaskListPage_InProgress.clickProvideOrganisationDetails()
      AboutTheOrganisationPage.validateNavigation()
      Then("User selects continue on 'About the organisation' page")
      AboutTheOrganisationPage.clickContinue()
      And("User navigates to 'What is the name of the charity regulator?' page")
      WhatIsTheNameOfTheCharityRegulatorPage.validateNavigation()
      And("User selects they are not registered with a regulator")
      WhatIsTheNameOfTheCharityRegulatorPage.radioButton(WhatIsTheNameOfTheCharityRegulatorPage.EngWal)
      WhatIsTheNameOfTheCharityRegulatorPage.clickContinue()
      And("User navigates to 'Why is the charity not registered with a regulator?' page")
      WhatIsYourCharityRegulatorNumberPage.validateNavigation()
      And("User inputs a Charity Regulator number")
      WhatIsYourCharityRegulatorNumberPage.enterCharityRegulatorNumber("123456")
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
      CorporateTrusteeDetailsPage.enterNonUKTrusteeDetails("TEST TRUSTEE", "00-1-332-555-2368")
      And("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.validateNavigation()
      Then("User navigates to 'Make a charity repayment claim' page")
      CheckYourOrganisationDetailsPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation()
      And("User clicks the link to navigate to 'Add Community Buildings schedule' page")
      ClaimsTaskListPage_InProgress.clickAddCommunityBuildingsSchedule()
      Then("User navigates to 'About Community Buildings schedule' page")
      AboutCommunityBuildingsSchedulePage.validateNavigation()
      AboutCommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.validateNavigation()
      Then("User selects a file to upload in the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.selectFile(
        "CommunityBuildingsSpreadsheets/CommunityBuildingsPassRows"
      )
      UploadACommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Community Buildings schedule' page")
      YourCommunityBuildingsScheduleUploadPage.validateNavigation()
      YourCommunityBuildingsScheduleUploadPage.waitForFileUpload()
      YourCommunityBuildingsScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your community buildings schedule' page")
      CheckYourCommunityBuildingsSchedulePage.validateNavigation()
      CheckYourCommunityBuildingsSchedulePage.radioButton(CheckYourCommunityBuildingsSchedulePage.no)
      CheckYourCommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Community Buildings schedule upload successful' page ")
      CommunityBuildingsScheduleUploadSuccessfulPage.validateNavigation()
      CommunityBuildingsScheduleUploadSuccessfulPage.validatePageParagraph()
      CommunityBuildingsScheduleUploadSuccessfulPage.clickContinue()
      Then("User navigates to 'Add Connected Charities schedule'")
      ClaimsTaskListPage_InProgress.clickAddConnectedCharitiesSchedule()
      Then("User navigates to 'About Connected Charities schedule' page")
      AboutConnectedCharitiesSchedulePage.validateNavigation()
      AboutConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNavigation()
      Then("User selects a file to upload in the 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.selectFile(
        "ConnectedCharitiesSpreadsheets/Connected-Charities-schedule-Excel-GoodData"
      )
      UploadAConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Your Connected Charities schedule upload' page")
      YourConnectedCharitiesScheduleUploadPage.validateNavigation()
      YourConnectedCharitiesScheduleUploadPage.waitForFileUpload()
      YourConnectedCharitiesScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your Connected Charities schedule' page")
      CheckYourConnectedCharitiesSchedulePage.validateNavigation()
      CheckYourConnectedCharitiesSchedulePage.radioButton(CheckYourConnectedCharitiesSchedulePage.no)
      CheckYourConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates and validates 'Successful Connected Charities Upload' page ")
      ConnectedCharitiesUploadSuccessfulPage.validateNavigation()
      ConnectedCharitiesUploadSuccessfulPage.validatePageParagraph()
      Then("User navigates to 'Make a charity repayment claim' page")
      GiftAidUploadSuccessfulPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation()
      Then("User navigates to 'What adjustments have you made to this claim?' page")
      ClaimsTaskListPage_InProgress.clickReadDeclaration()
      WhatAdjustmentsHaveYouMadeToThisClaimPage.validateNavigation()
      And("User enters details on adjustments page and navigates to Declaration Page")
      WhatAdjustmentsHaveYouMadeToThisClaimPage.enterAdjustmentDetails("TEST ADJUSTMENT INPUT")
      DeclarationPage.validateNavigation()
      Then("User navigates to 'Claim complete' page")
      DeclarationPage.clickContinue()
      ClaimCompletePage.validateNavigation()
      And("User validates 'Claim complete' page elements")
      ClaimCompletePage.validatePageContent()
      Then("User navigates to 'Charity repayment claim summary' page")
      ClaimCompletePage.clickPrintClaimSummaryLink()
      And("User validates Static 'Headers' in Summary page ")
      CharityRepaymentClaimSummaryPage.validateNavigation()
      And("User validates Submission Reference Number is in BASE32 format")
      CharityRepaymentClaimSummaryPage.verifySubmissionReferenceBase32()
      And("User validates GASDS Heading on Page")
      CharityRepaymentClaimSummaryPage.validateGASDSHeading()
      Then("User Validates the CB & CC data extracted from CB & CC ODS")
      CharityRepaymentClaimSummaryPage.assertAllSummaryPairsExactlyAt(1)(
        "Number of Community Buildings" -> "500",
        "Total value of GASDS donations collected in a Community Building" -> "£1000000.00",
        "Number of Connected Charities" -> "1"
      )
      Then(
        "User Validates the 3 links: 'Print Summary', 'Log out and go back HMRC online services' and 'Go to Your HMRC services exist'"
      )
      CharityRepaymentClaimSummaryPage.validateSummaryPageLinks()
    }
  }
}

 