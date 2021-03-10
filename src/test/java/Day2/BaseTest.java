package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {
    protected WebDriver driver;
    Logger logger = Logger.getLogger(BaseTest.class);

    @BeforeClass        // to się wykona raz przed klasą - nie przed każdą metodą testową
    public void setLogging(){
        DOMConfigurator.configure("log4j.xml");
    }

    @BeforeMethod
    public void setup() throws MalformedURLException {  //throws tylko do grida
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless"); //chrom jest tylko w pamięci, nie widać go

        driver = new ChromeDriver(options);
        // do Selenium Grid byłoby:
        // driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/"), options);    //options jak parę linijek wyżej, to chyba nie koniec tego urla

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
