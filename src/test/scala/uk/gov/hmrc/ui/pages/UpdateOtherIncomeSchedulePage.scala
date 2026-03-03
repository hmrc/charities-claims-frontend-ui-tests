/*
 * Copyright 2025 HM Revenue & Customs
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
import org.scalactic.Prettifier.default

object UpdateOtherIncomeSchedulePage extends BasePage {

  override def pageUrl: String = s"$hostname/update-other-income-schedule"

  override def pageTitle: String =
    "Are you sure you want to update this Other Income schedule? - Charities - GOV.UK"

  def pageHeading: String =
    "Are you sure you want to update this Other Income schedule?"

  def pageHint: String =
    "By updating this file, you will lose any Other Income schedule data you have previously attached."

  def errorMsg: String =
    "Select ‘Yes’ if you want to update this Other Income schedule"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    UpdateOtherIncomeSchedulePage.verifyPageUrl(UpdateOtherIncomeSchedulePage.pageUrl)
    UpdateOtherIncomeSchedulePage.verifyPageTitle(UpdateOtherIncomeSchedulePage.pageTitle)
    UpdateOtherIncomeSchedulePage.verifyPageHeader(UpdateOtherIncomeSchedulePage.pageHeading)
    UpdateOtherIncomeSchedulePage.verifyHintText(UpdateOtherIncomeSchedulePage.pageHint)
  }

  def validateErrorMessage(): Unit =
    UpdateOtherIncomeSchedulePage.validateGenericPageError(
      UpdateOtherIncomeSchedulePage.errorMsg,
      UpdateOtherIncomeSchedulePage.errorMsgLocator
    )

}
