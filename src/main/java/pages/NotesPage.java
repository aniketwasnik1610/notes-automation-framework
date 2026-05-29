package pages;

import base.BasePage;
import drivers.DriverFactory;
import org.openqa.selenium.By;
import utils.WaitUtility;

public class NotesPage extends BasePage {

    private final By addNoteBtn =
            By.cssSelector("[data-testid='add-new-note']");

    private final By titleField =
            By.id("title");

    private final By descriptionField =
            By.id("description");

    private final By createBtn =
            By.xpath("//button[contains(text(),'Create')]");

    public void createNote(String title, String description) {

        WaitUtility.waitForElement(addNoteBtn);
        click(addNoteBtn);

        WaitUtility.waitForElement(titleField);
        type(titleField, title);

        WaitUtility.waitForElement(descriptionField);
        type(descriptionField, description);

        WaitUtility.waitForElement(createBtn);
        click(createBtn);
    }

    public boolean isAddNoteVisible() {
        try {
            WaitUtility.waitForElement(addNoteBtn);
            return DriverFactory.getDriver()
                    .findElement(addNoteBtn)
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNotePresent(String title) {
        try {

            By noteTitleLocator =
                    By.xpath("//*[contains(text(),'" + title + "')]");

            WaitUtility.waitForElement(noteTitleLocator);

            return DriverFactory.getDriver()
                    .findElements(noteTitleLocator)
                    .size() > 0;

        } catch (Exception e) {
            return false;
        }
    }

    public void refreshPage() {
        DriverFactory.getDriver().navigate().refresh();
    }
}