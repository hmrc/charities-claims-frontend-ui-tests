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

object DoYouWantToClaimATopUpUnderGASDSPage extends BasePage {

  override def pageUrl: String = s"$hostname/claim-gasds-payment"

  def changePageUrl: String = s"$hostname/change-claim-gasds-payment"

  override def pageTitle: String =
    "Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme? - Charities - GOV.UK"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageHeading: String =
    "Do you want to claim a top-up payment under the Gift Aid Small Donations Scheme?"

  def pageHint: String =
    "For donations of £20 or less that were not collected in a community building."

  def pageErrorMsg: String =
    "Select ‘Yes’ if you are claiming under the Gift Aid Small Donations Scheme"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    DoYouWantToClaimATopUpUnderGASDSPage.verifyPageUrl(DoYouWantToClaimATopUpUnderGASDSPage.pageUrl)
    DoYouWantToClaimATopUpUnderGASDSPage.verifyPageTitle(DoYouWantToClaimATopUpUnderGASDSPage.pageTitle)
    DoYouWantToClaimATopUpUnderGASDSPage.verifyPageCaption(DoYouWantToClaimATopUpUnderGASDSPage.pageCaption)
    DoYouWantToClaimATopUpUnderGASDSPage.verifyPageHeading(DoYouWantToClaimATopUpUnderGASDSPage.pageHeading)
  }

  def validateChangeNavigation(): Unit = {
    DoYouWantToClaimATopUpUnderGASDSPage.verifyPageUrl(DoYouWantToClaimATopUpUnderGASDSPage.changePageUrl)
    DoYouWantToClaimATopUpUnderGASDSPage.verifyPageTitle(DoYouWantToClaimATopUpUnderGASDSPage.pageTitle)
    DoYouWantToClaimATopUpUnderGASDSPage.verifyPageCaption(DoYouWantToClaimATopUpUnderGASDSPage.pageCaption)
    DoYouWantToClaimATopUpUnderGASDSPage.verifyPageHeading(DoYouWantToClaimATopUpUnderGASDSPage.pageHeading)
  }

  def validateHint(): Unit =
    DoYouWantToClaimATopUpUnderGASDSPage.verifyHintText(DoYouWantToClaimATopUpUnderGASDSPage.pageHint)

  /** Validate that the error message is correct */
  def validateErrorMessage(): Unit =
    DoYouWantToClaimATopUpUnderGASDSPage.validateGenericPageError(
      DoYouWantToClaimATopUpUnderGASDSPage.pageErrorMsg,
      DoYouWantToClaimATopUpUnderGASDSPage.errorMsgLocator
    )
}
