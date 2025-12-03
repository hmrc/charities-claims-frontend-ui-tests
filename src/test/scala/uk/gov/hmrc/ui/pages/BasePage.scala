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

package uk.gov.hmrc.ui.pages

import com.typesafe.scalalogging.LazyLogging
import org.openqa.selenium.support.ui.{ExpectedConditions, FluentWait, Wait, WebDriverWait}
import org.openqa.selenium.{By, JavascriptExecutor, WebDriver, WebElement}
import org.scalatest.concurrent.Eventually
import org.scalatest.matchers.must.Matchers
import uk.gov.hmrc.selenium.component.PageObject
import uk.gov.hmrc.selenium.webdriver.Driver
import uk.gov.hmrc.ui.driver.BrowserDriver
//import uk.gov.hmrc.ui.pages.AuthWizard
import uk.gov.hmrc.ui.util.Users.LoginTypes.HASDIRECT
import uk.gov.hmrc.ui.util.Users.UserTypes.Organisation

import java.time.Duration
import scala.util.Random

trait BasePage extends PageObject with Eventually with Matchers with LazyLogging with BrowserDriver {

  /** Implicit wait */
  implicit def w: WebDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30))

  logger.info(
    s"Instantiating Browser: ${sys.props.getOrElse("browser", "'browser' System property not set. This is required")}"
  )

  /** Locator values */
  object Locators {
    val btnContinue                   = "//button[@type='submit']"
    val lnkBack                       = "Back"
    val lnkHeader                     = ".govuk-header__link.govuk-header__service-name"
    val rdoYes                        = "#value_0"
    val rdoNo                         = "#value_1"
    val txtFileName                   = ".govuk-body"
    val txtHeader: By                 = By.xpath("//h1")
    val txtAddressPostCode            = By.ById("postcode")
    val inputYourClaimReferenceNumber = By.ByClassName("govuk-input")
    val inputYourUserId: By           = By.xpath("//input[@name='authorityId']")
    val hintText                      = By.ById("value-hint")
    val paragraphText                 = By.ByClassName("govuk-body")
    val errorSummary                  = By.ByClassName("govuk-error-summary__body")
    val errorMsg                      = By.ById("value-error")
    val listText                      = By.ByClassName("govuk-list")
    val legendText                    = By.ByClassName("govuk-fieldset__legend")
    val checkYouAnswersSummaryList    = By.ByClassName("govuk-summary-list__row")
    val pageNotFoundContent           = By.ByClassName("govuk-grid-row")
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

  /** Trigger a generic error message by trying to bypass required components / data */
  def validateGenericPageError(expectedErrorMessage: String): Unit = {
    val errorSummary       = s"$expectedErrorMessage"
    val errorMsgWithPrefix = s"Error:\n$expectedErrorMessage"
    clickContinue()
    waitForVisibilityOfElement(Locators.errorMsg)
    // Error title indicator
    assert(
      driver.getTitle.contains("Error:"),
      s"Page title mismatch! Expected: Error: ${driver.getTitle} , Actual: ${driver.getTitle}"
    )
    // Error summary - top of page
    val actualErrorSummary = driver.findElement(Locators.errorSummary).getText
    assert(
      actualErrorSummary == errorSummary,
      s"Page error message mismatch! Expected: $errorSummary, Actual: $actualErrorSummary"
    )
    println("Actual error summary is: " + driver.findElement(Locators.errorSummary).getText)
    // Error message - above erroring field
    val actualErrorMsg     = driver.findElement(Locators.errorMsg).getText
    assert(
      actualErrorMsg == errorMsgWithPrefix,
      s"Page error message mismatch! Expected: $errorMsgWithPrefix, Actual: $actualErrorMsg"
    )
    println("Actual error message is: " + driver.findElement(Locators.errorMsg).getText)
  }

  /** Trigger too many characters error message */
  def triggerTooManyCharInputtedError(expectedMessage: String): Unit = {
    val randomString: String = Random.alphanumeric.take(64).mkString
    val element              = waitForVisibilityOfElement(Locators.inputYourClaimReferenceNumber)
    element.clear()
    element.sendKeys(randomString)
    validateGenericPageError(expectedMessage)
  }

  /** Trigger non Western European Alphabet error message */
  def triggerNonWesternEuropeanAlphabetError(expectedMessage: String): Unit = {
    val heartCharacter = "\u2665"
    val element        = waitForVisibilityOfElement(Locators.inputYourClaimReferenceNumber)
    element.clear()
    element.sendKeys(heartCharacter)
    validateGenericPageError(expectedMessage)
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
  def clickContinue(): Unit = click(By.xpath(Locators.btnContinue))
  def clickBackLink(): Unit = click(By.linkText(Locators.lnkBack))
//  def saveAndContinue(): Unit   = click(By.cssSelector(Locators.btnContinue))
  def header(): Unit        = click(By.cssSelector(Locators.lnkHeader))
//  def removeFile(): Unit        = click(By.cssSelector(Locators.lnkRemoveFile))

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

  def verifyPageHeader(expectedHeader: String): Unit = {
    waitForVisibilityOfElement(Locators.txtHeader)
    val actualHeader = driver.findElement(Locators.txtHeader).getText
    assert(
      actualHeader == expectedHeader,
      s"Page header mismatch! Expected: $expectedHeader, Actual: $actualHeader"
    )
    println("Actual page header is: " + driver.findElement(Locators.txtHeader).getText)
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
  def verifyPageNotFoundContent(expectedText: String): Unit = {
    waitForVisibilityOfElement(Locators.pageNotFoundContent)
    val actualText = driver.findElement(Locators.pageNotFoundContent).getText
    assert(
      actualText == expectedText,
      s"404 page content mismatch! Expected: $expectedText, Actual: $actualText"
    )
    println("Actual page not found content is: " + driver.findElement(Locators.pageNotFoundContent).getText)
  }

  /** Helper method for passing one string to verify list text instead of multiple */
  def createSingleStringFromMany(listItems: String*): String = listItems.mkString("\n")
}
