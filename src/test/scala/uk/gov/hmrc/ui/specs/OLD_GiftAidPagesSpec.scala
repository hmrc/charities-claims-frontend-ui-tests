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

class OLD_GiftAidPagesSpec
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
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGTEST - R1.0")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateNavigation()
      Then("User validates the elements on the 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateHint()
      Then("User validates the 'no input' error on the 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Are you claiming tax deducted from another income?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R1.1")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateNavigation()
      And("User navigates to 'Are you claiming UK tax deducted from other income?' page")
      AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.navigateToPage(
        AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.pageUrl
      )
      AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.validateNavigation()
      AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.validateParagraph()
      Then("User validates the 'no input' error on the 'Are you claiming Gift Aid?' page")
      AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Gift Aid Small Donations Scheme' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R1.2")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateNavigation()
      And("User navigates to 'Gift Aid Small Donations Scheme' page")
      GiftAidSmallDonationsSchemePage_OLD.navigateToPage(GiftAidSmallDonationsSchemePage_OLD.pageUrl)
      GiftAidSmallDonationsSchemePage_OLD.validateNavigation()
      GiftAidSmallDonationsSchemePage_OLD.validateParagraph()
      Then("User validates the 'no input' error on the 'Gift Aid Small Donations Scheme' page")
      GiftAidSmallDonationsSchemePage_OLD.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Do you have a claim reference number?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R1.3")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateNavigation()
      And("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage_OLD.navigateToPage(DoYouHaveAClaimReferenceNumberPage_OLD.pageUrl)
      DoYouHaveAClaimReferenceNumberPage_OLD.validateNavigation()
      Then("User validates the 'no input' error on the 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage_OLD.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'What is your reference number?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R1.4")
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage_OLD.navigateToPage(DoYouHaveAClaimReferenceNumberPage_OLD.pageUrl)
      DoYouHaveAClaimReferenceNumberPage_OLD.validateNavigation()
      Then("User clicks 'yes' radio button")
      DoYouHaveAClaimReferenceNumberPage_OLD.radioButton(DoYouHaveAClaimReferenceNumberPage_OLD.yes)
      Then("User clicks 'continue' button")
      DoYouHaveAClaimReferenceNumberPage_OLD.clickContinue()
      And("User navigates to 'What is your reference number?' page")
      WhatIsYourClaimReferenceNumberPage_OLD.navigateToPage(WhatIsYourClaimReferenceNumberPage_OLD.pageUrl)
      WhatIsYourClaimReferenceNumberPage_OLD.validateNavigation()
      Then("User validates the elements on the 'What is your reference number?' page")
      WhatIsYourClaimReferenceNumberPage_OLD.validateParagraph()
      Then("User validates the 'no input' error on the 'What is your reference number?' page")
      WhatIsYourClaimReferenceNumberPage_OLD.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Declaration' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R1.5")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateNavigation()
      And("User navigates to 'Declaration' page")
      DeclarationPage_OLD.navigateToPage(DeclarationPage_OLD.pageUrl)
      DeclarationPage_OLD.validateNavigation()
      Then("User validates the elements on the 'Declaration' page")
      DeclarationPage_OLD.validateParagraph()
    }

    Scenario(
      "User navigates to the 'Check your claim details' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - R1.6")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateNavigation()
      And("User navigates to 'Check your claim details' page")
      CheckYourClaimDetailsPage_OLD.navigateToPage(CheckYourClaimDetailsPage_OLD.pageUrl)
      CheckYourClaimDetailsPage_OLD.validateNavigation()
//      Then("User validates the 'no input' error on the 'Check your claim details' page")
//      CheckYourClaimDetailsPage_OLD.validateParagraph()
//      CheckYourClaimDetailsPage_OLD.validateErrorMessage()
    }

    Scenario(
      "User attempts to navigate to the 'What is your reference number?' page without required data and validates the user is taken to page not found"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - ERR2")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateNavigation()
      Then("User navigates to 'What is your reference number?' page")
      WhatIsYourClaimReferenceNumberPage_OLD.navigateToPage(WhatIsYourClaimReferenceNumberPage_OLD.pageUrl)
      Error_PageNotFoundPage.validateNavigation()
      Then("User validates the 'page not found' content")
      Error_PageNotFoundPage.validatePageContent()
    }

    Scenario(
      "User navigates to the 'Access Denied' page and validates the user is taken to Access Denied page"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - ERR3")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage_OLD.validateNavigation()
      Then("User navigates to 'Access Denied' error page")
      AccessDeniedErrorPage.navigateToPage(AccessDeniedErrorPage.pageUrl)
      AccessDeniedErrorPage.validateNavigation()
      Then("User validates the 'Access Denied' page content")
      AccessDeniedErrorPage.validatePageContent()
    }
  }
}
