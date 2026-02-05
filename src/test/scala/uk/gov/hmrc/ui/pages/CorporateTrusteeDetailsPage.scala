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
import uk.gov.hmrc.ui.pages

object CorporateTrusteeDetailsPage extends BasePage {

  override def pageUrl: String = s"$hostname/corporate-trustee-details"

  override def pageTitle: String =
    "What are the corporate trustee details? - Charities - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeader: String =
    "What are the corporate trustee details?"

  val errorSummary = By.ByClassName("govuk-error-summary__body")

  // Name field
  def inputNameMaxLength  = 161
  val nameInputLocator    = By.ById("nameOfCorporateTrustee")
  val nameErrorMsgLocator = By.ById("nameOfCorporateTrustee-error")

  def pageErrorMsgTrusteeName: String =
    "Enter a corporate trustee name"

  def pageErrorMsgNameTooManyChars: String =
    "Corporate trustee name must be 160 characters or less"

  def pageErrorMsgNameNonWesternChar =
    "Enter a corporate trustee name in the correct format"

  // Phone field
  def inputPhoneMaxLength  = 36
  val phoneInputLocator    = By.ById("corporateTrusteeDaytimeTelephoneNumber")
  val phoneErrorMsgLocator = By.ById("corporateTrusteeDaytimeTelephoneNumber-error")

  def pageErrorMsgTrusteePhoneNo: String =
    "Enter a corporate trustee phone number"

  def pageErrorMsgPhoneTooManyChars: String =
    "Corporate trustee phone number must be 35 characters or less"

  def pageErrorMsgPhoneNonWesternChar =
    "Enter a corporate trustee phone number in the correct format"

  // Postcode field
  def inputPostcodeMaxLength  = 9
  val postcodeInputLocator    = By.ById("corporateTrusteePostcode")
  val postcodeErrorMsgLocator = By.ById("corporateTrusteePostcode-error")

  def pageErrorMsgTrusteeUKPostcode: String =
    "Enter a corporate trustee postcode"

  def pageErrorMsgPostcodeTooManyChars: String =
    "Corporate trustee postcode must be 8 characters or less"

  def pageErrorMsgPostcodeNonWesternChar =
    "Enter a corporate trustee postcode in the correct format"

  def enterNonUKTrusteeDetails(trusteeName: String, trusteePhoneNo: String): Unit = {
    input(Locators.txtTrusteeName, trusteeName)
    input(Locators.txtTrusteePhoneNo, trusteePhoneNo)
    clickContinue()
  }

  def enterUKTrusteeDetails(trusteeName: String, trusteePhoneNo: String, trusteePostcode: String): Unit = {
    input(Locators.txtTrusteeName, trusteeName)
    input(Locators.txtTrusteePhoneNo, trusteePhoneNo)
    input(Locators.txtTrusteePostcode, trusteePostcode)
    clickContinue()
  }

  def validateNavigation(): Unit = {
    CorporateTrusteeDetailsPage.verifyPageUrl(CorporateTrusteeDetailsPage.pageUrl)
    CorporateTrusteeDetailsPage.verifyPageTitle(CorporateTrusteeDetailsPage.pageTitle)
    CorporateTrusteeDetailsPage.verifyPageCaption(CorporateTrusteeDetailsPage.pageCaption)
    CorporateTrusteeDetailsPage.verifyPageHeader(CorporateTrusteeDetailsPage.pageHeader)
  }

  /** Validate that the error message is correct */
  def validateUKAddressErrorMessages(): Unit =
    CorporateTrusteeDetailsPage.validateGenericPageError(
      CorporateTrusteeDetailsPage.pageErrorMsgTrusteeName + "\n" +
        CorporateTrusteeDetailsPage.pageErrorMsgTrusteePhoneNo + "\n" +
        CorporateTrusteeDetailsPage.pageErrorMsgTrusteeUKPostcode,
      CorporateTrusteeDetailsPage.errorSummary
    )

  def validateNonUKAddressErrorMessages(): Unit =
    CorporateTrusteeDetailsPage.validateGenericPageError(
      CorporateTrusteeDetailsPage.pageErrorMsgTrusteeName + "\n" +
        CorporateTrusteeDetailsPage.pageErrorMsgTrusteePhoneNo,
      CorporateTrusteeDetailsPage.errorSummary
    )

    /** Validate that the error messages are correct */
  def validateCorporateTrusteeNameErrorMessages(): Unit =
    /** Number defines string length */
    CorporateTrusteeDetailsPage.triggerTooManyCharInputError(
      CorporateTrusteeDetailsPage.inputNameMaxLength,
      CorporateTrusteeDetailsPage.pageErrorMsgNameTooManyChars,
      CorporateTrusteeDetailsPage.nameInputLocator,
      CorporateTrusteeDetailsPage.nameErrorMsgLocator
    )
    CorporateTrusteeDetailsPage.triggerNonWesternEuropeanAlphabetError(
      CorporateTrusteeDetailsPage.pageErrorMsgNameNonWesternChar,
      CorporateTrusteeDetailsPage.nameInputLocator,
      CorporateTrusteeDetailsPage.nameErrorMsgLocator
    )

  def validateCorporateTrusteePhoneErrorMessages(): Unit =
    /** Number defines string length */
    CorporateTrusteeDetailsPage.triggerTooManyCharInputError(
      CorporateTrusteeDetailsPage.inputPhoneMaxLength,
      CorporateTrusteeDetailsPage.pageErrorMsgPhoneTooManyChars,
      CorporateTrusteeDetailsPage.phoneInputLocator,
      CorporateTrusteeDetailsPage.phoneErrorMsgLocator
    )
    CorporateTrusteeDetailsPage.triggerNonWesternEuropeanAlphabetError(
      CorporateTrusteeDetailsPage.pageErrorMsgPhoneNonWesternChar,
      CorporateTrusteeDetailsPage.phoneInputLocator,
      CorporateTrusteeDetailsPage.phoneErrorMsgLocator
    )

  def validateCorporateTrusteePostcodeErrorMessages(): Unit =
    /** Number defines string length */
    CorporateTrusteeDetailsPage.triggerTooManyCharInputError(
      CorporateTrusteeDetailsPage.inputPostcodeMaxLength,
      CorporateTrusteeDetailsPage.pageErrorMsgPostcodeTooManyChars,
      CorporateTrusteeDetailsPage.postcodeInputLocator,
      CorporateTrusteeDetailsPage.postcodeErrorMsgLocator
    )
    CorporateTrusteeDetailsPage.triggerNonWesternEuropeanAlphabetError(
      CorporateTrusteeDetailsPage.pageErrorMsgPostcodeNonWesternChar,
      CorporateTrusteeDetailsPage.postcodeInputLocator,
      CorporateTrusteeDetailsPage.postcodeErrorMsgLocator
    )
}
