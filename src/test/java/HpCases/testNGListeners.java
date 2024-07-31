package HpCases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class testNGListeners implements ITestListener {

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
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

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("******"+ result.getName() + " is Test successfull");

    }


}
