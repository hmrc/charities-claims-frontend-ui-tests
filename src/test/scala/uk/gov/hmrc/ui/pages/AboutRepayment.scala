package uk.gov.hmrc.ui.pages

object AboutRepayment extends BasePage{

  override def pageUrl: String = s"$hostname/repayment-claim-details"

  override def pageTitle : String =
    "Repayment claim details - Charities - GOV.UK"

  def pageHeader : String =
    "Repayment claim details"

  def pageCaption : String =
    "provide repayment claim details"

  def pageParagraph : String =
    "Use this service to claim:"

  def listItem1 : String =
    "tax repayment on Gift Aid donations"

  def listItem2 : String =
    "top-up payments under the Gift Aid Small Donations Scheme"

  def listItem3 : String =
    "UK tax deducted from other income"


  def validateNavigation() : Unit = {
    AboutRepayment.verifyPageUrl(AboutRepayment.pageUrl)
    AboutRepayment.verifyPageTitle(AboutRepayment.pageTitle)
    AboutRepayment.verifyPageHeader(AboutRepayment.pageHeader)
    AboutRepayment.verifyPageCaption(AboutRepayment.pageCaption)
  }

  def validateParagraph(): Unit = {
    AboutRepayment.verifyParagraphText(
      AboutRepayment.pageParagraph
    )
    AboutRepayment.verifyListText(
      AboutRepayment.createSingleStringFromMany(
        AboutRepayment.listItem1,
        AboutRepayment.listItem2,
        AboutRepayment.listItem3
      )
    )
  }

}
