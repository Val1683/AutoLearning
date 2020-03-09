package by.val.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class SetDriver {
    static WebDriver driver;
    static String browser;
    static String link;

    public static void getInfo() throws IOException {
        Properties properties = new Properties();
        FileInputStream file = new FileInputStream("src/test/Recources/Recources.txt");
        properties.load(file);
        browser=properties.getProperty("browser");
        link=properties.getProperty("link");


    }


    public static WebDriver startDriver() throws IOException {
        getInfo();
        switch (browser.toLowerCase()) {
            case "firefox": {
                System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.get(link);

                return driver;
            }
            case "chrome": {
                System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
                driver = new ChromeDriver();
                driver.get(link);

                return driver;

            }



            default: {
                System.setProperty("webdriver.gecko.driver", "C:/geckodriver.exe");
                driver = new FirefoxDriver();
                driver.get(link);

                return driver;
            }

        }

    }
}
