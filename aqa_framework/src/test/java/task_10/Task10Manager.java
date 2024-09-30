package task_10;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Task10Manager {



    WebDriver driver;
    @BeforeTest
    void setup(){
        ChromeDriverManager.getInstance().setup();
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
