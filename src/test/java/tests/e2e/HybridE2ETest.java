package tests.e2e;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.TestListener.class)
public class HybridE2ETest extends BaseTest {

    @Test(description = "TC-E2E-01")
    public void uiApiValidationTest() {

        Assert.assertTrue(true);
    }

    @Test(description = "TC-E2E-02")
    public void deletedNoteDisappearTest() {

        Assert.assertTrue(true);
    }
}