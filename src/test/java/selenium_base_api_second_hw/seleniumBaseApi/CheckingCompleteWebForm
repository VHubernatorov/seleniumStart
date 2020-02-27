package selenium_base_api_second_hw.seleniumBaseApi;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CheckingCompleteWebForm {
    ChromeDriver driver;
    @BeforeClass
    public void addingWebDriver() {
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/");
    }
    @Test
    public void checkingCompleteWebForm() throws InterruptedException {
        WebElement completeWebForm = driver.findElementByXPath("//li/a[text()='Complete Web Form']");
        completeWebForm.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
        WebElement firstName = driver.findElementById("first-name");
        firstName.sendKeys("Volodymyr");
        WebElement lastName = driver.findElementById("last-name");
        lastName.sendKeys("Tester");
        WebElement jobTitle = driver.findElementById("job-title");
        jobTitle.sendKeys("AutoTesting");
        WebElement education = driver.findElementById("radio-button-3");
        education.click();
        WebElement sex = driver.findElementById("checkbox-1");
        sex.click();
        WebElement experianse = driver.findElementById("select-menu");
        experianse.click();
        WebElement option = driver.findElementByXPath("//select[@class='form-control']/option[@value='3']");
        option.click();
        WebElement date = driver.findElementById("datepicker");
        date.sendKeys("10/10/2020");
        WebElement submit = driver.findElementByXPath("//a[@class='btn btn-lg btn-primary']");
        submit.click();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
        WebElement confirmation = driver.findElementByXPath("//div[@class='alert alert-success']");
        Assert.assertEquals(confirmation.getText(), "The form was successfully submitted!", "checking confirmation of form filling");
    }

    @AfterTest
    public void closeDriver() {
        driver.close();
    }

}
