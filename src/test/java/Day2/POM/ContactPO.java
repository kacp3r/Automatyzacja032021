package Day2.POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactPO extends BasePO{
    Logger logger = Logger.getLogger(ContactPO.class);

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "id_order")
    private WebElement orderIdField;

    @FindBy(id = "message")
    private WebElement messageField;

    @FindBy(id = "fileUpload")
    private WebElement fileUploadField;

    @FindBy(className = "uploader")             //this one is used only to check visibility
    private WebElement fileUploadContainer;

    @FindBy(id = "id_contact")
    private WebElement subjectHeadingDropdown;

    @FindBy(id = "submitMessage")
    private WebElement submitMessageButton;

    @FindBy(className = "alert-success")
    private WebElement successMessage;

    public ContactPO(WebDriver driver) {  //domyślny konstruktor, odwołujący się do abstrakta
        super(driver);
    }

    public boolean emailFieldIsDisplayed(){
        logger.trace("Will attempt to check for Email field");
        if (emailField.isDisplayed()){
            logger.debug("Email field is displayed");
        } else {
            logger.debug("Email field is not displayed");
        }
        return emailField.isDisplayed();
    }

    public boolean orderIdFieldIsDisplayed(){
        logger.trace("Will attempt to check for Order Id field");
        if (orderIdField.isDisplayed()){
            logger.debug("Order id field is displayed");
        } else {
            logger.debug("Order id field is not displayed");
        }
        return orderIdField.isDisplayed();
    }

    public boolean messageFieldIsDisplayed(){
        logger.trace("Will attempt to check for Message field");
        if (messageField.isDisplayed()){
            logger.debug("Message field is displayed");
        } else {
            logger.debug("Message field is not displayed");
        }
        return messageField.isDisplayed();
    }

    // this one is bad and is not displayed
    public boolean fileUploadFieldIsDisplayed(){
        logger.trace("Will attempt to check for Order Id field");
        if (fileUploadContainer.isDisplayed()){
            logger.debug("File upload field is displayed");
        } else {
            logger.debug("File upload field is NOT displayed");
        }
        return fileUploadContainer.isDisplayed();
    }

    // this one is bad and is not displayed, so I had to go up one level with xpath
    public boolean subjectHeadingDropdownIsDisplayed(){
        logger.trace("Will attempt to check for Order Id field");
        if (subjectHeadingDropdown.isDisplayed()){
            logger.debug("Subject heading dropdown field is displayed");
        } else {
            logger.debug("Subject heading dropdown field is NOT displayed");
        }
        return subjectHeadingDropdown.findElement(By.xpath("./../span")).isDisplayed();
    }

    public ContactPO sendEmail(String emailAddress){
        logger.trace("Attempting to send email address");
        emailField.sendKeys(emailAddress);
        logger.debug("Sent email address to field");
        return this;
    }

    public ContactPO sendOrderId(String orderId){
        logger.trace("Attempting to send Order Id to field");
        orderIdField.sendKeys(orderId);
        logger.debug("Sent order Id to field");
        return this;
    }

    public ContactPO sendMessage(String message){
        logger.trace("Attempting to send message to field");
        messageField.sendKeys(message);
        logger.debug("Sent message to field");
        return this;
    }

    public ContactPO selectElementFromSubjectHeadingDropdown(String elementNo){    // good values are "1" and "2"
        Select select = new Select(subjectHeadingDropdown);
        logger.trace("Attempting to select element from subject heading dropdown");
        select.selectByValue(elementNo);
        logger.debug("Selected element from subject heading dropdown");
        return this;
    }

    public ContactPO sendFileToFileUploadField(String fileAddress){
        logger.trace("Attempting to send file to file upload field");
        fileUploadField.sendKeys(fileAddress);
        logger.debug("Sent file to file upload field");
        return this;
    }

    public void clickSubmitMessageButton(){
        logger.trace("Attempting to click submit message button");
        submitMessageButton.click();
        logger.debug("Clicked subject heading button");
    }       // this is intentionally on void, because then you are no longer on the contact page

    public boolean successMessageIsVisible(){
        logger.trace("Will attempt to check for success message field");
        if (successMessage.isDisplayed()){
            logger.debug("Order success message is displayed");
        } else {
            logger.debug("Order success message is NOT displayed");
        }
        return successMessage.isDisplayed();
    }
}
