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

object CheckYourClaimDetailsForTaxYearPage extends BasePage {

  override def pageUrl: String = s"$hostname/check-claim-details-for-tax-year"

  override def pageTitle: String =
    "Check your claim details for tax year 1 - Make a charity tax repayment claim - GOV.UK"

  def pageTitle2: String =
    "Check your claim details for tax year 2 - Make a charity tax repayment claim - GOV.UK"

  def pageTitle3: String =
    "Check your claim details for tax year 3 - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide GASDS donation details"

  def pageHeading: String =
    "Check your claim details for tax year"

  def validateNavigation1(): Unit = {
    CheckYourClaimDetailsForTaxYearPage.verifyPageUrl(CheckYourClaimDetailsForTaxYearPage.pageUrl + "/1")
    CheckYourClaimDetailsForTaxYearPage.verifyPageTitle(CheckYourClaimDetailsForTaxYearPage.pageTitle)
    CheckYourClaimDetailsForTaxYearPage.verifyPageCaption(CheckYourClaimDetailsForTaxYearPage.pageCaption)
    CheckYourClaimDetailsForTaxYearPage.verifyPageHeading(CheckYourClaimDetailsForTaxYearPage.pageHeading + " 1")
  }

  def validateNavigation2(): Unit = {
    CheckYourClaimDetailsForTaxYearPage.verifyPageUrl(CheckYourClaimDetailsForTaxYearPage.pageUrl + "/2")
    CheckYourClaimDetailsForTaxYearPage.verifyPageTitle(CheckYourClaimDetailsForTaxYearPage.pageTitle2)
    CheckYourClaimDetailsForTaxYearPage.verifyPageCaption(CheckYourClaimDetailsForTaxYearPage.pageCaption)
    CheckYourClaimDetailsForTaxYearPage.verifyPageHeading(CheckYourClaimDetailsForTaxYearPage.pageHeading + " 2")
  }

  def validateNavigation3(): Unit = {
    CheckYourClaimDetailsForTaxYearPage.verifyPageUrl(CheckYourClaimDetailsForTaxYearPage.pageUrl + "/3")
    CheckYourClaimDetailsForTaxYearPage.verifyPageTitle(CheckYourClaimDetailsForTaxYearPage.pageTitle3)
    CheckYourClaimDetailsForTaxYearPage.verifyPageCaption(CheckYourClaimDetailsForTaxYearPage.pageCaption)
    CheckYourClaimDetailsForTaxYearPage.verifyPageHeading(CheckYourClaimDetailsForTaxYearPage.pageHeading + " 3")
  }

  val linkChangeTaxYear: By        = By.xpath("//dt[contains(text(),'Tax year')]/following-sibling::dd[2]/a")
  val linkChangeDonationAmount: By = By.xpath("//dt[contains(text(),'Donation amount')]/following-sibling::dd[2]/a")

  def clickChangeTaxYear(): Unit = {
    val element = waitForElementToBeClickable(linkChangeTaxYear)
    element.click()
  }

  def clickChangeDonationAmount(): Unit = {
    val element = waitForElementToBeClickable(linkChangeDonationAmount)
    element.click()
  }
}
