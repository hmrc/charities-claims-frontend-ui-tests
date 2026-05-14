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

object RegisteringYourCharityWithRegulatorPage_Excepted extends BasePage {

  override def pageUrl: String = s"$hostname/registering-your-charity-with-a-regulator"

  override def pageTitle: String =
    "Registering your charity with a regulator - Make a charity tax repayment claim - GOV.UK"

  def pageTitleAgent: String =
    "Registering the charity with a regulator - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String = "Registering your charity with a regulator"

  def pageHeadingAgent: String = "Registering the charity with a regulator"

  def pageWarningIcon: String =
    "!"

  def pageWarningHeading: String =
    "Warning"

  def pageWarningText: String =
    "You have made claims for Gift Aid repayments on donations of £100,000 or more in the last 12 months."

  def pageWarningTextAgent: String =
    "The charity has made claims for Gift Aid repayments on donations of £100,000 or more in the last 12 months."

  def textParagraph1: String =
    "If your annual income is £100,000 or more, you need to register your charity with a regulator (opens in new tab)."

  def textParagraph1Agent: String =
    "If the charity’s annual income is £100,000 or more, you need to register this charity with a regulator (opens in new tab)."

  def pageErrorMsg: String = "Select ‘Yes’ if you need to register with a regulator"

  def textRadioButtonQuestion: String = "Do you need to register your charity with a regulator?"

  def textRadioButtonQuestionAgent: String = "Do you need to register this charity with a regulator?"

  def textRadioButtonYes: String = "Yes"

  def textRadioButtonNo: String = "No, continue with claim"

  def btnContinue: String = "Continue"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    RegisteringYourCharityWithRegulatorPage_Excepted.verifyPageUrl(
      RegisteringYourCharityWithRegulatorPage_Excepted.pageUrl
    )
    RegisteringYourCharityWithRegulatorPage_Excepted.verifyPageTitle(
      RegisteringYourCharityWithRegulatorPage_Excepted.pageTitle
    )
    RegisteringYourCharityWithRegulatorPage_Excepted.verifyPageHeading(
      RegisteringYourCharityWithRegulatorPage_Excepted.pageHeading
    )
  }

  def validateNavigationAgent(): Unit = {
    RegisteringYourCharityWithRegulatorPage_Excepted.verifyPageUrl(
      RegisteringYourCharityWithRegulatorPage_Excepted.pageUrl
    )
    RegisteringYourCharityWithRegulatorPage_Excepted.verifyPageTitle(
      RegisteringYourCharityWithRegulatorPage_Excepted.pageTitleAgent
    )
    RegisteringYourCharityWithRegulatorPage_Excepted.verifyPageHeading(
      RegisteringYourCharityWithRegulatorPage_Excepted.pageHeadingAgent
    )
  }

  def validatePageContent(): Unit = {
    RegisteringYourCharityWithRegulatorPage_Excepted.verifyPageWarning(
      RegisteringYourCharityWithRegulatorPage_Excepted.createSingleStringFromMany(
        RegisteringYourCharityWithRegulatorPage_Excepted.pageWarningIcon,
        RegisteringYourCharityWithRegulatorPage_Excepted.pageWarningHeading,
        RegisteringYourCharityWithRegulatorPage_Excepted.pageWarningText
      )
    )
    RegisteringYourCharityWithRegulatorPage_Excepted.verifyParagraphText(
      RegisteringYourCharityWithRegulatorPage_Excepted.textParagraph1
    )
    RegisteringYourCharityWithRegulatorPage_Excepted.verifyFormFieldsetContent(
      RegisteringYourCharityWithRegulatorPage_Excepted.createSingleStringFromMany(
        RegisteringYourCharityWithRegulatorPage_Excepted.textRadioButtonQuestion,
        RegisteringYourCharityWithRegulatorPage_Excepted.textRadioButtonYes,
        RegisteringYourCharityWithRegulatorPage_Excepted.textRadioButtonNo
      )
    )
  }

  def validatePageContentAgent(): Unit = {
    RegisteringYourCharityWithRegulatorPage_Excepted.verifyPageWarning(
      RegisteringYourCharityWithRegulatorPage_Excepted.createSingleStringFromMany(
        RegisteringYourCharityWithRegulatorPage_Excepted.pageWarningIcon,
        RegisteringYourCharityWithRegulatorPage_Excepted.pageWarningHeading,
        RegisteringYourCharityWithRegulatorPage_Excepted.pageWarningTextAgent
      )
    )
    RegisteringYourCharityWithRegulatorPage_Excepted.verifyParagraphText(
      RegisteringYourCharityWithRegulatorPage_Excepted.textParagraph1Agent
    )
    RegisteringYourCharityWithRegulatorPage_Excepted.verifyFormFieldsetContent(
      RegisteringYourCharityWithRegulatorPage_Excepted.createSingleStringFromMany(
        RegisteringYourCharityWithRegulatorPage_Excepted.textRadioButtonQuestionAgent,
        RegisteringYourCharityWithRegulatorPage_Excepted.textRadioButtonYes,
        RegisteringYourCharityWithRegulatorPage_Excepted.textRadioButtonNo
      )
    )
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    RegisteringYourCharityWithRegulatorPage_Excepted.validateGenericPageError(
      RegisteringYourCharityWithRegulatorPage_Excepted.pageErrorMsg,
      RegisteringYourCharityWithRegulatorPage_Excepted.errorMsgLocator
    )
}
