package Appium;

        import io.appium.java_client.AppiumDriver;
        import io.appium.java_client.MobileBy;
        import io.appium.java_client.MobileElement;
        import io.appium.java_client.android.AndroidDriver;
        import io.appium.java_client.remote.MobileCapabilityType;
        import org.junit.Test;
        import org.junit.Assert;
        //import org.junit.jupiter.api.Test;
        import org.openqa.selenium.remote.DesiredCapabilities;

        import java.net.MalformedURLException;
        import java.net.URL;

public class CalculatorTest {
    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 3");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        //App=Calculator
        capabilities.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/calculator.apk");
        //App=Etsy
        //capabilities.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/etsy.apk");
        URL url = new URL("http://localhost:4723/wd/hub");

        //launch AppiumDriver
        AppiumDriver<MobileElement> driver;
        driver = new AndroidDriver<MobileElement>(url, capabilities);

        //System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getDeviceTime() = " + driver.getDeviceTime());
        System.out.println("driver.getPlatformName() = " + driver.getPlatformName());
        Assert.assertEquals("android", driver.getPlatformName());
        Thread.sleep(3000);

        //locate AC element
        MobileElement clearElement=driver.findElement(MobileBy.AccessibilityId("clear"));
        System.out.println("clearElement.getText() = " + clearElement.getText());
        Assert.assertTrue(clearElement.isDisplayed());

        //close the App
        driver.closeApp();
    }
}
