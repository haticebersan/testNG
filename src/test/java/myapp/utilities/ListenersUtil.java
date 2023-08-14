package myapp.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ListenersUtil implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {

    @Override
    public void onStart(ITestContext context) {//This is like @BeforeSuite
        System.out.println("onStart: executes ONCE BEFORE all @Test cases ");
    }

    @Override
    public void onFinish(ITestContext context) {//This is like @AfterSuite
        System.out.println("onFinish: executes ONCE AFTER all @Test cases ");
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart: executes ONCE BEFORE EACH @Test cases ");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess: executes ONCE AFTER EACH PASSING @Test cases ");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped: executes ONCE AFTER EACH SKIPPED @Test cases ");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure: executes ONCE AFTER EACH FAILED @Test cases ");
        //If test cases failed this code will take screenshot
        try {
            MediaUtils.takeScreenshotOfTheEntirePage();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private int retryCount = 0;
    private static final int maxRetryCount = 100;

    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

    //This makes the failed test cases automatically rerun using testng xml files
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(ListenersUtil.class);
    }


}
