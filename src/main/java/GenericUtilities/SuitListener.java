package GenericUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static GenericUtilities.BaseTest.driver;
import static GenericUtilities.ScreenShot.captureScreenshot;

public class SuitListener implements ITestListener {
    private ExtentTest test;
    private ExtentReports extent = ExtentReportGen.extentReportGenerator(); // Ensure this method is correctly implemented.

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Test case started: " + result.getName());
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test case passed: " + result.getName());
        test.log(Status.PASS, "Test case passed");
    }

//    @Override
//    public void onTestFailure(ITestResult result) {
//        System.out.println("Test case failed: " + result.getName());
//        test.fail(result.getThrowable());
//
//        // Optionally, add screenshot capture here if needed.
//    }
@Override
        public void onTestFailure(ITestResult result) {
            System.out.println("Test case failed :"+result.getName());
            test.fail(result.getThrowable());

            String dateName=new SimpleDateFormat("yyyyMMddhhmmmss").format(new Date());
            String fileName = System.getProperty("user.dir") + File.separator + "screenshot" + File.separator + result.getMethod().getMethodName();
            File f = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            try {

                FileUtils.copyFile(f, new File(fileName + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("Test case Failed :"+result.getName());
            test.fail(result.getThrowable());
            try {
                String base64Code=captureScreenshot();
                test.addScreenCaptureFromBase64String(base64Code);
                test.addScreenCaptureFromPath(captureScreenshot(driver,result.getName() ), "Captured screenshot");
                extent.flush();


            } catch (IOException e) {

                System.out.println("Exception occured while taking screenshot");
            }

        }


    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test case skipped: " + result.getName());
        test.skip("Test skipped");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // Implement if needed.
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test started: " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test completed: " + context.getName());
        extent.flush();
    }
}
