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

  override def pageTitle: String =
    "Why is the charity not registered with a regulator? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String = "Provide organisation details"

  def pageHeading: String = "Why is the charity not registered with a regulator?"

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

  def validateErrorMessage(): Unit =
    WhyIsTheCharityNotRegisteredPage.validateGenericPageError(
      WhyIsTheCharityNotRegisteredPage.pageErrorMsg,
      WhyIsTheCharityNotRegisteredPage.errorMsgLocator
    )
}
