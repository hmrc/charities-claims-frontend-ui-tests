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

  Feature("Charities - Agent - Warning Page Validations") {
    Scenario(
      "User navigates to the 'Do you need to register your charity with a regulator?' Low Income page from the Gift Aid flow and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "AGT-PAGETEST-WRN12-5K")
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
      ClaimsTaskListPage_InProgress.validateNavigationAgent()
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
      And("User selects they are excepted")
      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.LowIncome)
      WhyIsTheCharityNotRegisteredPage.clickContinue()
      And("User navigates to 'Who should HMRC send payment to?' page")
      WhoShouldHMRCSendPaymentToPage.validateNavigationAgent()
      And("User selects to send payment to Agent/Trustee")
      WhoShouldHMRCSendPaymentToPage.radioButton(WhoShouldHMRCSendPaymentToPage.AgtTtee)
      Then("User selects continue on 'Who should HMRC send payment to?' page")
      WhoShouldHMRCSendPaymentToPage.clickContinue()
      And("User navigates to 'What is your telephone number?' page")
      WhatIsYourTelephoneNumberPage.validateNavigationAgent()
      Then("User Inputs a Telephone Number on 'What is your telephone number?' page and clicks CONTINUE")
      WhatIsYourTelephoneNumberPage.enterAgentTelephoneNumber("0044 (0123) 456-7890")
      And("User navigates to 'Do you have a UK address?' page")
      DoYouHaveAUKAddressPage.validateNavigationAgent()
      And("User selects 'Yes' to 'Do you have a UK address'")
      DoYouHaveAUKAddressPage.radioButton(DoYouHaveAUKAddressPage.no)
      DoYouHaveAUKAddressPage.clickContinue()
      And("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.validateNavigation()
      Then("User navigates to 'Make a charity repayment claim' page")
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
      UploadAGiftAidSchedulePage.selectFile("GiftAidSpreadsheets/Gift-Aid-Schedule-SIMPLEPASS_MAX_ROWS_LOW_INCOME")
      UploadAGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Your Gift Aid schedule upload' page")
      YourGiftAidScheduleUploadPage.validateNavigationAgent()
      YourGiftAidScheduleUploadPage.waitForFileUpload()
      YourGiftAidScheduleUploadPage.clickContinue()
      Then("User navigates to 'Check your Gift Aid schedule' page")
      CheckYourGiftAidSchedulePage.validateNavigationAgent()
      CheckYourGiftAidSchedulePage.radioButton(CheckYourGiftAidSchedulePage.no)
      CheckYourGiftAidSchedulePage.clickContinue()
      Then("User navigates to 'Successful Gift Aid Upload' page")
      GiftAidUploadSuccessfulPage.validateNavigation()
      Then("User navigates to 'Make a charity repayment claim' page")
      GiftAidUploadSuccessfulPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation()
      Then("User navigates to 'Registering your charity with a regulator' page")
      ClaimsTaskListPage_InProgress.clickReadDeclaration()
      RegisteringYourCharityWithRegulatorPage_LowIncome.validateNavigationAgent()
      And("User validates 'Registering your charity with a regulator' page elements")
      RegisteringYourCharityWithRegulatorPage_LowIncome.validatePageContentAgent()
      And("User validates 'Registering your charity with a regulator' page error message")
      RegisteringYourCharityWithRegulatorPage_LowIncome.validateErrorMessage()
      And("User selects 'Yes' and clicks continue on 'Registering your charity with a regulator' page")
      RegisteringYourCharityWithRegulatorPage_LowIncome.radioButton(
        RegisteringYourCharityWithRegulatorPage_LowIncome.yes
      )
      RegisteringYourCharityWithRegulatorPage_LowIncome.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation()
    }

//    Scenario(
//      "User navigates to the 'Do you need to register your charity with a regulator?' Excepted page from the Gift Aid flow and validates the page elements"
//    ) {
//      Given("the user logs in through the Authority Wizard page")
//      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "AGT-PAGETEST-WRN12-100K")
//      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
//      CharitiesManagementAgent.validateNavigationAgent()
//      And(
//        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
//      )
//      CharitiesManagementAgent.clickUseTheCharitiesLink()
//      Then("User navigates and validates the 'Repayment claim details' page")
//      RepaymentClaimDetailsPage.validateNavigationAgent()
//      Then("User Clicks Continue and navigates to 'Enter HMRC Charities Reference' page")
//      RepaymentClaimDetailsPage.clickContinue()
//      And("User Validates Navigation/hint for the 'Enter HMRC Charities Reference' page")
//      WhatIsYourHMRCReferenceNumberPage.validateNavigationAgent()
//      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
//      WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber("X12345")
//      And("User Navigates to 'What is the Name of your Charity or CASC' page and validates the page elements and text")
//      WhatIsTheNameOfCharityOrCASC.validateNavigationAgent()
//      Then("User Inputs a Charity Reference Number on 'Enter HMRC Charities Reference' page and clicks CONTINUE")
//      WhatIsTheNameOfCharityOrCASC.enterCharityName("TEST AGENT CASC")
//      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
//      RepaymentCheckboxPage.validateNavigationAgent()
//      And("User selects 'Tax repayments on Gift Aid donations' checkbox and clicks continue")
//      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GiftAid, true)
//      RepaymentCheckboxPage.clickContinue()
//      Then("User navigates to 'Do you have a claim reference number?' page")
//      DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
//      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
//      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
//      DoYouHaveAClaimReferenceNumberPage.clickContinue()
//      Then("User navigates to 'Check your repayment claim' page")
//      CheckYourRepaymentClaimPage.validateNavigationAgent()
//      Then("User navigates and validates the 'Repayment claim details' page")
//      CheckYourRepaymentClaimPage.clickContinue()
//      ClaimsTaskListPage_InProgress.validateNavigationAgent()
//      Then("User clicks 'Provide Organisation Details' link and navigates to 'About the Organisation' page")
//      ClaimsTaskListPage_InProgress.clickProvideOrganisationDetails()
//      AboutTheOrganisationPage.validateNavigation()
//      Then("User selects continue on 'About the organisation' page")
//      AboutTheOrganisationPage.clickContinue()
//      And("User navigates to 'What is the name of the charity regulator?' page")
//      WhatIsTheNameOfTheCharityRegulatorPage.validateNavigation()
//      And("User selects they are not registered with a regulator")
//      WhatIsTheNameOfTheCharityRegulatorPage.radioButton(WhatIsTheNameOfTheCharityRegulatorPage.None)
//      WhatIsTheNameOfTheCharityRegulatorPage.clickContinue()
//      And("User navigates to 'Why is the charity not registered with a regulator?' page")
//      WhyIsTheCharityNotRegisteredPage.validateNavigation()
//      And("User selects they are excepted")
//      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.Excepted)
//      WhyIsTheCharityNotRegisteredPage.clickContinue()
//      And("User navigates to 'Your charity is excepted' page")
//      YourCharityIsExceptedPage.validateNavigation()
//      Then("User selects continue on 'Your charity is excepted' page")
//      YourCharityIsExceptedPage.clickContinue()
//      And("User navigates to 'Who should HMRC send payment to?' page")
//      WhoShouldHMRCSendPaymentToPage.validateNavigationAgent()
//      And("User selects to send payment to Agent/Trustee")
//      WhoShouldHMRCSendPaymentToPage.radioButton(WhoShouldHMRCSendPaymentToPage.AgtTtee)
//      Then("User selects continue on 'Who should HMRC send payment to?' page")
//      WhoShouldHMRCSendPaymentToPage.clickContinue()
//      And("User navigates to 'What is your telephone number?' page")
//      WhatIsYourTelephoneNumberPage.validateNavigationAgent()
//      Then("User Inputs a Telephone Number on 'What is your telephone number?' page and clicks CONTINUE")
//      WhatIsYourTelephoneNumberPage.enterAgentTelephoneNumber("0044 (0123) 456-7890")
//      And("User navigates to 'Do you have a UK address?' page")
//      DoYouHaveAUKAddressPage.validateNavigationAgent()
//      And("User selects 'Yes' to 'Do you have a UK address'")
//      DoYouHaveAUKAddressPage.radioButton(DoYouHaveAUKAddressPage.no)
//      DoYouHaveAUKAddressPage.clickContinue()
//      And("User navigates to 'Check your organisation details' page")
//      CheckYourOrganisationDetailsPage.validateNavigation()
//      Then("User navigates to 'Make a charity repayment claim' page")
//      CheckYourOrganisationDetailsPage.clickContinue()
//      ClaimsTaskListPage_InProgress.validateNavigation()
//      And("User clicks the link to navigate to 'Add Gift Aid schedule' page")
//      ClaimsTaskListPage_InProgress.clickAddGiftAidSchedule()
//      Then("User navigates to 'About Gift Aid schedule' page")
//      AboutGiftAidSchedulePage.validateNavigation()
//      AboutGiftAidSchedulePage.clickContinue()
//      Then("User navigates to 'Upload a Gift Aid schedule' page")
//      UploadAGiftAidSchedulePage.validateNavigation()
//      Then("User selects a file to upload in the 'Upload a Gift Aid schedule' page")
//      UploadAGiftAidSchedulePage.selectFile("GiftAidSpreadsheets/Gift-Aid-Schedule-SIMPLEPASS_MAX_ROWS_EXCEPTED")
//      UploadAGiftAidSchedulePage.clickContinue()
//      Then("User navigates to 'Your Gift Aid schedule upload' page")
//      YourGiftAidScheduleUploadPage.validateNavigationAgent()
//      YourGiftAidScheduleUploadPage.waitForFileUpload()
//      YourGiftAidScheduleUploadPage.clickContinue()
//      Then("User navigates to 'Check your Gift Aid schedule' page")
//      CheckYourGiftAidSchedulePage.validateNavigationAgent()
//      CheckYourGiftAidSchedulePage.radioButton(CheckYourGiftAidSchedulePage.no)
//      CheckYourGiftAidSchedulePage.clickContinue()
//      Then("User navigates to 'Successful Gift Aid Upload' page")
//      GiftAidUploadSuccessfulPage.validateNavigation()
//      Then("User navigates to 'Make a charity repayment claim' page")
//      GiftAidUploadSuccessfulPage.clickContinue()
//      ClaimsTaskListPage_InProgress.validateNavigation()
//      Then("User navigates to 'Registering your charity with a regulator' page")
//      ClaimsTaskListPage_InProgress.clickReadDeclaration()
//      RegisteringYourCharityWithRegulatorPage_Excepted.validateNavigationAgent()
//      And("User validates 'Registering your charity with a regulator' page elements")
//      RegisteringYourCharityWithRegulatorPage_Excepted.validatePageContentAgent()
//      And("User validates 'Registering your charity with a regulator' page error message")
//      RegisteringYourCharityWithRegulatorPage_Excepted.validateErrorMessage()
//      And("User selects 'Yes' and clicks continue on 'Registering your charity with a regulator' page")
//      RegisteringYourCharityWithRegulatorPage_Excepted.radioButton(
//        RegisteringYourCharityWithRegulatorPage_Excepted.yes
//      )
//      RegisteringYourCharityWithRegulatorPage_Excepted.clickContinue()
//      Then("User navigates to 'Make a charity repayment claim' page")
//      ClaimsTaskListPage_InProgress.validateNavigation()
//    }
  }
}
