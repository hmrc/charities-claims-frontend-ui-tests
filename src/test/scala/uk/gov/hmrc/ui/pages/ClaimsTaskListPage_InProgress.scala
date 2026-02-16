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

object ClaimsTaskListPage_InProgress extends BasePage {

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
    "Completed"

  def pageTaskListItemIncompleteStatus: String =
    "Incomplete"

  def pageTaskList1Item1: String =
    "Provide repayment claim details"

  def pageTaskList1Item2: String =
    "Provide organisation details"

  def pageTaskList1Item3: String =
    "Gift Aid Small Donations Scheme details"

  def pageSubheading2: String =
    "Upload documents"

  def pageTaskList2Item1: String =
    "Add Gift Aid schedule"

  def pageTaskList2Item2: String =
    "Add other income schedule"

  def pageTaskList2Item3: String =
    "Add community buildings schedule"

  def pageTaskList2Item4: String =
    "Add connected charities schedule"

  def pageSubheading3: String =
    "Declaration"

  def pageTaskList3Item1: String =
    "Read declaration"

  def pageTaskList3Item2: String =
    "You must complete every section before you can declare."

  def pageTaskList3Item3: String =
    "Cannot start yet"

  def validateNavigation(): Unit = {
    ClaimsTaskListPage_InProgress.verifyPageTitle(ClaimsTaskListPage_InProgress.pageTitle)
    ClaimsTaskListPage_InProgress.verifyDynamicPageCaption(ClaimsTaskListPage_InProgress.pageCaption)
    ClaimsTaskListPage_InProgress.verifyPageHeader(ClaimsTaskListPage_InProgress.pageHeader)
    ClaimsTaskListPage_InProgress.verifyPageSubHeading1(ClaimsTaskListPage_InProgress.pageSubheading1)
    ClaimsTaskListPage_InProgress.verifyPageSubHeading2(ClaimsTaskListPage_InProgress.pageSubheading2)
  }

  val linkGoToDashboard: By                 = By.xpath("//a[@href='/charities-claims/charity-repayment-dashboard']")
  val linkProvideRepaymentClaimDetails: By  = By.xpath("//a[@href='/charities-claims/repayment-claim-details']")
  val linkProvideOrganisationDetails: By    = By.xpath("//a[@href='/charities-claims/TODO']")
  val linkProvideGASDSnDetails: By          = By.xpath("//a[@href='/charities-claims/TODO']")
  val linkAddGiftAidSchedule: By            = By.xpath("//a[@href='/charities-claims/about-gift-aid-schedule']")
  val linkAddOtherIncomeSchedule: By        = By.xpath("//a[@href='/charities-claims/TODO']")
  val linkAddCommunityBuildingsSchedule: By = By.xpath("//a[@href='/charities-claims/TODO']")
  val linkAddConnectedCharitiesSchedule: By = By.xpath("//a[@href='/charities-claims/TODO']")

  def clickGoToDashboard(): Unit = {
    val element = waitForElementToBeClickable(linkGoToDashboard)
    element.click()
  }

  def clickProvideRepaymentClaimDetails(): Unit = {
    val element = waitForElementToBeClickable(linkProvideRepaymentClaimDetails)
    element.click()
  }

  def clickProvideOrganisationDetails(): Unit = {
    val element = waitForElementToBeClickable(linkProvideOrganisationDetails)
    element.click()
  }

  def clickProvideGASDSDetails(): Unit = {
    val element = waitForElementToBeClickable(linkProvideGASDSnDetails)
    element.click()
  }

  def clickAddGiftAidSchedule(): Unit = {
    val element = waitForElementToBeClickable(linkAddGiftAidSchedule)
    element.click()
  }

  def clickAddOtherIncomeSchedule(): Unit = {
    val element = waitForElementToBeClickable(linkAddOtherIncomeSchedule)
    element.click()
  }

  def clickAddCommunityBuildingsSchedule(): Unit = {
    val element = waitForElementToBeClickable(linkAddCommunityBuildingsSchedule)
    element.click()
  }

  def clickAddConnectedCharitiesSchedule(): Unit = {
    val element = waitForElementToBeClickable(linkAddConnectedCharitiesSchedule)
    element.click()
  }

  def validatePageContent(): Unit =
    ClaimsTaskListPage_InProgress.verifyTaskList1Text(
      ClaimsTaskListPage_InProgress.createSingleStringFromMany(
        ClaimsTaskListPage_InProgress.pageTaskList1Item1 + " " + ClaimsTaskListPage_InProgress.pageTaskListItemCompleteStatus,
        ClaimsTaskListPage_InProgress.pageTaskList1Item2 + " " + ClaimsTaskListPage_InProgress.pageTaskListItemIncompleteStatus,
        ClaimsTaskListPage_InProgress.pageTaskList1Item3 + " " + ClaimsTaskListPage_InProgress.pageTaskListItemCompleteStatus
      )
    )
    ClaimsTaskListPage_InProgress.verifyTaskList2Text(
      ClaimsTaskListPage_InProgress.createSingleStringFromMany(
        ClaimsTaskListPage_InProgress.pageTaskList2Item1 + " " + ClaimsTaskListPage_InProgress.pageTaskListItemCompleteStatus,
        ClaimsTaskListPage_InProgress.pageTaskList2Item2 + " " + ClaimsTaskListPage_InProgress.pageTaskListItemCompleteStatus,
        ClaimsTaskListPage_InProgress.pageTaskList2Item3 + " " + ClaimsTaskListPage_InProgress.pageTaskListItemCompleteStatus,
        ClaimsTaskListPage_InProgress.pageTaskList2Item4 + " " + ClaimsTaskListPage_InProgress.pageTaskListItemCompleteStatus
      )
    )
    ClaimsTaskListPage_InProgress.verifyTaskList3Text(
      ClaimsTaskListPage_InProgress.createSingleStringFromMany(
        ClaimsTaskListPage_InProgress.pageTaskList3Item1,
        ClaimsTaskListPage_InProgress.pageTaskList3Item2,
        ClaimsTaskListPage_InProgress.pageTaskList3Item3
      )
    )
}
