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

object CheckYourOrganisationDetailsPage extends BasePage {

  override def pageUrl: String = s"$hostname/check-your-organisation-details"

  override def pageTitle: String =
    "Check your organisation details - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeading: String =
    "Check your organisation details"

  def charityRegulatorName: String =
    "Charity regulator name"

  def charityRegulatorNumber: String =
    "Charity regulator number"

  // TODO review headers and text due to CYA changes
  def corporateTrusteeClaim: String =
    "Corporate trustee claim"

  def corporateTrusteeUKAddress: String =
    "Corporate trustee UK address"

  def corporateTrusteeDetails: String =
    "Corporate trustee details"

  def authorisedOfficialUKAddress: String =
    "Authorised official’s UK address"

  def authorisedOfficialDetails: String =
    "Authorised official’s details"

  def validateNavigation(): Unit = {
    CheckYourOrganisationDetailsPage.verifyPageUrl(CheckYourOrganisationDetailsPage.pageUrl)
    CheckYourOrganisationDetailsPage.verifyPageTitle(CheckYourOrganisationDetailsPage.pageTitle)
    CheckYourOrganisationDetailsPage.verifyPageCaption(CheckYourOrganisationDetailsPage.pageCaption)
    CheckYourOrganisationDetailsPage.verifyPageHeading(CheckYourOrganisationDetailsPage.pageHeading)
  }

  def validateNavigationAgent(): Unit = {
    CheckYourOrganisationDetailsPage.verifyPageUrl(CheckYourOrganisationDetailsPage.pageUrl)
    //CheckYourOrganisationDetailsPage.verifyPageTitle(CheckYourOrganisationDetailsPage.pageTitle)
    CheckYourOrganisationDetailsPage.verifyPageCaption(CheckYourOrganisationDetailsPage.pageCaption)
    //CheckYourOrganisationDetailsPage.verifyPageHeading(CheckYourOrganisationDetailsPage.pageHeading)
  }

  val linkChangeCharityRegulatorName: By      = By.xpath("//a[@href='/charities-claims/change-name-of-charity-regulator']")
  val linkChangeRegisteredWithRegulator: By   = By.xpath("//a[@href='/charities-claims/change-charity-not-registered']")
  val linkChangeCharityRegulatorNumber: By    = By.xpath("//a[@href='/charities-claims/change-charity-regulator-number']")
  val linkChangeCorporateTrusteeClaim: By     = By.xpath("//a[@href='/charities-claims/change-corporate-trustee-claim']")
  val linkChangeCorporateTrusteeUKAddress: By =
    By.xpath("//a[@href='/charities-claims/change-corporate-trustee-address']")
  val linkChangeCorporateTrusteeDetails: By   =
    By.xpath("//a[@href='/charities-claims/change-corporate-trustee-details']")
  val linkChangeAuthOfficialUKAddress: By     =
    By.xpath("//a[@href='/charities-claims/change-authorised-official-address']")
  val linkChangeAuthOfficialDetails: By       = By.xpath("//a[@href='/charities-claims/change-authorised-official-address']")

  def clickChangeCharityRegulatorName(): Unit = {
    val element = waitForElementToBeClickable(linkChangeCharityRegulatorName)
    element.click()
  }

  def clickChangeRegisteredWithRegulator(): Unit = {
    val element = waitForElementToBeClickable(linkChangeRegisteredWithRegulator)
    element.click()
  }

  def clickChangeCharityRegulatorNumber(): Unit = {
    val element = waitForElementToBeClickable(linkChangeCharityRegulatorNumber)
    element.click()
  }

  def clickChangeCorporateTrusteeClaim(): Unit = {
    val element = waitForElementToBeClickable(linkChangeCorporateTrusteeClaim)
    element.click()
  }

  def clickChangeCorporateTrusteeUKAddress(): Unit = {
    val element = waitForElementToBeClickable(linkChangeCorporateTrusteeUKAddress)
    element.click()
  }

  def clickChangeCorporateTrusteeDetails(): Unit = {
    val element = waitForElementToBeClickable(linkChangeCorporateTrusteeDetails)
    element.click()
  }

  def clickChangeAuthOfficialUKAddress(): Unit = {
    val element = waitForElementToBeClickable(linkChangeAuthOfficialUKAddress)
    element.click()
  }

  def clickChangeAuthOfficialDetails(): Unit = {
    val element = waitForElementToBeClickable(linkChangeAuthOfficialDetails)
    element.click()
  }
}
