package baseTest;

import org.openqa.selenium.WebDriver;

public class appDriver {

    public static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver()
    {
        return driver.get();
    }

    public static void setDriver(WebDriver Driver)
    {
        driver.set(Driver);
    }
}
