/*
 * Copyright 2025 HM Revenue & Customs
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

object OLD_AreYouClaimingGiftAidPage extends BasePage {

  override def pageUrl: String = s"$hostname/old/claim-gift-aid"

  override def pageTitle: String =
    "Are you claiming Gift Aid? - Charities - GOV.UK"

  def pageHeader: String =
    "Are you claiming Gift Aid?"

  def pageHint: String =
    "Select ‘Yes’ if you want to claim tax repayment on donations from a Gift Aid declaration."

  def pageErrorMsg: String =
    "Select ‘Yes’ if you are claiming Gift Aid."

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    OLD_AreYouClaimingGiftAidPage.verifyPageUrl(OLD_AreYouClaimingGiftAidPage.pageUrl)
    OLD_AreYouClaimingGiftAidPage.verifyPageTitle(OLD_AreYouClaimingGiftAidPage.pageTitle)
    OLD_AreYouClaimingGiftAidPage.verifyPageHeader(OLD_AreYouClaimingGiftAidPage.pageHeader)
  }

  /** Validate the paragraph on the screen, dev team have encapsulated inside a hint */
  def validateHint(): Unit =
    OLD_AreYouClaimingGiftAidPage.verifyHintText(OLD_AreYouClaimingGiftAidPage.pageHint)

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    OLD_AreYouClaimingGiftAidPage.validateGenericPageError(
      OLD_AreYouClaimingGiftAidPage.pageErrorMsg,
      OLD_AreYouClaimingGiftAidPage.errorMsgLocator
    )
}
