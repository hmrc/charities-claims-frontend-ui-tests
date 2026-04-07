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

object WhatAdjustmentsHaveYouMadeToThisClaimPage extends BasePage {

  override def pageUrl: String = s"$hostname/adjustments-to-this-claim"

  override def pageTitle: String =
    "What adjustments have you made to this claim? - Charities - GOV.UK"

  def pageHeading: String =
    "What adjustments have you made to this claim?"

  def pageParagraph: String =
    "If you have included any adjustments in this claim, you must enter an explanation below. You can also provide any other information regarding your charity’s repayment claim."

  def pageHiddenHint: String =
    "You can enter up to 350 characters"

  def pageCharacterCount: String =
    "You have 350 characters remaining"

  def pageHiddenCharacterCount: String =
    "You have 350 characters remaining"

  def pageErrorMsgRequiredValue: String =
    "Enter an adjustment to Gift Aid, Other Income or a donation under the Gift Aid Small Donations Scheme"

  def pageErrorMsgTooManyChars: String =
    "Adjustments must be 350 characters or less"

  def pageErrorMsgNonWesternChar: String =
    "Enter an adjustment in the correct format"

  def btnContinue: String =
    "Continue"

  val adjustmentDetailsFieldLocator = By.ById("value")
  val errorMsgLocator               = By.ById("value-error")

  def inputMaxLength = 351

  def enterAdjustmentDetails(adjustmentDetails: String): Unit = {
    input(adjustmentDetailsFieldLocator, adjustmentDetails)
    clickContinue()
  }

  def validateNavigation(): Unit = {
    WhatAdjustmentsHaveYouMadeToThisClaimPage.verifyPageUrl(WhatAdjustmentsHaveYouMadeToThisClaimPage.pageUrl)
    WhatAdjustmentsHaveYouMadeToThisClaimPage.verifyPageTitle(WhatAdjustmentsHaveYouMadeToThisClaimPage.pageTitle)
    WhatAdjustmentsHaveYouMadeToThisClaimPage.verifyPageHeading(WhatAdjustmentsHaveYouMadeToThisClaimPage.pageHeading)
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit = {
    WhatAdjustmentsHaveYouMadeToThisClaimPage.validateGenericPageError(
      WhatAdjustmentsHaveYouMadeToThisClaimPage.pageErrorMsgRequiredValue,
      WhatAdjustmentsHaveYouMadeToThisClaimPage.errorMsgLocator
    )

    /** Number defines string length */
    WhatAdjustmentsHaveYouMadeToThisClaimPage.triggerTooManyCharInputError(
      WhatAdjustmentsHaveYouMadeToThisClaimPage.inputMaxLength,
      WhatAdjustmentsHaveYouMadeToThisClaimPage.pageErrorMsgTooManyChars,
      WhatAdjustmentsHaveYouMadeToThisClaimPage.adjustmentDetailsFieldLocator,
      WhatAdjustmentsHaveYouMadeToThisClaimPage.errorMsgLocator
    )
    WhatAdjustmentsHaveYouMadeToThisClaimPage.triggerNonWesternEuropeanAlphabetError(
      WhatAdjustmentsHaveYouMadeToThisClaimPage.pageErrorMsgNonWesternChar,
      WhatAdjustmentsHaveYouMadeToThisClaimPage.adjustmentDetailsFieldLocator,
      WhatAdjustmentsHaveYouMadeToThisClaimPage.errorMsgLocator
    )
  }

  def validateParagraph(): Unit =
    WhatAdjustmentsHaveYouMadeToThisClaimPage.verifyParagraphText(
      WhatAdjustmentsHaveYouMadeToThisClaimPage.pageParagraph
    )

  def validatePageContent(): Unit =
    WhatAdjustmentsHaveYouMadeToThisClaimPage.verifyEntirePageContent(
      WhatAdjustmentsHaveYouMadeToThisClaimPage.createSingleStringFromMany(
        WhatAdjustmentsHaveYouMadeToThisClaimPage.pageHeading,
        // TODO revisit when form approach clarified
        WhatAdjustmentsHaveYouMadeToThisClaimPage.pageHeading,
        WhatAdjustmentsHaveYouMadeToThisClaimPage.pageParagraph,
        WhatAdjustmentsHaveYouMadeToThisClaimPage.pageHiddenHint,
        WhatAdjustmentsHaveYouMadeToThisClaimPage.pageCharacterCount,
        WhatAdjustmentsHaveYouMadeToThisClaimPage.pageHiddenCharacterCount,
        WhatAdjustmentsHaveYouMadeToThisClaimPage.btnContinue
      )
    )
}
