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

object CheckYourOtherIncomeSchedulePage extends BasePage {

  override def pageUrl: String = s"$hostname/check-your-other-income-schedule"

  override def pageTitle: String = "Check your Other Income schedule - Make a charity tax repayment claim - GOV.UK"

  def pageTitleAgent: String = "Check this Other Income schedule - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String = "Add Other Income schedule"

  def pageHeading: String = "Check your Other Income schedule"

  def pageHeadingAgent: String = "Check this Other Income schedule"

  def pageErrorMsg: String = "Select ‘Yes’ if you need to update this Other Income schedule"

  def textSummaryCardTitle: String = "Other Income schedule details"

  def textAdjForOIOverclaimed: String = "Adjustment for Other Income previously over-claimed"

  def textTotalGrossPayment: String = "Total gross payment"

  def textTotalTaxDeducted: String = "Total tax deducted"

  def textRadioButtonQuestion: String = "Do you need to update this Other Income schedule?"

  def textRadioButtonYes: String = "Yes"

  def textRadioButtonNo: String = "No, continue with Other Income schedule"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    CheckYourOtherIncomeSchedulePage.verifyPageUrl(CheckYourOtherIncomeSchedulePage.pageUrl)
    CheckYourOtherIncomeSchedulePage.verifyPageTitle(CheckYourOtherIncomeSchedulePage.pageTitle)
    CheckYourOtherIncomeSchedulePage.verifyPageCaption(CheckYourOtherIncomeSchedulePage.pageCaption)
    CheckYourOtherIncomeSchedulePage.verifyPageHeading(CheckYourOtherIncomeSchedulePage.pageHeading)
  }

  def validateNavigationAgent(): Unit = {
    CheckYourOtherIncomeSchedulePage.verifyPageUrl(CheckYourOtherIncomeSchedulePage.pageUrl)
    CheckYourOtherIncomeSchedulePage.verifyPageTitle(CheckYourOtherIncomeSchedulePage.pageTitleAgent)
    CheckYourOtherIncomeSchedulePage.verifyPageCaption(CheckYourOtherIncomeSchedulePage.pageCaption)
    CheckYourOtherIncomeSchedulePage.verifyPageHeading(CheckYourOtherIncomeSchedulePage.pageHeadingAgent)
  }

  def validateSummaryCardTitle(): Unit =
    CheckYourOtherIncomeSchedulePage.verifySummaryCardTitle(
      CheckYourOtherIncomeSchedulePage.textSummaryCardTitle
    )

  def validateFormFieldset(): Unit =
    CheckYourOtherIncomeSchedulePage.verifyFormFieldsetContent(
      CheckYourOtherIncomeSchedulePage.createSingleStringFromMany(
        CheckYourOtherIncomeSchedulePage.textRadioButtonQuestion,
        CheckYourOtherIncomeSchedulePage.textRadioButtonYes,
        CheckYourOtherIncomeSchedulePage.textRadioButtonNo
      )
    )

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    CheckYourOtherIncomeSchedulePage.validateGenericPageError(
      CheckYourOtherIncomeSchedulePage.pageErrorMsg,
      CheckYourOtherIncomeSchedulePage.errorMsgLocator
    )
}
