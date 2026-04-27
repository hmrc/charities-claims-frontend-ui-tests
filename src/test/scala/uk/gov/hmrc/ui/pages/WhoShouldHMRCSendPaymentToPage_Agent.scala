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

object WhoShouldHMRCSendPaymentToPage_Agent extends BasePage {

  override def pageUrl: String = s"$hostname/who-should-we-send-the-payment-to"

  def changePageUrl: String = s"$hostname/tobeconfirmed"

  override def pageTitle: String =
    "Who should HMRC send payment to? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageHeading: String =
    "Who should HMRC send payment to?"

  def pageErrorMsg: String =
    "TEST"

  val charityorcasc: String  = "#value"
  val agentornominee: String = "#value-no"
  val errorMsgLocator        = By.ById("value-error")

  def validateNavigation(): Unit = {
    WhoShouldHMRCSendPaymentToPage_Agent.verifyPageUrl(WhoShouldHMRCSendPaymentToPage_Agent.pageUrl)
    WhoShouldHMRCSendPaymentToPage_Agent.verifyPageTitle(WhoShouldHMRCSendPaymentToPage_Agent.pageTitle)
    WhoShouldHMRCSendPaymentToPage_Agent.verifyPageCaption(WhoShouldHMRCSendPaymentToPage_Agent.pageCaption)
    WhoShouldHMRCSendPaymentToPage_Agent.verifyPageHeading(WhoShouldHMRCSendPaymentToPage_Agent.pageHeading)
  }

  def validateChangeNavigation(): Unit = {
    WhoShouldHMRCSendPaymentToPage_Agent.verifyPageUrl(WhoShouldHMRCSendPaymentToPage_Agent.changePageUrl)
    WhoShouldHMRCSendPaymentToPage_Agent.verifyPageTitle(WhoShouldHMRCSendPaymentToPage_Agent.pageTitle)
    WhoShouldHMRCSendPaymentToPage_Agent.verifyPageCaption(WhoShouldHMRCSendPaymentToPage_Agent.pageCaption)
    WhoShouldHMRCSendPaymentToPage_Agent.verifyPageHeading(WhoShouldHMRCSendPaymentToPage_Agent.pageHeading)
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    WhoShouldHMRCSendPaymentToPage_Agent.validateGenericPageError(
      WhoShouldHMRCSendPaymentToPage_Agent.pageErrorMsg,
      WhoShouldHMRCSendPaymentToPage_Agent.errorMsgLocator
    )
}
