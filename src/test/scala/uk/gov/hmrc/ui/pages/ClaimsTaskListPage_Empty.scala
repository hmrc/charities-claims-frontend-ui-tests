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

object ClaimsTaskListPage_Empty extends BasePage {

  override def pageUrl: String = s"$hostname/make-a-charity-repayment-claim"

  override def pageTitle: String =
    "Make a charity repayment claim - Charities - GOV.UK"

  def pageCaption: String =
    "HMRC Charities reference:"

  def pageHeader: String =
    "Make a charity repayment claim"

  def pageSubheading1: String =
    "About the claim"

  def pageTaskListItemCompleteStatus: String =
    "Complete"

  def pageTaskListItemIncompleteStatus: String =
    "Incomplete"

  def pageTaskList1Item1: String =
    "Provide repayment claim details"

  def pageSubheading2: String =
    "Declaration"

  def pageTaskList2Item1: String =
    "Read declaration"

  def pageTaskList2Item2: String =
    "You must complete every section before you can declare."

  def pageTaskList2Item3: String =
    "Cannot start yet"

  def validateNavigation(): Unit = {
    ClaimsTaskListPage_Empty.verifyPageUrl(ClaimsTaskListPage_Empty.pageUrl)
    ClaimsTaskListPage_Empty.verifyPageTitle(ClaimsTaskListPage_Empty.pageTitle)
    ClaimsTaskListPage_Empty.verifyDynamicPageCaption(ClaimsTaskListPage_Empty.pageCaption)
    ClaimsTaskListPage_Empty.verifyPageHeader(ClaimsTaskListPage_Empty.pageHeader)
    ClaimsTaskListPage_Empty.verifyPageSubHeading1(ClaimsTaskListPage_Empty.pageSubheading1)
    ClaimsTaskListPage_Empty.verifyPageSubHeading2(ClaimsTaskListPage_Empty.pageSubheading2)
  }

  val linkGoToDashboard: By                = By.xpath("//a[@href='/charities-claims/charity-repayment-dashboard']")
  val linkProvideRepaymentClaimDetails: By = By.xpath("//a[@href='/charities-claims/repayment-claim-details']")

  def clickGoToDashboard(): Unit = {
    val element = waitForElementToBeClickable(linkGoToDashboard)
    element.click()
  }

  def clickProvideRepaymentClaimDetails(): Unit = {
    val element = waitForElementToBeClickable(linkProvideRepaymentClaimDetails)
    element.click()
  }

  def validatePageContent(): Unit =
    ClaimsTaskListPage_Empty.verifyTaskList1Text(
      ClaimsTaskListPage_Empty.createSingleStringFromMany(
        ClaimsTaskListPage_Empty.pageTaskList1Item1 + " " + ClaimsTaskListPage_Empty.pageTaskListItemIncompleteStatus
      )
    )
    ClaimsTaskListPage_Empty.verifyTaskList2Text(
      ClaimsTaskListPage_Empty.createSingleStringFromMany(
        ClaimsTaskListPage_Empty.pageTaskList2Item1,
        ClaimsTaskListPage_Empty.pageTaskList2Item2,
        ClaimsTaskListPage_Empty.pageTaskList2Item3
      )
    )
}
