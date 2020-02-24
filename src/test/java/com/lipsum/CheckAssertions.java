package com.lipsum;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckAssertions {

    @Test
    public void openYouTube(){
        ChromeDriver driver;
        System.setProperty("webdriver.chrome.driver", "/Users/Lexx/chromedriv/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://youtube.com/");
        Assert.assertEquals("YouTube", driver.getTitle());
    }
}
