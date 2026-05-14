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

object WhatIsYourClaimReferenceNumberPage extends BasePage {

  override def pageUrl: String = s"$hostname/enter-claim-reference-number"

  def changePageUrl: String = s"$hostname/change-enter-claim-reference-number"

  override def pageTitle: String =
    "What is your claim reference number? - Make a charity tax repayment claim - GOV.UK"

  def pageTitleAgent: String =
    "What is the charity’s claim reference number? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageCaptionAgent: String =
    "Provide charity repayment claim details"

  def pageHeading: String =
    "What is your claim reference number?"

  def pageHeadingAgent: String =
    "What is the charity’s claim reference number?"

  def pageHint: String =
    "This can be up to 20 characters and include numerical characters like 123456789 and letters from A to Z. It can be found on the payment advice note when the claim is paid."

  def pageErrorMsg: String =
    "Enter your claim reference number"

  def pageErrorMsgTooManyChars =
    "Claim reference number must be 20 characters or less"

  def pageErrorMsgNonWesternChar =
    "This can be up to 20 characters including numbers and capital letters"

  def inputMaxLength = 21

  val claimReferenceNumberFieldLocator = By.ById("value")
  val errorMsgLocator                  = By.ById("value-error")

  def enterClaimReferenceNumber(referenceNo: String): Unit = {
    input(Locators.inputReferenceNumber, referenceNo)
    clickContinue()
  }

  def validateNavigation(): Unit = {
    WhatIsYourClaimReferenceNumberPage.verifyPageUrl(WhatIsYourClaimReferenceNumberPage.pageUrl)
    WhatIsYourClaimReferenceNumberPage.verifyPageTitle(WhatIsYourClaimReferenceNumberPage.pageTitle)
    WhatIsYourClaimReferenceNumberPage.verifyPageCaption(WhatIsYourClaimReferenceNumberPage.pageCaption)
    WhatIsYourClaimReferenceNumberPage.verifyPageHeading(WhatIsYourClaimReferenceNumberPage.pageHeading)
  }

  def validateNavigationAgent(): Unit = {
    WhatIsYourClaimReferenceNumberPage.verifyPageUrl(WhatIsYourClaimReferenceNumberPage.pageUrl)
    WhatIsYourClaimReferenceNumberPage.verifyPageTitle(WhatIsYourClaimReferenceNumberPage.pageTitleAgent)
    WhatIsYourClaimReferenceNumberPage.verifyPageCaption(WhatIsYourClaimReferenceNumberPage.pageCaptionAgent)
    WhatIsYourClaimReferenceNumberPage.verifyPageHeading(WhatIsYourClaimReferenceNumberPage.pageHeadingAgent)
  }

  def validateHint(): Unit =
    WhatIsYourClaimReferenceNumberPage.verifyHintText(WhatIsYourClaimReferenceNumberPage.pageHint)

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit = {
    WhatIsYourClaimReferenceNumberPage.validateGenericPageError(
      WhatIsYourClaimReferenceNumberPage.pageErrorMsg,
      WhatIsYourClaimReferenceNumberPage.errorMsgLocator
    )

    /** Number defines string length */
    WhatIsYourClaimReferenceNumberPage.triggerTooManyCharInputError(
      WhatIsYourClaimReferenceNumberPage.inputMaxLength,
      WhatIsYourClaimReferenceNumberPage.pageErrorMsgTooManyChars,
      WhatIsYourClaimReferenceNumberPage.claimReferenceNumberFieldLocator,
      WhatIsYourClaimReferenceNumberPage.errorMsgLocator
    )
    WhatIsYourClaimReferenceNumberPage.triggerNonWesternEuropeanAlphabetError(
      WhatIsYourClaimReferenceNumberPage.pageErrorMsgNonWesternChar,
      WhatIsYourClaimReferenceNumberPage.claimReferenceNumberFieldLocator,
      WhatIsYourClaimReferenceNumberPage.errorMsgLocator
    )
  }
}
