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

object CharitiesManagementPlaceholder_Agent extends BasePage {

  override def pageUrl: String = s"$hostname/charities-management/charity-repayment-dashboard"

  override def pageTitle: String =
    "Manage Charity repayment claims - Make a charity tax repayment claim - GOV.UK"

  val pageCaptionAgentID: By = By.xpath("//span[@class='govuk-caption-l'][1]")

  val pageCaptionAgentRef: By = By.xpath("//span[@class='govuk-caption-l'][2]")

  def pageHeading: String =
    "Manage Charity repayment claims"

  val pageParagraph1: By = By.xpath("//p[@class='govuk-body'][1]")

  def pageSubHeading1: String =
    "Make a repayment claim"

  val pageParagraph2: By = By.xpath("//p[@class='govuk-body'][2]")

  val pageParagraph3: By = By.xpath("//p[@class='govuk-body'][3]")

  def pageSubHeading2: String =
    "Draft charity repayment claims"

  val pageParagraph4: By = By.xpath("//p[@class='govuk-body'][4]")

  def validateNavigation(): Unit = {
    // CharitiesManagementPlaceholder_Agent.verifyPageUrl(CharitiesManagementPlaceholder.pageUrl)
    CharitiesManagementPlaceholder_Agent.verifyPageTitle(CharitiesManagementPlaceholder.pageTitle)
    // CharitiesManagementPlaceholder_Agent.verifyPageCaption(CharitiesManagementPlaceholder.pageCaption)
    CharitiesManagementPlaceholder_Agent.verifyPageHeading(CharitiesManagementPlaceholder.pageHeading)
  }
}
