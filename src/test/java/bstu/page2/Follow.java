package bstu.page2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.net.URL;

/**
 * Created by Admin on 15.05.2016.
 */
public class Follow extends AbstractPage{
    private final String BASE_URL = "https://twitter.com/";

    @FindBy(id = "signin-email")
    public WebElement signInEmail;

    @FindBy(id = "signin-password")
    public WebElement signInPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInLogin;

    @FindBy(id = "search-query")
    public WebElement searchQuery;

    //@FindBy(xpath = "//button[@type='button'])[29]")
    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[2]/div[2]/div/div[2]/div/div/div/div/div[2]/ol[1]/li[1]/div[2]/div[1]/div/div/div/div[1]/div/div/div/button")
    public WebElement followButton;


    public Follow(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void follow(String email, String password, String searcworld)
    {

        signInEmail.clear();
        signInEmail.sendKeys(email);
        signInPassword.clear();
        signInPassword.sendKeys(password);
        signInLogin.click();

        searchQuery.clear();
        searchQuery.sendKeys(searcworld);
        searchQuery.submit();

        followButton.click();
    }

    public boolean isFollow(){
            return driver.findElement(By.linkText("EPAM Systems")).isDisplayed();
    }

}