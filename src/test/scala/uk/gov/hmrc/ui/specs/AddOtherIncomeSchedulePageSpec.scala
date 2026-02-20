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

package uk.gov.hmrc.ui.specs

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.ui.pages.*
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

class AddOtherIncomeSchedulePageSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation - Other Income Page Validations") {
//    Scenario("Placeholder for O1.0"){}

    Scenario(
      "User navigates to the 'Upload an Other Income schedule' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGE TEST - O1.1")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigation()
      And("User selects 'UK tax deducted from Other Income' checkbox and clicks continue")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.OtherIncome, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation()
      ClaimsTaskListPage_InProgress.validateTaskList1_RC_OI()
      ClaimsTaskListPage_InProgress.validateTaskList2_OI()
      ClaimsTaskListPage_InProgress.validateTaskList3_NoDeclaration()
      And("User clicks the link to navigate to 'Add Other Income schedule' page")
      ClaimsTaskListPage_InProgress.clickAddOtherIncomeSchedule()
      Then("User navigates to 'About Other Income schedule' page")
      AboutOtherIncomeSchedulePage.validateNavigation()
      AboutOtherIncomeSchedulePage.clickContinue()
      Then("User navigates to 'Upload an Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.validateNavigation()
      Then("User validates the elements on the 'Upload an Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.validatePageContent()
      Then("User validates the 'no input' error on the 'Upload an Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.validateNoInputErrorMessage()
      Then("User selects a file of over 250KB to upload in the 'Upload an Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.selectFile("OtherIncomeSpreadsheets/Other-Income-Schedule-Oversize")
      UploadAnOtherIncomeSchedulePage.clickContinue()
      Then("User validates the 'file must be smaller than 250KB' error on the 'Upload an Other Income schedule' page")
      UploadAnOtherIncomeSchedulePage.validateOversizeErrorMessage()
    }
  }
}
