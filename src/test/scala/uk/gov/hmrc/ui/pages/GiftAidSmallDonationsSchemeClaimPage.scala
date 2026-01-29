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

object GiftAidSmallDonationsSchemeClaimPage extends BasePage {

  override def pageUrl: String = s"$hostname/change-previous-gasds-claim"

  override def pageTitle: String =
    "Gift Aid Small Donations Scheme claim - Charities - GOV.UK"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageHeader: String =
    "Gift Aid Small Donations Scheme claim"

  def pageParagraph: String =
    "If a Community Amateur Sports Club has received an over-payment, we will deduct the over-payment from this claim."

  def pageLegend: String =
    "Do you want to change a previous Gift Aid Small Donations Scheme claim?"

  def pageErrorMsg: String =
    "Select ‘Yes’ if you want to change a previous Gift Aid Small Donations Scheme claim"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    GiftAidSmallDonationsSchemeClaimPage.verifyPageUrl(GiftAidSmallDonationsSchemeClaimPage.pageUrl)
    GiftAidSmallDonationsSchemeClaimPage.verifyPageTitle(GiftAidSmallDonationsSchemeClaimPage.pageTitle)
    GiftAidSmallDonationsSchemeClaimPage.verifyPageCaption(GiftAidSmallDonationsSchemeClaimPage.pageCaption)
    GiftAidSmallDonationsSchemeClaimPage.verifyPageHeader(GiftAidSmallDonationsSchemeClaimPage.pageHeader)
  }

  def validateParagraph(): Unit = {
    GiftAidSmallDonationsSchemeClaimPage.verifyParagraphText(GiftAidSmallDonationsSchemeClaimPage.pageParagraph)
    GiftAidSmallDonationsSchemeClaimPage.verifyLegendText(GiftAidSmallDonationsSchemeClaimPage.pageLegend)
  }

  def validateErrorMessage(): Unit =
    GiftAidSmallDonationsSchemeClaimPage.validateGenericPageError(
      GiftAidSmallDonationsSchemeClaimPage.pageErrorMsg,
      GiftAidSmallDonationsSchemeClaimPage.errorMsgLocator
    )
}
