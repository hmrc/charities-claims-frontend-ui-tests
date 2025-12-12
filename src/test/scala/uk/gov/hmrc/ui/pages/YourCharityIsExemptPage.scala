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

object YourCharityIsExemptPage extends BasePage {

  override def pageUrl: String = s"$hostname/charity-exempt"

  override def pageTitle: String =
    "Your charity is exempt - Charities - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeader: String =
    "Your charity is exempt"

  def pageParagraph: String =
    "Your charity is exempt from registering with a regulator because:"

  def pageListItem1: String =
    "it is an educational institution such as a university or school"

  def pageListItem2: String =
    "it is a museum or gallery"

  def pageListItem3: String =
    "it is a housing association"

  def validateNavigation(): Unit = {
    YourCharityIsExemptPage.verifyPageUrl(YourCharityIsExemptPage.pageUrl)
    YourCharityIsExemptPage.verifyPageTitle(YourCharityIsExemptPage.pageTitle)
    YourCharityIsExemptPage.verifyPageCaption(YourCharityIsExemptPage.pageCaption)
    YourCharityIsExemptPage.verifyPageHeader(YourCharityIsExemptPage.pageHeader)
  }

  def validateParagraph(): Unit = {
    YourCharityIsExemptPage.verifyParagraphText(
      YourCharityIsExemptPage.pageParagraph
    )
    YourCharityIsExemptPage.verifyListText(
      YourCharityIsExemptPage.createSingleStringFromMany(
        YourCharityIsExemptPage.pageListItem1,
        YourCharityIsExemptPage.pageListItem2,
        YourCharityIsExemptPage.pageListItem3
      )
    )
  }
}
