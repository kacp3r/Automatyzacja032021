package Steps;

import Day2.POM.ContactPO;
import Day2.POM.HomepagePO;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class Steps {
    Logger logger = Logger.getLogger(Steps.class);
    static WebDriver driver;
    HomepagePO homepagePO;   // deklaracja, dzięki temu możęmy używać tej instancji w każdej metodzie
    ContactPO contactPO;


    @Before
    public static void setup(){
        DOMConfigurator.configure("log4j.xml");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @After
    public static void close(){
        driver.quit();
    }

    @Given("homepage is opened")
    public void homepage_is_opened() {
        homepagePO = new HomepagePO(driver);        //inicjalizacja
        homepagePO.openMe();
    }
    @When("I click Contact Link")
    public void i_click_contact_link() {
        contactPO = homepagePO.clickContactLink();
    }
    @Then("ContactUs page is opened")
    public void contact_us_page_is_opened() {
        Assert.assertTrue(contactPO.messageFieldIsDisplayed());
    }

    @Then("{string} is displayed")
    public void is_displayed(String string) {
        Assert.assertTrue(true);                    //obvious placeholder
    }

    @Then("{string} is displayed {int}")                        //two parameters
    public void is_displayed(String string, Integer int1) {
        Assert.assertTrue(true);                    //obvious placeholder
    }
}
