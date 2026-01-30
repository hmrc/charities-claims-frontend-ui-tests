/*
 * Copyright 2023 HM Revenue & Customs
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

object WhatIsYourClaimReferenceNumberPage_OLD extends BasePage {

  override def pageUrl: String = s"$hostname/old/your-claim-reference-number"

  override def pageTitle: String =
    "What is your claim reference number? - Charities - GOV.UK"

  def pageHeader: String =
    "What is your claim reference number?"

  def pageParagraph: String =
    "You do not have to complete this box but you can use it to show your claim reference if you use one. The reference that you quote will appear on the payment advice note you receive from us when we pay the claim."

  def pageErrorMsg: String =
    "Enter your claim reference number"

  def pageErrorMsgTooManyChars =
    "Claim reference number must be 20 characters or less"

  def pageErrorMsgNonWesternChar =
    "Include characters from Western European alphabets"

  def inputMaxLength = 21

  val claimReferenceNumberFieldLocator = By.ById("value")
  val errorMsgLocator                  = By.ById("value-error")

  def enterClaimReferenceNumber(referenceNo: String): Unit = {
    input(Locators.inputReferenceNumber, referenceNo)
    clickContinue()
  }

  def validateNavigation(): Unit = {
    WhatIsYourClaimReferenceNumberPage_OLD.verifyPageUrl(WhatIsYourClaimReferenceNumberPage_OLD.pageUrl)
    WhatIsYourClaimReferenceNumberPage_OLD.verifyPageTitle(WhatIsYourClaimReferenceNumberPage_OLD.pageTitle)
    WhatIsYourClaimReferenceNumberPage_OLD.verifyPageHeader(WhatIsYourClaimReferenceNumberPage_OLD.pageHeader)
  }

  def validateParagraph(): Unit =
    WhatIsYourClaimReferenceNumberPage_OLD.verifyParagraphText(WhatIsYourClaimReferenceNumberPage_OLD.pageParagraph)

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit = {
    WhatIsYourClaimReferenceNumberPage_OLD.validateGenericPageError(
      WhatIsYourClaimReferenceNumberPage_OLD.pageErrorMsg,
      WhatIsYourClaimReferenceNumberPage_OLD.errorMsgLocator
    )

    /** Number defines string length */
    WhatIsYourClaimReferenceNumberPage_OLD.triggerTooManyCharInputError(
      WhatIsYourClaimReferenceNumberPage_OLD.inputMaxLength,
      WhatIsYourClaimReferenceNumberPage_OLD.pageErrorMsgTooManyChars,
      WhatIsYourClaimReferenceNumberPage_OLD.claimReferenceNumberFieldLocator,
      WhatIsYourClaimReferenceNumberPage_OLD.errorMsgLocator
    )
    WhatIsYourClaimReferenceNumberPage_OLD.triggerNonWesternEuropeanAlphabetError(
      WhatIsYourClaimReferenceNumberPage_OLD.pageErrorMsgNonWesternChar,
      WhatIsYourClaimReferenceNumberPage_OLD.claimReferenceNumberFieldLocator,
      WhatIsYourClaimReferenceNumberPage_OLD.errorMsgLocator
    )
  }
}
