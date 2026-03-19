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

object CheckYourGiftAidSchedulePage extends BasePage {

  override def pageUrl: String = s"$hostname/check-your-gift-aid-schedule"

  override def pageTitle: String =
    "Check your Gift Aid schedule (page 1 of 100) - Charities - GOV.UK"

  def pageCaption: String =
    "Add Gift Aid schedule"

  def pageHeading: String =
    "Check your Gift Aid schedule"

  def pageErrorMsg: String =
    "Select ‘Yes’ if you need to update this Gift Aid schedule"

  def textSummaryCardTitle: String =
    "Gift Aid schedule details"

  def textSummaryRow1Col1: String =
    "Earliest donation date"

  def textSummaryRow1Col2: String =
    "1 January 2025"

  def textSummaryRow2Col1: String =
    "Adjustment for Gift Aid previously over-claimed"

  def textSummaryRow2Col2: String =
    "£0.00"

  def textSummaryRow3Col1: String =
    "Total donations"

  def textSummaryRow3Col2: String =
    "£599,500.00"

  def textRadioButtonQuestion: String =
    "Do you need to update this Gift Aid schedule?"

  def textRadioButtonYes: String =
    "Yes"

  def textRadioButtonNo: String =
    "No, continue with Gift Aid schedule"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    CheckYourGiftAidSchedulePage.verifyPageUrl(CheckYourGiftAidSchedulePage.pageUrl)
    CheckYourGiftAidSchedulePage.verifyPageTitle(CheckYourGiftAidSchedulePage.pageTitle)
    CheckYourGiftAidSchedulePage.verifyPageCaption(CheckYourGiftAidSchedulePage.pageCaption)
    CheckYourGiftAidSchedulePage.verifyPageHeading(CheckYourGiftAidSchedulePage.pageHeading)
  }

  // TODO Hardcoded values, needs improved
  def validateSummaryCard(): Unit =
    CheckYourGiftAidSchedulePage.verifySummaryCardContent(
      CheckYourGiftAidSchedulePage.createSingleStringFromMany(
        CheckYourGiftAidSchedulePage.textSummaryCardTitle,
        CheckYourGiftAidSchedulePage.textSummaryRow1Col1 + " " + CheckYourGiftAidSchedulePage.textSummaryRow1Col2,
        CheckYourGiftAidSchedulePage.textSummaryRow2Col1 + " " + CheckYourGiftAidSchedulePage.textSummaryRow2Col2,
        CheckYourGiftAidSchedulePage.textSummaryRow3Col1 + " " + CheckYourGiftAidSchedulePage.textSummaryRow3Col2
      )
    )

  def validateFormFieldset(): Unit =
    CheckYourGiftAidSchedulePage.verifyFormFieldsetContent(
      CheckYourGiftAidSchedulePage.createSingleStringFromMany(
        CheckYourGiftAidSchedulePage.textRadioButtonQuestion,
        CheckYourGiftAidSchedulePage.textRadioButtonYes,
        CheckYourGiftAidSchedulePage.textRadioButtonNo
      )
    )

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    CheckYourGiftAidSchedulePage.validateGenericPageError(
      CheckYourGiftAidSchedulePage.pageErrorMsg,
      CheckYourGiftAidSchedulePage.errorMsgLocator
    )
}
