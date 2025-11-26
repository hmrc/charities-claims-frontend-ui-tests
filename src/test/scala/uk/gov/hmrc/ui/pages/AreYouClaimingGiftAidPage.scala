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

object AreYouClaimingGiftAidPage extends BasePage {

  override def pageUrl: String = "/claim-gift-aid"

  override def pageTitle: String =
    "Claiming Gift Aid - Charities - GOV.UK"

  def pageHeader: String =
    "Are you claiming Gift Aid?"

  def pageHint: String =
    "Select ‘Yes’ if you want to claim tax repayment on donations from a Gift Aid declaration."

  def pageErrorMsg: String =
    "Select ‘Yes’ if you are claiming Gift Aid."

  val yes: String = "#value"
  val no: String  = "#value-no"

  def validateNavigation(): Unit = {
    AreYouClaimingGiftAidPage.verifyPageUrl(AreYouClaimingGiftAidPage.pageUrl)
    AreYouClaimingGiftAidPage.verifyPageTitle(AreYouClaimingGiftAidPage.pageTitle)
    AreYouClaimingGiftAidPage.verifyPageHeader(AreYouClaimingGiftAidPage.pageHeader)
  }

  /** Validate the paragraph on the screen, dev team have encapsulated inside a hint */
  def validateHint(): Unit =
    AreYouClaimingGiftAidPage.verifyHintText(AreYouClaimingGiftAidPage.pageHint)

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    AreYouClaimingGiftAidPage.validateGenericPageError(AreYouClaimingGiftAidPage.pageErrorMsg)
}
