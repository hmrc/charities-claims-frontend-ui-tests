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

object AuthorisedOfficialDetailsPage extends BasePage {

  override def pageUrl: String = s"$hostname/authorised-official-details"

  def changePageUrl: String = s"$hostname/change-authorised-official-details"

  override def pageTitle: String =
    "What are the authorised official details? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeading: String =
    "What are the authorised official details?"

  val errorSummary = By.ByClassName("govuk-error-summary__body")

  // Title field
  def inputTitleMaxLength  = 5
  val titleInputLocator    = By.ById("title")
  val titleErrorMsgLocator = By.ById("title-error")

  def pageErrorMsgTitleTooManyChars: String =
    "Authorised official title must be 4 characters or less"

  def pageErrorMsgTitleNonWesternChar =
    "Enter an authorised official title in the correct format"

  // Forename field
  def inputForenameMaxLength  = 36
  val forenameInputLocator    = By.ById("firstName")
  val forenameErrorMsgLocator = By.ById("firstName-error")

  def pageErrorMsgAuthOfficialForename: String =
    "Enter an authorised official first name"

  def pageErrorMsgForenameTooManyChars: String =
    "Authorised official first name must be 35 characters or less"

  def pageErrorMsgForenameNonWesternChar =
    "Enter an authorised official first name in the correct format"

  // Surname field
  def inputSurnameMaxLength  = 36
  val surnameInputLocator    = By.ById("lastName")
  val surnameErrorMsgLocator = By.ById("lastName-error")

  def pageErrorMsgAuthOfficialSurname: String =
    "Enter an authorised official last name"

  def pageErrorMsgSurnameTooManyChars: String =
    "Authorised official last name must be 35 characters or less"

  def pageErrorMsgSurnameNonWesternChar =
    "Enter an authorised official last name in the correct format"

  // Phone number field
  def inputPhoneNoMaxLength  = 36
  val phoneNoInputLocator    = By.ById("phoneNumber")
  val phoneNoErrorMsgLocator = By.ById("phoneNumber-error")

  def pageErrorMsgAuthOfficialPhoneNo: String =
    "Enter an authorised official phone number"

  def pageErrorMsgPhoneNoTooManyChars: String =
    "Authorised official phone number must be 35 characters or less"

  def pageErrorMsgPhoneNoNonWesternChar =
    "Enter an authorised official phone number in the correct format"

  // Postcode field
  def inputPostcodeMaxLength  = 9
  val postcodeInputLocator    = By.ById("postcode")
  val postcodeErrorMsgLocator = By.ById("postcode-error")

  def pageErrorMsgAuthOfficialUKPostcode: String =
    "Enter an authorised official postcode"

  def pageErrorMsgPostcodeTooManyChars: String =
    "Authorised official postcode must be 8 characters or less"

  def pageErrorMsgPostcodeNonWesternChar =
    "Enter an authorised official postcode in the correct format"

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

  def enterNonUKAuthOfficialDetails(
    authOfficialTitle: String,
    authOfficialForename: String,
    authOfficialSurname: String,
    authOfficialPhoneNo: String
  ): Unit = {
    input(Locators.txtAuthOfficialTitle, authOfficialTitle)
    input(Locators.txtAuthOfficialForename, authOfficialForename)
    input(Locators.txtAuthOfficialSurname, authOfficialSurname)
    input(Locators.txtAuthOfficialPhoneNo, authOfficialPhoneNo)
    clickContinue()
  }

  def validateNavigation(): Unit = {
    AuthorisedOfficialDetailsPage.verifyPageUrl(AuthorisedOfficialDetailsPage.pageUrl)
    AuthorisedOfficialDetailsPage.verifyPageTitle(AuthorisedOfficialDetailsPage.pageTitle)
    AuthorisedOfficialDetailsPage.verifyPageCaption(AuthorisedOfficialDetailsPage.pageCaption)
    AuthorisedOfficialDetailsPage.verifyPageHeading(AuthorisedOfficialDetailsPage.pageHeading)
  }

  def validateChangeNavigation(): Unit = {
    AuthorisedOfficialDetailsPage.verifyPageUrl(AuthorisedOfficialDetailsPage.changePageUrl)
    AuthorisedOfficialDetailsPage.verifyPageTitle(AuthorisedOfficialDetailsPage.pageTitle)
    AuthorisedOfficialDetailsPage.verifyPageCaption(AuthorisedOfficialDetailsPage.pageCaption)
    AuthorisedOfficialDetailsPage.verifyPageHeading(AuthorisedOfficialDetailsPage.pageHeading)
  }

  /** Validate that the error message is correct */
  def validateUKAddressErrorMessages(): Unit =
    AuthorisedOfficialDetailsPage.validateGenericPageError(
      AuthorisedOfficialDetailsPage.pageErrorMsgAuthOfficialForename + "\n" +
        AuthorisedOfficialDetailsPage.pageErrorMsgAuthOfficialSurname + "\n" +
        AuthorisedOfficialDetailsPage.pageErrorMsgAuthOfficialPhoneNo + "\n" +
        AuthorisedOfficialDetailsPage.pageErrorMsgAuthOfficialUKPostcode,
      AuthorisedOfficialDetailsPage.errorSummary
    )

