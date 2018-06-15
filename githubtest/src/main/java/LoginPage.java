import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userLogin = By.xpath("//*[@id=\"login_field\"]");
    private By userPassword = By.xpath("//*[@id=\"password\"]");
    private By singInButton = By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]");
    private By singUp = By.xpath("//*[@id=\"login\"]/p/a");
    private By heading = By.xpath("//*[@id=\"login\"]/form/div[1]/h1");

    public LoginPage typeUserLogin(String userLogin) {
        driver.findElement(this.userLogin).sendKeys(userLogin);
        return this;
    }

    public LoginPage typeUserPassword(String userPassword) {
        driver.findElement(this.userPassword).sendKeys(userPassword);
        return this;
    }

    public LoginPage invalidLogin(String userLogin, String userPassword) {
        typeUserLogin(userLogin);
        typeUserPassword(userPassword);
        driver.findElement(singInButton).click();
        return new LoginPage(driver);
    }

    public SingUpPage singUp() {
        driver.findElement(singUp).click();
        return new SingUpPage(driver);
    }

    public String headingText() {
        return driver.findElement(heading).getText();
    }
}
