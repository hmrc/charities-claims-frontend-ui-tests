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

object AboutCommunityBuildingsSchedulePage extends BasePage {

  override def pageUrl: String = s"$hostname/about-community-buildings-schedule"

  override def pageTitle: String =
    "About Community Buildings schedule - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Add Community Buildings schedule"

  def pageHeading: String =
    "About Community Buildings schedule"

  def listItem1: String =
    "Use this service to add a Community Buildings schedule."

  def listItem1Agent: String =
    "Use this service to add a Community Buildings schedule for your client."

  def listItem2: String =
    "You can upload a Community Buildings schedule in a .ods format."

  def listItem3: String =
    "You can download a Community Buildings schedule here (opens in new tab). You can submit 1 file at a time, and each file can be up to 250KB."

  def listItem4: String =
    "Continue"

  def validateNavigation(): Unit = {
    AboutCommunityBuildingsSchedulePage.verifyPageUrl(AboutCommunityBuildingsSchedulePage.pageUrl)
    AboutCommunityBuildingsSchedulePage.verifyPageTitle(AboutCommunityBuildingsSchedulePage.pageTitle)
    AboutCommunityBuildingsSchedulePage.verifyPageCaption(AboutCommunityBuildingsSchedulePage.pageCaption)
    AboutCommunityBuildingsSchedulePage.verifyPageHeading(AboutCommunityBuildingsSchedulePage.pageHeading)
  }

  def validatePageContent(): Unit =
    AboutCommunityBuildingsSchedulePage.verifyEntirePageContent(
      AboutCommunityBuildingsSchedulePage.createSingleStringFromMany(
        AboutCommunityBuildingsSchedulePage.pageCaption,
        AboutCommunityBuildingsSchedulePage.pageHeading,
        AboutCommunityBuildingsSchedulePage.listItem1,
        AboutCommunityBuildingsSchedulePage.listItem2,
        AboutCommunityBuildingsSchedulePage.listItem3,
        AboutCommunityBuildingsSchedulePage.listItem4
      )
    )

  def validateNavigationAgent(): Unit = {
    AboutCommunityBuildingsSchedulePage.verifyPageUrl(AboutCommunityBuildingsSchedulePage.pageUrl)
    AboutCommunityBuildingsSchedulePage.verifyPageTitle(AboutCommunityBuildingsSchedulePage.pageTitle)
    AboutCommunityBuildingsSchedulePage.verifyPageCaption(AboutCommunityBuildingsSchedulePage.pageCaption)
    AboutCommunityBuildingsSchedulePage.verifyPageHeading(AboutCommunityBuildingsSchedulePage.pageHeading)
  }

  def validatePageContentAgent(): Unit =
    AboutCommunityBuildingsSchedulePage.verifyEntirePageContent(
      AboutCommunityBuildingsSchedulePage.createSingleStringFromMany(
        AboutCommunityBuildingsSchedulePage.pageCaption,
        AboutCommunityBuildingsSchedulePage.pageHeading,
        AboutCommunityBuildingsSchedulePage.listItem1Agent,
        AboutCommunityBuildingsSchedulePage.listItem2,
        AboutCommunityBuildingsSchedulePage.listItem3,
        AboutCommunityBuildingsSchedulePage.listItem4
      )
    )

}
