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

import org.openqa.selenium.By

object WhichTaxYearPage extends BasePage {

  override def pageUrl: String = s"$hostname/which-tax-year-are-you-claiming-for"

  def pageUrl1: String = s"$hostname/which-tax-year-are-you-claiming-for/1"

  def pageUrl2: String = s"$hostname/which-tax-year-are-you-claiming-for/2"

  def pageUrl3: String = s"$hostname/which-tax-year-are-you-claiming-for/3"

  override def pageTitle: String = "Which tax year are you claiming for? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption1: String = "Provide GASDS donation details"

  def pageCaption2: String = "Provide GASDS donation details - Tax year 2"

  def pageCaption3: String = "Provide GASDS donation details - Tax year 3"

  def pageHeading: String = "Which tax year are you claiming for?"

  def pageParagraph: String =
    "The tax year covers April to April. For example, tax year 2016 runs from 6 April 2015 to 5 April 2016."

  def pageHint: String = "For example, 2016"

  val errorSummary = By.ByClassName("govuk-error-summary__body")

  def inputMaxYearLength = 4

  val yearInputLocator      = By.ById("value")
  val yearInputErrorLocator = By.ById("value-error")

  def pageErrorEmpty: String = "Enter a first tax year"

  def pageErrorMaxLength: String = "Enter a first tax year in the correct format"

  def pageUnderYearError: String =
    "Gift Aid Small Donations Scheme community buildings claim cannot be earlier than 2024"

  def pageOverYearError: String =
    "Gift Aid Small Donations Scheme community buildings claim tax year must be this year or earlier"

  def pageErrorWrongFormat1: String = "Enter a first tax year in the correct format"

  def pageErrorWrongFormat2: String = "Enter a second tax year in the correct format"

  def pageErrorWrongFormat3: String = "Enter a third tax year in the correct format"

  def validateNavigation1(): Unit = {
    WhichTaxYearPage.verifyPageUrl(WhichTaxYearPage.pageUrl1)
    WhichTaxYearPage.verifyPageTitle(WhichTaxYearPage.pageTitle)
    WhichTaxYearPage.verifyPageCaption(WhichTaxYearPage.pageCaption1)
    WhichTaxYearPage.verifyPageHeading(WhichTaxYearPage.pageHeading)

  }

  def validatePageProperties1(): Unit = {
    WhichTaxYearPage.verifyPageCaption(WhichTaxYearPage.pageCaption1)
    WhichTaxYearPage.verifyParagraphText(WhichTaxYearPage.pageParagraph)
    WhichTaxYearPage.verifyHintText(WhichTaxYearPage.pageHint)
  }

  def validateNavigation2(): Unit = {
    WhichTaxYearPage.verifyPageUrl(WhichTaxYearPage.pageUrl2)
    WhichTaxYearPage.verifyPageTitle(WhichTaxYearPage.pageTitle)
    WhichTaxYearPage.verifyPageCaption(WhichTaxYearPage.pageCaption2)
    WhichTaxYearPage.verifyPageHeading(WhichTaxYearPage.pageHeading)

  }

  def validatePageProperties2(): Unit = {
    WhichTaxYearPage.verifyPageCaption(WhichTaxYearPage.pageCaption2)
    WhichTaxYearPage.verifyParagraphText(WhichTaxYearPage.pageParagraph)
    WhichTaxYearPage.verifyHintText(WhichTaxYearPage.pageHint)
  }

  def validateNavigation3(): Unit = {
    WhichTaxYearPage.verifyPageUrl(WhichTaxYearPage.pageUrl3)
    WhichTaxYearPage.verifyPageTitle(WhichTaxYearPage.pageTitle)
    WhichTaxYearPage.verifyPageCaption(WhichTaxYearPage.pageCaption3)
    WhichTaxYearPage.verifyPageHeading(WhichTaxYearPage.pageHeading)

  }

