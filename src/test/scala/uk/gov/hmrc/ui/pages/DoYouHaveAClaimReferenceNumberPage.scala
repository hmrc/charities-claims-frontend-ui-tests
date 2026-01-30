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

object DoYouHaveAClaimReferenceNumberPage extends BasePage {

  override def pageUrl: String = s"$hostname/claim-reference-number"

  override def pageTitle: String =
    "Do you have a claim reference number? - Charities - GOV.UK"

  def pageHeader: String =
    "Do you have a claim reference number?"

  def pageErrorMsg: String =
    "Select ‘Yes’ if you have a claim reference number"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    OLD_DoYouHaveAClaimReferenceNumberPage.verifyPageUrl(OLD_DoYouHaveAClaimReferenceNumberPage.pageUrl)
    OLD_DoYouHaveAClaimReferenceNumberPage.verifyPageTitle(OLD_DoYouHaveAClaimReferenceNumberPage.pageTitle)
    OLD_DoYouHaveAClaimReferenceNumberPage.verifyPageHeader(OLD_DoYouHaveAClaimReferenceNumberPage.pageHeader)
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    OLD_DoYouHaveAClaimReferenceNumberPage.validateGenericPageError(
      OLD_DoYouHaveAClaimReferenceNumberPage.pageErrorMsg,
      OLD_DoYouHaveAClaimReferenceNumberPage.errorMsgLocator
    )
}
