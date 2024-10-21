package GenericUtilities;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import static GenericUtilities.BaseTest.driver;

public class TestngListeners {

    @Test(priority=1)
    public void getTitle() {
        System.out.println("Title is- " + driver.getTitle());
    }

    @Test(priority=2)
    public void skipTest() {
        throw new SkipException("This test skipped- " + this.getClass().getSimpleName());
    }

    @Test(priority=3)
    public void failTest() {
        Assert.assertEquals(driver.getTitle(), "Test");
    }
}
