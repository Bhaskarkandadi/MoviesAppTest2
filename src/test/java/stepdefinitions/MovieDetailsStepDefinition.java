package stepdefinitions;
import Pages.LoginPage;
import Pages.MovieDetailsPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class MovieDetailsStepDefinition {

    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginpage;
    MovieDetailsPage movieDetailsPage;

    @Before
    public void Setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        movieDetailsPage = new MovieDetailsPage(driver, wait);
        loginpage = new LoginPage(driver, wait);
        driver.get("https://qamoviesapp.ccbp.tech/login");
        loginpage.login("rahul","rahul@2021");
    }
    @Given("the user is on homepage")
    public void loginUser() {
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl, "URLs don't match");
    }
    @When("the user clicks on a movie link from the Home Page")
    public void clickOnMovieLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='link-item']"))).click();
    }
    @Then("the movie title is displayed")
    public void verifyMovieTitle() {
        Assert.assertTrue(movieDetailsPage.isMovieTitleDisplayed(), "Movie title is not displayed.");
    }
    @And("the movie image is displayed")
    public void verifyMovieImage() {
        Assert.assertTrue(movieDetailsPage.isMovieImageDisplayed(), "Movie image is not displayed.");
    }
    @And("the movie watch time is displayed")
    public void verifyMovieWatchTime() {
        Assert.assertTrue(movieDetailsPage.isWatchtimeDisplayed(), "Movie watch time is not displayed.");
    }
    @And("the movie sensor rating is displayed")
    public void verifyMovieSensorRating() {
        Assert.assertTrue(movieDetailsPage.isSensorRatingDisplayed(), "Movie sensor rating is not displayed.");
    }
    @And("the movie release year is displayed")
    public void verifyMovieReleaseYear() {
        Assert.assertTrue(movieDetailsPage.isReleaseYearDisplayed(), "Movie release year is not displayed.");
    }
    @And("the movie overview is displayed")
    public void verifyMovieOverview() {
        Assert.assertTrue(movieDetailsPage.isMovieOverviewDisplayed(), "Movie overview is not displayed.");
    }
    @And("the play button is displayed")
    public void verifyMoviePlayButton() {
        Assert.assertTrue(movieDetailsPage.isPlayButtonDisplayed(), "Movie play button is not displayed.");
    }
    @When("the user clicks on the {string} link")
    public void clickOnPopularLink(String linkText) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText(linkText))).click();
    }
    @And("clicks on a movie link")
    public void clickOnPopularMovieLink() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='link-item']"))).click();
    }
    @After
    public void teardown() {
        driver.quit();
    }
}
