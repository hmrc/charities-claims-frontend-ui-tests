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

object AuthorisedOfficialDetailsPage extends BasePage {

  override def pageUrl: String = s"$hostname/authorised-official-details"

  override def pageTitle: String =
    "What are the authorised official details? - Charities - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeader: String =
    "What are the authorised official details?"

  def pageErrorMsgAuthOfficialForename: String =
    "Enter a authorised official first name"

  def pageErrorMsgAuthOfficialSurname: String =
    "Enter a authorised official last name"

  def pageErrorMsgAuthOfficialPhoneNo: String =
    "Enter a authorised official phone number"

  def pageErrorMsgAuthOfficialUKPostcode: String =
    "Enter a authorised official postcode"

  def enterUKAuthOfficialDetails(
    authOfficialTitle: String,
    authOfficialForename: String,
    authOfficialSurname: String,
    authOfficialPhoneNo: String,
    authOfficialPostcode: String
  ): Unit = {
    input(Locators.txtAuthOfficialTitle, authOfficialTitle)
    input(Locators.txtAuthOfficialForename, authOfficialForename)
    input(Locators.txtAuthOfficialSurname, authOfficialSurname)
    input(Locators.txtAuthOfficialPhoneNo, authOfficialPhoneNo)
    input(Locators.txtAuthOfficialPostcode, authOfficialPostcode)
    clickContinue()
  }

  def validateNavigation(): Unit = {
    AuthorisedOfficialDetailsPage.verifyPageUrl(AuthorisedOfficialDetailsPage.pageUrl)
    AuthorisedOfficialDetailsPage.verifyPageTitle(AuthorisedOfficialDetailsPage.pageTitle)
    AuthorisedOfficialDetailsPage.verifyPageCaption(AuthorisedOfficialDetailsPage.pageCaption)
    AuthorisedOfficialDetailsPage.verifyPageHeader(AuthorisedOfficialDetailsPage.pageHeader)
  }

  /** Validate that the error message is correct */
  def validateUKAddressErrorMessages(): Unit =
    AuthorisedOfficialDetailsPage.validateGenericPageError(
      AuthorisedOfficialDetailsPage.pageErrorMsgAuthOfficialForename + "\n" +
        AuthorisedOfficialDetailsPage.pageErrorMsgAuthOfficialSurname + "\n" +
        AuthorisedOfficialDetailsPage.pageErrorMsgAuthOfficialPhoneNo + "\n" +
        AuthorisedOfficialDetailsPage.pageErrorMsgAuthOfficialUKPostcode
    )

  def validateNonUKAddressErrorMessages(): Unit =
    AuthorisedOfficialDetailsPage.validateGenericPageError(
      AuthorisedOfficialDetailsPage.pageErrorMsgAuthOfficialForename + "\n" +
        AuthorisedOfficialDetailsPage.pageErrorMsgAuthOfficialSurname + "\n" +
        AuthorisedOfficialDetailsPage.pageErrorMsgAuthOfficialPhoneNo
    )
}
