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

object RemoveClaimForTaxYearPage extends BasePage {

  override def pageUrl: String = s"$hostname/remove-claim-for-tax-year"

  override def pageTitle: String =
    "Do you want to remove the claim for tax year "

  def pageHeading: String =
    "Do you want to remove the claim for tax year "

  def pageErrorMsg: String =
    "Select ‘Yes’ if you want to remove the claim for tax year"

  val TaxYearNow: String            = currentTaxYear.toString
  val earliestTaxYear: String       = (currentTaxYear - 3).toString
  val secondEarliestTaxYear: String = (currentTaxYear - 2).toString
  val recentTaxYear: String = (currentTaxYear-1).toString

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation1(): Unit = {
    RemoveClaimForTaxYearPage.verifyPageUrl(RemoveClaimForTaxYearPage.pageUrl + "/1")
    RemoveClaimForTaxYearPage.verifyPageTitle(
      RemoveClaimForTaxYearPage.pageTitle + earliestTaxYear + "? - Make a charity tax repayment claim - GOV.UK"
    )
    RemoveClaimForTaxYearPage.verifyPageHeading(RemoveClaimForTaxYearPage.pageHeading + earliestTaxYear + "?")
  }

  def validateNavigation2(): Unit = {
    RemoveClaimForTaxYearPage.verifyPageUrl(RemoveClaimForTaxYearPage.pageUrl + "/2")
    RemoveClaimForTaxYearPage.verifyPageTitle(
      RemoveClaimForTaxYearPage.pageTitle + secondEarliestTaxYear + "? - Make a charity tax repayment claim - GOV.UK"
    )
    RemoveClaimForTaxYearPage.verifyPageHeading(RemoveClaimForTaxYearPage.pageHeading + secondEarliestTaxYear + "?")
  }

  def validateNavigation3(): Unit = {
    RemoveClaimForTaxYearPage.verifyPageUrl(RemoveClaimForTaxYearPage.pageUrl + "/3")
    RemoveClaimForTaxYearPage.verifyPageTitle(
      RemoveClaimForTaxYearPage.pageTitle + recentTaxYear + "? - Make a charity tax repayment claim - GOV.UK"
    )
    RemoveClaimForTaxYearPage.verifyPageHeading(RemoveClaimForTaxYearPage.pageHeading + recentTaxYear + "?")
  }

  def validateErrorMessage(): Unit =
    RemoveClaimForTaxYearPage.validateGenericPageError(
      RemoveClaimForTaxYearPage.pageErrorMsg,
      RemoveClaimForTaxYearPage.errorMsgLocator
    )

}
