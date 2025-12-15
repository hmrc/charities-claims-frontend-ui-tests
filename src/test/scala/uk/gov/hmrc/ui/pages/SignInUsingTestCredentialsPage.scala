/*
 * Copyright 2023 HM Revenue & Customs
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

object SignInUsingTestCredentialsPage extends BasePage {

  override def pageUrl: String = s"$hostname"

  override def pageTitle: String = "???"

  def pageHeader: String =
    "Sign in using test credentials"

  def enterUserID(userID: String): Unit = {
    input(Locators.inputYourUserId, userID)
    clickContinue()
  }

  def validateNavigation(): Unit =
    SignInUsingTestCredentialsPage.verifyPageHeader(SignInUsingTestCredentialsPage.pageHeader)

  val organisation: String = "#value"
  val agent: String        = "#value-no"

}
