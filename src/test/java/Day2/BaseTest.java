package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;



public class BaseTest {
    protected WebDriver driver;
    Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeClass        // to się wykona raz przed klasą - nie przed każdą metodą testową
    public void setLogging(){
        DOMConfigurator.configure("log4j.xml");
    }

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless"); //chrom jest tylko w pamięci, nie widać go

        driver = new ChromeDriver(options);

        logger.info("Chromedriver created");
        // tutaj coś jeszcze
        //driver.manage().timeouts().implicitlyWait()   //co tam dalej?
    }

    @AfterMethod
    public void cleanUp(){
        logger.trace("Tryin to kill browser");
        driver.quit();
        logger.info("Browser killed");
    }
}
