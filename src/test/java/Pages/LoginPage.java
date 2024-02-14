package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By logoImage = By.className("login-website-logo");
    By headingText = By.className("sign-in-heading");
    By usernameLabel = By.xpath("//div[@class = 'login-form-container']//form//div[1]/label");
    By passwordLabel = By.xpath("//div[@class = 'login-form-container']//form//div[2]/label");
    By loginButton = By.className("login-button");
    By usernameInput = By.id("usernameInput");
    By passwordInput = By.id("passwordInput");

    private By errorMessage = By.className("error-message");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isLogoImageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoImage)).isDisplayed();
    }

    public String getHeadingText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(headingText)).getText();
    }

    public String getUsernameLabelText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLabel)).getText();
    }

    public String getPasswordLabelText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLabel)).getText();
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }


    public boolean isLoginButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).isDisplayed();
    }

    public String getLoginButtonText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).getText();
    }

    public WebElement getErrorMessageElement() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
    }

    public void login(String username, String password) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput));
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput));

        usernameElement.sendKeys(username);
        passwordElement.sendKeys(password);

        clickLoginButton();
    }
}
