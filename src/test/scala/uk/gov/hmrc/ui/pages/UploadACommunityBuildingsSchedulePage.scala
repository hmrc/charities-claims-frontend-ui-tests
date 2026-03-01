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

object UploadACommunityBuildingsSchedulePage extends BasePage {

  override def pageUrl: String = s"$hostname/upload-community-buildings-schedule"

  override def pageTitle: String =
    "Upload a Community Buildings schedule - Charities - GOV.UK"

  def pageCaption: String =
    "Add Community Buildings schedule"

  def pageHeader: String =
    "Upload a Community Buildings schedule"

  def pageText1: String =
    "To claim Community Buildings top-up payment, you need to upload a completed Community Buildings schedule with details of the community building(s) where donations were collected and amounts received. You can save your claim without uploading the Community Buildings schedule, but you need to upload a Community Buildings schedule before submitting your claim."

  def pageText2: String =
    "If you have not completed a Community Buildings schedule, download a Community Buildings schedule here (opens in new tab)."

  def pageText3: String =
    "Upload a file"

  def pageText4: String =
    "No file chosen"

  def pageHiddenText: String =
    ","

  def pageText5: String =
    "Choose file"

  def pageText6: String =
    "or drop file"

  def pageText7: String =
    "Continue"

  def pageNoInputErrorMsg: String =
    "Select a Community Buildings schedule"

  def pageFileTooBigErrorMsg: String =
    "The selected file must be smaller than 250KB"

  val errorMsgLocator = By.ById("file-error")

  def validateNavigation(): Unit = {
    UploadACommunityBuildingsSchedulePage.verifyPageUrl(UploadACommunityBuildingsSchedulePage.pageUrl)
    UploadACommunityBuildingsSchedulePage.verifyPageTitle(UploadACommunityBuildingsSchedulePage.pageTitle)
    UploadACommunityBuildingsSchedulePage.verifyPageCaption(UploadACommunityBuildingsSchedulePage.pageCaption)
    UploadACommunityBuildingsSchedulePage.verifyPageHeader(UploadACommunityBuildingsSchedulePage.pageHeader)
  }

  def validatePageContent(): Unit =
    UploadACommunityBuildingsSchedulePage.verifyEntirePageContent(
      UploadACommunityBuildingsSchedulePage.createSingleStringFromMany(
        UploadACommunityBuildingsSchedulePage.pageCaption,
        UploadACommunityBuildingsSchedulePage.pageHeader,
        UploadACommunityBuildingsSchedulePage.pageText1,
        UploadACommunityBuildingsSchedulePage.pageText2,
        UploadACommunityBuildingsSchedulePage.pageText3,
        UploadACommunityBuildingsSchedulePage.pageText4,
        UploadACommunityBuildingsSchedulePage.pageHiddenText,
        UploadACommunityBuildingsSchedulePage.pageText5,
        UploadACommunityBuildingsSchedulePage.pageText6,
        UploadACommunityBuildingsSchedulePage.pageText7
      )
    )

  /** Validate that the no input error message is correct */
  def validateNoInputErrorMessage(): Unit =
    UploadACommunityBuildingsSchedulePage.validateGenericPageError(
      UploadACommunityBuildingsSchedulePage.pageNoInputErrorMsg,
      UploadACommunityBuildingsSchedulePage.errorMsgLocator
    )

  /** Validate that the file above max size error message is correct */
  def validateOversizeErrorMessage(): Unit =
    UploadACommunityBuildingsSchedulePage.validateUploadFilePageError(
      UploadACommunityBuildingsSchedulePage.pageFileTooBigErrorMsg,
      UploadACommunityBuildingsSchedulePage.errorMsgLocator
    )
}
