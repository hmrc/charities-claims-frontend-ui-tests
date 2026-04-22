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

object ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown extends BasePage {

  override def pageUrl: String = s"$hostname/problem-uploading-community-buildings-schedule-unknown-error"

  override def pageTitle: String =
    "There is a problem uploading your Community Buildings schedule - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "There is a problem uploading your Community Buildings schedule"

  def listItem1: String =
    "Your file could not be uploaded. You can try uploading the file again."

  def btnUploadNewSchedule: String =
    "Upload a new schedule"

  def txtReturnToDashboard: String =
    "No, return to manage charity repayment claims"

  def validateNavigation(): Unit = {
    ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.verifyPageUrl(
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.pageUrl
    )
    ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.verifyPageTitle(
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.pageTitle
    )
    ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.verifyPageHeading(
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.pageHeading
    )
  }

  def validatePageContent(): Unit =
    ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.verifyEntirePageContent(
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.createSingleStringFromMany(
        ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.pageHeading,
        ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.listItem1,
        ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.btnUploadNewSchedule,
        ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Unknown.txtReturnToDashboard
      )
    )
}
