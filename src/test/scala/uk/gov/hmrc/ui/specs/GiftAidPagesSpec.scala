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

class GiftAidPagesSpec
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
      "User navigates to the 'Make a charity repayment claim' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST-R20")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      ClaimsTaskListPage_Empty.validatePageContent()
    }

    Scenario(
      "User navigates to the 'Repayment claim details' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST-R10")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      RepaymentClaimDetailsPage.validateParagraph()
    }

    Scenario(
      "User navigates to the 'Which type of repayment claim do you want to make?' Checkbox page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST-R11")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User navigates to 'Which type of repayment claim do you want to make?' checkbox page")
      RepaymentCheckboxPage.navigateToPage(RepaymentCheckboxPage.pageUrl)
      RepaymentCheckboxPage.validateNavigation()
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
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST-R14")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User navigates to 'Type of Repayment Claim' checkbox page")
      RepaymentCheckboxPage.navigateToPage(RepaymentCheckboxPage.pageUrl)
      RepaymentCheckboxPage.validateNavigation()
      Then("User selects the 'Top up payments for donations under the Gift Aid Small Donations Scheme' option")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateNavigation()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContent()
      And("User selects 'GASDS top-up' checkbox and clicks continue")
      GASDSCheckboxPage.checkbox(GASDSCheckboxPage.GASDSTopUp, true)
      GASDSCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
      GiftAidSmallDonationsSchemeClaimPage.validateParagraph()
      Then("User validates the 'no input' error on the 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Do you have a claim reference number?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST-R16")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.navigateToPage(DoYouHaveAClaimReferenceNumberPage.pageUrl)
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      Then("User validates the 'no input' error on the 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'What is your claim reference number?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST-R17")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.navigateToPage(DoYouHaveAClaimReferenceNumberPage.pageUrl)
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      Then("User clicks 'yes' radio button")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.yes)
      Then("User clicks 'continue' button")
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      And("User navigates to 'What is your claim reference number?' page")
      WhatIsYourClaimReferenceNumberPage.navigateToPage(WhatIsYourClaimReferenceNumberPage.pageUrl)
      WhatIsYourClaimReferenceNumberPage.validateNavigation()
      Then("User validates the elements on the 'What is your claim reference number?' page")
      WhatIsYourClaimReferenceNumberPage.validateHint()
      Then("User validates the 'no input' error on the 'What is your claim reference number?' page")
      WhatIsYourClaimReferenceNumberPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Check your Repayment Claim details' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST-R18")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User navigates to 'Check your Repayment Claim details' page")
      CheckYourRepaymentClaimPage.navigateToPage(CheckYourRepaymentClaimPage.pageUrl)
      CheckYourRepaymentClaimPage.validateNavigation()
    }

    Scenario(
      "User navigates to the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST-NEWR14")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User navigates to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      RepaymentClaimDetailsPage.validateNavigation()
      And("User navigates to 'Type of Repayment Claim' checkbox page")
      RepaymentClaimDetailsPage.clickContinue()
      RepaymentCheckboxPage.validateNavigation()
      Then("User selects the 'Top up payments for donations under the Gift Aid Small Donations Scheme' option")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.navigateToPage(GASDSCheckboxPage.pageUrl)
      GASDSCheckboxPage.validateNavigation()
      Then("User validates entire page content on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validatePageContent()
      Then("User validates the 'no input' error on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.validateErrorMessage()
    }

    Scenario(
      "User navigates with a Charity Ref Starting with CH or CF to the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "CH1234")
      Then("User navigates to 'Manage charity repayment claims' page and validates navigation")
      CharitiesManagementPlaceholder.validateNavigation()
      And(
        "User clicks the link 'Use the charities online service' to navigate to task list 'Make a charity repayment claim' page"
      )
      CharitiesManagementPlaceholder.clickUseTheCharitiesLink()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User navigates to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      RepaymentClaimDetailsPage.validateNavigation()
      And("User navigates to 'Type of Repayment Claim' checkbox page")
      RepaymentClaimDetailsPage.clickContinue()
      RepaymentCheckboxPage.validateNavigation()
      Then("User selects the 'Top up payments for donations under the Gift Aid Small Donations Scheme' option")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
      GASDSCheckboxPage.navigateToPage(GASDSCheckboxPage.pageUrl)
      GASDSCheckboxPage.validateNavigation()
      Then(
        "User validates entire page content (without Community Building Details) on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page"
      )
      // TODO real validation to check no CB on page and error message does not have CB
      GASDSCheckboxPage.validatePageContentCASC()
//      Then("User validates the 'no input' error on the 'Gift Aid Small Donations Scheme (GASDS) details' checkbox page")
//      GASDSCheckboxPage.validateErrorMessage()
    }
  }
}
