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

object ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown extends BasePage {

  override def pageUrl: String = s"$hostname/problem-uploading-connected-charities-schedule-unknown-error"

  override def pageTitle: String =
    "There is a problem uploading your Connected Charities schedule - Charities - GOV.UK"

  def pageHeading: String =
    "There is a problem uploading your Connected Charities schedule"

  def listItem1: String =
    "Your file could not be uploaded. You can try uploading the file again."

  def btnUploadNewSchedule: String =
    "Upload a new schedule"

  def txtReturnToDashboard: String =
    "No, return to manage charity repayment claims"

  val linkReturnToDashboard: By = By.xpath("//a[@href='/charities-claims/make-a-charity-repayment-claim']")

  def validateNavigation(): Unit = {
    ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.verifyPageUrl(
      ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.pageUrl
    )
    ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.verifyPageTitle(
      ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.pageTitle
    )
    ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.verifyPageHeading(
      ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.pageHeading
    )
  }

  def validatePageContent(): Unit =
    ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.verifyEntirePageContent(
      ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.createSingleStringFromMany(
        ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.pageHeading,
        ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.listItem1,
        ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.btnUploadNewSchedule,
        ThereIsAProblemUploadingYourConnectedCharitiesSchedulePage_Unknown.txtReturnToDashboard
      )
    )
}
