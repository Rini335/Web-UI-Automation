package GenericUtilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;




public class ExtentReportGen {

    static ExtentReports extent;

    public static ExtentReports extentReportGenerator() {

        String path = System.getProperty("user.dir")+"//reports//Zoko_reports.html";

        ExtentHtmlReporter spark = new ExtentHtmlReporter(path);


        spark.config().setTheme(Theme.STANDARD);

        spark.config().setReportName("Zoko Report");

        extent = new ExtentReports();


        extent.attachReporter(spark);


        extent.setSystemInfo("Project Name", "TestZoko");

        extent.setSystemInfo("Environment", "Prod");

        extent.setSystemInfo("Executed by", "Rini Thomas");

        return extent;
    }
}