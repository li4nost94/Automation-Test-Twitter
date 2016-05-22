package bstu.page2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Admin on 16.05.2016.
 */
public class AddMessage extends AbstractPage{

    private final String BASE_URL = "https://twitter.com/Molochko_Ness";

    @FindBy(name = "session[username_or_email]")
    public WebElement signInEmail;

    @FindBy(name = "session[password]")
    public WebElement signInPassword;

    @FindBy(xpath = "//input[@value='Войти']")
    public WebElement signInLogin;


    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/ul[2]/li/div/div[3]/form/div[1]/input")
    public WebElement loginBox;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/ul[2]/li/div/div[3]/form/div[2]/input")
    public WebElement passwordBox;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div/div/div/div/ul[2]/li/div/div[3]/form/input[1]")
    public WebElement buttonLogin;
    @FindBy(xpath = "/html/body/div[2]/div[1]/div[2]/div/div/div[2]/ul/li[3]/a")
    public WebElement clickMessage;
    @FindBy(xpath = "/html/body/div[8]/div[2]/div[2]/div[2]/div[2]/div/ul/li/div")
    public WebElement clickMessage2;
    @FindBy(xpath = "/html/body/div[8]/div[2]/div[3]/div[2]/div/div[2]/div[2]/div[3]/div[2]/form/div[1]/div[2]")
    public WebElement addMessage;
    @FindBy(xpath = "/html/body/div[8]/div[2]/div[3]/div[2]/div/div[2]/div[2]/div[3]/div[2]/form/div[3]/button")
    public WebElement sendMessage;


    public AddMessage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }


    public void addMessage(String email, String password, String Name, String message)
    {
        signInEmail.clear();
        signInEmail.sendKeys(email);
        signInPassword.clear();
        signInPassword.sendKeys(password);
        signInLogin.click();

        //send message
        clickMessage.click();
        clickMessage2.click();
        addMessage.sendKeys(message);
        sendMessage.click();

    }

    public boolean isMessage(){

        return driver.findElement(By.linkText("Яна Дронина")).isDisplayed();

    }

}