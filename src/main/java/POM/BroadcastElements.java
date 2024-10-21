package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class BroadcastElements {
    public BroadcastElements(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id=\"broadcast\"]")
    private WebElement Broadcast;

    public WebElement getBroadcast() {
        return Broadcast;
    }

    @FindBy(xpath = "//*[@id=\"new_broadcast\"]")
    private WebElement NewBroadcast;

    public WebElement getNewBroadcast() {
        return NewBroadcast;
    }
    @FindBy(xpath = "//*[@id=\"broadcast_language\"]/span/div/div/div")
    private WebElement BroadcastLanguage;

    public WebElement getBroadcastLanguage() {
        return BroadcastLanguage;
    }
    @FindBy(xpath = "//*[@id=\"broadcast_language\"]/span/div/div[2]/div[2]/div/div/input")
    private WebElement BroadcastSearchLanguage;

    public WebElement getBroadcastSearchLanguage() {
        return BroadcastSearchLanguage;
    }

    @FindBy(xpath = "//*[text()='English']")
    private WebElement BroadcastSelectLanguage;

    public WebElement getBroadcastSelectLanguage() {
        return BroadcastSelectLanguage;
    }


    @FindBy(xpath = "//*[@id=\"template_search\"]/div/input")
    private WebElement SearchforTemplate;

    public WebElement getSearchforTemplate() {
        return SearchforTemplate;
    }

    @FindBy(xpath = "//*[@id=\"template_list\"]//*[text()='rini']")
    private WebElement SelectTemplate;
    public WebElement getSelectTemplate() {
        return SelectTemplate;
    }

    @FindBy(xpath = "//*[@id=\"broadcast_recipient_next\"]")
    private WebElement AddBroadcastRecipient;
    public WebElement getAddBroadcastRecipient() {
        return AddBroadcastRecipient;
    }

    @FindBy(xpath = "//*[@id=\"broadcast-header-active-link\"]")
    private WebElement getBroadcastName;
    public WebElement getGetBroadcastName() {
        return getBroadcastName;
    }

    @FindBy(xpath = "(//*[@id=\"broadcast_recipients_title\"])[1]")
    private WebElement donotsendtosection;
    public WebElement getDonotsendtosection(){
        return donotsendtosection;
    }

    @FindBy(xpath = "//*[@id=\"broadcast_add_recipients\"]/span")
    private WebElement AddRecipients;
    public WebElement getAddRecipients(){
        return AddRecipients;
    }

    @FindBy(xpath = "//*[@id=\"broadcast_contact_search\"]/div[1]/div/div/input")
    private WebElement AddContacts;
    public WebElement getAddContacts(){
        return AddContacts;
    }

//    @FindBy(xpath = "//*[@id=\"broadcast_contact_search\"]/div[1]/div/div/input")
//    private WebElement AddContacts;
//    public WebElement getAddContacts(){
//        return AddContacts;
//    }



}
