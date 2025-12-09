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

object CharityRegulatorNumberPage extends BasePage {

  override def pageUrl: String = "s$hostname/charity-regulator-number"

  override def pageTitle: String = "What is the charity regulator number? - Charities - GOV.UK"

  def pageHeader: String = "What is the charity regulator number?"

  def pageCaption: String = "Provide organisation details"

  def pageParagraph: String = "This can be up to 20 numerical characters like 123456789 and does not include letters."

  def pageErrorMsg: String = "Enter a charity regulator number"

  def pageErrorMsgNonNumb: String = "Enter a charity regulator number in the correct format"

  def pageErrorMsgTooManyChars: String = "Enter a charity regulator number in the correct format"

  /* def enterYourCharityRegulatorNumberPage(regulatorNo: String): Unit = {
    input(Locators.inputYourCharityRegulatorNumberPage ,regulatorNo )
    clickContinue()
  } */

  def validateNavigation(): Unit = {
    CharityRegulatorNumberPage.verifyPageUrl(CharityRegulatorNumberPage.pageUrl)
    CharityRegulatorNumberPage.verifyPageTitle(CharityRegulatorNumberPage.pageTitle)
    CharityRegulatorNumberPage.verifyPageHeader(CharityRegulatorNumberPage.pageHeader)
    CharityRegulatorNumberPage.verifyPageCaption(CharityRegulatorNumberPage.pageCaption)
  }

  def validateParagraph(): Unit =
    CharityRegulatorNumberPage.verifyParagraphText(CharityRegulatorNumberPage.pageParagraph)

  /* Error Messages To Be Confirmed */
  def validateErrorMessage(): Unit = {
    CharityRegulatorNumberPage.validateGenericPageError(CharityRegulatorNumberPage.pageErrorMsg)
    CharityRegulatorNumberPage.triggerTooManyCharInputtedError(CharityRegulatorNumberPage.pageErrorMsgTooManyChars)
    /* CharityRegulatorNumberPage.triggerNonNumbError(CharityRegulatorNumberPage.pageErrorMsgNonNumb) */
  }
}
