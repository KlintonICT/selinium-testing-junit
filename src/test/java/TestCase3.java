/*
 * Test Case 3: Check Search Box
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class TestCase3 {
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
        WebElement textBox = driver.findElement(By.xpath("//input[@Class='search-box']"));
        textBox.sendKeys("Cheese");
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div/div/i")).click();
        String expectedTitle = "https://pantip.com/search?q=Cheese";
        String actualTitle = "";

        Thread.sleep(10000); // wait for loading of the next page

        actualTitle = driver.getCurrentUrl();

        assertEquals(expectedTitle, actualTitle);
    }
}
