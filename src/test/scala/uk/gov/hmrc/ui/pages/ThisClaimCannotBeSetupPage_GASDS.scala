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

object ThisClaimCannotBeSetupPage_GASDS extends BasePage {

  override def pageUrl: String = s"$hostname/cannot-set-up-gasds-claim"

  override def pageTitle: String =
    "This claim cannot be setup - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "This claim cannot be setup"

  def pageWarningIcon: String =
    "!"

  def pageWarningHeading: String =
    "Warning"

  def pageWarningText: String =
    "This claim cannot be setup because some details are missing."

  def textParagraph1: String =
    "You need to provide the following details to continue:"

  def linkGoBackToProvideMissingInfo: String =
    "Go back to provide the missing details for your claim"

  def textConfirmAmountOfGASDSOverclaimed: String =
    "confirm the amount of GASDS previously overclaimed"

  def textConfirmGASDSDonationAmountTaxYear1: String =
    "confirm the donation amount you are claiming for tax year 1"

  def textConfirmGASDSDonationAmountTaxYear2: String =
    "confirm the donation amount you are claiming for tax year 2"

  def textConfirmGASDSDonationAmountTaxYear3: String =
    "confirm the donation amount you are claiming for tax year 3"

  def validateNavigation(): Unit = {
    ThisClaimCannotBeSetupPage_GASDS.verifyPageUrl(ThisClaimCannotBeSetupPage_GASDS.pageUrl)
    ThisClaimCannotBeSetupPage_GASDS.verifyPageTitle(ThisClaimCannotBeSetupPage_GASDS.pageTitle)
    ThisClaimCannotBeSetupPage_GASDS.verifyPageHeading(ThisClaimCannotBeSetupPage_GASDS.pageHeading)
  }

  def validatePageContent(): Unit =
    ThisClaimCannotBeSetupPage_GASDS.verifyEntirePageContent(
      ThisClaimCannotBeSetupPage_GASDS.createSingleStringFromMany(
        ThisClaimCannotBeSetupPage_GASDS.pageHeading,
        ThisClaimCannotBeSetupPage_GASDS.pageWarningIcon,
        ThisClaimCannotBeSetupPage_GASDS.pageWarningHeading,
        ThisClaimCannotBeSetupPage_GASDS.pageWarningText,
        ThisClaimCannotBeSetupPage_GASDS.textParagraph1,
        ThisClaimCannotBeSetupPage_GASDS.textConfirmGASDSDonationAmountTaxYear3,
        ThisClaimCannotBeSetupPage_GASDS.linkGoBackToProvideMissingInfo
      )
    )
}
