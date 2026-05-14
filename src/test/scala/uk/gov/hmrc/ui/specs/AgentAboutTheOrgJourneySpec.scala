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

class AgentAboutTheOrgJourneySpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Agent - About the Organisation journeys") {
    Scenario(
      "User navigates to the 'About the organisation', selects not registered radio button option, excepted and Agent/Trustee"
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
      WhyIsTheCharityNotRegisteredPage.validateFormFieldsetAgent()
      And("User selects they are exempt")
      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.Exempt)
      WhyIsTheCharityNotRegisteredPage.clickContinue()
      And("User navigates to 'The charity is exempt' page")
      YourCharityIsExemptPage.validateNavigationAgent()
      YourCharityIsExemptPage.validateParagraphAgent()
      And("User clicks back link to reach 'Why is the charity not registered with a regulator?' page")
      YourCharityIsExemptPage.clickBackLink()
      WhyIsTheCharityNotRegisteredPage.validateNavigation()
      And("User selects they are excepted")
      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.Excepted)
      WhyIsTheCharityNotRegisteredPage.clickContinue()
      And("User navigates to 'The charity is excepted' page")
      YourCharityIsExceptedPage.validateNavigationAgent()
      YourCharityIsExceptedPage.validateParagraphAgent()
      Then("User selects continue on 'The charity is excepted' page")
      YourCharityIsExceptedPage.clickContinue()
      And("User navigates to 'Who should HMRC send payment to?' page")
      WhoShouldHMRCSendPaymentToPage.validateNavigationAgent()
      WhoShouldHMRCSendPaymentToPage.validateFormFieldsetAgent()
      And("User validates no input Error on 'Who should HMRC send payment to?' page")
      WhoShouldHMRCSendPaymentToPage.validateErrorMessageAgent()
      And("User selects to send payment to Agent/Trustee")
      WhoShouldHMRCSendPaymentToPage.radioButton(WhoShouldHMRCSendPaymentToPage.AgtTtee)
      Then("User selects continue on 'Who should HMRC send payment to?' page")
      WhoShouldHMRCSendPaymentToPage.clickContinue()
      And("User navigates to 'What is your telephone number?' page")
      WhatIsYourTelephoneNumberPage.validateNavigationAgent()
      WhatIsYourTelephoneNumberPage.validatePageContentAgent()
      And("User validates Error messages on 'What is your telephone number?' page")
      WhatIsYourTelephoneNumberPage.validateErrorMessageAgent()
      Then("User Inputs a Telephone Number on 'What is your telephone number?' page and clicks CONTINUE")
      WhatIsYourTelephoneNumberPage.enterAgentTelephoneNumber("0044 (0123) 456-7890")
      And("User navigates to 'Do you have a UK address?' page")
      DoYouHaveAUKAddressPage.validateNavigationAgent()
      And("User validates no input Error on 'Do you have a UK address?' page")
      DoYouHaveAUKAddressPage.validateErrorMessageAgent()
      And("User selects 'Yes' to 'Do you have a UK address'")
      DoYouHaveAUKAddressPage.radioButton(DoYouHaveAUKAddressPage.yes)
      DoYouHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What is your postcode?' page")
      WhatIsYourPostcodePage.validateNavigationAgent()
      And("User validates Error messages on 'What is your postcode?' page")
      WhatIsYourPostcodePage.validateErrorMessageAgent()
    }
  }
}
