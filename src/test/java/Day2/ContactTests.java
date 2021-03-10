package Day2;

import Day2.POM.ContactPO;
import Day2.POM.HomepagePO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactTests extends BaseTest{

    // homepage -> contact us - sprawdzenie załadowania elementów
    @Test
    public void elementsPresentOnContactPage(){
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        ContactPO contactPO = new ContactPO(driver);

        //when
        homepagePO.openMe().
                clickContactLink();

        //then
        Assert.assertTrue(contactPO.emailFieldIsDisplayed());
        Assert.assertTrue(contactPO.subjectHeadingDropdownIsDisplayed());
        Assert.assertTrue(contactPO.orderIdFieldIsDisplayed());
        Assert.assertTrue(contactPO.messageFieldIsDisplayed());
        Assert.assertTrue(contactPO.fileUploadFieldIsDisplayed());
    }

    // homepage -> contact us - wysłanie wiadomości
    @Test
    public void sendMessageSuccessfulTypeOne(){
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        ContactPO contactPO = new ContactPO(driver);
        String emailAddress = "a@b.com";
        String orderId = "123456";
        String message = "This is my message to be sent.";
        String subjectHeadingDropdownElementNo = "1";
        String fileAddress = "C:\\Users\\kacpe\\IdeaProjects\\Automatyzacja032021\\src\\test\\java\\Day2\\pusty.txt";

        //when
        homepagePO.openMe().
                clickContactLink();

        contactPO.sendEmail(emailAddress)
                .sendOrderId(orderId)
                .sendMessage(message)
                .selectElementFromSubjectHeadingDropdown(subjectHeadingDropdownElementNo)
                .sendFileToFileUploadField(fileAddress)
                .clickSubmitMessageButton();

        //then
        Assert.assertTrue(contactPO.successMessageIsVisible());
    }

    // sprawdzenie obu typów wiadomości - dla chętnych
    @Test
    public void sendMessageSuccessfulTypeTwo(){
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        ContactPO contactPO = new ContactPO(driver);
        String emailAddress = "a@b.com";
        String orderId = "123456";
        String message = "This is my message to be sent.";
        String subjectHeadingDropdownElementNo = "2";

        //when
        homepagePO.openMe().
                clickContactLink();

        contactPO.sendEmail(emailAddress)
                .sendOrderId(orderId)
                .sendMessage(message)
                .selectElementFromSubjectHeadingDropdown(subjectHeadingDropdownElementNo)
                .clickSubmitMessageButton();

        //then
        Assert.assertTrue(contactPO.successMessageIsVisible());
    }
}
