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

package uk.gov.hmrc.ui.pages

import com.typesafe.scalalogging.LazyLogging
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait, WebDriverWait}
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.scalatest.concurrent.Eventually
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.{should, shouldBe}
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.driver.BrowserDriver

import java.nio.file.Paths
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

import java.time.Duration
import scala.util.Random

import scala.jdk.CollectionConverters._

trait BasePage extends PageObject with Eventually with Matchers with LazyLogging with BrowserDriver {

  /** Implicit wait */
  implicit def w: WebDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30))

  logger.info(
    s"Instantiating Browser: ${sys.props.getOrElse("browser", "'browser' System property not set. This is required")}"
  )

  /** Locator values */
  object Locators {
    val btnContinue                    = "//button[@type='submit']"
    val lnkBack                        = "Back"
    val lnkHeader                      = ".govuk-header__link.govuk-header__service-name"
    val lnkDeleteSchedule              = "//a[contains(text(), 'Delete schedule')]"
    val lnkSignOut                     = "//a[contains(text(), 'Sign out')]"
    val buttonSignIn                   = "//button[@type='submit' and normalize-space(text())='Sign in']"
    val rdoYes                         = "#value_0"
    val rdoNo                          = "#value_1"
    val txtFileName                    = ".govuk-body"
    val txtCaption                     = By.ByClassName("govuk-caption-l")
    val txtHeading: By                 = By.xpath("//h1")
    val txtWarning                     = By.ByClassName("govuk-warning-text")
    val txtSubHeading1: By             = By.xpath("//main//h2[1]")
    val txtSubHeading2: By             = By.xpath("//main//h2[2]")
    val txtSubHeading3: By             = By.xpath("//main//h2[3]")
    val txtAddressPostCode             = By.ById("addressPostcode")
    val inputReferenceNumber           = By.ByClassName("govuk-input")
    val inputYourUserId: By            = By.xpath("//input[@name='authorityId']")
    val hintText                       = By.ById("value-hint")
    val paragraphText                  = By.ByClassName("govuk-body")
    val errorSummary                   = By.ByClassName("govuk-error-summary__body")
    val errorMsg                       = By.ByClassName("govuk-error-message")
    val listText                       = By.ByClassName("govuk-list")
    val taskList1Text: By              = By.xpath("//main//ul[1]")
    val taskList2Text: By              = By.xpath("//main//ul[2]")
    val taskList3Text: By              = By.xpath("//main//ul[3]")
    val scheduleErrorHelpList: By      = By.xpath("//ol[contains(@class, 'govuk-list')]")
    val legendText                     = By.ByClassName("govuk-fieldset__legend")
    val checkYouAnswersSummaryList     = By.ByClassName("govuk-summary-list__row")
    val txtEntirePageContent           = By.ByClassName("govuk-grid-row")
    val txtSummaryCardContent          = By.ByClassName("govuk-summary-card")
    val txtTrusteeName                 = By.ById("nameOfCorporateTrustee")
    val txtTrusteePhoneNo              = By.ById("corporateTrusteeDaytimeTelephoneNumber")
    val txtTrusteePostcode             = By.ById("corporateTrusteePostcode")
    val txtAuthOfficialTitle           = By.ById("title")
    val txtAuthOfficialForename        = By.ById("firstName")
    val txtAuthOfficialSurname         = By.ById("lastName")
    val txtAuthOfficialPhoneNo         = By.ById("phoneNumber")
    val txtAuthOfficialPostcode        = By.ById("postcode")
    val fileUploadFieldLocator         = By.ById("file-input")
    val txtFormFieldset: By            = By.xpath("//form//fieldset")
    val txtBelowConfirmationPanel1: By = By.xpath("//main//p[1]")
    val txtBelowConfirmationPanel2: By = By.xpath("//main//p[2]")
    val txtBelowConfirmationPanel3: By = By.xpath("//main//p[3]")

    val dlLocator: By  = By.className("govuk-summary-list")
    val rowLocator: By = By.className("govuk-summary-list__row")
    val dtLocator: By  = By.className("govuk-summary-list__key")
    val dd1Locator: By = By.className("govuk-summary-list__value")
  }

  def pageUrl: String

  def pageTitle: String

  /** Wait for visibility of an element */
  def waitForVisibilityOfElement(selector: By): WebElement =
    w.until(ExpectedConditions.visibilityOfElementLocated(selector))

  /** Wait for page to load */
  def waitForPage(): Unit = fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("footer")))

  private def fluentWait: Wait[WebDriver] = new FluentWait[WebDriver](Driver.instance)
    .withTimeout(Duration.ofSeconds(30))
    .pollingEvery(Duration.ofMillis(500))
    .ignoring(classOf[NoSuchElementException])

  /** Wait for the page to load to ensure the URL is ready to check */
  def waitForUrl(expectedUrl: String): Unit =
    fluentWait.until(ExpectedConditions.urlContains(expectedUrl))

  def waitForPageTitle(expectedTitle: String): Unit =
    fluentWait.until(ExpectedConditions.titleIs(expectedTitle))

  def waitForElementToBeClickable(selector: By): WebElement =
    new WebDriverWait(driver, Duration.ofSeconds(10))
      .until(ExpectedConditions.elementToBeClickable(selector))

  // Wait for the element to contain the text
  def waitForElementToContain(elementLocator: By, expectedValue: String, waitTime: Int): Unit = {
    val wait = new WebDriverWait(driver, Duration.ofSeconds(waitTime))
    wait.until(ExpectedConditions.textToBePresentInElementLocated(elementLocator, expectedValue))
  }

  /** Trigger a generic error message by trying to bypass required components / data */
  def validateGenericPageError(expectedErrorMessage: String, errorMsgLocatorValue: By): Unit = {
    val errorMessage       = s"$expectedErrorMessage"
    fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(Locators.btnContinue)))
    clickContinue()
    waitForVisibilityOfElement(Locators.errorSummary)
    // Error title indicator
    assert(
      driver.getTitle.contains("Error:"),
      s"Page title mismatch! Expected: Error: ${driver.getTitle} , Actual: ${driver.getTitle}"
    )
    // Error summary - top of page
    val actualErrorSummary = driver.findElement(Locators.errorSummary).getText
    assert(
      actualErrorSummary contains errorMessage,
      s"Page error summary mismatch! Expected: $errorMessage, Actual: $actualErrorSummary"
    )
    println("Actual error summary is: " + actualErrorSummary)
    // Error message - above erroring field
    val actualErrorMsg     = driver.findElement(errorMsgLocatorValue).getText
    assert(
      actualErrorMsg contains errorMessage,
      s"Page error message mismatch! Expected: $errorMessage, Actual: $actualErrorMsg"
    )
    println("Actual error message is: " + actualErrorMsg)
  }

  /** Trigger too many characters error message */
  def triggerTooManyCharInputError(
    length: Int,
    expectedMessage: String,
    inputLocatorValue: By,
    errorMsgLocatorValue: By
  ): Unit = {
    val randomString: String = Random.alphanumeric.take(length).mkString
    val element              = waitForVisibilityOfElement(inputLocatorValue)
    element.clear()
    element.sendKeys(randomString)
    validateGenericPageError(expectedMessage, errorMsgLocatorValue)
  }

  /** Trigger non Western European Alphabet error message */
  def triggerNonWesternEuropeanAlphabetError(
    expectedMessage: String,
    inputLocatorValue: By,
    errorMsgLocatorValue: By
  ): Unit = {
    val heartCharacter = "\u2665"
    val element        = waitForVisibilityOfElement(inputLocatorValue)
    element.clear()
    element.sendKeys(heartCharacter)
    validateGenericPageError(expectedMessage, errorMsgLocatorValue)
  }

  /** Generic input method */
  def input(selector: By, value: String): Unit = {
    val element = waitForVisibilityOfElement(selector)
    element.clear()
    element.sendKeys(value)
  }

  /** Method to input values into month and year fields */
  def inputMonthAndYear(monthSelector: By, yearSelector: By, monthValue: String, yearValue: String): Unit = {
    val monthElement = waitForVisibilityOfElement(monthSelector)
    monthElement.clear()
    monthElement.sendKeys(monthValue)
    val yearElement  = waitForVisibilityOfElement(yearSelector)
    yearElement.clear()
    yearElement.sendKeys(yearValue)
  }

  /** Generic click method */
  override def click(selector: By): Unit = {
    val element = waitForVisibilityOfElement(selector)
    element.click()
  }

  /** Generic clear method */
  def clear(selector: By): Unit = {
    val element = waitForVisibilityOfElement(selector)
    element.clear()
  }

  /** Specific actions */
  def clickContinue(): Unit         = click(By.xpath(Locators.btnContinue))
  def clickBackLink(): Unit         = click(By.linkText(Locators.lnkBack))
  def clickConfirmAndSubmit(): Unit = click(By.cssSelector(Locators.btnContinue))
  def header(): Unit                = click(By.cssSelector(Locators.lnkHeader))
