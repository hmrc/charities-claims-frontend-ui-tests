/*
 * Copyright 2025 HM Revenue & Customs
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

object ErrorPageNotFoundPage extends BasePage {

  override def pageUrl: String = s"$hostname/page-not-found"

  override def pageTitle: String =
    "Page not found - Charities - GOV.UK"

  def pageHeader: String =
    "Page not found"

  def listItem1: String =
    "If you typed the web address, check it is correct."

  def listItem2: String =
    "If you pasted the web address, check you copied the entire address."

  def listItem3: String =
    "If the web address is correct or you selected a link or button, contact the HMRC Online Services Helpdesk if you need to speak to someone."

  def validateNavigation(): Unit = {
    // PageNotFound.verifyPageUrl(PageNotFound.pageUrl)
    ErrorPageNotFoundPage.verifyPageTitle(ErrorPageNotFoundPage.pageTitle)
    ErrorPageNotFoundPage.verifyPageHeader(ErrorPageNotFoundPage.pageHeader)
  }

  def validatePageContent(): Unit =
    ErrorPageNotFoundPage.verifyPageNotFoundContent(
      ErrorPageNotFoundPage.createSingleStringFromMany(
        ErrorPageNotFoundPage.pageHeader,
        ErrorPageNotFoundPage.listItem1,
        ErrorPageNotFoundPage.listItem2,
        ErrorPageNotFoundPage.listItem3
      )
    )
}
