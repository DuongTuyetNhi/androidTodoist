package utils;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;

import java.time.Duration;

import static drivers.DriverManager.getDriver;

public class Actions {
    public static void click(By element){
        getDriver().findElement(element).click();
    }

    public static void sendKeys(By element, String information){
        getDriver().findElement(element).sendKeys(information);
    }

    public static String getText(By element){
        return getDriver().findElement(element).getText();
    }

    public static boolean isDisplay(By element){
        return getDriver().findElement(element).isDisplayed();
    }

    public static boolean isElementInViewport(By element) {
        try {
            WebElement webElement = getDriver().findElement(element);

            // Lấy kích thước màn hình
            Dimension windowSize = getDriver().manage().window().getSize();
            int windowHeight = windowSize.getHeight();
            int windowWidth = windowSize.getWidth();

            // Lấy vị trí của phần tử
            Point elementLocation = webElement.getLocation();
            int elementTop = elementLocation.getY();
            int elementBottom = elementTop + webElement.getSize().getHeight();
            int elementLeft = elementLocation.getX();
            int elementRight = elementLeft + webElement.getSize().getWidth();

            // Kiểm tra xem phần tử có nằm trong vùng nhìn thấy được hay không
            return (elementTop >= 0 && elementBottom <= windowHeight) &&
                    (elementLeft >= 0 && elementRight <= windowWidth);
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void swipe(String direction) {
        int startX, startY, endX, endY;
        int width = getDriver().manage().window().getSize().width;
        int height = getDriver().manage().window().getSize().height;

        switch (direction.toLowerCase()) {
            case "up":
                startX = width / 2;
                startY = (int) (height * 0.6);
                endX = width / 2;
                endY = (int) (height * 0.1);
                break;
            case "down":
                startX = width / 2;
                startY = (int) (height * 0.2);
                endX = width / 2;
                endY = (int) (height * 0.8);
                break;
            case "left":
                startX = (int) (width * 0.8);
                startY = height / 2;
                endX = (int) (width * 0.2);
                endY = height / 2;
                break;
            case "right":
                startX = (int) (width * 0.2);
                startY = height / 2;
                endX = (int) (width * 0.8);
                endY = height / 2;
                break;
            default:
                throw new IllegalArgumentException("Invalid swipe direction: " + direction);
        }

        new TouchAction<>((PerformsTouchActions) getDriver())
                .press(PointOption.point(startX, startY))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();
    }

    public static void waitForElementVisible(By xpath, int timeout){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        wait.until(ExpectedConditions.visibilityOfElementLocated(xpath));
    }

    public static Boolean waitForElementInvisibility(By element, int timeout){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }

    public static void scrollToView(By xpath){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        WebElement element = getDriver().findElement(xpath);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }
    public static void swipeToView(By element) {
        int swipeCount = 1;
        while (!isElementInViewport(element)) {
            swipe("up");
            swipeCount++;
        }

        if (isElementInViewport(element)) {
            System.out.println("Element found after " + swipeCount + " swipes.");
        }
    }

}
