package com.ex;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

public class SomeOtherTests extends BaseTest{
    @Test
    public void testUiContains(){
        webDriver.get("https://output.jsbin.com/osebed/2");
        Select fruit = new Select(webDriver.findElement(By.xpath("//select[@id='fruits']")));
        fruit.selectByValue("orange");
        fruit.selectByVisibleText("Grape");
        System.out.println();
    }

    @Test
    public void testSelect(){
        webDriver.get("https://theautomationzone.blogspot.com/");
        Select fruit = new Select(webDriver.findElement(By.xpath("//select[@id='course']")));
        fruit.selectByVisibleText("Computer Course");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        fruit.selectByVisibleText("Other Course");
        System.out.println();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testUiList(){
        webDriver.get("https://parabank.parasoft.com/");
        List<WebElement> webElements = webDriver.findElements(By.xpath("//ul[@class='leftmenu']//li[not(contains(@class,'Solutions'))]"));
        for (WebElement element: webElements){
            if (Objects.equals(element.getText(), "Products")){
                element.click();
                break;
            }
        }
        System.out.println();
    }
}
