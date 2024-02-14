import Pages.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;

import java.time.Duration;

public class SearchPageTest {
    WebDriver driver;
    WebDriverWait wait;
    SearchPage searchPage;
    LoginPage loginpage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        searchPage = new SearchPage(driver, wait);
        loginpage = new LoginPage(driver, wait);
        driver.get("https://qamoviesapp.ccbp.tech");
        loginpage.login("rahul","rahul@2021");
    }
    @Test
    public void testSearchFunctionality() {
        searchPage.searchMovie("Venom");
        Assert.assertTrue(searchPage.areSearchResultsDisplayed(), "Search results are not displayed.");
        int moviesCount = searchPage.getSearchResultsCount();
        System.out.println(moviesCount);
        Assert.assertTrue(moviesCount > 0, "No movies are displayed in the search results.");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
