package bstu.page2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Admin on 16.05.2016.
 */
public class Retweet extends AbstractPage{
    private final String BASE_URL = "https://twitter.com/NewsBstu";


    @FindBy(name = "session[username_or_email]")
    public WebElement signInEmail;

    @FindBy(name = "session[password]")
    public WebElement signInPassword;

    @FindBy(xpath = "//input[@value='Войти']")
    public WebElement signInLogin;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/div/div/div[2]/div/div[2]/div[4]/div/div[2]/ol[1]/li[1]/div/div[2]/div[4]/div[2]/div[2]/button[1]")
    public WebElement retweetButton;

    @FindBy(xpath = "/html/body/div[12]/div[2]/div[2]/form/div[1]/div[1]/div/div[2]/div[1]")
    public WebElement retweetComment;

    @FindBy(xpath = "/html/body/div[12]/div[2]/div[2]/form/div[2]/div[3]/button")
    public WebElement retweetButton2;

    public Retweet(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void retweet(String email, String password, String comment)
    {

        driver.navigate().to("https://twitter.com/NewsBstu");

        signInEmail.clear();
        signInEmail.sendKeys(email);
        signInPassword.clear();
        signInPassword.sendKeys(password);
        signInLogin.click();

//        retweet
        retweetButton.click();
        retweetComment.sendKeys(comment);
        retweetButton2.click();

    }

    public boolean isRetweet(){
        return driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[1]/div/div/div/div[1]/div[2]/span[2]/a")).isDisplayed();

    }

}