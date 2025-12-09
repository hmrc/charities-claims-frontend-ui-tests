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

object CorporateTrusteePage extends BasePage {

  override def pageUrl: String = "s$hostname/corporate-trustee-claim"

  override def pageTitle: String = "Is a corporate trustee making this claim? - Charities - GOV.UK"

  def pageHeader: String = "Is a corporate trustee making this claim?"

  def pageCaption: String = "Provide organisation details"

  def pageParagraph: String = "This can be the trust department of a bank, a trust company or trust corporation"

  /* Error Messages To Be Confirmed */

  def pageErrorMsg: String = "Select if this claim is being made by a corporate trustee"

  /* Error Messages To Be Confirmed */

  val yes: String = "#value"
  val no: String  = "#value-no"

  def validateNavigation(): Unit = {
    CorporateTrusteePage.verifyPageUrl(CorporateTrusteePage.pageUrl)
    CorporateTrusteePage.verifyPageTitle(CorporateTrusteePage.pageTitle)
    CorporateTrusteePage.verifyPageHeader(CorporateTrusteePage.pageHeader)
    CorporateTrusteePage.verifyPageCaption(CorporateTrusteePage.pageCaption)
  }

  /* Error Messages To Be Confirmed */

  def validateErrorMessage(): Unit =
    CorporateTrusteePage.validateGenericPageError(CorporateTrusteePage.pageErrorMsg)

}
