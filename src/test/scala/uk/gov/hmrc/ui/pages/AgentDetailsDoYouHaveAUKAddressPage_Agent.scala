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

object AgentDetailsDoYouHaveAUKAddressPage_Agent extends BasePage {
  override def pageUrl: String = s"$hostname/do-you-have-a-uk-address"

  override def pageTitle: String =
    "Do you have a UK address? - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "Agent Details"

  def pageSubHeading: String =
    "Do you have a UK address?"

  def pageCaption: String =
    "Provide organisation details"

  /* Error Messages To Be Confirmed */
  def pageErrorMsg: String =
    "Select ‘Yes’ if you have a UK address"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    AgentDetailsDoYouHaveAUKAddressPage_Agent.verifyPageUrl(AgentDetailsDoYouHaveAUKAddressPage_Agent.pageUrl)
    AgentDetailsDoYouHaveAUKAddressPage_Agent.verifyPageTitle(AgentDetailsDoYouHaveAUKAddressPage_Agent.pageTitle)
    AgentDetailsDoYouHaveAUKAddressPage_Agent.verifyPageHeading(
      AgentDetailsDoYouHaveAUKAddressPage_Agent.pageHeading
    )
    AgentDetailsDoYouHaveAUKAddressPage_Agent.verifyPageCaption(
      AgentDetailsDoYouHaveAUKAddressPage_Agent.pageCaption
    )
  }

  def validatePage(): Unit =
    AgentDetailsDoYouHaveAUKAddressPage_Agent.verifyLegendText(AgentDetailsDoYouHaveAUKAddressPage_Agent.pageSubHeading)

  def validateErrorMessage(): Unit =
    AgentDetailsDoYouHaveAUKAddressPage_Agent.validateGenericPageError(
      AgentDetailsDoYouHaveAUKAddressPage_Agent.pageErrorMsg,
      AgentDetailsDoYouHaveAUKAddressPage_Agent.errorMsgLocator
    )
}
