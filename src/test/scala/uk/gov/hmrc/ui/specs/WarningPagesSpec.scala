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
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
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
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
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
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
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
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
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
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      Then("User navigates to 'Are you sure you want to delete this repayment claim?' page")
      DeleteRepaymentClaimPage.navigateToPage(DeleteRepaymentClaimPage.pageUrl)
      DeleteRepaymentClaimPage.validateNavigation()
      Then(
        "User validates the 'no input' error on the 'Are you sure you want to delete this repayment claim?' page"
      )
      DeleteRepaymentClaimPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Check your organisation details' page with missing information and validates correct warning screen is displayed on submission"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(
        HASDIRECT,
        Organisation,
        "Organisation",
        "HMRC-CHAR-ORG",
        "CHARID",
        "PAGETEST - Organisation WRN6"
      )
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.navigateToPage(CheckYourOrganisationDetailsPage.pageUrl)
      CheckYourOrganisationDetailsPage.validateNavigation()
      Then("User attempts to submit with missing details on 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.clickContinue()
      And("User navigates to 'This claim cannot be setup' page")
      ThisClaimCannotBeSetupPage_Organisation.validateNavigation()
      Then("User validates the expected missing info on the 'This claim cannot be setup' page")
      ThisClaimCannotBeSetupPage_Organisation.validatePageContent()
    }

    Scenario(
      "User navigates to the 'Check your repayment claim' page with missing information and validates correct warning screen is displayed on submission"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - Repayment WRN6")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigation()
      And("User selects 'Top up payments for donations under the GASDS' checkbox and clicks continue")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page")
      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
      And(
        "User selects 'Yes' and clicks continue on 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
      )
      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouWantToClaimATopUpUnderGASDSPage.yes)
      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
      Then("User navigates to 'Do you want to claim for donations collected in community buildings?' page")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
      And("User navigates to 'Check your repayment claim details' page")
      CheckYourRepaymentClaimPage.navigateToPage(CheckYourRepaymentClaimPage.pageUrl)
      Then("User attempts to submit with missing details on 'Check your repayment claim details' page")
      CheckYourRepaymentClaimPage.clickContinue()
      And("User navigates to 'This claim cannot be setup' page")
      ThisClaimCannotBeSetupPage_Repayment.validateNavigation()
      Then("User validates the expected missing info on the 'This claim cannot be setup' page")
      ThisClaimCannotBeSetupPage_Repayment.validatePageContent()
    }
  }
}
