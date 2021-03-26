/*
 * Test Case 2: Check hamburger bar
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestCase2 {
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
        WebElement _navBarWrapper = driver.findElement(By.className("pt-wrapper-sidenav-mini-beta"));
        List<WebElement> _sideMenuItems = _navBarWrapper.findElements(By.className("gtm-sub-nav"));

        int totalItems = _sideMenuItems.size();
        int passed = 0;

        for (int i = 0; i < totalItems; i++) {
            WebElement navBarWrapper = driver.findElement(By.className("pt-wrapper-sidenav-mini-beta"));
            List<WebElement> sideMenuItems = navBarWrapper.findElements(By.className("gtm-sub-nav"));

            WebElement menuItem = sideMenuItems.get(i);

            String expectedTitle = menuItem.findElement(By.className("pt-lists-item__text")).getText();
            menuItem.click();

            WebElement breadcrumb = driver.findElement(By.className("pt-breadcrumb"));
            System.out.println(breadcrumb);
            String actualTitle = breadcrumb.getText();

            // System.out.println("expectedTitle: " + expectedTitle);
            // System.out.println("actualTitle: " + actualTitle);

            if (actualTitle.contains(expectedTitle)) {
                passed++;
//                System.out.println("actualTitle: " + actualTitle + " - Passed");
            } else {
                break;
            }
        }

        assertEquals(totalItems, passed);
    }
}
