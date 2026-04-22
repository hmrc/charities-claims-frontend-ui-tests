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

object DeclarationPage extends BasePage {

  override def pageUrl: String = s"$hostname/declaration"

  override def pageTitle: String =
    "Declaration - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "Declaration"

  def pageParagraph: String =
    "By submitting this claim, I confirm that:"

  def listItem1: String =
    "the information given is complete and correct"

  def listItem2: String =
    "I have read the HMRC guidance on claiming Gift Aid and top‑up payments under the Gift Aid Small Donations Scheme"

  def listItem3: String =
    "where this claim relates to Gift Aid, the charity or Community Amateur Sports Club meets the conditions for tax exemption for the period covered by this claim"

  def pageWarningIcon: String =
    "!"

  def pageWarningHeading: String =
    "Warning"

  def pageWarningText: String =
    "I understand that if I give false or misleading information, HMRC may take action against me."

  def validateNavigation(): Unit = {
    DeclarationPage.verifyPageUrl(DeclarationPage.pageUrl)
    DeclarationPage.verifyPageTitle(DeclarationPage.pageTitle)
    DeclarationPage.verifyPageHeading(DeclarationPage.pageHeading)
  }

  def validatePageContent(): Unit = {
    DeclarationPage.verifyParagraphText(
      DeclarationPage.pageParagraph
    )
    DeclarationPage.verifyListText(
      DeclarationPage.createSingleStringFromMany(
        DeclarationPage.listItem1,
        DeclarationPage.listItem2,
        DeclarationPage.listItem3
      )
    )
    DeclarationPage.verifyPageWarning(
      DeclarationPage.createSingleStringFromMany(
        DeclarationPage.pageWarningIcon,
        DeclarationPage.pageWarningHeading,
        DeclarationPage.pageWarningText
      )
    )
  }
}
