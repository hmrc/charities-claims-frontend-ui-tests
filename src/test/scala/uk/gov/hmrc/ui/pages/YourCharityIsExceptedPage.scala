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

object YourCharityIsExceptedPage extends BasePage {

  override def pageUrl: String = s"$hostname/charity-excepted"

  override def pageTitle: String =
    "Your charity is excepted - Charities - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeader: String =
    "Your charity is excepted"

  def pageParagraph: String =
    "Your charity is excepted as the charity's income is £100,000 or less and is classed as one of the following:"

  def pageListItem1: String =
    "a church or chapel"

  def pageListItem2: String =
    "a charity that provides premises for schools"

  def pageListItem3: String =
    "a scout or guide group"

  def pageListItem4: String =
    "a charitable service of the Armed Forces"

  def pageListItem5: String =
    "a student union"

  def validateNavigation(): Unit = {
    YourCharityIsExceptedPage.verifyPageUrl(YourCharityIsExceptedPage.pageUrl)
    YourCharityIsExceptedPage.verifyPageTitle(YourCharityIsExceptedPage.pageTitle)
    YourCharityIsExceptedPage.verifyPageCaption(YourCharityIsExceptedPage.pageCaption)
    YourCharityIsExceptedPage.verifyPageHeader(YourCharityIsExceptedPage.pageHeader)
  }

  def validateParagraph(): Unit = {
    YourCharityIsExceptedPage.verifyParagraphText(
      YourCharityIsExceptedPage.pageParagraph
    )
    YourCharityIsExceptedPage.verifyListText(
      YourCharityIsExceptedPage.createSingleStringFromMany(
        YourCharityIsExceptedPage.pageListItem1,
        YourCharityIsExceptedPage.pageListItem2,
        YourCharityIsExceptedPage.pageListItem3,
        YourCharityIsExceptedPage.pageListItem4,
        YourCharityIsExceptedPage.pageListItem5
      )
    )
  }
}
