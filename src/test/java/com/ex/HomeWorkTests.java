package com.ex;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class HomeWorkTests extends BaseTest {
    @Test
    public void testUiRadioButton() {
        webDriver.get("https://theautomationzone.blogspot.com/");
        webDriver.findElement(By.xpath("//a[@id='Blog1_blog-pager-older-link']")).click();
        webDriver.findElement(By.xpath("//input[@id='gc']")).click();

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        String jsCode = String.valueOf(js.executeScript("return document.getElementById('result').value"));
        assertThat(jsCode).isEqualTo("gc");

    }

    @Test
    public void testUiChooseFile() {
        webDriver.get("https://theautomationzone.blogspot.com/");
        webDriver.findElement(By.xpath("//input[@id='photo']")).sendKeys("/home/oleh/lesson18/src/main/resources/exceptions.txt");
        webDriver.findElement(By.xpath("//button[@id='submit']")).click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Test
    public void testUiSampleTable() {
        webDriver.get("https://theautomationzone.blogspot.com/");
        List<WebElement> tableHeadList = webDriver.findElements(By.xpath("//div[@class='divTableRow']/child::div[@class='divTableHead']"));
        int elementOfTable = 0;
        for (int i = 0; i < tableHeadList.size(); i++) {
            if (tableHeadList.get(i).getText().equals("Lastname")) {
                elementOfTable = i;
            }
        }
        List<WebElement> tableRow = webDriver.findElements(By.xpath("//div[@class='divTableCell']//parent::div[@class='divTableRow']"));
        Set<String> uniqLastName = new HashSet<>();

        int finalElementOfTable = elementOfTable;
        for (WebElement x : tableRow) {
                    uniqLastName.add(x.findElements(By.xpath(".//div[@class='divTableCell']")).get(finalElementOfTable).getText());
        }
        List<String> uniqList = new ArrayList<String>(uniqLastName);
        Collections.shuffle(uniqList);
        System.out.println(uniqList);

        for (int s=0; s<3; s++) {
            for (WebElement v : tableRow) {
                if ((uniqList.get(s)).equals(v.findElements(By.xpath(".//div[@class='divTableCell']")).get(finalElementOfTable).getText())) {
                    v.findElement(By.xpath(".//input")).click();
                    break;
                }
            }
        }
        System.out.println();
    }
}