package GenericUtilities;

import POM.LoginElements;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class BaseTest implements IAutoContants {
    public static WebDriver driver;
    protected String baseUrl;
    protected String username;
    protected String password;

    /**
     * Initializes configuration parameters.
     * This method runs once before the entire test suite.
     */
    @BeforeSuite
    @Parameters({"baseUrl", "username", "password"})
    public void beforeSuiteMethod(
            @Optional("https://app.live.zoko.io") String baseUrl,
            @Optional("defaultUsername") String username,
            @Optional("defaultPassword") String password) {
        // Initialize configuration variables
        this.baseUrl = baseUrl;
        this.username = username;
        this.password = password;

        // Debug Logs
        Reporter.log("Base URL: " + baseUrl, true);
        Reporter.log("Username: " + username, true);
        Reporter.log("Password: " + password, true);

    }

    /**
     * Sets up the WebDriver before each test method based on the browser parameter.
     */
    @BeforeMethod
    @Parameters({"browser"})
    public void setUp(@Optional("chrome") String browser, Method method) {
        // Initialize WebDriver based on browser using WebDriverManager
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            Reporter.log("Launching Chrome Browser", true);
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            Reporter.log("Launching Firefox Browser", true);
        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        // Maximize window and set implicit wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Navigate to baseUrl
        driver.get(baseUrl);
        Reporter.log("Navigated to URL: " + baseUrl, true);
    }

    /**
     * Tears down the WebDriver after each test method and handles test results.
     */
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        // Handle test results and logging
        if (result.getStatus() == ITestResult.FAILURE) {
            // Optionally, capture screenshots here if not handled by the listener
            captureScreenshot(result.getMethod().getMethodName());
        }

        // Close the browser
        if (driver != null) {
            driver.quit();
            Reporter.log("Browser closed", true);
        }
    }

    /**
     * Flushes any remaining reports after the entire test suite has run.
     */
    @AfterSuite
    public void afterSuiteMethod() {
        Reporter.log("Test Suite Execution Completed", true);
    }

    /**
     * Captures a screenshot of the current browser window.
     *
     * @param methodName The name of the test method.
     * @throws IOException If an I/O error occurs during file operations.
     */
    public void captureScreenshot(String methodName) throws IOException {
        // Capture screenshot as a file
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "/" + SCREENSHOT_PATH + methodName + ".png";
        FileUtils.copyFile(src, new File(dest));
        // If ExtentReports is managed by the listener, you might need to pass the path to the listener
    }

    /**
     * Performs login actions using the LoginElements Page Object.
     */
    protected void performLogin() {
        // Initialize Page Object
        LoginElements login = new LoginElements(driver);

        // Perform login actions
        login.getEmail().sendKeys(username);
        Reporter.log("Entered email: " + username, true);

        login.getPassword().sendKeys(password);
        Reporter.log("Entered password: " + password, true);

        login.getSignin().click();
        Reporter.log("Clicked on Signin button", true);
    }
}
