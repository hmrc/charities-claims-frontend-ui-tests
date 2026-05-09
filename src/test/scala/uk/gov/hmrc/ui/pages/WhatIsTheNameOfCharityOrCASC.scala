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

object WhatIsTheNameOfCharityOrCASC extends BasePage {

  override def pageUrl: String = s"$hostname/enter-the-charity-name"

  override def pageTitle: String =
    "What is the name of the charity or Community Amateur Sports Club (CASC)? - Make a charity tax repayment claim - GOV.UK"

  def pageTitleAgent: String =
    "What is the name of the charity or Community Amateur Sports Club (CASC)? - Make a charity tax repayment claim - GOV.UK"

  def pageHeadingAgent: String =
    "What is the name of the charity or Community Amateur Sports Club (CASC)?"

  def pageHint: String =
    "Enter the name registered with HM Revenue & Customs. For example, Royal Society for the Prevention of Cruelty to Animals Hillingdon, Slough and District Branch."

  def pageHiddenHint: String =
    "You can enter up to 160 characters"

  def pageCharacterCount: String =
    "You have 160 characters remaining"

  def pageHiddenCharacterCount: String =
    "You have 160 characters remaining"

  def pageErrorMsgRequiredValue: String =
    "Enter a charity or Community Amateur Sports Club (CASC) name"

  def pageErrorMsgTooManyChars: String =
    "Charity or Community Amateur Sports Club (CASC) name must be 160 characters or less"

  def pageErrorMsgNonWesternChar: String =
    "Enter a charity or Community Amateur Sports Club (CASC) name in the correct format"

  def btnContinue: String =
    "Continue"

  val charityNameFieldLocator = By.ById("value")
  val errorMsgLocator               = By.ById("value-error")

  def inputMaxLength = 161

  def enterCharityName(charityName: String): Unit = {
    input(charityNameFieldLocator, charityName)
    clickContinue()
  }

  def validateNavigationAgent(): Unit = {
    WhatIsTheNameOfCharityOrCASC.verifyPageUrl(WhatIsTheNameOfCharityOrCASC.pageUrl)
    WhatIsTheNameOfCharityOrCASC.verifyPageTitle(WhatIsTheNameOfCharityOrCASC.pageTitleAgent)
    WhatIsTheNameOfCharityOrCASC.verifyPageHeading(WhatIsTheNameOfCharityOrCASC.pageHeadingAgent)
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit = {
    WhatIsTheNameOfCharityOrCASC.validateGenericPageError(
      WhatIsTheNameOfCharityOrCASC.pageErrorMsgRequiredValue,
      WhatIsTheNameOfCharityOrCASC.errorMsgLocator
    )

    /** Number defines string length */
    WhatIsTheNameOfCharityOrCASC.triggerTooManyCharInputError(
      WhatIsTheNameOfCharityOrCASC.inputMaxLength,
      WhatIsTheNameOfCharityOrCASC.pageErrorMsgTooManyChars,
      WhatIsTheNameOfCharityOrCASC.charityNameFieldLocator,
      WhatIsTheNameOfCharityOrCASC.errorMsgLocator
    )
    WhatIsTheNameOfCharityOrCASC.triggerNonWesternEuropeanAlphabetError(
      WhatIsTheNameOfCharityOrCASC.pageErrorMsgNonWesternChar,
      WhatIsTheNameOfCharityOrCASC.charityNameFieldLocator,
      WhatIsTheNameOfCharityOrCASC.errorMsgLocator
    )
  }

  def validateHintAgent(): Unit =
    WhatIsTheNameOfCharityOrCASC.verifyHintText(
      WhatIsTheNameOfCharityOrCASC.pageHint
    )

  def validatePageContentAgent(): Unit =
    WhatIsTheNameOfCharityOrCASC.verifyEntirePageContent(
      WhatIsTheNameOfCharityOrCASC.createSingleStringFromMany(
        WhatIsTheNameOfCharityOrCASC.pageHeadingAgent,
        WhatIsTheNameOfCharityOrCASC.pageHint,
        WhatIsTheNameOfCharityOrCASC.pageHiddenHint,
        WhatIsTheNameOfCharityOrCASC.pageCharacterCount,
        WhatIsTheNameOfCharityOrCASC.pageHiddenCharacterCount,
        WhatIsTheNameOfCharityOrCASC.btnContinue
      )
    )
}