  def validateNonUKAddressErrorMessages(): Unit =
    AuthorisedOfficialDetailsPage.validateGenericPageError(
      AuthorisedOfficialDetailsPage.pageErrorMsgAuthOfficialForename + "\n" +
        AuthorisedOfficialDetailsPage.pageErrorMsgAuthOfficialSurname + "\n" +
        AuthorisedOfficialDetailsPage.pageErrorMsgAuthOfficialPhoneNo,
      AuthorisedOfficialDetailsPage.errorSummary
    )

  /** Validate that the error messages are correct */
  def validateAuthOfficialTitleErrorMessages(): Unit =

    /** Number defines string length */
    AuthorisedOfficialDetailsPage.triggerTooManyCharInputError(
      AuthorisedOfficialDetailsPage.inputTitleMaxLength,
      AuthorisedOfficialDetailsPage.pageErrorMsgTitleTooManyChars,
      AuthorisedOfficialDetailsPage.titleInputLocator,
      AuthorisedOfficialDetailsPage.titleErrorMsgLocator
    )

    AuthorisedOfficialDetailsPage.triggerNonWesternEuropeanAlphabetError(
      AuthorisedOfficialDetailsPage.pageErrorMsgTitleNonWesternChar,
      AuthorisedOfficialDetailsPage.titleInputLocator,
      AuthorisedOfficialDetailsPage.titleErrorMsgLocator
    )

  def validateAuthOfficialForenameErrorMessages(): Unit =

    /** Number defines string length */
    AuthorisedOfficialDetailsPage.triggerTooManyCharInputError(
      AuthorisedOfficialDetailsPage.inputForenameMaxLength,
      AuthorisedOfficialDetailsPage.pageErrorMsgForenameTooManyChars,
      AuthorisedOfficialDetailsPage.forenameInputLocator,
      AuthorisedOfficialDetailsPage.forenameErrorMsgLocator
    )

    AuthorisedOfficialDetailsPage.triggerNonWesternEuropeanAlphabetError(
      AuthorisedOfficialDetailsPage.pageErrorMsgForenameNonWesternChar,
      AuthorisedOfficialDetailsPage.forenameInputLocator,
      AuthorisedOfficialDetailsPage.forenameErrorMsgLocator
    )

  def validateAuthOfficialSurnameErrorMessages(): Unit =

    /** Number defines string length */
    AuthorisedOfficialDetailsPage.triggerTooManyCharInputError(
      AuthorisedOfficialDetailsPage.inputSurnameMaxLength,
      AuthorisedOfficialDetailsPage.pageErrorMsgSurnameTooManyChars,
      AuthorisedOfficialDetailsPage.surnameInputLocator,
      AuthorisedOfficialDetailsPage.surnameErrorMsgLocator
    )

    AuthorisedOfficialDetailsPage.triggerNonWesternEuropeanAlphabetError(
      AuthorisedOfficialDetailsPage.pageErrorMsgSurnameNonWesternChar,
      AuthorisedOfficialDetailsPage.surnameInputLocator,
      AuthorisedOfficialDetailsPage.surnameErrorMsgLocator
    )

  def validateAuthOfficialPhoneNoErrorMessages(): Unit =

    /** Number defines string length */
    AuthorisedOfficialDetailsPage.triggerTooManyCharInputError(
      AuthorisedOfficialDetailsPage.inputPhoneNoMaxLength,
      AuthorisedOfficialDetailsPage.pageErrorMsgPhoneNoTooManyChars,
      AuthorisedOfficialDetailsPage.phoneNoInputLocator,
      AuthorisedOfficialDetailsPage.phoneNoErrorMsgLocator
    )

    AuthorisedOfficialDetailsPage.triggerNonWesternEuropeanAlphabetError(
      AuthorisedOfficialDetailsPage.pageErrorMsgPhoneNoNonWesternChar,
      AuthorisedOfficialDetailsPage.phoneNoInputLocator,
      AuthorisedOfficialDetailsPage.phoneNoErrorMsgLocator
    )

  def validateAuthOfficialPostcodeErrorMessages(): Unit =

    /** Number defines string length */
    AuthorisedOfficialDetailsPage.triggerTooManyCharInputError(
      AuthorisedOfficialDetailsPage.inputPostcodeMaxLength,
      AuthorisedOfficialDetailsPage.pageErrorMsgPostcodeTooManyChars,
      AuthorisedOfficialDetailsPage.postcodeInputLocator,
      AuthorisedOfficialDetailsPage.postcodeErrorMsgLocator
    )

    AuthorisedOfficialDetailsPage.triggerNonWesternEuropeanAlphabetError(
      AuthorisedOfficialDetailsPage.pageErrorMsgPostcodeNonWesternChar,
      AuthorisedOfficialDetailsPage.postcodeInputLocator,
      AuthorisedOfficialDetailsPage.postcodeErrorMsgLocator
    )
}
