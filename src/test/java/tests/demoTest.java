package tests;

import drivers.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import utils.Actions;


public class demoTest {
    @BeforeMethod
    public void setUp() {
        DriverManager.initializeDriver();
    }

    @Test
    public void testOpenApp() {
        AndroidDriver driver = DriverManager.getDriver();

        Actions.swipe("up");
        // todoist = driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Todoist\"]"));
        By todoist = By.xpath("//android.widget.TextView[@content-desc=\"Todoist\"]");
        System.out.println(Actions.getText(todoist));
        // continue with email
        WebElement email = driver.findElement(By.id("com.todoist:id/btn_welcome_email"));
        email.click();
        //enter email address
        WebElement addressMail = driver.findElement(By.id("com.todoist:id/email_exists_input"));
        addressMail.sendKeys("todoist1@gotgel.org");
        //click btn continue
        WebElement btnContinue = driver.findElement(By.id("com.todoist:id/btn_continue_with_email"));
        btnContinue.click();
        //enter password
        WebElement txtPassword = driver.findElement(By.id("com.todoist:id/sign_up_password"));
        txtPassword.sendKeys("12345678.");
        //click btn sign up
        WebElement btnSignUp = driver.findElement(By.id("com.todoist:id/btn_sign_up"));
        btnSignUp.click();
        //click skip
        WebElement btnSkip = driver.findElement(By.id("com.todoist:id/btn_sign_up"));
        btnSkip.click();
        //confirm skip
        WebElement btnConfirmSkip = driver.findElement(By.xpath("//android.view.ViewGroup/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button"));
        btnConfirmSkip.click();
        //click done
        WebElement btnDone = driver.findElement(By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button"));
        btnDone.click();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }
}

