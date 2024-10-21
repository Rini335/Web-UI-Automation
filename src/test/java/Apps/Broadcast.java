//package Apps;
//
//import GenericUtilities.BaseTest;
//import POM.BroadcastElements;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//import POM.Apps;
//import POM.LoginElements;
//
//import java.time.Duration;
//
//public class Broadcast extends BaseTest {
//    @Test
//    public void Broadcast()throws InterruptedException {
////        WebDriverWait wait = new WebDriverWait(driver,30);
//        BroadcastElements broadcast=new BroadcastElements(driver);
//        Apps apps=new Apps(driver);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//        wait.until(ExpectedConditions.elementToBeClickable(apps.getApps()));
//        apps.getApps().click();
//        Thread.sleep(3000);
//        broadcast.getBroadcast().click();
//        Thread.sleep(2000);
//        broadcast.getNewBroadcast().click();
//        Thread.sleep(2000);
//        broadcast.getBroadcastLanguage().click();
//        Thread.sleep(5000);
//        broadcast.getBroadcastSearchLanguage().sendKeys(BroadcastSearchLanguage);
//        Thread.sleep(3000);
//        broadcast.getBroadcastSelectLanguage().click();
//        Thread.sleep(2000);
//        broadcast.getSearchforTemplate().sendKeys(TemplateName);
//        broadcast.getSelectTemplate().click();
//        broadcast.getAddBroadcastRecipient().click();
//        Thread.sleep(5000);
//       String name= String.valueOf(broadcast.getGetBroadcastName());
//
//
//
//
//
//
//
//
//
//    }
//}
package Apps;

import GenericUtilities.BaseTest;
import POM.BroadcastElements;
import POM.Apps;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 * Test class for Broadcast functionality.
 */
public class Broadcast extends BaseTest {

    @Test(groups = "broadcast")
    @Parameters({"broadcastSearchLanguage", "templateName"})
    public void testBroadcastFunctionality(String broadcastSearchLanguage, String templateName) {
        performLogin();
        Reporter.log("Performed login with username: " + username, true);

        BroadcastElements broadcast = new BroadcastElements(driver);
        Apps apps = new Apps(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));

        wait.until(ExpectedConditions.elementToBeClickable(apps.getApps()));
        apps.getApps().click();
        Reporter.log("Clicked on Apps section", true);

        wait.until(ExpectedConditions.elementToBeClickable(broadcast.getBroadcast()));
        broadcast.getBroadcast().click();
        Reporter.log("Navigated to Broadcast section", true);

        broadcast.getNewBroadcast().click();
        Reporter.log("Clicked on New Broadcast", true);

        broadcast.getBroadcastLanguage().click();
        Reporter.log("Clicked on Broadcast Language", true);


        broadcast.getBroadcastSearchLanguage().sendKeys(broadcastSearchLanguage);
        Reporter.log("Entered Broadcast Search Language: " + broadcastSearchLanguage, true);


        broadcast.getBroadcastSelectLanguage().click();
        Reporter.log("Selected Broadcast Language", true);


        broadcast.getSearchforTemplate().sendKeys(templateName);
        Reporter.log("Entered Template Name: " + templateName, true);

        broadcast.getSelectTemplate().click();
        Reporter.log("Selected Template: " + templateName, true);

        broadcast.getAddBroadcastRecipient().click();
        Reporter.log("Added Broadcast Recipient", true);

        String broadcastname = broadcast.getGetBroadcastName().getText();
        Reporter.log("Broadcast Name: " + broadcastname, true);


    }
}
