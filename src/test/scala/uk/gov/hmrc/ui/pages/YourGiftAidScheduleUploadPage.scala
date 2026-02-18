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

object YourGiftAidScheduleUploadPage extends BasePage {

  override def pageUrl: String = s"$hostname/your-gift-aid-schedule-upload"

  override def pageTitle: String =
    "Your Gift Aid schedule upload - Charities - GOV.UK"

  def pageCaption: String =
    "Add Gift Aid schedule"

  def pageHeading: String =
    "Your Gift Aid schedule upload"

  def pageParagraph: String =
    "You can upload your Gift Aid schedule as a spreadsheet. The selected file must be smaller than 250KB."

  val linkRemoveUploadedFile: By = By.xpath("//a[@href='/charities-claims/your-gift-aid-schedule-upload/remove']")

  def btnContinue: String =
    "Continue"

  val txtFileStatus: By = By.xpath("//dd[@class='govuk-summary-list__value']")

  def txtFileStatusUploaded: String =
    "Uploaded"

  def numMaxWaitTime: Int = 6

  def validateNavigation(): Unit = {
    YourGiftAidScheduleUploadPage.verifyPageUrl(YourGiftAidScheduleUploadPage.pageUrl)
    YourGiftAidScheduleUploadPage.verifyPageTitle(YourGiftAidScheduleUploadPage.pageTitle)
    YourGiftAidScheduleUploadPage.verifyPageCaption(YourGiftAidScheduleUploadPage.pageCaption)
    YourGiftAidScheduleUploadPage.verifyPageHeader(YourGiftAidScheduleUploadPage.pageHeading)
  }

  def validateParagraph(): Unit = {
    YourGiftAidScheduleUploadPage.verifyParagraphText(
      YourGiftAidScheduleUploadPage.pageParagraph
    )
  }

  def waitForFileUpload(): Unit = {
    YourGiftAidScheduleUploadPage.waitForElementToContain(
      YourGiftAidScheduleUploadPage.txtFileStatus,
      YourGiftAidScheduleUploadPage.txtFileStatusUploaded,
      YourGiftAidScheduleUploadPage.numMaxWaitTime
    )
  }

  def clickRemoveUploadedFile(): Unit = {
    val element = waitForElementToBeClickable(linkRemoveUploadedFile)
    element.click()
  }
}
