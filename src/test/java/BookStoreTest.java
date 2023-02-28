import configurations.ConfigurationConstants;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BooksPage;
import pages.LoginPage;
import pojo.Book;
import utils.apiutils.ApiDemoQaMethods;

import java.util.ArrayList;
import java.util.List;

public class BookStoreTest extends BaseTest {
    
    private List<String> uiBookTitles = new ArrayList<>();
    private List<Book> apiBookData = new ArrayList<>();
    
    @Test
    public void testCase1() {
        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnBtnLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendUserName(getTestData(ConfigurationConstants.KEY_USER_NAME));
        loginPage.sendUserPassword(getTestData(ConfigurationConstants.KEY_USER_PASSWORD));
        loginPage.clickOnBtnLogin();
        Assert.assertEquals(booksPage.getRegisteredUserName(), 
                getTestData(ConfigurationConstants.KEY_USER_NAME),
                String.format("The registered username should be %s",
                        getTestData(ConfigurationConstants.KEY_USER_NAME)));
    }

    @Test(groups = "api_test")
    public void testCase2() {
        BooksPage booksPage = new BooksPage(driver);
        uiBookTitles = booksPage.getUiBookTitles();
        apiBookData = ApiDemoQaMethods.getBooks(Book.class);
        for (int i = 0; i < uiBookTitles.size(); i++) {
            Assert.assertEquals(uiBookTitles.get(i),
                    apiBookData.get(i).getTitle(), String.format(
                            "Title of UI test (%s) and title of API test (%s) should match",
                            uiBookTitles.get(i), apiBookData.get(i).getTitle()));
        }
    }
}
