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

import org.openqa.selenium.By

object AreYouClaimingTaxDeductedFromOtherIncomePage_OLD extends BasePage {

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
    AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.verifyPageUrl(
      AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.pageUrl
    )
    AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.verifyPageTitle(
      AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.pageTitle
    )
    AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.verifyPageHeader(
      AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.pageHeader
    )
  }

  def validateParagraph(): Unit = {
    AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.verifyParagraphText(
      AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.pageParagraph
    )
    AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.verifyListText(
      AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.createSingleStringFromMany(
        AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.pageListItem1,
        AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.pageListItem2,
        AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.pageListItem3
      )
    )
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.validateGenericPageError(
      AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.pageErrorMsg,
      AreYouClaimingTaxDeductedFromOtherIncomePage_OLD.errorMsgLocator
    )
}
