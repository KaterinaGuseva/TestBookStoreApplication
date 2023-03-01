import configurations.ConfigurationConstants;
import configurations.TestConfiguration;
import io.restassured.RestAssured;
import logger.MyLogger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeMethod;
import utils.apiutils.Specifications;
import webdriver.CreateWebDriver;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    private TestConfiguration testData =
            new TestConfiguration(ConfigurationConstants.TEST_DATA_FILE_PATH);
    private TestConfiguration testConfig =
            new TestConfiguration(ConfigurationConstants.TEST_CONFIGURATION_FILE_PATH);
    
    public String getTestData(String jsonKeyName) {
        return testData.getTestConfiguration(jsonKeyName);
    }
    
    public String getTestConfig(String jsonKeyName) {
        return  testConfig.getTestConfiguration(jsonKeyName);
    }
    
    @BeforeMethod
    public void setUp() {
        MyLogger.getMyLogger().info( "Create Driver");
        driver = CreateWebDriver.getDriver(getTestConfig(ConfigurationConstants.KEY_BROWSER));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        MyLogger.getMyLogger().info( "Open Main Page");
        driver.get(getTestData(ConfigurationConstants.KEY_URL));
    }

    @BeforeGroups("api_test")
    public void setUpRequestSpecification() {
        RestAssured.requestSpecification = Specifications.requestSpecification(
                getTestData(ConfigurationConstants.KEY_API_URL));
    }
    
    @AfterMethod
    public void tearDown() {
        MyLogger.getMyLogger().info( "Close Driver");
        CreateWebDriver.quitDriver();
    }
}
