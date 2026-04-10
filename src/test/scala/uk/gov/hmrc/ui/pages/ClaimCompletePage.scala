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

object ClaimCompletePage extends BasePage {

  override def pageUrl: String = s"$hostname/claim-complete"

  override def pageTitle: String =
    "Claim complete - Charities - GOV.UK"

  def pagePanelHeading: String =
    "Claim complete"

  def pagePanelParagraph: String =
    "Your reference number"

  def pageSubHeading: String =
    "What happens next"

  def txtParagraph1: String =
    "We’ve sent your charity repayment claim to HMRC."

  def txtParagraph2: String =
    "They will contact you to confirm your repayment, or to ask for more information."

  def txtPrintClaimSummaryLink: String = 
    "Print a summary of your claim"

  val lnkPrintClaimSummaryLink: By      = By.xpath("//a[@href='/charities-claims/charity-repayment-claim-summary']")

  def clickPrintClaimSummaryLink(): Unit = {
    val element = waitForElementToBeClickable(lnkPrintClaimSummaryLink)
    element.click()
  }

  def validateNavigation(): Unit = {
    ClaimCompletePage.verifyPageUrl(ClaimCompletePage.pageUrl)
    ClaimCompletePage.verifyPageTitle(ClaimCompletePage.pageTitle)
    ClaimCompletePage.verifyPageHeading(ClaimCompletePage.pagePanelHeading)
    ClaimCompletePage.verifyPageSubHeading1(ClaimCompletePage.pageSubHeading)
  }

  def validatePageContent(): Unit = {
    ClaimCompletePage.verifyPageSubHeading1(ClaimCompletePage.pageSubHeading)
    ClaimCompletePage.verifyPageContentBelowPanel1(ClaimCompletePage.txtParagraph1)
    ClaimCompletePage.verifyPageContentBelowPanel2(ClaimCompletePage.txtParagraph2)
    ClaimCompletePage.verifyPageContentBelowPanel3(ClaimCompletePage.txtPrintClaimSummaryLink)
  }
}
