package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class BasePage {

    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollElementIntoView(String elementLocator) {
        JavascriptExecutor executor= (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].scrollIntoView(false);",driver.findElement(By.xpath(elementLocator)));
    }
}
