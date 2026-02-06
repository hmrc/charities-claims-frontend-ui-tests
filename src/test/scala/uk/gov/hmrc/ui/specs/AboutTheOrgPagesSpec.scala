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

  Feature("Charities - Organisation - About the Organisation page validations") {
    Scenario(
      "User navigates to the 'About the organisation' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.0")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
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
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
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
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User navigates to 'What is the name of the charity regulator?' page")
      WhatIsTheNameOfTheCharityRegulatorPage.navigateToPage(WhatIsTheNameOfTheCharityRegulatorPage.pageUrl)
      WhatIsTheNameOfTheCharityRegulatorPage.validateNavigation()
      And("User clicks 'Charity is not registered with a regulator' radio button option")
      WhatIsTheNameOfTheCharityRegulatorPage.radioButton(WhatIsTheNameOfTheCharityRegulatorPage.None)
      And("User clicks 'Continue' button")
      WhatIsTheNameOfTheCharityRegulatorPage.clickContinue()
      And("User navigates to 'Why is the charity not registered with a regulator?' page")
      WhyIsTheCharityNotRegisteredPage.validateNavigation()
      Then("User validates the 'no input' error on the 'Why is the charity not registered with a regulator?' page")
      WhyIsTheCharityNotRegisteredPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Your charity is excepted' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.3")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User navigates to 'What is the name of the charity regulator?' page")
      WhatIsTheNameOfTheCharityRegulatorPage.navigateToPage(WhatIsTheNameOfTheCharityRegulatorPage.pageUrl)
      WhatIsTheNameOfTheCharityRegulatorPage.validateNavigation()
      And("User clicks 'Charity is not registered with a regulator' radio button option")
      WhatIsTheNameOfTheCharityRegulatorPage.radioButton(WhatIsTheNameOfTheCharityRegulatorPage.None)
      And("User clicks 'Continue' button")
      WhatIsTheNameOfTheCharityRegulatorPage.clickContinue()
      And("User navigates to 'Why is the charity not registered with a regulator?' page")
      WhyIsTheCharityNotRegisteredPage.validateNavigation()
      And("User clicks 'Charity is not registered with a regulator' radio button option")
      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.Excepted)
      And("User clicks 'Continue' button")
      WhyIsTheCharityNotRegisteredPage.clickContinue()
      And("User navigates to 'Your charity is excepted' page")
      YourCharityIsExceptedPage.validateNavigation()
      Then("User validates the elements on the 'Your charity is excepted' page")
      YourCharityIsExceptedPage.validateParagraph()
    }

    Scenario(
      "User navigates to the 'Your charity is exempt' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.4")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User navigates to 'What is the name of the charity regulator?' page")
      WhatIsTheNameOfTheCharityRegulatorPage.navigateToPage(WhatIsTheNameOfTheCharityRegulatorPage.pageUrl)
      WhatIsTheNameOfTheCharityRegulatorPage.validateNavigation()
      And("User clicks 'Charity is not registered with a regulator' radio button option")
      WhatIsTheNameOfTheCharityRegulatorPage.radioButton(WhatIsTheNameOfTheCharityRegulatorPage.None)
      And("User clicks 'Continue' button")
      WhatIsTheNameOfTheCharityRegulatorPage.clickContinue()
      And("User navigates to 'Why is the charity not registered with a regulator?' page")
      WhyIsTheCharityNotRegisteredPage.validateNavigation()
      And("User clicks 'Charity is not registered with a regulator' radio button option")
      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.Exempt)
      And("User clicks 'Continue' button")
      WhyIsTheCharityNotRegisteredPage.clickContinue()
      And("User navigates to 'Your charity is exempt' page")
      YourCharityIsExemptPage.validateNavigation()
      Then("User validates the elements on the 'Your charity is exempt' page")
      YourCharityIsExemptPage.validateParagraph()
    }

    Scenario(
      "User navigates to the 'What is the charity regulator number?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.5")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User navigates to 'What is the name of the charity regulator?' page")
      WhatIsTheNameOfTheCharityRegulatorPage.navigateToPage(WhatIsTheNameOfTheCharityRegulatorPage.pageUrl)
      WhatIsTheNameOfTheCharityRegulatorPage.validateNavigation()
      And("User clicks 'Charity is not registered with a regulator' radio button option")
      WhatIsTheNameOfTheCharityRegulatorPage.radioButton(WhatIsTheNameOfTheCharityRegulatorPage.EngWal)
      And("User clicks 'Continue' button")
      WhatIsTheNameOfTheCharityRegulatorPage.clickContinue()
      And("User navigates to 'What is the charity regulator number?' page")
      WhatIsYourCharityRegulatorNumberPage.validateNavigation()
      Then("User validates the elements on the 'What is the charity regulator number?' page")
      WhatIsYourCharityRegulatorNumberPage.validateHint()
      Then("User validates the 'no input' error on the 'What is the charity regulator number?' page")
      WhatIsYourCharityRegulatorNumberPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'Is a corporate trustee making this claim?' page and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.6")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User navigates to 'Is a corporate trustee making this claim?' page")
      IsACorporateTrusteeMakingThisClaimPage.navigateToPage(IsACorporateTrusteeMakingThisClaimPage.pageUrl)
      IsACorporateTrusteeMakingThisClaimPage.validateNavigation()
      Then("User validates the 'no input' error on the 'Is a corporate trustee making this claim?' page")
      IsACorporateTrusteeMakingThisClaimPage.validateErrorMessage()
    }

    Scenario(
      "User navigates to the 'corporate trustee' pages and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.7 A2.9")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User navigates to 'Is a corporate trustee making this claim?' page")
      IsACorporateTrusteeMakingThisClaimPage.navigateToPage(IsACorporateTrusteeMakingThisClaimPage.pageUrl)
      IsACorporateTrusteeMakingThisClaimPage.validateNavigation()
      And("User selects a corporate trustee is making this claim")
      IsACorporateTrusteeMakingThisClaimPage.radioButton(IsACorporateTrusteeMakingThisClaimPage.yes)
      IsACorporateTrusteeMakingThisClaimPage.clickContinue()
      And("User navigates to 'Does the corporate trustee have a UK address?' page")
      DoesTheCorporateTrusteeHaveAUKAddressPage.validateNavigation()
      Then("User validates the 'no input' error on the 'Does the corporate trustee have a UK address?' page")
      DoesTheCorporateTrusteeHaveAUKAddressPage.validateErrorMessage()
      And("User selects a corporate trustee does have a UK address")
      DoesTheCorporateTrusteeHaveAUKAddressPage.radioButton(DoesTheCorporateTrusteeHaveAUKAddressPage.yes)
      DoesTheCorporateTrusteeHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateNavigation()
      Then("User validates the 'no input' error on the UK address 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateUKAddressErrorMessages()
      Then("User validates the name errors on the 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateCorporateTrusteeNameErrorMessages()
      Then("User validates the phone number errors on the 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateCorporateTrusteePhoneErrorMessages()
      Then("User validates the postcode errors on the 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateCorporateTrusteePostcodeErrorMessages()
      And("User navigates back to the 'Does the corporate trustee have a UK address?' page")
      DoesTheCorporateTrusteeHaveAUKAddressPage.navigateToPage(DoesTheCorporateTrusteeHaveAUKAddressPage.pageUrl)
      And("User navigates to 'Does the corporate trustee have a UK address?' page")
      DoesTheCorporateTrusteeHaveAUKAddressPage.validateNavigation()
      And("User selects a corporate trustee does NOT have a UK address")
      DoesTheCorporateTrusteeHaveAUKAddressPage.radioButton(DoesTheCorporateTrusteeHaveAUKAddressPage.no)
      DoesTheCorporateTrusteeHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateNavigation()
      Then("User validates the 'no input' error on the Non-UK address 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateNonUKAddressErrorMessages()
    }

    Scenario(
      "User navigates to the 'authorised official' pages and validates the page elements and error messages"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.8 A2.10")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User navigates to 'Is a corporate trustee making this claim?' page")
      IsACorporateTrusteeMakingThisClaimPage.navigateToPage(IsACorporateTrusteeMakingThisClaimPage.pageUrl)
      IsACorporateTrusteeMakingThisClaimPage.validateNavigation()
      And("User selects a corporate trustee is making this claim")
      IsACorporateTrusteeMakingThisClaimPage.radioButton(IsACorporateTrusteeMakingThisClaimPage.no)
      IsACorporateTrusteeMakingThisClaimPage.clickContinue()
      And("User navigates to 'Does the authorised official have a UK address?' page")
      DoesTheAuthorisedOfficialHaveAUKAddressPage.validateNavigation()
      Then("User validates the 'no input' error on the 'Does the authorised official have a UK address?' page")
      DoesTheAuthorisedOfficialHaveAUKAddressPage.validateErrorMessage()
      And("User selects a authorised official does have a UK address")
      DoesTheAuthorisedOfficialHaveAUKAddressPage.radioButton(DoesTheAuthorisedOfficialHaveAUKAddressPage.yes)
      DoesTheAuthorisedOfficialHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What are the authorised official details?' page")
      AuthorisedOfficialDetailsPage.validateNavigation()
      Then("User validates the 'no input' error on the UK address 'What are the authorised official details?' page")
      AuthorisedOfficialDetailsPage.validateUKAddressErrorMessages()
      Then("User validates the title errors on the 'What are the authorised official details?' page")
      AuthorisedOfficialDetailsPage.validateAuthOfficialTitleErrorMessages()
      Then("User validates the First Name errors on the 'What are the authorised official details?' page")
      AuthorisedOfficialDetailsPage.validateAuthOfficialForenameErrorMessages()
      Then("User validates the Last Name errors on the 'What are the authorised official details?' page")
      AuthorisedOfficialDetailsPage.validateAuthOfficialSurnameErrorMessages()
      Then("User validates the Phone Number errors on the 'What are the authorised official details?' page")
      AuthorisedOfficialDetailsPage.validateAuthOfficialPhoneNoErrorMessages()
      Then("User validates the Postcode errors on the 'What are the authorised official details?' page")
      AuthorisedOfficialDetailsPage.validateAuthOfficialPostcodeErrorMessages()
      And("User navigates back to the 'Does the authorised official have a UK address?' page")
      DoesTheAuthorisedOfficialHaveAUKAddressPage.navigateToPage(DoesTheAuthorisedOfficialHaveAUKAddressPage.pageUrl)
      And("User navigates to 'Does the authorised official have a UK address?' page")
      DoesTheAuthorisedOfficialHaveAUKAddressPage.validateNavigation()
      And("User selects a authorised official does NOT have a UK address")
      DoesTheAuthorisedOfficialHaveAUKAddressPage.radioButton(DoesTheAuthorisedOfficialHaveAUKAddressPage.no)
      DoesTheAuthorisedOfficialHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What are the authorised official details?' page")
      AuthorisedOfficialDetailsPage.validateNavigation()
      Then("User validates the 'no input' error on the Non-UK address 'What are the authorised official details?' page")
      AuthorisedOfficialDetailsPage.validateNonUKAddressErrorMessages()
    }

    Scenario(
      "User navigates to the 'Check your organisation details' page and validates the page elements"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - A2.11")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage.validateNavigation()
      And("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.navigateToPage(CheckYourOrganisationDetailsPage.pageUrl)
      CheckYourOrganisationDetailsPage.validateNavigation()
    }
  }
}
