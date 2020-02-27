package selenium_base_api_second_hw.seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CheckButtonsOnFormProject {
    ChromeDriver driver;

    @BeforeClass
    public void addingWebDriver() {
        driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/buttons#");
    }

    @Test(singleThreaded = true)
    public void checkButtonPrimary() {
        WebElement buttonPrimary = driver.findElement(By.xpath("//*[@class='btn btn-lg btn-primary']"));
        buttonPrimary.click();
        Assert.assertEquals(buttonPrimary.getText(), "Primary", "checking 'Primary' button");
    }

    @Test(singleThreaded = true)
    public void checkButtonSuccess() {
        WebElement buttonSuccess = driver.findElement(By.xpath("//*[@class='btn btn-lg btn-success']"));
        buttonSuccess.click();
        Assert.assertEquals(buttonSuccess.getText(), "Success", "checking 'Success' button");

    }

    @Test(singleThreaded = true)
    public void checkButtonInfo() {
        WebElement buttonInfo = driver.findElement(By.xpath("//*[@class='btn btn-lg btn-info']"));
        buttonInfo.click();
        Assert.assertEquals(buttonInfo.getText(), "Info", "checking 'Info' button");
    }

    @Test(singleThreaded = true)
    public void checkButtonWarning() {
        WebElement buttonWarning = driver.findElement(By.xpath("//*[@class='btn btn-lg btn-warning']"));
        buttonWarning.click();
        Assert.assertEquals(buttonWarning.getText(), "Warning", "checking 'Warning' button");
    }

    @Test(singleThreaded = true)
    public void checkButtonDanger() {
        WebElement buttonDanger = driver.findElement(By.xpath("//*[@class='btn btn-lg btn-danger']"));
        buttonDanger.click();
        Assert.assertEquals(buttonDanger.getText(), "Danger", "checking 'Danger' button");
    }

    @Test(singleThreaded = true)
    public void checkButtonLink() {
        WebElement buttonLink = driver.findElement(By.xpath("//*[@class='btn btn-lg btn-link']"));
        buttonLink.click();
        Assert.assertEquals(buttonLink.getText(), "Link", "checking 'Link' button");
    }

    @Test(singleThreaded = true)
    public void checkButtonLeft() {
        WebElement buttonLeft = driver.findElement(By.xpath("//button[text()='Left']"));
        buttonLeft.click();
        Assert.assertEquals(buttonLeft.getText(), "Left", "checking 'Left' button");
    }

    @Test(singleThreaded = true)
    public void checkButtonMiddle() {
        WebElement buttonMiddle = driver.findElement(By.xpath("//button[text()='Middle']"));
        buttonMiddle.click();
        Assert.assertEquals(buttonMiddle.getText(), "Middle", "checking 'Middle' button");
    }

    @Test(singleThreaded = true)
    public void checkButtonRight() {
        WebElement buttonRight = driver.findElement(By.xpath("//button[text()='Right']"));
        buttonRight.click();
        Assert.assertEquals(buttonRight.getText(), "Right", "checking 'Right' button");
    }

    @Test(singleThreaded = true)
    public void checkButtonOne() {
        WebElement buttonOne = driver.findElement(By.xpath("//button[text()='1']"));
        buttonOne.click();
        Assert.assertEquals(buttonOne.getText(), "1", "checking '1' button");
    }

    @Test(singleThreaded = true)
    public void checkButtonTwo() {
        WebElement buttonTwo = driver.findElement(By.xpath("//button[text()='2']"));
        buttonTwo.click();
        Assert.assertEquals(buttonTwo.getText(), "2", "checking '2' button");
    }

    @Test(singleThreaded = true)
    public void checkButtonDropdownOne() {
        WebElement buttonDropdown = driver.findElement(By.id("btnGroupDrop1"));
        buttonDropdown.click();
        buttonDropdown = driver.findElement(By.xpath("//a[text()='Dropdown link 1']"));
        Assert.assertEquals(buttonDropdown.getText(), "Dropdown link 1", "checking 'Dropdown - Link 1' button");
    }

    @Test(singleThreaded = true)
    public void checkButtonDropdownTwo() {
//            WebElement buttonDropdownSecond = driver.findElement(By.id("btnGroupDrop1"));
//        buttonDropdownSecond.click();
        WebElement buttonDropdownSecond = driver.findElement(By.xpath("//a[text()='Dropdown link 2']"));
        Assert.assertEquals(buttonDropdownSecond.getText(), "Dropdown link 2", "checking 'Dropdown Link 2' button");
    }


    @AfterTest
    public void closeDriver() {
        driver.close();
    }

}
