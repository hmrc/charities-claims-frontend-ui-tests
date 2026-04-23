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

object CheckYourConnectedCharitiesScheduleErrorPage extends BasePage {

  override def pageUrl: String = s"$hostname/problem-with-connected-charities-schedule"

  override def pageTitle: String =
    "There is a problem with the data in your Connected Charities schedule - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Add Connected Charities schedule"

  def pageHeading: String =
    "There is a problem with the data in your Connected Charities schedule"

  def pageWarningIcon: String =
    "!"

  def pageWarningHeading: String =
    "Warning"

  def pageWarningText: String =
    "We cannot accept the file because it has errors. You must fix these errors and upload the updated file before you can continue."

  def pageHeading2: String =
    "What you can do next"

  def pageHeading3: String =
    "Summary of errors"

  def errorHelp1: String =
    "Refer to the Schedule spreadsheet to claim tax back on Connected Charities donations (opens in new tab)."

  def errorHelp2: String =
    "Delete this Connected Charities schedule."

  def errorHelp3: String =
    "Update your spreadsheet."

  def errorHelp4: String =
    "Upload the updated spreadsheet."

  def validateNavigation(): Unit = {
    CheckYourConnectedCharitiesScheduleErrorPage.verifyPageUrl(CheckYourConnectedCharitiesScheduleErrorPage.pageUrl)
    CheckYourConnectedCharitiesScheduleErrorPage.verifyPageTitle(CheckYourConnectedCharitiesScheduleErrorPage.pageTitle)
    CheckYourConnectedCharitiesScheduleErrorPage.verifyPageCaption(
      CheckYourConnectedCharitiesScheduleErrorPage.pageCaption
    )
    CheckYourConnectedCharitiesScheduleErrorPage.verifyPageHeading(
      CheckYourConnectedCharitiesScheduleErrorPage.pageHeading
    )
  }

  def validatePageContent(): Unit = {
    CheckYourConnectedCharitiesScheduleErrorPage.verifyPageWarning(
      CheckYourConnectedCharitiesScheduleErrorPage.createSingleStringFromMany(
        CheckYourConnectedCharitiesScheduleErrorPage.pageWarningIcon,
        CheckYourConnectedCharitiesScheduleErrorPage.pageWarningHeading,
        CheckYourConnectedCharitiesScheduleErrorPage.pageWarningText
      )
    )
    CheckYourConnectedCharitiesScheduleErrorPage.verifyPageSubHeading1(
      CheckYourConnectedCharitiesScheduleErrorPage.pageHeading2
    )
    CheckYourConnectedCharitiesScheduleErrorPage.verifyPageSubHeading2(
      CheckYourConnectedCharitiesScheduleErrorPage.pageHeading3
    )
    CheckYourConnectedCharitiesScheduleErrorPage.verifyScheduleErrorHelpList(
      CheckYourConnectedCharitiesScheduleErrorPage.createSingleStringFromMany(
        CheckYourConnectedCharitiesScheduleErrorPage.errorHelp1,
        CheckYourConnectedCharitiesScheduleErrorPage.errorHelp2,
        CheckYourConnectedCharitiesScheduleErrorPage.errorHelp3,
        CheckYourConnectedCharitiesScheduleErrorPage.errorHelp4
      )
    )
  }
}
