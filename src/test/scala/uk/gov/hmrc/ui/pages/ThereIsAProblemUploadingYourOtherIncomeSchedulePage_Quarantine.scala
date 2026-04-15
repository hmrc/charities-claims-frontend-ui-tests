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

object ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine extends BasePage {

  override def pageUrl: String = s"$hostname/problem-uploading-other-income-schedule-quarantine"

  override def pageTitle: String =
    "There is a problem uploading your Other Income schedule - Charities - GOV.UK"

  def pageHeading: String =
    "There is a problem uploading your Other Income schedule"

  def listItem1: String =
    "Your file contains a virus, so it cannot be uploaded. Check the file for viruses or create a new version before uploading it again."

  def btnUploadNewSchedule: String =
    "Upload a new schedule"

  def txtReturnToDashboard: String =
    "No, return to manage charity repayment claims"

  val linkReturnToDashboard: By = By.xpath("//a[@href='/charities-claims/make-a-charity-repayment-claim']")

  def validateNavigation(): Unit = {
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.verifyPageUrl(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.pageUrl
    )
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.verifyPageTitle(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.pageTitle
    )
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.verifyPageHeading(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.pageHeading
    )
  }

  def validatePageContent(): Unit =
    ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.verifyEntirePageContent(
      ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.createSingleStringFromMany(
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.pageHeading,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.listItem1,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.btnUploadNewSchedule,
        ThereIsAProblemUploadingYourOtherIncomeSchedulePage_Quarantine.txtReturnToDashboard
      )
    )
}
