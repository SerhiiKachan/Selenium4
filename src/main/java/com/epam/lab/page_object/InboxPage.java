package com.epam.lab.page_object;

import com.epam.lab.specific_element.Button;
import com.epam.lab.specific_element.CheckBox;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class InboxPage {

    private WebDriver driver;
    private List<String> identifiers;
    private final Logger LOG = Logger.getLogger(InboxPage.class);

    @FindBy(css = "table.F.cf.zt tbody div[role='checkbox']")
    private List<CheckBox> messages;

    @FindBy(css = "div.T-I.J-J5-Ji.nX.T-I-ax7.T-I-Js-Gs.mA")
    private Button deleteButton;

    @FindBy(id = "link_undo")
    private Button undoButton;

    public InboxPage(WebDriver webDriver) {
        driver = webDriver;
        PageFactory.initElements(new CustomFieldDecorator(driver), this);
        identifiers = new ArrayList<>();
    }

    private void selectMessage(CheckBox message, int index) {
        try {
            if (!message.isChecked())
                message.click();
        } catch (StaleElementReferenceException e) {
            message = messages.get(index - 1);
            if (!message.isChecked())
                message.click();
        }
        identifiers.add(message.getAttribute("id"));
        LOG.info("Message selected");
    }

    private void deleteMessages() {
        LOG.info("Deleting messages...");
        deleteButton.click();
        LOG.info("Completed");
    }

    private void undo() {
        LOG.info("Undo deleting...");
        undoButton.click();
        LOG.info("Completed");
    }

    public void selectAndDeleteMessages(int quantity) {
        LOG.info("Inside inbox page");
        LOG.info("Selecting messages to delete...");
        int i = 1;
        if (messages.size() >= quantity) {
            while (i <= quantity) {
                selectMessage(messages.get(i - 1), i);
                i++;
            }
        } else {
            LOG.error("Quantity of selected messages is larger than quantity of all located messages.");
        }
        deleteMessages();
        undo();
    }

    public boolean isUndoCompleted() {
        LOG.info("Checking undo operation...");
        try {
            Thread.sleep(1000);
            int i = 0;
            while (i < 3) {
                if (!messages.get(i).getAttribute("id").equals(identifiers.get(i)))
                    throw new NoSuchElementException("Can't find element with id=" + identifiers.get(i) + ". Element has been deleted.");
                i++;
            }
            LOG.info("Completed");
            return true;
        } catch (NoSuchElementException e) {
            LOG.error(e.getMessage());
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }
}
