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

object WhyIsTheCharityNotRegisteredPage extends BasePage {

  /** Everything is taken from and follows the confluence page and the prototype*/

  override def pageUrl: String = s"$hostname/charity-not-registered"

  override def pageTitle: String = "Why is the charity not registered with a regulator? - Charities - GOV.UK"

  def pageCaption: String = "Provide organisation details"

  def pageHeader: String ="Why is the charity not registered with a regulator?"

  def pageError: String = "Select why the charity is not registered with a regulator"


  val EngWal : String = "#whyNoCharityReg"
  val Exempt : String = "#whyNoCharityReg-2"
  val Excepted : String = "#whyNoCharityReg-3"
  val NorIrl : String = "#whyNoCharityReg-4"

  /** Name for values picked as we want to know why there is no charity regulator and is based on the options */


  def validateNavigation(): Unit = {
    WhyIsTheCharityNotRegisteredPage.verifyPageUrl(WhyIsTheCharityNotRegisteredPage.pageUrl)
    WhyIsTheCharityNotRegisteredPage.verifyPageTitle(WhyIsTheCharityNotRegisteredPage.pageTitle)
    WhyIsTheCharityNotRegisteredPage.verifyPageHeader(WhyIsTheCharityNotRegisteredPage.pageHeader)
    WhyIsTheCharityNotRegisteredPage.verifyPageCaption(WhyIsTheCharityNotRegisteredPage.pageCaption) 

  } /** We want to validate the navigation features of the page and ensure they follow confluence */

  def validateError(): Unit =
    WhyIsTheCharityNotRegisteredPage.validateGenericPageError(WhyIsTheCharityNotRegisteredPage.pageError)

  /** We want to validate that the error message is correct and follows confluence page*/
}