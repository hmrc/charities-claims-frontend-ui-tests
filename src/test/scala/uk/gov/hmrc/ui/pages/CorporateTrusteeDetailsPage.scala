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

  override def pageUrl: String = s"$hostname/corporate-trustee-details"

  override def pageTitle: String =
    "What are the corporate trustee details? - Charities - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeader: String =
    "What are the corporate trustee details?"

  def pageErrorMsgTrusteeName: String =
    "Enter a corporate trustee name"

  def pageErrorMsgTrusteePhoneNo: String =
    "Enter a corporate trustee phone number"

  def pageErrorMsgTrusteeUKPostcode: String =
    "Enter trustee postcode"

  def enterNonUKTrusteeDetails(trusteeName: String, trusteePhoneNo: String): Unit = {
    input(Locators.txtTrusteeName, trusteeName)
    input(Locators.txtTrusteePhoneNo, trusteePhoneNo)
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
        CorporateTrusteeDetailsPage.pageErrorMsgTrusteeUKPostcode
    )

  def validateNonUKAddressErrorMessages(): Unit =
    CorporateTrusteeDetailsPage.validateGenericPageError(
      CorporateTrusteeDetailsPage.pageErrorMsgTrusteeName + "\n" +
        CorporateTrusteeDetailsPage.pageErrorMsgTrusteePhoneNo
    )
}
