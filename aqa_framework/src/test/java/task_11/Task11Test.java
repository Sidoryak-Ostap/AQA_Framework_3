package task_11;


import com.automation.remarks.testng.UniversalVideoListener;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import task_12.DriverProvider;
import task_14.MyTestListener;


@Listeners({MyTestListener.class, UniversalVideoListener.class})
public class Task11Test {


    @Test
    void findBook(){

        String inputValue = "learning";
        // Step 1. Go to web book store page
        new WebBookBO().goToBookStore()
                // Step 2. Focus input
                .focusInput()
                // Step 3. Enter text in input
                .fillInput(inputValue)
                // Step 4. Click "search" button
                .clickSearchButton()
                // Step 4. Verify found result
                .verifyResult();
    }

    @Test
    void negativeFindBook(){
        String inputValue = "learning";
        // Step 1. Go to web book store page
        new WebBookBO().goToBookStore()
                // Step 2. Focus input
                .focusInput()
                // Step 3. Enter text in input
                .fillInput(inputValue)
                // Step 4. Click "search" button
                .clickSearchButton()
                // Step 4. Verify found result
                .verifyResult();

        Assert.fail();
    }

    @AfterTest
    void closeBrowser(){
        DriverProvider.getDriver().close();
    }


}






//General task
//1. Make up one simple UI end-to-end test case for your test page from Task_10
//2. Automate that scenario using WebDriver
//3. Create PageObject (use Busines object if need)for all pages used in scenario
//
//Scenario example (new account)
//- Navigate to the sign-up page
//- Enter a valid email address, a username, and a strong password
//- Click on the "Sign Up" button
//- Verify that the user is redirected to the home page
//- Verify that the user account is created andlogged in