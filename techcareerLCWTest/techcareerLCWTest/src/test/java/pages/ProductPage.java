package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseTest;


public class ProductPage extends BaseTest {

    @FindBy(xpath = "(//a[@data-stock>'0'])[1]")
    public WebElement sizeButton;
    @FindBy(css = "a.add-to-cart.button-link")
    public WebElement addToCartButton;
    @FindBy(xpath = "//a[.='Sepetim1']")
    public WebElement cartPageButton;

    public ProductPage() {
        PageFactory.initElements(BaseTest.getDriver(), this);
    }

    public void selectSize() {
        javascriptExecutor.executeScript("arguments[0].click();", sizeButton);
    }

    public void clickAddToCartButton() {
        javascriptExecutor.executeScript("arguments[0].click();", addToCartButton);
    }

    public void clickCartPageButton() {
        cartPageButton.click();
    }

    public boolean isProductPageOpened() {
        return driver.getCurrentUrl().contains("https://www.lcwaikiki.com/tr-TR/TR/urun/");
    }
}
