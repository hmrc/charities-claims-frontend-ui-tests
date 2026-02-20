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

class AddCommunityBuildingsSchedulePageSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation - Community Buildings Page Validations") {
//    Scenario(
//      B1.0 goes here
//    ) {
//    }

//    Scenario(
//      "User navigates to the 'Upload a Community Buildings schedule' page and validates the page elements"
//    ) {
//      Given("the user logs in through the Authority Wizard page")
//      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE TEST - B1.1")
//      Then("User navigates to 'Make a charity repayment claim' page")
//      ClaimsTaskListPage_Empty.validateNavigation()
//      And("User clicks the link to navigate to 'Repayment claim details' page")
//      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
//      Then("User validates the 'Repayment claim details' page")
//      RepaymentClaimDetailsPage.validateNavigation()
//      And("User clicks continue on 'Repayment claim details' page")
//      RepaymentClaimDetailsPage.clickContinue()
//      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
//      RepaymentCheckboxPage.validateNavigation()
//      And(
//        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
//      )
//      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
//      RepaymentCheckboxPage.clickContinue()
//      Then("User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page")
//      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
//      And(
//        "User selects 'No' and clicks continue on 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
//      )
//      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
//      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
//      Then("User navigates to 'Do you want to claim for donations collected in community buildings?' page")
//      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
//      And(
//        "User selects 'Yes' and clicks continue on 'Do you want to claim for donations collected in community buildings?' page"
//      )
//      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.radioButton(DoYouHaveAClaimReferenceNumberPage.yes)
//      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.clickContinue()
//      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
//      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
//      And("User selects 'No' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
//      GiftAidSmallDonationsSchemeClaimPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
//      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
//      Then("User navigates to 'Connected charities and Community Amateur Sports Clubs' page")
//      ConnectedCharitiesPage.validateNavigation()
//      And("User selects 'No' and clicks continue on 'Connected charities and Community Amateur Sports Clubs' page")
//      ConnectedCharitiesPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
//      ConnectedCharitiesPage.clickContinue()
//      Then("User navigates to 'Do you have a claim reference number?' page")
//      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
//      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
//      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
//      DoYouHaveAClaimReferenceNumberPage.clickContinue()
//      Then("User navigates to 'Check your repayment claim' page")
//      CheckYourRepaymentClaimPage.validateNavigation()
//      CheckYourRepaymentClaimPage.clickContinue()
//      Then("User navigates to 'Make a charity repayment claim' page")
//      ClaimsTaskListPage_InProgress.validateNavigation()
//      And("User clicks the link to navigate to 'Add Community Buildings schedule' page")
//      ClaimsTaskListPage_InProgress.clickAddCommunityBuildingsSchedule()
//      Then("User navigates to 'About Community Buildings schedule' page")
////      AboutGiftAidSchedulePage.validateNavigation()
//      AboutGiftAidSchedulePage.clickContinue()
//      Then("User navigates to 'Upload a Community Buildings schedule' page")
//      UploadACommunityBuildingsSchedulePage.validateNavigation()
//      Then("User validates the elements on the 'Upload a Community Buildings schedule' page")
//      UploadACommunityBuildingsSchedulePage.validatePageContent()
//      Then("User validates the 'no input' error on the 'Upload a Community Buildings schedule' page")
//      UploadACommunityBuildingsSchedulePage.validateNoInputErrorMessage()
//      Then("User selects a file to upload in the 'Upload a Community Buildings schedule' page")
//      UploadACommunityBuildingsSchedulePage.selectFile("GiftAidSpreadsheets/Gift-Aid-Schedule-TESTSIZE")
//      UploadACommunityBuildingsSchedulePage.clickContinue()
//      Then("User validates the 'file above size limit' error on the 'Check your Gift Aid schedule' page")
//      UploadACommunityBuildingsSchedulePage.validateOversizeErrorMessage()
//    }

    Scenario(
      "User navigates to the 'Your Community Buildings schedule upload' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE TEST - B1.2")
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
        "User selects 'No' and clicks continue on 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
      )
      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
      Then("User navigates to 'Do you want to claim for donations collected in community buildings?' page")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
      And(
        "User selects 'Yes' and clicks continue on 'Do you want to claim for donations collected in community buildings?' page"
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.radioButton(DoYouHaveAClaimReferenceNumberPage.yes)
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
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
      And("User clicks the link to navigate to 'Add Community Buildings schedule' page")
      ClaimsTaskListPage_InProgress.clickAddCommunityBuildingsSchedule()
      Then("User navigates to 'About Community Buildings schedule' page")
      //      AboutGiftAidSchedulePage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.validateNavigation()
      Then("User selects a file to upload in the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.selectFile(
        "CommunityBuildingsSpreadsheets/Community-Buildings-Excel-GoodData"
      )
      UploadACommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Community Buildings schedule' page")
      YourCommunityBuildingsScheduleUploadPage.validateNavigation()
      YourCommunityBuildingsScheduleUploadPage.validateParagraph()
      Then("User removed the uploaded file on 'Upload a Community Buildings schedule' page")
      YourCommunityBuildingsScheduleUploadPage.clickRemoveUploadedFile()
      Then("User navigates to 'Upload a Gift Aid schedule' page")
      UploadACommunityBuildingsSchedulePage.validateNavigation()
    }
  }
}
