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

object CheckYourRepaymentClaimPage extends BasePage {

  override def pageUrl: String = s"$hostname/check-your-repayment-claim"

  override def pageTitle: String =
    "Check your repayment claim - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageHeading: String =
    "Check your repayment claim"

  def repaymentClaimType: String =
    "Repayment claim type"

  def claimReferenceProvided: String =
    "Claim reference provided"

  def claimReferenceNumber: String =
    "Claim reference number"

  def GASDSClaimType: String =
    "GASDS claim type"

  def GASDSAdjustment: String =
    "GASDS adjustment"

  def validateNavigation(): Unit = {
    CheckYourRepaymentClaimPage.verifyPageUrl(CheckYourRepaymentClaimPage.pageUrl)
    CheckYourRepaymentClaimPage.verifyPageTitle(CheckYourRepaymentClaimPage.pageTitle)
    CheckYourRepaymentClaimPage.verifyPageCaption(CheckYourRepaymentClaimPage.pageCaption)
    CheckYourRepaymentClaimPage.verifyPageHeading(CheckYourRepaymentClaimPage.pageHeading)
  }

  val linkChangeRepaymentClaimType: By = By.xpath("//a[@href='/charities-claims/change-select-repayment-claim-type']")
  val linkChangeClaimReference: By     = By.xpath("//a[@href='/charities-claims/change-claim-reference-number-check']")
  val linkChangeReferenceNumber: By    = By.xpath("//a[@href='/charities-claims/change-enter-claim-reference-number']")
  val linkChangeGASDSClaimType: By     =
    By.xpath("//a[@href='/charities-claims/change-select-gift-aid-small-donations-scheme-claim-type']")
  val linkChangeGASDSAdjustment: By    =
    By.xpath("//a[@href='/charities-claims/change-change-previous-gift-aid-small-donations-scheme-claim']")

  def clickChangeRepaymentClaimType(): Unit = {
    val element = waitForElementToBeClickable(linkChangeRepaymentClaimType)
    element.click()
  }

  def clickChangeClaimReference(): Unit = {
    val element = waitForElementToBeClickable(linkChangeClaimReference)
    element.click()
  }

  def clickChangeReferenceNumber(): Unit = {
    val element = waitForElementToBeClickable(linkChangeReferenceNumber)
    element.click()
  }

  def clickChangeGASDSClaimType(): Unit = {
    val element = waitForElementToBeClickable(linkChangeGASDSClaimType)
    element.click()
  }

  def clickChangeGASDSAdjustment(): Unit = {
    val element = waitForElementToBeClickable(linkChangeGASDSAdjustment)
    element.click()
  }

}
