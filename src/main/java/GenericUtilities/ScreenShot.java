package GenericUtilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot extends BaseTest {

    //WAP to take the screenshot and call that method into another class
    public static String captureScreenshot() throws IOException
    {

        TakesScreenshot scrshot = (TakesScreenshot)driver;

        String base64Code  = scrshot.getScreenshotAs(OutputType.BASE64);
        System.out.println("screenshot saved successfully");
        return base64Code;

    }

    public static String captureScreenshot(WebDriver driver, String filename) throws IOException
    {

        TakesScreenshot scrshot = (TakesScreenshot)driver;

        File source = scrshot.getScreenshotAs(OutputType.FILE);

        //String path = System.getProperty("user.dir")+"\\screenshot\\"+filename+".png"; //for windows
        String path = System.getProperty("user.dir") + "/screenshot/" + filename + ".png"; //for mac

        //	String path = "/home/techsevin/git/YarnBiz/screenshots/"+filename+".png";  //for linux

        File destination = new File(path);

        FileHandler.copy(source, destination);

        return path;

    }


}
