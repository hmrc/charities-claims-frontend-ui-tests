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

object YourClaimReferenceNumberPage extends BasePage {

  override def pageUrl: String = s"$hostname/enter-claim-reference-number"

  override def pageTitle: String =
    "Your claim reference number - Charities - GOV.UK"

  def pageHeader: String =
    "Your claim reference number"

  def pageParagraph: String =
    "You do not have to complete this box but you can use it to show your claim reference if you use one. The reference that you quote will appear on the payment advice note you receive from us when we pay the claim."

  def pageErrorMsg: String =
    "Enter your claim reference number"

  def pageErrorMsgTooManyChars =
    "Claim reference number must be 20 characters or less"

  def pageErrorMsgNonWesternChar =
    "Include characters from Western European alphabets"

  def pageNotFoundTitle: String =
    "Page not found - Charities - GOV.UK"

  def pageNotFoundHeading: String =
    "Page not found"

  def pageNotFoundListItem1: String =
    "If you typed the web address, check it is correct."

  def pageNotFoundListItem2: String =
    "If you pasted the web address, check you copied the entire address."

  def pageNotFoundListItem3: String =
    "If the web address is correct or you selected a link or button, contact the HMRC Online Services Helpdesk if you need to speak to someone."

  def enterClaimReferenceNumber(referenceNo: String): Unit = {
    input(Locators.inputYourClaimReferenceNumber, referenceNo)
    clickContinue()
  }

  def validateNavigation(): Unit = {
    YourClaimReferenceNumberPage.verifyPageUrl(YourClaimReferenceNumberPage.pageUrl)
    YourClaimReferenceNumberPage.verifyPageTitle(YourClaimReferenceNumberPage.pageTitle)
    YourClaimReferenceNumberPage.verifyPageHeader(YourClaimReferenceNumberPage.pageHeader)
  }

  def validateParagraph(): Unit =
    YourClaimReferenceNumberPage.verifyParagraphText(YourClaimReferenceNumberPage.pageParagraph)

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit = {
    YourClaimReferenceNumberPage.validateGenericPageError(YourClaimReferenceNumberPage.pageErrorMsg)
    YourClaimReferenceNumberPage.triggerTooManyCharInputtedError(YourClaimReferenceNumberPage.pageErrorMsgTooManyChars)
    YourClaimReferenceNumberPage.triggerNonWesternEuropeanAlphabetError(
      YourClaimReferenceNumberPage.pageErrorMsgNonWesternChar
    )
  }

  /** Validate the user has navigated to the page but has bypassed data guard and will be displayed a '404' page */
  def validateNavigationToPageNotFound(): Unit = {
    YourClaimReferenceNumberPage.verifyPageUrl(YourClaimReferenceNumberPage.pageUrl)
    YourClaimReferenceNumberPage.verifyPageTitle(YourClaimReferenceNumberPage.pageNotFoundTitle)
    YourClaimReferenceNumberPage.verifyPageHeader(YourClaimReferenceNumberPage.pageNotFoundHeading)
  }

  /** Used to validate that if the user skips to this URL that they're displayed a 'Page Not Found' */
  def validatePageNotFound(): Unit =
    YourClaimReferenceNumberPage.verifyErrorPageContent(
      YourClaimReferenceNumberPage.createSingleStringFromMany(
        YourClaimReferenceNumberPage.pageNotFoundHeading,
        YourClaimReferenceNumberPage.pageNotFoundListItem1,
        YourClaimReferenceNumberPage.pageNotFoundListItem2,
        YourClaimReferenceNumberPage.pageNotFoundListItem3
      )
    )
}
