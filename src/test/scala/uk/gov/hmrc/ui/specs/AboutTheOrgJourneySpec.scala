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
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "JOURNEYTEST - A1")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigation()
      And("User selects 'Top up payments for donations under the GASDS' checkbox and clicks continue")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GiftAid, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation()
      And("User clicks the link to navigate to 'About the organisation' page")
      ClaimsTaskListPage_InProgress.clickProvideOrganisationDetails()
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
      IsACorporateTrusteeMakingThisClaimPage.validateNavigation()
      And("User selects a corporate trustee is making this claim")
      IsACorporateTrusteeMakingThisClaimPage.radioButton(IsACorporateTrusteeMakingThisClaimPage.yes)
      IsACorporateTrusteeMakingThisClaimPage.clickContinue()
      And("User navigates to 'Does the corporate trustee have a UK address?' page")
      DoesTheCorporateTrusteeHaveAUKAddressPage.validateNavigation()
      And("User selects a corporate trustee does not have a UK address")
      DoesTheCorporateTrusteeHaveAUKAddressPage.radioButton(DoesTheCorporateTrusteeHaveAUKAddressPage.no)
      DoesTheCorporateTrusteeHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateNavigation()
      And("User enters their Non UK Trustee details and clicks continue")
      CorporateTrusteeDetailsPage.enterNonUKTrusteeDetails("TEST TRUSTEE", "00-1-332-555-2368")
      And("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.validateNavigation()
    }

    Scenario(
      "User navigates to the 'About the organisation', selects not registered radio button option, exempt and authorised official with UK address"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "JOURNEYTEST - A2")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigation()
      And("User selects 'Top up payments for donations under the GASDS' checkbox and clicks continue")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GiftAid, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation()
      And("User clicks the link to navigate to 'About the organisation' page")
      ClaimsTaskListPage_InProgress.clickProvideOrganisationDetails()
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
      And("User selects they are exempt")
      WhyIsTheCharityNotRegisteredPage.radioButton(WhyIsTheCharityNotRegisteredPage.Exempt)
      WhyIsTheCharityNotRegisteredPage.clickContinue()
      And("User navigates to 'Your charity is exempt' page")
      YourCharityIsExemptPage.validateNavigation()
      Then("User selects continue on 'Your charity is exempt' page")
      YourCharityIsExemptPage.clickContinue()
      And("User navigates to 'Is a corporate trustee making this claim?' page")
      IsACorporateTrusteeMakingThisClaimPage.validateNavigation()
      And("User selects a corporate trustee is not making this claim")
      IsACorporateTrusteeMakingThisClaimPage.radioButton(IsACorporateTrusteeMakingThisClaimPage.no)
      IsACorporateTrusteeMakingThisClaimPage.clickContinue()
      And("User navigates to 'Does the authorised official have a UK address?' page")
      DoesTheAuthorisedOfficialHaveAUKAddressPage.validateNavigation()
      And("User selects a authorised official does have a UK address")
      DoesTheAuthorisedOfficialHaveAUKAddressPage.radioButton(DoesTheAuthorisedOfficialHaveAUKAddressPage.yes)
      DoesTheAuthorisedOfficialHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What are the authorised official details?' page")
      AuthorisedOfficialDetailsPage.validateNavigation()
      And("User enters their UK Authorised Official details and clicks continue")
      AuthorisedOfficialDetailsPage.enterUKAuthOfficialDetails(
        "TEST",
        "TESTFORENAME",
        "TESTSURNAME",
        "01632 960999",
        "WG7 7FU"
      )
      And("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.validateNavigation()
    }

    Scenario(
      "User navigates to the 'About the organisation', selects registered with England and Wales regulator radio button option and corporate trustee with UK address"
    ) {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "JOURNEYTEST - A3")
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_Empty.validateNavigation()
      And("User clicks the link to navigate to 'Repayment claim details' page")
      ClaimsTaskListPage_Empty.clickProvideRepaymentClaimDetails()
      Then("User validates the 'Repayment claim details' page")
      RepaymentClaimDetailsPage.validateNavigation()
      And("User clicks continue on 'Repayment claim details' page")
      RepaymentClaimDetailsPage.clickContinue()
      Then("User navigates to 'Which type of repayment claim do you want to make?' page")
      RepaymentCheckboxPage.validateNavigation()
      And("User selects 'Top up payments for donations under the GASDS' checkbox and clicks continue")
      RepaymentCheckboxPage.checkbox(RepaymentCheckboxPage.GiftAid, true)
      RepaymentCheckboxPage.clickContinue()
      Then("User navigates to 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.validateNavigation()
      And("User selects 'No' and clicks continue on 'Do you have a claim reference number?' page")
      DoYouHaveAClaimReferenceNumberPage.radioButton(DoYouHaveAClaimReferenceNumberPage.no)
      DoYouHaveAClaimReferenceNumberPage.clickContinue()
      Then("User navigates to 'Check your repayment claim' page")
      CheckYourRepaymentClaimPage.validateNavigation()
      CheckYourRepaymentClaimPage.clickContinue()
      Then("User navigates to 'Make a charity repayment claim' page")
      ClaimsTaskListPage_InProgress.validateNavigation()
      And("User clicks the link to navigate to 'About the organisation' page")
      ClaimsTaskListPage_InProgress.clickProvideOrganisationDetails()
      AboutTheOrganisationPage.validateNavigation()
      Then("User selects continue on 'About the organisation' page")
      AboutTheOrganisationPage.clickContinue()
      And("User navigates to 'What is the name of the charity regulator?' page")
      WhatIsTheNameOfTheCharityRegulatorPage.validateNavigation()
      And("User selects they are registered with the England and Wales regulator")
      WhatIsTheNameOfTheCharityRegulatorPage.radioButton(WhatIsTheNameOfTheCharityRegulatorPage.EngWal)
      WhatIsTheNameOfTheCharityRegulatorPage.clickContinue()
      And("User navigates to 'What is the charity regulator number?' page")
      WhatIsYourCharityRegulatorNumberPage.validateNavigation()
      And("User enters their charity regulator number and clicks continue")
      WhatIsYourCharityRegulatorNumberPage.enterCharityRegulatorNumber("1234567890")
      And("User navigates to 'Is a corporate trustee making this claim?' page")
      IsACorporateTrusteeMakingThisClaimPage.validateNavigation()
      And("User selects a corporate trustee is making this claim")
      IsACorporateTrusteeMakingThisClaimPage.radioButton(IsACorporateTrusteeMakingThisClaimPage.yes)
      IsACorporateTrusteeMakingThisClaimPage.clickContinue()
      And("User navigates to 'Does the corporate trustee have a UK address?' page")
      DoesTheCorporateTrusteeHaveAUKAddressPage.validateNavigation()
      And("User selects a corporate trustee does not have a UK address")
      DoesTheCorporateTrusteeHaveAUKAddressPage.radioButton(DoesTheCorporateTrusteeHaveAUKAddressPage.yes)
      DoesTheCorporateTrusteeHaveAUKAddressPage.clickContinue()
      And("User navigates to 'What are the corporate trustee details?' page")
      CorporateTrusteeDetailsPage.validateNavigation()
      And("User enters their Non UK Trustee details and clicks continue")
      CorporateTrusteeDetailsPage.enterUKTrusteeDetails("TEST TRUSTEE", "01632 960999", "WG7 7FU")
      And("User navigates to 'Check your organisation details' page")
      CheckYourOrganisationDetailsPage.validateNavigation()
    }
  }
}
