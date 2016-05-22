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
   // private static final String MESSAGE_EPAM = "Êòî òàêîé Äæîí Ãîëò?";
    private static final String NAME_EPAM = "ßíà Äðîíèíà";
    private static final String COMMENT_EPAM = "Retweet";
    private static final String JACK_EPAM = "epam2!!!";


    private static final String EPAM_BSTU  = "EPAM BSTU";

    private StepsTw steps;

    @BeforeMethod(description = "Init browser")
    public void setUp() {
        steps = new StepsTw();
        steps.initBrowser();
    }

    //âõîä
    @Test(description = "login to Twitter")
    public void logInTw() {
        steps.logInTw(EMAIL, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn());
        System.out.println("login to Twitter");
    }
    //âûõîä
    @Test(description = "logOut to Twitter")
    public void logOutTw(){
        steps.logOutTw(EMAIL, PASSWORD);
        Assert.assertTrue(steps.isLoggedOut());
        System.out.println("logOut to Twitter");
    }


    //ïîèñê
    @Test(description = "Search in Twitter")
    public void searchTw(){
        steps.logInTw(EMAIL, PASSWORD);
        steps.searchTw(SEARCH_EPAM);
        Assert.assertTrue(steps.isSearched());
        System.out.println("Search to Twitter");
    }



    //òâèò
    @Test(description = "Tweet on twitter")
    public void tweetTw(){
        steps.tweetTw(EMAIL,PASSWORD,TWEET);
        Assert.assertTrue(steps.isTweet());
        System.out.println("Tweet to Twitter");
    }

//follow
    @Test(description = "Follow on Twitter")
    public void followTw() {
        steps.followTw(EMAIL,PASSWORD,SEARCH_EPAM);
        Assert.assertTrue(steps.isFollowers());
        System.out.println("Follow to Twitter");
    }


    @Test(description = "Like on Twitter")
    public void likeTw() {
        steps.likeTw(EMAIL,PASSWORD);
        Assert.assertTrue(steps.isLikes());
        System.out.println("like to Twitter");
    }
/*
    @Test(description = "Message on Twitter")
    public void messageTw() {
        steps.messageTw(EMAIL, PASSWORD, NAME_EPAM, MESSAGE_EPAM);
        Assert.assertTrue(steps.isMessages());
        System.out.println("Message to Twitter");
    }

*/
    @Test(description = "Retweet on Twitter")
    public void retweetTw() {
        steps.retweetTw(EMAIL,PASSWORD,COMMENT_EPAM);
        Assert.assertTrue(steps.isRetweet());
        System.out.println("Retweet to Twitter");
    }


    @Test(description = "Jack on Twitter")
    public void jackDorseyTw() {
        steps.JackDorseyTw(EMAIL,PASSWORD,JACK_EPAM);
        Assert.assertTrue(steps.isJackDorsey());
        System.out.println("Jack to Twitter");
    }



}
