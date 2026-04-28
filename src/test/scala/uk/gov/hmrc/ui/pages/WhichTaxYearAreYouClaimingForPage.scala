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
import uk.gov.hmrc.ui.pages.CorporateTrusteeDetailsPage.{clickContinue, input}

object WhichTaxYearAreYouClaimingForPage extends BasePage {

  override def pageUrl: String = s"$hostname/which-tax-year-are-you-claiming-for"

  def pageUrl1: String = pageUrl + "/1"

  def pageUrl2: String = pageUrl + "/2"

  def pageUrl3: String = pageUrl + "/3"

  override def pageTitle: String = "Which tax year are you claiming for? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption1: String = "Provide GASDS donation details"

  def pageCaption2: String = "Provide GASDS donation details - Tax year 2"

  def pageCaption3: String = "Provide GASDS donation details - Tax year 3"

  def pageHeading: String = "Which tax year are you claiming for?"

  def pageParagraph: String =
    "The tax year covers April to April. For example, tax year 2016 runs from 6 April 2015 to 5 April 2016."

  def pageHint: String = "For example, 2016"

  def enterValidTaxYear(taxYear: String): Unit = {
    input(Locators.txtTaxYear, taxYear)
    clickContinue()
  }

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
    WhichTaxYearAreYouClaimingForPage.verifyPageUrl(WhichTaxYearAreYouClaimingForPage.pageUrl1)
    WhichTaxYearAreYouClaimingForPage.verifyPageTitle(WhichTaxYearAreYouClaimingForPage.pageTitle)
    WhichTaxYearAreYouClaimingForPage.verifyPageCaption(WhichTaxYearAreYouClaimingForPage.pageCaption1)
    WhichTaxYearAreYouClaimingForPage.verifyPageHeading(WhichTaxYearAreYouClaimingForPage.pageHeading)
  }

  def validatePageProperties1(): Unit = {
    WhichTaxYearAreYouClaimingForPage.verifyPageCaption(WhichTaxYearAreYouClaimingForPage.pageCaption1)
    WhichTaxYearAreYouClaimingForPage.verifyParagraphText(WhichTaxYearAreYouClaimingForPage.pageParagraph)
    WhichTaxYearAreYouClaimingForPage.verifyHintText(WhichTaxYearAreYouClaimingForPage.pageHint)
  }

  def validateNavigation2(): Unit = {
    WhichTaxYearAreYouClaimingForPage.verifyPageUrl(WhichTaxYearAreYouClaimingForPage.pageUrl2)
    WhichTaxYearAreYouClaimingForPage.verifyPageTitle(WhichTaxYearAreYouClaimingForPage.pageTitle)
    WhichTaxYearAreYouClaimingForPage.verifyPageCaption(WhichTaxYearAreYouClaimingForPage.pageCaption2)
    WhichTaxYearAreYouClaimingForPage.verifyPageHeading(WhichTaxYearAreYouClaimingForPage.pageHeading)
  }

  def validatePageProperties2(): Unit = {
    WhichTaxYearAreYouClaimingForPage.verifyPageCaption(WhichTaxYearAreYouClaimingForPage.pageCaption2)
    WhichTaxYearAreYouClaimingForPage.verifyParagraphText(WhichTaxYearAreYouClaimingForPage.pageParagraph)
    WhichTaxYearAreYouClaimingForPage.verifyHintText(WhichTaxYearAreYouClaimingForPage.pageHint)
  }

  def validateNavigation3(): Unit = {
    WhichTaxYearAreYouClaimingForPage.verifyPageUrl(WhichTaxYearAreYouClaimingForPage.pageUrl3)
    WhichTaxYearAreYouClaimingForPage.verifyPageTitle(WhichTaxYearAreYouClaimingForPage.pageTitle)
    WhichTaxYearAreYouClaimingForPage.verifyPageCaption(WhichTaxYearAreYouClaimingForPage.pageCaption3)
    WhichTaxYearAreYouClaimingForPage.verifyPageHeading(WhichTaxYearAreYouClaimingForPage.pageHeading)
  }

  def validatePageProperties3(): Unit = {
    WhichTaxYearAreYouClaimingForPage.verifyPageCaption(WhichTaxYearAreYouClaimingForPage.pageCaption3)
    WhichTaxYearAreYouClaimingForPage.verifyParagraphText(WhichTaxYearAreYouClaimingForPage.pageParagraph)
    WhichTaxYearAreYouClaimingForPage.verifyHintText(WhichTaxYearAreYouClaimingForPage.pageHint)
  }

  def validateErrorMessages1(): Unit =
    WhichTaxYearAreYouClaimingForPage.validateGenericPageError(
      WhichTaxYearAreYouClaimingForPage.pageErrorEmpty,
      WhichTaxYearAreYouClaimingForPage.errorSummary
    )
    WhichTaxYearAreYouClaimingForPage.triggerTooManyCharInputError(
      WhichTaxYearAreYouClaimingForPage.inputMaxYearLength,
      WhichTaxYearAreYouClaimingForPage.pageErrorMaxLength,
      WhichTaxYearAreYouClaimingForPage.yearInputLocator,
      WhichTaxYearAreYouClaimingForPage.yearInputErrorLocator
    )
    WhichTaxYearAreYouClaimingForPage.triggerNonWesternEuropeanAlphabetError(
      WhichTaxYearAreYouClaimingForPage.pageErrorWrongFormat1,
      WhichTaxYearAreYouClaimingForPage.yearInputLocator,
      WhichTaxYearAreYouClaimingForPage.yearInputErrorLocator
    )
    WhichTaxYearAreYouClaimingForPage.triggerBefore2024TaxYearError(
      WhichTaxYearAreYouClaimingForPage.pageUnderYearError,
      WhichTaxYearAreYouClaimingForPage.yearInputLocator,
      WhichTaxYearAreYouClaimingForPage.yearInputErrorLocator
    )
    WhichTaxYearAreYouClaimingForPage.triggerAfterCurrentTaxYearError(
      WhichTaxYearAreYouClaimingForPage.pageOverYearError,
      WhichTaxYearAreYouClaimingForPage.yearInputLocator,
      WhichTaxYearAreYouClaimingForPage.yearInputErrorLocator
    )

  def validateErrorMessages2(): Unit =
    WhichTaxYearAreYouClaimingForPage.validateGenericPageError(
      WhichTaxYearAreYouClaimingForPage.pageErrorEmpty,
      WhichTaxYearAreYouClaimingForPage.errorSummary
    )
    WhichTaxYearAreYouClaimingForPage.triggerTooManyCharInputError(
      WhichTaxYearAreYouClaimingForPage.inputMaxYearLength,
      WhichTaxYearAreYouClaimingForPage.pageErrorMaxLength,
      WhichTaxYearAreYouClaimingForPage.yearInputLocator,
      WhichTaxYearAreYouClaimingForPage.yearInputErrorLocator
    )
    WhichTaxYearAreYouClaimingForPage.triggerNonWesternEuropeanAlphabetError(
      WhichTaxYearAreYouClaimingForPage.pageErrorWrongFormat2,
      WhichTaxYearAreYouClaimingForPage.yearInputLocator,
      WhichTaxYearAreYouClaimingForPage.yearInputErrorLocator
    )
    WhichTaxYearAreYouClaimingForPage.triggerBefore2024TaxYearError(
      WhichTaxYearAreYouClaimingForPage.pageUnderYearError,
      WhichTaxYearAreYouClaimingForPage.yearInputLocator,
      WhichTaxYearAreYouClaimingForPage.yearInputErrorLocator
    )
    WhichTaxYearAreYouClaimingForPage.triggerAfterCurrentTaxYearError(
      WhichTaxYearAreYouClaimingForPage.pageOverYearError,
      WhichTaxYearAreYouClaimingForPage.yearInputLocator,
      WhichTaxYearAreYouClaimingForPage.yearInputErrorLocator
    )

  def validateErrorMessages3(): Unit =
    WhichTaxYearAreYouClaimingForPage.validateGenericPageError(
      WhichTaxYearAreYouClaimingForPage.pageErrorEmpty,
      WhichTaxYearAreYouClaimingForPage.errorSummary
    )
    WhichTaxYearAreYouClaimingForPage.triggerTooManyCharInputError(
      WhichTaxYearAreYouClaimingForPage.inputMaxYearLength,
      WhichTaxYearAreYouClaimingForPage.pageErrorMaxLength,
      WhichTaxYearAreYouClaimingForPage.yearInputLocator,
      WhichTaxYearAreYouClaimingForPage.yearInputErrorLocator
    )
    WhichTaxYearAreYouClaimingForPage.triggerNonWesternEuropeanAlphabetError(
      WhichTaxYearAreYouClaimingForPage.pageErrorWrongFormat3,
      WhichTaxYearAreYouClaimingForPage.yearInputLocator,
      WhichTaxYearAreYouClaimingForPage.yearInputErrorLocator
    )
    WhichTaxYearAreYouClaimingForPage.triggerBefore2024TaxYearError(
      WhichTaxYearAreYouClaimingForPage.pageUnderYearError,
      WhichTaxYearAreYouClaimingForPage.yearInputLocator,
      WhichTaxYearAreYouClaimingForPage.yearInputErrorLocator
    )
    WhichTaxYearAreYouClaimingForPage.triggerAfterCurrentTaxYearError(
      WhichTaxYearAreYouClaimingForPage.pageOverYearError,
      WhichTaxYearAreYouClaimingForPage.yearInputLocator,
      WhichTaxYearAreYouClaimingForPage.yearInputErrorLocator
    )
}
