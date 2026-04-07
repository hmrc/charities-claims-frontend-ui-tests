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

//  val managementHostname =
//    if (hostname.startsWith("localhost"))
//      hostname
//        .replaceFirst(":\\d+", ":8033")
//        .replaceFirst("/.*$", "/")
//    else
//      hostname.replaceFirst("/.*$", "/")
//
//  val finalUrl = s"${managementHostname}charities-management"
//
//  hostname.replace("charities-claims", "")
  override def pageUrl: String = s"$hostname/charities-management/charity-repayment-dashboard"

  override def pageTitle: String =
    "Charity repayment dashboard - Charities - GOV.UK"

//  def pageCaption: String =
//    "Add Gift Aid schedule"

  def pageHeading: String =
    "Charity repayment dashboard"


  def validateNavigation(): Unit = {
    //CharitiesManagementPlaceholder.verifyPageUrl(CharitiesManagementPlaceholder.pageUrl)
    CharitiesManagementPlaceholder.verifyPageTitle(CharitiesManagementPlaceholder.pageTitle)
    //CharitiesManagementPlaceholder.verifyPageCaption(CharitiesManagementPlaceholder.pageCaption)
    CharitiesManagementPlaceholder.verifyPageHeading(CharitiesManagementPlaceholder.pageHeading)
  }

}
