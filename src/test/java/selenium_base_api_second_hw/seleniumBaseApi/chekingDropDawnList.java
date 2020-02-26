package selenium_base_api_second_hw.seleniumBaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class chekingDropDawnList {
    ChromeDriver driver;
    WebElement element;

    @BeforeClass
    public void addingWebDriver() {
      //  System.setProperty("webdriver.chrome.driver", "/Users/Lexx/chromedriv/chromedriver.exe");
        driver = new ChromeDriver();

    }
    @DataProvider(name = "verificationList")
    public static Object[] listOfElements() {
        return new Object[]{"Autocomplete", "Buttons", "Checkbox", "Datepicker", "Drag and Drop", "Dropdown",
        "Enabled and disabled elements", "File Upload", "File Download", "Key and Mouse Press", "Modal", "Page Scroll",
        "Radio Button", "Switch Window", "Complete Web Form"};
    }
    @Test(dataProvider = "verificationList")
    public void verificationOfDropDawnMenu(String nameOfElements) throws InterruptedException {
        driver.get("https://formy-project.herokuapp.com/dropdown");
   //     element = driver.findElementById("dropdownMenuButton");
        element = driver.findElementByXPath("//button[@class='btn btn-primary dropdown-toggle']");
        element.click();
 //       driver.navigate().wait(5000000);
//       WebDriverWait wait=new WebDriverWait(driver, 2);
 //       driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
     //   Thread.sleep(2000);
        element.findElement(By.xpath("//div[@class='dropdown show']/div[@class='dropdown-menu show']/a[text()='"+ nameOfElements +"']"));
//        element.findElement(By.xpath("//div[@class='dropdown-menu show']/a[contains(@href, ’" + nameOfElements +"’)]"));
     element.click();


//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
      //  driver.navigate().forward();
      //  System.out.println(element.getText());
 //       Assert.assertEquals(element.getText(), nameOfElements, "checking names of Elements");

    }

    @AfterTest
    public void closeDriver() {
        //driver.close();
    }
}
