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

object AboutConnectedCharitiesSchedulePage extends BasePage {
  override def pageUrl: String = s"$hostname/about-connected-charities-schedule"

  override def pageTitle: String = "About Connected Charities schedule - Charities - GOV.UK"

  def pageHeading: String = "About Connected Charities schedule"

  def pageCaption: String = "Add Connected Charities schedule"

  def listText1: String = "Use this service to add a Connected Charities schedule."

  def listText2: String = "You can upload a Connected Charities schedule in a .ods format."

  def listText3: String =
    "You can download a Connected Charities schedule here (opens in new tab). You can submit 1 file at a time, and each file can be up to 250KB."

  def continueButton: String = "Continue"

  def backButton: String = "Back"

  def validateNavigation(): Unit = {
    AboutConnectedCharitiesSchedulePage.verifyPageUrl(AboutConnectedCharitiesSchedulePage.pageUrl)
    AboutConnectedCharitiesSchedulePage.verifyPageTitle(AboutConnectedCharitiesSchedulePage.pageTitle)
    AboutConnectedCharitiesSchedulePage.verifyPageCaption(AboutConnectedCharitiesSchedulePage.pageCaption)
    AboutConnectedCharitiesSchedulePage.verifyPageHeader(AboutConnectedCharitiesSchedulePage.pageHeading)
  }

  def validatePageContent(): Unit =
    AboutConnectedCharitiesSchedulePage.verifyEntirePageContent(
      AboutConnectedCharitiesSchedulePage.createSingleStringFromMany(
        AboutConnectedCharitiesSchedulePage.pageCaption,
        AboutConnectedCharitiesSchedulePage.pageHeading,
        AboutConnectedCharitiesSchedulePage.listText1,
        AboutConnectedCharitiesSchedulePage.listText2,
        AboutConnectedCharitiesSchedulePage.listText3,
        AboutConnectedCharitiesSchedulePage.continueButton,
        AboutConnectedCharitiesSchedulePage.backButton
      )
    )
}
