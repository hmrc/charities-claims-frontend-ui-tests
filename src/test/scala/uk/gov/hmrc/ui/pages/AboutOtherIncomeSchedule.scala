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

object AboutOtherIncomeSchedule extends BasePage {
  override def pageUrl: String = s"$hostname/about-other-income-schedule"

  override def pageTitle: String = "About Other Income schedule - Charities - GOV.UK"

  def pageHeading: String = "About Other Income schedule"

  def pageCaption: String = "Add Other Income schedule"

  def listText1: String = "Use this service to add an Other Income schedule."

  def listText2: String = "You can upload an Other Income schedule in a .ods format."

  def listText3: String =
    "You can download an Other Income schedule here (opens in new tab). You can submit 1 file at a time, and each file can be up to 2.5MB."

  def continueButton: String = "Continue"

  def validateNavigation(): Unit = {
    AboutOtherIncomeSchedule.verifyPageUrl(AboutOtherIncomeSchedule.pageUrl)
    AboutOtherIncomeSchedule.verifyPageTitle(AboutOtherIncomeSchedule.pageTitle)
  }

  def validatePageContent(): Unit =
    AboutOtherIncomeSchedule.verifyEntirePageContent(
      AboutOtherIncomeSchedule.createSingleStringFromMany(
        AboutOtherIncomeSchedule.pageCaption,
        AboutOtherIncomeSchedule.pageHeading,
        AboutOtherIncomeSchedule.listText1,
        AboutOtherIncomeSchedule.listText2,
        AboutOtherIncomeSchedule.listText3,
        AboutOtherIncomeSchedule.continueButton
      )
    )

  def validateDataGuardProtection(): Unit = {
    navigateToPage(pageUrl)
    Error_PageNotFoundPage.validateNavigation()
    Error_PageNotFoundPage.validatePageContent()
  }

  def completeMinimumDataGuard(): Unit = {
    navigateToPage(ClaimsTaskListPage_Empty.pageUrl)
    verifyPageUrl(ClaimsTaskListPage_Empty.pageUrl)
    ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
    verifyPageUrl(RepaymentClaimDetailsPage.pageUrl)
    clickContinue()
    verifyPageUrl(RepaymentCheckboxPage.pageUrl)
    checkbox(RepaymentCheckboxPage.OtherIncome, true)
    clickContinue()
  }

  def goToAboutOtherIncomeSchedulePage(): Unit = {
    navigateToPage(AboutOtherIncomeSchedule.pageUrl)
    verifyPageUrl(AboutOtherIncomeSchedule.pageUrl)
  }

  def goToMakeACharityRepaymentClaimPage(): Unit = {
    navigateToPage(ClaimsTaskListPage_Empty.pageUrl)
    verifyPageUrl(ClaimsTaskListPage_Empty.pageUrl)
  }
}
