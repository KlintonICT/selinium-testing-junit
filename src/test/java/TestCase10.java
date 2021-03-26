/*
 * Test Case 10: Check ก้นครัว pantip link
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TestCase10 {
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
        WebElement element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div/ul[2]/a[3]"));
        element.click();

        WebElement element1 = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[4]/div/section/div/div[1]/a"));
        element1.click();

        Thread.sleep(2000);

        assertTrue(driver.getTitle().contains("ก้นครัว"));
    }
}
