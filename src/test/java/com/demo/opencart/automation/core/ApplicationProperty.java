package com.demo.opencart.automation.core;

import org.apache.commons.lang3.SystemUtils;

/**
 * Enum to list available properties to get from the app configuration
 */
public enum ApplicationProperty {
    APPLICATION_BASE_URL("application.base-url"),
    CHROME_DRIVER_PATH_WINDOWS("webdriver.chrome.driver.windows.path"),
    CHROME_DRIVER_PATH_LINUX("webdriver.chrome.driver.linux.path"),
    CHROME_DRIVER_PATH_MAC("webdriver.chrome.driver.mac.path"),
    CHROME_USE_HEADLESS_MODE("webdriver.chrome.driver.useheadless"); // true or false

    private final String propertyPath;

    ApplicationProperty(String propertyPath) {
        this.propertyPath = propertyPath;
    }

    public String getPropertyPath() {
        return propertyPath;
    }

    public static ApplicationProperty getChromeDriverPath(){
        if (SystemUtils.IS_OS_MAC){
            return CHROME_DRIVER_PATH_MAC;
        }
        if (SystemUtils.IS_OS_LINUX){
            return CHROME_DRIVER_PATH_LINUX;
        }
        if (SystemUtils.IS_OS_WINDOWS){
            return CHROME_DRIVER_PATH_WINDOWS;
        }
        throw new RuntimeException("Unable to determine OS to get the corresponding ChromeDriver");
    }
}
