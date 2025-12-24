package betterment.bonds.org.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import betterment.bonds.org.utilities.EnvironmentUtil;

import java.io.IOException;


public class BaseTest {
    EnvironmentUtil envUtil = new EnvironmentUtil();
    WebDriver driver;

    public BaseTest(String url) throws IOException {
        envUtil.setURL(url);
        this.setDriver();
        this.getUrl(driver, envUtil.getURL());
    }

    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        this.options();
    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public void getUrl(WebDriver driver, String url) {
        driver.get(url);
    }

    void options() {
        driver.manage().window().maximize();
    }
}