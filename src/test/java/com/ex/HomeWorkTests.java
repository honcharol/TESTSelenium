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
        HashSet<String> uniqLastName = new HashSet<>();
        List<WebElement> tableSell = new ArrayList<>();
        List<WebElement> tableRow = webDriver.findElements(By.xpath
                ("//div[@class='divTableCell']//parent::div[@class='divTableRow']"));
        int finalElementOfTable = elementOfTable;
        for (WebElement x : tableRow) {
            if(x.findElements(By.xpath(".//div[@class='divTableCell']")).get(finalElementOfTable).getText().contains("Strong")){
                x.findElement(By.xpath(".//input")).click();
            }

        }
        System.out.println();


//        for (int k=0; k<tableRow.size(); k++){
//             webDriver.findElements((By) tableRow.get(k));
//
//        }
//        List<String> uniqLastNames = new ArrayList<>();
//        for(int i=1; i<elements.size(); i++){
//           List<String> tempStr = Arrays.asList((elements.get(i)).getText().split(" "));
//           if(!uniqLastNames.contains(tempStr.get(1))){
//               uniqLastNames.add(tempStr.get(1) +" "+ checkBox.get(i - 1));
//           }
//        }


    }
}
