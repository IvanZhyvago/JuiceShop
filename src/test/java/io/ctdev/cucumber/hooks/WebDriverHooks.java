package io.ctdev.cucumber.hooks;

import io.ctdev.config.TestConfig;
import io.ctdev.driver.WebDriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;



public class WebDriverHooks {

    @Before
    public void setUp () {
        WebDriverSingleton.getDriver().get(TestConfig.cfg.webSite());
    }

    @After
    public void tearDown () {
        WebDriverSingleton.closeDriver();
    }


}
