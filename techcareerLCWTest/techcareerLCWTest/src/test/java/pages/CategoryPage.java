package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseTest;

import java.util.Objects;

public class CategoryPage extends BaseTest {

    @FindBy(xpath = "(//div[@class='product-card product-card--one-of-4'])[1]")
    public WebElement firstProduct;

    public CategoryPage() {
        PageFactory.initElements(BaseTest.getDriver(), this);
    }

    public void clickFirstProduct() {
        firstProduct.click();
    }

    public boolean isCategoryPageOpened(String url) {
        return driver.getCurrentUrl().contains(url);
    }
}
