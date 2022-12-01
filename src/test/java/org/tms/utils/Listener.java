package org.tms.utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.tms.driver.DriverSingleton;

import java.util.concurrent.TimeUnit;

public class Listener implements ITestListener {

    private static final String TAKE_SCREENSHOT_PROCESS_NAME = "Take screenshot";

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(String.format("========== STARTING TEST %s ==========", result.getName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println(String.format("========== FINISHED TEST %s Duration: %ss ==========", result.getName(),
                getExecutionTime(result)));
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println(String.format("========== FAILED TEST %s Duration: %ss ==========", result.getName(),
                getExecutionTime(result)));
        takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println(String.format("========== SKIPPING TEST %s ==========", result.getName()));
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println(String.format("========== FAILED TEST WITHIN SUCCESS PERCENTAGE %s Duration: %ss ==========",
                result.getName(), getExecutionTime(result)));
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println(String.format("========== FAILED TEST WITH TIMEOUT %s Duration: %ss ==========",
                result.getName(), getExecutionTime(result)));
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("========== START ==========");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("========== STOP ==========");
    }

    private long getExecutionTime(ITestResult iTestResult) {
        return TimeUnit.MILLISECONDS.toSeconds(iTestResult.getEndMillis() - iTestResult.getStartMillis());
    }

    @Attachment(value = "Last screen state", type = "image/png")
    private byte[] takeScreenshot() {
        MessageLogger.logStartProcessInfo(TAKE_SCREENSHOT_PROCESS_NAME);
        return ((TakesScreenshot) DriverSingleton.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
