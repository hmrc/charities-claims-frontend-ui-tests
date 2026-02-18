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

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.ui.pages.{AboutOtherIncomeSchedulePage, AuthWizard}
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

class OtherIncomePagesSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {
  Feature("Charities - Organisation - About Other Income Schedule") {
    Scenario("User navigates to the 'About Other Income Schedule' page without meeting the minimum data guard") {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(
        HASDIRECT,
        Organisation,
        "Organisation",
        "HMRC-CHAR-ORG",
        "CHARID",
        "PAGETEST - O1.0 - Page Not Found"
      )
      Then("the user tries to access the screen and reaches 'Page Not Found'")
      AboutOtherIncomeSchedulePage.validateDataGuardProtection()
    }

    Scenario("User navigates to the 'About Other Income Schedule' page and completes the minimum data guard") {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - O1.0")
      Then("the user navigates too 'Claims Task List' then completes the necessary minimum data input")
      AboutOtherIncomeSchedulePage.completeMinimumDataGuard()
      Then("the user has completed the minimum data required and navigates to 'About Other Income Schedule' page")
      AboutOtherIncomeSchedulePage.goToAboutOtherIncomeSchedulePage()
      Then("the we validate the page content")
      AboutOtherIncomeSchedulePage.validateNavigation()
      AboutOtherIncomeSchedulePage.validatePageContent()
    }
  }
}
