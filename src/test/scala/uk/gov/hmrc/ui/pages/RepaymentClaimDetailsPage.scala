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

object RepaymentClaimDetailsPage extends BasePage {

  override def pageUrl: String = s"$hostname/repayment-claim-details"

  override def pageTitle: String =
    "Repayment claim details - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "Repayment claim details"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageParagraph: String =
    "Use this service to claim:"

  def listItem1: String =
    "tax repayments on Gift Aid donations"

  def listItem2: String =
    "top-up payments under the Gift Aid Small Donations Scheme (GASDS)"

  def listItem3: String =
    "UK tax deducted from Other Income"

  def validateNavigation(): Unit = {
    RepaymentClaimDetailsPage.verifyPageUrl(RepaymentClaimDetailsPage.pageUrl)
    RepaymentClaimDetailsPage.verifyPageTitle(RepaymentClaimDetailsPage.pageTitle)
    RepaymentClaimDetailsPage.verifyPageHeading(RepaymentClaimDetailsPage.pageHeading)
    RepaymentClaimDetailsPage.verifyPageCaption(RepaymentClaimDetailsPage.pageCaption)
  }

  def validateNavigationAgent(): Unit = {
    RepaymentCheckboxPage.verifyPageUrl(RepaymentCheckboxPage.pageUrl)
    RepaymentCheckboxPage.verifyPageTitle(RepaymentCheckboxPage.pageTitle)
    RepaymentCheckboxPage.verifyPageCaption(RepaymentCheckboxPage.pageCaptionAgent)
    RepaymentCheckboxPage.verifyPageHeading(RepaymentCheckboxPage.pageHeading)
  }

  def validateParagraph(): Unit = {
    RepaymentClaimDetailsPage.verifyParagraphText(
      RepaymentClaimDetailsPage.pageParagraph
    )
    RepaymentClaimDetailsPage.verifyListText(
      RepaymentClaimDetailsPage.createSingleStringFromMany(
        RepaymentClaimDetailsPage.listItem1,
        RepaymentClaimDetailsPage.listItem2,
        RepaymentClaimDetailsPage.listItem3
      )
    )
  }

}
