import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Pages.LoginPage;
import java.time.Duration;

public class LoginPageTest {
    WebDriver driver;
    LoginPage loginPage;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\Softwares\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        loginPage = new LoginPage(driver, wait);
        driver.get("https://qamoviesapp.ccbp.tech");
    }

    @Test(priority = 1)
    public void testLogoIsDisplayed() {
        Assert.assertTrue(loginPage.isLogoImageDisplayed(), "Logo is not displayed");
    }

    @Test(priority = 2)
    public void testHeadingText() {
        Assert.assertEquals(loginPage.getHeadingText(), "Login", "Incorrect heading text");
    }

    @Test(priority = 3)
    public void testUsernameLabelText() {
        Assert.assertEquals(loginPage.getUsernameLabelText(), "USERNAME", "Incorrect username label text");
    }

    @Test(priority = 4)
    public void testPasswordLabelText() {
        Assert.assertEquals(loginPage.getPasswordLabelText(), "PASSWORD", "Incorrect password label text");
    }

    @Test(priority = 5)
    public void testLoginButtonUI() {
        Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed");
        Assert.assertEquals(loginPage.getLoginButtonText(), "Login", "Incorrect login button label");
    }

    @Test(priority = 6)
    public void testLoginWithEmptyFields() {
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getErrorMessageElement().getText(), "*Username or password is invalid", "Incorrect error message");
    }

    @Test(priority = 7)
    public void testLoginWithEmptyUsername() {
        loginPage.login("", "rahul@2021");
        Assert.assertEquals(loginPage.getErrorMessageElement().getText(), "*Username or password is invalid", "Incorrect error message");
    }

    @Test(priority = 8)
    public void testLoginWithEmptyPassword() {
        loginPage.login("rahul", "");
        Assert.assertEquals(loginPage.getErrorMessageElement().getText(), "*Username or password is invalid", "Incorrect error message");
    }

    @Test(priority = 9)
    public void testLoginWithInvalidCredentials() {
        loginPage.login("rahul", "wrongpassword");
        Assert.assertEquals(loginPage.getErrorMessageElement().getText(), "*username and password didn't match", "Incorrect error message");
    }

    @Test(priority = 10)
    public void testLoginWithCorrectCredentials() {
        loginPage.login("rahul", "rahul@2021");
        String expectedLoginLink = "https://qamoviesapp.ccbp.tech/";
        wait.until(ExpectedConditions.urlToBe(expectedLoginLink));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedLoginLink, "Login URL doesn't match");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
