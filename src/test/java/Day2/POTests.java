package Day2;

import Day2.POM.HomepagePO;
import org.testng.Assert;
import org.testng.annotations.Test;

public class POTests extends BaseTest{

    @Test
    public void firstPOTest(){
        //given
        HomepagePO homepagePO = new HomepagePO(driver);

        //when
        homepagePO.openMe();

        //then
        Assert.assertTrue(homepagePO.isDisplayed());
    }

    @Test
    public void displayWomenCategoryTest(){
        //given
        HomepagePO homepagePO = new HomepagePO(driver);

        //when
        homepagePO.openMe()
                  .hoverOverWomenCategory();


        //then
        Assert.assertTrue(homepagePO.womenCategoryDisplayed());
    }

    @Test
    public void priceOfFirstProductTest(){
        //given
        HomepagePO homepagePO = new HomepagePO(driver);
        double expectedPrice = 16.51;

        //when
        double result = homepagePO.openMe().getNthPrice(1);

        //then
        Assert.assertEquals(result, expectedPrice);
    }
}
