package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountPage {
    WebDriver driver;
    WebDriverWait wait;
    By accountHeading = By.className("account-heading");
    By logoutButton = By.className("logout-button");
    By membershipname = By.className("membership-username");

    By plandetails = By.xpath("//p[@class = 'plan-details']");

    public AccountPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getAccountHeadingText() {
        WebElement headingElement = wait.until(ExpectedConditions.visibilityOfElementLocated(accountHeading));
        return headingElement.getText();
    }

    public void clickLogoutButton() {
        WebElement logoutButtonElement = wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
        logoutButtonElement.click();
    }

    public String getMembershipname() {
        return driver.findElement(membershipname).getText();
    }

    public String getPlandetails() {
        return driver.findElement(plandetails).getText();
    }
}
