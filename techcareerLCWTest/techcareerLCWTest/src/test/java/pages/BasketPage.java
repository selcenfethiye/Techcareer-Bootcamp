package pages;

import org.openqa.selenium.support.PageFactory;
import base.BaseTest;

import java.util.Objects;

public class BasketPage extends BaseTest {

    public BasketPage() {
        PageFactory.initElements(BaseTest.getDriver(), this);
    }

    public boolean isBasketPageOpened() {
        return Objects.equals(driver.getCurrentUrl(), "https://www.lcwaikiki.com/tr-TR/TR/sepetim");
    }
}
