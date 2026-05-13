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

object WhatIsYourTelephoneNumberPage extends BasePage {

  override def pageUrl: String = s"$hostname/enter-a-telephone-number"

  override def pageTitle: String =
    "What is your telephone number? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeading: String =
    "What is your telephone number?"

  def pageParagraph: String =
    "You must provide a phone number so HM Revenue & Customs can get in touch about this claim."

  def pageHint: String =
    "For international numbers include the country code"

  def pageErrorMsg: String =
    "Enter a telephone number"

  def pageErrorMsgTooManyChars =
    "Telephone number must be 30 characters or less"

  def pageErrorMsgInvalidFormat =
    "Enter a telephone number in the correct format"

  def inputMaxLength = 31

  val telephoneNumberFieldLocator = By.ById("value")
  val errorMsgLocator             = By.ById("value-error")

  def enterClaimReferenceNumber(referenceNo: String): Unit = {
    input(Locators.inputReferenceNumber, referenceNo)
    clickContinue()
  }

  def validateNavigationAgent(): Unit = {
    WhatIsYourTelephoneNumberPage.verifyPageUrl(WhatIsYourTelephoneNumberPage.pageUrl)
    WhatIsYourTelephoneNumberPage.verifyPageTitle(WhatIsYourTelephoneNumberPage.pageTitle)
    WhatIsYourTelephoneNumberPage.verifyPageCaption(WhatIsYourTelephoneNumberPage.pageCaption)
    WhatIsYourTelephoneNumberPage.verifyPageHeading(WhatIsYourTelephoneNumberPage.pageHeading)
  }

  def validatePageContentAgent(): Unit = {
    WhatIsYourTelephoneNumberPage.verifyParagraphText(WhatIsYourTelephoneNumberPage.pageParagraph)
    WhatIsYourTelephoneNumberPage.verifyHintText(WhatIsYourTelephoneNumberPage.pageHint)
  }

  /** Validate that the error message is correct */
  def validateErrorMessageAgent(): Unit = {
    WhatIsYourTelephoneNumberPage.validateGenericPageError(
      WhatIsYourTelephoneNumberPage.pageErrorMsg,
      WhatIsYourTelephoneNumberPage.errorMsgLocator
    )

    /** Number defines string length */
    WhatIsYourTelephoneNumberPage.triggerTooManyCharInputError(
      WhatIsYourTelephoneNumberPage.inputMaxLength,
      WhatIsYourTelephoneNumberPage.pageErrorMsgTooManyChars,
      WhatIsYourTelephoneNumberPage.telephoneNumberFieldLocator,
      WhatIsYourTelephoneNumberPage.errorMsgLocator
    )
    WhatIsYourTelephoneNumberPage.triggerNonWesternEuropeanAlphabetError(
      WhatIsYourTelephoneNumberPage.pageErrorMsgInvalidFormat,
      WhatIsYourTelephoneNumberPage.telephoneNumberFieldLocator,
      WhatIsYourTelephoneNumberPage.errorMsgLocator
    )
  }

  def enterAgentTelephoneNumber(agentTelephoneNumber: String): Unit = {
    input(Locators.txtAgentTelephoneNum, agentTelephoneNumber)
    clickContinue()
  }
}
