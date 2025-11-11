/*
 * Copyright 2023 HM Revenue & Customs
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
//import uk.gov.hmrc.ui.pages.{#PAGE OBJECT NAMES HERE# e.g. ExampleRadioPage}
//import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
//import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

class InitialSpec
  extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Agent - Gift Aid frontend Journeys") {
    Scenario("Agent navigates to **service name**") {
      Given("Agent navigates to **page name** page")
      //CODE LINE - e.g. ExampleRadioPage.verifyPageTitle(ExampleRadioPage.pageTitle)
      //CODE LINE - e.g. ExampleRadioPage.verifyPageHeader(ExampleRadioPage.pageHeader)
      And("Agent clicks 'Yes' radio button option")
      //CODE LINE - e.g. ExampleRadioPage.clickYesRadio()
      And("Agent clicks 'Continue' button")
      //CODE LINE - e.g. ExampleRadioPage.clickSubmitButton()
      And("User navigates to **next page** page")
      //CODE LINE - e.g. AnotherPage.verifyPageTitle(AnotherPage.pageTitle)
    }
  }
}