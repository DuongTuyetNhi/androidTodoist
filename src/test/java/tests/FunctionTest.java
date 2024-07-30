package tests;

import enums.Color;
import enums.View;
import models.Project;
import models.Task;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.widget.AppPage;
import pages.widget.TodoistApp;
import utils.Actions;

public class FunctionTest extends BaseTest{
    AppPage appPage = new AppPage();
    TodoistApp todoistApp = new TodoistApp();
    Task task = new Task("Task ok", "task ni ni", "10 October 2024", "2");
    Task task1 = new Task("OKOK", null, "12 October 2024", "1");
    Project project = new Project("Project 4", Color.BERRY_RED, null, null, null, View.BOARD);

//    @Test(description = "User can create new task")
//    public void create(){
//        Actions.swipe("up");
//        appPage.chooseTodoistApp();
//        todoistApp.choosePagination("add");
//
//        todoistApp.addTask(task);
//        todoistApp.clickAddTaskBtn();
//    }
//
//    @Test(description = "User can edit task")
//    public void edit(){
//        Actions.swipe("up");
//        appPage.chooseTodoistApp();
//        todoistApp.choosePagination("menu");
//        todoistApp.chooseWidget("Inbox");
//
//        todoistApp.editTask("OK OK", task1);
//        Actions.swipe("down");
//    }
//
//    @Test(description = "User can delete task")
//    public void delete(){
//        Actions.swipe("up");
//        appPage.chooseTodoistApp();
//        todoistApp.choosePagination("menu");
//        todoistApp.chooseWidget("Inbox");
//
//        todoistApp.deleteTask("Task 11");
//        Assert.assertTrue(todoistApp.isTaskDisplayed("Task 11"), "Task is not disappear!");
//
//    }

    @Test(description = "User can create new project")
    public void createNewProject(){
        Actions.swipe("up");
        appPage.chooseTodoistApp();
        todoistApp.choosePagination("menu");

        todoistApp.addProject(project);
    }


}
