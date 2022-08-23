package com.ex;

import com.ex.DriverInit;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static WebDriver webDriver;

    @BeforeClass
    public void initWebDriver(){
        String browser = System.getProperty("browser");
        switch (browser){
            case "chrome":
                webDriver = DriverInit.getWebDriver(DriverInit.Browser.CHROME);
                break;
            case "ff":
                webDriver = DriverInit.getWebDriver(DriverInit.Browser.FF);
                break;
            default:
                System.err.println("You have to chose 'CHROME' or 'FF'");
        }
    }

    @AfterClass
    public void closeWebDriver(){
        webDriver.quit();
    }
}
