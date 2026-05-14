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
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.Agent
import scala.util.Random

object CharitiesManagementAgent extends BasePage {

  override def pageUrl: String = s"$hostname/charities-management/manage-charity-repayment-claim"

  override def pageTitle: String =
    "Manage charity repayment claims - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "Manage charity repayment claims"

  def pageSubHeading1: String =
    "Make a repayment claim"

  val lnkUseTheCharities: By             = By.xpath("//a[@href and contains(text(),'Use the charities online service')]")
  val lnkContinueClaim: By               = By.xpath("//a[@href and contains(text(),'Continue with draft claim')]")
  val lnkRow1UnsubmittedClaim: By       = By.xpath("//tr[1]//td[3]/a")
  val lnkRow1DeleteUnsubmittedClaim: By = By.xpath("//tr[1]//td[4]/a")

  def validateNavigationAgent(): Unit = {
    // CharitiesManagementAgent.verifyPageUrl(CharitiesManagementAgent.pageUrl)
    CharitiesManagementAgent.verifyPageTitle(CharitiesManagementAgent.pageTitle)
    // CharitiesManagementAgent.verifyPageCaption(CharitiesManagementAgent.pageCaption)
    CharitiesManagementAgent.verifyPageHeading(CharitiesManagementAgent.pageHeading)
  }

  def clickUseTheCharitiesLink(): Unit = {
    val element = waitForElementToBeClickable(lnkUseTheCharities)
    element.click()
  }

  def clickContinueClaimLink(): Unit = {
    val element = waitForElementToBeClickable(lnkContinueClaim)
    element.click()
  }

  def clickFirstUnsubmittedClaimLink(): Unit = {
    val element = waitForElementToBeClickable(lnkRow1UnsubmittedClaim)
    element.click()
  }

  def clickDeleteFirstUnsubmittedClaimLink(): Unit = {
    val element = waitForElementToBeClickable(lnkRow1DeleteFirstUnsubmittedClaim)
    element.click()
  }

  def randomVarchar6(): String =
    Random.alphanumeric.take(6).mkString

  val RandomUsername = randomVarchar6()

  def createNClaims(n: Int): Unit = {
    val agentReferenceNumber   = "A" + n
    val charityReferenceNumber = "C" + n
    val charityName            = "Charity name" + n
    AuthWizard.loginAgent(
      HASDIRECT,
      Agent,
      "Agent",
      "HMRC-CHAR-AGENT",
      "AGENTCHARID",
      agentReferenceNumber,
      RandomUsername
    )
    CharitiesManagementAgent.verifyPageHeading(CharitiesManagementAgent.pageHeading)
    CharitiesManagementAgent.clickUseTheCharitiesLink()
    RepaymentClaimDetailsPage.validateNavigationAgent()
    RepaymentClaimDetailsPage.clickContinue()
    WhatIsYourHMRCReferenceNumberPage.validateNavigationAgent()
    WhatIsYourHMRCReferenceNumberPage.enterCharitiesReferenceNumber(charityReferenceNumber)
    WhatIsTheNameOfCharityOrCASC.validateNavigationAgent()
    WhatIsTheNameOfCharityOrCASC.enterCharityName(charityName)
    RepaymentCheckboxPage.validateNavigationAgent()
    RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GiftAid, true)
    RepaymentCheckboxPage.clickContinue()
    DoYouHaveAClaimReferenceNumberPage.validateNavigationAgent()
    DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
    DoYouHaveAClaimReferenceNumberPage.clickContinue()
    CheckYourRepaymentClaimPage.validateNavigationAgent()
    CheckYourRepaymentClaimPage.clickContinue()
    ClaimsTaskListPage_InProgress.validateNavigationAgent()
  }

  def runCreateNClaims(n: Int): Unit =
    for (i <- 1 to n)
      createNClaims(i)
      println(s"[DEBUG] using Agent Username:" + CharitiesManagementAgent.RandomUsername)

}
