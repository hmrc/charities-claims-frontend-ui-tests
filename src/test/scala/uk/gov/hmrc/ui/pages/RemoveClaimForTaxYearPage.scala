package uk.gov.hmrc.ui.pages

import org.openqa.selenium.By

object RemoveClaimForTaxYearPage extends BasePage{

  override def pageUrl : String = s"$hostname/remove-claim-for-tax-year"

  override def pageTitle : String =
    "Do you want to remove the claim for tax year"

  def pageHeading : String =
    "Do you want to remove the claim for the tax year"

  def pageErrorMsg : String =
    "Select ‘Yes’ if you want to remove the claim for tax year"

  val yes: String = "#value"
  val no: String = "#value-no"
  val errorMsgLocator = By.ById("value-error")

  def validateNavigation1(): Unit = {
    RemoveClaimForTaxYearPage.verifyPageUrl(RemoveClaimForTaxYearPage.pageUrl+"/1")
    RemoveClaimForTaxYearPage.verifyPageTitle(RemoveClaimForTaxYearPage.pageTitle + "1? - Make a charity tax repayment claim - GOV.UK")
    RemoveClaimForTaxYearPage.verifyPageHeading(RemoveClaimForTaxYearPage.pageHeading + " 1?")
  }

  def validateNavigation2(): Unit = {
    RemoveClaimForTaxYearPage.verifyPageUrl(RemoveClaimForTaxYearPage.pageUrl + "/2")
    RemoveClaimForTaxYearPage.verifyPageTitle(RemoveClaimForTaxYearPage.pageTitle + "2? - Make a charity tax repayment claim - GOV.UK")
    RemoveClaimForTaxYearPage.verifyPageHeading(RemoveClaimForTaxYearPage.pageHeading + " 2?")
  }

  def validateNavigation3(): Unit = {
    RemoveClaimForTaxYearPage.verifyPageUrl(RemoveClaimForTaxYearPage.pageUrl + "/3")
    RemoveClaimForTaxYearPage.verifyPageTitle(RemoveClaimForTaxYearPage.pageTitle + "3? - Make a charity tax repayment claim - GOV.UK")
    RemoveClaimForTaxYearPage.verifyPageHeading(RemoveClaimForTaxYearPage.pageHeading + " 3?")
  }

  def validateErrorMessage(): Unit =
    RemoveClaimForTaxYearPage.validateGenericPageError(
      RemoveClaimForTaxYearPage.pageErrorMsg,
      RemoveClaimForTaxYearPage.errorMsgLocator
    )

}
