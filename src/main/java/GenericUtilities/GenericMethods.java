package GenericUtilities;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static GenericUtilities.BaseTest.driver;

//
//import java.time.Duration;
//
//



    //
//import java.time.Duration;
//
//
    public class GenericMethods {
        //All Assertion methods

        public static void assertEquals(Object expected, Object actual, String message) {
            Assert.assertEquals(expected, actual, message);
        }

        public static void assertTrue(boolean condition, String message) {
            Assert.assertTrue(condition, message);
        }

        public static void assertFalse(boolean condition, String message) {
            Assert.assertFalse(condition, message);
        }

        public static void assertNull(Object object, String message) {
            Assert.assertNull(object, message);
        }

        public static void assertNotNull(Object object, String message) {
            Assert.assertNotNull(object, message);
        }

        public static void assertSame(Object expected, Object actual, String message) {
            Assert.assertSame(expected, actual, message);
        }

        public static void assertNotSame(Object expected, Object actual, String message) {
            Assert.assertNotSame(expected, actual, message);
        }


        public static void assertArrayEqualsWithMessage(Object[] expectedArray, Object[] actualArray, String message) {
            assertArrayEqualsWithMessage(expectedArray, actualArray, "Arrays should be equal.");

        }

        //common methods
        public static void SenKeysOnWebelement(WebElement element, String text) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }

        //for click action
        public static Void ClickOnWebelement(WebElement element, long waitTimeInSeconds) {
            WebDriverWait webwait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeInSeconds));
            WebElement elements = null;
            elements = webwait.until(ExpectedConditions.elementToBeClickable(element));
            elements.click();

            return null;
        }

        public void SelectByVisibleText(WebElement element, String text) {
            Select select = new Select(element);
            select.selectByVisibleText(text);

        }

        public void AcceptAlert(WebDriver driver) {
            driver.switchTo().alert().accept();
        }

        public void MouseHoverandClickElement(WebElement element) {
            Actions action = new Actions(driver);
            action.moveToElement(element).click().build().perform();


        }

        public void Entermethod(WebElement element) {
            element.sendKeys(Keys.ENTER);

        }
        public void Implicitwait() {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        }

        public static void switchToTab(WebDriver driver, int tabIndex) {
            driver.switchTo().window(driver.getWindowHandles().toArray()[tabIndex].toString());
        }


        // Method to close a specific tab by index
        public static void closeTab(WebDriver driver, int tabIndex)
        {
            switchToTab(driver, tabIndex);
            driver.close(); }

    }
