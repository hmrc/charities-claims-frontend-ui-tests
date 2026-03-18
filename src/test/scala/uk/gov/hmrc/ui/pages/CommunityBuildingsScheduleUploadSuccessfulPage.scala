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

object CommunityBuildingsScheduleUploadSuccessfulPage extends BasePage {

  override def pageUrl: String = s"$hostname/community-buildings-schedule-upload-successful"

  override def pageTitle: String =
    "Upload successful - Charities - GOV.UK"

  def pageHeading: String =
    "Upload successful"

  def pageParagraph: String =
    "You have successfully attached your Community Buildings schedule."

  def validateNavigation(): Unit = {
    CommunityBuildingsScheduleUploadSuccessfulPage.verifyPageUrl(CommunityBuildingsScheduleUploadSuccessfulPage.pageUrl)
    CommunityBuildingsScheduleUploadSuccessfulPage.verifyPageTitle(
      CommunityBuildingsScheduleUploadSuccessfulPage.pageTitle
    )
    CommunityBuildingsScheduleUploadSuccessfulPage.verifyPageHeading(
      CommunityBuildingsScheduleUploadSuccessfulPage.pageHeading
    )
  }

  def validatePageParagraph(): Unit =
    CommunityBuildingsScheduleUploadSuccessfulPage.verifyParagraphText(
      CommunityBuildingsScheduleUploadSuccessfulPage.pageParagraph
    )
}
