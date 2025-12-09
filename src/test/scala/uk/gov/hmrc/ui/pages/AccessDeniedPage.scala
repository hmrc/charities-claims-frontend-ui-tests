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

object AccessDeniedPage extends BasePage {

  override def pageUrl: String = s"$hostname/there-is-a-problem-access-denied"

  override def pageTitle: String = "Sorry, there is a problem with the service - Charities - GOV.UK"

  def pageHeader: String = "Sorry, there is a problem with the service"

  def listItem1: String = "You do not have access to this service."

  def listItem2: String = "Continue to your account"

  def validateNavigation(): Unit = {
    AccessDeniedPage.verifyPageUrl(AccessDeniedPage.pageUrl)
    AccessDeniedPage.verifyPageTitle(AccessDeniedPage.pageTitle)
    AccessDeniedPage.verifyPageHeader(AccessDeniedPage.pageHeader)
    AccessDeniedPage.verifyListText(AccessDeniedPage.listItem1)
    AccessDeniedPage.verifyListText(AccessDeniedPage.listItem2)
  }

}
