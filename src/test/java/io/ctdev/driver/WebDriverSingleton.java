//java -jar "C:\SeleniumGrid\selenium-server-standalone-3.141.59.jar" -role hub -hubConfig "C:\SeleniumGrid\hubConfig.json" -debug
//java "-Dwebdriver.chrome.driver=C:\Install\Chrome Drivers\chromedriver.exe" -jar  "C:\SeleniumGrid\selenium-server-standalone-3.141.59.jar" -role node


// java "-Dwebdriver.firefox.driver=C:\Install\Chrome Drivers\geckodriver.exe" -jar  "C:\SeleniumGrid\selenium-server-standalone-3.141.59.jar" -role node -hub http://localhost:4444/grid/register -nodeConfig C:\SeleniumGrid\nodeConfig.json

//java -jar "C:\SeleniumGrid\selenium-server-standalone-3.141.59.jar" -role hub
//java "-Dwebdriver.chrome.driver=C:\Install\Chrome Drivers\chromedriver.exe" -jar  "C:\SeleniumGrid\selenium-server-standalone-3.141.59.jar" -role node -hub http://localhost:4444/grid/register
//java "-Dwebdriver.firefox.driver=C:\Install\Chrome Drivers\geckodriver.exe" -jar  "C:\SeleniumGrid\selenium-server-standalone-3.141.59.jar" -role node -hub http://localhost:4444/grid/register
package io.ctdev.driver;

import io.ctdev.config.TestConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverSingleton {

    private static ThreadLocal <WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (driver.get() == null) {
            /*System.getProperty("browser")*/
            switch (TestConfig.cfg.browser()) {
                case "chrome": {
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                }
                case "edgedriver" : {
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;
                }
                default: {
                    if (TestConfig.cfg.remote()) {
                        System.out.println("Test running remotely");
                        try {
                            DesiredCapabilities capabilities = new DesiredCapabilities();
                            capabilities.setCapability("browserName", "chrome");
                            capabilities.setCapability("browserVersion", "85.0");
                            capabilities.setCapability("enableVnc", true);
                            driver.set(new RemoteWebDriver(new URL("http://3.18.213.48:4444/wd/hub"), capabilities));
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Test running on firefox");
                        WebDriverManager.firefoxdriver().setup();
                        driver.set(new EventFiringWebDriver(new FirefoxDriver()));
                    }
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
