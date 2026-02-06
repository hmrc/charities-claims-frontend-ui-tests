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

package uk.gov.hmrc.ui.pages

object ThisClaimCannotBeSetupPage_Repayment extends BasePage {

  override def pageUrl: String = s"$hostname/cannot-set-up-repayment-claim"

  override def pageTitle: String =
    "This claim cannot be setup - Charities - GOV.UK"

  def pageHeader: String =
    "This claim cannot be setup"

  def pageWarning: String =
    "This claim cannot be setup because some details are missing."

  def listItem1: String =
    "You need to provide information about the organisation you are claiming for."

  def listItem2: String =
    "The person making this claim must be an approved official or corporate trustee recognised by HM Revenue Customs."

  def listItem3: String =
    "Continue"

  def validateNavigation(): Unit = {
    ThisClaimCannotBeSetupPage_Repayment.verifyPageUrl(ThisClaimCannotBeSetupPage_Repayment.pageUrl)
    ThisClaimCannotBeSetupPage_Repayment.verifyPageTitle(ThisClaimCannotBeSetupPage_Repayment.pageTitle)
    ThisClaimCannotBeSetupPage_Repayment.verifyPageHeader(ThisClaimCannotBeSetupPage_Repayment.pageHeader)
  }

  def validatePageContent(): Unit =
    ThisClaimCannotBeSetupPage_Repayment.verifyEntirePageContent(
      ThisClaimCannotBeSetupPage_Repayment.createSingleStringFromMany(
        ThisClaimCannotBeSetupPage_Repayment.pageHeader,
        ThisClaimCannotBeSetupPage_Repayment.pageWarning,
        ThisClaimCannotBeSetupPage_Repayment.listItem1,
        ThisClaimCannotBeSetupPage_Repayment.listItem2,
        ThisClaimCannotBeSetupPage_Repayment.listItem3
      )
    )
}
