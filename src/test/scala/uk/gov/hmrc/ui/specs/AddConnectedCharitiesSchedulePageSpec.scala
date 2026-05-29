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

class AddConnectedCharitiesSchedulePageSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation - Connected Charities Page Validations") {
    Scenario("User navigates to the 'About Connected Charities schedule' page and validates the page elements") {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST-C10")
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
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigation()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContent()
      And("User selects 'Connected Charities' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      And("User clicks the link to navigate to 'Add Connected Charities schedule' page")
      ClaimsTaskListPage_InProgress.clickAddConnectedCharitiesSchedule()
      Then("User navigates to 'About Connected Charities schedule' page")
      AboutConnectedCharitiesSchedulePage.validateNavigation()
      AboutConnectedCharitiesSchedulePage.validatePageContent()
    }

    Scenario("User navigates to the 'Upload a Connected Charities schedule' page and validates the page elements") {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST-C11")
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
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigation()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContent()
      And("User selects 'Connected Charities' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      And("User clicks the link to navigate to 'Add Connected Charities schedule' page")
      ClaimsTaskListPage_InProgress.clickAddConnectedCharitiesSchedule()
      Then("User navigates to 'About Connected Charities schedule' page")
      AboutConnectedCharitiesSchedulePage.validateNavigation()
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
    }

    Scenario("User navigates to the 'Your Connected Charities schedule upload' page and validates the page elements") {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST-C12")
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
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigation()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContent()
      And("User selects 'Connected Charities' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      And("User clicks the link to navigate to 'Add Connected Charities schedule' page")
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
      YourConnectedCharitiesScheduleUploadPage.validateParagraph()
      Then("User removed the uploaded file on 'Your Connected Charities schedule upload' page")
      YourConnectedCharitiesScheduleUploadPage.clickRemoveUploadedFile()
      Then("User navigates to 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNavigation()
    }

    Scenario(
      "User navigates to the 'Check your Connected Charities schedule upload' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST-CC13")
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
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigation()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContent()
      And("User selects 'Connected Charities' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      And("User clicks the link to navigate to 'Add Connected Charities schedule' page")
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
    }

    Scenario(
      "User navigates to the 'Problem with your Connected Charities schedule' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST-CC14")
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
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigation()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContent()
      And("User selects 'Connected Charities' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      And("User clicks the link to navigate to 'Add Connected Charities schedule' page")
      ClaimsTaskListPage_InProgress.clickAddConnectedCharitiesSchedule()
      Then("User navigates to 'About Connected Charities schedule' page")
      AboutConnectedCharitiesSchedulePage.validateNavigation()
      AboutConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNavigation()
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
    }

    Scenario(
      "User navigates to the 'Upload Successful' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST-CC15")
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
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigation()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContent()
      And("User selects 'Connected Charities' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation_AllSubheadings()
      And("User clicks the link to navigate to 'Add Connected Charities schedule' page")
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
      Then("User navigates and validates 'Successful Connected Charities Upload' page")
      ConnectedCharitiesUploadSuccessfulPage.validateNavigation()
      ConnectedCharitiesUploadSuccessfulPage.validatePageParagraph()
    }
  }
}
