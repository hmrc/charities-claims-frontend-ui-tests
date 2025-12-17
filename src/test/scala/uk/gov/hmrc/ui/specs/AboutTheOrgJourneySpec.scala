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

class AboutTheOrgJourneySpec
    extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {

  Feature("Charities - Organisation - About the Organisation journeys") {
    Scenario(
      "User navigates to the 'About the organisation', selects not registered radio button option, excepted and corporate trustee without UK address"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.0")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage.validateNavigation()
      And("User navigates to 'About the organisation' page")
      AboutTheOrganisationPage.navigateToPage(AboutTheOrganisationPage.pageUrl)
      AboutTheOrganisationPage.validateNavigation()
      Then("User selects continue on 'About the organisation' page")
      AboutTheOrganisationPage.clickContinue()
      And("User navigates to 'What is the name of the charity regulator?' page")
      WhatIsTheNameOfTheCharityRegulatorPage.validateNavigation()
      And("User selects they are not registered with a regulator")
      WhatIsTheNameOfTheCharityRegulatorPage.radioButton(WhatIsTheNameOfTheCharityRegulatorPage.None)
      WhatIsTheNameOfTheCharityRegulatorPage.clickContinue()
      And("User navigates to 'Why is the charity not registered with a regulator?' page")
      WhyIsTheCharityNotRegisteredPage.validateNavigation()
      And("User selects they are excepted")
      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.Excepted)
      WhyIsTheCharityNotRegisteredPage.clickContinue()
      And("User navigates to 'Your charity is excepted' page")
      YourCharityIsExceptedPage.validateNavigation()
      Then("User selects continue on 'Your charity is excepted' page")
      YourCharityIsExceptedPage.clickContinue()
      And("User navigates to 'Is a corporate trustee making this claim?' page")
      CorporateTrusteePage.validateNavigation()
      And("User selects a corporate trustee is making this claim")
      CorporateTrusteePage.radioButton(CorporateTrusteePage.yes)
      CorporateTrusteePage.clickContinue()
      And("User navigates to 'Does the corporate trustee have a UK address?' page")
      CorporateTrusteeAddressPage.validateNavigation()
      And("User selects a corporate trustee does not have a UK address")
      CorporateTrusteeAddressPage.radioButton(CorporateTrusteeAddressPage.no)
      CorporateTrusteeAddressPage.clickContinue()
      //MORE TO DO
    }

    Scenario(
      "User navigates to the 'About the organisation', selects not registered radio button option, exempt and authorised official with UK address"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.0")
      Then("User navigates to 'Are you claiming Gift Aid?' page")
      AreYouClaimingGiftAidPage.validateNavigation()
      And("User navigates to 'About the organisation' page")
      AboutTheOrganisationPage.navigateToPage(AboutTheOrganisationPage.pageUrl)
      AboutTheOrganisationPage.validateNavigation()
      Then("User selects continue on 'About the organisation' page")
      AboutTheOrganisationPage.clickContinue()
      And("User navigates to 'What is the name of the charity regulator?' page")
      WhatIsTheNameOfTheCharityRegulatorPage.validateNavigation()
      And("User selects they are not registered with a regulator")
      WhatIsTheNameOfTheCharityRegulatorPage.radioButton(WhatIsTheNameOfTheCharityRegulatorPage.None)
      WhatIsTheNameOfTheCharityRegulatorPage.clickContinue()
      And("User navigates to 'Why is the charity not registered with a regulator?' page")
      WhyIsTheCharityNotRegisteredPage.validateNavigation()
      And("User selects they are excepted")
      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.Exempt)
      WhyIsTheCharityNotRegisteredPage.clickContinue()
      And("User navigates to 'Your charity is exempt' page")
      YourCharityIsExemptPage.validateNavigation()
      Then("User selects continue on 'Your charity is exempt' page")
      YourCharityIsExemptPage.clickContinue()
      And("User navigates to 'Is a corporate trustee making this claim?' page")
      CorporateTrusteePage.validateNavigation()
      And("User selects a corporate trustee is not making this claim")
      CorporateTrusteePage.radioButton(CorporateTrusteePage.no)
      CorporateTrusteePage.clickContinue()
      And("User navigates to 'Does the authorised official have a UK address?' page")
      AuthorisedOfficialAddressPage.validateNavigation()
      And("User selects a authorised official does have a UK address")
      AuthorisedOfficialAddressPage.radioButton(AuthorisedOfficialAddressPage.yes)
      AuthorisedOfficialAddressPage.clickContinue()
      //MORE TO DO
    }
  }
}
