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

object WhyIsTheCharityNotRegisteredPage extends BasePage {

  override def pageUrl: String = s"$hostname/charity-not-registered"

  def changePageUrl: String = s"$hostname/change-charity-not-registered"

  override def pageTitle: String =
    "Why is the charity not registered with a regulator? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String = "Provide organisation details"

  def pageHeading: String = "Why is the charity not registered with a regulator?"

  def textCheckbox1: String = "Your charity is located in England or Wales and your income is less than £5,000 per year"

  def textCheckbox2: String = "Your charity is excepted"

  def textCheckbox3: String = "Your charity is exempt"

  def textCheckbox4: String =
    "Your charity is based in Northern Ireland and you are awaiting registration with the Charity Commission for Northern Ireland (CCNI)"

  def textCheckbox1Agent: String =
    "The charity is located in England or Wales and its income is less than £5,000 per year"

  def textCheckbox2Agent: String = "The charity is excepted"

  def textCheckbox3Agent: String = "The charity is exempt"

  def textCheckbox4Agent: String =
    "The charity is based in Northern Ireland and it is awaiting registration with the Charity Commission for Northern Ireland (CCNI)"

  def pageErrorMsg: String = "Select why the charity is not registered with a regulator"

  val LowIncome: String  = "#value"
  val Exempt: String     = "#Exempt"
  val Excepted: String   = "#Excepted"
  val NorIrlWait: String = "#Waiting"
  val errorMsgLocator    = By.ById("value-error")

  def validateNavigation(): Unit = {
    WhyIsTheCharityNotRegisteredPage.verifyPageUrl(WhyIsTheCharityNotRegisteredPage.pageUrl)
    WhyIsTheCharityNotRegisteredPage.verifyPageTitle(WhyIsTheCharityNotRegisteredPage.pageTitle)
    WhyIsTheCharityNotRegisteredPage.verifyPageHeading(WhyIsTheCharityNotRegisteredPage.pageHeading)
    WhyIsTheCharityNotRegisteredPage.verifyPageCaption(WhyIsTheCharityNotRegisteredPage.pageCaption)
  }

  def validateChangeNavigation(): Unit = {
    WhyIsTheCharityNotRegisteredPage.verifyPageUrl(WhyIsTheCharityNotRegisteredPage.changePageUrl)
    WhyIsTheCharityNotRegisteredPage.verifyPageTitle(WhyIsTheCharityNotRegisteredPage.pageTitle)
    WhyIsTheCharityNotRegisteredPage.verifyPageHeading(WhyIsTheCharityNotRegisteredPage.pageHeading)
    WhyIsTheCharityNotRegisteredPage.verifyPageCaption(WhyIsTheCharityNotRegisteredPage.pageCaption)
  }

  def validateFormFieldset(): Unit =
    WhyIsTheCharityNotRegisteredPage.verifyFormFieldsetContent(
      WhyIsTheCharityNotRegisteredPage.createSingleStringFromMany(
        WhyIsTheCharityNotRegisteredPage.pageHeading,
        WhyIsTheCharityNotRegisteredPage.textCheckbox1,
        WhyIsTheCharityNotRegisteredPage.textCheckbox2,
        WhyIsTheCharityNotRegisteredPage.textCheckbox3,
        WhyIsTheCharityNotRegisteredPage.textCheckbox4
      )
    )

  def validateFormFieldsetAgent(): Unit =
    WhyIsTheCharityNotRegisteredPage.verifyFormFieldsetContent(
      WhyIsTheCharityNotRegisteredPage.createSingleStringFromMany(
        WhyIsTheCharityNotRegisteredPage.pageHeading,
        WhyIsTheCharityNotRegisteredPage.textCheckbox1Agent,
        WhyIsTheCharityNotRegisteredPage.textCheckbox2Agent,
        WhyIsTheCharityNotRegisteredPage.textCheckbox3Agent,
        WhyIsTheCharityNotRegisteredPage.textCheckbox4Agent
      )
    )

  def validateErrorMessage(): Unit =
    WhyIsTheCharityNotRegisteredPage.validateGenericPageError(
      WhyIsTheCharityNotRegisteredPage.pageErrorMsg,
      WhyIsTheCharityNotRegisteredPage.errorMsgLocator
    )
}
