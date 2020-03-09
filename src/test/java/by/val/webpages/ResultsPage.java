package by.val.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class ResultsPage extends Page {

//
//    @FindBy(xpath = "/html/body/div[5]/div/div/div[3]/div/div[4]/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/span/span/span/a")
//    List<WebElement> vacancies
    By vacancieslink = By.xpath("/html/body/div[5]/div/div/div[3]/div/div[4]/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/span/span/span/a");

    @FindBy(xpath = "//a[@class='bloko-button HH-Pager-Controls-Next HH-Pager-Control']")
    List<WebElement> nextButton;

    public ResultsPage(WebDriver driver) {
        super(driver);
    }

    //Write the vacancies in the file
    public void reportfile() throws IOException, InterruptedException {
        List<WebElement> vacs = driver.findElements(vacancieslink);
        String timestamp = new SimpleDateFormat("dd.MM.yyyy").format(new Date());
        String filename = "src/test/Recources/vacancies_"+timestamp+".txt";
           FileWriter file = new FileWriter(filename, true);
           BufferedWriter buffer = new BufferedWriter(file);
              buffer.write("The number of links in the file is " + vacs.size());
              buffer.write("\n");
             for (WebElement vaclink : vacs) {
               buffer.write(vaclink.getText()+" "+vaclink.getAttribute("href"));
               buffer.write("\n");
        }
            buffer.close();
            file.close();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public ResultsPageNext clickNext() throws IOException, InterruptedException {
        if (nextButton.size() > 0) {
            nextButton.get(0).click();
            this.reportfile();
        }
        return new ResultsPageNext(driver);
    }

}
