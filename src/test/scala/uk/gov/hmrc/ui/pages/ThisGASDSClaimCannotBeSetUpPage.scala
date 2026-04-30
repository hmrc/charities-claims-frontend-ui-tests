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

object ThisGASDSClaimCannotBeSetUpPage extends BasePage {

  override def pageUrl: String = s"$hostname/cannot-set-up-gasds-claim"

  override def pageTitle: String = "This claim cannot be set up - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String = "This claim cannot be set up"

  def pageWarningIcon: String =
    "!"

  def pageWarningHeading: String =
    "Warning"

  def pageWarningText: String =
    "This claim cannot be setup because some details are missing."

  def textParagraph1: String =
    "You need to provide the following details to continue:"

  def textGoBackToProvideMissingInfo: String =
    "Go back to provide the missing details for your claim"

  def textConfirmAmountOfGASDSOverclaimed: String =
    "confirm the amount of GASDS previously overclaimed "

  def textConfirmNumberOfTaxYears: String =
    "confirm the number of tax years you are claiming for"

  def textConfirmTheDonationAmount1: String =
    "confirm the donation amount you are claiming for tax year 1"

  def textConfirmTheDonationAmount2: String =
    "confirm the donation amount you are claiming for tax year 2"

  def textConfirmTheDonationAmount3: String =
    "confirm the donation amount you are claiming for tax year 3"

  def validateNavigation(): Unit = {
    ThisGASDSClaimCannotBeSetUpPage.verifyPageUrl(ThisGASDSClaimCannotBeSetUpPage.pageUrl)
    ThisGASDSClaimCannotBeSetUpPage.verifyPageTitle(ThisGASDSClaimCannotBeSetUpPage.pageTitle)
    ThisGASDSClaimCannotBeSetUpPage.verifyPageHeading(ThisGASDSClaimCannotBeSetUpPage.pageHeading)
  }

  def validatePageContent(): Unit =
    ThisGASDSClaimCannotBeSetUpPage.verifyEntirePageContent(
      ThisGASDSClaimCannotBeSetUpPage.createSingleStringFromMany(
        ThisGASDSClaimCannotBeSetUpPage.pageHeading,
        ThisGASDSClaimCannotBeSetUpPage.pageWarningIcon,
        ThisGASDSClaimCannotBeSetUpPage.pageWarningHeading,
        ThisGASDSClaimCannotBeSetUpPage.pageWarningText,
        ThisGASDSClaimCannotBeSetUpPage.textParagraph1,
        ThisGASDSClaimCannotBeSetUpPage.textConfirmAmountOfGASDSOverclaimed,
        ThisGASDSClaimCannotBeSetUpPage.textGoBackToProvideMissingInfo
      )
    )

}