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

class AgentDeclarationJourneySpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Agent - Declaration Page Validations") {
    Scenario(
      "User Agent navigates to the 'What adjustments have you made to this claim?' page from the Gift Aid flow and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "TESTAGENTORG")
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
      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.Excepted)
      WhyIsTheCharityNotRegisteredPage.clickContinue()
      And("User navigates to 'The charity is excepted' page")
      YourCharityIsExceptedPage.validateNavigationAgent()
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
      Then("User Inputs a Telephone Number on 'What is your telephone number?' page and clicks CONTINUE")
      WhatIsYourTelephoneNumberPage.enterAgentTelephoneNumber("0044 (0123) 456-7890")
      And("User navigates to 'Do you have a UK address?' page")
      DoYouHaveAUKAddressPage.validateNavigationAgent()
      And("User selects 'Yes' to 'Do you have a UK address'")
      DoYouHaveAUKAddressPage.radioButton(DoYouHaveAUKAddressPage.no)
      DoYouHaveAUKAddressPage.clickContinue()
      And("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.validateNavigationAgent()
      Then("User Validates the Key and Value pairs on 'CYA Organisation Details' page and Submits")
      CheckYourOrganisationDetailsPage.assertAllSummaryPairsExactlyAt(0)(
        "Charity regulator name"     -> "Charity is not registered with a regulator",
        "Reason for not registering" -> "The charity is excepted The charity is excepted as the charity’s annual income is £100,000 or less and is classed as one of the following: a church or chapel a charity that provides premises for schools a scout or guide group a charitable service of the armed forces a students’ union",
        "Send payment to"            -> "Agent/Nominee"
      )
      CheckYourOrganisationDetailsPage.assertAllSummaryPairsExactlyAt(1)(
        "Telephone number"           -> "0044 (0123) 456-7890",
        "UK address"                 -> "No"
      )
      And("User navigates to 'Make a charity repayment claim' task list page")
      CheckYourOrganisationDetailsPage.clickContinue()
      ClaimsTaskListPage_InProgress.validateNavigation()
      And("User clicks the link to navigate to 'Add Gift Aid schedule' page")
      ClaimsTaskListPage_InProgress.clickAddGiftAidSchedule()
      Then("User navigates to 'About Gift Aid schedule' page")
      AboutGiftAidSchedulePage.validateNavigationAgent()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.validateNavigationAgent()
      Then("User validates the elements on the 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.validatePageContentAgent()
      Then("User selects a file to upload in the 'Upload a Gift Aid schedule' page")
      UploadAGiftAidSchedulePage.selectFile("GiftAidSpreadsheets/Gift-Aid-Schedule-SIMPLEPASS_MAX_ROWS")
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
      DeclarationPage.clickConfirmAndSubmit()
      ClaimCompletePage.validateNavigation()
      And("User validates 'Claim complete' page elements")
      ClaimCompletePage.validatePageContentAgent()
    }
  }
}
