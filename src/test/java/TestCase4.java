/*
 * Test Case 4: Check Login
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class TestCase4 {
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
        WebElement element = driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div/ul[2]/a[5]"));
        element.click();

        Thread.sleep(2000); // wait for loading of the next page

        WebElement element1 = driver.findElement(By.id("member_email"));
        element1.sendKeys("wipu25@gmail.com");

        WebElement element2 = driver.findElement(By.id("member_password"));
        element2.sendKeys("123456789");

        WebElement element3 = driver.findElement(By.id("user_login"));
        element3.submit();

        Thread.sleep(2000); // wait for loading of the next page

        WebElement element4 = driver.findElement(By.xpath("/html/body/div[4]/div/div/div/form/div/div[2]/div/p[2]"));

        assertTrue(element4.getText().contains("รหัสผ่านไม่ถูกต้อง"));
    }
}
