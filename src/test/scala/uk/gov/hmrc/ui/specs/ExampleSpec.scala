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
//import uk.gov.hmrc.ui.pages.{#PAGE OBJECT NAMES HERE# e.g. ExampleRadioPage}
//import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
//import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

class ExampleSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation - Gift Aid frontend Journeys") {
    Scenario("User navigates the Gift Aid journey, selects all 'Yes' radio button options and enters a valid claim reference number") {
      Given("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage.verifyPageTitle(AreYouClaimingGiftAidPage.pageTitle)
      AreYouClaimingGiftAidPage.verifyPageHeader(AreYouClaimingGiftAidPage.pageHeader)
      And("User clicks 'Yes' radio button option")
      AreYouClaimingGiftAidPage.radioButton(AreYouClaimingGiftAidPage.yes)
      And("User clicks 'Continue' button")
      AreYouClaimingGiftAidPage.clickSubmitButton()
      And("User navigates to 'Are you claiming UK tax deducted from other income?' page")
      AreYouClaimingTaxDeductedFromOtherIncomePage.verifyPageTitle(AreYouClaimingTaxDeductedFromOtherIncomePage.pageTitle)
      AreYouClaimingTaxDeductedFromOtherIncomePage.verifyPageHeader(AreYouClaimingTaxDeductedFromOtherIncomePage.pageHeader)
      And("User clicks 'Yes' radio button option")
      AreYouClaimingTaxDeductedFromOtherIncomePage.radioButton(AreYouClaimingTaxDeductedFromOtherIncomePage.yes)
      And("User clicks 'Continue' button")
      AreYouClaimingTaxDeductedFromOtherIncomePage.clickSubmitButton()
      And("User navigates to 'Gift Aid Small Donations Scheme' page")
      GiftAidSmallDonationsSchemePage.verifyPageTitle(GiftAidSmallDonationsSchemePage.pageTitle)
      GiftAidSmallDonationsSchemePage.verifyPageHeader(GiftAidSmallDonationsSchemePage.pageHeader)
      And("User clicks 'Yes' radio button option")
      GiftAidSmallDonationsSchemePage.radioButton(GiftAidSmallDonationsSchemePage.yes)
      And("User clicks 'Continue' button")
      GiftAidSmallDonationsSchemePage.clickSubmitButton()
      And("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.verifyPageTitle(DoYouHaveAClaimReferenceNumberPage.pageTitle)
      DoYouHaveAClaimReferenceNumberPage.verifyPageHeader(DoYouHaveAClaimReferenceNumberPage.pageHeader)
      And("User clicks 'Yes' radio button option")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.yes)
      And("User clicks 'Continue' button")
      DoYouHaveAClaimReferenceNumberPage.clickSubmitButton()
      And("User navigates to 'Your claim reference number?' page")
      YourClaimReferenceNumberPage.verifyPageTitle(YourClaimReferenceNumberPage.pageTitle)
      YourClaimReferenceNumberPage.verifyPageHeader(YourClaimReferenceNumberPage.pageHeader)
      And("User enters their claim reference number")
      YourClaimReferenceNumberPage.enterClaimReferenceNumber("SOME VALUE HERE")
      //uppercase + 'x', '\' and numbers up to 20 chars ('X' / 'EW' for Eng + Wales, 'CR' scotland, 'CH' ireland)
      And("User clicks 'Continue' button")
      YourClaimReferenceNumberPage.clickSubmitButton()
      And("User navigates to 'Declaration' page")
      DeclarationPage.verifyPageTitle(DeclarationPage.pageTitle)
      DeclarationPage.verifyPageHeader(DeclarationPage.pageHeader)
      And("User clicks 'Continue' button")
      DeclarationPage.clickSubmitButton()
      And("User navigates to 'Check your answers' page")
      CheckYourAnswersPage.verifyPageTitle(CheckYourAnswersPage.pageTitle)
      CheckYourAnswersPage.verifyPageHeader(CheckYourAnswersPage.pageHeader)
    }
  }
}
