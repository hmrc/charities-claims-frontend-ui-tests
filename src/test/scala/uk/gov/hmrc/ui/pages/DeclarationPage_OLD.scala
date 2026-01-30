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

object DeclarationPage_OLD extends BasePage {

  override def pageUrl: String = s"$hostname/old/declaration"

  override def pageTitle: String =
    "Declaration - Charities - GOV.UK"

  def pageHeader: String =
    "Declaration"

  def pageParagraph: String =
    "I declare that:"

  def pageListItem: String =
    "I will provide accurate information in this claim"

  def validateNavigation(): Unit = {
    DeclarationPage_OLD.verifyPageUrl(DeclarationPage_OLD.pageUrl)
    DeclarationPage_OLD.verifyPageTitle(DeclarationPage_OLD.pageTitle)
    DeclarationPage_OLD.verifyPageHeader(DeclarationPage_OLD.pageHeader)
  }

  def validateParagraph(): Unit = {
    DeclarationPage_OLD.verifyParagraphText(DeclarationPage_OLD.pageParagraph)
    DeclarationPage_OLD.verifyListText(DeclarationPage_OLD.pageListItem)
  }
}
