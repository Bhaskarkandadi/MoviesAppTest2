import Pages.MovieDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import Pages.LoginPage;

public class MovieDetailsPageTest {
    WebDriver driver;
    WebDriverWait wait;
    MovieDetailsPage movieDetailsPage;
    LoginPage loginpage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        movieDetailsPage = new MovieDetailsPage(driver, wait);
        loginpage = new LoginPage(driver, wait);
        driver.get("https://qamoviesapp.ccbp.tech");
        loginpage.login("rahul", "rahul@2021");
    }
    @Test(priority = 1)
    public void testMovieDetailsPageFromHomePage() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='link-item']"))).click();
        Assert.assertTrue(movieDetailsPage.isMovieTitleDisplayed(), "Movie title is not displayed.");
        Assert.assertTrue(movieDetailsPage.isMovieImageDisplayed(), "Movie image is not displayed.");
        Assert.assertTrue(movieDetailsPage.isWatchtimeDisplayed(), "Movie watch time is not displayed.");
        Assert.assertTrue(movieDetailsPage.isSensorRatingDisplayed(), "Movie sensor rating is not displayed.");
        Assert.assertTrue(movieDetailsPage.isReleaseYearDisplayed(), "Movie release year is not displayed.");
        Assert.assertTrue(movieDetailsPage.isMovieOverviewDisplayed(), "Movie overview is not displayed.");
        Assert.assertTrue(movieDetailsPage.isPlayButtonDisplayed(), "Movie play button is not displayed.");
    }

    @Test(priority = 2)
    public void testMovieDetailsPageFromPopularPage() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Popular"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='link-item']"))).click();
        Assert.assertTrue(movieDetailsPage.isMovieTitleDisplayed(), "Movie title is not displayed.");
        Assert.assertTrue(movieDetailsPage.isMovieImageDisplayed(), "Movie image is not displayed.");
        Assert.assertTrue(movieDetailsPage.isWatchtimeDisplayed(), "Movie watch time is not displayed.");
        Assert.assertTrue(movieDetailsPage.isSensorRatingDisplayed(), "Movie sensor rating is not displayed.");
        Assert.assertTrue(movieDetailsPage.isReleaseYearDisplayed(), "Movie release year is not displayed.");
        Assert.assertTrue(movieDetailsPage.isMovieOverviewDisplayed(), "Movie overview is not displayed.");
        Assert.assertTrue(movieDetailsPage.isPlayButtonDisplayed(), "Movie play button is not displayed.");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
