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

object CheckYourDonationDetailsPage extends BasePage {

  override def pageUrl: String = s"$hostname/check-claim-details-for-tax-year"

  def pageUrl1: String = pageUrl + "/1"

  def pageUrl2: String = pageUrl + "/2"

  def pageUrl3: String = pageUrl + "/3"

  override def pageTitle: String =
    "Check your claim details for tax year"

  def pageTitle1: String =
    pageTitle + " 1 - Make a charity tax repayment claim - GOV.UK"

  def pageTitle2: String =
    pageTitle + " 2 - Make a charity tax repayment claim - GOV.UK"

  def pageTitle3: String =
    pageTitle + " 3 - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide GASDS donation details"

  def pageCaption2: String =
    pageCaption + " - Tax year 2"

  def pageCaption3: String =
    pageCaption + " - Tax year 3"

  def pageHeading: String =
    "Check your claim details for tax year "

  def pageHeading1: String =
    pageHeading + "1"

  def pageHeading2: String =
    pageHeading + "2"

  def pageHeading3: String =
    pageHeading + "3"

  def validateNavigation1(): Unit = {
    CheckYourDonationDetailsPage.verifyPageUrl(CheckYourDonationDetailsPage.pageUrl1)
    CheckYourDonationDetailsPage.verifyPageTitle(CheckYourDonationDetailsPage.pageTitle1)
    CheckYourDonationDetailsPage.verifyPageCaption(CheckYourDonationDetailsPage.pageCaption)
    CheckYourDonationDetailsPage.verifyPageHeading(CheckYourDonationDetailsPage.pageHeading1)

  }

  def validateNavigation2(): Unit = {
    CheckYourDonationDetailsPage.verifyPageUrl(CheckYourDonationDetailsPage.pageUrl2)
    CheckYourDonationDetailsPage.verifyPageTitle(CheckYourDonationDetailsPage.pageTitle2)
    CheckYourDonationDetailsPage.verifyPageCaption(CheckYourDonationDetailsPage.pageCaption2)
    CheckYourDonationDetailsPage.verifyPageHeading(CheckYourDonationDetailsPage.pageHeading2)

  }

  def validateNavigation3(): Unit = {
    CheckYourDonationDetailsPage.verifyPageUrl(CheckYourDonationDetailsPage.pageUrl3)
    CheckYourDonationDetailsPage.verifyPageTitle(CheckYourDonationDetailsPage.pageTitle3)
    CheckYourDonationDetailsPage.verifyPageCaption(CheckYourDonationDetailsPage.pageCaption3)
    CheckYourDonationDetailsPage.verifyPageHeading(CheckYourDonationDetailsPage.pageHeading3)

  }


  val linkChangeTaxYear1: By      = By.xpath("//a[@href='/charities-claims/change-which-tax-year-are-you-claiming-for/1']")
  val linkChangeDonationAmount1: By   = By.xpath("//a[@href='/charities-claims/donation-amount-you-are-claiming/1']")
  val linkChangeTaxYear2: By = By.xpath("//a[@href='/charities-claims/change-which-tax-year-are-you-claiming-for/2']")
  val linkChangeDonationAmount2: By = By.xpath("//a[@href='/charities-claims/donation-amount-you-are-claiming/2']")
  val linkChangeTaxYear3: By = By.xpath("//a[@href='/charities-claims/change-which-tax-year-are-you-claiming-for/3']")
  val linkChangeDonationAmount3: By = By.xpath("//a[@href='/charities-claims/donation-amount-you-are-claiming/3']")

  def clickChangeTaxYear1() : Unit = {
    val element = waitForElementToBeClickable(linkChangeTaxYear1)
    element.click()
  }

  def clickChangeDonationAmount1(): Unit = {
    val element = waitForElementToBeClickable(linkChangeDonationAmount1)
    element.click()
  }

  def clickChangeTaxYear2(): Unit = {
    val element = waitForElementToBeClickable(linkChangeTaxYear3)
    element.click()
  }

  def clickChangeDonationAmount2(): Unit = {
    val element = waitForElementToBeClickable(linkChangeDonationAmount3)
    element.click()
  }

  def clickChangeTaxYear3(): Unit = {
    val element = waitForElementToBeClickable(linkChangeTaxYear3)
    element.click()
  }

  def clickChangeDonationAmount3(): Unit = {
    val element = waitForElementToBeClickable(linkChangeDonationAmount3)
    element.click()
  }

}
