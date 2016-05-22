package bstu.page2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{
    private final String BASE_URL = "https://twitter.com/";

    @FindBy(id = "signin-email")
    public WebElement signInEmail;

    @FindBy(id = "signin-password")
    public WebElement signInPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInLogin;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void logIn(String email, String password)
    {

        signInEmail.clear();
        signInEmail.sendKeys(email);
        signInPassword.clear();
        signInPassword.sendKeys(password);
        signInLogin.click();

    }

    public boolean isLogIn(){
        return driver.findElement(By.id("tweet-box-home-timeline")).isDisplayed();

    }

    public void logOut(String email, String password){

        //Login
        signInEmail.clear();
        signInEmail.sendKeys(email);
        signInPassword.clear();
        signInPassword.sendKeys(password);
        signInLogin.click();

        //out
        driver.findElement(By.id("user-dropdown-toggle")).click();
        driver.findElement(By.id("signout-button")).click();
    }

    public boolean isLogOut(){
        return driver.findElement(By.id("phone_number")).isDisplayed();
    }
}