package task_10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task10 {


    WebDriver driver;

    @BeforeTest
    void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
        driver = new ChromeDriver();
    }


    @Test
    void task10Test(){
        driver.get("https://demoqa.com/books");
        WebElement searchBox = driver.findElement(By.id("searchBox"));
        WebElement loginBtn = driver.findElement(By.id("login"));

        searchBox.sendKeys("world");
        loginBtn.click();
        driver.navigate().back();

        WebElement firstBook = driver.findElement(By.xpath("//a[contains(@href, \"/books?book\")][1]"));
        firstBook.click();
    }


    @AfterTest
    void closeBrowser(){
        driver.close();
        driver.quit();
    }
}


//V16. https://demoqa.com (Book Store Application - Book Store)
//1. Set up ChromeDriver using the driver file and properties.
//2. Set up ChromeDriver using DriverManager.
//3. Navigate to the page assigned to your variant.
//4. Select any three different elements.
//5. Interact with all the selected elements.
//6. Verify the visibility of each element using assertions.
//7. Wrap all these steps into a TestNG test case.