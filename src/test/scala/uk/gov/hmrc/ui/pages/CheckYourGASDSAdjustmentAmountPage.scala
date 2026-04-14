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

object CheckYourGASDSAdjustmentAmountPage extends BasePage {

  override def pageUrl: String = s"$hostname/check-gasds-adjustment-amount"

  override def pageTitle: String =
    "Check your GASDS adjustment amount - Charities - GOV.UK"

  def pageCaption: String =
    "Provide GASDS donation details"

  def pageHeading: String =
    "Check your GASDS adjustment amount"

  def validateNavigation(): Unit = {
    CheckYourGASDSAdjustmentAmountPage.verifyPageUrl(CheckYourGASDSAdjustmentAmountPage.pageUrl)
    CheckYourGASDSAdjustmentAmountPage.verifyPageTitle(CheckYourGASDSAdjustmentAmountPage.pageTitle)
    CheckYourGASDSAdjustmentAmountPage.verifyPageCaption(CheckYourGASDSAdjustmentAmountPage.pageCaption)
    CheckYourGASDSAdjustmentAmountPage.verifyPageHeading(CheckYourGASDSAdjustmentAmountPage.pageHeading)
  }

  val linkChangeGASDSAdjustmentAmount: By = By.xpath("//a[@href='/charities-claims/adjustment-to-gift-aid-overclaimed']")

  def clickChangeGASDSAdjustmentAmount(): Unit = {
    val element = waitForElementToBeClickable(linkChangeGASDSAdjustmentAmount)
    element.click()
  }

}
