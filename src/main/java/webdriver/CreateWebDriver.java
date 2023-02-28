package webdriver;

import org.openqa.selenium.WebDriver;

public class CreateWebDriver {
    
    private static WebDriver driver;

    private CreateWebDriver() {
    }

    public static WebDriver getDriver(String nameOfBrowser) {
        if (driver == null) {
            driver = BrowserFactory.getBrowser(nameOfBrowser);
        }
        return driver;
    }

    public static void quitDriver() {
        driver.quit();
        driver = null;
    }
}
