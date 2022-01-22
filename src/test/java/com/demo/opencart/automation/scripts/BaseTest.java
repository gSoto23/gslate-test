package com.demo.opencart.automation.scripts;

import com.demo.opencart.automation.core.ApplicationProperty;
import com.demo.opencart.automation.core.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    public WebDriver driver;

    public void initializeDriver() {

        System.setProperty("webdriver.chrome.driver", Constants.get(ApplicationProperty.getChromeDriverPath()));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--incognito");
        options.addArguments("ignore-certificate-errors");
        options.addArguments("--ignore-ssl-errors=yes");

        if (Constants.getAsBoolean(ApplicationProperty.CHROME_USE_HEADLESS_MODE)) {
            options.setHeadless(true);
        }

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public void login(String baseURL) {
        driver.get(baseURL);
    }
}
