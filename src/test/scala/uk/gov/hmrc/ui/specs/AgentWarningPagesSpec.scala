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

class AgentWarningPagesSpec
  extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {


  Feature("Charities - Agent - Warning Pages Validations") {
    Scenario(
      "User navigates to the 'Your Community Buildings schedule upload' page and attempt to upload a quarantined file,then a rejected file, then an unknown file"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETES-WRN70-CB")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigationAgent()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigationAgent()
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigationAgent()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContent()
      And("User selects 'GASDS Community Buildings' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSBuilding, true)
      GASDSCheckboxPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigationAgent()
      And("User selects 'No' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.no)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigationAgent()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigationAgent()
      And("User clicks the link to navigate to 'Add Community Buildings schedule' page")
      ClaimsTaskListPage_InProgress.clickAddCommunityBuildingsSchedule()
      Then("User navigates to 'About Community Buildings schedule' page")
      AboutCommunityBuildingsSchedulePage.validateNavigationAgent()
      AboutCommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.validateNavigationAgent()
      Then("User selects a file (to have a dummy virus) to upload in the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.selectFile(
        "WarningPagesSpreadsheets/infected.WRN7-0"
      )
      UploadACommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Your Community Buildings schedule upload' page")
      YourCommunityBuildingsScheduleUploadPage.validateNavigationAgent()
      YourCommunityBuildingsScheduleUploadPage.waitForFileUploadFail()
      YourCommunityBuildingsScheduleUploadPage.clickContinue()
      Then(
        "User navigates to 'There is a problem uploading your Community Buildings schedule' page and validates its contents"
      )
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.validateNavigationAgent()
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.validatePageContent()
      Then(
        "User selects 'Upload a new schedule' button on the 'There is a problem uploading your Community Buildings schedule' page"
      )
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.clickUploadANewSchedule()
      Then("User navigates to 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.validateNavigationAgent()
      Then("User selects a file (to be rejected) to upload in the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.selectFile(
        "WarningPagesSpreadsheets/rejected.WRN7-1"
      )
      UploadACommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Your Community Buildings schedule upload' page")
      YourCommunityBuildingsScheduleUploadPage.validateNavigationAgent()
      YourCommunityBuildingsScheduleUploadPage.waitForFileUploadFail()
      YourCommunityBuildingsScheduleUploadPage.clickContinue()
      Then(
        "User navigates to 'There is a problem uploading your Community Buildings schedule' page and validates its contents"
      )
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.validateNavigationAgent()
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.validatePageContent()
      Then(
        "User selects 'Upload a new schedule' button on the 'There is a problem uploading your Community Buildings schedule' page"
      )
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.clickUploadANewSchedule()
      Then("User navigates to 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.validateNavigationAgent()
      Then("User selects an unknown file to upload in the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.selectFile(
        "WarningPagesSpreadsheets/unknown.WRN7-2"
      )
      UploadACommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Your Community Buildings schedule upload' page")
      YourCommunityBuildingsScheduleUploadPage.validateNavigationAgent()
      YourCommunityBuildingsScheduleUploadPage.waitForFileUploadFail()
      YourCommunityBuildingsScheduleUploadPage.clickContinue()
      Then(
        "User navigates to 'There is a problem uploading your Community Buildings schedule' page and validates its contents"
      )
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.validateNavigationAgent()
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.validatePageContent()
      Then(
        "User selects 'Upload a new schedule' button on the 'There is a problem uploading your Community Buildings schedule' page"
      )
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.clickUploadANewSchedule()
      Then("User navigates to 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.validateNavigationAgent()

    }

    Scenario(
      "User navigates to the 'Your Gift Aid schedule upload' page and attempt to upload a quarantined file,then a rejected file, then an unknown file"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETES-WRN70-GAS")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
     CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigationAgent()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigationAgent()
      And(
        "User selects 'GiftAid' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GiftAid, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigationAgent()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigationAgent()
      And("User clicks the link to navigate to 'Add Gift Aid schedule' page")
      ClaimsTaskListPage_InProgress.clickAddGiftAidSchedule()
      Then("User navigates to 'About Gift Aid schedule' page")
      AboutGiftAidSchedulePage.validateNavigationAgent()
      AboutGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.validateNavigationAgent()
      Then("User selects a file (to have a dummy virus) to upload in the 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.selectFile(
        "WarningPagesSpreadsheets/infected.WRN7-0"
      )
      UploadAGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Your Gift Aid schedule upload' page")
      YourGiftAidScheduleUploadPage.validateNavigationAgent()
      YourGiftAidScheduleUploadPage.waitForFileUploadFail()
      YourGiftAidScheduleUploadPage.clickContinue()
      Then(
        "User navigates to 'There is a problem uploading your Gift Aid schedule' page and validates its contents"
      )
      ThereIsAProblemUploadingYourGiftAidSchedulePage_Quarantine.validateNavigationAgent()
      ThereIsAProblemUploadingYourGiftAidSchedulePage_Quarantine.validatePageContent()
      Then(
        "User selects 'Upload a new schedule' button on the 'There is a problem uploading your Gift Aid schedule' page"
      )
      ThereIsAProblemUploadingYourGiftAidSchedulePage_Quarantine.clickUploadANewSchedule()
      Then("User navigates to 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.validateNavigationAgent()
      Then("User selects a file (to be rejected) to upload in the 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.selectFile(
        "WarningPagesSpreadsheets/rejected.WRN7-1"
      )
      UploadAGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Your Gift Aid schedule upload' page")
      YourGiftAidScheduleUploadPage.validateNavigationAgent()
      YourGiftAidScheduleUploadPage.waitForFileUploadFail()
      YourGiftAidScheduleUploadPage.clickContinue()
      Then(
        "User navigates to 'There is a problem uploading your Gift Aid schedule' page and validates its contents"
      )
      ThereIsAProblemUploadingYourGiftAidSchedulePage_Reject.validateNavigationAgent()
      ThereIsAProblemUploadingYourGiftAidSchedulePage_Reject.validatePageContent()
      Then(
        "User selects 'Upload a new schedule' button on the 'There is a problem uploading your Gift Aid schedule' page"
      )
      ThereIsAProblemUploadingYourGiftAidSchedulePage_Reject.clickUploadANewSchedule()
      Then("User navigates to 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.validateNavigationAgent()
      Then("User selects an unknown file to upload in the 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.selectFile(
        "WarningPagesSpreadsheets/unknown.WRN7-2"
      )
      UploadAGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Your Gift Aid schedule upload' page")
      YourGiftAidScheduleUploadPage.validateNavigationAgent()
      YourGiftAidScheduleUploadPage.waitForFileUploadFail()
      YourGiftAidScheduleUploadPage.clickContinue()
      Then(
        "User navigates to 'There is a problem uploading your Gift Aid schedule' page and validates its contents"
      )
      ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.validateNavigationAgent()
      ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.validatePageContent()
      Then(
        "User selects 'Upload a new schedule' button on the 'There is a problem uploading your Gift Aid schedule' page"
      )
      ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.clickUploadANewSchedule()
      Then("User navigates to 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.validateNavigationAgent()
    }

    Scenario(
      "User navigates to the 'Your Other Income Schedule Upload' page and attempt to upload a quarantined file,then a rejected file, then an unknown file"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETES-WRN70-OI")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
     CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigationAgent()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigationAgent()
      And(
        "User selects 'Other Income' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.OtherIncome, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigationAgent()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigationAgent()
      And("User clicks the link to navigate to 'Add Other Income schedule' page")
      ClaimsTaskListPage_InProgress.clickAddOtherIncomeSchedule()
      Then("User navigates to 'About Other Income schedule' page")
      AboutOtherIncomeSchedulePage.validateNavigationAgent()
      AboutOtherIncomeSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.validateNavigationAgent()
      Then("User selects a file (to have a dummy virus) to upload in the 'Upload a Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.selectFile(
        "WarningPagesSpreadsheets/infected.WRN7-0"
      )
      UploadAnOtherIncomeSchedulePage.clickContinue()
      Then("User navigates to 'Your Other Income schedule upload' page")
      YourOtherIncomeScheduleUploadPage.validateNavigationAgent()
      YourOtherIncomeScheduleUploadPage.waitForFileUploadFail()
      YourOtherIncomeScheduleUploadPage.clickContinue()
      Then(
        "User navigates to 'There is a problem uploading your Other Income schedule' page and validates its contents"
      )
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.validateNavigationAgent()
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.validatePageContent()
      Then(
        "User selects 'Upload a new schedule' button on the 'There is a problem uploading your Other Income schedule' page"
      )
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.clickUploadANewSchedule()
      Then("User navigates to 'Upload a Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.validateNavigationAgent()
      Then("User selects a file (to be rejected) to upload in the 'Upload a Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.selectFile(
        "WarningPagesSpreadsheets/rejected.WRN7-1"
      )
      UploadAnOtherIncomeSchedulePage.clickContinue()
      Then("User navigates to 'Your Other Income schedule upload' page")
      YourOtherIncomeScheduleUploadPage.validateNavigationAgent()
      YourOtherIncomeScheduleUploadPage.waitForFileUploadFail()
      YourOtherIncomeScheduleUploadPage.clickContinue()
      Then(
        "User navigates to 'There is a problem uploading your Other Income schedule' page and validates its contents"
      )
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.validateNavigationAgent()
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.validatePageContent()
      Then(
        "User selects 'Upload a new schedule' button on the 'There is a problem uploading your Other Income schedule' page"
      )
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.clickUploadANewSchedule()
      Then("User navigates to 'Upload a Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.validateNavigationAgent()
      Then("User selects an unknown file to upload in the 'Upload a Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.selectFile(
        "WarningPagesSpreadsheets/unknown.WRN7-2"
      )
      UploadAnOtherIncomeSchedulePage.clickContinue()
      Then("User navigates to 'Your Other Income schedule upload' page")
      YourOtherIncomeScheduleUploadPage.validateNavigationAgent()
      YourOtherIncomeScheduleUploadPage.waitForFileUploadFail()
      YourOtherIncomeScheduleUploadPage.clickContinue()
      Then(
        "User navigates to 'There is a problem uploading your Other Income schedule' page and validates its contents"
      )
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.validateNavigationAgent()
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.validatePageContent()
      Then(
        "User selects 'Upload a new schedule' button on the 'There is a problem uploading your Other Income schedule' page"
      )
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.clickUploadANewSchedule()
      Then("User navigates to 'Upload a Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.validateNavigationAgent()
    }

    Scenario(
      "User navigates to the 'Your Connected Charities Schedule Upload' page and attempt to upload a quarantined file,then a rejected file, then an unknown file"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETES-WRN70-CC")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
     CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigationAgent()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigationAgent()
      And(
        "User selects 'Top up payments for donations under the Gift Aid Small Donations Scheme' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigationAgent()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContent()
      And("User selects 'GASDS Other Income' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigationAgent()
      And("User selects 'No' and clicks continue on 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.radioButton(GiftAidSmallDonationsSchemeClaimPage.no)
      GiftAidSmallDonationsSchemeClaimPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigationAgent()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigationAgent()
      And("User clicks the link to navigate to 'Add Other Income schedule' page")
      ClaimsTaskListPage_InProgress.clickAddConnectedCharitiesSchedule()
      Then("User navigates to 'About Other Income schedule' page")
      AboutConnectedCharitiesSchedulePage.validateNavigationAgent()
      AboutConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Other Income schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNavigationAgent()
      Then("User selects a file (to have a dummy virus) to upload in the 'Upload a Other Income schedule' page")
      UploadAConnectedCharitiesSchedulePage.selectFile(
        "WarningPagesSpreadsheets/infected.WRN7-0"
      )
      UploadAConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Your Other Income schedule upload' page")
      YourConnectedCharitiesScheduleUploadPage.validateNavigationAgent()
      YourConnectedCharitiesScheduleUploadPage.waitForFileUploadFail()
      YourConnectedCharitiesScheduleUploadPage.clickContinue()
      Then(
        "User navigates to 'There is a problem uploading your Other Income schedule' page and validates its contents"
      )
      ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Quarantine.validateNavigationAgent()
      ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Quarantine.validatePageContent()
      Then(
        "User selects 'Upload a new schedule' button on the 'There is a problem uploading your Other Income schedule' page"
      )
      ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Quarantine.clickUploadANewSchedule()
      Then("User navigates to 'Upload a Other Income schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNavigationAgent()
      Then("User selects a file (to be rejected) to upload in the 'Upload a Other Income schedule' page")
      UploadAConnectedCharitiesSchedulePage.selectFile(
        "WarningPagesSpreadsheets/rejected.WRN7-1"
      )
      UploadAConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Your Other Income schedule upload' page")
      YourConnectedCharitiesScheduleUploadPage.validateNavigationAgent()
      YourConnectedCharitiesScheduleUploadPage.waitForFileUploadFail()
      YourConnectedCharitiesScheduleUploadPage.clickContinue()
      Then(
        "User navigates to 'There is a problem uploading your Other Income schedule' page and validates its contents"
      )
      ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Reject.validateNavigationAgent()
      ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Reject.validatePageContent()
      Then(
        "User selects 'Upload a new schedule' button on the 'There is a problem uploading your Other Income schedule' page"
      )
      ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Reject.clickUploadANewSchedule()
      Then("User navigates to 'Upload a Other Income schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNavigationAgent()
      Then("User selects an unknown file to upload in the 'Upload a Other Income schedule' page")
      UploadAConnectedCharitiesSchedulePage.selectFile(
        "WarningPagesSpreadsheets/unknown.WRN7-2"
      )
      UploadAConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Your Other Income schedule upload' page")
      YourConnectedCharitiesScheduleUploadPage.validateNavigationAgent()
      YourConnectedCharitiesScheduleUploadPage.waitForFileUploadFail()
      YourConnectedCharitiesScheduleUploadPage.clickContinue()
      Then(
        "User navigates to 'There is a problem uploading your Other Income schedule' page and validates its contents"
      )
      ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.validateNavigationAgent()
      ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.validatePageContent()
      Then(
        "User selects 'Upload a new schedule' button on the 'There is a problem uploading your Other Income schedule' page"
      )
      ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.clickUploadANewSchedule()
      Then("User navigates to 'Upload a Other Income schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNavigationAgent()
    }
  }
}
