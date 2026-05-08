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

object DoYouHaveAClaimReferenceNumberPage extends BasePage {

  override def pageUrl: String = s"$hostname/claim-reference-number-check"

  def changePageUrl: String = s"$hostname/change-claim-reference-number-check"

  override def pageTitle: String =
    "Do you have a claim reference number? - Make a charity tax repayment claim - GOV.UK"

  def pageTitleAgent: String =
    "Does the charity have a claim reference number? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageCaptionAgent: String =
    "Provide charity repayment claim details"

  def pageHeading: String =
    "Do you have a claim reference number?"

  def pageHeadingAgent: String =
    "Does the charity have a claim reference number?"

  def pageErrorMsg: String =
    "Select ‘Yes’ if you have a claim reference number"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    DoYouHaveAClaimReferenceNumberPage.verifyPageUrl(DoYouHaveAClaimReferenceNumberPage.pageUrl)
    DoYouHaveAClaimReferenceNumberPage.verifyPageTitle(DoYouHaveAClaimReferenceNumberPage.pageTitle)
    DoYouHaveAClaimReferenceNumberPage.verifyPageCaption(DoYouHaveAClaimReferenceNumberPage.pageCaption)
    DoYouHaveAClaimReferenceNumberPage.verifyPageHeading(DoYouHaveAClaimReferenceNumberPage.pageHeading)
  }

  def validateNavigationAgent(): Unit = {
    DoYouHaveAClaimReferenceNumberPage.verifyPageUrl(DoYouHaveAClaimReferenceNumberPage.pageUrl)
    DoYouHaveAClaimReferenceNumberPage.verifyPageTitle(DoYouHaveAClaimReferenceNumberPage.pageTitleAgent)
    DoYouHaveAClaimReferenceNumberPage.verifyPageCaption(DoYouHaveAClaimReferenceNumberPage.pageCaptionAgent)
    DoYouHaveAClaimReferenceNumberPage.verifyPageHeading(DoYouHaveAClaimReferenceNumberPage.pageHeadingAgent)
  }

  def validateChangeNavigation(): Unit = {
    DoYouHaveAClaimReferenceNumberPage.verifyPageUrl(DoYouHaveAClaimReferenceNumberPage.changePageUrl)
    DoYouHaveAClaimReferenceNumberPage.verifyPageTitle(DoYouHaveAClaimReferenceNumberPage.pageTitle)
    DoYouHaveAClaimReferenceNumberPage.verifyPageCaption(DoYouHaveAClaimReferenceNumberPage.pageCaption)
    DoYouHaveAClaimReferenceNumberPage.verifyPageHeading(DoYouHaveAClaimReferenceNumberPage.pageHeading)
  }

  def validateChangeNavigationAgent(): Unit = {
    DoYouHaveAClaimReferenceNumberPage.verifyPageUrl(DoYouHaveAClaimReferenceNumberPage.changePageUrl)
    DoYouHaveAClaimReferenceNumberPage.verifyPageTitle(DoYouHaveAClaimReferenceNumberPage.pageTitleAgent)
    DoYouHaveAClaimReferenceNumberPage.verifyPageCaption(DoYouHaveAClaimReferenceNumberPage.pageCaptionAgent)
    DoYouHaveAClaimReferenceNumberPage.verifyPageHeading(DoYouHaveAClaimReferenceNumberPage.pageHeadingAgent)
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    DoYouHaveAClaimReferenceNumberPage.validateGenericPageError(
      DoYouHaveAClaimReferenceNumberPage.pageErrorMsg,
      DoYouHaveAClaimReferenceNumberPage.errorMsgLocator
    )
}
