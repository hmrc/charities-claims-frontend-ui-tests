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
import uk.gov.hmrc.ui.pages

object UpdateRepaymentClaimDetails extends BasePage {
  
  override def pageUrl: String = s"$hostname/change-repayment-claim-type"

  override def pageTitle: String =
    "Do you want to update this repayment claim? - Charities - GOV.UK"

  def pageHeading: String =
    "Do you want to update this repayment claim?"

  def pageParagraph: String =
    "If you change this claim, you'll lose any data you've already given or attached"

  def errorMsg: String =
    "Select ‘Yes’ if you want to update this repayment claim"

  val yes: String = "#value"
  val no: String = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    UpdateRepaymentClaimDetails.verifyPageUrl(UpdateRepaymentClaimDetails.pageUrl)
    UpdateRepaymentClaimDetails.verifyPageTitle(UpdateRepaymentClaimDetails.pageTitle)
    UpdateRepaymentClaimDetails.verifyPageHeader(UpdateRepaymentClaimDetails.pageHeading)

  }

  def validateErrorMessages(): Unit =
    UpdateRepaymentClaimDetails.validateGenericPageError(
      UpdateRepaymentClaimDetails.errorMsg,
      UpdateRepaymentClaimDetails.errorMsgLocator
    )
}
