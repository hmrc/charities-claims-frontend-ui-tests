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

object CharityRepaymentClaimSummary extends BasePage {

  val GiftAidDetails: By  = By.xpath("//h1[normalize-space(text())='Gift Aid details']")
  val OtherIncomeDetails: By  = By.xpath("//h1[normalize-space(text())='Other Income details']")
  val AdjustmentDetails: By  = By.xpath("//h1[normalize-space(text())='Adjustment for overclaimed tax relief details']")

  override def pageUrl: String = s"$hostname/charity-repayment-claim-summary"

  override def pageTitle: String =
    "Charity repayment claim summary - Charities - GOV.UK"

  def verifyGiftAidDetailsH2(expectedSubHeading: String): Unit = {
    waitForVisibilityOfElement(GiftAidDetails)
    val actualSubHeading = driver.findElement(GiftAidDetails).getText
    assert(
      actualSubHeading == expectedSubHeading,
      s"Page sub-heading mismatch! Expected: $expectedSubHeading, Actual: $actualSubHeading"
    )
    println("Actual page sub-heading is: " + driver.findElement(GiftAidDetails).getText)
  }

  def verifyOtherIncomeDetailsH2(expectedSubHeading: String): Unit = {
    waitForVisibilityOfElement(OtherIncomeDetails)
    val actualSubHeading = driver.findElement(OtherIncomeDetails).getText
    assert(
      actualSubHeading == expectedSubHeading,
      s"Page sub-heading mismatch! Expected: $expectedSubHeading, Actual: $actualSubHeading"
    )
    println("Actual page sub-heading is: " + driver.findElement(OtherIncomeDetails).getText)
  }

  def verifyAdjustmentDetailsH2(expectedSubHeading: String): Unit = {
    waitForVisibilityOfElement(AdjustmentDetails)
    val actualSubHeading = driver.findElement(AdjustmentDetails).getText
    assert(
      actualSubHeading == expectedSubHeading,
      s"Page sub-heading mismatch! Expected: $expectedSubHeading, Actual: $actualSubHeading"
    )
    println("Actual page sub-heading is: " + driver.findElement(AdjustmentDetails).getText)
  }
  
  def pageHeading: String =
    "Charity repayment claim summary"

  def pageHeading2: String =
    "Claim details"

  def pageHeadingGiftAidDetails: String =
    "Gift Aid details"

  def validateNavigation(): Unit = {
    CharityRepaymentClaimSummary.verifyPageUrl(CharityRepaymentClaimSummary.pageUrl)
    CharityRepaymentClaimSummary.verifyPageTitle(CharityRepaymentClaimSummary.pageTitle)
    CharityRepaymentClaimSummary.verifyPageHeading(CharityRepaymentClaimSummary.pageHeading)
    CharityRepaymentClaimSummary.verifyPageSubHeading1(CharityRepaymentClaimSummary.pageHeading2)
  }

}
