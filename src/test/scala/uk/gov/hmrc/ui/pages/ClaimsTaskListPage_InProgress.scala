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
    "Make a charity repayment claim - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "HMRC Charities reference:"

  def pageHeading: String =
    "Make a charity repayment claim"

  def pageSubheading1: String =
    "About this claim"

  def pageTaskListItemNotYetStartedStatus: String =
    "Not yet started"

  def pageTaskListItemInProgressStatus: String =
    "In progress"

  def pageTaskListItemCompletedStatus: String =
    "Completed"

  def pageTaskList1_RepaymentClaimDetails: String =
    "Provide repayment claim details"

  def pageTaskList1_OrganisationDetails: String =
    "Provide organisation details"

  def pageTaskList1_GASDSDetails: String =
    "Gift Aid Small Donations Scheme details"

  def pageSubheading2: String =
    "Upload documents"

  def pageTaskList2_GiftAid: String =
    "Add Gift Aid schedule"

  def pageTaskList2_OtherIncome: String =
    "Add Other Income schedule"

  def pageTaskList2_CommunityBuildings: String =
    "Add Community Buildings schedule"

  def pageTaskList2_ConnectedCharities: String =
    "Add Connected Charities schedule"

  def pageSubheading3: String =
    "Declaration"

  def pageTaskList3Item1: String =
    "Read declaration"

  def pageTaskList3Item2: String =
    "You must complete every section before you can declare."

  def pageTaskList3Item3: String =
    "Cannot start yet"

  def validateNavigation_AllSubheadings(): Unit = {
    ClaimsTaskListPage_InProgress.verifyPageTitle(ClaimsTaskListPage_InProgress.pageTitle)
    // ClaimsTaskListPage_InProgress.verifyDynamicPageCaption(ClaimsTaskListPage_InProgress.pageCaption)
    ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
    ClaimsTaskListPage_InProgress.verifyPageSubHeading1(ClaimsTaskListPage_InProgress.pageSubheading1)
    ClaimsTaskListPage_InProgress.verifyPageSubHeading2(ClaimsTaskListPage_InProgress.pageSubheading2)
    ClaimsTaskListPage_InProgress.verifyPageSubHeading3(ClaimsTaskListPage_InProgress.pageSubheading3)
  }

  def validateNavigation_AboutClaimAndDeclaration(): Unit = {
    ClaimsTaskListPage_InProgress.verifyPageTitle(ClaimsTaskListPage_InProgress.pageTitle)
    // ClaimsTaskListPage_InProgress.verifyDynamicPageCaption(ClaimsTaskListPage_InProgress.pageCaption)
    ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
    ClaimsTaskListPage_InProgress.verifyPageSubHeading1(ClaimsTaskListPage_InProgress.pageSubheading1)
    ClaimsTaskListPage_InProgress.verifyPageSubHeading2(ClaimsTaskListPage_InProgress.pageSubheading3)
  }

  def validateNavigation_AllSubheadingsAgent(): Unit = {
    ClaimsTaskListPage_InProgress.verifyPageTitle(ClaimsTaskListPage_InProgress.pageTitle)
    // ClaimsTaskListPage_InProgress.verifyDynamicPageCaption(ClaimsTaskListPage_InProgress.pageCaption)
    ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
    ClaimsTaskListPage_InProgress.verifyPageSubHeading1(ClaimsTaskListPage_InProgress.pageSubheading1)
    ClaimsTaskListPage_InProgress.verifyPageSubHeading2(ClaimsTaskListPage_InProgress.pageSubheading2)
    ClaimsTaskListPage_InProgress.verifyPageSubHeading3(ClaimsTaskListPage_InProgress.pageSubheading3)
  }

  def validateNavigation_AboutClaimAndDeclarationAgent(): Unit = {
    ClaimsTaskListPage_InProgress.verifyPageTitle(ClaimsTaskListPage_InProgress.pageTitle)
    // ClaimsTaskListPage_InProgress.verifyDynamicPageCaption(ClaimsTaskListPage_InProgress.pageCaption)
    ClaimsTaskListPage_InProgress.verifyPageHeading(ClaimsTaskListPage_InProgress.pageHeading)
    ClaimsTaskListPage_InProgress.verifyPageSubHeading1(ClaimsTaskListPage_InProgress.pageSubheading1)
    ClaimsTaskListPage_InProgress.verifyPageSubHeading2(ClaimsTaskListPage_InProgress.pageSubheading3)
  }

  val linkGoToDashboard: By                = By.xpath("//a[@href='/charities-claims/charity-repayment-dashboard']")
  val linkProvideRepaymentClaimDetails: By = By.xpath("//a[@href='/charities-claims/repayment-claim-details']")
  val linkProvideOrganisationDetails: By   = By.xpath("//a[@href='/charities-claims/about-the-organisation']")

  val linkCheckYourRepaymentClaim: By      = By.xpath("//a[@href='/charities-claims/check-your-repayment-claim']")
  val linkCheckYourOrganisationDetails: By = By.xpath("//a[@href='/charities-claims/check-your-organisation-details']")

  val linkProvideGASDSDetails: By           = By.xpath("//a[@href='/charities-claims/about-gift-aid-small-donations-scheme']")
  val linkAddGiftAidSchedule: By            = By.xpath("//a[@href='/charities-claims/about-gift-aid-schedule']")
  val linkAddOtherIncomeSchedule: By        = By.xpath("//a[@href='/charities-claims/about-other-income-schedule']")
  val linkAddCommunityBuildingsSchedule: By =
    By.xpath("//a[@href='/charities-claims/about-community-buildings-schedule']")
  val linkAddConnectedCharitiesSchedule: By =
    By.xpath("//a[@href='/charities-claims/about-connected-charities-schedule']")
  val linkReadDeclaration: By               = By.xpath("//a[@href='/charities-claims/adjustments-to-this-claim']")
  val linkDeleteClaim: By                   = By.xpath("//a[@href='/charities-claims/delete-repayment-claim']")
  val linkDeleteCharityClaim: By            = By.xpath("//a[@href='/charities-claims/delete-charity-repayment-claim']")

  val linkGoToCharityManagementAgent: By =
    By.xpath("//a[@href and contains(text(),'Go to manage charity repayment claims')]")

  def clickGoToDashboard(): Unit = {
    val element = waitForElementToBeClickable(linkGoToDashboard)
    element.click()
  }

  def clickProvideRepaymentClaimDetails(): Unit = {
    val element = waitForElementToBeClickable(linkProvideRepaymentClaimDetails)
    element.click()
  }

  def clickCheckYourRepaymentClaimDetails(): Unit = {
    val element = waitForElementToBeClickable(linkCheckYourRepaymentClaim)
    element.click()
  }

  def clickProvideOrganisationDetails(): Unit = {
    val element = waitForElementToBeClickable(linkProvideOrganisationDetails)
    element.click()
  }

  def clickCheckYourOrganisationDetails(): Unit = {
    val element = waitForElementToBeClickable(linkCheckYourOrganisationDetails)
    element.click()
  }

  def clickProvideGASDSDetails(): Unit = {
    val element = waitForElementToBeClickable(linkProvideGASDSDetails)
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

  def clickReadDeclaration(): Unit = {
    val element = waitForElementToBeClickable(linkReadDeclaration)
    element.click()
  }

  def clickDeleteClaim(): Unit = {
    val element = waitForElementToBeClickable(linkDeleteClaim)
    element.click()
  }

  def clickDeleteCharityClaim(): Unit = {
    val element = waitForElementToBeClickable(linkDeleteCharityClaim)
    element.click()
  }

  def clickGoToCharityManagementAgent(): Unit = {
    val element = waitForElementToBeClickable(linkGoToCharityManagementAgent)
    element.click()
  }

  def validateTaskList1_RC_OI(): Unit =
    ClaimsTaskListPage_InProgress.verifyTaskList1Text(
      ClaimsTaskListPage_InProgress.createSingleStringFromMany(
        ClaimsTaskListPage_InProgress.pageTaskList1_RepaymentClaimDetails + " " + ClaimsTaskListPage_InProgress.pageTaskListItemCompletedStatus,
        ClaimsTaskListPage_InProgress.pageTaskList1_OrganisationDetails + " " + ClaimsTaskListPage_InProgress.pageTaskListItemNotYetStartedStatus
      )
    )

  def validateTaskList1_RC_OI_GI(): Unit =
    ClaimsTaskListPage_InProgress.verifyTaskList1Text(
      ClaimsTaskListPage_InProgress.createSingleStringFromMany(
        ClaimsTaskListPage_InProgress.pageTaskList1_RepaymentClaimDetails + " " + ClaimsTaskListPage_InProgress.pageTaskListItemCompletedStatus,
        ClaimsTaskListPage_InProgress.pageTaskList1_OrganisationDetails + " " + ClaimsTaskListPage_InProgress.pageTaskListItemNotYetStartedStatus,
        ClaimsTaskListPage_InProgress.pageTaskList1_GASDSDetails + " " + ClaimsTaskListPage_InProgress.pageTaskListItemNotYetStartedStatus
      )
    )

  def validateTaskList1_RC_OC_GI(): Unit =
    ClaimsTaskListPage_InProgress.verifyTaskList1Text(
      ClaimsTaskListPage_InProgress.createSingleStringFromMany(
        ClaimsTaskListPage_InProgress.pageTaskList1_RepaymentClaimDetails + " " + ClaimsTaskListPage_InProgress.pageTaskListItemCompletedStatus,
        ClaimsTaskListPage_InProgress.pageTaskList1_OrganisationDetails + " " + ClaimsTaskListPage_InProgress.pageTaskListItemCompletedStatus,
        ClaimsTaskListPage_InProgress.pageTaskList1_GASDSDetails + " " + ClaimsTaskListPage_InProgress.pageTaskListItemNotYetStartedStatus
      )
    )

  def validateTaskList1_RC_OC(): Unit =
    ClaimsTaskListPage_InProgress.verifyTaskList1Text(
      ClaimsTaskListPage_InProgress.createSingleStringFromMany(
        ClaimsTaskListPage_InProgress.pageTaskList1_RepaymentClaimDetails + " " + ClaimsTaskListPage_InProgress.pageTaskListItemCompletedStatus,
        ClaimsTaskListPage_InProgress.pageTaskList1_OrganisationDetails + " " + ClaimsTaskListPage_InProgress.pageTaskListItemCompletedStatus
      )
    )

  def validateTaskList2_GA(): Unit =
    ClaimsTaskListPage_InProgress.verifyTaskList2Text(
      ClaimsTaskListPage_InProgress.pageTaskList2_GiftAid + " " + ClaimsTaskListPage_InProgress.pageTaskListItemNotYetStartedStatus
    )

  def validateTaskList2_OI(): Unit =
    ClaimsTaskListPage_InProgress.verifyTaskList2Text(
      ClaimsTaskListPage_InProgress.pageTaskList2_OtherIncome + " " + ClaimsTaskListPage_InProgress.pageTaskListItemNotYetStartedStatus
    )

  def validateTaskList2_GA_OI_CB_CC(): Unit =
    ClaimsTaskListPage_InProgress.verifyTaskList2Text(
      ClaimsTaskListPage_InProgress.createSingleStringFromMany(
        ClaimsTaskListPage_InProgress.pageTaskList2_GiftAid + " " + ClaimsTaskListPage_InProgress.pageTaskListItemNotYetStartedStatus,
        ClaimsTaskListPage_InProgress.pageTaskList2_OtherIncome + " " + ClaimsTaskListPage_InProgress.pageTaskListItemNotYetStartedStatus,
        ClaimsTaskListPage_InProgress.pageTaskList2_CommunityBuildings + " " + ClaimsTaskListPage_InProgress.pageTaskListItemNotYetStartedStatus,
        ClaimsTaskListPage_InProgress.pageTaskList2_ConnectedCharities + " " + ClaimsTaskListPage_InProgress.pageTaskListItemNotYetStartedStatus
      )
    )

  def validateTaskList2_GAP_OI_CB_CC(): Unit =
    ClaimsTaskListPage_InProgress.verifyTaskList2Text(
      ClaimsTaskListPage_InProgress.createSingleStringFromMany(
        ClaimsTaskListPage_InProgress.pageTaskList2_GiftAid + " " + ClaimsTaskListPage_InProgress.pageTaskListItemInProgressStatus,
        ClaimsTaskListPage_InProgress.pageTaskList2_OtherIncome + " " + ClaimsTaskListPage_InProgress.pageTaskListItemNotYetStartedStatus,
        ClaimsTaskListPage_InProgress.pageTaskList2_CommunityBuildings + " " + ClaimsTaskListPage_InProgress.pageTaskListItemNotYetStartedStatus,
        ClaimsTaskListPage_InProgress.pageTaskList2_ConnectedCharities + " " + ClaimsTaskListPage_InProgress.pageTaskListItemNotYetStartedStatus
      )
    )

  def validateTaskList2_GAC_OIC_CBP_CCN(): Unit =
    ClaimsTaskListPage_InProgress.verifyTaskList2Text(
      ClaimsTaskListPage_InProgress.createSingleStringFromMany(
        ClaimsTaskListPage_InProgress.pageTaskList2_GiftAid + " " + ClaimsTaskListPage_InProgress.pageTaskListItemCompletedStatus,
        ClaimsTaskListPage_InProgress.pageTaskList2_OtherIncome + " " + ClaimsTaskListPage_InProgress.pageTaskListItemCompletedStatus,
        ClaimsTaskListPage_InProgress.pageTaskList2_CommunityBuildings + " " + ClaimsTaskListPage_InProgress.pageTaskListItemInProgressStatus,
        ClaimsTaskListPage_InProgress.pageTaskList2_ConnectedCharities + " " + ClaimsTaskListPage_InProgress.pageTaskListItemNotYetStartedStatus
      )
    )

  def validateTaskList3_NoDeclaration(): Unit =
    ClaimsTaskListPage_InProgress.verifyTaskList3Text(
      ClaimsTaskListPage_InProgress.createSingleStringFromMany(
        ClaimsTaskListPage_InProgress.pageTaskList3Item1,
        ClaimsTaskListPage_InProgress.pageTaskList3Item2,
        ClaimsTaskListPage_InProgress.pageTaskList3Item3
      )
    )
}
