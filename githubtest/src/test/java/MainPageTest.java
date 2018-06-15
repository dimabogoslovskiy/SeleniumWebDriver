import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MainPageTest {

    private WebDriver driver;
    private MainPage mainPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/home/dima/IdeaProjects/driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://github.com");
        mainPage = new MainPage(driver);
    }

    @Test
    public void singIn() {
        LoginPage loginPage = mainPage.clickSingIn();
        String heading = loginPage.headingText();
        Assert.assertEquals("Sign in to GitHub", heading);
    }

    @Test
    public void registerFailText() {
        SingUpPage singUpPage = mainPage.register("fasf", "fasdf", "fad");
        String errorText = singUpPage.errorText();
        Assert.assertEquals("There were problems creating your account.", errorText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
