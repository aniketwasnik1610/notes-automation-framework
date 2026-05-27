package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.ScreenshotUtil;

public class TestListener
        implements ITestListener {

    @Override
    public void onTestFailure(
            ITestResult result) {

        ScreenshotUtil.capture(
                result.getName());
    }

    @Override
    public void onStart(
            ITestContext context) {

    }

    @Override
    public void onFinish(
            ITestContext context) {

    }
}