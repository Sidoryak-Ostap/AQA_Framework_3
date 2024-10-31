package task_13;

import io.qameta.allure.Attachment;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.apache.logging.log4j.Logger;

import static task_12.DriverProvider.getDriver;


public class MyTestListener implements ITestListener {
    protected final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        LOGGER.error(result.getMethod().getMethodName()+ "\n" + result.getThrowable());

    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        LOGGER.info(context.getName() + " " + context.getFailedTests());
    }



}


//General task
//Implement custom Listeners with methods for your variant.
//Add logging for all overridden listener methods using log4j console and file appenders
//Add video recorder for onFail action (you can use any lib for that)
//V16. ITestListener method task (5, 7);ISuiteListener, IExecutionListener,IInvoke...(2, 4)