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

object YourCharityIsExemptPage extends BasePage {

  override def pageUrl: String = s"$hostname/charity-exempt"

  override def pageTitle: String =
    "Your charity is exempt - Make a charity tax repayment claim - GOV.UK"

  def pageTitleAgent: String =
    "The charity is exempt - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide organisation details"

  def pageHeading: String =
    "Your charity is exempt"

  def pageHeadingAgent: String =
    "The charity is exempt"

  def pageParagraph: String =
    "Your charity is exempt from registering with a regulator because it is a:"

  def pageParagraphAgent: String =
    "The charity is exempt from registering with a regulator because it is a:"

  def pageListItem1: String =
    "university or school"

  def pageListItem2: String =
    "museum or gallery"

  def pageListItem3: String =
    "housing association"

  def validateNavigation(): Unit = {
    YourCharityIsExemptPage.verifyPageUrl(YourCharityIsExemptPage.pageUrl)
    YourCharityIsExemptPage.verifyPageTitle(YourCharityIsExemptPage.pageTitle)
    YourCharityIsExemptPage.verifyPageCaption(YourCharityIsExemptPage.pageCaption)
    YourCharityIsExemptPage.verifyPageHeading(YourCharityIsExemptPage.pageHeading)
  }

  def validateNavigationAgent(): Unit = {
    YourCharityIsExemptPage.verifyPageUrl(YourCharityIsExemptPage.pageUrl)
    YourCharityIsExemptPage.verifyPageTitle(YourCharityIsExemptPage.pageTitleAgent)
    YourCharityIsExemptPage.verifyPageCaption(YourCharityIsExemptPage.pageCaption)
    YourCharityIsExemptPage.verifyPageHeading(YourCharityIsExemptPage.pageHeadingAgent)
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

  def validateParagraphAgent(): Unit = {
    YourCharityIsExemptPage.verifyParagraphText(
      YourCharityIsExemptPage.pageParagraphAgent
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
