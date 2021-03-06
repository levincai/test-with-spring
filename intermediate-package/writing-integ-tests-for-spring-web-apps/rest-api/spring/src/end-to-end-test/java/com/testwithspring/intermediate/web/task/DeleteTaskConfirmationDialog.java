package com.testwithspring.intermediate.web.task;

import com.testwithspring.intermediate.SeleniumWait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 *  This class represents the configuration dialog that is shown when
 *  a user clicks the delete link found from the view task page.
 */
final class DeleteTaskConfirmationDialog {

    private final WebDriver browser;
    private final WebElement taskActions;

    DeleteTaskConfirmationDialog(WebDriver browser, WebElement taskActions) {
        this.browser = browser;
        this.taskActions = taskActions;
    }

    public DeleteTaskConfirmationDialog open() {
        taskActions.findElement(By.id("delete-task-link")).click();
        SeleniumWait.waitUntilElementIsClickable(browser, By.id("delete-task-button"));
        return this;
    }

    TaskListPage deleteTask() {
        WebElement deleteButton = browser.findElement(By.id("delete-task-button"));
        deleteButton.click();

        TaskListPage targetPage = new TaskListPage(browser);
        targetPage.waitUntilPageIsOpen();
        return targetPage;
    }
}
