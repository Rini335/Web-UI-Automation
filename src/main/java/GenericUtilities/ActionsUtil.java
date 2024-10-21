package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static GenericUtilities.BaseTest.driver;

public class ActionsUtil {
    WebDriver driver;
        Actions action = new Actions(driver);
	    public ActionsUtil(WebDriver driver) {
            driver=this.driver;
        }
        public void clickElement(WebElement element) {
            action.click(element).perform();
        }
        public void moveToElement(WebElement element) {
            action.moveToElement(element).perform();
        }
        public void moveByoffSet(WebElement element) {
            action.moveToElement(element).perform();
        }
        public void doubleClick(WebElement element) {
            action.doubleClick(element).perform();
        }
        public void rightClick(WebElement element) {
            action.contextClick(element).perform();
        }

    }

