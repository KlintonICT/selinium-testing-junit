/*
 * Test Case 9: Check share to twitter
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class TestCase9 {
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
        driver.findElement(By.id("sideNavButton")).click();

        String twitterCssSelector = "#__next > div > div > div.pt-wrapper-sidenav-beta.js-menu-control-1 > div > div > a:nth-child(4)";
        driver.findElement(By.cssSelector(twitterCssSelector)).click();

        String expectedUrl = "https://twitter.com/Pantip1996";

        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String actualUrl = driver.getCurrentUrl();

        assertEquals(expectedUrl, actualUrl);
    }
}
