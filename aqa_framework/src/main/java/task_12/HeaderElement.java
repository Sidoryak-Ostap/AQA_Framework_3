package task_12;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HeaderElement extends Element {
    public HeaderElement(WebElement webElement) {
        super(webElement);
    }
    public boolean verifyHeaderText(String expectedText){
        System.out.println("verifyText");
        Assert.assertEquals(super.getElement().getText(), expectedText, "Header text does not match!");
        return true;
    }

    public String getText() {
        System.out.println("Getting text");
        return webElement.getText();
    }

    public void waitForHeaderToBeVisible(){
        System.out.println("Waiting for header to be displayed");
        WebDriverWait wait = new WebDriverWait(DriverProvider.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(super.getElement()));
    };
}


//Headers:
//verifyHeaderText - verifies the text value of a header
//waitForHeaderToBeVisible - waits for a header to be visible
//getText - retrieves the text value of a header