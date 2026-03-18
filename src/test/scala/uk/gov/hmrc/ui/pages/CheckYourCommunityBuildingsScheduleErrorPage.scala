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

object CheckYourCommunityBuildingsScheduleErrorPage extends BasePage {

  override def pageUrl: String = s"$hostname/problem-with-community-buildings-schedule"

  override def pageTitle: String =
    "There is a problem with the data in your Community Buildings schedule (page 1 of 2) - Charities - GOV.UK"

  def pageCaption: String =
    "Add Community Buildings schedule"

  def pageHeading: String =
    "There is a problem with the data in your Community Buildings schedule"

  def pageWarning: String =
    "We cannot accept the file because it has errors. You must fix these errors and upload the updated file before you can continue."

  def pageHeading2: String =
    "What you can do next"

  def pageHeading3: String =
    "Summary of errors"

  def errorHelp1: String =
    "Refer to the Schedule spreadsheet to claim tax back on Community Buildings donations (opens in new tab)."

  def errorHelp2: String =
    "Delete this Community Buildings schedule."

  def errorHelp3: String =
    "Update your spreadsheet."

  def errorHelp4: String =
    "Upload the updated spreadsheet."

  def validateNavigation(): Unit = {
    CheckYourCommunityBuildingsScheduleErrorPage.verifyPageUrl(CheckYourCommunityBuildingsScheduleErrorPage.pageUrl)
    CheckYourCommunityBuildingsScheduleErrorPage.verifyPageTitle(CheckYourCommunityBuildingsScheduleErrorPage.pageTitle)
    CheckYourCommunityBuildingsScheduleErrorPage.verifyPageCaption(
      CheckYourCommunityBuildingsScheduleErrorPage.pageCaption
    )
    CheckYourCommunityBuildingsScheduleErrorPage.verifyPageHeading(
      CheckYourCommunityBuildingsScheduleErrorPage.pageHeading
    )
    CheckYourCommunityBuildingsScheduleErrorPage.verifyPageWarning(
      CheckYourCommunityBuildingsScheduleErrorPage.pageWarning
    )
    CheckYourCommunityBuildingsScheduleErrorPage.verifyPageSubHeading1(
      CheckYourCommunityBuildingsScheduleErrorPage.pageHeading2
    )
    CheckYourCommunityBuildingsScheduleErrorPage.verifyPageSubHeading2(
      CheckYourCommunityBuildingsScheduleErrorPage.pageHeading3
    )
  }

  def validatePageContent(): Unit =
    CheckYourCommunityBuildingsScheduleErrorPage.verifyScheduleErrorHelpList(
      CheckYourCommunityBuildingsScheduleErrorPage.createSingleStringFromMany(
        CheckYourCommunityBuildingsScheduleErrorPage.errorHelp1,
        CheckYourCommunityBuildingsScheduleErrorPage.errorHelp2,
        CheckYourCommunityBuildingsScheduleErrorPage.errorHelp3,
        CheckYourCommunityBuildingsScheduleErrorPage.errorHelp4
      )
    )

}
