package uk.gov.hmrc.ui.pages

object AboutOtherIncomeSchedule extends BasePage {
  override def pageUrl: String = s"$hostname/about-other-income-schedule"

  override def pageTitle: String = "About Other Income schedule - Charities - GOV.UK"

  def pageHeading: String = "About Other Income schedule"

  def pageCaption: String = "Add Other Income schedule"

  def listText1: String = "Use this service to add an Other Income schedule."

  def listText2: String = "You can upload an Other Income schedule in a .ods format."

  def listText3: String =
    "You can download a Other Income schedule here (opens in a new tab). You can submit 1 file at a time, and each file can be up to 2.5MB."

  /** URL to the page that opens in new tab */
  def newPageUrl: String = "https://www.gov.uk/guidance/schedule-spreadsheet-to-reclaim-tax-on-interest-and-other-income"

  def validateNavigation(): Unit = {
    AboutOtherIncomeSchedule.verifyPageUrl(AboutOtherIncomeSchedule.pageUrl)
    AboutOtherIncomeSchedule.verifyPageTitle(AboutOtherIncomeSchedule.pageTitle)
  }

  def validatePageContent(): Unit = {
    AboutOtherIncomeSchedule.verifyEntirePageContent(
      AboutTheOrganisationPage.createSingleStringFromMany(
        AboutOtherIncomeSchedule.pageCaption,
        AboutOtherIncomeSchedule.pageHeading,
        AboutOtherIncomeSchedule.listText1,
        AboutOtherIncomeSchedule.listText2,
        AboutOtherIncomeSchedule.listText3
      )
    )
  }

  def validateDataGuardProtection(): Unit = {
    navigateToPage(pageUrl)
    Error_PageNotFoundPage.validateNavigation()
    Error_PageNotFoundPage.validatePageContent()
  }

  def completeMinimumDataGuard(): Unit = {
    navigateToPage(ClaimsTaskListPage.pageUrl)
    verifyPageUrl(ClaimsTaskListPage.pageUrl)
    ClaimsTaskListPage.clickProvideRepaymentClaimDetails()
    verifyPageUrl(RepaymentClaimDetailsPage.pageUrl)
    clickContinue()
    verifyPageUrl(RepaymentCheckboxPage.pageUrl)
    checkbox(RepaymentCheckboxPage.OtherIncome, true)
    clickContinue()
  }

  def dataGuardCompleteGoToAboutOtherIncomeSchedule(): Unit = {
    navigateToPage(AboutOtherIncomeSchedule.pageUrl)
  }
}
