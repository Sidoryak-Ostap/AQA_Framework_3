package task_12;

import com.automation.remarks.testng.UniversalVideoListener;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task_13.MyExecutionListener;
import task_13.MyTestListener;


@Listeners({MyTestListener.class, MyExecutionListener.class, UniversalVideoListener.class})
public class Task12Test {


    @Test
    void headersTest(){
        new StackOverflowBO().openStackOvAboutTab().verifyStackOvAboutHeader();
    }

    @Test
    void negativeHeadersTest(){
        new StackOverflowBO().verifyStackOvAboutHeader();
    }

    @AfterTest
    void closeBrowser() {
        DriverProvider.getDriver().close();
    }
}









//Implement PageFactory for a few pages.
//Implement Wrapper for common WebElements (choose your variant).
//Implement methods for your web element with console logging. (Choose your variant with specific methods)
//Use those methods in simple TC scenario

//Headers:
//verifyHeaderText - verifies the text value of a header
//waitForHeaderToBeVisible - waits for a header to be visible
//getText - retrieves the text value of a header