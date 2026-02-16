package uk.gov.hmrc.ui.pages

object SuccessfulOIUpload extends BasePage {
  override def pageUrl: String = s"$hostname/other-income-schedule-upload-successful"

  override def pageTitle: String = "Upload successful - Charities - GOV.UK"

  def pageHeading: String = "Upload successful"

  def listText: String = "You have successfully attached your Other Income schedule."

  def validateNavigation(): Unit = {
    SuccessfulOIUpload.verifyPageUrl(SuccessfulOIUpload.pageUrl)
    SuccessfulOIUpload.verifyPageTitle(SuccessfulOIUpload.pageTitle)
  }

  def validatePageContent(): Unit = {
    SuccessfulOIUpload.verifyParagraphText(SuccessfulOIUpload.listText)
  }

  def goToPage(): Unit = {
    navigateToPage(SuccessfulOIUpload.pageUrl)
    verifyPageUrl(SuccessfulOIUpload.pageUrl)
  }
}
