import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HeaderSectionPage;
import Pages.LoginPage;
import java.time.Duration;
import static org.testng.Assert.assertTrue;

public class HeaderSectionTest {
    WebDriver driver;
    WebDriverWait wait;
    HeaderSectionPage headerSection;
    LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        headerSection = new HeaderSectionPage(driver, wait);
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage.login("rahul", "rahul@2021");
    }

    @Test(priority = 1)
    public void testLogoisDisplyed() {
        assertTrue(headerSection.isLogoDisplayed(), "Logo is not displayed");
    }

    @Test(priority = 2)
    public void testHomeisDisplayed() {
        assertTrue(headerSection.isHomeDisplayed(), "Home is not displayed");
    }

    @Test(priority = 3)
    public void testPopularisDisplayed() {
        assertTrue(headerSection.isPopularDisplayed(), "Popular is not displayed");
    }
    @Test(priority = 4)
    public void testisSearchDisplayed() {
        assertTrue(headerSection.isSearchDisplayed(), "Search Icon is not displayed");
    }

    @Test(priority = 5)
    public void testAccountDisplayed() {
        assertTrue(headerSection.isAccountDisplayed(), "Account Icon is not displayed");
    }


    @Test(priority = 6)
    public void navigatetohomeFunctionality() throws InterruptedException {
        headerSection.navigateToHome();
        Thread.sleep(2000);
        String expectedUrlHome = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedUrlHome));
        String currentUrlHome = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlHome, expectedUrlHome, "Home Element not working");
    }

    @Test(priority = 7)
    public void navigatetoPopularFunctionality() throws InterruptedException {
        headerSection.navigateToPopular();
        Thread.sleep(2000);
        String expectedUrlPopular = "https://qamoviesapp.ccbp.tech/popular";
        wait.until(ExpectedConditions.urlToBe(expectedUrlPopular));
        String currentUrlPopular = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlPopular, expectedUrlPopular, "Popular Element not working");
    }

    @Test(priority = 8)
    public void SearchFunctionality() throws InterruptedException {
        headerSection.searchClick();
        headerSection.enterSearchText("Venom");
        Thread.sleep(2000);

    }

    @Test(priority = 9)
    public void navigatetoAccountFunctionality() throws InterruptedException {
        headerSection.navigateToAccount();
        Thread.sleep(2000);
        String expectedUrlAccount = "https://qamoviesapp.ccbp.tech/account";
        wait.until(ExpectedConditions.urlToBe(expectedUrlAccount));
        String currentUrlAccount = driver.getCurrentUrl();
        Assert.assertEquals(currentUrlAccount, expectedUrlAccount, "Account Element not working");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
