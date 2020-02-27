package selenium_base_api_second_hw.seleniumBaseApi;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckingCheckBoxes {
    ChromeDriver driver;

    @DataProvider(name = "ListOfCSSSelector")
    public static Object[] cssSelectors() {
        return new Object[]{"input[value='checkbox-1']", "input[value='checkbox-2']", "input[value='checkbox-3']"};
    }

    @DataProvider(name = "ListOfXpathSelector")
    public static Object[] xpathSelectors() {
        return new Object[]{"//input[@type='checkbox'][@value='checkbox-1']",
                "//input[@type='checkbox'][@value='checkbox-2']", "//input[@type='checkbox'][@value='checkbox-3']"};
    }

    @BeforeClass
    public void addingWebDriver() {
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/checkbox");
    }

    @Test(dataProvider = "ListOfCSSSelector")
    public void checkCheckBoxByCSSSelector(String cssSelectors) {
        WebElement checkBox = driver.findElementByCssSelector(cssSelectors);
        if (!checkBox.isSelected()) {
            checkBox.click();
            Assert.assertTrue(checkBox.isSelected(), "Checking checkBox using CSS Selectors");
        }
    }

    @Test(dataProvider = "ListOfXpathSelector")
    public void checkCheckBoxByXpathSelector(String xpathSelectors) {
        WebElement checkBox = driver.findElementByXPath(xpathSelectors);
        if (!checkBox.isSelected()) {
            checkBox.click();
            Assert.assertTrue(checkBox.isSelected(), "Checking checkBox using xpath Selectors");
        }
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }
}
