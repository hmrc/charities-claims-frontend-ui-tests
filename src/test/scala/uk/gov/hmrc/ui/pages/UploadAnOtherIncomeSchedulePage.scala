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

object UploadAnOtherIncomeSchedulePage extends BasePage {
  override def pageUrl: String = s"$hostname/upload-other-income-schedule"

  override def pageTitle: String = "Upload an Other Income schedule - Charities - GOV.UK"

  def pageHeading: String = "Upload an Other Income schedule"

  def pageCaption: String = "Add Other Income schedule"

  def pageText1: String =
    "To claim Other Income, you need to upload a completed Other Income schedule with details of your donors and donations. You can save your claim without uploading the Other Income schedule, but you need to upload an Other Income schedule before submitting your claim."

  def pageText2: String =
    "If you have not completed an Other Income schedule, download an Other Income schedule here (opens in new tab)."

  def pageText3: String = "Upload a file."

  def pageText4: String = "No file chosen"

  def pageText5: String = "Choose file"

  def pageText6: String = "or drop file"

  def continueButton: String = "Continue"

//  def pageErrorMsg: String = "There is a problem"

  def pageNoInputErrorMsg: String = "Select an Other Income schedule"

  def pageFileTooBigErrorMsg: String = "The selected file must be smaller than 250KB"

//  val fileUploadFieldLocator  = By.ById("file")
  val errorMsgLocator = By.ById("file-error")

  def clickFileUploader(spreadsheet: String): Unit = {
    selectFile(spreadsheet)
    clickContinue()
  }

  def validateNavigation(): Unit = {
    UploadAnOtherIncomeSchedulePage.verifyPageUrl(UploadAnOtherIncomeSchedulePage.pageUrl)
    UploadAnOtherIncomeSchedulePage.verifyPageTitle(UploadAnOtherIncomeSchedulePage.pageTitle)
  }

  def validatePageContent(): Unit =
    UploadAnOtherIncomeSchedulePage.verifyEntirePageContent(
      UploadAnOtherIncomeSchedulePage.createSingleStringFromMany(
        UploadAnOtherIncomeSchedulePage.pageCaption,
        UploadAnOtherIncomeSchedulePage.pageHeading,
        UploadAnOtherIncomeSchedulePage.pageText1,
        UploadAnOtherIncomeSchedulePage.pageText2,
        UploadAnOtherIncomeSchedulePage.pageText3,
        UploadAnOtherIncomeSchedulePage.pageText4,
        UploadAnOtherIncomeSchedulePage.pageText5,
        UploadAnOtherIncomeSchedulePage.pageText6,
        UploadAnOtherIncomeSchedulePage.continueButton
      )
    )

  /** Validate that the no file selected/upload error message is correct */
  def validateNoInputErrorMessage(): Unit =
    UploadAnOtherIncomeSchedulePage.validateGenericPageError(
      UploadAnOtherIncomeSchedulePage.pageNoInputErrorMsg,
      UploadAnOtherIncomeSchedulePage.errorMsgLocator
    )

  /** Validate that the file above max size error message is correct */
  def validateOversizeErrorMessage(): Unit =
    UploadAnOtherIncomeSchedulePage.validateUploadFilePageError(
      UploadAnOtherIncomeSchedulePage.pageFileTooBigErrorMsg,
      UploadAnOtherIncomeSchedulePage.errorMsgLocator
    )
}
