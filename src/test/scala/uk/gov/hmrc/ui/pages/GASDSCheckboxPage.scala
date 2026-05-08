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

object GASDSCheckboxPage extends BasePage {

  override def pageUrl: String = s"$hostname/select-gift-aid-small-donations-scheme-claim-type"
  def changePageUrl: String    = s"$hostname/change-select-gift-aid-small-donations-scheme-claim-type"

  override def pageTitle: String =
    "Gift Aid Small Donations Scheme (GASDS) details - Make a charity tax repayment claim - GOV.UK"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageCaptionAgent: String =
    "Provide charity repayment claim details"

  def pageHeading: String =
    "Gift Aid Small Donations Scheme (GASDS) details"

  def pageParagraph: String =
    "We need to know what you want to claim under GASDS."

  def pageParagraphAgent: String =
    "We need to know what the charity is claiming under GASDS."

  def pageSubHeading1: String =
    "You can claim:"

  def pageSubHeading1Agent: String =
    "The charity can claim:"

  def pageBullet1: String =
    "GASDS top-up payments"

  def pageHint1: String =
    "For donations of £30 or less that were not collected in a community building."

  def pageBullet2: String =
    "Community buildings top-up payments"

  def pageHint2: String =
    "For donations of £30 or less that were collected in a community building during charitable activities."

  def pageBullet3: String =
    "Connected charity or CASC claims"

  def pageHint3: String =
    "If your client is connected to other charities or Community Amateur Sports Clubs (CASCs), the £2,000 payment limit is shared across all connected organisations."

  def pageSubHeading2: String =
    "Which type of GASDS claim(s) do you want to make?"

  def pageSubHeading2Agent: String =
    "Which type of GASDS claim(s) do you want to make for the charity?"

  def pageHintSelectAtLeastOne: String =
    "Select at least one"

  def pageCheckbox1: String =
    "GASDS top-up payment"

  def pageCheckbox2: String =
    "Community buildings top-up payment"

  def pageCheckbox3: String =
    "Connected charity or CASC claim"

  def btnContinue: String =
    "Continue"

  def pageErrorMsg: String =
    "Select which type of GASDS claim(s) you want to make"

  val GASDSTopUp: String     = "#value"
  val GASDSBuilding: String  = "#value_1"
  val GASDSConnected: String = "#value_2"
  val errorMsgLocator        = By.ById("value-error")

  def validateNavigation(): Unit = {
    GASDSCheckboxPage.verifyPageUrl(GASDSCheckboxPage.pageUrl)
    GASDSCheckboxPage.verifyPageTitle(GASDSCheckboxPage.pageTitle)
    GASDSCheckboxPage.verifyPageCaption(GASDSCheckboxPage.pageCaption)
    GASDSCheckboxPage.verifyPageHeading(GASDSCheckboxPage.pageHeading)
  }

  def validateNavigationAgent(): Unit = {
    GASDSCheckboxPage.verifyPageUrl(GASDSCheckboxPage.pageUrl)
    GASDSCheckboxPage.verifyPageTitle(GASDSCheckboxPage.pageTitle)
    GASDSCheckboxPage.verifyPageCaption(GASDSCheckboxPage.pageCaptionAgent)
    GASDSCheckboxPage.verifyPageHeading(GASDSCheckboxPage.pageHeading)
  }

  def validateChangeNavigation(): Unit = {
    GASDSCheckboxPage.verifyPageUrl(GASDSCheckboxPage.changePageUrl)
    GASDSCheckboxPage.verifyPageTitle(GASDSCheckboxPage.pageTitle)
    GASDSCheckboxPage.verifyPageCaption(GASDSCheckboxPage.pageCaption)
    GASDSCheckboxPage.verifyPageHeading(GASDSCheckboxPage.pageHeading)
  }

  def validateChangeNavigationAgent(): Unit = {
    GASDSCheckboxPage.verifyPageUrl(GASDSCheckboxPage.changePageUrl)
    GASDSCheckboxPage.verifyPageTitle(GASDSCheckboxPage.pageTitle)
    GASDSCheckboxPage.verifyPageCaption(GASDSCheckboxPage.pageCaptionAgent)
    GASDSCheckboxPage.verifyPageHeading(GASDSCheckboxPage.pageHeading)
  }

