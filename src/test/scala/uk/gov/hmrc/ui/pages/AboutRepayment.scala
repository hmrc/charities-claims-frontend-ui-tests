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

object AboutRepayment extends BasePage {

  override def pageUrl: String = s"$hostname/repayment-claim-details"

  override def pageTitle: String =
    "Repayment claim details - Charities - GOV.UK"

  def pageHeader: String =
    "Repayment claim details"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageParagraph: String =
    "Use this service to claim:"

  def listItem1: String =
    "tax repayments on Gift Aid donations"

  def listItem2: String =
    "top-up payments under the Gift Aid Small Donations Scheme"

  def listItem3: String =
    "UK tax deducted from Other Income"

  def validateNavigation(): Unit = {
    AboutRepayment.verifyPageUrl(AboutRepayment.pageUrl)
    AboutRepayment.verifyPageTitle(AboutRepayment.pageTitle)
    AboutRepayment.verifyPageHeader(AboutRepayment.pageHeader)
    AboutRepayment.verifyPageCaption(AboutRepayment.pageCaption)
  }

  def validateParagraph(): Unit = {
    AboutRepayment.verifyParagraphText(
      AboutRepayment.pageParagraph
    )
    AboutRepayment.verifyListText(
      AboutRepayment.createSingleStringFromMany(
        AboutRepayment.listItem1,
        AboutRepayment.listItem2,
        AboutRepayment.listItem3
      )
    )
  }

}
