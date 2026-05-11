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

object CheckYourOtherIncomeScheduleErrorPage extends BasePage {

  override def pageUrl: String = s"$hostname/problem-with-other-income-schedule"

  override def pageTitle: String =
    "There is a problem with the data in your Other Income schedule - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Add Other Income schedule"

  def pageHeading: String =
    "There is a problem with the data in your Other Income schedule"

  def pageHeadingAgent: String =
    "There is a problem with the data in this Other Income schedule"

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
    "Refer to the Schedule spreadsheet to claim tax back on Other Income donations (opens in new tab)."

  def errorHelp2: String =
    "Delete this Other Income schedule."

  def errorHelp3: String =
    "Update your spreadsheet."

  def errorHelpAgent3: String =
    "Update the spreadsheet."

  def errorHelp4: String =
    "Upload the updated spreadsheet."

  def validateNavigation(): Unit = {
    CheckYourOtherIncomeScheduleErrorPage.verifyPageUrl(CheckYourOtherIncomeScheduleErrorPage.pageUrl)
    CheckYourOtherIncomeScheduleErrorPage.verifyPageTitle(CheckYourOtherIncomeScheduleErrorPage.pageTitle)
    CheckYourOtherIncomeScheduleErrorPage.verifyPageCaption(CheckYourOtherIncomeScheduleErrorPage.pageCaption)
    CheckYourOtherIncomeScheduleErrorPage.verifyPageHeading(CheckYourOtherIncomeScheduleErrorPage.pageHeading)
  }

  def validatePageContent(): Unit = {
    CheckYourOtherIncomeScheduleErrorPage.verifyPageWarning(
      CheckYourOtherIncomeScheduleErrorPage.createSingleStringFromMany(
        CheckYourOtherIncomeScheduleErrorPage.pageWarningIcon,
        CheckYourOtherIncomeScheduleErrorPage.pageWarningHeading,
        CheckYourOtherIncomeScheduleErrorPage.pageWarningText
      )
    )
    CheckYourOtherIncomeScheduleErrorPage.verifyPageSubHeading1(CheckYourOtherIncomeScheduleErrorPage.pageHeading2)
    CheckYourOtherIncomeScheduleErrorPage.verifyPageSubHeading2(CheckYourOtherIncomeScheduleErrorPage.pageHeading3)
    CheckYourOtherIncomeScheduleErrorPage.verifyScheduleErrorHelpList(
      CheckYourOtherIncomeScheduleErrorPage.createSingleStringFromMany(
        CheckYourOtherIncomeScheduleErrorPage.errorHelp1,
        CheckYourOtherIncomeScheduleErrorPage.errorHelp2,
        CheckYourOtherIncomeScheduleErrorPage.errorHelp3,
        CheckYourOtherIncomeScheduleErrorPage.errorHelp4
      )
    )
  }

  def validateNavigationAgent(): Unit = {
    CheckYourOtherIncomeScheduleErrorPage.verifyPageUrl(CheckYourOtherIncomeScheduleErrorPage.pageUrl)
    CheckYourOtherIncomeScheduleErrorPage.verifyPageTitle(CheckYourOtherIncomeScheduleErrorPage.pageTitle)
    CheckYourOtherIncomeScheduleErrorPage.verifyPageCaption(CheckYourOtherIncomeScheduleErrorPage.pageCaption)
    CheckYourOtherIncomeScheduleErrorPage.verifyPageHeading(CheckYourOtherIncomeScheduleErrorPage.pageHeadingAgent)
  }

  def validatePageContentAgent(): Unit = {
    CheckYourOtherIncomeScheduleErrorPage.verifyPageWarning(
      CheckYourOtherIncomeScheduleErrorPage.createSingleStringFromMany(
        CheckYourOtherIncomeScheduleErrorPage.pageWarningIcon,
        CheckYourOtherIncomeScheduleErrorPage.pageWarningHeading,
        CheckYourOtherIncomeScheduleErrorPage.pageWarningText
      )
    )
    CheckYourOtherIncomeScheduleErrorPage.verifyPageSubHeading1(CheckYourOtherIncomeScheduleErrorPage.pageHeading2)
    CheckYourOtherIncomeScheduleErrorPage.verifyPageSubHeading2(CheckYourOtherIncomeScheduleErrorPage.pageHeading3)
    CheckYourOtherIncomeScheduleErrorPage.verifyScheduleErrorHelpList(
      CheckYourOtherIncomeScheduleErrorPage.createSingleStringFromMany(
        CheckYourOtherIncomeScheduleErrorPage.errorHelp1,
        CheckYourOtherIncomeScheduleErrorPage.errorHelp2,
        CheckYourOtherIncomeScheduleErrorPage.errorHelpAgent3,
        CheckYourOtherIncomeScheduleErrorPage.errorHelp4
      )
    )
  }
}
