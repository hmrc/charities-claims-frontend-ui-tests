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

object CharitiesManagementAgent extends BasePage {

  override def pageUrl: String = s"$hostname/charities-management/manage-charity-repayment-claim"

  override def pageTitle: String =
    "Manage charity repayment claims - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "Manage charity repayment claims"

  val lnkUseTheCharities: By = By.xpath("//a[@href and contains(text(),'Use the charities online service')]")
  val lnkContinueClaim: By   = By.xpath("//a[@href and contains(text(),'Continue with draft claim')]")

  def validateNavigationAgent(): Unit = {
    // CharitiesManagementAgent.verifyPageUrl(CharitiesManagementAgent.pageUrl)
    CharitiesManagementAgent.verifyPageTitle(CharitiesManagementAgent.pageTitle)
    // CharitiesManagementAgent.verifyPageCaption(CharitiesManagementAgent.pageCaption)
    CharitiesManagementAgent.verifyPageHeading(CharitiesManagementAgent.pageHeading)
  }

  def clickUseTheCharitiesLink(): Unit = {
    val element = waitForElementToBeClickable(lnkUseTheCharities)
    element.click()
  }

  def clickContinueClaimLink(): Unit = {
    val element = waitForElementToBeClickable(lnkContinueClaim)
    element.click()
  }
}
