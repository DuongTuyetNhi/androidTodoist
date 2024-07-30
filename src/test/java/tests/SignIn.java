package tests;

import org.testng.annotations.Test;
import pages.widget.AppPage;
import pages.widget.TodoistApp;
import utils.Actions;

public class SignIn extends BaseTest{
    AppPage appPage = new AppPage();
    TodoistApp todoistApp = new TodoistApp();
    String email = "todoist01@gotgel.org";
    String password = "12345678.";

    @Test(description = "User can sign in an account have been registered")
    public void SignIn(){
        Actions.swipe("up");
        appPage.chooseTodoistApp();
        todoistApp.clickContinueWithEmail();
        todoistApp.submitSignIn(email, password);
    }
}