  def validatePageContent(): Unit =
    GASDSCheckboxPage.verifyEntirePageContent(
      GASDSCheckboxPage.createSingleStringFromMany(
        GASDSCheckboxPage.pageCaption,
        GASDSCheckboxPage.pageHeading,
        GASDSCheckboxPage.pageParagraph,
        GASDSCheckboxPage.pageSubHeading1,
        GASDSCheckboxPage.pageBullet1,
        GASDSCheckboxPage.pageHint1,
        GASDSCheckboxPage.pageBullet2,
        GASDSCheckboxPage.pageHint2,
        GASDSCheckboxPage.pageBullet3,
        GASDSCheckboxPage.pageHint3,
        GASDSCheckboxPage.pageSubHeading2,
        GASDSCheckboxPage.pageHintSelectAtLeastOne,
        GASDSCheckboxPage.pageCheckbox1,
        GASDSCheckboxPage.pageCheckbox2,
        GASDSCheckboxPage.pageCheckbox3,
        GASDSCheckboxPage.btnContinue
      )
    )

  def validatePageContentCASC(): Unit =
    GASDSCheckboxPage.verifyEntirePageContent(
      GASDSCheckboxPage.createSingleStringFromMany(
        GASDSCheckboxPage.pageCaption,
        GASDSCheckboxPage.pageHeading,
        GASDSCheckboxPage.pageParagraph,
        GASDSCheckboxPage.pageSubHeading1,
        GASDSCheckboxPage.pageBullet1,
        GASDSCheckboxPage.pageHint1,
        GASDSCheckboxPage.pageBullet2,
        GASDSCheckboxPage.pageHint2,
        GASDSCheckboxPage.pageBullet3,
        GASDSCheckboxPage.pageHint3,
        GASDSCheckboxPage.pageSubHeading2,
        GASDSCheckboxPage.pageHintSelectAtLeastOne,
        GASDSCheckboxPage.pageCheckbox1,
        GASDSCheckboxPage.pageCheckbox3,
        GASDSCheckboxPage.btnContinue
      )
    )

  def validatePageContentAgent(): Unit =
    GASDSCheckboxPage.verifyEntirePageContent(
      GASDSCheckboxPage.createSingleStringFromMany(
        GASDSCheckboxPage.pageCaptionAgent,
        GASDSCheckboxPage.pageHeading,
        GASDSCheckboxPage.pageParagraphAgent,
        GASDSCheckboxPage.pageSubHeading1Agent,
        GASDSCheckboxPage.pageBullet1,
        GASDSCheckboxPage.pageHint1,
        GASDSCheckboxPage.pageBullet2,
        GASDSCheckboxPage.pageHint2,
        GASDSCheckboxPage.pageBullet3,
        GASDSCheckboxPage.pageHint3,
        GASDSCheckboxPage.pageSubHeading2Agent,
        GASDSCheckboxPage.pageHintSelectAtLeastOne,
        GASDSCheckboxPage.pageCheckbox1,
        GASDSCheckboxPage.pageCheckbox2,
        GASDSCheckboxPage.pageCheckbox3,
        GASDSCheckboxPage.btnContinue
      )
    )

  def validatePageContentCASCAgent(): Unit =
    GASDSCheckboxPage.verifyEntirePageContent(
      GASDSCheckboxPage.createSingleStringFromMany(
        GASDSCheckboxPage.pageCaptionAgent,
        GASDSCheckboxPage.pageHeading,
        GASDSCheckboxPage.pageParagraphAgent,
        GASDSCheckboxPage.pageSubHeading1Agent,
        GASDSCheckboxPage.pageBullet1,
        GASDSCheckboxPage.pageHint1,
        GASDSCheckboxPage.pageBullet2,
        GASDSCheckboxPage.pageHint2,
        GASDSCheckboxPage.pageBullet3,
        GASDSCheckboxPage.pageHint3,
        GASDSCheckboxPage.pageSubHeading2Agent,
        GASDSCheckboxPage.pageHintSelectAtLeastOne,
        GASDSCheckboxPage.pageCheckbox1,
        GASDSCheckboxPage.pageCheckbox3,
        GASDSCheckboxPage.btnContinue
      )
    )

  def validateErrorMessage(): Unit =
    GASDSCheckboxPage.validateGenericPageError(
      GASDSCheckboxPage.pageErrorMsg,
      GASDSCheckboxPage.errorMsgLocator
    )
}
