package by.val.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.util.List;

public class ResultsPageNext extends ResultsPage{


//    @FindBy(xpath = "/html/body/div[5]/div/div/div[3]/div/div[4]/div/div[2]/div/div[2]/div/div/div/div[1]/div[1]/span/span/span/a")
//    List<WebElement> vacancies;

    @FindBy(xpath ="//a[@class='bloko-button HH-Pager-Controls-Next HH-Pager-Control']")
    List<WebElement> nextButton;

    public ResultsPageNext(WebDriver driver) {
        super(driver);
    }

    @Override
    public ResultsPageNext clickNext() throws IOException, InterruptedException {
       if (nextButton.size()>0) {
           nextButton.get(0).click();
           this.reportfile();
           this.clickNext();
       }

       return this;

    }



}
