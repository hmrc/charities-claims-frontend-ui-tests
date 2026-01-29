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

object ConnectedCharitiesPage extends BasePage {

  override def pageUrl: String = s"$hostname/connected-to-charities"

  override def pageTitle: String =
    "Connected charities and Community Amateur Sports Clubs - Charities - GOV.UK"

  def pageCaption: String =
    "Provide repayment claim details"

  def pageHeader: String =
    "Connected charities and Community Amateur Sports Clubs"

  def pageParagraph: String =
    "If connected charities and Community Amateur Sports Clubs claim a top-up payment, they will share the maximum £1,250 payment limit for the tax year."

  def pageLegend: String =
    "Are you connected to other charities or a Community Amateur Sports Club?"

  def pageErrorMsg: String =
    "Select 'Yes' if you are connected to other charities or a Community Amateur Sports Club"

  val yes: String     = "#value"
  val no: String      = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation(): Unit = {
    ConnectedCharitiesPage.verifyPageUrl(ConnectedCharitiesPage.pageUrl)
    ConnectedCharitiesPage.verifyPageTitle(ConnectedCharitiesPage.pageTitle)
    ConnectedCharitiesPage.verifyPageCaption(ConnectedCharitiesPage.pageCaption)
    ConnectedCharitiesPage.verifyPageHeader(ConnectedCharitiesPage.pageHeader)
  }

  def validateParagraph(): Unit = {
    ConnectedCharitiesPage.verifyParagraphText(ConnectedCharitiesPage.pageParagraph)
    ConnectedCharitiesPage.verifyLegendText(ConnectedCharitiesPage.pageLegend)
  }

  def validateErrorMessage(): Unit =
    ConnectedCharitiesPage.validateGenericPageError(
      ConnectedCharitiesPage.pageErrorMsg,
      ConnectedCharitiesPage.errorMsgLocator
    )
}
