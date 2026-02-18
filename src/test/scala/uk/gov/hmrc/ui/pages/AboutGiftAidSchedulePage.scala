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

object AboutGiftAidSchedulePage extends BasePage {

  override def pageUrl: String = s"$hostname/about-gift-aid-schedule"

  override def pageTitle: String =
    "About Gift Aid schedule - Charities - GOV.UK"

  def pageCaption: String =
    "Add Gift Aid schedule"

  def pageHeading: String =
    "About Gift Aid schedule"

  def listItem1: String =
    "Use this service to add a Gift Aid schedule."

  def listItem2: String =
    "You can upload a Gift Aid schedule in a .ods format."

  def listItem3: String =
    "You can download a Gift Aid schedule here (opens in new tab). You can submit 1 file at a time, and each file can be up to 250 KB."

  def listItem4: String =
    "Continue"

  def validateNavigation(): Unit = {
    AboutGiftAidSchedulePage.verifyPageUrl(AboutGiftAidSchedulePage.pageUrl)
    AboutGiftAidSchedulePage.verifyPageTitle(AboutGiftAidSchedulePage.pageTitle)
    AboutGiftAidSchedulePage.verifyPageCaption(AboutGiftAidSchedulePage.pageCaption)
    AboutGiftAidSchedulePage.verifyPageHeader(AboutGiftAidSchedulePage.pageHeading)
  }

  def validatePageContent(): Unit =
    AboutGiftAidSchedulePage.verifyEntirePageContent(
      AboutGiftAidSchedulePage.createSingleStringFromMany(
        AboutGiftAidSchedulePage.pageCaption,
        AboutGiftAidSchedulePage.pageHeading,
        AboutGiftAidSchedulePage.listItem1,
        AboutGiftAidSchedulePage.listItem2,
        AboutGiftAidSchedulePage.listItem3,
        AboutGiftAidSchedulePage.listItem4
      )
    )
}
