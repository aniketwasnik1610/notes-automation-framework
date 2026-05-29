package pages;

import base.BasePage;
import drivers.DriverFactory;
import org.openqa.selenium.By;
import utils.WaitUtility;

public class NotesPage extends BasePage {

    private final By addNoteBtn =
            By.xpath(
                    "/html/body/main/div[3]/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/div[2]/button"
            );

    private final By titleField =
            By.id("title");

    private final By descriptionField =
            By.id("description");

    private final By createBtn =
            By.xpath(
                    "//button[contains(text(),'Create')]"
            );

    public void createNote(
            String title,
            String description) {

        click(addNoteBtn);

        type(titleField,title);

        type(descriptionField,description);

        click(createBtn);
    }

    public boolean isAddNoteVisible() {
        try {
            return DriverFactory.getDriver().findElement(addNoteBtn).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isNotePresent(String title) {
        try {
            By noteTitleLocator = By.xpath("//*[contains(text(),\"" + title + "\")]");
            // wait a short time implicitly via WaitUtility
            WaitUtility.waitForElement(noteTitleLocator);
            return DriverFactory.getDriver().findElements(noteTitleLocator).size() > 0;
        } catch (Exception e) {
            return false;
        }
    }

    public void refreshPage() {
        DriverFactory.getDriver().navigate().refresh();
    }
}