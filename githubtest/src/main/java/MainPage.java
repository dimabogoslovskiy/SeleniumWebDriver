import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By singInButton = By.xpath("/html/body/div[1]/header/div/div[2]/div/span/div/a[1]");
    private By singUpButton = By.xpath("/html/body/div[1]/header/div/div[2]/div/span/div/a[2]");
    private By userName = By.xpath("//*[@id=\"user[login]\"]");
    private By userEmail = By.xpath("//*[@id=\"user[email]\"]");
    private By userPassword = By.xpath("//*[@id=\"user[password]\"]");
    private By singUnFormButton = By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button");

    public LoginPage clickSingIn() {
        driver.findElement(singInButton).click();
        return new LoginPage(driver);
    }

    public SingUpPage clickSingUp() {
        driver.findElement(singUpButton).click();
        return new SingUpPage(driver);
    }

    public SingUpPage clickSingUpFrom() {
        driver.findElement(singUnFormButton).click();
        return new SingUpPage(driver);
    }

    public MainPage typeUserName(String userName) {
        driver.findElement(this.userName).sendKeys(userName);
        return this;
    }

    public MainPage typeUserEmail(String userEmail) {
        driver.findElement(this.userEmail).sendKeys(userEmail);
        return this;
    }

    public MainPage typeUserPassword(String userPassword) {
        driver.findElement(this.userPassword).sendKeys(userPassword);
        return this;
    }

    public SingUpPage register(String userName, String userEmail, String userPassword) {
        typeUserName(userName);
        typeUserEmail(userEmail);
        typeUserPassword(userPassword);
        clickSingUpFrom();
        return new SingUpPage(driver);
    }
}
