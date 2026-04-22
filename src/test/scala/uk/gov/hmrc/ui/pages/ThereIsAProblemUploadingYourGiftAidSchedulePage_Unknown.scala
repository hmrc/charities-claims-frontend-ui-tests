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

object ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown extends BasePage {

  override def pageUrl: String = s"$hostname/problem-uploading-gift-aid-schedule-unknown-error"

  override def pageTitle: String =
    "There is a problem uploading your Gift Aid schedule - Charities - GOV.UK"

  def pageHeading: String =
    "There is a problem uploading your Gift Aid schedule"

  def listItem1: String =
    "Your file could not be uploaded. You can try uploading the file again."

  def btnUploadNewSchedule: String =
    "Upload a new schedule"

  def txtReturnToDashboard: String =
    "No, return to manage charity repayment claims"

  def validateNavigation(): Unit = {
    ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.verifyPageUrl(
      ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.pageUrl
    )
    ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.verifyPageTitle(
      ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.pageTitle
    )
    ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.verifyPageHeading(
      ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.pageHeading
    )
  }

  def validatePageContent(): Unit =
    ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.verifyEntirePageContent(
      ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.createSingleStringFromMany(
        ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.pageHeading,
        ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.listItem1,
        ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.btnUploadNewSchedule,
        ThereIsAProblemUploadingYourGiftAidSchedulePage_Unknown.txtReturnToDashboard
      )
    )
}
