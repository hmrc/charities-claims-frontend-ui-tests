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

package uk.gov.hmrc.ui.specs

import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.verbs.ShouldVerb
import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.ui.pages.*
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

class AboutTheOrgPagesSpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation - Gift Aid Page Validations") {
    Scenario(
      "User navigates to the 'About the organisation' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.0")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage.validateNavigation()
      And("User navigates to 'About the organisation' page")
      AboutTheOrganisationPage.navigateToPage(AboutTheOrganisationPage.pageUrl)
      AboutTheOrganisationPage.validateNavigation()
      Then("User validates the elements on the 'About the organisation' page")
      AboutTheOrganisationPage.validatePageContent()
    }

    Scenario(
      "User navigates to the 'What is the name of the charity regulator?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.1")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage.validateNavigation()
      And("User navigates to 'What is the name of the charity regulator?' page")
      WhatIsTheNameOfTheCharityRegulatorPage.navigateToPage(WhatIsTheNameOfTheCharityRegulatorPage.pageUrl)
      WhatIsTheNameOfTheCharityRegulatorPage.validateNavigation()
      Then("User validates the 'no input' error on the 'What is the name of the charity regulator?' page")
      WhatIsTheNameOfTheCharityRegulatorPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Why is the charity not registered with a regulator?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.2")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage.validateNavigation()
      And("User navigates to 'Why is the charity not registered with a regulator?' page")
      WhyIsTheCharityNotRegisteredPage.navigateToPage(WhyIsTheCharityNotRegisteredPage.pageUrl)
      WhyIsTheCharityNotRegisteredPage.validateNavigation()
      Then("User validates the 'no input' error on the 'Why is the charity not registered with a regulator?' page")
      WhyIsTheCharityNotRegisteredPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Your charity is excepted' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.3")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage.validateNavigation()
      And("User navigates to 'Your charity is excepted' page")
      YourCharityIsExceptedPage.navigateToPage(YourCharityIsExceptedPage.pageUrl)
      YourCharityIsExceptedPage.validateNavigation()
      Then("User validates the elements on the 'Your charity is excepted' page")
      YourCharityIsExceptedPage.validateParagraph()
    }

    Scenario(
      "User navigates to the 'Your charity is exempt' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.4")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage.validateNavigation()
      And("User navigates to 'Your charity is exempt' page")
      YourCharityIsExemptPage.navigateToPage(YourCharityIsExemptPage.pageUrl)
      YourCharityIsExemptPage.validateNavigation()
      Then("User validates the elements on the 'Your charity is exempt' page")
      YourCharityIsExemptPage.validateParagraph()
    }

//    Scenario(
//      "User navigates to the 'What is the charity regulator number?' page and validates the page elements and error messages"
//    ) {
//      Given("the user logs in through the Authority Wizard page")
//      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.5")
//      Then("User navigates to 'Are you claiming Gift Aid?' page")
//      AreYouClaimingGiftAidPage.validateNavigation()
//      And("User navigates to 'What is the charity regulator number?' page")
//      WhatIsYourCharityRegulatorNumberPage.navigateToPage(WhatIsYourCharityRegulatorNumberPage.pageUrl)
//      WhatIsYourCharityRegulatorNumberPage.validateNavigation()
//      Then("User validates the elements on the 'What is the charity regulator number?' page")
//      WhatIsYourCharityRegulatorNumberPage.validateHint()
//    }
//
//    Scenario(
//      "User navigates to the 'Is a corporate trustee making this claim?' page and validates the page elements and error messages"
//    ) {
//      Given("the user logs in through the Authority Wizard page")
//      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.6")
//      Then("User navigates to 'Are you claiming Gift Aid?' page")
//      AreYouClaimingGiftAidPage.validateNavigation()
//      And("User navigates to 'Is a corporate trustee making this claim?' page")
//      CorporateTrusteePage.navigateToPage(CorporateTrusteePage.pageUrl)
//      CorporateTrusteePage.validateNavigation()
//      Then("User validates the 'no input' error on the 'Is a corporate trustee making this claim?' page")
//      CorporateTrusteePage.validateErrorMessage()
//    }
  }
}
