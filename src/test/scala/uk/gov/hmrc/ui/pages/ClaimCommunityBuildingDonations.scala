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

import org.openqa.selenium.By

object ClaimCommunityBuildingDonations extends BasePage{

  override def pageUrl : String = s"$hostname/claim-community-building-donations"

  override def pageTitle : String =
    "Do you want to claim for donations collected in community buildings? - Charities - GOV.UK"

  def pageHeading : String =
    "Do you want to claim for donations collected in community buildings?"

  def pageCaption : String =
    "Provide repayment claim details"

  def pageHint : String =
    "For donations of £20 or less that were collected in a community building during charitable activities."

  def errorMsg : String =
    "Select 'Yes' if you are claiming for donations collected in community buildings"

  val yes: String = "#value"
  val no: String = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation () : Unit ={
    ClaimCommunityBuildingDonations.verifyPageUrl(ClaimCommunityBuildingDonations.pageUrl)
    ClaimCommunityBuildingDonations.verifyPageTitle(ClaimCommunityBuildingDonations.pageTitle)
    ClaimCommunityBuildingDonations.verifyPageHeader(ClaimCommunityBuildingDonations.pageHeading)
    ClaimCommunityBuildingDonations.verifyPageCaption(ClaimCommunityBuildingDonations.pageCaption)
  }

  def validateHint(): Unit =
    ClaimCommunityBuildingDonations.verifyHintText(ClaimCommunityBuildingDonations.pageHint)

  def validateErrorMessage(): Unit =
    ClaimCommunityBuildingDonations.validateGenericPageError(
      ClaimCommunityBuildingDonations.errorMsg,
      ClaimCommunityBuildingDonations.errorMsgLocator
    )

}
