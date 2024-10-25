package task_12;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Task12Test {


    @Test
    void headersTest(){
        new StackOverflowBO().openStackOvAboutTab().verifyStackOvAboutHeader();
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