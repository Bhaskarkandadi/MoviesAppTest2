import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import Pages.AccountPage;
import Pages.LoginPage;

import java.time.Duration;

public class AccountPageTest {
    WebDriver driver;
    WebDriverWait wait;
    AccountPage accountPage;
    LoginPage loginpage;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginpage = new LoginPage(driver, wait);
        accountPage = new AccountPage(driver, wait);
        driver.get("https://qamoviesapp.ccbp.tech/account");
        loginpage.login("rahul","rahul@2021");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("avatar-img")));
        driver.findElement(By.className("avatar-img")).click();
    }

    @Test(priority = 1)
    public void testAccountHeadingText() {
        String headingText = accountPage.getAccountHeadingText();
        Assert.assertEquals(headingText, "Account", "Account heading is incorrect");

    }
    @Test(priority = 2)
    public void testAccountMembership() {
        String Memberhsipname = accountPage.getMembershipname();
        Assert.assertEquals(Memberhsipname,"User name : rahul","Username is incorrect");
    }
    @Test(priority = 3)
    public void testAccountPlandetails() {
        String Plandetails = accountPage.getPlandetails();
        Assert.assertEquals(Plandetails,"Ultra HD","Username is incorrect");
    }
    @Test(priority = 4)
    public void testLogoutFunctionality() {
        accountPage.clickLogoutButton();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
