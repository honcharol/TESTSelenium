package com.ex;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

public class DriverInit {
    private static WebDriver webDriver;

    public DriverInit(Browser browser) {
        setWebDriver(browser);
    }

    public static WebDriver getWebDriver(Browser browser) {
        if(webDriver == null){
            new DriverInit(browser);
        }
        webDriver.manage().window().setSize(new Dimension(1900, 1000));
        return webDriver;
    }

    public static void setWebDriver(Browser browser) {
        switch (browser) {
            case FF:
                webDriver = WebDriverManager.firefoxdriver().create();
                break;
            case CHROME:
                webDriver = WebDriverManager.chromedriver().create();
                break;
        }
    }

    public enum Browser {
        CHROME,
        FF
    }
}
