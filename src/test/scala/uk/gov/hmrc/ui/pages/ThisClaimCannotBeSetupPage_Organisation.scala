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

object ThisClaimCannotBeSetupPage_Organisation extends BasePage {

  override def pageUrl: String = s"$hostname/cannot-set-up-organisation-details"

  override def pageTitle: String =
    "This claim cannot be setup - Charities - GOV.UK"

  def pageHeader: String =
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

  def textConfirmRegulatorName: String =
    "confirm your charity regulator name"

  def textConfirmIfCorporateTrustee : String =
    "confirm if you are a corporate trustee"

  def validateNavigation(): Unit = {
    ThisClaimCannotBeSetupPage_Organisation.verifyPageUrl(ThisClaimCannotBeSetupPage_Organisation.pageUrl)
    ThisClaimCannotBeSetupPage_Organisation.verifyPageTitle(ThisClaimCannotBeSetupPage_Organisation.pageTitle)
    ThisClaimCannotBeSetupPage_Organisation.verifyPageHeader(ThisClaimCannotBeSetupPage_Organisation.pageHeader)
  }

  def validatePageContent(): Unit =
    ThisClaimCannotBeSetupPage_Organisation.verifyEntirePageContent(
      ThisClaimCannotBeSetupPage_Organisation.createSingleStringFromMany(
        ThisClaimCannotBeSetupPage_Organisation.pageHeader,
        ThisClaimCannotBeSetupPage_Organisation.pageWarningIcon,
        ThisClaimCannotBeSetupPage_Organisation.pageWarningHeading,
        ThisClaimCannotBeSetupPage_Organisation.pageWarningText,
        ThisClaimCannotBeSetupPage_Organisation.textParagraph1,
        ThisClaimCannotBeSetupPage_Organisation.textConfirmRegulatorName,
        ThisClaimCannotBeSetupPage_Organisation.textConfirmIfCorporateTrustee,
        ThisClaimCannotBeSetupPage_Organisation.linkGoBackToProvideMissingInfo
      )
    )
}
