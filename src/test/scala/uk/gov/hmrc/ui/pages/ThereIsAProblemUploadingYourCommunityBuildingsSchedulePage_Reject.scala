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

object ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject extends BasePage {

  override def pageUrl: String = s"$hostname/problem-uploading-community-buildings-schedule-rejected"

  override def pageTitle: String =
    "There is a problem uploading your Community Buildings schedule - Charities - GOV.UK"

  def pageHeading: String =
    "There is a problem uploading your Community Buildings schedule"

  def listItem1: String =
    "Your file must be an ODS file. Save your schedule as an ODS file and try uploading it again."

  def btnUploadNewSchedule: String =
    "Upload a new schedule"

  def txtReturnToDashboard: String =
    "No, return to manage charity repayment claims"

  val linkReturnToDashboard: By = By.xpath("//a[@href='/charities-claims/make-a-charity-repayment-claim']")

  def validateNavigation(): Unit = {
    ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.verifyPageUrl(
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.pageUrl
    )
    ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.verifyPageTitle(
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.pageTitle
    )
    ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.verifyPageHeading(
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.pageHeading
    )
  }

  def validatePageContent(): Unit =
    ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.verifyEntirePageContent(
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.createSingleStringFromMany(
        ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.pageHeading,
        ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.listItem1,
        ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.btnUploadNewSchedule,
        ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Reject.txtReturnToDashboard
      )
    )
}
