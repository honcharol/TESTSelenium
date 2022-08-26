package ui;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ui.BaseTest;

import static org.assertj.core.api.Assertions.assertThat;

public class SmokeUiSuite extends BaseTest {

    @Test
    public void firstTest(){
        webDriver.get("http://automationpractice.com/");
        By element = By.xpath("//a[@class='login']");
        webDriver.findElement(element).click();

        String generLeftPart= RandomStringUtils.randomAlphabetic(6);
        String rndEmail = generLeftPart + "@ukr.net";


        webDriver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(rndEmail);
        webDriver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String actualStr = webDriver.findElement(By.xpath("//label[text()='Title']/parent::div/parent::div//h3")).getText();
        assertThat(actualStr).isEqualTo("YOUR PERSONAL INFORMATION");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    @Test
    public void firstTest2() {
        webDriver.get("http://automationpractice.com/");
        By element = By.xpath("//a[@class='login']");
        webDriver.findElement(element).click();

        webDriver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("example@email.com");
        webDriver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

//        webDriver.findElement(By.xpath("//div[@id='create_account_error']/ol/li[text()='An account using this email address has already been registered. Please enter a valid password or request a new one. ']"));
        String actualStr = webDriver.findElement(By.xpath("//div[@id='create_account_error']/ol/li")).getText();
        assertThat(actualStr).isEqualTo("An account using this email address has already been registered. Please enter a valid password or request a new one.");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
