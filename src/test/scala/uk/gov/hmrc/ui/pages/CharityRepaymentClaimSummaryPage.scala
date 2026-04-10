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

object CharityRepaymentClaimSummaryPage extends BasePage {

  override def pageUrl: String = s"$hostname/charity-repayment-claim-summary"

  override def pageTitle: String =
    "Charity repayment claim summary - Charities - GOV.UK"

  def pageHeading: String =
    "Charity repayment claim summary"

  def validateNavigation(): Unit = {
    CharityRepaymentClaimSummaryPage.verifyPageUrl(CharityRepaymentClaimSummaryPage.pageUrl)
    CharityRepaymentClaimSummaryPage.verifyPageTitle(CharityRepaymentClaimSummaryPage.pageTitle)
    CharityRepaymentClaimSummaryPage.verifyPageHeading(CharityRepaymentClaimSummaryPage.pageHeading)
  }
}
