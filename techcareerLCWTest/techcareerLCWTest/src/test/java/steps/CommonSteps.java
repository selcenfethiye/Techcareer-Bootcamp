package steps;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.testng.Assert;
import pages.BasketPage;
import pages.CategoryPage;
import pages.HomePage;
import pages.ProductPage;

public class CommonSteps {
    public static final Logger LOGGER = Logger.getLogger(CommonSteps.class.getName());
    HomePage homePage = new HomePage();
    CategoryPage categoryPage = new CategoryPage();
    ProductPage productPage = new ProductPage();
    BasketPage basketPage = new BasketPage();

    @Given("I open home page")
    public void homePageIsOpened() {
        BaseTest.getTheDriverAndGoHomePage();
    }

    @Given("I close popup if exist")
    public void closePopup() {
        homePage.closeIfExistPopup();
        LOGGER.info("Campaign popup is closed");
    }

    @Given("I close driver")
    public void closeDriver() {
        BaseTest.closeDriver();
    }

    @Given("I see {string} as page title")
    public void isHomePageDisplayed(String title) {
        Assert.assertTrue(homePage.isHomePageOpened(title), "Home Page is not opened");
        LOGGER.info("Home Page is opened");
    }

    @When("I go shoes category page")
    public void goShoesPage() {
        homePage.moveMouseToShoesCategory();
        homePage.clickManCategory();
    }

    @When("I click the searchbar")
    public void clickTheSearchBar() {
        homePage.moveMouseToSearchBar();
        homePage.clickSearchBar();
    }

    @When("I type {string} in the search bar")
    public void typeTheSearchBar(String type) {
        homePage.typeSearchBar(type);
    }

    @When("I go product page")
    public void shoesPageIsDisplayed() {
        categoryPage.clickFirstProduct();
    }

    @Given("I see {string} as page URL for {string}")
    public void shoesPageURL(String url, String page) {
        Assert.assertTrue(categoryPage.isCategoryPageOpened(url), page +"Page is not opened");
        LOGGER.info(page + "Page is opened");
    }
    @Given("I see {string} as first suggestion")
    public void see(String suggestion) {
        Assert.assertEquals(homePage.firstSuggestion().toLowerCase(), suggestion.toLowerCase());
        LOGGER.info( suggestion + "seen");
    }

    @Given("I go basket page")
    public void basketPageIsDisplayed() {
        productPage.selectSize();
        productPage.clickAddToCartButton();
        productPage.clickCartPageButton();
    }

    @Given("I go home page")
    public void homePageIsDisplayedAgain() {
        BaseTest.goHomePage();
    }


}
