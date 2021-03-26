/*
 * Test Case 8: Check facebook button
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestCase8 {
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
        driver.findElement(By.xpath("//*[@id=\"sideNavButton\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[8]/div/div/a[1]/i")).click();

        Thread.sleep(10000);

        ArrayList<String> tabs2 = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));

        String expectedTitle = "https://www.facebook.com/pantipdotcom/";
        String actualTitle = driver.getCurrentUrl();

        assertEquals(expectedTitle, actualTitle);
    }
}
