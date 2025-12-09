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

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.ui.pages.*
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

class AboutTheOrgPagesSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation - Gift Aid Page Validations") {
    Scenario(
      "User navigates to the 'Are you claiming Gift Aid?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.3")
      //      Then("User navigates to 'Sign in using test credentials' page")
      //      SignInUsingTestCredentialsPage.validateNavigation()
      //      And("User clicks 'Organisation' radio button option")
      //      SignInUsingTestCredentialsPage.radioButton(SignInUsingTestCredentialsPage.organisation)
      //      And("User enters their User ID and clicks continue")
      //      SignInUsingTestCredentialsPage.enterUserID("TEST7")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage.validateNavigation()
      And("User navigates to 'Your charity is excepted' page")
      YourCharityIsExceptedPage.navigateToPage(YourCharityIsExceptedPage.pageUrl)
      YourCharityIsExceptedPage.validateNavigation()
      Then("User validates the elements on the 'Your charity is excepted' page")
      YourCharityIsExceptedPage.validateParagraph()
    }
  }
}
