package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PopularPage {
    WebDriver driver;
    WebDriverWait wait;
    By moviesList = By.className("movie-image");
    By popularlink = By.linkText("Popular");

    public PopularPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public int getMoviesCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularlink)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(moviesList));
        return driver.findElements(moviesList).size();
    }
}
