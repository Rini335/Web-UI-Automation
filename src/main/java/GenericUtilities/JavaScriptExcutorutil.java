package GenericUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static GenericUtilities.BaseTest.driver;

public class JavaScriptExcutorutil {
        public static void clickElement(WebElement element, WebDriver driver) {
            JavascriptExecutor javaScript = (JavascriptExecutor) driver;
            javaScript.executeScript("arguments[0].click();", element);
        }

        public static void jsSendkeys(String data,WebElement element, WebDriver driver) {
            JavascriptExecutor javaScript = (JavascriptExecutor) driver;
            javaScript.executeScript("arguments[0].value='"+data+"';", element);
        }

        public static void jsScrollBy(int x,int y, WebDriver driver) {
            JavascriptExecutor javaScript = (JavascriptExecutor) driver;
            javaScript.executeScript("window.scrollBy("+x+","+y+")");

        }

        public static void jsScrollIntoView(boolean a,WebElement element, WebDriver driver) {
            JavascriptExecutor javaScript = (JavascriptExecutor) driver;
            javaScript.executeScript("arguments[0].scrollIntoView("+a+")",element);
        }

        public static void jsScrollTo(int x,int y,WebElement element, WebDriver driver) {
            JavascriptExecutor javaScript = (JavascriptExecutor) driver;
            javaScript.executeScript("arguments[0].scrollTo("+x+","+y+")",element);
        }

        public static void jsScrollToBottomOfThePage(WebDriver driver) {
            JavascriptExecutor javaScript = (JavascriptExecutor) driver;
            javaScript.executeScript("arguments[0].scrollBy(0,document.body.scrollHeight')");
        }

        public static String jsFetchVale(WebElement element,WebDriver driver) {
            JavascriptExecutor javaScript = (JavascriptExecutor) driver;
            return (String)javaScript.executeScript("return arguments[0].value",element);
        }

        public static void jsRefresh(WebDriver driver) {
            JavascriptExecutor javaScript = (JavascriptExecutor) driver;
            javaScript.executeScript("history.go(0)");
        }

        public static void jsClear(WebElement element,WebDriver driver) {
            JavascriptExecutor javaScript = (JavascriptExecutor) driver;
            javaScript.executeScript("arguments[0].vlue='';",element);
        }

        public static void toPutABorderOnWebElement(WebElement element,WebDriver driver) {
            JavascriptExecutor javaScript = (JavascriptExecutor) driver;
            javaScript.executeScript("arguments[0].style.border='3px solid red';",element);
        }

        public void toChangeTheColorOfWebElement(String color,WebElement element,WebDriver driver) {
            JavascriptExecutor javaScript = (JavascriptExecutor) driver;
            javaScript.executeScript("arguments[0].style.backgroundColor = '"+color+"';",element);

        }
    public static void jsScrollTo(int vertical,int horizontal) {
        JavascriptExecutor javaScript = (JavascriptExecutor) driver;
        javaScript.executeScript("scroll(vertical,horizontal)");
    }

    public static void jsclickon(WebElement locator) {
        JavascriptExecutor javaScript = (JavascriptExecutor) driver;
        javaScript.executeScript("document.getElementById(locator).click()");
    }

    }

