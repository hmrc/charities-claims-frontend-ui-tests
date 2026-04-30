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
import uk.gov.hmrc.ui.util.Users.UserTypes.Agent_Trust

class Agent_AboutTheOrgJourneySpec
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
      "AGENT JOURNEY TEST"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Agent_Trust, "Agent", "HMRC-CHAR-AGENT", "AGENTCHARID", "AGTJOURNEYTEST")
      Then("User navigates to 'Manage Charity repayment claims' page")
      CharitiesManagementPlaceholder_Agent.validateNavigation()
      Then("User validates content on 'Manage Charity repayment claims' page")
      CharitiesManagementPlaceholder_Agent.validatePageContent()
      And("User clicks the link to navigate to 'Make a charity repayment claim' page")
      CharitiesManagementPlaceholder_Agent.clickLinkToMakeANewClaim()
      Then("User navigates to 'Make a charity repayment claim' page")
//      ClaimsTaskListPage_Empty.validateNavigation()
    }
  }
}
