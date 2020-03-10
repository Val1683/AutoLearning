package by.val.tests;


import by.val.base.SetDriver;
import by.val.webpages.HomePage;
import by.val.webpages.ResultsPage;
import by.val.webpages.ResultsPageNext;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

    public class SearchResultTest {
    protected static WebDriver driver;
    HomePage page;
    ResultsPage respage;
    ResultsPageNext resultspageNext;
    static String searchtext="QA";

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
     Assert.assertTrue("The page is succesfully loaded"+driver.getTitle(), driver.getTitle().contains("tut.by"));
    }


    @AfterClass
    public static void teardown()  {
    }
}
