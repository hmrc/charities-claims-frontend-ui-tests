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

object UploadAConnectedCharitiesSchedulePage extends BasePage {

  override def pageUrl: String = s"$hostname/upload-connected-charities-schedule"

  override def pageTitle: String = "Upload a Connected Charities schedule - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String = "Upload a Connected Charities schedule"

  def pageCaption: String = "Add Connected Charities schedule"

  def pageText1: String =
    "To claim Connected Charities, you need to upload a completed Connected Charities schedule with details of your Connected Charities or Community Amateur Sports Clubs (CASC). You can save your claim without uploading the Connected Charities schedule, but you need to upload a Connected Charities schedule before submitting your claim."

  def pageText2: String =
    "If you have not completed a Connected Charities schedule, download a Connected Charities schedule here (opens in new tab)."

  def pageText3: String = "Upload a file"

  def pageText4: String = "No file chosen"

  def pageText5: String = "Choose file"

  def pageText6: String = "or drop file"

  def continueButton: String = "Continue"

  def pageHiddenText: String = ","

  def pageNoInputErrorMsg: String = "Select a Connected Charities schedule"

  def pageFileTooBigErrorMsg: String = "The selected file must be smaller than 250KB"

  val errorMsgLocator = By.ById("file-error")

  def validateNavigation(): Unit = {
    UploadAConnectedCharitiesSchedulePage.verifyPageUrl(UploadAConnectedCharitiesSchedulePage.pageUrl)
    UploadAConnectedCharitiesSchedulePage.verifyPageTitle(UploadAConnectedCharitiesSchedulePage.pageTitle)
    UploadAConnectedCharitiesSchedulePage.verifyPageCaption(UploadAConnectedCharitiesSchedulePage.pageCaption)
    UploadAConnectedCharitiesSchedulePage.verifyPageHeading(UploadAConnectedCharitiesSchedulePage.pageHeading)
  }

  def validatePageContent(): Unit =
    UploadAConnectedCharitiesSchedulePage.verifyEntirePageContent(
      UploadAConnectedCharitiesSchedulePage.createSingleStringFromMany(
        UploadAConnectedCharitiesSchedulePage.pageCaption,
        UploadAConnectedCharitiesSchedulePage.pageHeading,
        UploadAConnectedCharitiesSchedulePage.pageText1,
        UploadAConnectedCharitiesSchedulePage.pageText2,
        UploadAConnectedCharitiesSchedulePage.pageText3,
        UploadAConnectedCharitiesSchedulePage.pageText4,
        UploadAConnectedCharitiesSchedulePage.pageHiddenText,
        UploadAConnectedCharitiesSchedulePage.pageText5,
        UploadAConnectedCharitiesSchedulePage.pageText6,
        UploadAConnectedCharitiesSchedulePage.continueButton
      )
    )

  /** Validate that the no file selected/upload error message is correct */
  def validateNoInputErrorMessage(): Unit =
    UploadAConnectedCharitiesSchedulePage.validateGenericPageError(
      UploadAConnectedCharitiesSchedulePage.pageNoInputErrorMsg,
      UploadAConnectedCharitiesSchedulePage.errorMsgLocator
    )

  /** Validate that the file above max size error message is correct */
  def validateOversizeErrorMessage(): Unit =
    UploadAConnectedCharitiesSchedulePage.validateUploadFilePageError(
      UploadAConnectedCharitiesSchedulePage.pageFileTooBigErrorMsg,
      UploadAConnectedCharitiesSchedulePage.errorMsgLocator
    )

}
