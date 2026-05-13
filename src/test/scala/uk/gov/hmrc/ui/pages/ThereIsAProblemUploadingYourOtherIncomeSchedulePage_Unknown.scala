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

object ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown extends BasePage {

  override def pageUrl: String = s"$hostname/problem-uploading-other-income-schedule-unknown-error"

  override def pageTitle: String =
    "There is a problem uploading your Other Income schedule - Make a charity tax repayment claim - GOV.UK"

  def pageTitleAgent: String =
    "There is a problem uploading this Other Income schedule - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "There is a problem uploading your Other Income schedule"

  def pageHeadingAgent: String =
    "There is a problem uploading this Other Income schedule"

  def listItem1: String =
    "Your file could not be uploaded. You can try uploading the file again."

  def listItem1Agent: String =
    "This file could not be uploaded. You can try uploading the file again."

  def btnUploadNewSchedule: String =
    "Upload a new schedule"

  def txtReturnToDashboard: String =
    "No, return to manage charity repayment claims"

  def validateNavigation(): Unit = {
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.verifyPageUrl(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.pageUrl
    )
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.verifyPageTitle(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.pageTitle
    )
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.verifyPageHeading(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.pageHeading
    )
  }

  def validatePageContent(): Unit =
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.verifyEntirePageContent(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.createSingleStringFromMany(
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.pageHeading,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.listItem1,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.btnUploadNewSchedule,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.txtReturnToDashboard
      )
    )

  def validateNavigationAgent(): Unit = {
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.verifyPageUrl(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.pageUrl
    )
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.verifyPageTitle(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.pageTitleAgent
    )
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.verifyPageHeading(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.pageHeadingAgent
    )
  }

  def validatePageContentAgent(): Unit =
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.verifyEntirePageContent(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.createSingleStringFromMany(
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.pageHeadingAgent,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.listItem1Agent,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.btnUploadNewSchedule,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Unknown.txtReturnToDashboard
      )
    )
}
