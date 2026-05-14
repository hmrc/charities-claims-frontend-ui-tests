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

object DeleteCharityRepaymentAgentPage extends BasePage {

  override def pageUrl: String = s"$hostname/delete-charity-repayment-claim"

  override def pageTitle: String =
    "Delete repayment claim - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "Delete repayment claim"

  def pageLegend: String =
    "Are you sure you want to delete this repayment claim?"

  def pageErrorMsg: String =
    "Select ‘Yes’ if you want to delete this repayment claim"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigationAgent(): Unit = {
    // DeleteCharityRepaymentAgentPage.verifyPageUrl(DeleteCharityRepaymentAgentPage.pageUrl)
    DeleteCharityRepaymentAgentPage.verifyPageTitle(DeleteCharityRepaymentAgentPage.pageTitle)
    DeleteCharityRepaymentAgentPage.verifyPageHeading(DeleteCharityRepaymentAgentPage.pageHeading)
    DeleteCharityRepaymentAgentPage.verifyLegendText(DeleteCharityRepaymentAgentPage.pageLegend)
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    DeleteCharityRepaymentAgentPage.validateGenericPageError(
      DeleteCharityRepaymentAgentPage.pageErrorMsg,
      DeleteCharityRepaymentAgentPage.errorMsgLocator
    )
}
