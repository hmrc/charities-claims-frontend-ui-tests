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
import scala.util.Random

object CharitiesManagementPlaceholder extends BasePage {

  override def pageUrl: String = s"$hostname/charities-management/manage-charity-repayment-claim"

  override def pageTitle: String =
    "Manage charity repayment claim - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String = "Organisation"

  def pageCaption2: String = "HMRC Charities reference:"

  def pageHeading: String =
    "Manage charity repayment claim"

  def txtParagraph1: String =
    "Complete any Gift Aid, Other Income or Community Buildings (opens in new tab) schedule spreadsheets before making a new claim."

  def pageSubHeading: String = "Make a repayment claim"

  def txtUseCharitiesOnlineServiceLink: String = "Use the charities online service"

  def txtUseHMRCRecognisedSoftwareLink: String = "Use HMRC-recognised software (opens in new tab)"

  val lnkUseTheCharities: By = By.xpath("//a[@href and contains(text(),'Use the charities online service')]")
  val lnkContinueClaim: By   = By.xpath("//a[@href and contains(text(),'Continue with draft claim')]")

  def validateNavigation(): Unit = {
    // CharitiesManagementPlaceholder.verifyPageUrl(CharitiesManagementPlaceholder.pageUrl)
    CharitiesManagementPlaceholder.verifyPageTitle(CharitiesManagementPlaceholder.pageTitle)
    CharitiesManagementPlaceholder.verifyDynamicPageCaption2(CharitiesManagementPlaceholder.pageCaption2)
    CharitiesManagementPlaceholder.verifyPageHeading(CharitiesManagementPlaceholder.pageHeading)
  }

  def validatePageContent(): Unit = {
    CharitiesManagementPlaceholder.verifyPageSubHeading1(CharitiesManagementPlaceholder.pageSubHeading)
    CharitiesManagementPlaceholder.verifyPageContentBelowPanel1(CharitiesManagementPlaceholder.txtParagraph1)
    CharitiesManagementPlaceholder.verifyPageContentBelowPanel2(
      CharitiesManagementPlaceholder.txtUseCharitiesOnlineServiceLink
    )
    CharitiesManagementPlaceholder.verifyPageContentBelowPanel3(
      CharitiesManagementPlaceholder.txtUseHMRCRecognisedSoftwareLink
    )
  }

  def clickUseTheCharitiesLink(): Unit = {
    val element = waitForElementToBeClickable(lnkUseTheCharities)
    element.click()
  }

  def clickContinueClaimLink(): Unit = {
    val element = waitForElementToBeClickable(lnkContinueClaim)
    element.click()
  }

  def randomVarchar6(): String =
    Random.alphanumeric.take(6).mkString

  val RandomUsernameOrg = randomVarchar6()
}
