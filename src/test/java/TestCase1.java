/*
 * Test Case 1: Check web title
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestCase1 {
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
        String expectedTitle = "Pantip - Learn, Share & Fun";
        String actualTitle = "";
        driver.get(baseUrl);
        actualTitle = driver.getTitle();

        assertEquals(expectedTitle, actualTitle);
    }
}
