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
import uk.gov.hmrc.ui.pages.*
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

class OLD_GiftAidJourneySpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation - Gift Aid frontend Journeys") {
    Scenario(
      "User navigates the Gift Aid journey, selects all 'Yes' radio button options and enters a valid claim reference number"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "JOURNEYTEST1")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      OLD_AreYouClaimingGiftAidPage.navigateToPage(OLD_AreYouClaimingGiftAidPage.pageUrl)
      OLD_AreYouClaimingGiftAidPage.validateNavigation()
      And("User clicks 'Yes' radio button option")
      OLD_AreYouClaimingGiftAidPage.radioButton(OLD_AreYouClaimingGiftAidPage.yes)
      And("User clicks 'Continue' button")
      OLD_AreYouClaimingGiftAidPage.clickContinue()
      And("User navigates to 'Are you claiming UK tax deducted from other income?' page")
      OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.validateNavigation()
      And("User clicks 'Yes' radio button option")
      OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.radioButton(OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.yes)
      And("User clicks 'Continue' button")
      OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.clickContinue()
      And("User navigates to 'Gift Aid Small Donations Scheme' page")
      OLD_GiftAidSmallDonationsSchemePage.validateNavigation()
      And("User clicks 'Yes' radio button option")
      OLD_GiftAidSmallDonationsSchemePage.radioButton(OLD_GiftAidSmallDonationsSchemePage.yes)
      And("User clicks 'Continue' button")
      OLD_GiftAidSmallDonationsSchemePage.clickContinue()
      And("User navigates to 'Do you have a claim reference number?' page")
      OLD_DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User clicks 'No' radio button option")
      OLD_DoYouHaveAClaimReferenceNumberPage.radioButton(OLD_DoYouHaveAClaimReferenceNumberPage.no)
      And("User clicks 'Continue' button")
      OLD_DoYouHaveAClaimReferenceNumberPage.clickContinue()
      And("User navigates to 'Declaration' page")
      OLD_DeclarationPage.validateNavigation()
      And("User clicks 'Back Link' on the 'Declaration' page")
      OLD_DeclarationPage.clickBackLink()
      And("User navigates to 'Do you have a claim reference number?' page")
      OLD_DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User clicks 'Yes' radio button option")
      OLD_DoYouHaveAClaimReferenceNumberPage.radioButton(OLD_DoYouHaveAClaimReferenceNumberPage.yes)
      And("User clicks 'Continue' button")
      OLD_DoYouHaveAClaimReferenceNumberPage.clickContinue()
      And("User navigates to 'Your claim reference number?' page")
      OLD_WhatIsYourClaimReferenceNumberPage.validateNavigation()
      And("User enters their claim reference number and clicks continue")
      OLD_WhatIsYourClaimReferenceNumberPage.enterClaimReferenceNumber("SOME VALUE HERE")
      // uppercase + 'x', '\' and numbers up to 20 chars ('X' / 'EW' for Eng + Wales, 'CR' scotland, 'CH' ireland)
      And("User navigates to 'Declaration' page")
      OLD_DeclarationPage.validateNavigation()
      And("User clicks 'Continue' button")
      OLD_DeclarationPage.clickContinue()
      And("User navigates to 'Check your answers' page")
      OLD_CheckYourClaimDetailsPage.validateNavigation()
      OLD_CheckYourClaimDetailsPage.clickContinue()
    }
  }

  Scenario(
    "User navigates the Gift Aid journey, selects all 'No' radio button options"
  ) {
    Given("the user logs in through the Authority Wizard page")
    AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "JOURNEYTEST2")
    Then("User navigates to 'Make a charity repayment claim' page")
    ClaimsTaskListPage.validateNavigation()
    Then("User navigates to 'Are you claiming Gift Aid?' page")
    OLD_AreYouClaimingGiftAidPage.navigateToPage(OLD_AreYouClaimingGiftAidPage.pageUrl)
    OLD_AreYouClaimingGiftAidPage.validateNavigation()
    And("User clicks 'No' radio button option")
    OLD_AreYouClaimingGiftAidPage.radioButton(OLD_AreYouClaimingGiftAidPage.no)
    And("User clicks 'Continue' button")
    OLD_AreYouClaimingGiftAidPage.clickContinue()
    And("User navigates to 'Are you claiming UK tax deducted from other income?' page")
    OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.validateNavigation()
    And("User clicks 'No' radio button option")
    OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.radioButton(OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.no)
    And("User clicks 'Continue' button")
    OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.clickContinue()
    And("User navigates to 'Gift Aid Small Donations Scheme' page")
    OLD_GiftAidSmallDonationsSchemePage.validateNavigation()
    And("User clicks 'No' radio button option")
    OLD_GiftAidSmallDonationsSchemePage.radioButton(OLD_GiftAidSmallDonationsSchemePage.no)
    And("User clicks 'Continue' button")
    OLD_GiftAidSmallDonationsSchemePage.clickContinue()
    And("User navigates to 'Do you have a claim reference number?' page")
    OLD_DoYouHaveAClaimReferenceNumberPage.validateNavigation()
    And("User clicks 'No' radio button option")
    OLD_DoYouHaveAClaimReferenceNumberPage.radioButton(OLD_DoYouHaveAClaimReferenceNumberPage.no)
    And("User clicks 'Continue' button")
    OLD_DoYouHaveAClaimReferenceNumberPage.clickContinue()
    And("User navigates to 'Declaration' page")
    OLD_DeclarationPage.validateNavigation()
    And("User clicks 'Continue' button")
    OLD_DeclarationPage.clickContinue()
    And("User navigates to 'Check your answers' page")
    OLD_CheckYourClaimDetailsPage.validateNavigation()
    OLD_CheckYourClaimDetailsPage.clickContinue()
  }
}
