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
import uk.gov.hmrc.ui.pages.AuthWizard.{click, sendKeys}
import uk.gov.hmrc.ui.util.Env
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation
import uk.gov.hmrc.ui.util.Users.{LoginTypes, UserTypes}

object AuthWizard extends BasePage {

  override def pageUrl: String = s"${Env.baseUrl}/auth-login-stub/gg-sign-in"

  override def pageTitle: String = "auth login stub"

  val url: String = s"${Env.baseUrl}"

  val redirectUrl: By     = By.id("redirectionUrl")
  val affinityGroup: By   = By.id("affinityGroupSelect")
  val confidenceLevel: By = By.id("confidenceLevel")
  val nino: By            = By.id("nino")
  val enrolmentKey: By    = By.id(s"enrolment[0].name") // Enrolment Key
  val enrolmentId: By     = By.name(s"enrolment[0].taxIdentifier[0].name") // Identifier Name
  val enrolmentValue: By  = By.name(s"enrolment[0].taxIdentifier[0].value") // Identifier Value
  val enrolmentId2: By    = By.name(s"enrolment[0].taxIdentifier[1].name")
  val enrolmentValue2: By = By.name(s"enrolment[0].taxIdentifier[1].value")
  val oAuthIdToken: By    = By.id("idToken")
  val addPreset: By       = By.id("add-ident-btn-0")
  val credId: By          = By.id("authorityId")
  val saPreset: By        = By.id("presets-dropdown")
  val btnSubmit: By       = By.id("submit")
  val btnAddEnrolment: By = By.id("add-ident-btn-0")

  def buildRedirectUrl(loginType: LoginTypes, userType: UserTypes): String = {
    val Redirect =
      if (
        Env.baseUrl.equals(
          "http://localhost:9949/auth-login-stub/gg-sign-in?continue=http://localhost:10911/stamp-duty-land-tax-agent"
        )
      ) "http://localhost:10911/stamp-duty-land-tax-agent"
      else s"/stamp-duty-land-tax-agent"
    Redirect
  }

  def fillInputs(enrolmentVal: String): this.type = {
    driver.findElement(affinityGroup).sendKeys("Organisation")
    driver.findElement(enrolmentKey).sendKeys("IR-SDLT-ORG")
    driver.findElement(enrolmentId).sendKeys("STORN")
    driver.findElement(enrolmentValue).sendKeys(enrolmentVal)
    this
  }

  def login(loginType: LoginTypes, userType: UserTypes, enrolmentVal: String): Unit = {
    AuthWizard.navigateToPage(url)
    sendKeys(redirectUrl, buildRedirectUrl(HASDIRECT, Organisation))
    fillInputs(enrolmentVal)
    click(btnSubmit)
  }

}
