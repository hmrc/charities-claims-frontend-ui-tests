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

object CharityRepaymentClaimSummaryPage extends BasePage {

  val GiftAidDetails: By            = By.xpath("//h2[normalize-space(text())='Gift Aid details']")
  val OtherIncomeDetails: By        = By.xpath("//h2[normalize-space(text())='Other Income details']")
  val AdjustmentDetails: By         = By.xpath("//h2[normalize-space(text())='Adjustment for overclaimed tax relief details']")
  val GASDSDetails: By              = By.xpath("//h2[normalize-space(text())='Gift Aid Small Donations Scheme (GASDS)']")
  val SubmissionReferenceNumber: By =
    By.xpath("//dt[normalize-space(text())='Submission receipt reference number']/following-sibling::dd[1]")
  val linkPrintSummary: By          = By.xpath("//a[@data-module='hmrc-print-link']")
  val linkLogOutHMRC: By            = By.xpath("//a[@href and contains(text(),'Log out and go back')]")
  val linkGoToYourHMRCServices: By  = By.xpath("//a[@href and contains(text(),'Go to Your HMRC services')]")

  override def pageUrl: String = s"$hostname/charity-repayment-claim-summary"

  override def pageTitle: String =
    "Charity repayment claim summary - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "Charity repayment claim summary"

  def pageHeading2: String =
    "Claim details"

  def pageHeadingGiftAidDetails: String =
    "Gift Aid details"

  def pageHeadingOtherIncomeDetails: String =
    "Other Income details"

  def pageHeadingGASDSDetails: String =
    "Gift Aid Small Donations Scheme (GASDS)"

  def pageHeadingAdjustmentDetails: String =
    "Adjustment for overclaimed tax relief details"

  def printSummaryLink: String =
    "Print summary"

  def logOutAndGoBackLink: String =
    "Log out and go back HMRC online services"

  def goToYourHMRCServicesLink: String =
    "Go to Your HMRC services"

  def verifyGiftAidDetailsH2(expectedSubHeading: String): Unit = {
    waitForVisibilityOfElement(GiftAidDetails)
    val actualSubHeading = driver.findElement(GiftAidDetails).getText
    assert(
      actualSubHeading == expectedSubHeading,
      s"Page sub-heading mismatch! Expected: $expectedSubHeading, Actual: $actualSubHeading"
    )
    logger.info("Actual page sub-heading is: " + driver.findElement(GiftAidDetails).getText)
  }

  def verifyOtherIncomeDetailsH2(expectedSubHeading: String): Unit = {
    waitForVisibilityOfElement(OtherIncomeDetails)
    val actualSubHeading = driver.findElement(OtherIncomeDetails).getText
    assert(
      actualSubHeading == expectedSubHeading,
      s"Page sub-heading mismatch! Expected: $expectedSubHeading, Actual: $actualSubHeading"
    )
    logger.info("Actual page sub-heading is: " + driver.findElement(OtherIncomeDetails).getText)
  }

  def verifyGASDSDetailsH2(expectedSubHeading: String): Unit = {
    waitForVisibilityOfElement(GASDSDetails)
    val actualSubHeading = driver.findElement(GASDSDetails).getText
    assert(
      actualSubHeading == expectedSubHeading,
      s"Page sub-heading mismatch! Expected: $expectedSubHeading, Actual: $actualSubHeading"
    )
    logger.info("Actual page sub-heading is: " + driver.findElement(GASDSDetails).getText)
  }

  def verifyAdjustmentDetailsH2(expectedSubHeading: String): Unit = {
    waitForVisibilityOfElement(AdjustmentDetails)
    val actualSubHeading = driver.findElement(AdjustmentDetails).getText
    assert(
      actualSubHeading == expectedSubHeading,
      s"Page sub-heading mismatch! Expected: $expectedSubHeading, Actual: $actualSubHeading"
    )
    logger.info("Actual page sub-heading is: " + driver.findElement(AdjustmentDetails).getText)
  }

