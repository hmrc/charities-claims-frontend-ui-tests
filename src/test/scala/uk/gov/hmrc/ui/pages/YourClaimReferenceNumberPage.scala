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

object YourClaimReferenceNumberPage extends BasePage {

//  override def pageUrl: String = "/check-claim-reference-number"

  override def pageUrl: String = "http://localhost:8030/charities-claims/check-claim-reference-number"

  override def pageTitle: String =
    "Check your claim reference number - Charities - GOV.UK"

  def pageHeader: String =
    "Your claim reference number"

  def pageErrorMsg: String =
    "Enter your claim reference number"

  def enterClaimReferenceNumber(referenceNo: String): Unit = {
    input(Locators.inputYourClaimReferenceNumber, referenceNo)
    clickContinue()
  }

  def validateNavigation(): Unit = {
    YourClaimReferenceNumberPage.verifyPageUrl(YourClaimReferenceNumberPage.pageUrl)
    YourClaimReferenceNumberPage.verifyPageTitle(YourClaimReferenceNumberPage.pageTitle)
    YourClaimReferenceNumberPage.verifyPageHeader(YourClaimReferenceNumberPage.pageHeader)
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    YourClaimReferenceNumberPage.validateGenericPageError(YourClaimReferenceNumberPage.pageErrorMsg)
}
