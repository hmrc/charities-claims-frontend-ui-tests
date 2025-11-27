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

import uk.gov.hmrc.ui.pages.AuthWizard
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

object AreYouClaimingTaxDeductedFromOtherIncomePage extends BasePage {

  val hostname: String         = AuthWizard.buildRedirectUrl(HASDIRECT, Organisation)
  override def pageUrl: String = s"$hostname/claiming-other-income"

//  override def pageUrl: String = "http://localhost:8030/charities-claims/claiming-other-income"

  override def pageTitle: String =
    "Are you claiming tax deducted from other income? - Charities - GOV.UK"

  def pageHeader: String =
    "Are you claiming tax deducted from other income?"

  def pageParagraph: String =
    "Tax relief can include:"

  def pageListItem1: String =
    "Bank or Building Society interest"

  def pageListItem2: String =
    "Tax shown on a R185E certificate"

  def pageListItem3: String =
    "Tax deducted from a Discretionary Trust payment"

  def pageErrorMsg: String =
    "Select Yes if you are claiming UK tax deducted from other income."

  val yes: String = "#value"
  val no: String  = "#value-no"

  def validateNavigation(): Unit =
    AreYouClaimingTaxDeductedFromOtherIncomePage.verifyPageUrl(AreYouClaimingTaxDeductedFromOtherIncomePage.pageUrl)
    AreYouClaimingTaxDeductedFromOtherIncomePage.verifyPageTitle(AreYouClaimingTaxDeductedFromOtherIncomePage.pageTitle)
    AreYouClaimingTaxDeductedFromOtherIncomePage.verifyPageHeader(
      AreYouClaimingTaxDeductedFromOtherIncomePage.pageHeader
    )

  def validateParagraph(): Unit = {
    AreYouClaimingTaxDeductedFromOtherIncomePage.verifyParagraphText(
      AreYouClaimingTaxDeductedFromOtherIncomePage.pageParagraph
    )
    AreYouClaimingTaxDeductedFromOtherIncomePage.verifyListText(
      AreYouClaimingTaxDeductedFromOtherIncomePage.createSingleStringFromMany(
        AreYouClaimingTaxDeductedFromOtherIncomePage.pageListItem1,
        AreYouClaimingTaxDeductedFromOtherIncomePage.pageListItem2,
        AreYouClaimingTaxDeductedFromOtherIncomePage.pageListItem3
      )
    )
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    AreYouClaimingTaxDeductedFromOtherIncomePage.validateGenericPageError(
      AreYouClaimingTaxDeductedFromOtherIncomePage.pageErrorMsg
    )
}
