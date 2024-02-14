package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;
    By headingSection1 = By.xpath("//div[@class='home-bottom-container']/div[1]/h1");
    By headingSection2 = By.xpath("//div[@class='home-bottom-container']/div[2]/h1");
    By playButton = By.className("home-movie-play-button");
    By moviesSection = By.className("slick-slide");
    By contactUsSection = By.className("footer-container");

    public HomePage(WebDriver driver,WebDriverWait wait) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getHeadingTextInSection1() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headingSection1)).getText();
    }

    public String getHeadingTextInSection2() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headingSection2)).getText();
    }

    public boolean isPlayButtonDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playButton));
        return driver.findElement(playButton).isDisplayed();
    }

    public boolean areMoviesDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(moviesSection)).isDisplayed();
    }

    public boolean isContactUsSectionDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(contactUsSection)).isDisplayed();
    }
}
