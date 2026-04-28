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

object WhatIsYourPostcodePage_Agent extends BasePage {

  override def pageUrl: String = s"$hostname/what-is-your-postcode"

  override def pageTitle: String =
    "What is your postcode? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageHeading: String =
    "What is your postcode?"

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
    WhatIsYourPostcodePage_Agent.verifyPageUrl(WhatIsYourPostcodePage_Agent.pageUrl)
    WhatIsYourPostcodePage_Agent.verifyPageTitle(WhatIsYourPostcodePage_Agent.pageTitle)
    WhatIsYourPostcodePage_Agent.verifyPageCaption(WhatIsYourPostcodePage_Agent.pageCaption)
    WhatIsYourPostcodePage_Agent.verifyPageHeading(WhatIsYourPostcodePage_Agent.pageHeading)
  }

  def validatePage(): Unit = {
    WhatIsYourPostcodePage_Agent.verifyLegendText(WhatIsYourPostcodePage_Agent.pageParagraph)
    WhatIsYourPostcodePage_Agent.verifyHintText(WhatIsYourPostcodePage_Agent.pageHint)
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit = {
    WhatIsYourPostcodePage_Agent.validateGenericPageError(
      WhatIsYourPostcodePage_Agent.pageErrorMsg,
      WhatIsYourPostcodePage_Agent.errorMsgLocator
    )

    /** Number defines string length */
    WhatIsYourPostcodePage_Agent.triggerTooManyCharInputError(
      WhatIsYourPostcodePage_Agent.inputMaxLength,
      WhatIsYourPostcodePage_Agent.pageErrorInvalidFormat,
      WhatIsYourPostcodePage_Agent.agentTelephoneNumberFieldLocator,
      WhatIsYourPostcodePage_Agent.errorMsgLocator
    )
    WhatIsYourPostcodePage_Agent.triggerNonWesternEuropeanAlphabetError(
      WhatIsYourPostcodePage_Agent.pageErrorInvalidFormat,
      WhatIsYourPostcodePage_Agent.agentTelephoneNumberFieldLocator,
      WhatIsYourPostcodePage_Agent.errorMsgLocator
    )
  }
}
