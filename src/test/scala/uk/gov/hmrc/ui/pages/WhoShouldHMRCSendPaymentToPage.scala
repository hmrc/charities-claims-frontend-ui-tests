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

object WhoShouldHMRCSendPaymentToPage extends BasePage {

  override def pageUrl: String = s"$hostname/who-should-we-send-the-payment-to"

  def changePageUrl: String = s"$hostname/change-who-should-we-send-the-payment-to"

  override def pageTitle: String =
    "Who should HMRC send payment to? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeading: String =
    "Who should HMRC send payment to?"

  def pageErrorMsg: String =
    "Select who HMRC should send payment to"

  def textRadioButtonCASC: String = "Charity/Community Amateur Sports Club (CASC)"

  def textRadioButtonAgent: String = "Agent/Nominee"

  val CASC: String    = "#value"
  val AgtTtee: String = "#taxAgent"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigationAgent(): Unit = {
    WhoShouldHMRCSendPaymentToPage.verifyPageUrl(WhoShouldHMRCSendPaymentToPage.pageUrl)
    WhoShouldHMRCSendPaymentToPage.verifyPageTitle(WhoShouldHMRCSendPaymentToPage.pageTitle)
    WhoShouldHMRCSendPaymentToPage.verifyPageCaption(WhoShouldHMRCSendPaymentToPage.pageCaption)
    WhoShouldHMRCSendPaymentToPage.verifyPageHeading(WhoShouldHMRCSendPaymentToPage.pageHeading)
  }

  def validateChangeNavigationAgent(): Unit = {
    WhoShouldHMRCSendPaymentToPage.verifyPageUrl(WhoShouldHMRCSendPaymentToPage.changePageUrl)
    WhoShouldHMRCSendPaymentToPage.verifyPageTitle(WhoShouldHMRCSendPaymentToPage.pageTitle)
    WhoShouldHMRCSendPaymentToPage.verifyPageCaption(WhoShouldHMRCSendPaymentToPage.pageCaption)
    WhoShouldHMRCSendPaymentToPage.verifyPageHeading(WhoShouldHMRCSendPaymentToPage.pageHeading)
  }

  def validateFormFieldsetAgent(): Unit =
    WhoShouldHMRCSendPaymentToPage.verifyFormFieldsetContent(
      WhoShouldHMRCSendPaymentToPage.createSingleStringFromMany(
        WhoShouldHMRCSendPaymentToPage.pageHeading,
        WhoShouldHMRCSendPaymentToPage.textRadioButtonCASC,
        WhoShouldHMRCSendPaymentToPage.textRadioButtonAgent
      )
    )

  /** Validate that the error message is correct */
  def validateErrorMessageAgent(): Unit =
    WhoShouldHMRCSendPaymentToPage.validateGenericPageError(
      WhoShouldHMRCSendPaymentToPage.pageErrorMsg,
      WhoShouldHMRCSendPaymentToPage.errorMsgLocator
    )
}
