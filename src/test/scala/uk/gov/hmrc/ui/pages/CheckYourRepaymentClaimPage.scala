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

  def pageTitleAgent: String =
    "Check repayment claim details - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageCaptionAgent: String =
    "Provide charity repayment claim details"

  def pageHeading: String =
    "Check your repayment claim"

  def pageHeadingAgent: String =
    "Check repayment claim details"

  def pageSubheadingCharityDetailsAgent: String =
    "Charity details"

  def pageSubheadingClaimDetailsAgent: String =
    "Claim details"

  def charityNameAgent: String =
    "Charity name"

  def charitiesReferenceAgent: String =
    "HMRC Charities reference"

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

  def validateNavigationAgent(): Unit = {
    CheckYourRepaymentClaimPage.verifyPageUrl(CheckYourRepaymentClaimPage.pageUrl)
    CheckYourRepaymentClaimPage.verifyPageTitle(CheckYourRepaymentClaimPage.pageTitleAgent)
    CheckYourRepaymentClaimPage.verifyPageCaption(CheckYourRepaymentClaimPage.pageCaptionAgent)
    CheckYourRepaymentClaimPage.verifyPageHeading(CheckYourRepaymentClaimPage.pageHeadingAgent)
  }

  val CharityDetailsAgent: By = By.xpath("//h2[normalize-space(text())='Charity details']")
  val ClaimDetailsAgent: By   = By.xpath("//h2[normalize-space(text())='Claim details']")

  val linkChangeRepaymentClaimType: By   = By.xpath("//a[@href='/charities-claims/change-select-repayment-claim-type']")
  val linkChangeClaimReference: By       = By.xpath("//a[@href='/charities-claims/change-claim-reference-number-check']")
  val linkChangeReferenceNumber: By      = By.xpath("//a[@href='/charities-claims/change-enter-claim-reference-number']")
  val linkChangeGASDSClaimType: By       =
    By.xpath("//a[@href='/charities-claims/change-select-gift-aid-small-donations-scheme-claim-type']")
  val linkChangeGASDSAdjustment: By      =
    By.xpath("//a[@href='/charities-claims/change-change-previous-gift-aid-small-donations-scheme-claim']")
  val linkChangeCharityName: By          =
    By.xpath("//a[@href='/charities-claims/change-enter-the-charity-name']")
  val linkChangeHMRCCharityReference: By =
    By.xpath("//a[@href='/charities-claims/change-enter-charities-reference-number']")

  def clickChangeCharityName(): Unit = {
    val element = waitForElementToBeClickable(linkChangeCharityName)
    element.click()
  }

  def clickChangeHMRCCharityReference(): Unit = {
    val element = waitForElementToBeClickable(linkChangeHMRCCharityReference)
    element.click()
  }

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

  def verifyCharityDetailsH2Agent(expectedSubHeading: String): Unit = {
    waitForVisibilityOfElement(CharityDetailsAgent)
    val actualSubHeading = driver.findElement(CharityDetailsAgent).getText
    assert(
      actualSubHeading == expectedSubHeading,
      s"Page sub-heading mismatch! Expected: $expectedSubHeading, Actual: $actualSubHeading"
    )
    println("Actual page sub-heading is: " + driver.findElement(CharityDetailsAgent).getText)
  }

  def verifyClaimDetailsH2Agent(expectedSubHeading: String): Unit = {
    waitForVisibilityOfElement(ClaimDetailsAgent)
    val actualSubHeading = driver.findElement(ClaimDetailsAgent).getText
    assert(
      actualSubHeading == expectedSubHeading,
      s"Page sub-heading mismatch! Expected: $expectedSubHeading, Actual: $actualSubHeading"
    )
    println("Actual page sub-heading is: " + driver.findElement(ClaimDetailsAgent).getText)
  }

}
