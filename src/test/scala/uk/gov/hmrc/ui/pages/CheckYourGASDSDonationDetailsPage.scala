package uk.gov.hmrc.ui.pages

object CheckYourGASDSDonationDetailsPage extends BasePage {

  override def pageUrl: String = s"$hostname/check-your-gift-aid-small-donations-scheme-donation-details"

  override def pageTitle: String =
    "Check your GASDS donation details - Make a charity tax repayment claim - GOV.UK"

  def pageHeading: String =
    "Check your GASDS donation details"

  def pageCaption: String =
    "GASDS claim adjustment"

  def validateNavigation(): Unit = {
    CheckYourGASDSDonationDetailsPage.verifyPageUrl(CheckYourGASDSDonationDetailsPage.pageUrl)
    CheckYourGASDSDonationDetailsPage.verifyPageTitle(CheckYourGASDSDonationDetailsPage.pageTitle)
    CheckYourGASDSDonationDetailsPage.verifyPageCaption(CheckYourGASDSDonationDetailsPage.pageCaption)
    CheckYourGASDSDonationDetailsPage.verifyPageHeading(CheckYourGASDSDonationDetailsPage.pageHeading)
  }

}