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
import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

class DataGuardSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation - Declaration Page Validations") {
    Scenario(
      "User URL hops to 'Charity Name' page whilst being an org user"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "DATAGUARD-AGENT-R1.8")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      Then("User URL hops to 'Charity name' page")
      WhatIsTheNameOfCharityOrCASC.navigateToPage(WhatIsTheNameOfTheCharityRegulatorPage.pageUrl)
      Then("User validates the 'Claims task lisk' Page")
      ClaimsTaskListPage_Empty.validateNavigation()

    }
    Scenario(
      "User URL hops to 'HMRC Charities ref number' page whilst being an org user"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "DATAGUARD-AGENT-R1.9")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      Then("User URL hops to 'HMRC charities ref number' page")
      WhatIsYourHMRCReferenceNumberPage.navigateToPage(WhatIsYourHMRCReferenceNumberPage.pageUrl)
      Then("User validates the 'Claims task lisk' Page")
      ClaimsTaskListPage_Empty.validateNavigation()

    }

    Scenario(
      "User URL hops to 'Who should we send the payment to' page whilst being an org user"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "DATAGUARD-AGENT-A2-18")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      Then("User URL hops to 'Who should we send the payment to' page")
      WhoShouldHMRCSendPaymentToPage.navigateToPage(WhoShouldHMRCSendPaymentToPage.pageUrl)
      Then("User validates the 'Claims task lisk' Page")
      ClaimsTaskListPage_Empty.validateNavigation()

    }

    Scenario(
      "User URL hops to 'Agent's telephone number' page whilst being an org user"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "DATAGUARD-AGENT-A2-19")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      Then("User URL hops to 'Agent's telephone number' page")
      WhatIsYourTelephoneNumberPage.navigateToPage(WhatIsYourTelephoneNumberPage.pageUrl)
      Then("User validates the 'Claims task lisk' Page")
      ClaimsTaskListPage_Empty.validateNavigation()

    }
    Scenario(
      "User URL hops to 'Agent UK address' page whilst being an org user"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "DATAGUARD-AGENT-A2-20")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      Then("User URL hops to 'Agent Uk Address' page")
      DoYouHaveAUKAddressPage.navigateToPage(DoYouHaveAUKAddressPage.pageUrl)
      Then("User validates the 'Claims task lisk' Page")
      ClaimsTaskListPage_Empty.validateNavigation()

    }
    Scenario(
      "User URL hops to 'Agent Postcode' page whilst being an org user"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "DATAGUARD-AGENT-A2-21")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      Then("User URL hops to 'Agent Postcode' page")
      WhatIsYourPostcodePage.navigateToPage(WhatIsYourPostcodePage.pageUrl)
      Then("User validates the 'Claims task lisk' Page")
      ClaimsTaskListPage_Empty.validateNavigation()

    }
    Scenario(
      "User URL hops to 'Delete Repayment Claim ' page whilst being an org user"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "DATAGUARD-AGENT-WRN10")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      Then("User URL hops to 'Agent Postcode' page")
      DeleteCharityRepaymentAgentPage.navigateToPage(DeleteCharityRepaymentAgentPage.pageUrl)
      Then("User validates the 'Claims task lisk' Page")
      ClaimsTaskListPage_Empty.validateNavigation()

    }
    Scenario(
      "User URL hops to 'Corporate trustee' page whilst being an agent user"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "DATAGUARD-ORGANISATION-A2-6")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      RepaymentClaimDetailsPage.validateParagraphAgent()
      Then("User URL hops to 'Corporate trustee' page")
      IsACorporateTrusteeMakingThisClaimPage.navigateToPage(IsACorporateTrusteeMakingThisClaimPage.pageUrl)
      Then("User validates the 'Charities Management' Page")
      CharitiesManagementAgent.validateNavigationAgent()

    }

    Scenario(
      "User URL hops to 'Corporate trustee address' page whilst being an agent user"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "DATAGUARD-ORGANISATION-A2-7")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      RepaymentClaimDetailsPage.validateParagraphAgent()
      Then("User URL hops to 'Corporate trustee address' page")
      DoesTheCorporateTrusteeHaveAUKAddressPage.navigateToPage(DoesTheCorporateTrusteeHaveAUKAddressPage.pageUrl)
      Then("User validates the 'Charities Management' Page")
      CharitiesManagementAgent.validateNavigationAgent()

    }
    Scenario(
      "User URL hops to 'Authorised Official Details' page whilst being an agent user"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "DATAGUARD-ORGANISATION-A2-8")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      RepaymentClaimDetailsPage.validateParagraphAgent()
      Then("User URL hops to 'Authorised Offical Details' page")
      AuthorisedOfficialDetailsPage.navigateToPage(AuthorisedOfficialDetailsPage.pageUrl)
      Then("User validates the 'Charities Management' Page")
      CharitiesManagementAgent.validateNavigationAgent()

    }
    Scenario(
      "User URL hops to 'Corporate trustee details' page whilst being an agent user"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "DATAGUARD-ORGANISATION-A2-9")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      RepaymentClaimDetailsPage.validateParagraphAgent()
      Then("User URL hops to 'Corporate Trustee Details' page")
      CorporateTrusteeDetailsPage.navigateToPage(CorporateTrusteeDetailsPage.pageUrl)
      Then("User validates the 'Charities Management' Page")
      CharitiesManagementAgent.validateNavigationAgent()

    }

    Scenario(
      "User URL hops to 'Authorised Details' page whilst being an agent user"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "DATAGUARD-ORGANISATION-A2-10")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      RepaymentClaimDetailsPage.validateParagraphAgent()
      Then("User URL hops to 'Authorised Official Details' page")
      AuthorisedOfficialDetailsPage.navigateToPage(AuthorisedOfficialDetailsPage.pageUrl)
      Then("User validates the 'Charities Management' Page")
      CharitiesManagementAgent.validateNavigationAgent()

    }

    Scenario(
      "User URL hops to 'Delete Repayment Claim' page whilst being an agent user"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.loginAgent(HASDIRECT, Agent, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "DATAGUARD-ORGANISATION-A2-10")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementAgent.validateNavigationAgent()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementAgent.clickUseTheCharitiesLink()
      Then("User navigates and validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigationAgent()
      RepaymentClaimDetailsPage.validateParagraphAgent()
      Then("User URL hops to 'Delete Repayment Claim' page")
      DeleteRepaymentClaimPage.navigateToPage(DeleteRepaymentClaimPage.pageUrl)
      Then("User validates the 'Charities Management' Page")
      CharitiesManagementAgent.validateNavigationAgent()

    }

  }
}
