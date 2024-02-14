import Pages.PopularPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.LoginPage;
import java.time.Duration;

public class PopularPageTest {
    WebDriver driver;
    WebDriverWait wait;
    PopularPage popularPage;
    LoginPage loginpage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        popularPage = new PopularPage(driver, wait);
        loginpage = new LoginPage(driver, wait);
        driver.get("https://qamoviesapp.ccbp.tech/popular");
        loginpage.login("rahul","rahul@2021");
    }
    @Test(priority = 1)
    public void testMoviesAreDisplayed() {
        Assert.assertTrue(popularPage.getMoviesCount() > 0, "No movies are displayed on the Popular page");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
