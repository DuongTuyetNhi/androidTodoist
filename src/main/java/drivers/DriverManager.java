package drivers;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static final ThreadLocal<AndroidDriver> driver = new ThreadLocal<>();
    private static final ThreadLocal<String> emulator = new ThreadLocal<>();

    public static AndroidDriver getDriver() {
        if (driver.get() == null) {
            throw new RuntimeException("Driver not initialized. Call initializeDriver() first.");
        }
        return driver.get();
    }

    public static void initializeDriver() {
        String emulator = getEmulator().toLowerCase();
        if (driver.get() == null) {
            try {
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("automationName", "UiAutomator2");
                capabilities.setCapability("udid", emulator);

                URL url = new URL("http://localhost:4723/wd/hub");
                AndroidDriver initializedDriver = new AndroidDriver(url, capabilities);
                initializedDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                driver.set(initializedDriver);
            } catch (MalformedURLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to initialize the driver.", e);
            }
        }
    }

    public static void setEmulator(String emulatorName) {
        emulator.set(emulatorName);
    }

    public static String getEmulator() {
        return emulator.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}
