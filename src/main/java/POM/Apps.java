package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Apps {
    public Apps(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"header_tab\"]/div/div/div[3]/div/div")
    private WebElement Apps;

    public WebElement getApps() {
        return Apps;
    }
}