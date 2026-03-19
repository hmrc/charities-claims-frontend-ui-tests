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

object UploadAGiftAidSchedulePage extends BasePage {

  override def pageUrl: String = s"$hostname/upload-gift-aid-schedule"

  override def pageTitle: String =
    "Upload a Gift Aid schedule - Charities - GOV.UK"

  def pageCaption: String =
    "Add Gift Aid schedule"

  def pageHeading: String =
    "Upload a Gift Aid schedule"

  def pageText1: String =
    "To claim Gift Aid, you need to upload a completed Gift Aid schedule with details of your donors and donations. You can save your claim without uploading the Gift Aid schedule, but you need to upload a Gift Aid schedule before submitting your claim."

  def pageText2: String =
    "If you have not completed a Gift Aid schedule, download a Gift Aid schedule here (opens in new tab)."

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
    "Select a Gift Aid schedule"

  def pageFileTooBigErrorMsg: String =
    "The selected file must be smaller than 250KB"

  val errorMsgLocator = By.ById("file-error")

  def validateNavigation(): Unit = {
    UploadAGiftAidSchedulePage.verifyPageUrl(UploadAGiftAidSchedulePage.pageUrl)
    UploadAGiftAidSchedulePage.verifyPageTitle(UploadAGiftAidSchedulePage.pageTitle)
    UploadAGiftAidSchedulePage.verifyPageCaption(UploadAGiftAidSchedulePage.pageCaption)
    UploadAGiftAidSchedulePage.verifyPageHeading(UploadAGiftAidSchedulePage.pageHeading)
  }

  def validatePageContent(): Unit =
    UploadAGiftAidSchedulePage.verifyEntirePageContent(
      UploadAGiftAidSchedulePage.createSingleStringFromMany(
        UploadAGiftAidSchedulePage.pageCaption,
        UploadAGiftAidSchedulePage.pageHeading,
        UploadAGiftAidSchedulePage.pageText1,
        UploadAGiftAidSchedulePage.pageText2,
        UploadAGiftAidSchedulePage.pageText3,
        UploadAGiftAidSchedulePage.pageText4,
        UploadAGiftAidSchedulePage.pageHiddenText,
        UploadAGiftAidSchedulePage.pageText5,
        UploadAGiftAidSchedulePage.pageText6,
        UploadAGiftAidSchedulePage.pageText7
      )
    )

  /** Validate that the no input error message is correct */
  def validateNoInputErrorMessage(): Unit =
    UploadAGiftAidSchedulePage.validateGenericPageError(
      UploadAGiftAidSchedulePage.pageNoInputErrorMsg,
      UploadAGiftAidSchedulePage.errorMsgLocator
    )

  /** Validate that the file above max size error message is correct */
  def validateOversizeErrorMessage(): Unit =
    UploadAGiftAidSchedulePage.validateUploadFilePageError(
      UploadAGiftAidSchedulePage.pageFileTooBigErrorMsg,
      UploadAGiftAidSchedulePage.errorMsgLocator
    )
}
