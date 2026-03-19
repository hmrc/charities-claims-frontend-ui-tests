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

object CheckYourConnectedCharitiesSchedulePage extends BasePage {

  override def pageUrl: String = s"$hostname/check-your-connected-charities-schedule"

  override def pageTitle: String = "Check your Connected Charities schedule - Charities - GOV.UK"

  def pageCaption: String = "Add Connected Charities schedule"

  def pageHeading: String = "Check your Connected Charities schedule"

  def pageErrorMsg: String = "Select ‘Yes’ if you need to update this Connected Charities schedule"

  def textRadioButtonQuestion: String = "Do you need to update this Connected Charities schedule?"

  def textRadioButtonYes: String = "Yes"

  def textRadioButtonNo: String = "No, continue with Connected Charities schedule"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    CheckYourConnectedCharitiesSchedulePage.verifyPageUrl(CheckYourConnectedCharitiesSchedulePage.pageUrl)
    CheckYourConnectedCharitiesSchedulePage.verifyPageTitle(CheckYourConnectedCharitiesSchedulePage.pageTitle)
    CheckYourConnectedCharitiesSchedulePage.verifyPageCaption(CheckYourConnectedCharitiesSchedulePage.pageCaption)
    CheckYourConnectedCharitiesSchedulePage.verifyPageHeading(CheckYourConnectedCharitiesSchedulePage.pageHeading)
  }

  def validateFormFieldset(): Unit =
    CheckYourConnectedCharitiesSchedulePage.verifyFormFieldsetContent(
      CheckYourConnectedCharitiesSchedulePage.createSingleStringFromMany(
        CheckYourConnectedCharitiesSchedulePage.textRadioButtonQuestion,
        CheckYourConnectedCharitiesSchedulePage.textRadioButtonYes,
        CheckYourConnectedCharitiesSchedulePage.textRadioButtonNo
      )
    )

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    CheckYourConnectedCharitiesSchedulePage.validateGenericPageError(
      CheckYourConnectedCharitiesSchedulePage.pageErrorMsg,
      CheckYourConnectedCharitiesSchedulePage.errorMsgLocator
    )
}
