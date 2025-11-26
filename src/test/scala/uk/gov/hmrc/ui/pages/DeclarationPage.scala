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

object DeclarationPage extends BasePage {

  override def pageUrl: String = "charities-claims/declaration"

//  override def pageUrl: String = "http://localhost:8030/charities-claims/declaration"

  override def pageTitle: String =
    "Declaration - Charities - GOV.UK"

  def pageHeader: String =
    "Declaration"

  def pageParagraph: String =
    "I declare that:"

  def pageListItem: String =
    "I will provide accurate information in this claim"

  def validateNavigation(): Unit = {
    DeclarationPage.verifyPageUrl(DeclarationPage.pageUrl)
    DeclarationPage.verifyPageTitle(DeclarationPage.pageTitle)
    DeclarationPage.verifyPageHeader(DeclarationPage.pageHeader)
  }

  def validateParagraph(): Unit = {
    DeclarationPage.verifyParagraphText(DeclarationPage.pageParagraph)
    DeclarationPage.verifyListText(DeclarationPage.pageListItem)
  }
}
