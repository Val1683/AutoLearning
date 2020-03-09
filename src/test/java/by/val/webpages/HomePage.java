package by.val.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.Keys.ENTER;

public class HomePage extends Page {

    @FindBy(name="text")
    WebElement searchField;


    public HomePage(WebDriver driver) {
        super(driver);
        assertTrue(searchField.isDisplayed());
    }

    public ResultsPage searchRequest(String searchtext) {
        searchField.clear();
        searchField.sendKeys(searchtext);
        searchField.submit();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return new ResultsPage(driver);
    }

}
