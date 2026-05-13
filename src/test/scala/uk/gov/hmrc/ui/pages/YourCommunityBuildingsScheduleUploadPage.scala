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

object YourCommunityBuildingsScheduleUploadPage extends BasePage {

  override def pageUrl: String = s"$hostname/your-community-buildings-schedule-upload"

  override def pageTitle: String =
    "Your Community Buildings schedule upload - Make a charity tax repayment claim - GOV.UK"

  def pageTitleAgent: String =
    "Community Buildings schedule upload - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Add Community Buildings schedule"

  def pageHeading: String =
    "Your Community Buildings schedule upload"

  def pageHeadingAgent: String =
    "Community Buildings schedule upload"

  def pageParagraph: String =
    "You can upload your Community Buildings schedule as a spreadsheet. The selected file must be smaller than 250KB."

  def pageParagraphAgent: String =
    "You can upload the Community Buildings schedule as a spreadsheet. The selected file must be smaller than 250KB."

  val linkRemoveUploadedFile: By =
    By.xpath("//a[@href='/charities-claims/your-community-buildings-schedule-upload/remove']")

  def btnContinue: String =
    "Continue"

  val txtFileStatus: By = By.xpath("//dd[@class='govuk-summary-list__value']")

  def txtFileStatusUploaded: String =
    "Uploaded"

  def txtFileStatusFailed: String =
    "Failed"

  def numMaxWaitTime: Int = 6

  def validateNavigation(): Unit = {
    YourCommunityBuildingsScheduleUploadPage.verifyPageUrl(YourCommunityBuildingsScheduleUploadPage.pageUrl)
    YourCommunityBuildingsScheduleUploadPage.verifyPageTitle(YourCommunityBuildingsScheduleUploadPage.pageTitle)
    YourCommunityBuildingsScheduleUploadPage.verifyPageCaption(YourCommunityBuildingsScheduleUploadPage.pageCaption)
    YourCommunityBuildingsScheduleUploadPage.verifyPageHeading(YourCommunityBuildingsScheduleUploadPage.pageHeading)
  }

  def validateParagraph(): Unit =
    YourCommunityBuildingsScheduleUploadPage.verifyParagraphText(
      YourCommunityBuildingsScheduleUploadPage.pageParagraph
    )

  def validateNavigationAgent(): Unit = {
    YourCommunityBuildingsScheduleUploadPage.verifyPageUrl(YourCommunityBuildingsScheduleUploadPage.pageUrl)
    YourCommunityBuildingsScheduleUploadPage.verifyPageTitle(YourCommunityBuildingsScheduleUploadPage.pageTitleAgent)
    YourCommunityBuildingsScheduleUploadPage.verifyPageCaption(YourCommunityBuildingsScheduleUploadPage.pageCaption)
    YourCommunityBuildingsScheduleUploadPage.verifyPageHeading(
      YourCommunityBuildingsScheduleUploadPage.pageHeadingAgent
    )
  }

  def validateParagraphAgent(): Unit =
    YourCommunityBuildingsScheduleUploadPage.verifyParagraphText(
      YourCommunityBuildingsScheduleUploadPage.pageParagraphAgent
    )

  def waitForFileUpload(): Unit =
    YourCommunityBuildingsScheduleUploadPage.waitForElementToContain(
      YourCommunityBuildingsScheduleUploadPage.txtFileStatus,
      YourCommunityBuildingsScheduleUploadPage.txtFileStatusUploaded,
      YourCommunityBuildingsScheduleUploadPage.numMaxWaitTime
    )

  def waitForFileUploadFail(): Unit =
    YourCommunityBuildingsScheduleUploadPage.waitForElementToContain(
      YourCommunityBuildingsScheduleUploadPage.txtFileStatus,
      YourCommunityBuildingsScheduleUploadPage.txtFileStatusFailed,
      YourCommunityBuildingsScheduleUploadPage.numMaxWaitTime
    )

  def clickRemoveUploadedFile(): Unit = {
    val element = waitForElementToBeClickable(linkRemoveUploadedFile)
    element.click()
  }
}