  def verifySubmissionReferenceBase32(): Unit = {
    waitForVisibilityOfElement(SubmissionReferenceNumber)
    val actualReference = driver.findElement(SubmissionReferenceNumber).getText.trim
    val isValid         = isUpperCaseBase32Unpadded(actualReference)

    if (isValid) {
      logger.info(s"[PASS] Valid Base32: $actualReference")
    } else {
      logger.info(s"[FAIL] Invalid Base32: $actualReference")
    }

    assert(isValid, s"Expected Base32 but got: $actualReference")
  }

  def validateNavigation(): Unit = {
    CharityRepaymentClaimSummaryPage.verifyPageUrl(CharityRepaymentClaimSummaryPage.pageUrl)
    CharityRepaymentClaimSummaryPage.verifyPageTitle(CharityRepaymentClaimSummaryPage.pageTitle)
    CharityRepaymentClaimSummaryPage.verifyPageHeading(CharityRepaymentClaimSummaryPage.pageHeading)
    CharityRepaymentClaimSummaryPage.verifyPageSubHeading1(CharityRepaymentClaimSummaryPage.pageHeading2)
  }

  def validateGiftAidHeading(): Unit =
    CharityRepaymentClaimSummaryPage.verifyGiftAidDetailsH2(CharityRepaymentClaimSummaryPage.pageHeadingGiftAidDetails)

  def validateOtherIncomeHeading(): Unit =
    CharityRepaymentClaimSummaryPage.verifyOtherIncomeDetailsH2(
      CharityRepaymentClaimSummaryPage.pageHeadingOtherIncomeDetails
    )

  def validateGASDSHeading(): Unit =
    CharityRepaymentClaimSummaryPage.verifyGASDSDetailsH2(CharityRepaymentClaimSummaryPage.pageHeadingGASDSDetails)

  def validateAdjustmentHeading(): Unit =
    CharityRepaymentClaimSummaryPage.verifyAdjustmentDetailsH2(
      CharityRepaymentClaimSummaryPage.pageHeadingAdjustmentDetails
    )

  def validatePrintSummaryLink(expectedLink: String): Unit =
    waitForVisibilityOfElement(linkPrintSummary)
    val actualLinkText = driver.findElement(linkPrintSummary).getText.trim
    assert(
      actualLinkText == expectedLink,
      s"Page Link mismatch! Expected: $expectedLink, Actual: $actualLinkText"
    )
    logger.info("Actual page Link is: " + driver.findElement(linkPrintSummary).getText.trim)

  def validateLogOutAndGoBackLink(expectedLink: String): Unit =
    waitForVisibilityOfElement(linkLogOutHMRC)
    val actualLinkText = driver.findElement(linkLogOutHMRC).getText.trim
    assert(
      actualLinkText == expectedLink,
      s"Page Link mismatch! Expected: $expectedLink, Actual: $actualLinkText"
    )
    logger.info("Actual page Link is: " + driver.findElement(linkLogOutHMRC).getText.trim)

  def validateGoToYourHMRCServicesLink(expectedLink: String): Unit =
    waitForVisibilityOfElement(linkGoToYourHMRCServices)
    val actualLinkText = driver.findElement(linkGoToYourHMRCServices).getText.trim
    assert(
      actualLinkText == expectedLink,
      s"Page Link mismatch! Expected: $expectedLink, Actual: $actualLinkText"
    )
    logger.info("Actual page Link is: " + driver.findElement(linkGoToYourHMRCServices).getText.trim)

  def validateSummaryPageLinks(): Unit = {
    CharityRepaymentClaimSummaryPage.validatePrintSummaryLink(CharityRepaymentClaimSummaryPage.printSummaryLink)
    CharityRepaymentClaimSummaryPage.validateLogOutAndGoBackLink(CharityRepaymentClaimSummaryPage.logOutAndGoBackLink)
    CharityRepaymentClaimSummaryPage.validateGoToYourHMRCServicesLink(
      CharityRepaymentClaimSummaryPage.goToYourHMRCServicesLink
    )
  }

}
