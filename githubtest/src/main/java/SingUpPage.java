import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SingUpPage {

    private WebDriver driver;

    public SingUpPage(WebDriver driver) {
        this.driver = driver;
    }

    private By userName = By.xpath("//*[@id=\"user_login\"]");
    private By userEmail = By.xpath("//*[@id=\"user_email\"]");
    private By userPassword = By.xpath("//*[@id=\"user_password\"]");
    private By singUp = By.xpath("//*[@id=\"signup_button\"]");
    private By errorMessage = By.xpath("//*[@id=\"signup-form\"]/div");

    public SingUpPage typeUserName(String userName) {
        driver.findElement(this.userName).sendKeys(userName);
        return this;
    }

    public SingUpPage typeUserEmail(String userEmail) {
        driver.findElement(this.userEmail).sendKeys(userEmail);
        return this;
    }

    public SingUpPage typeUserPassword(String userPassword) {
        driver.findElement(this.userPassword).sendKeys(userPassword);
        return this;
    }

    public SingUpPage invalidSingUp(String userName, String userEmail, String userPassword) {
        typeUserName(userName);
        typeUserEmail(userEmail);
        typeUserPassword(userPassword);
        driver.findElement(singUp).click();
        return new SingUpPage(driver);
    }

    public String errorText() {
        return driver.findElement(errorMessage).getText();
    }
}
