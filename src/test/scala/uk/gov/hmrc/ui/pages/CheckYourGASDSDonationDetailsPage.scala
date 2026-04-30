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

package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object CheckYourGASDSDonationDetailsPage extends BasePage {

  override def pageUrl: String = s"$hostname/check-your-gift-aid-small-donations-scheme-donation-details"

  override def pageTitle: String =
    "Check your GASDS donation details - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide GASDS donation details"

  def pageHeading: String =
    "Check your GASDS donation details"

  def pageHeadingGASDSAdjustment: String =
    "GASDS claim adjustment"

  def pageHeadingGASDSClaimTax: String =
    "GASDS claims"

  val linkAdjustmentAmount: By    =
    By.xpath("//a[@href='/charities-claims/change-check-gift-aid-small-donations-scheme-adjustment-amount']")
  val linkGASDSTaxYears: By       = By.xpath("//a[@href='/charities-claims/claim-added-for-tax-year']")
  val GASDSAdjustmentAmountH2: By = By.xpath("//h2[normalize-space(text())='GASDS claim adjustment']")
  val GASDSClaimsH2: By           = By.xpath("//h2[normalize-space(text())='GASDS claims']")

  def clickChangeGASDSAdjustmentAmount(): Unit = {
    val element = waitForElementToBeClickable(linkAdjustmentAmount)
    element.click()
  }

  def clickChangeGASDSTaxYears(): Unit = {
    val element = waitForElementToBeClickable(linkGASDSTaxYears)
    element.click()
  }

  def validateNavigation(): Unit                                = {
    CheckYourGASDSDonationDetailsPage.verifyPageUrl(CheckYourGASDSDonationDetailsPage.pageUrl)
    CheckYourGASDSDonationDetailsPage.verifyPageTitle(CheckYourGASDSDonationDetailsPage.pageTitle)
    CheckYourGASDSDonationDetailsPage.verifyPageCaption(CheckYourGASDSDonationDetailsPage.pageCaption)
    CheckYourGASDSDonationDetailsPage.verifyPageHeading(CheckYourGASDSDonationDetailsPage.pageHeading)
  }
  def verifyGASDSAdjustmentH2(expectedSubHeading: String): Unit = {
    waitForVisibilityOfElement(GASDSAdjustmentAmountH2)
    val actualSubHeading = driver.findElement(GASDSAdjustmentAmountH2).getText
    assert(
      actualSubHeading == expectedSubHeading,
      s"Page sub-heading mismatch! Expected: $expectedSubHeading, Actual: $actualSubHeading"
    )
    println("Actual page sub-heading is: " + driver.findElement(GASDSAdjustmentAmountH2).getText)
  }

  def verifyGASDSClaimsH2(expectedSubHeading: String): Unit = {
    waitForVisibilityOfElement(GASDSClaimsH2)
    val actualSubHeading = driver.findElement(GASDSClaimsH2).getText
    assert(
      actualSubHeading == expectedSubHeading,
      s"Page sub-heading mismatch! Expected: $expectedSubHeading, Actual: $actualSubHeading"
    )
    println("Actual page sub-heading is: " + driver.findElement(GASDSClaimsH2).getText)
  }

  def validateGASDSAdjustmentHeading(): Unit =
    CheckYourGASDSDonationDetailsPage.verifyGASDSAdjustmentH2(
      CheckYourGASDSDonationDetailsPage.pageHeadingGASDSAdjustment
    )

  def validateGASDSClaimTaxHeading(): Unit =
    CheckYourGASDSDonationDetailsPage.verifyGASDSClaimsH2(
      CheckYourGASDSDonationDetailsPage.pageHeadingGASDSClaimTax
    )

}
