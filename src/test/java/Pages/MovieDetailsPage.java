package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MovieDetailsPage {
    WebDriver driver;
    WebDriverWait wait;
    By movieTitle = By.xpath("//h1[@class='movie-title']");
    By movieImage = By.className("medium-screen-movie-container");
    By watchtime = By.className("watch-time");
    By sensorrating = By.className("sensor-rating");
    By releaseyear = By.className("release-year");
    By movieoverview = By.className("movie-overview");
    By playbutton = By.className("play-button");
    public MovieDetailsPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public boolean isMovieTitleDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieTitle));
        return driver.findElement(movieTitle).isDisplayed();
    }
    public boolean isMovieImageDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieImage));
        return driver.findElement(movieImage).isDisplayed();
    }
    public boolean isWatchtimeDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(watchtime));
        return driver.findElement(watchtime).isDisplayed();
    }
    public boolean isSensorRatingDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(sensorrating));
        return driver.findElement(sensorrating).isDisplayed();
    }
    public boolean isReleaseYearDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(releaseyear));
        return driver.findElement(releaseyear).isDisplayed();
    }
    public boolean isMovieOverviewDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(movieoverview));
        return driver.findElement(movieoverview).isDisplayed();
    }
    public boolean isPlayButtonDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playbutton));
        return driver.findElement(playbutton).isDisplayed();
    }
}

