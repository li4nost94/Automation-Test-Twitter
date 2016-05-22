package bstu.page2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Tweet extends AbstractPage{
    private final String BASE_URL = "https://twitter.com/";

    @FindBy(id = "signin-email")
    public WebElement signInEmail;

    @FindBy(id = "signin-password")
    public WebElement signInPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInLogin;

    @FindBy(id = "tweet-box-home-timeline")
    public WebElement tweetBox;

    @FindBy(xpath = ("(//button[@type='button'])[22]"))
    public WebElement tweetButton;


    public Tweet(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void tweet(String email,String password,String text)
    {
        signInEmail.clear();
        signInEmail.sendKeys(email);
        signInPassword.clear();
        signInPassword.sendKeys(password);
        signInLogin.click();
        //tweet
        tweetBox.click();
        tweetBox.sendKeys(text);
       // tweetButton.click();
         driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div[2]/div/form/div[2]/div[2]/button")).click();

    }

    public boolean isTweet(){
        return driver.findElement(By.linkText("EPAM BSTU")).isDisplayed();
    }
}
