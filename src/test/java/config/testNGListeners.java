package config;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testNGListeners implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("******"+ context.getName() + " is Test started");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("******"+ result.getName() + " is Test failing, Please check");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("******"+ result.getName() + " is Test completed");

    }

    public void onFinish(ITestContext context) {
        System.out.println("******"+ context.getName() + " is Test Finished");

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("******"+ result.getName() + " is Test successfull");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
        System.out.println("******"+ result.getName() + " done and failed within success percentage");

    }
    @Override
    public void onTestStart(ITestResult result){
        System.out.println("******"+ result.getName() + " is Started");
    }

}
