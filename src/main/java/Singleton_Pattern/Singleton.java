package Singleton_Pattern;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.OperaDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;

public class Singleton {
    private static Singleton singl;

    static {
        try {
            singl = new Singleton();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static WebDriver driver;

    private Singleton() throws InterruptedException {
        ChromeOptions options= new ChromeOptions();
        options.addArguments("--start-maximized", "--disable-notifications");
        driver = WebDriverManager.chromedriver().avoidShutdownHook().capabilities(options).create();
        driver.get(Constant.URL);
        driver.close();
        Thread.sleep(3000);
        System.out.println("singleton object has already been created");
    }

    public static Singleton getDriverInstance(){

        return singl;
    }


}