  def validatePageProperties3(): Unit = {
    WhichTaxYearPage.verifyPageCaption(WhichTaxYearPage.pageCaption3)
    WhichTaxYearPage.verifyParagraphText(WhichTaxYearPage.pageParagraph)
    WhichTaxYearPage.verifyHintText(WhichTaxYearPage.pageHint)
  }

  def validateErrorMessages1(): Unit =
    WhichTaxYearPage.validateGenericPageError(
      WhichTaxYearPage.pageErrorEmpty,
      WhichTaxYearPage.errorSummary
    )
    WhichTaxYearPage.triggerTooManyCharInputError(
      WhichTaxYearPage.inputMaxYearLength,
      WhichTaxYearPage.pageErrorMaxLength,
      WhichTaxYearPage.yearInputLocator,
      WhichTaxYearPage.yearInputErrorLocator
    )
    WhichTaxYearPage.triggerNonWesternEuropeanAlphabetError(
      WhichTaxYearPage.pageErrorWrongFormat1,
      WhichTaxYearPage.yearInputLocator,
      WhichTaxYearPage.yearInputErrorLocator
    )
    WhichTaxYearPage.triggerBefore2024TaxYearError(
      WhichTaxYearPage.pageUnderYearError,
      WhichTaxYearPage.yearInputLocator,
      WhichTaxYearPage.yearInputErrorLocator
    )
    WhichTaxYearPage.triggerAfterCurrentTaxYearError(
      WhichTaxYearPage.pageOverYearError,
      WhichTaxYearPage.yearInputLocator,
      WhichTaxYearPage.yearInputErrorLocator
    )

  def validateErrorMessages2(): Unit =
    WhichTaxYearPage.validateGenericPageError(
      WhichTaxYearPage.pageErrorEmpty,
      WhichTaxYearPage.errorSummary
    )
    WhichTaxYearPage.triggerTooManyCharInputError(
      WhichTaxYearPage.inputMaxYearLength,
      WhichTaxYearPage.pageErrorMaxLength,
      WhichTaxYearPage.yearInputLocator,
      WhichTaxYearPage.yearInputErrorLocator
    )
    WhichTaxYearPage.triggerNonWesternEuropeanAlphabetError(
      WhichTaxYearPage.pageErrorWrongFormat2,
      WhichTaxYearPage.yearInputLocator,
      WhichTaxYearPage.yearInputErrorLocator
    )
    WhichTaxYearPage.triggerBefore2024TaxYearError(
      WhichTaxYearPage.pageUnderYearError,
      WhichTaxYearPage.yearInputLocator,
      WhichTaxYearPage.yearInputErrorLocator
    )
    WhichTaxYearPage.triggerAfterCurrentTaxYearError(
      WhichTaxYearPage.pageOverYearError,
      WhichTaxYearPage.yearInputLocator,
      WhichTaxYearPage.yearInputErrorLocator
    )

  def validateErrorMessages3(): Unit =
    WhichTaxYearPage.validateGenericPageError(
      WhichTaxYearPage.pageErrorEmpty,
      WhichTaxYearPage.errorSummary
    )
    WhichTaxYearPage.triggerTooManyCharInputError(
      WhichTaxYearPage.inputMaxYearLength,
      WhichTaxYearPage.pageErrorMaxLength,
      WhichTaxYearPage.yearInputLocator,
      WhichTaxYearPage.yearInputErrorLocator
    )
    WhichTaxYearPage.triggerNonWesternEuropeanAlphabetError(
      WhichTaxYearPage.pageErrorWrongFormat3,
      WhichTaxYearPage.yearInputLocator,
      WhichTaxYearPage.yearInputErrorLocator
    )
    WhichTaxYearPage.triggerBefore2024TaxYearError(
      WhichTaxYearPage.pageUnderYearError,
      WhichTaxYearPage.yearInputLocator,
      WhichTaxYearPage.yearInputErrorLocator
    )
    WhichTaxYearPage.triggerAfterCurrentTaxYearError(
      WhichTaxYearPage.pageOverYearError,
      WhichTaxYearPage.yearInputLocator,
      WhichTaxYearPage.yearInputErrorLocator
    )

}
