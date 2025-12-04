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

object AboutTheOrganisationPage extends BasePage {

  override def pageUrl: String = s"$hostname/about-the-organisation"

  override def pageTitle: String =
    "About the organisation - Charities - GOV.UK"

  def pageHeader: String =
    "About the organisation"

  def pageCaption: String =
    "Provide organisation details"

  def pageParagraph1: String =
    "You need to provide information about the organisation you are claiming for."

  def pageParagraph2: String =
    "The person making this claim must be an approved official or corporate trustee recognised by HM Revenue Customs."

  def validateNavigation(): Unit = {
    AboutTheOrganisationPage.verifyPageUrl(AboutTheOrganisationPage.pageUrl)
    AboutTheOrganisationPage.verifyPageTitle(AboutTheOrganisationPage.pageTitle)
    AboutTheOrganisationPage.verifyPageCaption(AboutTheOrganisationPage.pageCaption)
    AboutTheOrganisationPage.verifyPageHeader(AboutTheOrganisationPage.pageHeader)
  }

  def validateParagraph(): Unit = {
    AboutTheOrganisationPage.verifyParagraphText(AboutTheOrganisationPage.pageParagraph1)
    AboutTheOrganisationPage.verifyParagraphText(AboutTheOrganisationPage.pageParagraph2)
  }
}
