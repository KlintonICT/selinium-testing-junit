/*
 * Test Case 5: Check Tag Search
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

public class TestCase5 {
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
        WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/ul[2]/a[4]"));
        element.click();

        ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        WebElement element1 = driver.findElement(By.id("search-tag-text"));
        element1.sendKeys("AIS");

        Thread.sleep(2000);

        WebElement element2 = driver.findElement(By.xpath("/html/body/div[4]/div[2]/div/div[2]/div/div[2]/div[1]/a/h1"));

        assertTrue(element2.getText().contains("AIS"));
    }
}
