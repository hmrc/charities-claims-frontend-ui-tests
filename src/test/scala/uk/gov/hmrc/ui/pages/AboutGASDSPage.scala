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

object AboutGASDSPage extends BasePage {

  override def pageUrl: String = s"$hostname/about-gift-aid-small-donations-scheme"

  override def pageTitle: String =
    "About Gift Aid Small Donations Scheme schedule - Charities - GOV.UK"

  def pageCaption: String =
    "Provide GASDS donation details"

  def pageHeading: String =
    "About Gift Aid Small Donations Scheme schedule"

  def listItem1: String =
    "Use this service to claim payments under the Gift Aid Small Donations Scheme (GASDS). You can add claims for up to 3 tax years."

  def listItem2: String =
    "GASDS applies to cash donations of £30 or less where the charity or Community Amateur Sports Club does not have a Gift Aid declaration."

  def listItem3: String =
    "Continue"

  def validateNavigation(): Unit = {
    AboutGASDSPage.verifyPageUrl(AboutGASDSPage.pageUrl)
    AboutGASDSPage.verifyPageTitle(AboutGASDSPage.pageTitle)
    AboutGASDSPage.verifyPageCaption(AboutGASDSPage.pageCaption)
    AboutGASDSPage.verifyPageHeading(AboutGASDSPage.pageHeading)
  }

  def validatePageContent(): Unit =
    AboutGASDSPage.verifyEntirePageContent(
      AboutGASDSPage.createSingleStringFromMany(
        AboutGASDSPage.pageCaption,
        AboutGASDSPage.pageHeading,
        AboutGASDSPage.listItem1,
        AboutGASDSPage.listItem2,
        AboutGASDSPage.listItem3
      )
    )

}
