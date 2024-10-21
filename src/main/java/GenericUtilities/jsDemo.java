package GenericUtilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class jsDemo {
    public static void flash(WebElement element, WebDriver driver){
        //JavascriptExecutor js=((JavascriptExecutor)driver);
        String bgcolor=element.getCssValue("backgroundcolor");//yellow button for list your property
        for(int i=0;i<500;i++){
            changeColor("#000000",element,driver);
            changeColor("bgcolor",element,driver);
        }
    }
    public static void changeColor(String color, WebElement element, WebDriver driver){
        JavascriptExecutor js=((JavascriptExecutor)driver);
       js.executeScript("argumements[0].style.backgroundcolor='"+color+"'"+element);
       try{
            Thread.sleep(2000);
       }
        catch (InterruptedException e) {
           throw new RuntimeException(e);
       } {

        }
    }

}
