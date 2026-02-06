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
    "Check your repayment claim - Charities - GOV.UK"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageHeader: String =
    "Check your repayment claim"

  def validateNavigation(): Unit = {
    CheckYourRepaymentClaimPage.verifyPageUrl(CheckYourRepaymentClaimPage.pageUrl)
    CheckYourRepaymentClaimPage.verifyPageTitle(CheckYourRepaymentClaimPage.pageTitle)
    CheckYourRepaymentClaimPage.verifyPageCaption(CheckYourRepaymentClaimPage.pageCaption)
    CheckYourRepaymentClaimPage.verifyPageHeader(CheckYourRepaymentClaimPage.pageHeader)
  }

  val linkChangeRepaymentClaimType: By = By.xpath("//a[@href='/charities-claims/change-repayment-claim-type']")
  val linkChangeClaimReference: By     = By.xpath("//a[@href='/charities-claims/change-claim-reference-number']")
  val linkChangeReferenceNumber: By    = By.xpath("//a[@href='/charities-claims/change-enter-claim-reference-number']")
  val linkChangeGasdsPayment: By       = By.xpath("//a[@href='/charities-claims/change-claim-gasds-payment']")
  val linkChangeBuilding: By           =
    By.xpath("//a[@href='/charities-claims/change-claim-community-building-donations']")
  val linkChangeChangeGasds: By        =
    By.xpath("//a[@href='/charities-claims/change-change-previous-gasds-claim']")
  val linkChangeConnectedCharities: By =
    By.xpath("//a[@href='/charities-claims/change-connected-to-charities']")

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

  def clickChangeGasdsPayment(): Unit = {
    val element = waitForElementToBeClickable(linkChangeGasdsPayment)
    element.click()
  }

  def clickChangeBuilding(): Unit = {
    val element = waitForElementToBeClickable(linkChangeBuilding)
    element.click()
  }

  def clickChangeChangeGasds(): Unit = {
    val element = waitForElementToBeClickable(linkChangeChangeGasds)
    element.click()
  }

  def clickChangeConnectedCharities(): Unit = {
    val element = waitForElementToBeClickable(linkChangeConnectedCharities)
    element.click()
  }

}
