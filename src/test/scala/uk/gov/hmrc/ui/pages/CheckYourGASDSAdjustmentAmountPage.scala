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

object CheckYourGASDSAdjustmentAmountPage extends BasePage {

  override def pageUrl: String = s"$hostname/check-gift-aid-small-donations-scheme-adjustment-amount"

  def changePageUrl: String = s"$hostname/change-check-gift-aid-small-donations-scheme-adjustment-amount"

  override def pageTitle: String =
    "Check your GASDS adjustment amount - Make a charity tax repayment claim - GOV.UK"

  def pageTitleAgent: String =
    "Check this GASDS adjustment amount - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide GASDS donation details"

  def pageHeading: String =
    "Check your GASDS adjustment amount"

  def pageHeadingAgent: String =
    "Check this GASDS adjustment amount"

  def validateNavigation(): Unit = {
    CheckYourGASDSAdjustmentAmountPage.verifyPageUrl(CheckYourGASDSAdjustmentAmountPage.pageUrl)
    CheckYourGASDSAdjustmentAmountPage.verifyPageTitle(CheckYourGASDSAdjustmentAmountPage.pageTitle)
    CheckYourGASDSAdjustmentAmountPage.verifyPageCaption(CheckYourGASDSAdjustmentAmountPage.pageCaption)
    CheckYourGASDSAdjustmentAmountPage.verifyPageHeading(CheckYourGASDSAdjustmentAmountPage.pageHeading)
  }

  def validateChangeNavigation(): Unit = {
    CheckYourGASDSAdjustmentAmountPage.verifyPageUrl(
      CheckYourGASDSAdjustmentAmountPage.changePageUrl
    )
    CheckYourGASDSAdjustmentAmountPage.verifyPageTitle(
      CheckYourGASDSAdjustmentAmountPage.pageTitle
    )
    CheckYourGASDSAdjustmentAmountPage.verifyPageCaption(
      CheckYourGASDSAdjustmentAmountPage.pageCaption
    )
    CheckYourGASDSAdjustmentAmountPage.verifyPageHeading(
      CheckYourGASDSAdjustmentAmountPage.pageHeading
    )
  }

  val linkChangeGASDSAdjustmentAmount: By =
    By.xpath("//a[@href='/charities-claims/change-adjustment-for-gift-aid-small-donations-scheme-overclaimed']")

  def clickChangeGASDSAdjustmentAmount(): Unit = {
    val element = waitForElementToBeClickable(linkChangeGASDSAdjustmentAmount)
    element.click()
  }

  def validateNavigationAgent(): Unit = {
    CheckYourGASDSAdjustmentAmountPage.verifyPageUrl(CheckYourGASDSAdjustmentAmountPage.pageUrl)
    CheckYourGASDSAdjustmentAmountPage.verifyPageTitle(CheckYourGASDSAdjustmentAmountPage.pageTitleAgent)
    CheckYourGASDSAdjustmentAmountPage.verifyPageCaption(CheckYourGASDSAdjustmentAmountPage.pageCaption)
    CheckYourGASDSAdjustmentAmountPage.verifyPageHeading(CheckYourGASDSAdjustmentAmountPage.pageHeadingAgent)
  }

  def validateChangeNavigationAgent(): Unit = {
    CheckYourGASDSAdjustmentAmountPage.verifyPageUrl(
      CheckYourGASDSAdjustmentAmountPage.changePageUrl
    )
    CheckYourGASDSAdjustmentAmountPage.verifyPageTitle(
      CheckYourGASDSAdjustmentAmountPage.pageTitleAgent
    )
    CheckYourGASDSAdjustmentAmountPage.verifyPageCaption(
      CheckYourGASDSAdjustmentAmountPage.pageCaption
    )
    CheckYourGASDSAdjustmentAmountPage.verifyPageHeading(
      CheckYourGASDSAdjustmentAmountPage.pageHeadingAgent
    )
  }

}
