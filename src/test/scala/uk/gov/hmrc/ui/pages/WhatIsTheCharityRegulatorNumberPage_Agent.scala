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
import uk.gov.hmrc.ui.pages

object WhatIsTheCharityRegulatorNumberPage_Agent extends BasePage {

  override def pageUrl: String = s"$hostname/about-the-organisation/enter-charity-regulator-number"

  override def pageTitle: String =
    "What is the charity regulator number? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeading: String =
    "What is the charity regulator number?"

  def pageHint: String =
    "This can be up to 20 numerical characters like 123456789 and does not include letters."

  def pageErrorMsg: String =
    "Enter a charity regulator number"

  def pageErrorMsgTooManyChars =
    "Enter a charity regulator number in the correct format"

  def inputMaxLength = 21

  val charityRegulatorNumberFieldLocator = By.ById("value")
  val errorMsgLocator                    = By.ById("value-error")

  def enterCharityRegulatorNumber(referenceNo: String): Unit = {
    input(Locators.inputReferenceNumber, referenceNo)
    clickContinue()
  }

  def validateNavigation(): Unit = {
    WhatIsYourCharityRegulatorNumberPage.verifyPageUrl(WhatIsYourCharityRegulatorNumberPage.pageUrl)
    WhatIsYourCharityRegulatorNumberPage.verifyPageTitle(WhatIsYourCharityRegulatorNumberPage.pageTitle)
    WhatIsYourCharityRegulatorNumberPage.verifyPageCaption(WhatIsYourCharityRegulatorNumberPage.pageCaption)
    WhatIsYourCharityRegulatorNumberPage.verifyPageHeading(WhatIsYourCharityRegulatorNumberPage.pageHeading)
  }

  def validateHint(): Unit =
    WhatIsYourCharityRegulatorNumberPage.verifyHintText(WhatIsYourCharityRegulatorNumberPage.pageHint)

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    WhatIsYourCharityRegulatorNumberPage.validateGenericPageError(
      WhatIsYourCharityRegulatorNumberPage.pageErrorMsg,
      WhatIsYourCharityRegulatorNumberPage.errorMsgLocator
    )

    /** Number defines string length */
    WhatIsYourCharityRegulatorNumberPage.triggerTooManyCharInputError(
      WhatIsYourCharityRegulatorNumberPage.inputMaxLength,
      WhatIsYourCharityRegulatorNumberPage.pageErrorMsgTooManyChars,
      WhatIsYourCharityRegulatorNumberPage.charityRegulatorNumberFieldLocator,
      WhatIsYourCharityRegulatorNumberPage.errorMsgLocator
    )
}
