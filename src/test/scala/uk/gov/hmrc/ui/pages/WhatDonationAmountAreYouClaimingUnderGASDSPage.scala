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

object WhatDonationAmountAreYouClaimingUnderGASDSPage extends BasePage {

  override def pageUrl: String = s"$hostname/donation-amount-you-are-claiming"

  override def pageTitle: String =
    "What donation amount are you claiming under GASDS, in pounds? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide GASDS donation details"

  def pageHeading: String =
    "What donation amount are you claiming under GASDS, in pounds?"

  def pageHint: String =
    "This can be up to 2 decimal places, for example £1000.00"

  def pageErrorMsg_Year1: String =
    "Enter a first tax year amount"

  def pageErrorMsg_Year2: String =
    "Enter a second tax year amount"

  def pageErrorMsg_Year3: String =
    "Enter a third tax year amount"

  def pageErrorMsgTooManyChars =
    "Donation amount must be £1,000,000,000,000 or less"

  def pageErrorMsgNonWesternChar_Year1 =
    "Enter a first tax year amount in the correct format"

  def pageErrorMsgNonWesternChar_Year2 =
    "Enter a second tax year amount in the correct format"

  def pageErrorMsgNonWesternChar_Year3 =
    "Enter a third tax year amount in the correct format"

  def inputMaxLength = 17

  val amountFieldLocator = By.ById("amount")
  val errorMsgLocator    = By.ById("amount-error")

  def enterClaimReferenceNumber(referenceNo: String): Unit = {
    input(Locators.inputReferenceNumber, referenceNo)
    clickContinue()
  }

  def validateNavigation_Year1(): Unit = {
    WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyPageUrl(WhatDonationAmountAreYouClaimingUnderGASDSPage.pageUrl + "/1")
    WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyPageTitle(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageTitle
    )
    WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyPageCaption(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageCaption
    )
    WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyPageHeading(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageHeading
    )
  }

  def validateNavigation_Year2(): Unit = {
    WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyPageUrl(WhatDonationAmountAreYouClaimingUnderGASDSPage.pageUrl + "/2")
    WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyPageTitle(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageTitle
    )
    WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyPageCaption(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageCaption
    )
    WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyPageHeading(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageHeading
    )
  }

  def validateNavigation_Year3(): Unit = {
    WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyPageUrl(WhatDonationAmountAreYouClaimingUnderGASDSPage.pageUrl + "/3")
    WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyPageTitle(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageTitle
    )
    WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyPageCaption(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageCaption
    )
    WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyPageHeading(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageHeading
    )
  }

  def verifyAmountHintText(): Unit =
    WhatDonationAmountAreYouClaimingUnderGASDSPage.verifyAmountHintText(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageHint
    )

  /** Validate that the error message is correct */
  def validateErrorMessage_Year1(): Unit = {
    WhatDonationAmountAreYouClaimingUnderGASDSPage.validateGenericPageError(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageErrorMsg_Year1,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.errorMsgLocator
    )

    /** Number defines string length */
    WhatDonationAmountAreYouClaimingUnderGASDSPage.triggerTooManyCharInputError(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.inputMaxLength,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageErrorMsgTooManyChars,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.amountFieldLocator,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.errorMsgLocator
    )

    WhatDonationAmountAreYouClaimingUnderGASDSPage.triggerNonWesternEuropeanAlphabetError(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageErrorMsgNonWesternChar_Year1,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.amountFieldLocator,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.errorMsgLocator
    )
  }

  def validateErrorMessage_Year2(): Unit = {
    WhatDonationAmountAreYouClaimingUnderGASDSPage.validateGenericPageError(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageErrorMsg_Year2,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.errorMsgLocator
    )

    /** Number defines string length */
    WhatDonationAmountAreYouClaimingUnderGASDSPage.triggerTooManyCharInputError(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.inputMaxLength,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageErrorMsgTooManyChars,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.amountFieldLocator,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.errorMsgLocator
    )

    WhatDonationAmountAreYouClaimingUnderGASDSPage.triggerNonWesternEuropeanAlphabetError(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageErrorMsgNonWesternChar_Year2,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.amountFieldLocator,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.errorMsgLocator
    )
  }

  def validateErrorMessage_Year3(): Unit = {
    WhatDonationAmountAreYouClaimingUnderGASDSPage.validateGenericPageError(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageErrorMsg_Year3,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.errorMsgLocator
    )

    /** Number defines string length */
    WhatDonationAmountAreYouClaimingUnderGASDSPage.triggerTooManyCharInputError(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.inputMaxLength,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageErrorMsgTooManyChars,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.amountFieldLocator,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.errorMsgLocator
    )

    WhatDonationAmountAreYouClaimingUnderGASDSPage.triggerNonWesternEuropeanAlphabetError(
      WhatDonationAmountAreYouClaimingUnderGASDSPage.pageErrorMsgNonWesternChar_Year3,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.amountFieldLocator,
      WhatDonationAmountAreYouClaimingUnderGASDSPage.errorMsgLocator
    )
  }
}
