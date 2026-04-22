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

object IsACorporateTrusteeMakingThisClaimPage extends BasePage {

  override def pageUrl: String = s"$hostname/corporate-trustee-claim"

  override def pageTitle: String =
    "Is a corporate trustee making this claim? - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String = "Is a corporate trustee making this claim?"

  def pageCaption: String = "Provide organisation details"

  def pageParagraph: String = "This can be the trust department of a bank, a trust company or trust corporation"

  def pageErrorMsg: String = "Select ‘Yes’ if this claim is being made by a corporate trustee"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    IsACorporateTrusteeMakingThisClaimPage.verifyPageUrl(IsACorporateTrusteeMakingThisClaimPage.pageUrl)
    IsACorporateTrusteeMakingThisClaimPage.verifyPageTitle(IsACorporateTrusteeMakingThisClaimPage.pageTitle)
    IsACorporateTrusteeMakingThisClaimPage.verifyPageCaption(IsACorporateTrusteeMakingThisClaimPage.pageCaption)
    IsACorporateTrusteeMakingThisClaimPage.verifyPageHeading(IsACorporateTrusteeMakingThisClaimPage.pageHeading)
  }

  def validateErrorMessage(): Unit =
    IsACorporateTrusteeMakingThisClaimPage.validateGenericPageError(
      IsACorporateTrusteeMakingThisClaimPage.pageErrorMsg,
      IsACorporateTrusteeMakingThisClaimPage.errorMsgLocator
    )
}
