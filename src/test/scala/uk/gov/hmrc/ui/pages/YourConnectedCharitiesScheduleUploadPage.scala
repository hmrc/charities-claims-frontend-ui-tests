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

object YourConnectedCharitiesScheduleUploadPage extends BasePage {
  override def pageUrl: String = s"$hostname/your-connected-charities-schedule-upload"

  override def pageTitle: String =
    "Your Connected Charities schedule upload - Charities - GOV.UK"

  def pageCaption: String =
    "Add Connected Charities schedule"

  def pageHeading: String =
    "Your Connected Charities schedule upload"

  def pageParagraph: String =
    "You can upload your Connected Charities schedule as a spreadsheet. The selected file must be smaller than 250KB."

  val linkRemoveUploadedFile: By =
    By.xpath("//a[@href='/charities-claims/your-connected-charities-schedule-upload/remove']")

  def continueButton: String = "Continue"

  val txtFileStatus: By = By.xpath("//dd[@class='govuk-summary-list__value']")

  def txtFileStatusUploaded: String = "Uploaded"

  def txtFileStatusFailed: String = "Failed"

  def numMaxWaitTime: Int = 6

  def validateNavigation(): Unit = {
    YourConnectedCharitiesScheduleUploadPage.verifyPageUrl(YourConnectedCharitiesScheduleUploadPage.pageUrl)
    YourConnectedCharitiesScheduleUploadPage.verifyPageTitle(YourConnectedCharitiesScheduleUploadPage.pageTitle)
    YourConnectedCharitiesScheduleUploadPage.verifyPageCaption(YourConnectedCharitiesScheduleUploadPage.pageCaption)
    YourConnectedCharitiesScheduleUploadPage.verifyPageHeading(YourConnectedCharitiesScheduleUploadPage.pageHeading)
  }

  def validateParagraph(): Unit =
    YourConnectedCharitiesScheduleUploadPage.verifyParagraphText(YourConnectedCharitiesScheduleUploadPage.pageParagraph)

  def waitForFileUpload(): Unit =
    YourConnectedCharitiesScheduleUploadPage.waitForElementToContain(
      YourConnectedCharitiesScheduleUploadPage.txtFileStatus,
      YourConnectedCharitiesScheduleUploadPage.txtFileStatusUploaded,
      YourConnectedCharitiesScheduleUploadPage.numMaxWaitTime
    )

  def waitForFileUploadFail(): Unit =
    YourConnectedCharitiesScheduleUploadPage.waitForElementToContain(
      YourConnectedCharitiesScheduleUploadPage.txtFileStatus,
      YourConnectedCharitiesScheduleUploadPage.txtFileStatusFailed,
      YourConnectedCharitiesScheduleUploadPage.numMaxWaitTime
    )

  def clickRemoveUploadedFile(): Unit = {
    val element = waitForElementToBeClickable(linkRemoveUploadedFile)
    element.click()
  }
}
