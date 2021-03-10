package Day2.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;

// To jest piękna klasa dla podelementu strony - tutaj to są takie małe kontenery na produkty na liście
public class ProductMiniaturePO {
    WebDriver driver;

    @FindBy(css = ".ajax_add_to_cart_button")
    private WebElement addToCartButton;

    @FindBy(css = ".right-block [itemprop=\"price\"]")
    private WebElement price;

    @FindBy(css = ".priduct-name")
    private WebElement productName;

    public double getPrice(){
        return Double.parseDouble(price.getText().replace("$", "").replace(" ", ""));
    }

    public String getProductName() {
        return productName.getText();
    }

    public void addToCart(){
        Actions actions = new Actions(driver);
        actions.moveToElement(productName);
        addToCartButton.click();
    }

    public ProductMiniaturePO(WebElement productContainer, WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(new DefaultElementLocatorFactory(productContainer), this);
    }
}
