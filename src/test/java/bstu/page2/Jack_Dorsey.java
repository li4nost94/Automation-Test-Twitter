package bstu.page2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Admin on 16.05.2016.
 */
public class Jack_Dorsey extends AbstractPage{
    private final String BASE_URL = "https://twitter.com/jack";

    @FindBy(name = "session[username_or_email]")
    public WebElement signInEmail;

    @FindBy(name = "session[password]")
    public WebElement signInPassword;

    @FindBy(xpath = "//input[@value='Войти']")
    public WebElement signInLogin;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/div/div/div[1]/div/div/div/div[1]/div[5]/div/div/button")
    public WebElement tweetButton;

    @FindBy(id = "tweet-box-global")
    public WebElement tweetGlobal;


    public Jack_Dorsey(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void jackDorsey(String email, String password, String message)
    {

        signInEmail.clear();
        signInEmail.sendKeys(email);
        signInPassword.clear();
        signInPassword.sendKeys(password);
        signInLogin.click();


      //  driver.findElement(By.xpath("//input[@value='Войти']")).click();
        tweetButton.click();
        //tweet Jeck
        tweetGlobal.sendKeys(message);
        driver.findElement(By.xpath("/html/body/div[10]/div[2]/div[2]/div[4]/form/div[2]/div[2]/button")).click();




    }

    public boolean isJackDorsey(){
        return driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div[2]/div/div/div[1]/div/div/div/div[1]/h1/a")).getText().contains("Jack");

    }

}