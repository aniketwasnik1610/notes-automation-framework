package pages;

import base.BasePage;
import org.openqa.selenium.By;

public class NotesPage extends BasePage {

    private final By addNoteBtn =
            By.xpath("/html/body/main/div[3]/div[2]/div/div/div/div/div/div/div[2]/div/div[2]/div[2]/button");

    private final By titleField =
            By.id("title");

    private final By descriptionField =
            By.id("description");

    private final By createBtn =
            By.xpath("//button[contains(text(),'Create')]");

    public void createNote(
            String title,
            String description) {

        Wait(3000);

        click(addNoteBtn);

        Wait(3000);

        type(titleField,title);

        Wait(2000);

        type(descriptionField,description);

        Wait(2000);

        click(createBtn);

        Wait(5000);
    }
}