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

object CheckYourGiftAidScheduleErrorPage extends BasePage {

  override def pageUrl: String = s"$hostname/problem-with-gift-aid-schedule"

  override def pageTitle: String =
    "There is a problem with the data in your Gift Aid schedule - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Add Gift Aid schedule"

  def pageHeading: String =
    "There is a problem with the data in your Gift Aid schedule"

  def pageHeadingAgent: String =
    "There is a problem with the data in this Gift Aid schedule"

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
    "Refer to the Schedule spreadsheet to claim tax back on Gift Aid donations (opens in new tab)."

  def errorHelp2: String =
    "Delete this Gift Aid schedule."

  def errorHelp3: String =
    "Update your spreadsheet."

  def errorHelp3Agent: String =
    "Update the spreadsheet."

  def errorHelp4: String =
    "Upload the updated spreadsheet."

  def validateNavigation(): Unit = {
    CheckYourGiftAidScheduleErrorPage.verifyPageUrl(CheckYourGiftAidScheduleErrorPage.pageUrl)
    CheckYourGiftAidScheduleErrorPage.verifyPageTitle(CheckYourGiftAidScheduleErrorPage.pageTitle)
    CheckYourGiftAidScheduleErrorPage.verifyPageCaption(CheckYourGiftAidScheduleErrorPage.pageCaption)
    CheckYourGiftAidScheduleErrorPage.verifyPageHeading(CheckYourGiftAidScheduleErrorPage.pageHeading)
  }

  def validatePageContent(): Unit = {
    CheckYourGiftAidScheduleErrorPage.verifyPageWarning(
      CheckYourGiftAidScheduleErrorPage.createSingleStringFromMany(
        CheckYourGiftAidScheduleErrorPage.pageWarningIcon,
        CheckYourGiftAidScheduleErrorPage.pageWarningHeading,
        CheckYourGiftAidScheduleErrorPage.pageWarningText
      )
    )
    CheckYourGiftAidScheduleErrorPage.verifyPageSubHeading1(CheckYourGiftAidScheduleErrorPage.pageHeading2)
    CheckYourGiftAidScheduleErrorPage.verifyPageSubHeading2(CheckYourGiftAidScheduleErrorPage.pageHeading3)
    CheckYourGiftAidScheduleErrorPage.verifyScheduleErrorHelpList(
      CheckYourGiftAidScheduleErrorPage.createSingleStringFromMany(
        CheckYourGiftAidScheduleErrorPage.errorHelp1,
        CheckYourGiftAidScheduleErrorPage.errorHelp2,
        CheckYourGiftAidScheduleErrorPage.errorHelp3,
        CheckYourGiftAidScheduleErrorPage.errorHelp4
      )
    )
  }

  def validateNavigationAgent(): Unit = {
    CheckYourGiftAidScheduleErrorPage.verifyPageUrl(CheckYourGiftAidScheduleErrorPage.pageUrl)
    CheckYourGiftAidScheduleErrorPage.verifyPageTitle(CheckYourGiftAidScheduleErrorPage.pageTitle)
    CheckYourGiftAidScheduleErrorPage.verifyPageCaption(CheckYourGiftAidScheduleErrorPage.pageCaption)
    CheckYourGiftAidScheduleErrorPage.verifyPageHeading(CheckYourGiftAidScheduleErrorPage.pageHeadingAgent)
  }

  def validatePageContentAgent(): Unit = {
    CheckYourGiftAidScheduleErrorPage.verifyPageWarning(
      CheckYourGiftAidScheduleErrorPage.createSingleStringFromMany(
        CheckYourGiftAidScheduleErrorPage.pageWarningIcon,
        CheckYourGiftAidScheduleErrorPage.pageWarningHeading,
        CheckYourGiftAidScheduleErrorPage.pageWarningText
      )
    )
    CheckYourGiftAidScheduleErrorPage.verifyPageSubHeading1(CheckYourGiftAidScheduleErrorPage.pageHeading2)
    CheckYourGiftAidScheduleErrorPage.verifyPageSubHeading2(CheckYourGiftAidScheduleErrorPage.pageHeading3)
    CheckYourGiftAidScheduleErrorPage.verifyScheduleErrorHelpList(
      CheckYourGiftAidScheduleErrorPage.createSingleStringFromMany(
        CheckYourGiftAidScheduleErrorPage.errorHelp1,
        CheckYourGiftAidScheduleErrorPage.errorHelp2,
        CheckYourGiftAidScheduleErrorPage.errorHelp3Agent,
        CheckYourGiftAidScheduleErrorPage.errorHelp4
      )
    )
  }
}
