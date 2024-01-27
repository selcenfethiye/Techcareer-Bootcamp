package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.PropReader;

import java.time.Duration;

public class BaseTest {
    protected static WebDriver driver;
    protected static JavascriptExecutor javascriptExecutor;
    protected static WebDriverWait wait;
    protected static Actions actions;

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (PropReader.getProperty("browser")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            //Settings for the test to work better(maximize window and wait elements to load)
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

            wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            javascriptExecutor = (JavascriptExecutor) driver;

            actions = new Actions(driver);
        }
        return driver;
    }

    public static void getTheDriverAndGoHomePage() {
        BaseTest.getDriver().get(PropReader.getProperty("homePageUrl"));
    }


    public static void goHomePage() {
        driver.get(PropReader.getProperty("homePageUrl"));
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }
}
