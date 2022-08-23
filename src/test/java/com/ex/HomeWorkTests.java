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

    }

    public int indexOfColumn(String str){
        List<WebElement> tableHeadList = webDriver.findElements(By.xpath("//div[@class='divTableRow']/child::div[@class='divTableHead']"));
        int elementOfTable = 0;
        for (int i = 0; i < tableHeadList.size(); i++) {
            if (tableHeadList.get(i).getText().equals(str)) {
                elementOfTable = i;
            }
        }
        return  elementOfTable;
    }
    public List<String> uniqListOfNames(List<WebElement> tableRow, int index){
        Set<String> uniqListName = new HashSet<>();

        for (WebElement x : tableRow) {
            uniqListName.add(x.findElements(By.xpath(".//div[@class='divTableCell']")).get(index).getText());
        }

        List<String> uniqList = new ArrayList<String>(uniqListName);
        Collections.shuffle(uniqList);

        return uniqList;
    }

    @Test
    public void testUiSampleTable() {
        webDriver.get("https://theautomationzone.blogspot.com/");
        int indexColumn = indexOfColumn("Lastname");

        List<WebElement> tableRow = webDriver.findElements(By.xpath("//div[@class='divTableCell']//parent::div[@class='divTableRow']"));

        List<String> uniqList = uniqListOfNames(tableRow, indexColumn);

        for (int s = 0; s < 3; s++) {
            for (WebElement v : tableRow) {
                if ((uniqList.get(s)).equals(v.findElements(By.xpath(".//div[@class='divTableCell']")).get(indexColumn).getText())) {
                    v.findElement(By.xpath(".//input")).click();
                    break;
                }
            }
        }
        System.out.println();
    }
}