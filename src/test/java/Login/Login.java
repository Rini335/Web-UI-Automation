package Login;

import GenericUtilities.BaseTest;
import POM.LoginElements;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.time.Duration;

public class Login extends BaseTest {

    @Test
    public void testLoginFunctionality() {
        // Perform login using the helper method
        performLogin();
        Reporter.log("Performed login with username: " + username, true);

        // Initialize WebDriverWait with a timeout of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize Page Object
        LoginElements login = new LoginElements(driver);

        // Wait for the dropdown to be visible
        wait.until(ExpectedConditions.visibilityOf(login.getDropdown()));
        Reporter.log("Dropdown is visible", true);

        // Click on the dropdown to reveal the signout button
        login.getDropdown().click();
        Reporter.log("Clicked on dropdown to reveal signout button", true);

        // Wait for the signout button to be visible
        wait.until(ExpectedConditions.visibilityOf(login.getSignout()));
        Reporter.log("Signout button is visible", true);

        // Assert that the signout button is displayed
        Assert.assertTrue(login.getSignout().isDisplayed(), "Signout button is not displayed. Login might have failed.");
        Reporter.log("Signout button is displayed. Login successful.", true);

        // Optionally, click on the signout button to log out
        // login.getSignout().click();
        // Reporter.log("Clicked on signout button to log out", true);
    }
}
