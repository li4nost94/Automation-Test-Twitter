package bstu.page2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Search extends AbstractPage{
    private final String BASE_URL = "https://twitter.com/";

    @FindBy(id = "search-query")
    public WebElement searchQuery;

    public Search(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
    @Override
    public void openPage(String URL)
    {
        driver.navigate().to(URL);
    }

    public void search(String searcworld)
    {
        searchQuery.clear();
        searchQuery.sendKeys(searcworld);
        searchQuery.submit();

    }

    public boolean isSearch(){
        return driver.findElement(By.linkText("EPAM Systems")).isDisplayed();
    }
}