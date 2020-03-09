package by.val.webpages;
import org.openqa.selenium.support.PageFactory;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class Page {
    protected WebDriver driver;

    public Page(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);


    }


}
