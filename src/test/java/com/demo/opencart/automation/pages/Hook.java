package com.demo.opencart.automation.pages;

import com.demo.opencart.automation.core.ApplicationProperty;
import com.demo.opencart.automation.core.Constants;
import com.demo.opencart.automation.scripts.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hook extends BaseTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);

    @Before
    public void beforeScenario() {
        initializeDriver();
        login(Constants.get(ApplicationProperty.APPLICATION_BASE_URL));
        LOGGER.info("Driver was started");
    }

    @After
    public void afterScenario() {
        driver.quit();
        LOGGER.info("Driver was closed");
    }
}