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

object UpdateConnectedCharitiesSchedulePage extends BasePage {

  override def pageUrl: String = s"$hostname/update-connected-charities-schedule"

  override def pageTitle: String =
    "Are you sure you want to update this Connected Charities schedule? - Charities - GOV.UK"

  def pageHeading: String =
    "\tAre you sure you want to update this Connected Charities schedule?"

  def pageHint: String =
    "By updating this file, you will lose any Connected Charities schedule data you have previously attached."

  def errorMsg: String =
    "Select ‘Yes’ if you want to update this Community Charities schedule"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    UpdateConnectedCharitiesSchedulePage.verifyPageUrl(UpdateConnectedCharitiesSchedulePage.pageUrl)
    UpdateConnectedCharitiesSchedulePage.verifyPageTitle(UpdateConnectedCharitiesSchedulePage.pageTitle)
    UpdateConnectedCharitiesSchedulePage.verifyPageHeader(UpdateConnectedCharitiesSchedulePage.pageHeading)
    UpdateConnectedCharitiesSchedulePage.verifyHintText(UpdateConnectedCharitiesSchedulePage.pageHint)
  }

  def validateErrorMessage(): Unit =
    UpdateConnectedCharitiesSchedulePage.validateGenericPageError(
      UpdateConnectedCharitiesSchedulePage.errorMsg,
      UpdateConnectedCharitiesSchedulePage.errorMsgLocator
    )

}
