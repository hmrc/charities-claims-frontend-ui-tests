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

object YouHaveAddedAClaimForXTaxYearPage extends BasePage {

  override def pageUrl: String = s"$hostname/claim-added-for-tax-year"

  override def pageTitle: String =
    "You have added a claim for 1 tax year - Make a charity tax repayment claim - GOV.UK"

  def pageTitle2: String =
    "You have added a claim for 2 tax years - Make a charity tax repayment claim - GOV.UK"

  def pageTitle3: String =
    "You have added a claim for 3 tax years - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide GASDS donation details"

  def pageHeading: String =
    "You have added a claim for 1 tax year"

  def pageHeading2: String =
    "You have added a claim for 2 tax years"

  def pageHeading3: String =
    "You have added a claim for 3 tax years"

  def pageLegend: String =
    "Do you want to add a claim for another tax year?"

  def pageHint: String =
    "You can only make claims for up to 3 tax years."

  def pageErrorMsg: String =
    "Select ‘Yes’ if you want to make a claim for another tax year"

  val lnkChangeRow1: By =
    By.xpath("(//a[@class='govuk-link']/span[contains(@class, 'link-text') and text() = 'Change'])[1]")
  val lnkRemoveRow1: By =
    By.xpath("(//a[@class='govuk-link']/span[contains(@class, 'link-text') and text() = 'Remove'])[1]")

  val lnkChangeRow2: By =
    By.xpath("(//a[@class='govuk-link']/span[contains(@class, 'link-text') and text() = 'Change'])[2]")
  val lnkRemoveRow2: By =
    By.xpath("(//a[@class='govuk-link']/span[contains(@class, 'link-text') and text() = 'Remove'])[2]")

  val lnkChangeRow3: By =
    By.xpath("(//a[@class='govuk-link']/span[contains(@class, 'link-text') and text() = 'Change'])[3]")
  val lnkRemoveRow3: By =
    By.xpath("(//a[@class='govuk-link']/span[contains(@class, 'link-text') and text() = 'Remove'])[3]")

  def clickChangeRow1Link(): Unit = {
    val element = waitForElementToBeClickable(lnkChangeRow1)
    element.click()
  }

  def clickRemoveRow1Link(): Unit = {
    val element = waitForElementToBeClickable(lnkRemoveRow1)
    element.click()
  }

  def clickChangeRow2Link(): Unit = {
    val element = waitForElementToBeClickable(lnkChangeRow2)
    element.click()
  }

  def clickRemoveRow2Link(): Unit = {
    val element = waitForElementToBeClickable(lnkRemoveRow2)
    element.click()
  }

  def clickChangeRow3Link(): Unit = {
    val element = waitForElementToBeClickable(lnkChangeRow3)
    element.click()
  }

  def clickRemoveRow3Link(): Unit = {
    val element = waitForElementToBeClickable(lnkRemoveRow3)
    element.click()
  }

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation1(): Unit = {
    YouHaveAddedAClaimForXTaxYearPage.verifyPageUrl(YouHaveAddedAClaimForXTaxYearPage.pageUrl)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageTitle(YouHaveAddedAClaimForXTaxYearPage.pageTitle)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageCaption(YouHaveAddedAClaimForXTaxYearPage.pageCaption)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageHeading(YouHaveAddedAClaimForXTaxYearPage.pageHeading)
  }

  def validateNavigation2(): Unit = {
    YouHaveAddedAClaimForXTaxYearPage.verifyPageUrl(YouHaveAddedAClaimForXTaxYearPage.pageUrl)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageTitle(YouHaveAddedAClaimForXTaxYearPage.pageTitle2)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageCaption(YouHaveAddedAClaimForXTaxYearPage.pageCaption)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageHeading(YouHaveAddedAClaimForXTaxYearPage.pageHeading2)
    YouHaveAddedAClaimForXTaxYearPage.verifyHintText(YouHaveAddedAClaimForXTaxYearPage.pageHint)
  }

  def validateNavigation3(): Unit = {
    YouHaveAddedAClaimForXTaxYearPage.verifyPageUrl(YouHaveAddedAClaimForXTaxYearPage.pageUrl)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageTitle(YouHaveAddedAClaimForXTaxYearPage.pageTitle3)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageCaption(YouHaveAddedAClaimForXTaxYearPage.pageCaption)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageHeading(YouHaveAddedAClaimForXTaxYearPage.pageHeading3)
  }

  def validateNavigation1Agent(): Unit = {
    YouHaveAddedAClaimForXTaxYearPage.verifyPageUrl(YouHaveAddedAClaimForXTaxYearPage.pageUrl)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageTitle(YouHaveAddedAClaimForXTaxYearPage.pageTitle)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageCaption(YouHaveAddedAClaimForXTaxYearPage.pageCaption)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageHeading(YouHaveAddedAClaimForXTaxYearPage.pageHeading)
  }

  def validateNavigation2Agent(): Unit = {
    YouHaveAddedAClaimForXTaxYearPage.verifyPageUrl(YouHaveAddedAClaimForXTaxYearPage.pageUrl)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageTitle(YouHaveAddedAClaimForXTaxYearPage.pageTitle2)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageCaption(YouHaveAddedAClaimForXTaxYearPage.pageCaption)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageHeading(YouHaveAddedAClaimForXTaxYearPage.pageHeading2)
    YouHaveAddedAClaimForXTaxYearPage.verifyHintText(YouHaveAddedAClaimForXTaxYearPage.pageHint)
  }

  def validateNavigation3Agent(): Unit = {
    YouHaveAddedAClaimForXTaxYearPage.verifyPageUrl(YouHaveAddedAClaimForXTaxYearPage.pageUrl)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageTitle(YouHaveAddedAClaimForXTaxYearPage.pageTitle3)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageCaption(YouHaveAddedAClaimForXTaxYearPage.pageCaption)
    YouHaveAddedAClaimForXTaxYearPage.verifyPageHeading(YouHaveAddedAClaimForXTaxYearPage.pageHeading3)
  }

  def validateErrorMessage(): Unit =
    YouHaveAddedAClaimForXTaxYearPage.validateGenericPageError(
      YouHaveAddedAClaimForXTaxYearPage.pageErrorMsg,
      YouHaveAddedAClaimForXTaxYearPage.errorMsgLocator
    )
}
