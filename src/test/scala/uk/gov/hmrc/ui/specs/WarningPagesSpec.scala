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

class WarningPagesSpec
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
      "User navigates to the 'Do you want to delete this Gift Aid schedule?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGTEST - WRN1.0")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateNavigation()
      Then("User navigates to 'Do you want to delete this Gift Aid schedule?' page")
      DeleteGiftAidSchedulePage.navigateToPage(DeleteGiftAidSchedulePage.pageUrl)
      DeleteGiftAidSchedulePage.validateNavigation()
      Then("User validates the 'no input' error on the 'Do you want to delete this Gift Aid schedule?' page")
      DeleteGiftAidSchedulePage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Do you want to delete this Other Income schedule?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGTEST - WRN1.1")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateNavigation()
      Then("User navigates to 'Do you want to delete this Other Income schedule?' page")
      DeleteOtherIncomeSchedulePage.navigateToPage(DeleteOtherIncomeSchedulePage.pageUrl)
      DeleteOtherIncomeSchedulePage.validateNavigation()
      Then("User validates the 'no input' error on the 'Do you want to delete this Other Income schedule?' page")
      DeleteOtherIncomeSchedulePage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Do you want to delete this GASDS community buildings schedule?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGTEST - WRN1.2")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateNavigation()
      Then("User navigates to 'Do you want to delete this GASDS community buildings schedule?' page")
      DeleteGASDSCommunityBuildingsSchedulePage.navigateToPage(DeleteGASDSCommunityBuildingsSchedulePage.pageUrl)
      DeleteGASDSCommunityBuildingsSchedulePage.validateNavigation()
      Then(
        "User validates the 'no input' error on the 'Do you want to delete this GASDS community buildings schedule?' page"
      )
      DeleteGASDSCommunityBuildingsSchedulePage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Do you want to delete this GASDS connected charities schedule?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGTEST - WRN1.3")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateNavigation()
      Then("User navigates to 'Do you want to delete this GASDS connected charities schedule?' page")
      DeleteGASDSConnectedCharitiesSchedulePage.navigateToPage(DeleteGASDSConnectedCharitiesSchedulePage.pageUrl)
      DeleteGASDSConnectedCharitiesSchedulePage.validateNavigation()
      Then(
        "User validates the 'no input' error on the 'Do you want to delete this GASDS connected charities schedule?' page"
      )
      DeleteGASDSConnectedCharitiesSchedulePage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Are you sure you want to delete this repayment claim?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGTEST - WRN 2")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateNavigation()
      Then("User navigates to 'Are you sure you want to delete this repayment claim?' page")
      DeleteRepaymentClaimPage.navigateToPage(DeleteRepaymentClaimPage.pageUrl)
      DeleteRepaymentClaimPage.validateNavigation()
      Then(
        "User validates the 'no input' error on the 'Are you sure you want to delete this repayment claim?' page"
      )
      DeleteRepaymentClaimPage.validateErrorMessage()
    }
  }
}
