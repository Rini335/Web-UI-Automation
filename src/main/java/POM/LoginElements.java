//package POM;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//
//public class LoginElements {
//    public LoginElements(WebDriver driver) {
//        PageFactory.initElements(driver, this);
//    }
//    @FindBy(xpath = "//*[@id=\"login_email\"]/div[2]/input")
//
//    private WebElement Email;
//
//    public WebElement getEnterEmail(){return Email;}
//
//
//}

package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginElements {
    public LoginElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }



    @FindBy(xpath = "//*[@placeholder=\"Type your email address...\"]")
    private WebElement Email;
    public WebElement getEmail() {
        return Email;
    }

    @FindBy(xpath = "//*[@placeholder=\"Type password..\"]")
    private WebElement Password;
    public WebElement getPassword() {
        return Password;
    }

    @FindBy(xpath = "//*[@id=\"login_button\"]")
    private WebElement Signin;
    public WebElement getSignin() {
        return Signin;
    }
    @FindBy(xpath = "//*[@id=\"page_header\"]/div/div[3]/div/img")
    private WebElement dropdown;
    public WebElement getDropdown(){
        return dropdown;}
    @FindBy(xpath = "//*[@id=\"page_header\"]/div/div[3]/div[2]/div/div/button/span")
    private WebElement signout;
    public WebElement getSignout(){
        return signout;
    }
    }



