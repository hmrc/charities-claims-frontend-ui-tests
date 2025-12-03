/*
 * Copyright 2023 HM Revenue & Customs
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

object CheckYourClaimDetailsPage extends BasePage {

  override def pageUrl: String = s"$hostname/check-your-claim-details"

  override def pageTitle: String =
    "Check your claim details - Charities - GOV.UK"

  def pageHeader: String =
    "Check your claim details"

  def validateNavigation(): Unit = {
    CheckYourClaimDetailsPage.verifyPageUrl(CheckYourClaimDetailsPage.pageUrl)
    CheckYourClaimDetailsPage.verifyPageTitle(CheckYourClaimDetailsPage.pageTitle)
    CheckYourClaimDetailsPage.verifyPageHeader(CheckYourClaimDetailsPage.pageHeader)
  }

  val linkChangeClaimingGiftAid: By     = By.xpath("//a[@href='/charities-claims/change-claim-gift-aid']")
  val linkChangeClaimingTaxDeducted: By = By.xpath("//a[@href='/charities-claims/change-claiming-other-income']")
  val linkChangeClaimingGASDS: By       = By.xpath("//a[@href='/charities-claims/change-gift-aid-small-donations-scheme']")
  val linkChangeDoYouHaveARefNo: By     = By.xpath("//a[@href='/charities-claims/change-claim-reference-number']")
  val linkChangeRefNoInput: By          = By.xpath("//a[@href='/charities-claims/change-your-claim-reference-number']")

  def clickChangeAreYouClaimingGiftAid(): Unit = {
    val element = waitForElementToBeClickable(linkChangeClaimingGiftAid)
    element.click()
  }

  def clickChangeAreYouClaimingTaxDeducted(): Unit = {
    val element = waitForElementToBeClickable(linkChangeClaimingTaxDeducted)
    element.click()
  }

  def clickChangeAreYouClaimingForTheGASDS(): Unit = {
    val element = waitForElementToBeClickable(linkChangeClaimingGASDS)
    element.click()
  }

  def clickChangeDoYouHaveAClaimRefNo(): Unit = {
    val element = waitForElementToBeClickable(linkChangeDoYouHaveARefNo)
    element.click()
  }

  def clickChangeWhatIsYourRefNo(): Unit = {
    val element = waitForElementToBeClickable(linkChangeRefNoInput)
    element.click()
  }
}
