/*
 * Copyright 2025 HM Revenue & Customs
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
import org.scalactic.Prettifier.default

object UpdateGiftAidSchedulePage extends BasePage {

  override def pageUrl: String = s"$hostname/update-gift-aid-schedule"

  override def pageTitle: String =
    "Are you sure you want to update this Gift Aid schedule? - Charities - GOV.UK"

  def pageHeading: String =
    "Are you sure you want to update this Gift Aid schedule?"

  def pageHint: String =
    "By updating this file, you will lose any Gift Aid schedule data you have previously attached."

  def errorMsg: String =
    "Select ‘Yes’ if you want to update this Gift Aid schedule"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    UpdateGiftAidSchedulePage.verifyPageUrl(UpdateGiftAidSchedulePage.pageUrl)
    UpdateGiftAidSchedulePage.verifyPageTitle(UpdateGiftAidSchedulePage.pageTitle)
    UpdateGiftAidSchedulePage.verifyPageHeader(UpdateGiftAidSchedulePage.pageHeading)
    UpdateGiftAidSchedulePage.verifyHintText(UpdateGiftAidSchedulePage.pageHint)
  }

  def validateErrorMessage(): Unit =
    UpdateGiftAidSchedulePage.validateGenericPageError(
      UpdateGiftAidSchedulePage.errorMsg,
      UpdateGiftAidSchedulePage.errorMsgLocator
    )

}
