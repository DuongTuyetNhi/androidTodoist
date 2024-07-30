package pages.widget;

import io.appium.java_client.AppiumBy;
import models.Project;
import models.Task;
import org.openqa.selenium.By;
import utils.Actions;

public class TodoistApp extends AppPage{
    String todoist = "com.todoist:id/%s";
//    String date = "//android.view.View[@content-desc='%s']";
    String date = viewView + "[@content-desc='%s']";
    String button = wButton + "[@content-desc='%s']";
    String imageButton = wImageButton + "[@content-desc='%s']";
    String sltNavBar = wImageView + "[@resource-id='com.todoist:id/icon']/following-sibling::*/descendant::android.widget.TextView[@text='%s']";
    String txtTask = wTextView + "[@resource-id='com.todoist:id/text' and @text='%s']";
    String txtOldTask = wEditText + "[@resource-id='com.todoist:id/item_%s']";
    String txtEditText = wEditText + "[@text='%s']";
    //android.widget.EditText[@text='Password']
    String sltOldTask = viewViewGroup + "[@resource-id='com.todoist:id/item_attribute_%s']/android.view.View/android.view.View";
    String xsltPriority = wTextView + "[@text='P%s']";
    String inboxModal = wTextView + "[@resource-id='com.todoist:id/title' and @text='%s']";
    String sltTextView = wTextView + "[@text='%s']";
    String btnButton = wButton + "[@text='%s']";
    String radioBtn = wCheckedTextView + "[@text='%s']";
    String txtMessageInvite = wTextView + "[contains(@text, '%s invited you')]";
    String btnHandleInvite = txtMessageInvite + "/..//android.widget.Button[@text='%s']";

    By txtDescription = By.xpath(wEditText + "[@resource-id='com.todoist:id/description']");
    By btnSkip = By.xpath(wTextView + "[@text='Skip']");
    By btnConfirmSkip = By.xpath(viewViewGroup + "/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
    By btnDone = By.xpath("//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.widget.Button");
    By btnDoneEdit = By.xpath(wButton + "[@resource-id='com.todoist:id/item_submit']");
    By btnReschedule = By.id(String.format(todoist, "scheduler_submit"));
    By btnPriority = By.xpath(wButton + "[@resource-id='com.todoist:id/item_pill_priority']");
    By btnMoreOption = By.xpath(wImageView + "[@content-desc='More options']");

    By btnMoreOptionToDelete = By.xpath(wButton + "[@content-desc='Assign to']/following-sibling::android.widget.ImageView[@content-desc='More options']");
    By btnDelete = By.xpath(wTextView + "[@resource-id='com.todoist:id/title' and @text='Delete']");
    By btnDoneProject = By.xpath(wButton + "[@content-desc='Done']");
    public void clickContinueWithEmail(){
        By btnEmail = AppiumBy.xpath("//android.widget.Button[@resource-id='com.todoist:id/btn_welcome_email']");
        Actions.click(btnEmail);

    }
    public void submitSignUp(String email, String password){
        By txtEmail = By.id(String.format(todoist,"email_exists_input"));
        Actions.sendKeys(txtEmail, email);
        By btnContinue = By.id(String.format(todoist, "btn_continue_with_email"));
        Actions.click(btnContinue);

        By txtPassword = By.id(String.format(todoist, "sign_up_password"));
        Actions.sendKeys(txtPassword, password);
        By btnSignUp = By.id(String.format(todoist, "btn_sign_up"));
        Actions.click(btnSignUp);

        //skip
        Actions.click(btnSkip);
        Actions.click(btnConfirmSkip);
        Actions.click(btnDone);
    }

    public void submitSignIn(String email, String password){
        By txtEmail = By.id(String.format(todoist,"email_exists_input"));
        Actions.sendKeys(txtEmail, email);
        By btnContinue = By.id(String.format(todoist, "btn_continue_with_email"));
        Actions.click(btnContinue);

        By txtPassword = By.xpath(String.format(txtEditText, "Password"));
        Actions.sendKeys(txtPassword, password);
        By btnLogIn = By.xpath(String.format(btnButton, "LOG IN"));
        Actions.click(btnLogIn);

    }
    public void choosePagination(String pagination){
        By element;
        switch (pagination.toLowerCase()){
            case "add":
                element = By.xpath(String.format(imageButton, "Quick add"));
                break;
            case "menu":
                element = By.xpath(String.format(imageButton, "Menu"));
                break;
            case "search":
                element = By.xpath(String.format(button, "Search"));
                break;
            case "notifications":
                element = By.xpath(String.format(button, "Notifications"));
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + pagination.toLowerCase());
        }
        Actions.click(element);
    }
    public void addTask(Task task){
        By txtTaskName = By.id("android:id/message");
        Actions.sendKeys(txtTaskName, (task.getTaskName() + " !!" + task.getPriority()));

        Actions.sendKeys(txtDescription, task.getDescription());

        By cbbDate = By.id(String.format(todoist, "schedule"));
        Actions.click(cbbDate);

        By sltDate = By.xpath(String.format(date, task.getDate()));
        Actions.swipeToView(sltDate);
        Actions.click(sltDate);

        Actions.click(btnReschedule);
    }
    public void clickAddTaskBtn(){
        By btnAdd = By.id("android:id/button1");
        Actions.click(btnAdd);
        By txtToday = By.xpath("//android.widget.TextView[@text='Today']");
        Actions.click(txtToday);
    }

