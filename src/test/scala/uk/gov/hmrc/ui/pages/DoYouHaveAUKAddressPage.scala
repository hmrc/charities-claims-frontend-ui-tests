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

object DoYouHaveAUKAddressPage extends BasePage {
  override def pageUrl: String = s"$hostname/do-you-have-a-uk-address"

  override def pageTitle: String =
    "Do you have a UK address? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeading: String =
    "Do you have a UK address?"

  def pageErrorMsg: String =
    "Select ‘Yes’ if you have a UK address"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigationAgent(): Unit = {
    DoYouHaveAUKAddressPage.verifyPageUrl(DoYouHaveAUKAddressPage.pageUrl)
    DoYouHaveAUKAddressPage.verifyPageTitle(DoYouHaveAUKAddressPage.pageTitle)
    DoYouHaveAUKAddressPage.verifyPageHeading(DoYouHaveAUKAddressPage.pageHeading)
    DoYouHaveAUKAddressPage.verifyPageCaption(DoYouHaveAUKAddressPage.pageCaption)
  }

  def validateErrorMessageAgent(): Unit =
    DoYouHaveAUKAddressPage.validateGenericPageError(
      DoYouHaveAUKAddressPage.pageErrorMsg,
      DoYouHaveAUKAddressPage.errorMsgLocator
    )
}
