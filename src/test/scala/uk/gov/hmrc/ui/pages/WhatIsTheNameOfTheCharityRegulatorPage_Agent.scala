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

object WhatIsTheNameOfTheCharityRegulatorPage_Agent extends BasePage {

  override def pageUrl: String = s"$hostname/about-the-organisation/name-of-charity-regulator"

  override def pageTitle: String =
    "What is the name of the charity regulator? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeading: String =
    "What is the name of the charity regulator?"

  def pageErrorMsg: String =
    "Select the name of the charity regulator"

  val EngWal: String  = "#value"
  val Ire: String     = "#NorthernIreland"
  val None: String    = "#None"
  val Scot: String    = "#Scottish"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    WhatIsTheNameOfTheCharityRegulatorPage_Agent.verifyPageUrl(WhatIsTheNameOfTheCharityRegulatorPage_Agent.pageUrl)
    WhatIsTheNameOfTheCharityRegulatorPage_Agent.verifyPageTitle(WhatIsTheNameOfTheCharityRegulatorPage_Agent.pageTitle)
    WhatIsTheNameOfTheCharityRegulatorPage_Agent.verifyPageCaption(WhatIsTheNameOfTheCharityRegulatorPage_Agent.pageCaption)
    WhatIsTheNameOfTheCharityRegulatorPage_Agent.verifyPageHeading(WhatIsTheNameOfTheCharityRegulatorPage_Agent.pageHeading)
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    WhatIsTheNameOfTheCharityRegulatorPage_Agent.validateGenericPageError(
      WhatIsTheNameOfTheCharityRegulatorPage_Agent.pageErrorMsg,
      WhatIsTheNameOfTheCharityRegulatorPage_Agent.errorMsgLocator
    )
}
