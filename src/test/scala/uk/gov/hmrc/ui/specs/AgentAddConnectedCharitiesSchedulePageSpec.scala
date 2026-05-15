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

class AgentAddConnectedCharitiesSchedulePageSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {
  Feature("Charities - Agent - Connected Charities Page Validations") {
    Scenario("User navigates to the 'About Connected Charities schedule' page and validates the page elements") {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETEST-C16")
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
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
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
      And("User clicks the link to navigate to 'Add Connected Charities schedule' page")
      ClaimsTaskListPage_InProgress.clickAddConnectedCharitiesSchedule()
      Then("User navigates to 'About Connected Charities schedule' page")
      AboutConnectedCharitiesSchedulePage.validateNavigationAgent()
      AboutConnectedCharitiesSchedulePage.validatePageContentAgent()
    }

    Scenario("User navigates to the 'Upload a Connected Charities schedule' page and validates the page elements") {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETEST-C17")
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
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
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
      And("User clicks the link to navigate to 'Add Connected Charities schedule' page")
      ClaimsTaskListPage_InProgress.clickAddConnectedCharitiesSchedule()
      Then("User navigates to 'About Connected Charities schedule' page")
      AboutConnectedCharitiesSchedulePage.validateNavigationAgent()
      AboutConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNavigationAgent()
      Then("User validates the elements on the 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.validatePageContentAgent()
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
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETEST-C18")
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
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
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
      And("User clicks the link to navigate to 'Add Connected Charities schedule' page")
      ClaimsTaskListPage_InProgress.clickAddConnectedCharitiesSchedule()
      Then("User navigates to 'About Connected Charities schedule' page")
      AboutConnectedCharitiesSchedulePage.validateNavigationAgent()
      AboutConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNavigationAgent()
      Then("User selects a file to upload in the 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.selectFile(
        "ConnectedCharitiesSpreadsheets/Connected-Charities-schedule-Excel-GoodData"
      )
      UploadAConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Your Connected Charities schedule upload' page")
      YourConnectedCharitiesScheduleUploadPage.validateNavigationAgent()
      YourConnectedCharitiesScheduleUploadPage.waitForFileUpload()
      YourConnectedCharitiesScheduleUploadPage.validateParagraphAgent()
      Then("User removed the uploaded file on 'Your Connected Charities schedule upload' page")
      YourConnectedCharitiesScheduleUploadPage.clickRemoveUploadedFile()
      Then("User navigates to 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNavigationAgent()
    }

    Scenario(
      "User navigates to the 'Check your Connected Charities schedule upload' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETEST-CC19")
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
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
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
      And("User clicks the link to navigate to 'Add Connected Charities schedule' page")
      ClaimsTaskListPage_InProgress.clickAddConnectedCharitiesSchedule()
      Then("User navigates to 'About Connected Charities schedule' page")
      AboutConnectedCharitiesSchedulePage.validateNavigationAgent()
      AboutConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNavigationAgent()
      Then("User selects a file to upload in the 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.selectFile(
        "ConnectedCharitiesSpreadsheets/Connected-Charities-schedule-Excel-GoodData"
      )
      UploadAConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Your Connected Charities upload' page")
      YourConnectedCharitiesScheduleUploadPage.validateNavigationAgent()
      YourConnectedCharitiesScheduleUploadPage.waitForFileUpload()
      YourConnectedCharitiesScheduleUploadPage.validateParagraphAgent()
      YourConnectedCharitiesScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your Connected Charities schedule' page")
      CheckYourConnectedCharitiesSchedulePage.validateNavigationAgent()
      Then("User validates content on 'Check your Connected Charities schedule' page")
      CheckYourConnectedCharitiesSchedulePage.validateFormFieldset()
      Then("User validates the 'no input' error on the 'Check your Connected Charities schedule' page")
      CheckYourConnectedCharitiesSchedulePage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Problem with your Connected Charities schedule' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETEST-CC110")
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
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
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
      And("User clicks the link to navigate to 'Add Connected Charities schedule' page")
      ClaimsTaskListPage_InProgress.clickAddConnectedCharitiesSchedule()
      Then("User navigates to 'About Connected Charities schedule' page")
      AboutConnectedCharitiesSchedulePage.validateNavigationAgent()
      AboutConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNavigationAgent()
      Then("User selects a file to upload in the 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.selectFile(
        "ConnectedCharitiesSpreadsheets/Connected-Charities-schedule-Excel-BadData"
      )
      UploadAConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Your Connected Charities schedule upload' page")
      YourConnectedCharitiesScheduleUploadPage.validateNavigationAgent()
      YourConnectedCharitiesScheduleUploadPage.waitForFileUpload()
      YourConnectedCharitiesScheduleUploadPage.clickContinue()
      Then("User navigates to 'Problem with your Connected Charities schedule data' page and validates page")
      CheckYourConnectedCharitiesScheduleErrorPage.validateNavigationAgent()
      Then("User validates the static text on 'Problem with your Connected Charities schedule data' page")
      CheckYourConnectedCharitiesScheduleErrorPage.validatePageContentAgent()
      Then("User clicks on the Delete Schedule link and reaches the Delete Schedule WRN 1.0 page")
      CheckYourConnectedCharitiesScheduleErrorPage.clickDeleteScheduleLink()
      Then("User validates navigation of Delete Schedule WRN 1.0 page")
      DeleteGASDSConnectedCharitiesSchedulePage.validateNavigation()
      Then("User clicks back to reach 'problem with your Connected Charities schedule' page")
      DeleteGASDSConnectedCharitiesSchedulePage.clickBackLink()
      Then("User reaches the 'problem with your Connected Charities schedule page' and validates the navigation")
      CheckYourConnectedCharitiesScheduleErrorPage.validateNavigationAgent()
      Then(
        "User clicks on 'Attach an updated Connected Charities schedule' that deletes the invalid ODS and navigates to" +
          " 'upload a Connected Charities schedule page CC1.1' "
      )
      CheckYourConnectedCharitiesScheduleErrorPage.clickAttachUpdatedSchedule()
      Then("User validates navigation of 'upload a Connected Charities schedule page CC1.1' ")
      UploadAConnectedCharitiesSchedulePage.validateNavigationAgent()
    }

    Scenario(
      "User navigates to the 'Upload Successful' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETEST-CC111")
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
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSConnected, true)
      GASDSCheckboxPage.clickContinue()
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
      And("User clicks the link to navigate to 'Add Connected Charities schedule' page")
      ClaimsTaskListPage_InProgress.clickAddConnectedCharitiesSchedule()
      Then("User navigates to 'About Connected Charities schedule' page")
      AboutConnectedCharitiesSchedulePage.validateNavigationAgent()
      AboutConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.validateNavigationAgent()
      Then("User selects a file to upload in the 'Upload a Connected Charities schedule' page")
      UploadAConnectedCharitiesSchedulePage.selectFile(
        "ConnectedCharitiesSpreadsheets/Connected-Charities-schedule-Excel-GoodData"
      )
      UploadAConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates to 'Your Connected Charities schedule upload' page")
      YourConnectedCharitiesScheduleUploadPage.validateNavigationAgent()
      YourConnectedCharitiesScheduleUploadPage.waitForFileUpload()
      YourConnectedCharitiesScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your Connected Charities schedule' page")
      CheckYourConnectedCharitiesSchedulePage.validateNavigationAgent()
      CheckYourConnectedCharitiesSchedulePage.radioButton(CheckYourConnectedCharitiesSchedulePage.no)
      CheckYourConnectedCharitiesSchedulePage.clickContinue()
      Then("User navigates and validates 'Successful Connected Charities Upload' page ")
      ConnectedCharitiesUploadSuccessfulPage.validateNavigationAgent()
      ConnectedCharitiesUploadSuccessfulPage.validatePageParagraphAgent()
    }
  }
}
