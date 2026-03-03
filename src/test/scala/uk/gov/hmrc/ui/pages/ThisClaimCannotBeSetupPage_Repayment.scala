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

object ThisClaimCannotBeSetupPage_Repayment extends BasePage {

  override def pageUrl: String = s"$hostname/cannot-set-up-repayment-claim"

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

  def textConfirmTopUpPaymentUnderGASDS: String =
    "confirm if you are claiming a top-up payment under the Gift Aid Small Donations Scheme"

  def textConfirmDonationsCollectedInCommunityBuildings: String =
    "confirm if you are claiming for donations collected in community buildings"

  def textConfirmChangingPreviousGASDSClaim: String =
    "confirm if you want to change a previous Gift Aid Small Donations Scheme claim"

  def textConfirmIfConnectedToOtherCharitiesOrCASC: String =
    "confirm if you are connected to other charities or a Community Amateur Sports Club"

  def textConfirmIfYouHaveAClaimRefNo: String =
    "provide a claim reference number"

  def validateNavigation(): Unit = {
    ThisClaimCannotBeSetupPage_Repayment.verifyPageUrl(ThisClaimCannotBeSetupPage_Repayment.pageUrl)
    ThisClaimCannotBeSetupPage_Repayment.verifyPageTitle(ThisClaimCannotBeSetupPage_Repayment.pageTitle)
    ThisClaimCannotBeSetupPage_Repayment.verifyPageHeader(ThisClaimCannotBeSetupPage_Repayment.pageHeader)
  }

  def validatePageContent(): Unit =
    ThisClaimCannotBeSetupPage_Repayment.verifyEntirePageContent(
      ThisClaimCannotBeSetupPage_Repayment.createSingleStringFromMany(
        ThisClaimCannotBeSetupPage_Repayment.pageHeader,
        ThisClaimCannotBeSetupPage_Repayment.pageWarningIcon,
        ThisClaimCannotBeSetupPage_Repayment.pageWarningHeading,
        ThisClaimCannotBeSetupPage_Repayment.pageWarningText,
        ThisClaimCannotBeSetupPage_Repayment.textParagraph1,
        ThisClaimCannotBeSetupPage_Repayment.textConfirmTopUpPaymentUnderGASDS,
        ThisClaimCannotBeSetupPage_Repayment.textConfirmDonationsCollectedInCommunityBuildings,
        ThisClaimCannotBeSetupPage_Repayment.textConfirmIfConnectedToOtherCharitiesOrCASC,
        ThisClaimCannotBeSetupPage_Repayment.linkGoBackToProvideMissingInfo
      )
    )
}
