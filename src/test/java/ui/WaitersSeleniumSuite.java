package ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.internal.BaseTestMethod;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class WaitersSeleniumSuite extends BaseTest {

    @Test
    public void threadSleep() {
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        findElement(webDriver, By.xpath("//input[@id='email_create']"))
                .sendKeys("someemail1@email.com");
        findElement(webDriver, By.xpath("//button[@id='SubmitCreate']")).click();

        waitForElementToBeClickable(webDriver, By.xpath("//button[contains(.,'Register')]")).click();


//        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(.,'Register')]")));
//
//        webDriver.findElement(By.xpath("//button[contains(.,'Register')]")).isDisplayed();
    }

    @Test
    public void TestScrolling() {
        webDriver.get("https://www.gurock.com/testrail/");
//        findElement(webDriver, By.xpath("//a[@target='_blank'][contains(.,'Legal')]")).click();
        WebElement wbe = webDriver.findElement(By.xpath("//a[@target='_blank'][contains(.,'Legal')]"));
        scrollToElement(webDriver,wbe);
        wbe.click();

        List<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        findElement(webDriver, By.xpath("//a[@id='ui-id-3']"));
        System.out.println();
    }
}