//  def removeFile(): Unit        = click(By.cssSelector(Locators.lnkRemoveFile))

  def clickDeleteScheduleLink(): Unit = click(By.xpath(Locators.lnkDeleteSchedule))
  def signOut(): Unit                 = click(By.xpath(Locators.lnkSignOut))

  /** Navigation methods */
  def navigateToPage(url: String): Unit = driver.navigate().to(url)
  def navigateBackToPage(): Unit        = driver.navigate().back()
  val hostname: String                  = AuthWizard.buildRedirectUrl(HASDIRECT, Organisation)

  /** Page validation methods */
  def isCurrentPage: Boolean         = pageTitle.startsWith(getPageTitle)
  def isCurrentUrl: Boolean          = getCurrentUrlInBrowser.contains(pageUrl)
  def getCurrentUrlInBrowser: String = driver.getCurrentUrl
  def getPageTitle: String           = driver.getTitle

  /** Radio button interaction */
  def radioButton(optionalValue: String): Unit = {
    val element: WebElement    = driver.findElement(By.cssSelector(optionalValue))
    val ex: JavascriptExecutor = driver.asInstanceOf[JavascriptExecutor]
    ex.executeScript("arguments[0].click()", element)
  }

  /** Checkbox interaction */
  def checkbox(optionalValue: String, shouldSelect: Boolean): Unit = {
    val element: WebElement    = driver.findElement(By.cssSelector(optionalValue))
    val ex: JavascriptExecutor = driver.asInstanceOf[JavascriptExecutor]
    val isChecked: Boolean     = element.isSelected
    if (shouldSelect && !isChecked) {
      ex.executeScript("arguments[0].click()", element)
    } else if (!shouldSelect && isChecked) {
      ex.executeScript("arguments[0].click()", element)
    }
  }

  def clickLinkById(linkId: String): Unit =
    try {
      click(By.id(linkId))
      println(s"Successfully clicked the link with ID: $linkId")
    } catch {
      case e: Exception =>
        println(s"Failed to click the link with ID: $linkId. Error: ${e.getMessage}")
    }

  /** Verify that the URL Endpoint is a substring of the current URL */
  def verifyPageUrl(expectedUrl: String): Unit = {
    waitForUrl(expectedUrl)
    assert(
      driver.getCurrentUrl.contains(expectedUrl),
      s"Page URL mismatch! Expected: $expectedUrl, Actual: ${driver.getCurrentUrl}"
    )
    println("Actual URL is: " + driver.getCurrentUrl)
  }

  def verifyPageTitle(expectedTitle: String): Unit = {
    waitForPageTitle(expectedTitle)
    assert(
      driver.getTitle == expectedTitle,
      s"Page title mismatch! Expected: $expectedTitle, Actual: ${driver.getTitle}"
    )
    println("Actual page title is: " + driver.getTitle)
  }

  def verifyPageCaption(expectedCaption: String): Unit = {
    waitForVisibilityOfElement(Locators.txtCaption)
    val actualCaption = driver.findElement(Locators.txtCaption).getText
    assert(
      actualCaption == expectedCaption,
      s"Page caption mismatch! Expected: $expectedCaption, Actual: $actualCaption"
    )
    println("Actual page caption is: " + driver.findElement(Locators.txtCaption).getText)
  }

  def verifyDynamicPageCaption(expectedCaption: String): Unit = {
    waitForVisibilityOfElement(Locators.txtCaption)
    val actualCaption = driver.findElement(Locators.txtCaption).getText
    assert(
      actualCaption contains expectedCaption,
      s"Page caption mismatch! Expected: $expectedCaption, Actual: $actualCaption"
    )
    println("Actual page caption is: " + driver.findElement(Locators.txtCaption).getText)
  }

  def verifyPageHeading(expectedHeading: String): Unit = {
    waitForVisibilityOfElement(Locators.txtHeading)
    val actualHeading = driver.findElement(Locators.txtHeading).getText
    assert(
      actualHeading == expectedHeading,
      s"Page heading mismatch! Expected: $expectedHeading, Actual: $actualHeading"
    )
    println("Actual page heading is: " + driver.findElement(Locators.txtHeading).getText)
  }

  def verifyPageWarning(expectedWarning: String): Unit = {
    waitForVisibilityOfElement(Locators.txtWarning)
    val actualWarning = driver.findElement(Locators.txtWarning).getText
    assert(
      actualWarning contains expectedWarning,
      s"Page warning mismatch! Expected: $expectedWarning, Actual: $actualWarning"
    )
    println("Actual page warning is: " + driver.findElement(Locators.txtWarning).getText)
  }

  def verifyPageSubHeading1(expectedSubHeading1: String): Unit = {
    waitForVisibilityOfElement(Locators.txtSubHeading1)
    val actualSubHeading1 = driver.findElement(Locators.txtSubHeading1).getText
    assert(
      actualSubHeading1 == expectedSubHeading1,
      s"Page sub-heading 1 mismatch! Expected: $expectedSubHeading1, Actual: $actualSubHeading1"
    )
    println("Actual page sub-heading 1 is: " + driver.findElement(Locators.txtSubHeading1).getText)
  }

  def verifyPageSubHeading2(expectedSubHeading2: String): Unit = {
    waitForVisibilityOfElement(Locators.txtSubHeading2)
    val actualSubHeading2 = driver.findElement(Locators.txtSubHeading2).getText
    assert(
      actualSubHeading2 == expectedSubHeading2,
      s"Page sub-heading 2 mismatch! Expected: $expectedSubHeading2, Actual: $actualSubHeading2"
    )
    println("Actual page sub-heading 2 is: " + driver.findElement(Locators.txtSubHeading2).getText)
  }

  /** Verify that a hint includes expected message */
  def verifyHintText(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.hintText)
    val actualText = driver.findElement(Locators.hintText).getText
    assert(
      actualText == expectedText,
      s"Page hint mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual page hint is: " + driver.findElement(Locators.hintText).getText)
  }

  /** Verify that a paragraph includes expected message */
  def verifyParagraphText(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.paragraphText)
    val actualText = driver.findElement(Locators.paragraphText).getText
    assert(
      actualText == expectedText,
      s"Page paragraph mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual page paragraph is: " + driver.findElement(Locators.paragraphText).getText)
  }

  /** Verify elements of a list are the expected messages */
  def verifyListText(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.listText)
    val actualText = driver.findElement(Locators.listText).getText
    assert(
      actualText == expectedText,
      s"Page list mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual page list is: " + driver.findElement(Locators.listText).getText)
  }

  /** Verify elements of a list are the expected messages */
  def verifyTaskList1Text(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.taskList1Text)
    val actualText = driver.findElement(Locators.taskList1Text).getText
    assert(
      actualText == expectedText,
      s"Page task list 1 mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual page task list 1 is: " + driver.findElement(Locators.taskList1Text).getText)
  }

  /** Verify elements of a list are the expected messages */
  def verifyTaskList2Text(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.taskList2Text)
    val actualText = driver.findElement(Locators.taskList2Text).getText
    assert(
      actualText == expectedText,
      s"Page task list 2 mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual page task list 2 is: " + driver.findElement(Locators.taskList2Text).getText)
  }

  /** Verify elements of a list are the expected messages */
  def verifyTaskList3Text(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.taskList3Text)
    val actualText = driver.findElement(Locators.taskList3Text).getText
    assert(
      actualText == expectedText,
      s"Page task list 3 mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual page task list 3 is: " + driver.findElement(Locators.taskList3Text).getText)
  }

  def verifyScheduleErrorHelpList(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.scheduleErrorHelpList)
    val actualText = driver.findElement(Locators.scheduleErrorHelpList).getText
    assert(
      actualText == expectedText,
      s"Page list mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual page list is: " + driver.findElement(Locators.scheduleErrorHelpList).getText)
  }

  /** Verify that the text within a legend includes the expected text */
  def verifyLegendText(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.legendText)
    val actualText = driver.findElement(Locators.legendText).getText
    assert(
      actualText == expectedText,
      s"Page legend mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual page legend is: " + driver.findElement(Locators.legendText).getText)
  }

  /** Verify that the main error page content is displayed as expected */
  def verifyEntirePageContent(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.txtEntirePageContent)
    val actualText = driver.findElement(Locators.txtEntirePageContent).getText
    assert(
      actualText == expectedText,
      s"Warning page content mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual page not found content is: " + driver.findElement(Locators.txtEntirePageContent).getText)
  }

  def verifySummaryCardContent(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.txtSummaryCardContent)
    val actualText = driver.findElement(Locators.txtSummaryCardContent).getText
    assert(
      actualText == expectedText,
      s"Warning summary card content mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual summary card content is: " + driver.findElement(Locators.txtSummaryCardContent).getText)
  }

  def verifyFormFieldsetContent(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.txtFormFieldset)
    val actualText = driver.findElement(Locators.txtFormFieldset).getText
    assert(
      actualText == expectedText,
      s"Warning form content mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual form content is: " + driver.findElement(Locators.txtFormFieldset).getText)
  }

  def verifyPageContentBelowPanel1(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.txtBelowConfirmationPanel1)
    val actualText = driver.findElement(Locators.txtBelowConfirmationPanel1).getText
    assert(
      actualText == expectedText,
      s"Warning form content mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual page content is: " + driver.findElement(Locators.txtBelowConfirmationPanel1).getText)
  }

  def verifyPageContentBelowPanel2(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.txtBelowConfirmationPanel2)
    val actualText = driver.findElement(Locators.txtBelowConfirmationPanel2).getText
    assert(
      actualText == expectedText,
      s"Warning form content mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual page content is: " + driver.findElement(Locators.txtBelowConfirmationPanel2).getText)
  }

  def verifyPageContentBelowPanel3(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.txtBelowConfirmationPanel3)
    val actualText = driver.findElement(Locators.txtBelowConfirmationPanel3).getText
    assert(
      actualText == expectedText,
      s"Warning form content mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual page content is: " + driver.findElement(Locators.txtBelowConfirmationPanel3).getText)
  }

  def verifySignInPage(expectedText: String): Unit = {
    waitForElementToBeClickable(By.xpath(Locators.buttonSignIn))
    val actualText = driver.findElement(By.xpath(Locators.buttonSignIn)).getText
    assert(
      actualText == expectedText,
      s"Warning form content mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual form content is: " + driver.findElement(By.xpath(Locators.buttonSignIn)).getText)
  }

  /** Helper method for passing one string to verify list text instead of multiple */
  def createSingleStringFromMany(listItems: String*): String = listItems.mkString("\n")

  def selectFile(spreadsheetName: String): Unit = {
    val fileUploadFieldLocator = driver.findElement(By.id("file-input"))
    val inputFilePath          = Paths.get("src/test/resources/" + spreadsheetName + ".ods").toAbsolutePath.toString
    fileUploadFieldLocator.sendKeys(inputFilePath)
  }

  def validateUploadFilePageError(expectedErrorMessage: String, errorMsgLocatorValue: By): Unit = {
    val errorMessage       = s"$expectedErrorMessage"
    waitForVisibilityOfElement(Locators.errorSummary)
    // Error title indicator
    assert(
      driver.getTitle.contains("Error:"),
      s"Page title mismatch! Expected: Error: ${driver.getTitle} , Actual: ${driver.getTitle}"
    )
    // Error summary - top of page
    val actualErrorSummary = driver.findElement(Locators.errorSummary).getText
    assert(
      actualErrorSummary contains errorMessage,
      s"Page error summary mismatch! Expected: $errorMessage, Actual: $actualErrorSummary"
    )
    println("Actual error summary is: " + actualErrorSummary)
    // Error message - above erroring field
    val actualErrorMsg     = driver.findElement(errorMsgLocatorValue).getText
    assert(
      actualErrorMsg contains errorMessage,
      s"Page error message mismatch! Expected: $errorMessage, Actual: $actualErrorMsg"
    )
    println("Actual error message is: " + actualErrorMsg)
  }

  /** Helper methods for validating Check your Answers Page's field and value pairs */
  def norm(s: String): String =
    Option(s)
      .getOrElse("")
      .replace('\u00A0', ' ')
      .replace('\n', ' ')
      .replace('\r', ' ')
      .trim
      .replaceAll("\\s+", " ")

  // Extract pairs from ONE WebElement (one summary-list block)
  private def extractPairsFrom(dl: WebElement): Map[String, String] = {
    val rows = dl.findElements(Locators.rowLocator).asScala.toList

    val pairs = rows.flatMap { row =>
      val keyOpt   = row.findElements(Locators.dtLocator).asScala.headOption.map(e => norm(e.getText))
      val valueOpt = row.findElements(Locators.dd1Locator).asScala.headOption.map(e => norm(e.getText))
      (keyOpt, valueOpt) match {
        case (Some(k), Some(v)) => Some(k -> v)
        case _                  => None
      }
    }

    val dupKeys = pairs.groupBy(_._1).collect { case (k, vs) if vs.size > 1 => k }.toList
    if (dupKeys.nonEmpty)
      throw new AssertionError(s"Duplicate dt keys in this summary-list block: ${dupKeys.mkString(", ")}")

    pairs.toMap
  }

  // Get the index of summary-list blocks on the page and extract pairs based on index
  private def extractAllActualPairsAt(index: Int): Map[String, String] = {

    fluentWait.until(_ => driver.findElements(Locators.dlLocator).size() > index)
    val allBlocks = driver.findElements(Locators.dlLocator).asScala.toList
    val targetDl  = allBlocks(index)
    extractPairsFrom(targetDl)
  }

  /** Helper method final to be used in SPEC for validating Check your Answers Page's field and value pairs */
  /** Lines/texts with single/many 'br' '\n' 'blank spaces' etc to input with a single blank space */
  def assertAllSummaryPairsExactlyAt(index: Int)(expectedPairs: (String, String)*): Unit = {
    val actual         = extractAllActualPairsAt(index)
    val expectedNormed = expectedPairs.toMap.map { case (k, v) => norm(k) -> norm(v) }
    val missing        = expectedNormed.keySet -- actual.keySet
    val extra          = actual.keySet -- expectedNormed.keySet

    assert(
      actual == expectedNormed,
      s"""Summary table mismatch! (Block index=$index)
         |Expected: $expectedNormed
         |Actual  : $actual
         |Missing keys: ${missing.mkString(", ")}
         |Extra keys  : ${extra.mkString(", ")}
         |""".stripMargin
    )
  }

}
