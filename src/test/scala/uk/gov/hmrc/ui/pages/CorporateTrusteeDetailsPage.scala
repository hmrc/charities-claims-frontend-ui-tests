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

object CorporateTrusteeDetailsPage extends BasePage {

  override def pageUrl: String = s"$hostname/charity-regulator-number"

  override def pageTitle: String =
    "What is the charity regulator number? - Charities - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeader: String =
    "What is the charity regulator number?"

  def pageHint: String =
    "This can be up to 20 numerical characters like 123456789 and does not include letters."

  def pageErrorMsg: String =
    "Enter a charity regulator number"

  def pageErrorMsgTooManyChars =
    "Enter a charity regulator number in the correct format"

  def inputMaxLength = 21

  def enterClaimReferenceNumber(referenceNo: String): Unit = {
    input(Locators.inputReferenceNumber, referenceNo)
    clickContinue()
  }

  def validateNavigation(): Unit = {
    WhatIsYourCharityRegulatorNumberPage.verifyPageUrl(WhatIsYourCharityRegulatorNumberPage.pageUrl)
    WhatIsYourCharityRegulatorNumberPage.verifyPageTitle(WhatIsYourCharityRegulatorNumberPage.pageTitle)
    WhatIsYourCharityRegulatorNumberPage.verifyPageCaption(WhatIsYourCharityRegulatorNumberPage.pageCaption)
    WhatIsYourCharityRegulatorNumberPage.verifyPageHeader(WhatIsYourCharityRegulatorNumberPage.pageHeader)
  }

  def validateHint(): Unit =
    WhatIsYourCharityRegulatorNumberPage.verifyHintText(WhatIsYourCharityRegulatorNumberPage.pageHint)

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    WhatIsYourCharityRegulatorNumberPage.validateGenericPageError(WhatIsYourCharityRegulatorNumberPage.pageErrorMsg)

    /** Number defines string length */
    WhatIsYourCharityRegulatorNumberPage.triggerTooManyCharInputtedError(
      WhatIsYourCharityRegulatorNumberPage.inputMaxLength,
      WhatIsYourCharityRegulatorNumberPage.pageErrorMsgTooManyChars
    )
}
