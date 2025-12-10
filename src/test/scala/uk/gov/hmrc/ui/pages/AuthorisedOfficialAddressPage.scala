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

/* Page properties are to be confirmed, this is just provisional, will be amended when confirmed */
package uk.gov.hmrc.ui.pages

object AuthorisedOfficialAddressPage extends BasePage {
  override def pageUrl: String = s"$hostname/authorised-official-address"

  override def pageTitle: String =
    "Authorised official address - Charities - GOV.UK"

  def pageHeader: String =
    "Authorised official address"

  def pageCaption: String =
    "Provide organisation details"

  /* Error Messages To Be Confirmed */
  def pageErrorMsg: String =
    "Select if the authorised official has a UK address"

  val yes: String = "#Value"
  val no: String  = "#Value - No"

  def validateNavigation(): Unit = {
    AuthorisedOfficialAddressPage.verifyPageUrl(AuthorisedOfficialAddressPage.pageUrl)
    AuthorisedOfficialAddressPage.verifyPageTitle(AuthorisedOfficialAddressPage.pageTitle)
    AuthorisedOfficialAddressPage.verifyPageHeader(AuthorisedOfficialAddressPage.pageHeader)
    AuthorisedOfficialAddressPage.verifyPageCaption(AuthorisedOfficialAddressPage.pageCaption)
  }

  def validateErrorMessage(): Unit =
    AuthorisedOfficialAddressPage.validateGenericPageError(AuthorisedOfficialAddressPage.pageErrorMsg)

}
