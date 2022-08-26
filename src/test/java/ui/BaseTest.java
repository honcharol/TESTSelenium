package ui;

import com.ex.DriverInit;
import com.ex.WebHelpers;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest extends WebHelpers {
    protected WebHelpers wh = new WebHelpers();
    protected static WebDriver webDriver;

    @BeforeClass
    public void initWebDriver(){
//        String browser = System.getProperty("browser");
        String browser = "chrome";
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
