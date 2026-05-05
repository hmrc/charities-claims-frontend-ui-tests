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

object RepaymentCheckboxPage extends BasePage {

  override def pageUrl: String = s"$hostname/select-repayment-claim-type"
  def changePageUrl: String = s"$hostname/change-select-repayment-claim-type"

  override def pageTitle: String =
    "Which type of repayment claim do you want to make? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageHeading: String =
    "Which type of repayment claim do you want to make?"

  def pageHintSelectAll: String =
    "Select at least one"

  def pageHintCheckbox: String =
    "These are not your Gift Aid donations"

  def pageErrorMsg: String =
    "Select repayment claim type"

  def verifyHintCheckbox(expectedText: String): Unit = {
    waitForVisibilityOfElement(By.ById("value_1-item-hint"))
    val actualText = driver.findElement(By.ById("value_1-item-hint")).getText
    assert(
      actualText == expectedText,
      s"Page hint mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual page hint is: " + driver.findElement(By.ById("value_1-item-hint")).getText)
  }

  val GiftAid: String     = "#value"
  val GASDSclaim: String  = "#value_1"
  val OtherIncome: String = "#value_2"
  val errorMsgLocator     = By.ById("value-error")

  def validateNavigation(): Unit = {
    RepaymentCheckboxPage.verifyPageUrl(RepaymentCheckboxPage.pageUrl)
    RepaymentCheckboxPage.verifyPageTitle(RepaymentCheckboxPage.pageTitle)
    RepaymentCheckboxPage.verifyPageCaption(RepaymentCheckboxPage.pageCaption)
    RepaymentCheckboxPage.verifyPageHeading(RepaymentCheckboxPage.pageHeading)
  }

  def validateHints(): Unit = {
    RepaymentCheckboxPage.verifyHintText(RepaymentCheckboxPage.pageHintSelectAll)
    RepaymentCheckboxPage.verifyHintCheckbox(RepaymentCheckboxPage.pageHintCheckbox)
  }

  def validateErrorMessage(): Unit =
    RepaymentCheckboxPage.validateGenericPageError(
      RepaymentCheckboxPage.pageErrorMsg,
      RepaymentCheckboxPage.errorMsgLocator
    )
}
