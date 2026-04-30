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

object WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage extends BasePage {

  override def pageUrl: String = s"$hostname/adjustment-for-gift-aid-small-donations-scheme-overclaimed"

  def changePageUrl: String = s"$hostname/change-adjustment-for-gift-aid-small-donations-scheme-overclaimed"

  override def pageTitle: String =
    "What is the adjustment amount for Gift Aid previously overclaimed? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide GASDS donation details"

  def pageHeading: String =
    "What is the adjustment amount for Gift Aid previously overclaimed?"

  def pageHint: String =
    "This can be up to 2 decimal places, for example £1000.00"

  def pageErrorMsg: String =
    "Enter an adjustment amount for Gift Aid previously overclaimed"

  def pageErrorMsgTooManyChars =
    "Adjustment amount must be £1,000,000,000,000 or less"

  def pageErrorMsgNonWesternChar =
    "Enter an adjustment amount for Gift Aid previously overclaimed in the correct format"

  def inputMaxLength = 17

  val amountFieldLocator = By.ById("amount")
  val errorMsgLocator    = By.ById("amount-error")

  def enterAdjustmentAmountValue(amount: String): Unit = {
    input(Locators.inputAmount, amount)
    clickContinue()
  }

  def validateNavigation(): Unit = {
    WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.verifyPageUrl(
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.pageUrl
    )
    WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.verifyPageTitle(
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.pageTitle
    )
    WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.verifyPageCaption(
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.pageCaption
    )
    WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.verifyPageHeading(
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.pageHeading
    )
  }

  def validateChangeNavigation(): Unit = {
    WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.verifyPageUrl(
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.changePageUrl
    )
    WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.verifyPageTitle(
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.pageTitle
    )
    WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.verifyPageCaption(
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.pageCaption
    )
    WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.verifyPageHeading(
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.pageHeading
    )
  }

  def verifyAmountHintText(): Unit =
    WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.verifyAmountHintText(
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.pageHint
    )

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit = {
    WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.validateGenericPageError(
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.pageErrorMsg,
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.errorMsgLocator
    )

    /** Number defines string length */
    WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.triggerTooManyCharInputError(
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.inputMaxLength,
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.pageErrorMsgTooManyChars,
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.amountFieldLocator,
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.errorMsgLocator
    )

    WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.triggerNonWesternEuropeanAlphabetError(
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.pageErrorMsgNonWesternChar,
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.amountFieldLocator,
      WhatIsTheAdjustmentAmountForGiftAidPreviouslyOverclaimedPage.errorMsgLocator
    )
  }
}
