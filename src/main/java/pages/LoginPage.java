package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final String TXB_USER_NAME = "//input[@id = 'userName']";
    private static final String TXB_USER_PASSWORD = "//input[@id = 'password']";
    private static final String SCROLL_TO_BNT_LOGIN = "//div[@class = 'left-pannel']";
    private static final String BTN_LOGIN = "//button[@id='login']";
    
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    
    public void sendUserName(String userName) {
        driver.findElement(By.xpath(TXB_USER_NAME)).sendKeys(userName);
    }

    public void sendUserPassword(String userPassword) {
        driver.findElement(By.xpath(TXB_USER_PASSWORD)).sendKeys(userPassword);
    }

    public void clickOnBtnLogin() {
          scrollElementIntoView(SCROLL_TO_BNT_LOGIN);
          driver.findElement(By.xpath(BTN_LOGIN)).click();
    }
}
