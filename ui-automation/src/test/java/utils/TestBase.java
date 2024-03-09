package utils;

import com.neetgramming.utils.BrowserUtils;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.util.logging.Logger;

public class TestBase extends BrowserUtils {
    private static final String BASE_URL = "https://www.saucedemo.com/";
    private static final Logger log = Logger.getLogger(String.valueOf(TestBase.class));
    protected static WebDriver driver;

    @Parameters("browserName")
    @BeforeTest(groups = {"single", "parallel"})
    public void browserSetup(@Optional String browserName) {
        log.info("setting up browser & navigating to " + BASE_URL);
        driver = setupDefaultChromeBrowser(browserName);
        goToBaseURL(driver, BASE_URL);
    }

    @AfterTest(groups = {"single", "parallel"})
    public void quitBrowser() {
        log.info("quitting browser");
        quitBrowser(driver);
    }
}