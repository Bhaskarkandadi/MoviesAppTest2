package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;
    By searchempty = By.className("search-empty-button");
    By searchInput = By.className("search-input-field");
    By searchButton = By.className("search-button");
    By searchResults = By.className("movie-image");
    public SearchPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public void searchMovie(String movieName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchempty));
        driver.findElement(searchempty).click();
        WebElement searchInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInput));
        searchInputField.sendKeys(movieName);
        driver.findElement(searchButton).click();
    }
    public boolean areSearchResultsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(searchResults)).isDisplayed();
    }
    public int getSearchResultsCount() {
        List<WebElement> results = driver.findElements(searchResults);
        return results.size();
    }
}
