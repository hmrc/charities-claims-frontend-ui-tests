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

object DoYouHaveAClaimReferenceNumberPage_OLD extends BasePage {

  override def pageUrl: String = s"$hostname/old/claim-reference-number"

  override def pageTitle: String =
    "Do you have a claim reference number? - Charities - GOV.UK"

  def pageHeader: String =
    "Do you have a claim reference number?"

  def pageErrorMsg: String =
    "Select ‘Yes’ if you have a reference number for this claim."

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    DoYouHaveAClaimReferenceNumberPage_OLD.verifyPageUrl(DoYouHaveAClaimReferenceNumberPage_OLD.pageUrl)
    DoYouHaveAClaimReferenceNumberPage_OLD.verifyPageTitle(DoYouHaveAClaimReferenceNumberPage_OLD.pageTitle)
    DoYouHaveAClaimReferenceNumberPage_OLD.verifyPageHeader(DoYouHaveAClaimReferenceNumberPage_OLD.pageHeader)
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    DoYouHaveAClaimReferenceNumberPage_OLD.validateGenericPageError(
      DoYouHaveAClaimReferenceNumberPage_OLD.pageErrorMsg,
      DoYouHaveAClaimReferenceNumberPage_OLD.errorMsgLocator
    )
}
