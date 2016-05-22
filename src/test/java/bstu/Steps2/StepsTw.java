package bstu.Steps2;

import bstu.page2.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;




public class StepsTw {
    private WebDriver driver;
    public void initBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }


    public void closeDriver()
    {
        driver.close();
    }


    public void logInTw(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage("https://twitter.com/");
        loginPage.logIn(username, password);
    }
    public boolean isLoggedIn()
    {
        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.isLogIn());
    }
    public void logOutTw(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage("https://twitter.com/");
        loginPage.logOut(username,password);
    }
    public boolean isLoggedOut()
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage("https://twitter.com/download?logged_out=1&lang=ru");
        return (loginPage.isLogOut());
    }

    public void searchTw(String searchEpam){
        Search search = new Search(driver);
        search.openPage("https://twitter.com/");
        search.search(searchEpam);
    }
    public boolean isSearched()
    {
        Search search = new Search(driver);
        return (search.isSearch());
    }

    public void tweetTw(String username,String password,String text){
        Tweet recall = new Tweet(driver);
        recall.openPage("https://twitter.com/");
        recall.tweet(username,password,text);
    }
    public boolean isTweet()
    {
        Tweet recall = new Tweet(driver);
        return (recall.isTweet());
    }


    public void followTw(String username,String password, String fallowEpam){
        Follow fallow = new Follow(driver);
        fallow.openPage("https://twitter.com/");
        fallow.follow(username,password, fallowEpam);
    }
    public boolean isFollowers()
    {
        Follow fallow = new Follow(driver);
        return (fallow.isFollow());
    }


    public void likeTw(String username,String password){
        Like like = new Like(driver);
        like.openPage("https://twitter.com/epam_bstu");
        like.like(username,password);
    }
    public boolean isLikes()
    {
        Like like = new Like(driver);
        return (like.isLike());
    }

    public void messageTw(String username, String password,String name, String messages){
        AddMessage message = new AddMessage(driver);
        message.openPage("https://twitter.com/Molochko_Ness");
        message.addMessage(username,password,name, messages);
    }
    public boolean isMessages()
    {
        AddMessage message = new AddMessage(driver);
        return (message.isMessage());
    }


    public void retweetTw(String username, String password, String comment){
        Retweet retweet = new Retweet(driver);
        retweet.openPage("https://twitter.com/NewsBstu");
        retweet.retweet(username,password,comment);
    }
    public boolean isRetweet()
    {
        Retweet retweet = new Retweet(driver);
        return (retweet.isRetweet());
    }

    public void JackDorseyTw(String username, String password, String message){
        Jack_Dorsey jackTweet = new Jack_Dorsey(driver);
        jackTweet.openPage("https://twitter.com/jack");
        jackTweet.jackDorsey(username,password,message);
    }
    public boolean isJackDorsey()
    {
        Jack_Dorsey jackDorsey = new Jack_Dorsey(driver);
        return (jackDorsey.isJackDorsey());
    }
}


