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
//    Scenario(
//      "User navigates to the 'Are you claiming Gift Aid?' page and validates the page elements and error messages"
//    ) {
//      Given("the user logs in through the Authority Wizard page")
//      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGTEST1")
////      Then("User navigates to 'Sign in using test credentials' page")
////      SignInUsingTestCredentialsPage.validateNavigation()
////      And("User clicks 'Organisation' radio button option")
////      SignInUsingTestCredentialsPage.radioButton(SignInUsingTestCredentialsPage.organisation)
////      And("User enters their User ID and clicks continue")
////      SignInUsingTestCredentialsPage.enterUserID("TEST1")
//      Then("User navigates to 'Are you claiming Gift Aid?' page")
//      AreYouClaimingGiftAidPage.validateNavigation()
//      Then("User validates the elements on the 'Are you claiming Gift Aid?' page")
//      AreYouClaimingGiftAidPage.validateHint()
//      Then("User validates the 'no input' error on the 'Are you claiming Gift Aid?' page")
//      AreYouClaimingGiftAidPage.validateErrorMessage()
//    }
//
//    Scenario(
//      "User navigates to the 'Are you claiming tax deducted from another income?' page and validates the page elements and error messages"
//    ) {
//      Given("the user logs in through the Authority Wizard page")
//      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST2")
////      Then("User navigates to 'Sign in using test credentials' page")
////      SignInUsingTestCredentialsPage.validateNavigation()
////      And("User clicks 'Organisation' radio button option")
////      SignInUsingTestCredentialsPage.radioButton(SignInUsingTestCredentialsPage.organisation)
////      And("User enters their User ID and clicks continue")
////      SignInUsingTestCredentialsPage.enterUserID("TEST2")
//      Then("User navigates to 'Are you claiming Gift Aid?' page")
//      AreYouClaimingGiftAidPage.validateNavigation()
//      And("User navigates to 'Are you claiming UK tax deducted from other income?' page")
//      AreYouClaimingTaxDeductedFromOtherIncomePage.navigateToPage(AreYouClaimingTaxDeductedFromOtherIncomePage.pageUrl)
//      AreYouClaimingTaxDeductedFromOtherIncomePage.validateNavigation()
//      AreYouClaimingTaxDeductedFromOtherIncomePage.validateParagraph()
//      Then("User validates the 'no input' error on the 'Are you claiming Gift Aid?' page")
//      AreYouClaimingTaxDeductedFromOtherIncomePage.validateErrorMessage()
//    }
//
//    Scenario(
//      "User navigates to the 'Gift Aid Small Donations Scheme' page and validates the page elements and error messages"
//    ) {
//      Given("the user logs in through the Authority Wizard page")
//      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST3")
////      Then("User navigates to 'Sign in using test credentials' page")
////      SignInUsingTestCredentialsPage.validateNavigation()
////      And("User clicks 'Organisation' radio button option")
////      SignInUsingTestCredentialsPage.radioButton(SignInUsingTestCredentialsPage.organisation)
////      And("User enters their User ID and clicks continue")
////      SignInUsingTestCredentialsPage.enterUserID("TEST3")
//      Then("User navigates to 'Are you claiming Gift Aid?' page")
//      AreYouClaimingGiftAidPage.validateNavigation()
//      And("User navigates to 'Gift Aid Small Donations Scheme' page")
//      GiftAidSmallDonationsSchemePage.navigateToPage(GiftAidSmallDonationsSchemePage.pageUrl)
//      GiftAidSmallDonationsSchemePage.validateNavigation()
//      GiftAidSmallDonationsSchemePage.validateParagraph()
//      Then("User validates the 'no input' error on the 'Gift Aid Small Donations Scheme' page")
//      GiftAidSmallDonationsSchemePage.validateErrorMessage()
//    }
//
//    Scenario(
//      "User navigates to the 'Do you have a claim reference number?' page and validates the page elements and error messages"
//    ) {
//      Given("the user logs in through the Authority Wizard page")
//      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST4")
////      Then("User navigates to 'Sign in using test credentials' page")
////      SignInUsingTestCredentialsPage.validateNavigation()
////      And("User clicks 'Organisation' radio button option")
////      SignInUsingTestCredentialsPage.radioButton(SignInUsingTestCredentialsPage.organisation)
////      And("User enters their User ID and clicks continue")
////      SignInUsingTestCredentialsPage.enterUserID("TEST4")
//      Then("User navigates to 'Are you claiming Gift Aid?' page")
//      AreYouClaimingGiftAidPage.validateNavigation()
//      And("User navigates to 'Do you have a claim reference number?' page")
//      DoYouHaveAClaimReferenceNumberPage.navigateToPage(DoYouHaveAClaimReferenceNumberPage.pageUrl)
//      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
//      Then("User validates the 'no input' error on the 'Do you have a claim reference number?' page")
//      DoYouHaveAClaimReferenceNumberPage.validateErrorMessage()
//    }
//
//    Scenario(
//      "User navigates to the 'What is your reference number?' page and validates the user is taken to page not found"
//    ) {
//      Given("the user logs in through the Authority Wizard page")
//      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST5")
////      Then("User navigates to 'Sign in using test credentials' page")
////      SignInUsingTestCredentialsPage.validateNavigation()
////      And("User clicks 'Organisation' radio button option")
////      SignInUsingTestCredentialsPage.radioButton(SignInUsingTestCredentialsPage.organisation)
////      And("User enters their User ID and clicks continue")
////      SignInUsingTestCredentialsPage.enterUserID("TEST5")
//      Then("User navigates to 'What is your reference number?' page")
//      WhatIsYourClaimReferenceNumberPage.navigateToPage(WhatIsYourClaimReferenceNumberPage.pageUrl)
//      ErrorPageNotFoundPage.validateNavigation()
//      Then("User validates the 'page not found' content")
//      ErrorPageNotFoundPage.validatePageContent()
//    }
//
//    Scenario(
//      "User navigates to the 'What is your reference number?' page and validates the page elements and error messages"
//    ) {
//      Given("the user logs in through the Authority Wizard page")
//      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST6")
////      Then("User navigates to 'Sign in using test credentials' page")
////      SignInUsingTestCredentialsPage.validateNavigation()
////      And("User clicks 'Organisation' radio button option")
////      SignInUsingTestCredentialsPage.radioButton(SignInUsingTestCredentialsPage.organisation)
////      And("User enters their User ID and clicks continue")
////      SignInUsingTestCredentialsPage.enterUserID("TEST6")
//      Then("User navigates to 'Do you have a claim reference number?' page")
//      DoYouHaveAClaimReferenceNumberPage.navigateToPage(DoYouHaveAClaimReferenceNumberPage.pageUrl)
//      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
//      Then("User clicks 'yes' radio button")
//      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.yes)
//      Then("User clicks 'continue' button")
//      DoYouHaveAClaimReferenceNumberPage.clickContinue()
//      And("User navigates to 'What is your reference number?' page")
//      WhatIsYourClaimReferenceNumberPage.navigateToPage(WhatIsYourClaimReferenceNumberPage.pageUrl)
//      WhatIsYourClaimReferenceNumberPage.validateNavigation()
//      Then("User validates the elements on the 'What is your reference number?' page")
//      WhatIsYourClaimReferenceNumberPage.validateParagraph()
//      Then("User validates the 'no input' error on the 'What is your reference number?' page")
//      WhatIsYourClaimReferenceNumberPage.validateErrorMessage()
//    }
//
//    Scenario(
//      "User navigates to the 'Declaration' page and validates the page elements and error messages"
//    ) {
//      Given("the user logs in through the Authority Wizard page")
//      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST7")
////      Then("User navigates to 'Sign in using test credentials' page")
////      SignInUsingTestCredentialsPage.validateNavigation()
////      And("User clicks 'Organisation' radio button option")
////      SignInUsingTestCredentialsPage.radioButton(SignInUsingTestCredentialsPage.organisation)
////      And("User enters their User ID and clicks continue")
////      SignInUsingTestCredentialsPage.enterUserID("TEST7")
//      Then("User navigates to 'Are you claiming Gift Aid?' page")
//      AreYouClaimingGiftAidPage.validateNavigation()
//      And("User navigates to 'Do you have a claim reference number?' page")
//      DeclarationPage.navigateToPage(DeclarationPage.pageUrl)
//      DeclarationPage.validateNavigation()
//      Then("User validates the elements on the 'Declaration' page")
//      DeclarationPage.validateParagraph()
//    }
//
//    Scenario(
//      "User navigates to the 'Check your claim details' page and validates the page elements and error messages"
//    ) {
//      Given("the user logs in through the Authority Wizard page")
//      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST8")
////      Then("User navigates to 'Sign in using test credentials' page")
////      SignInUsingTestCredentialsPage.validateNavigation()
////      And("User clicks 'Organisation' radio button option")
////      SignInUsingTestCredentialsPage.radioButton(SignInUsingTestCredentialsPage.organisation)
////      And("User enters their User ID and clicks continue")
////      SignInUsingTestCredentialsPage.enterUserID("TEST8")
//      Then("User navigates to 'Are you claiming Gift Aid?' page")
//      AreYouClaimingGiftAidPage.validateNavigation()
//      And("User navigates to 'Check your claim details' page")
//      CheckYourClaimDetailsPage.navigateToPage(CheckYourClaimDetailsPage.pageUrl)
//      CheckYourClaimDetailsPage.validateNavigation()
////      Then("User validates the 'no input' error on the 'Check your claim details' page")
////      CheckYourClaimDetailsPage.validateParagraph()
////      CheckYourClaimDetailsPage.validateErrorMessage()
//    }
  }
}
