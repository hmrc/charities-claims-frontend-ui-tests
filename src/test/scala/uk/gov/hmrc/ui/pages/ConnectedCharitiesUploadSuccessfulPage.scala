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

object ConnectedCharitiesUploadSuccessfulPage extends BasePage {

  override def pageUrl: String = s"$hostname/connected-charities-schedule-upload-successful"

  override def pageTitle: String =
    "Upload successful - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "Upload successful"

  def pageParagraph: String =
    "You have successfully attached your Connected Charities schedule."

  def pageParagraphAgent: String =
    "You have successfully attached this Connected Charities schedule."

  def validateNavigation(): Unit = {
    ConnectedCharitiesUploadSuccessfulPage.verifyPageUrl(ConnectedCharitiesUploadSuccessfulPage.pageUrl)
    ConnectedCharitiesUploadSuccessfulPage.verifyPageTitle(ConnectedCharitiesUploadSuccessfulPage.pageTitle)
    ConnectedCharitiesUploadSuccessfulPage.verifyPageHeading(ConnectedCharitiesUploadSuccessfulPage.pageHeading)
  }

  def validatePageParagraph(): Unit =
    ConnectedCharitiesUploadSuccessfulPage.verifyParagraphText(ConnectedCharitiesUploadSuccessfulPage.pageParagraph)

  def validateNavigationAgent(): Unit = {
    ConnectedCharitiesUploadSuccessfulPage.verifyPageUrl(ConnectedCharitiesUploadSuccessfulPage.pageUrl)
    ConnectedCharitiesUploadSuccessfulPage.verifyPageTitle(ConnectedCharitiesUploadSuccessfulPage.pageTitle)
    ConnectedCharitiesUploadSuccessfulPage.verifyPageHeading(ConnectedCharitiesUploadSuccessfulPage.pageHeading)
  }

  def validatePageParagraphAgent(): Unit =
    ConnectedCharitiesUploadSuccessfulPage.verifyParagraphText(
      ConnectedCharitiesUploadSuccessfulPage.pageParagraphAgent
    )
}
