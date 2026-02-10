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

  def pageHeader: String =
    "Upload a Gift Aid schedule"

  def pageText1: String =
    "To claim Gift Aid, you need to upload a completed Gift Aid schedule with details of your donors and donations. You can save your claim without uploading the Gift Aid schedule, but you need to upload a Gift Aid schedule before submitting your claim."

  def pageText2: String =
    "If you have not completed a Gift Aid schedule, download a Gift Aid schedule here (opens in new tab)."

  def pageErrorMsg: String =
    "Select a Gift Aid schedule"

  val fileUploadFieldLocator = By.ById("value")
  val errorMsgLocator        = By.ById("value-error")

  def enterClaimReferenceNumber(referenceNo: String): Unit = {
    input(Locators.inputReferenceNumber, referenceNo)
    clickContinue()
  }

  def validateNavigation(): Unit = {
    UploadAGiftAidSchedulePage.verifyPageUrl(UploadAGiftAidSchedulePage.pageUrl)
    UploadAGiftAidSchedulePage.verifyPageTitle(UploadAGiftAidSchedulePage.pageTitle)
    UploadAGiftAidSchedulePage.verifyPageCaption(UploadAGiftAidSchedulePage.pageCaption)
    UploadAGiftAidSchedulePage.verifyPageHeader(UploadAGiftAidSchedulePage.pageHeader)
  }

  def validatePageContent(): Unit =
    UploadAGiftAidSchedulePage.verifyEntirePageContent(
      UploadAGiftAidSchedulePage.createSingleStringFromMany(
        UploadAGiftAidSchedulePage.pageCaption,
        UploadAGiftAidSchedulePage.pageHeader,
        UploadAGiftAidSchedulePage.pageText1,
        UploadAGiftAidSchedulePage.pageText2
//        UploadAGiftAidSchedulePage.listItem3
      )
    )

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    UploadAGiftAidSchedulePage.validateGenericPageError(
      UploadAGiftAidSchedulePage.pageErrorMsg,
      UploadAGiftAidSchedulePage.errorMsgLocator
    )
}
