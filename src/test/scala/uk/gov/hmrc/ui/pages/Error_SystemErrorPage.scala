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

object Error_SystemErrorPage extends BasePage {

  override def pageUrl: String = s"$hostname/there-is-a-problem"

  override def pageTitle: String = "Sorry, there is a problem with this service - Charities - GOV.UK"

  def pageHeader: String = "Sorry, there is a problem with this service"

  def listItem: String = "Try again later or contact the HMRC Online Services Helpdesk(opens in a new tab)."

  def validateNavigation(): Unit = {
    Error_SystemErrorPage.verifyPageUrl(Error_SystemErrorPage.pageUrl)
    Error_SystemErrorPage.verifyPageTitle(Error_SystemErrorPage.pageTitle)
    Error_SystemErrorPage.verifyPageHeader(Error_SystemErrorPage.pageHeader)
    Error_SystemErrorPage.verifyListText(Error_SystemErrorPage.listItem)
  }

}
