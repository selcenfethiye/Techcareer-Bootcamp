package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseTest;

public class HomePage extends BaseTest {

    @FindBy(xpath = "(//a[text()='ERKEK'])[2]")
    public WebElement manCategory;
    @FindBy(xpath = "//a[text()='Ayakkabı']")
    public WebElement shoesHeaderMenuButton;

    @FindBy(xpath = "//div[contains(@class, 'ins-coupon-close-text')]")
    public WebElement closePopupButton;

    @FindBy(id = "search-form__input-field__search-input")
    public WebElement searchBar;

    @FindBy(xpath = "//ul[@class='advanced-result-list advanced-result-list--suggestions-container'][1]/li[1]/a")
    public WebElement firstSuggestion;

    public HomePage() {
        PageFactory.initElements(BaseTest.getDriver(), this);
    }


    public void moveMouseToShoesCategory() {
        actions.moveToElement(shoesHeaderMenuButton).perform();
    }
    public void moveMouseToSearchBar() {
        actions.moveToElement(searchBar).perform();
    }
    public void clickManCategory() {
        manCategory.click();
    }
    public void clickSearchBar() {
        searchBar.click();
    }
    public void typeSearchBar(String type) {
        searchBar.sendKeys(type);
    }
    public void closeIfExistPopup() {
        if(closePopupButton.isDisplayed())
            closePopupButton.click();
    }
    public boolean isHomePageOpened(String title) {
        return  driver.getTitle().contains(title);
    }
    public String firstSuggestion() {
        return  firstSuggestion.getText();
    }
}




