package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderSectionPage {
    WebDriver driver;
    WebDriverWait wait;
    By logo = By.className("website-logo");
    By homeLink = By.linkText("Home");
    By popularLink = By.linkText("Popular");
    By search = By.className("search-empty-button");
    By searchButton = By.className("search-button");
    By accountLink = By.className("avatar-button");
    By Searchinputfield = By.className("search-input-field");
    public HeaderSectionPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
    public boolean isLogoDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(logo));
        return driver.findElement(logo).isDisplayed();
    }
    public boolean isHomeDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeLink));
        return driver.findElement(homeLink).isDisplayed();
    }
    public boolean isPopularDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularLink));
        return driver.findElement(popularLink).isDisplayed();
    }
    public boolean isSearchDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(search));
        return driver.findElement(search).isDisplayed();
    }
    public boolean isAccountDisplayed() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountLink));
        return driver.findElement(accountLink).isDisplayed();
    }
    public void navigateToHome() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeLink));
        driver.findElement(homeLink).click();
    }
    public void navigateToPopular() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(popularLink));
        driver.findElement(popularLink).click();
    }
    public void searchClick() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(search));
        driver.findElement(search).click();
    }
    public void enterSearchText(String searchText) {
        WebElement searchInput = wait.until(ExpectedConditions.visibilityOfElementLocated(Searchinputfield));
        searchInput.sendKeys("Venom");
        wait.until(ExpectedConditions.visibilityOfElementLocated(searchButton)).click();
    }
    public void navigateToAccount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountLink));
        driver.findElement(accountLink).click();
    }
}
