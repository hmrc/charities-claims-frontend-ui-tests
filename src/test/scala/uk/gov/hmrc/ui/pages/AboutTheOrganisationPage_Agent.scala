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

object AboutTheOrganisationPage_Agent extends BasePage {

  override def pageUrl: String = s"$hostname/about-the-organisation"

  override def pageTitle: String =
    "About the organisation - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "About the organisation"

  def pageCaption: String =
    "Provide organisation details"

  def listItem1: String =
    "You need to provide information about the organisation you are claiming for."

  def listItem2: String =
    "The agent making this claim must provide a phone number so HM Revenue & Customs can get in touch about this claim."

  def listItem3: String =
    "Continue"

  def validateNavigation(): Unit = {
    AboutTheOrganisationPage_Agent.verifyPageUrl(AboutTheOrganisationPage_Agent.pageUrl)
    AboutTheOrganisationPage_Agent.verifyPageTitle(AboutTheOrganisationPage_Agent.pageTitle)
    AboutTheOrganisationPage_Agent.verifyPageCaption(AboutTheOrganisationPage_Agent.pageCaption)
    AboutTheOrganisationPage_Agent.verifyPageHeading(AboutTheOrganisationPage_Agent.pageHeading)
  }

  def validatePageContent(): Unit =
    AboutTheOrganisationPage_Agent.verifyEntirePageContent(
      AboutTheOrganisationPage_Agent.createSingleStringFromMany(
        AboutTheOrganisationPage_Agent.pageCaption,
        AboutTheOrganisationPage_Agent.pageHeading,
        AboutTheOrganisationPage_Agent.listItem1,
        AboutTheOrganisationPage_Agent.listItem2,
        AboutTheOrganisationPage_Agent.listItem3
      )
    )
}
