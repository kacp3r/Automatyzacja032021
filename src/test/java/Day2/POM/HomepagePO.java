package Day2.POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class HomepagePO extends BasePO {
    Logger logger = Logger.getLogger(HomepagePO.class);

    @FindBy(css = ".logo")
    private WebElement logo;
    // page factory daje to, że elementy są inicjalizowane, ale przeszukiwanie dopiero przy użyciu

    @FindBy(css = "a[title=\"Women\"]")
    private WebElement womenCategory;

    @FindBy(css = "[title=\"Blouses\"]")
    private WebElement blousesInWomen;

    @FindBy(xpath = "//a[@title='Dresses'][1]")
    private WebElement womenCategoryDisplayed;

    @FindBy(css = "#homefeatured .product-container")
    private List<WebElement> allFeaturedProducts;

    private List<ProductMiniaturePO> getProductMiniatures(){
        List<ProductMiniaturePO> list = new ArrayList<>();
        for (WebElement e: allFeaturedProducts) {
            list.add(new ProductMiniaturePO(e, driver));
        }
        return list;
    }

    public double getNthPrice(int n){
        return getProductMiniatures().get(n-1).getPrice();
    }

    private String myurl = "http://automationpractice.com/index.php";

    public HomepagePO(WebDriver driver) {  //domyślny konstruktor, odwołujący się do abstrakta
        super(driver);
    }

    public HomepagePO openMe(){
        logger.trace("Will attempt to open page " + myurl);
        driver.get(myurl);
        logger.trace("Finished trying to open page " + myurl);
        return this;
    }

    public boolean isDisplayed(){      // czy strona jest wyświetlona
        logger.trace("Looking for object logo, which would mean that the page is open.");
        if (logo.isDisplayed()) {
            logger.debug("We found the logo object, which means that the page is displayed");
        }
        return logo.isDisplayed();
    }

    public HomepagePO hoverOverWomenCategory(){
        logger.trace("Will try to move to " + womenCategory.getText());
        actions.moveToElement(womenCategory).build().perform();
        logger.trace("Hovered over element" + womenCategory.getText());
        logger.trace("Will wait for visibility of " + womenCategoryDisplayed.getText());
        wait.until(ExpectedConditions.visibilityOf(womenCategoryDisplayed));
        logger.info("Opened Women Top Menu");
        return this;
    }

    public boolean blousesDisplayed(){
        return blousesInWomen.isDisplayed();  //lepiej byłoby to zrobić po całym kontenerze menu
    }

    public boolean womenCategoryDisplayed(){
        logger.trace("Looking for women category top menu.");
        if (womenCategoryDisplayed.isDisplayed()) {
            logger.debug("We found the women category top menu displayed");
        }
        return womenCategoryDisplayed.isDisplayed();  //lepiej byłoby to zrobić po całym kontenerze menu
    }
}
