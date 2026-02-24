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

object ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine extends BasePage {

  override def pageUrl: String = s"$hostname/problem-uploading-community-buildings-schedule-quarantine"

  override def pageTitle: String =
    "There is a problem uploading your Community Buildings schedule - Charities - GOV.UK"

  def pageHeading: String =
    "There is a problem uploading your Community Buildings schedule"

  def listItem1: String =
    "Your file contains a virus, so it cannot be uploaded. Check the file for viruses or create a new version before uploading it again."

  def btnUploadNewSchedule: String =
    "Upload a new schedule"

  def txtReturnToDashboard: String =
    "No, return to dashboard"

  val linkReturnToDashboard: By = By.xpath("//a[@href='/charities-claims/make-a-charity-repayment-claim']")

  def validateNavigation(): Unit = {
    ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.verifyPageUrl(
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.pageUrl
    )
    ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.verifyPageTitle(
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.pageTitle
    )
    ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.verifyPageHeader(
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.pageHeading
    )
  }

  def validatePageContent(): Unit =
    ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.verifyEntirePageContent(
      ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.createSingleStringFromMany(
        ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.pageHeading,
        ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.listItem1,
        ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.btnUploadNewSchedule,
        ThereIsAProblemUploadingYourCommunityBuildingsSchedulePage_Quarantine.txtReturnToDashboard
      )
    )
}
