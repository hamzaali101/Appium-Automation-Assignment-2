package baseTest;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;
import utilities.configReader;

import java.net.MalformedURLException;
import java.net.URL;

public class appFactory {

    public static configReader confReader;
    public static AndroidDriver driver;
    public static void initializer() throws MalformedURLException {

        DesiredCapabilities dCap = new DesiredCapabilities();
        confReader = new configReader();

        dCap.setCapability(MobileCapabilityType.AUTOMATION_NAME, confReader.getAutomationName());
        dCap.setCapability(MobileCapabilityType.PLATFORM_NAME, confReader.getPlatformName());
        dCap.setCapability(MobileCapabilityType.PLATFORM_VERSION, confReader.getplatformVersion());
        dCap.setCapability(MobileCapabilityType.DEVICE_NAME, confReader.getdeviceName());
        dCap.setCapability("newCommandTimeout",100000);
        dCap.setCapability(MobileCapabilityType.APP, confReader.getapk());
        URL url = new URL(confReader.geturl());
        driver = new AndroidDriver(url, dCap);

        appDriver.setDriver(driver);

    }

    public static void quitDriver()
    {
        if(null != driver)
            driver.quit();
    }
}
