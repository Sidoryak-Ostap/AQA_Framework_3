package task_14;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.*;

import static task_12.DriverProvider.getDriver;

public class MyTestListener implements ITestListener, IInvokedMethodListener {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
        IInvokedMethodListener.super.afterInvocation(method, testResult);
        if(testResult.getStatus() == ITestResult.FAILURE){
            attachDOM();
            makeScreenShot();
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        LOGGER.error(result.getMethod().getMethodName() + "\n" + result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        LOGGER.info(context.getName() + " " + context.getFailedTests());
    }

    @Attachment(value = "Page screen", type = "image/png")
    private byte[] makeScreenShot() {
            return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
        }

    @Attachment(value = "Page source DOM", type = "text/html")
    private String attachDOM() {
        return  getDriver().getPageSource();
    }
}
