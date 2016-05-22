package bstu;

import bstu.Steps2.StepsTw;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Admin on 08.05.2016.
 */
public class AppTest {

    ///         https://habrahabr.ru/post/134462/

    private static final String TWEET = "Automation Test labs #epam, #bstu #brsm";

    private static final String EMAIL = "epam.bstu@gmail.com";
    private static final String PASSWORD = "epam.bstu";
    private static final String SEARCH_EPAM = "epam";
    private static final String MESSAGE_EPAM = "*";
   // private static final String MESSAGE_EPAM = "Кто такой Джон Голт?";
    private static final String NAME_EPAM = "Яна Дронина";
    private static final String COMMENT_EPAM = "Retweet";
    private static final String JACK_EPAM = "epam2!!!";


    private static final String EPAM_BSTU  = "EPAM BSTU";

    private StepsTw steps;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new StepsTw();
        steps.initBrowser();
    }

    //вход
    @Test(description = "login to Twitter")
    public void logInTw() {
        steps.logInTw(EMAIL, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn());
    }
    //выход
    @Test(description = "logOut to Twitter")
    public void logOutTw(){
        steps.logOutTw(EMAIL, PASSWORD);
        Assert.assertTrue(steps.isLoggedOut());
    }


    //поиск
    @Test(description = "Search in Twitter")
    public void searchTw(){
        steps.logInTw(EMAIL, PASSWORD);
        steps.searchTw(SEARCH_EPAM);
        Assert.assertTrue(steps.isSearched());
    }



    //твит
    @Test(description = "Tweet on twitter")
    public void tweetTw(){
        steps.tweetTw(EMAIL,PASSWORD,TWEET);
        Assert.assertTrue(steps.isTweet());
    }

//follow
    @Test(description = "Follow on Twitter")
    public void followTw() {
        steps.followTw(EMAIL,PASSWORD,SEARCH_EPAM);
        Assert.assertTrue(steps.isFollowers());
    }


    @Test(description = "Like on Twitter")
    public void likeTw() {
        steps.likeTw(EMAIL,PASSWORD);
        Assert.assertTrue(steps.isLikes());
    }
/*
    @Test(description = "Message on Twitter")
    public void messageTw() {
        steps.messageTw(EMAIL, PASSWORD, NAME_EPAM, MESSAGE_EPAM);
        Assert.assertTrue(steps.isMessages());
    }

*/
    @Test(description = "Retweet on Twitter")
    public void retweetTw() {
        steps.retweetTw(EMAIL,PASSWORD,COMMENT_EPAM);
        Assert.assertTrue(steps.isRetweet());
    }


    @Test(description = "Jack on Twitter")
    public void jackDorseyTw() {
        steps.JackDorseyTw(EMAIL,PASSWORD,JACK_EPAM);
        Assert.assertTrue(steps.isJackDorsey());
    }



}
