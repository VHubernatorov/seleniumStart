package selenium_base_api_second_hw.seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckingDropDawnList {
    ChromeDriver driver;
    WebElement element;

    @DataProvider(name = "verificationList")
    public static Object[] listOfElements() {
        return new Object[][]{{"Autocomplete", "/autocomplete"}, {"Buttons", "/buttons"}, {"Checkbox", "/checkbox"},
                {"Datepicker", "/datepicker"}, {"Drag and Drop", "/dragdrop"}, {"Dropdown", "/dropdown"},
                {"Enabled and disabled elements", "/enabled"}, {"File Upload", "/fileupload"},
                {"File Download","/filedownload"}, {"Key and Mouse Press","/keypress"}, {"Modal","/modal"},
                {"Page Scroll", "/scroll"}, {"Radio Button", "/radiobutton"}, {"Switch Window","/switch-window"},
                {"Complete Web Form","/form"}};
    }

    @BeforeClass
    public void addingWebDriver() {
        driver = new ChromeDriver();

    }

    @Test(dataProvider = "verificationList")
    public void verificationOfDropDawnMenu(String nameOfElements, String url) {
        driver.get("https://formy-project.herokuapp.com/dropdown");
        element = driver.findElementByXPath("//button[@class='btn btn-primary dropdown-toggle']");
        element.click();
        element = element.findElement(By.xpath("//div[@class='dropdown show']/div[@class='dropdown-menu show']/a[text()='" + nameOfElements + "']"));
        element.click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://formy-project.herokuapp.com" + url, "checking URL changing");
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }
}
