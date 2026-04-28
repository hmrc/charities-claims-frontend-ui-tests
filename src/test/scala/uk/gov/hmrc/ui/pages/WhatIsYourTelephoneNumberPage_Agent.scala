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

object WhatIsYourTelephoneNumberPage_Agent extends BasePage {

  override def pageUrl: String = s"$hostname/enter-claim-reference-number"

  override def pageTitle: String =
    "What is your telephone number? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageHeading: String =
    "What is your telephone number?"

  def pageParagraph: String =
    "You must provide a phone number so HM Revenue & Customs can get in touch about this claim."

  def pageHint: String =
    "For international numbers include the country code"

  def pageErrorMsg: String =
    "Enter a telephone number"

  def pageErrorInvalidFormat =
    "Enter a telephone number in the correct format "

  def inputMaxLength = 36

  val agentTelephoneNumberFieldLocator = By.ById("value")
  val errorMsgLocator                  = By.ById("value-error")

  def enterTelephoneNumber(telephoneNo: String): Unit = {
    input(Locators.inputAgentTelephoneNumberFieldLocator, telephoneNo)
    clickContinue()
  }

  def validateNavigation(): Unit = {
    WhatIsYourTelephoneNumberPage_Agent.verifyPageUrl(WhatIsYourTelephoneNumberPage_Agent.pageUrl)
    WhatIsYourTelephoneNumberPage_Agent.verifyPageTitle(WhatIsYourTelephoneNumberPage_Agent.pageTitle)
    WhatIsYourTelephoneNumberPage_Agent.verifyPageCaption(WhatIsYourTelephoneNumberPage_Agent.pageCaption)
    WhatIsYourTelephoneNumberPage_Agent.verifyPageHeading(WhatIsYourTelephoneNumberPage_Agent.pageHeading)
  }

  def validatePage(): Unit = {
    WhatIsYourTelephoneNumberPage_Agent.verifyLegendText(WhatIsYourTelephoneNumberPage_Agent.pageParagraph)
    WhatIsYourTelephoneNumberPage_Agent.verifyHintText(WhatIsYourTelephoneNumberPage_Agent.pageHint)
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit = {
    WhatIsYourTelephoneNumberPage_Agent.validateGenericPageError(
      WhatIsYourTelephoneNumberPage_Agent.pageErrorMsg,
      WhatIsYourTelephoneNumberPage_Agent.errorMsgLocator
    )

    /** Number defines string length */
    WhatIsYourTelephoneNumberPage_Agent.triggerTooManyCharInputError(
      WhatIsYourTelephoneNumberPage_Agent.inputMaxLength,
      WhatIsYourTelephoneNumberPage_Agent.pageErrorInvalidFormat,
      WhatIsYourTelephoneNumberPage_Agent.agentTelephoneNumberFieldLocator,
      WhatIsYourTelephoneNumberPage_Agent.errorMsgLocator
    )
    WhatIsYourTelephoneNumberPage_Agent.triggerNonWesternEuropeanAlphabetError(
      WhatIsYourTelephoneNumberPage_Agent.pageErrorInvalidFormat,
      WhatIsYourTelephoneNumberPage_Agent.agentTelephoneNumberFieldLocator,
      WhatIsYourTelephoneNumberPage_Agent.errorMsgLocator
    )
  }
}
