package ui;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpUriRequest;
import org.asynchttpclient.HttpResponseStatus;
import org.asynchttpclient.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v102.network.model.Request;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.remote.http.HttpResponse;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class HW_TestsWaiters extends BaseTest {
    @Test
    public void testAboutGurok(){
        webDriver.get("https://www.gurock.com/testrail/");

        WebElement wbe = webDriver.findElement(By.xpath("//a[contains(.,'About Gurock')]"));
        scrollToElement(webDriver,wbe);
        wbe.click();

        String str = findElementCustom(webDriver, By.xpath("//h1[contains(.,'Our Story')]")).getText();
        assertThat(str).isEqualTo("Our Story");

        System.out.println();
    }

    @Test
    public void testJobs(){
        webDriver.get("https://www.gurock.com/testrail/");

        WebElement wbe = webDriver.findElement(By.xpath("//a[contains(.,'Jobs')]"));
        scrollToElement(webDriver,wbe);
        wbe.click();

        String str = findElementCustom(webDriver, By.xpath("//h1[contains(.,'Help us build products thousands of teams love')]")).getText();
        assertThat(str).isEqualTo("Help us build products thousands of teams love");

        System.out.println();
    }

    @Test
    public void testCompliance(){
        webDriver.get("https://www.gurock.com/testrail/");

        WebElement wbe = webDriver.findElement(By.xpath("//a[contains(.,'Compliance')]"));
        scrollToElement(webDriver,wbe);
        wbe.click();

        WebElement i = findElementCustom(webDriver, By.xpath("//img[@src='https://media.gurock.com/" +
                "gk-media/logos/socforserviceorganizationslogosos.jpeg']"));
        Boolean p = (Boolean) ((JavascriptExecutor)webDriver).executeScript("return arguments[0].complete "
                        + "&& typeof arguments[0].naturalWidth != \"undefined\" "
                        + "&& arguments[0].naturalWidth > 0", i);
        assertThat(p).isEqualTo(true);

        System.out.println();
    }

    @Test
    public void testLegal(){
        webDriver.get("https://www.gurock.com/testrail/");

        WebElement wbe = webDriver.findElement(By.xpath("//a[contains(.,'Legal')]"));
        scrollToElement(webDriver,wbe);
        wbe.click();

        List<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        findElementCustom(webDriver, By.xpath("//a[@id='ui-id-2']")).click();

        String s = findElementCustom(webDriver, By.xpath("//a[contains(.,'Product Licenses, " +
                "SaaS Agreements and Customer Agreements')]")).getText();
        assertThat(s).isEqualTo("Product Licenses, SaaS Agreements and Customer Agreements");

        webDriver.switchTo().window(tabs.get(0));
        findElementCustom(webDriver, By.xpath("//div[@class='col-6 col-sm-6 col-md-4 col-lg-3 " +
                "gk-footer-menu-item-first']//i[@class='material-icons']")).click();

        String s2 = findElementCustom(webDriver, By.xpath("//h1[contains(.,'Subscribe to TestRail News')]")).getText();
        assertThat(s2).isEqualTo("Subscribe to TestRail News");

        System.out.println();
    }

    @Test
    public void testFeatures() throws Exception{
        webDriver.get("https://www.gurock.com/testrail/");

        WebElement wbe = webDriver.findElement(By.xpath("//a[contains(.,'Features')]"));
        scrollToElement(webDriver,wbe);
        wbe.click();

//        webDriver.getCurrentUrl();
//        HttpResponse statusCode = new HttpResponse();
//        System.out.println(statusCode.getStatus());
//        System.out.println();


            URL url = new URL("https://www.gurock.com/testrail/tour/modern-test-management/");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int code = connection.getResponseCode();
        System.out.println(code);

    }
}
