/*
 * Test Case 7: Check banner Link
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestCase7 {
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
    public void test() {
        driver.get(baseUrl);
        WebElement element = driver.findElement(By.xpath("/html/body/div/div/div/div[4]/div[3]/a"));
        element.click();

        String expectedLink = "https://pantip.com/s/etoFK";
        String actualLink = element.getAttribute("href");

        assertEquals(expectedLink, actualLink);
    }
}
