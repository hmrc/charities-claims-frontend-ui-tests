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

object ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject extends BasePage {

  override def pageUrl: String = s"$hostname/problem-uploading-other-income-schedule-rejected"

  override def pageTitle: String =
    "There is a problem uploading your Other Income schedule - Make a charity tax repayment claim - GOV.UK"

  def pageTitleAgent: String =
    "There is a problem uploading this Other Income schedule - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "There is a problem uploading your Other Income schedule"

  def pageHeadingAgent: String =
    "There is a problem uploading this Other Income schedule"

  def listItem1: String =
    "Your file must be an ODS file. Save your schedule as an ODS file and try uploading it again."

  def listItem1Agent: String =
    "This file must be an ODS file. Save this schedule as an ODS file and try uploading it again."

  def btnUploadNewSchedule: String =
    "Upload a new schedule"

  def txtReturnToDashboard: String =
    "No, return to manage charity repayment claims"

  def validateNavigation(): Unit = {
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.verifyPageUrl(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.pageUrl
    )
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.verifyPageTitle(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.pageTitle
    )
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.verifyPageHeading(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.pageHeading
    )
  }

  def validatePageContent(): Unit =
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.verifyEntirePageContent(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.createSingleStringFromMany(
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.pageHeading,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.listItem1,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.btnUploadNewSchedule,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.txtReturnToDashboard
      )
    )

  def validateNavigationAgent(): Unit = {
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.verifyPageUrl(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.pageUrl
    )
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.verifyPageTitle(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.pageTitleAgent
    )
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.verifyPageHeading(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.pageHeadingAgent
    )
  }

  def validatePageContentAgent(): Unit =
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.verifyEntirePageContent(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.createSingleStringFromMany(
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.pageHeadingAgent,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.listItem1Agent,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.btnUploadNewSchedule,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Reject.txtReturnToDashboard
      )
    )
}
