package by.val.tests;


import by.val.base.SetDriver;
import by.val.webpages.HomePage;
import by.val.webpages.ResultsPage;
import by.val.webpages.ResultsPageNext;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

    public class SearchResultTest {
    protected static WebDriver driver;
    HomePage page;
    ResultsPage respage;
    ResultsPageNext resultspageNext;
    static String searchtext="Software Tester";

    @BeforeClass
    public static void setup() throws IOException {

        driver = SetDriver.startDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }


    @Test
    public void testSearchFunction() throws IOException, InterruptedException {
     page = new HomePage(driver);
     respage = page.searchRequest(searchtext);
     respage.reportfile();
     resultspageNext = respage.clickNext();
     resultspageNext.clickNext();
       // WebDriverWait wait = new WebDriverWait(driver, 4);
        //wait.until(ExpectedConditions.titleContains("Selenium"));
        Assert.assertTrue("The page is succesfully loaded"+driver.getTitle(), driver.getTitle().contains("tut.by"));

    }

//    @Test
//    public void testSearchFunction2() {
//        Assert.assertTrue("The page is succesfully loaded", driver.getTitle()=="Selenium Java tutorial");
//    }

    @AfterClass
    public static void teardown()  {


    }
}
