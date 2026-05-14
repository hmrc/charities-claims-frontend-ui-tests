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

object WhatIsYourHMRCReferenceNumberPage extends BasePage {

  override def pageUrl: String = s"$hostname/enter-charities-reference-number"

  def changePageUrl: String = s"$hostname/change-charities-reference-number"

  override def pageTitle: String =
    "What is the HMRC charities reference number? - Make a charity tax repayment claim - GOV.UK"

  def pageTitleAgent: String =
    "What is the HMRC charities reference number? - Make a charity tax repayment claim - GOV.UK"

  def pageCaptionAgent: String =
    "Provide charity repayment claim details"

  def pageHeadingAgent: String =
    "What is the HMRC charities reference number?"

  def pageHint: String =
    "This will begin with either one or two letters from A to Z and can include up to 5 numbers like 12345. For example, CF10034."

  def pageErrorMsg: String =
    "Enter a HMRC charities reference number"

  def pageErrorMsgTooManyChars =
    "HMRC charities reference number must be 7 characters or less"

  def pageErrorMsgNonWesternChar =
    "Enter an HMRC charities reference number in the correct format"

  def pageErrorInvalidFormat =
    "Enter an HMRC charities reference number in the correct format"

  def pageErrorClaimAlreadyExists =
    "You have already created a claim for HMRC ref"

  def inputMaxLength = 8

  val charitiesReferenceNumberFieldLocator = By.ById("value")
  val errorMsgLocator                      = By.ById("value-error")

  def enterCharitiesReferenceNumber(referenceNo: String): Unit = {
    input(Locators.inputReferenceNumber, referenceNo)
    clickContinue()
  }

  def validateNavigationAgent(): Unit = {
    WhatIsYourHMRCReferenceNumberPage.verifyPageUrl(WhatIsYourHMRCReferenceNumberPage.pageUrl)
    WhatIsYourHMRCReferenceNumberPage.verifyPageTitle(WhatIsYourHMRCReferenceNumberPage.pageTitleAgent)
    WhatIsYourHMRCReferenceNumberPage.verifyPageCaption(WhatIsYourHMRCReferenceNumberPage.pageCaptionAgent)
    WhatIsYourHMRCReferenceNumberPage.verifyPageHeading(WhatIsYourHMRCReferenceNumberPage.pageHeadingAgent)
  }

  def validateHintAgent(): Unit =
    WhatIsYourHMRCReferenceNumberPage.verifyHintText(WhatIsYourHMRCReferenceNumberPage.pageHint)

  /** To add this error validation in Journey Spec not pages spec */
  def validateErrorMessageClaimAlreadyExists(): Unit =
    WhatIsYourHMRCReferenceNumberPage.validateGenericPageError(
      WhatIsYourHMRCReferenceNumberPage.pageErrorClaimAlreadyExists,
      WhatIsYourHMRCReferenceNumberPage.errorMsgLocator
    )

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit = {
    WhatIsYourHMRCReferenceNumberPage.validateGenericPageError(
      WhatIsYourHMRCReferenceNumberPage.pageErrorMsg,
      WhatIsYourHMRCReferenceNumberPage.errorMsgLocator
    )

    /** Number defines string length */
    WhatIsYourHMRCReferenceNumberPage.triggerTooManyCharInputError(
      WhatIsYourHMRCReferenceNumberPage.inputMaxLength,
      WhatIsYourHMRCReferenceNumberPage.pageErrorMsgTooManyChars,
      WhatIsYourHMRCReferenceNumberPage.charitiesReferenceNumberFieldLocator,
      WhatIsYourHMRCReferenceNumberPage.errorMsgLocator
    )
    WhatIsYourHMRCReferenceNumberPage.triggerNonWesternEuropeanAlphabetError(
      WhatIsYourHMRCReferenceNumberPage.pageErrorMsgNonWesternChar,
      WhatIsYourHMRCReferenceNumberPage.charitiesReferenceNumberFieldLocator,
      WhatIsYourHMRCReferenceNumberPage.errorMsgLocator
    )
  }

  def validateWrongFormatErrorMessage(expectedErrorMessage: String, errorMsgLocatorValue: By): Unit = {
    val errorMessage       = s"$expectedErrorMessage"
    waitForVisibilityOfElement(By.xpath(Locators.btnContinue))
    enterCharitiesReferenceNumber("12345")
    waitForVisibilityOfElement(Locators.errorSummary)
    // Error title indicator
    assert(
      driver.getTitle.contains("Error:"),
      s"Page title mismatch! Expected: Error: ${driver.getTitle} , Actual: ${driver.getTitle}"
    )
    // Error summary - top of page
    val actualErrorSummary = driver.findElement(Locators.errorSummary).getText
    assert(
      actualErrorSummary contains errorMessage,
      s"Page error summary mismatch! Expected: $errorMessage, Actual: $actualErrorSummary"
    )
    println("Actual error summary is: " + actualErrorSummary)
    // Error message - above erroring field
    val actualErrorMsg     = driver.findElement(errorMsgLocatorValue).getText
    assert(
      actualErrorMsg contains errorMessage,
      s"Page error message mismatch! Expected: $errorMessage, Actual: $actualErrorMsg"
    )
    println("Actual error message is: " + actualErrorMsg)
  }

}
