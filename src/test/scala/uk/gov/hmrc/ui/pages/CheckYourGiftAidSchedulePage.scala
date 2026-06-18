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
    "Check your Gift Aid schedule (page 1 of 100) - Make a charity tax repayment claim - GOV.UK"

  def pageTitleAgent: String =
    "Check this Gift Aid schedule (page 1 of 100) - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Add Gift Aid schedule"

  def pageHeading: String =
    "Check your Gift Aid schedule"

  def pageHeadingAgent: String =
    "Check this Gift Aid schedule"

  def pageErrorMsg: String =
    "Select ‘Yes’ if you need to update this Gift Aid schedule"

  def textSummaryCardTitle: String =
    "Gift Aid schedule details"

  def textEarliestDonationDate: String =
    "Earliest donation date"

  def textAdjForGAOverclaimed: String =
    "Adjustment for Gift Aid previously over-claimed"

  def textTotalDonations: String =
    "Total donations"

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

  def validateSummaryCardTitle(): Unit =
    CheckYourGiftAidSchedulePage.verifySummaryCardTitle(
      CheckYourGiftAidSchedulePage.textSummaryCardTitle
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

  def validateNavigationAgent(): Unit = {
    CheckYourGiftAidSchedulePage.verifyPageUrl(CheckYourGiftAidSchedulePage.pageUrl)
    CheckYourGiftAidSchedulePage.verifyPageTitle(CheckYourGiftAidSchedulePage.pageTitleAgent)
    CheckYourGiftAidSchedulePage.verifyPageCaption(CheckYourGiftAidSchedulePage.pageCaption)
    CheckYourGiftAidSchedulePage.verifyPageHeading(CheckYourGiftAidSchedulePage.pageHeadingAgent)
  }
}
