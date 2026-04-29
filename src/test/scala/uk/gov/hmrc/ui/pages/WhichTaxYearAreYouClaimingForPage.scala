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

  override def pageTitle: String = "Which tax year are you claiming for? - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String = "Provide GASDS donation details"

  def pageHeading: String = "Which tax year are you claiming for?"

  def pageParagraph: String =
    "The tax year covers April to April. For example, tax year 2016 runs from 6 April 2015 to 5 April 2016."

  def pageHint: String = "For example, 2016"

  def enterValidTaxYear(currentTaxYear: String): Unit = {
    input(Locators.txtTaxYear, currentTaxYear)
    clickContinue()
  }

  def inputMaxYearLength = 4

  val yearInputLocator              = By.ById("value")
  val yearInputErrorLocator         = By.ById("value-error")
  val TaxYearNow: String            = currentTaxYear.toString
  val earliestTaxYear: String       = (currentTaxYear - 3).toString
  val secondEarliestTaxYear: String = (currentTaxYear - 2).toString
  val recentTaxYear: String         = (currentTaxYear - 1).toString
  val errorSummary                  = By.ByClassName("govuk-error-summary__body")

  def pageErrorEmpty: String = "Enter a first tax year"

  def pageErrorMaxLength: String = "Enter a first tax year in the correct format"

  def pageUnderYearError: String =
    "Gift Aid Small Donations Scheme community buildings claim cannot be earlier than " + earliestTaxYear

  def pageOverYearError: String =
    "Gift Aid Small Donations Scheme community buildings claim tax year must be this year or earlier"

  def pageErrorWrongFormat1: String = "Enter a first tax year in the correct format"

  def pageErrorWrongFormat2: String = "Enter a second tax year in the correct format"

  def pageErrorWrongFormat3: String = "Enter a third tax year in the correct format"

  /** Trigger Invalid Tax Year error message - <= 2023 */
  def triggerMoreThan3TaxYearsAgoError(
    expectedMessage: String,
    inputLocatorValue: By,
    errorMsgLocatorValue: By
  ): Unit = {
    val moreThan3TaxYearsAgo = (currentTaxYear - 4).toString
    val element              = waitForVisibilityOfElement(inputLocatorValue)
    element.clear()
    element.sendKeys(moreThan3TaxYearsAgo)
    validateGenericPageError(expectedMessage, errorMsgLocatorValue)
  }

  /** Trigger Invalid Tax Year error message - after current tax year */
  def triggerAfterCurrentTaxYearError(
    expectedMessage: String,
    inputLocatorValue: By,
    errorMsgLocatorValue: By
  ): Unit = {
    val afterCurrentTaxYear = (currentTaxYear + 1).toString
    val element             = waitForVisibilityOfElement(inputLocatorValue)
    element.clear()
    element.sendKeys(afterCurrentTaxYear)
    validateGenericPageError(expectedMessage, errorMsgLocatorValue)
  }

  def validateNavigation1(): Unit = {
    WhichTaxYearAreYouClaimingForPage.verifyPageUrl(WhichTaxYearAreYouClaimingForPage.pageUrl + "/1")
    WhichTaxYearAreYouClaimingForPage.verifyPageTitle(WhichTaxYearAreYouClaimingForPage.pageTitle)
    WhichTaxYearAreYouClaimingForPage.verifyPageCaption(WhichTaxYearAreYouClaimingForPage.pageCaption)
    WhichTaxYearAreYouClaimingForPage.verifyPageHeading(WhichTaxYearAreYouClaimingForPage.pageHeading)
  }

  def validatePageProperties1(): Unit = {
    WhichTaxYearAreYouClaimingForPage.verifyPageCaption(WhichTaxYearAreYouClaimingForPage.pageCaption)
    WhichTaxYearAreYouClaimingForPage.verifyParagraphText(WhichTaxYearAreYouClaimingForPage.pageParagraph)
    WhichTaxYearAreYouClaimingForPage.verifyHintText(WhichTaxYearAreYouClaimingForPage.pageHint)
  }

  def validateNavigation2(): Unit = {
    WhichTaxYearAreYouClaimingForPage.verifyPageUrl(WhichTaxYearAreYouClaimingForPage.pageUrl + "/2")
    WhichTaxYearAreYouClaimingForPage.verifyPageTitle(WhichTaxYearAreYouClaimingForPage.pageTitle)
    WhichTaxYearAreYouClaimingForPage.verifyPageCaption(WhichTaxYearAreYouClaimingForPage.pageCaption + " - Tax year 2")
    WhichTaxYearAreYouClaimingForPage.verifyPageHeading(WhichTaxYearAreYouClaimingForPage.pageHeading)
  }

  def validatePageProperties2(): Unit = {
    WhichTaxYearAreYouClaimingForPage.verifyPageCaption(WhichTaxYearAreYouClaimingForPage.pageCaption + " - Tax year 2")
    WhichTaxYearAreYouClaimingForPage.verifyParagraphText(WhichTaxYearAreYouClaimingForPage.pageParagraph)
    WhichTaxYearAreYouClaimingForPage.verifyHintText(WhichTaxYearAreYouClaimingForPage.pageHint)
  }

  def validateNavigation3(): Unit = {
    WhichTaxYearAreYouClaimingForPage.verifyPageUrl(WhichTaxYearAreYouClaimingForPage.pageUrl + "/3")
    WhichTaxYearAreYouClaimingForPage.verifyPageTitle(WhichTaxYearAreYouClaimingForPage.pageTitle)
    WhichTaxYearAreYouClaimingForPage.verifyPageCaption(WhichTaxYearAreYouClaimingForPage.pageCaption + " - Tax year 3")
    WhichTaxYearAreYouClaimingForPage.verifyPageHeading(WhichTaxYearAreYouClaimingForPage.pageHeading)
  }

  def validatePageProperties3(): Unit = {
    WhichTaxYearAreYouClaimingForPage.verifyPageCaption(WhichTaxYearAreYouClaimingForPage.pageCaption + " - Tax year 3")
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
    WhichTaxYearAreYouClaimingForPage.triggerMoreThan3TaxYearsAgoError(
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
    WhichTaxYearAreYouClaimingForPage.triggerMoreThan3TaxYearsAgoError(
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
    WhichTaxYearAreYouClaimingForPage.triggerMoreThan3TaxYearsAgoError(
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
