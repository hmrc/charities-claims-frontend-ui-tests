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

object DoesTheCorporateTrusteeHaveAUKAddressPage extends BasePage {
  override def pageUrl: String = s"$hostname/corporate-trustee-address"

  def changePageUrl: String = s"$hostname/change-corporate-trustee-address"

  override def pageTitle: String =
    "Does the corporate trustee have a UK address? - Charities - GOV.UK"

  def pageHeader: String =
    "Does the corporate trustee have a UK address?"

  def pageCaption: String =
    "Provide organisation details"

  /* Error Messages To Be Confirmed */
  def pageErrorMsg: String =
    "Select ‘Yes’ if the corporate trustee has a UK address"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    DoesTheCorporateTrusteeHaveAUKAddressPage.verifyPageUrl(DoesTheCorporateTrusteeHaveAUKAddressPage.pageUrl)
    DoesTheCorporateTrusteeHaveAUKAddressPage.verifyPageTitle(DoesTheCorporateTrusteeHaveAUKAddressPage.pageTitle)
    DoesTheCorporateTrusteeHaveAUKAddressPage.verifyPageHeader(DoesTheCorporateTrusteeHaveAUKAddressPage.pageHeader)
  }

  def validateChangeNavigation(): Unit = {
    DoesTheCorporateTrusteeHaveAUKAddressPage.verifyPageUrl(DoesTheCorporateTrusteeHaveAUKAddressPage.changePageUrl)
    DoesTheCorporateTrusteeHaveAUKAddressPage.verifyPageTitle(DoesTheCorporateTrusteeHaveAUKAddressPage.pageTitle)
    DoesTheCorporateTrusteeHaveAUKAddressPage.verifyPageHeader(DoesTheCorporateTrusteeHaveAUKAddressPage.pageHeader)
  }

  def validateErrorMessage(): Unit =
    DoesTheCorporateTrusteeHaveAUKAddressPage.validateGenericPageError(
      DoesTheCorporateTrusteeHaveAUKAddressPage.pageErrorMsg,
      DoesTheCorporateTrusteeHaveAUKAddressPage.errorMsgLocator
    )

}
