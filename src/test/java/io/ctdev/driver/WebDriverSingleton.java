package io.ctdev.driver;

import io.ctdev.config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverSingleton {
    private static ThreadLocal <WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            /*System.getProperty("browser")*/
            switch (TestConfig.cfg.browser()) {
                case "firefox": {
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                }
                case "edgedriver" : {
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;
                }
                default: {
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                }
            }
            driver.get().manage().window().maximize();
        }
        return driver.get();
    }

    public static void closeDriver() {
        if (driver.get() != null){
            driver.get().close();
            driver.remove();
        }
    }
}
