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

class AgentAddCommunityBuildingsSchedulePageSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Agent - Community Buildings Page Validations") {
    Scenario(
      "User navigates to the 'About community buildings schedule' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETEST-B16")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      Then("User Clicks Continue and navigates to 'Enter HMRC Charities Reference' page")
      RepaymentClaimDetailsPage.clickContinue()
      And("User Validates Navigation/hint for the 'Enter HMRC Charities Reference' page")
      WhatIsYourHMRCReferenceNumberPage.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber("X1")
      And("User Navigates to 'What is the Name of your Charity or CASC' page and validates the page elements and text")
      WhatIsTheNameOfCharityOrCASC.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsTheNameOfCharityOrCASC.enterCharityName("Charity of X1")
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigationAgent()
      And(
        "User selects 'Top-up payments for donations under the Gift Aid Small Donations Scheme(GASDS)' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' and selects connected charities")
      GASDSCheckboxPage.validateNavigationAgent()
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
      AboutCommunityBuildingsSchedulePage.validatePageContentAgent()
    }

    Scenario(
      "User navigates to the 'Upload a Community Buildings schedule' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETEST-B17")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      Then("User Clicks Continue and navigates to 'Enter HMRC Charities Reference' page")
      RepaymentClaimDetailsPage.clickContinue()
      And("User Validates Navigation/hint for the 'Enter HMRC Charities Reference' page")
      WhatIsYourHMRCReferenceNumberPage.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber("X1")
      And("User Navigates to 'What is the Name of your Charity or CASC' page and validates the page elements and text")
      WhatIsTheNameOfCharityOrCASC.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsTheNameOfCharityOrCASC.enterCharityName("Charity of X1")
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigationAgent()
      And(
        "User selects 'Top-up payments for donations under the Gift Aid Small Donations Scheme(GASDS)' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' and selects connected charities")
      GASDSCheckboxPage.validateNavigationAgent()
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
      Then("User validates the elements on the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.validatePageContentAgent()
      Then("User validates the 'no input' error on the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.validateNoInputErrorMessage()
      Then("User selects a file to upload in the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.selectFile("GiftAidSpreadsheets/Gift-Aid-Schedule-TESTSIZE")
      UploadACommunityBuildingsSchedulePage.clickContinue()
      Then("User validates the 'file above size limit' error on the 'Check your Gift Aid schedule' page")
      UploadACommunityBuildingsSchedulePage.validateOversizeErrorMessage()
    }

    Scenario(
      "User navigates to the 'Your Community Buildings schedule upload' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETEST-B18")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      Then("User Clicks Continue and navigates to 'Enter HMRC Charities Reference' page")
      RepaymentClaimDetailsPage.clickContinue()
      And("User Validates Navigation/hint for the 'Enter HMRC Charities Reference' page")
      WhatIsYourHMRCReferenceNumberPage.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber("X1")
      And("User Navigates to 'What is the Name of your Charity or CASC' page and validates the page elements and text")
      WhatIsTheNameOfCharityOrCASC.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsTheNameOfCharityOrCASC.enterCharityName("Charity of X1")
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigationAgent()
      And(
        "User selects 'Top-up payments for donations under the Gift Aid Small Donations Scheme(GASDS)' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' and selects connected charities")
      GASDSCheckboxPage.validateNavigationAgent()
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
      Then("User selects a file to upload in the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.selectFile(
        "CommunityBuildingsSpreadsheets/Community-Buildings-Excel-GoodData"
      )
      UploadACommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Community Buildings schedule' page")
      YourCommunityBuildingsScheduleUploadPage.validateNavigationAgent()
      YourCommunityBuildingsScheduleUploadPage.validateParagraphAgent()
      Then("User removed the uploaded file on 'Upload a Community Buildings schedule' page")
      YourCommunityBuildingsScheduleUploadPage.clickRemoveUploadedFile()
      Then("User navigates to 'Upload a Gift Aid schedule' page")
      UploadACommunityBuildingsSchedulePage.validateNavigationAgent()
    }

    Scenario(
      "User navigates to the 'Check your Community Buildings schedule' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETEST-B19")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      Then("User Clicks Continue and navigates to 'Enter HMRC Charities Reference' page")
      RepaymentClaimDetailsPage.clickContinue()
      And("User Validates Navigation/hint for the 'Enter HMRC Charities Reference' page")
      WhatIsYourHMRCReferenceNumberPage.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber("X1")
      And("User Navigates to 'What is the Name of your Charity or CASC' page and validates the page elements and text")
      WhatIsTheNameOfCharityOrCASC.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsTheNameOfCharityOrCASC.enterCharityName("Charity of X1")
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigationAgent()
      And(
        "User selects 'Top-up payments for donations under the Gift Aid Small Donations Scheme(GASDS)' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' and selects connected charities")
      GASDSCheckboxPage.validateNavigationAgent()
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
      Then("User selects a file to upload in the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.selectFile(
        "CommunityBuildingsSpreadsheets/CommunityBuildingsPassRows"
      )
      UploadACommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Your Community Buildings schedule upload' page")
      YourCommunityBuildingsScheduleUploadPage.validateNavigationAgent()
      YourCommunityBuildingsScheduleUploadPage.waitForFileUpload()
      YourCommunityBuildingsScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your Community Buildings schedule' page")
      CheckYourCommunityBuildingsSchedulePage.validateNavigationAgent()
      Then("User validates content on 'Check your Community Buildings schedule' page")
      CheckYourCommunityBuildingsSchedulePage.validateSummaryCard()
      CheckYourCommunityBuildingsSchedulePage.validateFormFieldset()
      Then("User validates the 'no input' error on the 'Check your Community Buildings schedule' page")
      CheckYourCommunityBuildingsSchedulePage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Check your Community Buildings schedule' error page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETEST-B110")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      Then("User Clicks Continue and navigates to 'Enter HMRC Charities Reference' page")
      RepaymentClaimDetailsPage.clickContinue()
      And("User Validates Navigation/hint for the 'Enter HMRC Charities Reference' page")
      WhatIsYourHMRCReferenceNumberPage.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber("X1")
      And("User Navigates to 'What is the Name of your Charity or CASC' page and validates the page elements and text")
      WhatIsTheNameOfCharityOrCASC.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsTheNameOfCharityOrCASC.enterCharityName("Charity of X1")
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigationAgent()
      And(
        "User selects 'Top-up payments for donations under the Gift Aid Small Donations Scheme(GASDS)' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' and selects connected charities")
      GASDSCheckboxPage.validateNavigationAgent()
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
      Then("User selects a file to upload in the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.selectFile(
        "CommunityBuildingsSpreadsheets/community-buildings-excel-BadData"
      )
      UploadACommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Your Community Buildings schedule upload' page")
      YourCommunityBuildingsScheduleUploadPage.validateNavigationAgent()
      YourCommunityBuildingsScheduleUploadPage.waitForFileUpload()
      YourCommunityBuildingsScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your Community Buildings schedule' page")
      CheckYourCommunityBuildingsScheduleErrorPage.validateNavigationAgent()
      Then("User validates the static text on'Problem with your Community Buildings schedule data' page")
      CheckYourCommunityBuildingsScheduleErrorPage.validatePageContentAgent()
      Then("User clicks on the Delete Schedule link and reaches the Delete Schedule WRN 1.2 page")
      CheckYourCommunityBuildingsScheduleErrorPage.clickDeleteScheduleLink()
      Then("User validates navigation of Delete Schedule WRN 1.2 page")
      DeleteGASDSCommunityBuildingsSchedulePage.validateNavigation()
      Then("User clicks back to reach 'problem with your CBS' page")
      DeleteGASDSCommunityBuildingsSchedulePage.clickBackLink()
      Then("User reaches the 'problem with your CBS page' and validates the navigation")
      CheckYourCommunityBuildingsScheduleErrorPage.validateNavigationAgent()
      Then(
        "User clicks on 'Attach an updated Community Buildings schedule' that deletes the invalid ODS and navigates to" +
          " 'upload a CBS page B1.1' "
      )
      CheckYourCommunityBuildingsScheduleErrorPage.clickAttachUpdatedSchedule()
      Then("User validates navigation of 'upload a CBS page B1.1' ")
      UploadACommunityBuildingsSchedulePage.validateNavigationAgent()

    }

    Scenario(
      "User navigates to the 'Community Buildings schedule upload successful' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETEST-B111")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      Then("User Clicks Continue and navigates to 'Enter HMRC Charities Reference' page")
      RepaymentClaimDetailsPage.clickContinue()
      And("User Validates Navigation/hint for the 'Enter HMRC Charities Reference' page")
      WhatIsYourHMRCReferenceNumberPage.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber("X1")
      And("User Navigates to 'What is the Name of your Charity or CASC' page and validates the page elements and text")
      WhatIsTheNameOfCharityOrCASC.validateNavigationAgent()
      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
      WhatIsTheNameOfCharityOrCASC.enterCharityName("Charity of X1")
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigationAgent()
      And(
        "User selects 'Top-up payments for donations under the Gift Aid Small Donations Scheme(GASDS)' checkbox and clicks continue"
      )
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' and selects connected charities")
      GASDSCheckboxPage.validateNavigationAgent()
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
      Then("User selects a file to upload in the 'Upload a Community Buildings schedule' page")
      UploadACommunityBuildingsSchedulePage.selectFile(
        "CommunityBuildingsSpreadsheets/CommunityBuildingsPassRows"
      )
      UploadACommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Community Buildings schedule' page")
      YourCommunityBuildingsScheduleUploadPage.validateNavigationAgent()
      YourCommunityBuildingsScheduleUploadPage.waitForFileUpload()
      YourCommunityBuildingsScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your community buildings schedule' page")
      CheckYourCommunityBuildingsSchedulePage.validateNavigationAgent()
      CheckYourCommunityBuildingsSchedulePage.radioButton(CheckYourCommunityBuildingsSchedulePage.no)
      CheckYourCommunityBuildingsSchedulePage.clickContinue()
      Then("User navigates to 'Community Buildings schedule upload successful' page ")
      CommunityBuildingsScheduleUploadSuccessfulPage.validateNavigationAgent()
      CommunityBuildingsScheduleUploadSuccessfulPage.validatePageParagraphAgent()
    }
  }
}
