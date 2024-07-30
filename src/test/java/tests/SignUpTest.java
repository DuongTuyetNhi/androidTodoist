package tests;

import drivers.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;
import pages.widget.AppPage;
import pages.widget.TodoistApp;
import utils.Actions;

public class SignUpTest extends BaseTest{
    AppPage appPage = new AppPage();
    TodoistApp todoistApp = new TodoistApp();
    String email = "todoist01@gotgel.org";
    String password = "12345678.";

    @Test(description = "User can sign up an account")
    public void SignUp(){
        Actions.swipe("up");
        appPage.chooseTodoistApp();
        todoistApp.clickContinueWithEmail();
        todoistApp.submitSignUp(email, password);
    }

}
