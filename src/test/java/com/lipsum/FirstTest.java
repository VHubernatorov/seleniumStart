package com.lipsum;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstTest {


    ChromeDriver driver;
    @Before
    public void startTup() {
        System.setProperty("webdriver.chrome.driver", "/Users/Lexx/chromedriv/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void firstTest() throws InterruptedException {
        driver.get("https://lipsum.com/");
//        WebElement element = driver.findElement(By.className("uk"));
        WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/a[30]"));
        element.click();
        Thread.sleep(5000);
        WebElement element1 = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div[1]/p"));
        String elementText = element1.getText();
        Boolean flag = elementText.contains("рыба");
//        System.out.println(flag);
    //    System.out.println(/html/body/div/div[2]/div[1]/a[38]);
//        System.out.println("***********" + elementText);
        Assert.assertEquals(true, flag);
    }

    @Test
    public void secondTest() throws InterruptedException {

        WebElement element;
        int count = 0;
        for (int i = 0; i < 10; i++) {
            driver.get("https://lipsum.com/");
            element = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div[4]/form/table/tbody/tr[2]/td[2]/input"));
            element.click();
            Thread.sleep(5000);
            element = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div[1]"));
            String tmp = "/html/body/div/div[2]/div[2]/div[3]/div[1]/p";
            String tmp2;
            for (int j = 1; j <= 5; j++) {
                tmp2 = tmp + "[" + j + "]";
                String text = element.findElement(By.xpath(tmp2)).getText();
                if (text.contains("lorem") || text.contains("Lorem")) {
                    count++;
                }
            }
            Thread.sleep(5000);
        }
        System.out.println(count);
        boolean flag = false;
        int AVG = count / 10;
        System.out.println("AVG - > " + AVG);
        if (AVG >= 3 ) {
            flag = true;
        }
        Assert.assertTrue(flag);
    }

    @Test
    public void therdTest() throws InterruptedException {
        int repit = 50;
        String strRepit = String.valueOf(repit);
        driver.get("https://lipsum.com/");
        WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div[4]/form/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td[1]"));
        element.click();
        element = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div[4]/form/table/tbody/tr[1]/td[1]/input"));
        element.clear();
        element.sendKeys(strRepit);
        element = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div[4]/form/table/tbody/tr[2]/td[2]/input"));
        element.click();
        Thread.sleep(5000);
        String str = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div[1]/p")).getText();
        String [] strNumber = str.split(" ");
        Assert.assertEquals(repit, strNumber.length);
    }

    @Test
    public void fouthTest() throws InterruptedException {
        int repit = 5;
     //   String strRepit = String.valueOf(repit);
        driver.get("https://lipsum.com/");
        WebElement element = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div[4]/form/table/tbody/tr[1]/td[2]/table/tbody/tr[4]/td[1]"));
        element.click();
        element = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div[4]/form/table/tbody/tr[1]/td[1]/input"));
        element.clear();
        element.sendKeys(String.valueOf(repit));
        element = driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div[3]/div[4]/form/table/tbody/tr[2]/td[2]/input"));
        element.click();
        Thread.sleep(10000);
       // List list = driver.findElements(By.name("ul"));
        List<WebElement> list = driver.findElementsByTagName("ul");
    //    System.out.println(list.size());
        Assert.assertEquals(repit, list.size());
    }

    @After
    public void close() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}