    public void chooseWidget(String widget){
        By sltWidget = By.xpath(String.format(sltNavBar, widget));
        Actions.click(sltWidget);
    }

    public void editTask(String taskName, Task task){
        By oldTask = By.xpath(String.format(txtTask, taskName));
        Actions.click(oldTask);

        if (task.getTaskName() != null) {
            By txtOldTaskName = By.xpath(String.format(txtOldTask, "content"));
            Actions.click(txtOldTaskName);
            Actions.sendKeys(txtOldTaskName, task.getTaskName());
            Actions.click(btnDoneEdit);
        }
        if (task.getDescription() != null) {
            By txtOldTaskDescription = By.xpath(String.format(txtOldTask, "description"));
            Actions.click(txtOldTaskDescription);
            Actions.sendKeys(txtOldTaskDescription, task.getDescription());
            Actions.click(btnDoneEdit);
        }
        if (task.getDate() != null) {
            By sltOldDate = By.xpath(String.format(sltOldTask, "due_date"));
            Actions.click(sltOldDate);

            By sltDate = By.xpath(String.format(date, task.getDate()));
            Actions.swipeToView(sltDate);
            Actions.click(sltDate);
            Actions.click(btnReschedule);
        }
        if (task.getPriority() != null) {
            Actions.click(btnPriority);
            By sltPriority = By.xpath(String.format(xsltPriority, task.getPriority()));
            Actions.click(sltPriority);
            Actions.swipe("down");
        }
    }

    public void chooseModal(String modal){
        By element = By.xpath(String.format(inboxModal, modal));
        Actions.click(element);
    }

    public void deleteTask(String taskName){
        Actions.click(btnMoreOption);
        chooseModal("Select tasks");

        By oldTask = By.xpath(String.format(txtTask, taskName));
        Actions.click(oldTask);

        Actions.click(btnMoreOptionToDelete);
        Actions.click(btnDelete);

        By btnYes = By.xpath(String.format(btnButton, "YES"));
        Actions.click(btnYes);
    }

    public boolean isTaskDisplayed(String taskName){
        By oldTask = By.xpath(String.format(txtTask, taskName));
        return Actions.waitForElementInvisibility(oldTask, 25);
    }

    public void addProject(Project project){
        By icnAdd = By.xpath(String.format(imageButton, "Add"));
        Actions.click(icnAdd);

        By txtNameProject = By.xpath(String.format(txtEditText, "Name"));
        Actions.sendKeys(txtNameProject, project.getProjectName());

        By sltColor = By.xpath(String.format(sltTextView, "Color"));
        Actions.click(sltColor);
        if (project.getColor() != null){
            By color = By.xpath(String.format(sltTextView, project.getColor().getValueColor()));
            Actions.swipeToView(color);
            Actions.click(color);
        }

        if (project.getAccess() != null){

        }

        if (project.getParent() != null){

        }

        if (project.getFavorite() != null){
            By toggleSwitch = By.xpath(wSwitch);
            Actions.click(toggleSwitch);
        }

        By sltView = By.xpath(String.format(radioBtn, project.getView().getValueView()));
        Actions.click(sltView);

        Actions.click(btnDoneProject);
    }

    public void handleInvite(String user, String handle){
        By msgInvite = By.xpath(String.format(txtMessageInvite, user));
        Actions.click(msgInvite);

        By btnHandle = By.xpath(String.format(btnHandleInvite, user, handle));
        Actions.click(btnHandle);
    }

}
