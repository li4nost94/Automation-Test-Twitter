package bstu.page2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Admin on 16.05.2016.
 */
public class Like extends AbstractPage{
    private final String BASE_URL = "https://twitter.com/epam_bstu";

    @FindBy(name = "session[username_or_email]")
    public WebElement signInEmail;

    @FindBy(name = "session[password]")
    public WebElement signInPassword;

    @FindBy(xpath = "//input[@value='Войти']")
    public WebElement signInLogin;

    @FindBy(xpath = "/html/body/div[2]/div[2]/div/div[4]/div/div/div[2]/div/div[2]/div[4]/div/div[2]/ol[1]/li/div/div[2]/div[4]/div[2]/div[3]/button[1]")
    public WebElement likeButton;

    public Like(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void like(String email, String password)
    {
        signInEmail.clear();
        signInEmail.sendKeys(email);
        signInPassword.clear();
        signInPassword.sendKeys(password);
        signInLogin.click();
        //  like
        likeButton.click();
        //  like
//        List<WebElement> likes = likeButton.findElements(By.className("IconContainer js-tooltip"));
//        if(likes != null && !likes.isEmpty()) {
//            WebElement like = likes.get(0);
//            if(!"убрать отметку".equalsIgnoreCase(like.getAttribute("title"))) {
//                like.click();
//            }



    }

    public boolean isLike(){
       // Assert.assertEquals("Понравилось \n 1", driver.findElement(By.xpath("(//button[@type='button'])[30]")).getText())
        return likeButton.isEnabled();


    }

}