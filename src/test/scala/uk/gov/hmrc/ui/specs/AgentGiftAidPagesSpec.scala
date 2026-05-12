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

class AgentGiftAidPagesSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Agent - Gift Aid Page Validations") {
    Scenario(
      "User navigates to the 'Repayment claim details' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETESTR10")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      RepaymentClaimDetailsPage.validateParagraphAgent()
    }

    Scenario(
      "User Logs in with an Agent User and Creates N claims from a single Agent User:" + CharitiesManagementAgent.RandomUsername
    ) {
      Given("the user logs in through the Authority Wizard page")
      CharitiesManagementAgent.runCreateNClaims(120)
    }

    Scenario(
      "User navigates to the 'HMRC Charities Reference Number' page and validates the page elements and all error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETESTR10")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      RepaymentClaimDetailsPage.validateParagraphAgent()
      Then("User Clicks Continue and navigates to 'Enter HMRC Charities Reference' page")
      RepaymentClaimDetailsPage.clickContinue()
      And("User Validates Navigation/hint for the 'Enter HMRC Charities Reference' page")
      WhatIsYourHMRCReferenceNumberPage.validateNavigationAgent()
      WhatIsYourHMRCReferenceNumberPage.validateHintAgent()
      And("User Validates Error messages of 'Enter HMRC Charities Reference' page")
      WhatIsYourHMRCReferenceNumberPage.validateErrorMessage()
      WhatIsYourHMRCReferenceNumberPage.validateWrongFormatErrorMessage(
        WhatIsYourHMRCReferenceNumberPage.pageErrorInvalidFormat,
        WhatIsYourHMRCReferenceNumberPage.errorMsgLocator
      )
    }

    Scenario(
      "User navigates to the 'What is the Name of your Charity or CASC' page and validates the page elements and all error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETESTR10")
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
      WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber("X1")
      And("User Navigates to 'What is the Name of your Charity or CASC' page and validates the page elements and text")
      WhatIsTheNameOfCharityOrCASC.validateNavigationAgent()
      WhatIsTheNameOfCharityOrCASC.validateHintAgent()
      WhatIsTheNameOfCharityOrCASC.validatePageContentAgent()
      Then("User Validates all error messages on 'What is the Name of your Charity or CASC' page")
      WhatIsTheNameOfCharityOrCASC.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Which type of repayment claim do you want to make?' Checkbox page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETESTR11")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      And("User navigates to 'Which type of repayment claim do you want to make?' checkbox page")
      RepaymentCheckboxPage.navigateToPage(RepaymentCheckboxPage.pageUrl)
      RepaymentCheckboxPage.validateNavigationAgent()
      RepaymentCheckboxPage.validateHint()
      // And("user selects all 3 types of checkboxes")
      // RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GiftAid, true)
      // RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      // RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.OtherIncome, true)
      Then(
        "User validates the 'no input' error on the 'Which type of repayment claim do you want to make?' checkbox page"
      )
      RepaymentCheckboxPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Gift Aid Small Donations Scheme claim' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETESTR12")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      And("User navigates to 'Type of Repayment Claim' checkbox page")
      RepaymentCheckboxPage.navigateToPage(RepaymentCheckboxPage.pageUrl)
      RepaymentCheckboxPage.validateNavigationAgent()
      Then("User selects the 'Top up payments for donations under the Gift Aid Small Donations Scheme' option")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigationAgent()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContentAgent()
      And("User selects 'GASDS top-up' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSTopUp, true)
      GASDSCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigationAgent()
      GiftAidSmallDonationsSchemeClaimPage.validateParagraphAgent()
      Then("User validates the 'no input' error on the 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Do you have a claim reference number?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETESTR13")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      And("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.navigateToPage(DoYouHaveAClaimReferenceNumberPage.pageUrl)
      DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
      Then("User validates the 'no input' error on the 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'What is your claim reference number?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETESTR14")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      And("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.navigateToPage(DoYouHaveAClaimReferenceNumberPage.pageUrl)
      DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
      Then("User clicks 'yes' radio button")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.yes)
      Then("User clicks 'continue' button")
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      And("User navigates to 'What is your claim reference number?' page")
      WhatIsYourClaimReferenceNumberPage.navigateToPage(WhatIsYourClaimReferenceNumberPage.pageUrl)
      WhatIsYourClaimReferenceNumberPage.validateNavigationAgent()
      Then("User validates the elements on the 'What is your claim reference number?' page")
      WhatIsYourClaimReferenceNumberPage.validateHint()
      Then("User validates the 'no input' error on the 'What is your claim reference number?' page")
      WhatIsYourClaimReferenceNumberPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Check your Repayment Claim details' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETESTR15")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      And("User navigates to 'Check your Repayment Claim details' page")
      CheckYourRepaymentClaimPage.navigateToPage(CheckYourRepaymentClaimPage.pageUrl)
      CheckYourRepaymentClaimPage.validateNavigationAgent()
    }

    Scenario(
      "User navigates to the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "PAGETESTR16")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      And("User navigates to 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      And("User navigates to 'Type of Repayment Claim' checkbox page")
      RepaymentCheckboxPage.navigateToPage(RepaymentCheckboxPage.pageUrl)
      RepaymentCheckboxPage.validateNavigationAgent()
      Then("User selects the 'Top up payments for donations under the Gift Aid Small Donations Scheme' option")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.navigateToPage(GASDSCheckboxPage.pageUrl)
      GASDSCheckboxPage.validateNavigationAgent()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContentAgent()
      Then("User validates the 'no input' error on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateErrorMessage()
    }
  }
}
