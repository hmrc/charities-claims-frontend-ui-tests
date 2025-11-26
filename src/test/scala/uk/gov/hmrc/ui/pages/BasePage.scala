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

import java.time.Duration

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
//    val txtBannerTitle      = "#govuk-notification-banner-title"
//    val lnkRemoveFile       = "dd[class='govuk-summary-list__actions'] a[class='govuk-link']"
//    val txtMonth: By        = By.ById("value.month")
//    val txtYear: By         = By.ById("value.year")
//    val txtEmailAddress: By = By.cssSelector("#value")
//    val cbxConfirm          = "#value_0"
    val txtHeader: By                 = By.xpath("//h1")
//    val lnkAddrManually     = "Enter the address manually"
//    val txtPostCode: By     = By.ById("postcode")
//    val txtAddress1: By     = By.ById("line1")
//    val txtTown: By         = By.ById("town")
    val txtAddressPostCode            = By.ById("postcode")
    val inputYourClaimReferenceNumber = By.ByClassName("govuk-input")
    val hintText                      = By.ById("value-hint")
    val paragraphText                 = By.ByClassName("govuk-body")
    val errorMsg                      = By.ById("value-error")
    val listText                      = By.ByClassName("govuk-list")
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
    val errorMsgWithPrefix = s"Error:\n$expectedErrorMessage"
    clickContinue()
    waitForVisibilityOfElement(Locators.errorMsg)
    val actualErrorMsg     = driver.findElement(Locators.errorMsg).getText
    assert(
      actualErrorMsg == errorMsgWithPrefix,
      s"Page error message mismatch! Expected: $errorMsgWithPrefix, Actual: $actualErrorMsg"
    )
    println("Actual error message is: " + driver.findElement(Locators.errorMsg).getText)
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
  def clickContinue(): Unit     = click(By.xpath(Locators.btnContinue))
  def clickBackLink(): Unit     = click(By.linkText(Locators.lnkBack))
  def saveAndContinue(): Unit   = click(By.cssSelector(Locators.btnContinue))
  def acceptAndContinue(): Unit = click(By.cssSelector(Locators.btnContinue))
  def header(): Unit            = click(By.cssSelector(Locators.lnkHeader))
//  def removeFile(): Unit        = click(By.cssSelector(Locators.lnkRemoveFile))

  /** Navigation methods */
  def navigateToPage(url: String): Unit = driver.navigate().to(url)
  def navigateBackToPage(): Unit        = driver.navigate().back()

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

  /** Helper method for passing one string to verify list text instead of multiple */
  def createSingleStringFromMany(listItems: String*): String = listItems.mkString("\n")
}
