package webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class BrowserFactory {

    private static WebDriver driver;

    public static WebDriver getBrowser(String browserName) {
        switch (browserName) {
            case "CHROME":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().maximize();
                break;
            case "FIREFOX":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments("-kiosk");
                driver = new FirefoxDriver(firefoxOptions);   
                break;
            case "IEXPLORER":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
                break;
            case "SAFARI":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            default:
                throw new IllegalArgumentException(String.format("Browser %s is not supported.",
                        browserName));
        }
        return driver;
    }
}
