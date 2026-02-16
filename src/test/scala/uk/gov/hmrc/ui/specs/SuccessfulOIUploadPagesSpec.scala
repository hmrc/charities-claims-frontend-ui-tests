package uk.gov.hmrc.ui.specs

import org.scalatest.{BeforeAndAfterAll, BeforeAndAfterEach, GivenWhenThen}
import org.scalatest.featurespec.AnyFeatureSpec
import org.scalatest.verbs.ShouldVerb
import uk.gov.hmrc.selenium.webdriver.{Browser, ScreenshotOnFailure}
import uk.gov.hmrc.ui.pages.{AuthWizard, SuccessfulOIUpload}
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

class SuccessfulOIUploadPagesSpec
  extends AnyFeatureSpec
    with BaseSpec
    with GivenWhenThen
    with ShouldVerb
    with BeforeAndAfterAll
    with BeforeAndAfterEach
    with Browser
    with ScreenshotOnFailure {
  Feature("Charities - Organisation - Other Income Successful Upload") {
    Scenario("User navigates to the 'Other Income Successful Upload Page - Meeting Data Guard'") {
      Given("the user logs in through the Authority Wizard page")
      AuthWizard.login(HASDIRECT, Organisation, "Organisation", "HMRC-CHAR-ORG", "CHARID", "PAGETEST - O1.5")
      //Finish
      Then("we go to the page")
      SuccessfulOIUpload.goToPage()
      Then("we validate the page content")
      SuccessfulOIUpload.validateNavigation()
      SuccessfulOIUpload.validatePageContent()
    }
  }

}
