import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.HomePage;
import java.time.Duration;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HomePageTest {
    WebDriver driver;
    HomePage homePage;
    WebDriverWait wait;
    LoginPage loginpage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        homePage = new HomePage(driver, wait);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginpage = new LoginPage(driver, wait);
        driver.get("https://qamoviesapp.ccbp.tech");
        loginpage.login("rahul","rahul@2021");
    }

    @Test(priority = 1)
    public void testHeadingText() {
        assertEquals(homePage.getHeadingTextInSection1(), "Trending Now");
        assertEquals(homePage.getHeadingTextInSection2(), "Originals");
    }

    @Test(priority = 2)
    public void testPlayButtonDisplayed() {
        assertTrue(homePage.isPlayButtonDisplayed());
    }

    @Test(priority = 3)
    public void testMoviesDisplayed() {
        assertTrue(homePage.areMoviesDisplayed());
    }

    @Test(priority = 4)
    public void testContactUsSectionDisplayed() {
        assertTrue(homePage.isContactUsSectionDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
