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

object WhatIsYourPostcodePage extends BasePage {

  override def pageUrl: String = s"$hostname/what-is-your-postcode"

  override def pageTitle: String =
    "What is your postcode? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeading: String =
    "What is your postcode?"

  def pageErrorMsg: String =
    "Enter a postcode"

  def pageErrorMsgTooManyChars =
    "Postcode must be 8 characters or less"

  def pageErrorMsgInvalidFormat =
    "Enter a postcode in the correct format"

  def inputMaxLength = 9

  val postcodeFieldLocator = By.ById("value")
  val errorMsgLocator      = By.ById("value-error")

  def validateNavigationAgent(): Unit = {
    WhatIsYourPostcodePage.verifyPageUrl(WhatIsYourPostcodePage.pageUrl)
    WhatIsYourPostcodePage.verifyPageTitle(WhatIsYourPostcodePage.pageTitle)
    WhatIsYourPostcodePage.verifyPageCaption(WhatIsYourPostcodePage.pageCaption)
    WhatIsYourPostcodePage.verifyPageHeading(WhatIsYourPostcodePage.pageHeading)
  }

  def enterAgentPostcode(agentPostcode: String): Unit = {
    input(Locators.txtAgentPostcode, agentPostcode)
    clickContinue()
  }

  /** Validate that the error message is correct */
  def validateErrorMessageAgent(): Unit = {
    WhatIsYourPostcodePage.validateGenericPageError(
      WhatIsYourPostcodePage.pageErrorMsg,
      WhatIsYourPostcodePage.errorMsgLocator
    )

    /** Number defines string length */
    WhatIsYourPostcodePage.triggerTooManyCharInputError(
      WhatIsYourPostcodePage.inputMaxLength,
      WhatIsYourPostcodePage.pageErrorMsgTooManyChars,
      WhatIsYourPostcodePage.postcodeFieldLocator,
      WhatIsYourPostcodePage.errorMsgLocator
    )
    WhatIsYourPostcodePage.triggerNonWesternEuropeanAlphabetError(
      WhatIsYourPostcodePage.pageErrorMsgInvalidFormat,
      WhatIsYourPostcodePage.postcodeFieldLocator,
      WhatIsYourPostcodePage.errorMsgLocator
    )
  }
}
