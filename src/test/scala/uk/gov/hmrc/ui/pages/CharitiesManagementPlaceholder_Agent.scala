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
    "Manage charity repayment claims - Make a charity tax repayment claim - GOV.UK"

  val pageCaptionAgentID: By = By.xpath("//span[@class='govuk-caption-l'][1]")

  def pageCaption1: String =
    "Agent AGTJOURNEYTEST"

  val pageCaptionAgentRef: By = By.xpath("//span[@class='govuk-caption-l'][2]")

  def pageCaption2: String =
    "Charities Agent reference: AGTJOURNEYTEST"

  def pageHeading: String =
    "Manage charity repayment claims"

  val pageParagraph1: By = By.xpath("//p[@class='govuk-body'][1]")

  def pageParagraph1Text: String =
    "Complete any Gift Aid, Other Income or Community Building (opens in new tab) schedule spreadsheets before making a new claim."

  def pageSubHeading1: String =
    "Make a repayment claim"

  val linkMakeANewClaim: By = By.xpath("//p[@class='govuk-body'][2]")

  def pageParagraph2Text: String =
    "Use this to make a repayment claim"

  val linkToRecognisedSoftware: By = By.xpath("//p[@class='govuk-body'][3]")

  def pageParagraph3Text: String =
    "Use HMRC-recognised software (opens in new tab)"

  def pageSubHeading2: String =
    "Draft charity repayment claims"

  val pageParagraph4: By = By.xpath("//p[@class='govuk-body'][4]")

  def pageParagraph4Text: String =
    "You have 0 claims in draft."

  def clickLinkToMakeANewClaim(): Unit = {
    val element = waitForElementToBeClickable(linkMakeANewClaim)
    element.click()
  }

  def clickLinkToRecognisedSoftware(): Unit = {
    val element = waitForElementToBeClickable(linkToRecognisedSoftware)
    element.click()
  }

  def validateNavigation(): Unit = {
    // CharitiesManagementPlaceholder_Agent.verifyPageUrl(CharitiesManagementPlaceholder_Agent.pageUrl)
    CharitiesManagementPlaceholder_Agent.verifyPageTitle(CharitiesManagementPlaceholder_Agent.pageTitle)
    // CharitiesManagementPlaceholder_Agent.verifyPageCaption(CharitiesManagementPlaceholder_Agent.pageCaption)
    CharitiesManagementPlaceholder_Agent.verifyPageHeading(CharitiesManagementPlaceholder_Agent.pageHeading)
  }

  def validatePageContent(): Unit =
    CharitiesManagementPlaceholder_Agent.verifyEntirePageContent(
      CharitiesManagementPlaceholder_Agent.createSingleStringFromMany(
        CharitiesManagementPlaceholder_Agent.pageCaption1,
        CharitiesManagementPlaceholder_Agent.pageCaption2,
        CharitiesManagementPlaceholder_Agent.pageHeading,
        CharitiesManagementPlaceholder_Agent.pageParagraph1Text,
        CharitiesManagementPlaceholder_Agent.pageSubHeading1,
        CharitiesManagementPlaceholder_Agent.pageParagraph2Text,
        CharitiesManagementPlaceholder_Agent.pageParagraph3Text,
        CharitiesManagementPlaceholder_Agent.pageSubHeading2,
        CharitiesManagementPlaceholder_Agent.pageParagraph4Text
      )
    )
}
