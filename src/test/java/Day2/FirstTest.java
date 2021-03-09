package Day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless"); //chrom jest tylko w pamięci, nie widać go

        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public void cleanUp(){
        driver.quit();
    }

    @Test
    @Ignore
    public void browserIsStartedTest(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //options.addArguments("--headless"); //chrom jest tylko w pamięci, nie widać go

        WebDriver driver = new ChromeDriver(options);

        driver.get("http://automationpractice.com/");

//        List<WebElement> listaElementow = driver.findElements(By.cssSelector("takiego_nie_ma"));
//        // ten nie da wyjątku, czyli możemy znaleźć listę i jeśli jest niepusta, to coś robimy
//        WebElement element = driver.findElement(By.cssSelector("takiego_nie_ma"));
//        // ten da wyjątek

        // kliknąć contact us
        driver.findElement(By.id("contact-link")).click();
        driver.findElements(By.id("contact-link"));
        //czy się wyświetliło?
        Assert.assertTrue(driver.findElement(By.cssSelector("#submitMessage")).isDisplayed());
        // tutaj też można sprawdzić, czy

        // wysłać formularz
        Select select = new Select(driver.findElement(By.id("id_contact")));
        select.selectByValue("2");  //value widać w htmlu

        driver.findElement(By.id("email")).sendKeys("a@b.com");
        driver.findElement(By.id("id_order")).sendKeys("Order no. 1");
        driver.findElement(By.id("message")).sendKeys("This is my message about my order");
        driver.findElement(By.id("fileUpload")).sendKeys("C:\\Users\\A690028\\IdeaProjects\\Automatyzacja032021\\kacp3rAutomatyzacja032021\\src\\test\\java\\Day2\\szkolenie java selenium dzien2.txt");

        driver.findElement(By.id("submitMessage")).click();

        WebDriverWait wait = new WebDriverWait(driver, 0);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert-success")));
        // the full class field is "alert alert-success" this is two classes, so we search for one
        // looks like this wait is not actually needed

        //Assert.assertTrue(driver.findElement(By.xpath("//p[text()=\"Your message has been successfully sent to our team.\"]")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.cssSelector(".alert.alert-success")).isDisplayed());
        // better to look for it by class, it actually has two classes


        // driver.close();
        //driver.quit();
    }

    @Test
    @Ignore
    public void waitingTest(){

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // czekanie domniemane - webdriver zaczyna szukać kiedy przeglądarka podnosi flagę ready
        // ale czasem elementy się jeszcze doładują - ile jeszcze czasu dać selenium po fladze ready na szukanie
        // on czeka tylko na findElemen - on w ogóle nie jest super, mało się przydaje

        driver.get("https://swiatroweru.com.pl/warsztat/seminariumStronka/");

        WebElement guzik = driver.findElement(By.cssSelector("[data-section]+section button"));

        WebDriverWait wait = new WebDriverWait(driver, 10);
        // ten jest mocny i przydatny
        wait.until(ExpectedConditions.elementToBeClickable(guzik));

        guzik.click();
        Assert.assertTrue(driver.findElement(By.tagName("img")).isDisplayed());
    }

    @Test
    @Ignore
    public void testAlertow(){
        driver.get("https://swiatroweru.com.pl/warsztat/seminariumStronka/");

        WebElement guzikS3 = driver.findElement(By.cssSelector("[data-section] button"));
        guzikS3.click();

        Alert alert = driver.switchTo().alert();
        // jeśli istnieje javascriptowy alert, przełączamy się na niego
        alert.dismiss(); //.accept()

        // Asercja na istnienie tego dziwnego wiersza, który
        Assert.assertTrue(driver.findElement(By.className("row")).isDisplayed());
        System.out.println("thing");
    }

    // tu może być wrapper wait and click

    @Test
    public void dragAndDropTest(){
        //given
        driver.get("https://www.seleniumeasy.com/test/drag-and-drop-demo.html");
        Actions actions = new Actions(driver);
        WebElement draggable1 = driver.findElement(By.cssSelector("#todrag>span:nth-of-type(1)"));
        WebElement dropArea = driver.findElement(By.id("mydropzone"));

        //when
        actions.dragAndDrop(draggable1, dropArea).build().perform();
        //then
        // asercja na droplist span
        System.out.println("thing");
        Assert.assertTrue(true);

        // ok, więc na tej stronie to nie zadziała, bo jest zjebana pozycja myszy
        // ale tutaj będzie działać: http://demo.guru99.com/test/drag_drop.html
    }
}
