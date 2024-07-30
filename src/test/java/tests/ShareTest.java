package tests;

import org.testng.annotations.Test;
import pages.widget.AppPage;
import pages.widget.TodoistApp;
import utils.Actions;

public class ShareTest extends BaseTest{
    AppPage appPage = new AppPage();
    TodoistApp todoistApp = new TodoistApp();

    @Test(description = "Accept invite")
    public void handleInvitation(){
        Actions.swipe("up");
        appPage.chooseTodoistApp();
        todoistApp.choosePagination("Notifications");

        todoistApp.handleInvite("nau", "DECLINE");
    }
}
