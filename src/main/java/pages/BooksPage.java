package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BooksPage extends BasePage {
    
    private static final String BTN_LOGIN = "//button[@id='login']";
    private static final String SCROLL_TO_BNT_LOGIN = "//div[@class='rt-tbody']";
    private static final String LBL_USER_NAME = "//label[@id='userName-value']";
    private static final String LINK_TITLE = "//div[@class='action-buttons']";
    
    public BooksPage(WebDriver driver) {
        super(driver);
    }
    
    public void clickOnBtnLogin() {
        scrollElementIntoView(SCROLL_TO_BNT_LOGIN);
        driver.findElement(By.xpath(BTN_LOGIN)).click();
    }

    public String getRegisteredUserName() {
        scrollElementIntoView(SCROLL_TO_BNT_LOGIN);
        return driver.findElement(By.xpath(LBL_USER_NAME)).getText();
    }
    
    public List<String> getUiBookTitles() {
        List<WebElement> webElements = driver.findElements(By.xpath(LINK_TITLE));
        List<String> bookTitles = new ArrayList<>();
        for (int i = 0;i < webElements.size(); i++) {
            bookTitles.add(webElements.get(i).getText());
        }
        return bookTitles;
    }
}
