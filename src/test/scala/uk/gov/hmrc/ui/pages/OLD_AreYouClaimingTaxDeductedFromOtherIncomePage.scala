/*
 * Copyright 2025 HM Revenue & Customs
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

object OLD_AreYouClaimingTaxDeductedFromOtherIncomePage extends BasePage {

  override def pageUrl: String = s"$hostname/old/claiming-other-income"

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
    "Select ‘Yes’ if you are claiming tax deducted from other income."

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.verifyPageUrl(
      OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.pageUrl
    )
    OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.verifyPageTitle(
      OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.pageTitle
    )
    OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.verifyPageHeader(
      OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.pageHeader
    )
  }

  def validateParagraph(): Unit = {
    OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.verifyParagraphText(
      OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.pageParagraph
    )
    OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.verifyListText(
      OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.createSingleStringFromMany(
        OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.pageListItem1,
        OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.pageListItem2,
        OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.pageListItem3
      )
    )
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.validateGenericPageError(
      OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.pageErrorMsg,
      OLD_AreYouClaimingTaxDeductedFromOtherIncomePage.errorMsgLocator
    )
}
