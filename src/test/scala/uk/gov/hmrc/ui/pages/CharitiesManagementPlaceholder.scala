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

object CharitiesManagementPlaceholder extends BasePage {

  override def pageUrl: String = s"$hostname/charities-management/charity-repayment-dashboard"

  override def pageTitle: String =
    "Charity repayment dashboard - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "Charity repayment dashboard"

  def validateNavigation(): Unit = {
    // CharitiesManagementPlaceholder.verifyPageUrl(CharitiesManagementPlaceholder.pageUrl)
    CharitiesManagementPlaceholder.verifyPageTitle(CharitiesManagementPlaceholder.pageTitle)
    // CharitiesManagementPlaceholder.verifyPageCaption(CharitiesManagementPlaceholder.pageCaption)
    CharitiesManagementPlaceholder.verifyPageHeading(CharitiesManagementPlaceholder.pageHeading)
  }

}
