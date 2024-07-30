package tests;

import drivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {
    @BeforeMethod
    @Parameters("emulator")
    public void setUp(String emulator) throws Throwable {
        System.out.println("Pre-condition");
        DriverManager.setEmulator(emulator);
        DriverManager.initializeDriver();
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("Post-condition");
        DriverManager.quitDriver();
    }
}
