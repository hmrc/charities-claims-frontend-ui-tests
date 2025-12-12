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

object WhatIsTheNameOfTheCharityRegulatorPage extends BasePage {

  override def pageUrl: String = s"$hostname/name-of-charity-regulator"

  override def pageTitle: String =
    "What is the name of the charity regulator? - Charities - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeader: String =
    "What is the name of the charity regulator?"

  def pageErrorMsg: String =
    "Select the name of the charity regulator"

  val EngWal: String = "#EnglandAndWales"
  val Ire: String    = "#NorthernIreland"
  val None: String   = "#None"
  val Scot: String   = "#Scottish"

  def validateNavigation(): Unit = {
    WhatIsTheNameOfTheCharityRegulatorPage.verifyPageUrl(WhatIsTheNameOfTheCharityRegulatorPage.pageUrl)
    WhatIsTheNameOfTheCharityRegulatorPage.verifyPageTitle(WhatIsTheNameOfTheCharityRegulatorPage.pageTitle)
    WhatIsTheNameOfTheCharityRegulatorPage.verifyPageCaption(WhatIsTheNameOfTheCharityRegulatorPage.pageCaption)
    WhatIsTheNameOfTheCharityRegulatorPage.verifyPageHeader(WhatIsTheNameOfTheCharityRegulatorPage.pageHeader)
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    WhatIsTheNameOfTheCharityRegulatorPage.validateGenericPageError(WhatIsTheNameOfTheCharityRegulatorPage.pageErrorMsg)
}
