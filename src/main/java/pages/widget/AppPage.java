package pages.widget;

import org.openqa.selenium.By;
import utils.Actions;

public class AppPage extends HomePage{
    By todoistApp = By.xpath((wTextView + "[@text='Todoist']"));

    public void chooseTodoistApp(){
        Actions.click(todoistApp);
    }
}
