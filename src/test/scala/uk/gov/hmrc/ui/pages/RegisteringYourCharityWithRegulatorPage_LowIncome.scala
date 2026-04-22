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

object RegisteringYourCharityWithRegulatorPage_LowIncome extends BasePage {

  override def pageUrl: String = s"$hostname/registering-your-charity-with-a-regulator"

  override def pageTitle: String =
    "Registering your charity with a regulator - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String = "Registering your charity with a regulator"

  def pageWarningIcon: String =
    "!"

  def pageWarningHeading: String =
    "Warning"

  def pageWarningText: String =
    "You have made claims for Gift Aid repayments on donations of £5,000 or more in the last 12 months."

  def textParagraph1: String =
    "If your annual income is £5,000 or more, you need to register your charity with a regulator (opens in new tab)."

  def pageErrorMsg: String = "Select ‘Yes’ if you need to register with a regulator"

  def textRadioButtonQuestion: String = "Do you need to register your charity with a regulator?"

  def textRadioButtonYes: String = "Yes"

  def textRadioButtonNo: String = "No, continue with claim"

  def btnContinue: String = "Continue"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    RegisteringYourCharityWithRegulatorPage_LowIncome.verifyPageUrl(
      RegisteringYourCharityWithRegulatorPage_LowIncome.pageUrl
    )
    RegisteringYourCharityWithRegulatorPage_LowIncome.verifyPageTitle(
      RegisteringYourCharityWithRegulatorPage_LowIncome.pageTitle
    )
    RegisteringYourCharityWithRegulatorPage_LowIncome.verifyPageHeading(
      RegisteringYourCharityWithRegulatorPage_LowIncome.pageHeading
    )
  }

  def validatePageContent(): Unit = {
    RegisteringYourCharityWithRegulatorPage_LowIncome.verifyPageWarning(
      RegisteringYourCharityWithRegulatorPage_LowIncome.createSingleStringFromMany(
        RegisteringYourCharityWithRegulatorPage_LowIncome.pageWarningIcon,
        RegisteringYourCharityWithRegulatorPage_LowIncome.pageWarningHeading,
        RegisteringYourCharityWithRegulatorPage_LowIncome.pageWarningText
      )
    )
    RegisteringYourCharityWithRegulatorPage_LowIncome.verifyParagraphText(
      RegisteringYourCharityWithRegulatorPage_LowIncome.textParagraph1
    )
    RegisteringYourCharityWithRegulatorPage_LowIncome.verifyFormFieldsetContent(
      RegisteringYourCharityWithRegulatorPage_LowIncome.createSingleStringFromMany(
        RegisteringYourCharityWithRegulatorPage_LowIncome.textRadioButtonQuestion,
        RegisteringYourCharityWithRegulatorPage_LowIncome.textRadioButtonYes,
        RegisteringYourCharityWithRegulatorPage_LowIncome.textRadioButtonNo
      )
    )
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    RegisteringYourCharityWithRegulatorPage_LowIncome.validateGenericPageError(
      RegisteringYourCharityWithRegulatorPage_LowIncome.pageErrorMsg,
      RegisteringYourCharityWithRegulatorPage_LowIncome.errorMsgLocator
    )
}
