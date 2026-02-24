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

object CheckYourCommunityBuildingsSchedulePage extends BasePage {

  override def pageUrl: String = s"$hostname/check-your-community-buildings-schedule"

  override def pageTitle: String =
    "Check your Community Buildings schedule (page 1 of 50) - Charities - GOV.UK"

  def pageCaption: String =
    "Add Community Buildings schedule"

  def pageHeader: String =
    "Check your Community Buildings schedule"

  def pageErrorMsg: String =
    "Select ‘Yes’ if you need to update this Community Buildings schedule"

  def textSummaryCardTitle: String =
    "Community Buildings schedule details"

  def textSummaryRow1Col1: String =
    "Total donations"

  def textSummaryRow1Col2: String =
    "£1,000,000.00"

  def textRadioButtonQuestion: String =
    "Do you need to update this Community Buildings schedule?"

  def textRadioButtonYes: String =
    "Yes"

  def textRadioButtonNo: String =
    "No, continue with Community Buildings schedule"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    CheckYourCommunityBuildingsSchedulePage.verifyPageUrl(CheckYourCommunityBuildingsSchedulePage.pageUrl)
    CheckYourCommunityBuildingsSchedulePage.verifyPageTitle(CheckYourCommunityBuildingsSchedulePage.pageTitle)
    CheckYourCommunityBuildingsSchedulePage.verifyPageCaption(CheckYourCommunityBuildingsSchedulePage.pageCaption)
    CheckYourCommunityBuildingsSchedulePage.verifyPageHeader(CheckYourCommunityBuildingsSchedulePage.pageHeader)
  }

  // TODO Hardcoded values, needs improved
  def validateSummaryCard(): Unit =
    CheckYourCommunityBuildingsSchedulePage.verifySummaryCardContent(
      CheckYourCommunityBuildingsSchedulePage.createSingleStringFromMany(
        CheckYourCommunityBuildingsSchedulePage.textSummaryCardTitle,
        CheckYourCommunityBuildingsSchedulePage.textSummaryRow1Col1 + " " + CheckYourCommunityBuildingsSchedulePage.textSummaryRow1Col2,
      )
    )

  def validateFormFieldset(): Unit =
    CheckYourCommunityBuildingsSchedulePage.verifyFormFieldsetContent(
      CheckYourCommunityBuildingsSchedulePage.createSingleStringFromMany(
        CheckYourCommunityBuildingsSchedulePage.textRadioButtonQuestion,
        CheckYourCommunityBuildingsSchedulePage.textRadioButtonYes,
        CheckYourCommunityBuildingsSchedulePage.textRadioButtonNo
      )
    )

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    CheckYourCommunityBuildingsSchedulePage.validateGenericPageError(
      CheckYourCommunityBuildingsSchedulePage.pageErrorMsg,
      CheckYourCommunityBuildingsSchedulePage.errorMsgLocator
    )
}
