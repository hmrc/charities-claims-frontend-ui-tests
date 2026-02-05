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
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R2.0")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      ClaimsTaskListPage.validatePageContent()
    }

    Scenario(
      "User navigates to the 'Repayment claim details' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R1.0")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      RepaymentClaimDetailsPage.validateParagraph()
    }

    Scenario(
      "User navigates to the 'Type of Repayment Claim' Checkbox page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R1.1")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User navigates to 'Type of Repayment Claim' checkbox page")
      RepaymentCheckboxPage.navigateToPage(RepaymentCheckboxPage.pageUrl)
      RepaymentCheckboxPage.validateNavigation()
      RepaymentCheckboxPage.validateHints()
      // And("user selects all 3 types of checkboxes")
      // RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GiftAid, true)
      // RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      // RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.OtherIncome, true)
      Then("User validates the 'no input' error on the 'Type of Repayment Claim' checkbox page")
      RepaymentCheckboxPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R1.2")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User navigates to 'Type of Repayment Claim' checkbox page")
      RepaymentCheckboxPage.navigateToPage(RepaymentCheckboxPage.pageUrl)
      RepaymentCheckboxPage.validateNavigation()
      Then("User selects the 'Top up payments for donations under the Gift Aid Small Donations Scheme' option")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page")
      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
      DoYouWantToClaimATopUpUnderGASDSPage.validateHint()
      Then(
        "User validates the 'no input' error on the 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page"
      )
      DoYouWantToClaimATopUpUnderGASDSPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Claim Community Building Donations' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R1.3")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User navigates to 'Type of Repayment Claim' checkbox page")
      RepaymentCheckboxPage.navigateToPage(RepaymentCheckboxPage.pageUrl)
      RepaymentCheckboxPage.validateNavigation()
      Then("User selects the 'Top up payments for donations under the Gift Aid Small Donations Scheme' option")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page")
      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
      And(
        "User selects 'No' on the 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page'"
      )
      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouWantToClaimATopUpUnderGASDSPage.no)
      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
      And("User navigates to 'Claim Community Building Donations' page")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateHint()
      Then("User validates the 'no input' error on the 'Claim Community Building Donations' page")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Gift Aid Small Donations Scheme claim' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R1.4")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User navigates to 'Type of Repayment Claim' checkbox page")
      RepaymentCheckboxPage.navigateToPage(RepaymentCheckboxPage.pageUrl)
      RepaymentCheckboxPage.validateNavigation()
      Then("User selects the 'Top up payments for donations under the Gift Aid Small Donations Scheme' option")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page")
      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
      And(
        "User selects 'Yes' on the 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page'"
      )
      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouWantToClaimATopUpUnderGASDSPage.yes)
      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
      Then("User navigates to 'Claim Community Building Donations' page")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
      And("User selects 'Yes' on the 'Claim Community Building Donations' page'")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.radioButton(
        DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.yes
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateNavigation()
      GiftAidSmallDonationsSchemeClaimPage.validateParagraph()
      Then("User validates the 'no input' error on the 'Gift Aid Small Donations Scheme claim' page")
      GiftAidSmallDonationsSchemeClaimPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Connected charities and Community Amateur Sports Clubs' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R1.5")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User navigates to 'Type of Repayment Claim' checkbox page")
      RepaymentCheckboxPage.navigateToPage(RepaymentCheckboxPage.pageUrl)
      RepaymentCheckboxPage.validateNavigation()
      Then("User selects the 'Top up payments for donations under the Gift Aid Small Donations Scheme' option")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GASDSclaim, true)
      RepaymentCheckboxPage.clickContinue()
      And("User navigates to 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page")
      DoYouWantToClaimATopUpUnderGASDSPage.validateNavigation()
      And(
        "User selects 'No' on the 'Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?' page'"
      )
      DoYouWantToClaimATopUpUnderGASDSPage.radioButton(DoYouWantToClaimATopUpUnderGASDSPage.no)
      DoYouWantToClaimATopUpUnderGASDSPage.clickContinue()
      Then("User navigates to 'Claim Community Building Donations' page")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.validateNavigation()
      And("User selects 'No' on the 'Claim Community Building Donations' page'")
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.radioButton(
        DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.no
      )
      DoYouWantToClaimForDonationsCollectedInCommunityBuildingsPage.clickContinue()
      And("User navigates to 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.navigateToPage(ConnectedCharitiesPage.pageUrl)
      ConnectedCharitiesPage.validateNavigation()
      ConnectedCharitiesPage.validateParagraph()
      Then("User validates the 'no input' error on the 'Connected charities and Community Amateur Sports Clubs' page")
      ConnectedCharitiesPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Do you have a claim reference number?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R1.6")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
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
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R1.7")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
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
  }
}
