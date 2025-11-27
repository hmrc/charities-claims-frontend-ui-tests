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

object GiftAidSmallDonationsSchemePage extends BasePage {

  override def pageUrl: String = s"$hostname/claiming-for-gift-aid-small-donations-scheme"

  override def pageTitle: String =
    "Are you claiming a top up payment for small cash donations under GASDS? - Charities - GOV.UK"

  def pageHeader: String =
    "Are you claiming a top up payment for small cash donations under GASDS?"

  def pageParagraph: String =
    "This is separate to a Gift Aid claim. The Gift Aid Small Donation Scheme (GASDS) is for donations of £20 or less and does not need declaring."

  def pageLegend: String =
    "Are you claiming for the Gift Aid Small Donations Scheme?"

  def pageErrorMsg: String =
    "Select ‘Yes’ if you are claiming for the Gift Aid Small Donations Scheme."

  val yes: String = "#value"
  val no: String  = "#value-no"

  def validateNavigation(): Unit = {
    GiftAidSmallDonationsSchemePage.verifyPageUrl(GiftAidSmallDonationsSchemePage.pageUrl)
    GiftAidSmallDonationsSchemePage.verifyPageTitle(GiftAidSmallDonationsSchemePage.pageTitle)
    GiftAidSmallDonationsSchemePage.verifyPageHeader(GiftAidSmallDonationsSchemePage.pageHeader)
  }

  def validateParagraph(): Unit = {
    GiftAidSmallDonationsSchemePage.verifyParagraphText(GiftAidSmallDonationsSchemePage.pageParagraph)
    GiftAidSmallDonationsSchemePage.verifyLegendText(GiftAidSmallDonationsSchemePage.pageLegend)
  }

  def validateErrorMessage(): Unit =
    GiftAidSmallDonationsSchemePage.validateGenericPageError(GiftAidSmallDonationsSchemePage.pageErrorMsg)
}
