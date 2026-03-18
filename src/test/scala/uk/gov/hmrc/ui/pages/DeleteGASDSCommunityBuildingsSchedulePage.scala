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

object DeleteGASDSCommunityBuildingsSchedulePage extends BasePage {

  override def pageUrl: String = s"$hostname/delete-gasds-community-buildings-schedule"

  override def pageTitle: String =
    "Do you want to delete this Gift Aid Small Donations Scheme community buildings schedule? - Charities - GOV.UK"

  def pageHeading: String =
    "Do you want to delete this Gift Aid Small Donations Scheme community buildings schedule?"

  def pageErrorMsg: String =
    "Select ‘Yes’ if you want to delete this Gift Aid Small Donations Scheme community buildings schedule"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    DeleteGASDSCommunityBuildingsSchedulePage.verifyPageUrl(DeleteGASDSCommunityBuildingsSchedulePage.pageUrl)
    DeleteGASDSCommunityBuildingsSchedulePage.verifyPageTitle(DeleteGASDSCommunityBuildingsSchedulePage.pageTitle)
    DeleteGASDSCommunityBuildingsSchedulePage.verifyPageHeading(DeleteGASDSCommunityBuildingsSchedulePage.pageHeading)
  }

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    DeleteGASDSCommunityBuildingsSchedulePage.validateGenericPageError(
      DeleteGASDSCommunityBuildingsSchedulePage.pageErrorMsg,
      DeleteGASDSCommunityBuildingsSchedulePage.errorMsgLocator
    )
}
