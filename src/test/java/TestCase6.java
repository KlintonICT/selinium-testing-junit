/*
 * Test Case 6: Check "ราชดำเนิน" button
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class TestCase6 {
    String baseUrl;
    WebDriver driver;

    @Before
    public void init() {
        System.setProperty("WebDriver.chrome.driver", "chromedriver");
        baseUrl = "https://www.pantip.com/";
        driver = new ChromeDriver();
    }

    @After
    public void finish() {
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.xpath("//*[@id=\"ptContainerMain\"]/div[5]/div[3]/div[2]/div/div/div/div[3]/a"));
        element.click();
        String expectedTitle = element.getText();

        Thread.sleep(2000);

        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        assertTrue(driver.getTitle().contains(expectedTitle));
    }
}
