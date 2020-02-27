package selenium_base_api_second_hw.seleniumBaseApi;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CheckingLipsumSiteHWTask {
    ChromeDriver driver;

    @DataProvider(name = "repeatTimesForWords")
    public static Object[] repeatTimes() {
        return new Object[][]{{"-1", -1}, {"0", 0}, {"15", 15}, {"50", 50}};
    }

    @DataProvider(name = "repeatTimesForList")
    public static Object[] repeatTimesForList() {
        return new Object[][]{{"-1", -1}, {"0", 0}, {"5", 5}};
    }

    @BeforeTest
    public void addingWebDriver() {
        driver = new ChromeDriver();
        driver.get("https://lipsum.com/");
    }

    @Test
    public void searchingWordOnSite() {
        WebElement element = driver.findElementByXPath("//a[@class='ru']");
        element.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement textField = driver.findElementById("Panes");
        Assert.assertTrue(textField.getText().contains("рыба"), "searching 'рыба' word in text");
    }

    @Test
    public void countingWordInText() {
        int count = 0;
        WebElement element;
        for (int i = 0; i < 10; i++) {
            element = driver.findElementById("generate");
            element.click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            for (int j = 1; j <= 5; j++) {
                if (driver.findElementByXPath("//div[@id='lipsum']/p[" + j + "]").getText().contains("lorem") ||
                        driver.findElementByXPath("//div[@id='lipsum']/p[" + j + "]").getText().contains("Lorem")) {
                    count++;
                }
            }
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            driver.get("https://lipsum.com/");
        }
        System.out.println(count);
        boolean flag = false;
        int AVG = count / 10;
        System.out.println("AVG - > " + AVG);
        if (AVG >= 3) {
            flag = true;
        }
        Assert.assertTrue(flag, "test will pass in a case when AVG of the word will be more then 3");
    }

    @Test(dataProvider = "repeatTimesForWords")
    public void checkingTimesRepeatesOfWords(String times, int intTimes) {
        driver.get("https://lipsum.com/");
        WebElement radioButtonWords = driver.findElementById("words");
        radioButtonWords.click();
        WebElement amountField = driver.findElementByXPath("//input[@name='amount']");
        amountField.clear();
        amountField.sendKeys(times);
        WebElement generateButton = driver.findElementById("generate");
        generateButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement paragraph = driver.findElementByXPath("//div[@id='lipsum']/p");
        String[] wordsNumber = paragraph.getText().split(" ");
        Assert.assertEquals(wordsNumber.length, intTimes, "checking times of repeat ");
    }

    @Test(dataProvider = "repeatTimesForList")
    public void checkingTimesRepeatesOfLists(String times, int intTimes) {
        driver.get("https://lipsum.com/");
        WebElement radioButtonLists = driver.findElementById("lists");
        radioButtonLists.click();
        WebElement amountField = driver.findElementByXPath("//input[@name='amount']");
        amountField.clear();
        amountField.sendKeys(times);
        WebElement generateButton = driver.findElementById("generate");
        generateButton.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        List<WebElement> list = driver.findElementsByTagName("ul");
        Assert.assertEquals(list.size(), intTimes, "checking times of List repeats");
    }

    @AfterTest
    public void closeWebDriver() {
        driver.quit();
    }

}
