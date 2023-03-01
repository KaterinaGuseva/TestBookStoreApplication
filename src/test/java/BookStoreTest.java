import configurations.ConfigurationConstants;
import logger.MyLogger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BooksPage;
import pages.LoginPage;
import pojo.Book;
import utils.apiutils.ApiDemoQaMethods;
import utils.apiutils.ApiQueryParameters;

import java.util.ArrayList;
import java.util.List;

public class BookStoreTest extends BaseTest {
    
    private List<String> uiBookTitles = new ArrayList<>();
    private List<Book> apiBookData = new ArrayList<>();
    
    @Test
    public void checkUiUserSingInCorrectData() {
        MyLogger.getMyLogger().info( "Sing up the test user from API method");
        ApiDemoQaMethods.signUpUser(ApiQueryParameters.getMapParamsSignUpUser(
                getTestData(ConfigurationConstants.KEY_USER_SIGN_UP_NAME), 
                getTestData(ConfigurationConstants.KEY_USER_SIGN_UP_PASSWORD)));
        MyLogger.getMyLogger().info( "Sing in the test user");
        BooksPage booksPage = new BooksPage(driver);
        booksPage.clickOnBtnLogin();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.sendUserName(getTestData(ConfigurationConstants.KEY_USER_SIGN_IN_NAME));
        loginPage.sendUserPassword(getTestData(ConfigurationConstants.KEY_USER_SIGN_IN_PASSWORD));
        loginPage.clickOnBtnLogin();
        MyLogger.getMyLogger().info( "Verify that user able to login");
        Assert.assertEquals(booksPage.getSignInUserName(), 
                getTestData(ConfigurationConstants.KEY_USER_SIGN_IN_NAME),
                String.format("The login username should be %s",
                        getTestData(ConfigurationConstants.KEY_USER_SIGN_IN_NAME)));
    }
    
    @Test(groups = "api_test")
    public void checkApiUiBookTitles() {
        BooksPage booksPage = new BooksPage(driver);
        uiBookTitles = booksPage.getUiBookTitles();
        apiBookData = ApiDemoQaMethods.getBooks(Book.class);
        MyLogger.getMyLogger().info( "Verify that number of books " +
                "from page and API response are matching");
        Assert.assertEquals(uiBookTitles.size(), apiBookData.size(), 
                "Number of books getting from books page and API response should match");
        MyLogger.getMyLogger().info( "Verify that title of books " +
                "from Ui books page and API response are matching");
        for (int i = 0; i < uiBookTitles.size(); i++) {
            Assert.assertEquals(uiBookTitles.get(i),
                    apiBookData.get(i).getTitle(), String.format(
                            "Title of books getting from books page (%s)" +
                                    " and title of books getting from API response (%s) should match",
                            uiBookTitles.get(i), apiBookData.get(i).getTitle()));
        }
    }
}
