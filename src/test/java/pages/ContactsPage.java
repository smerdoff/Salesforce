package pages;

import elements.Input;
import elements.Select;
import elements.TextArea;
import models.Contact;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContactsPage extends BasePage {
    private static final String NEW_BUTTON_CSS = "[title=New]";
    private static final String SAVE_BUTTON_CSS = "[title=Save]";
    private static final String SALUTATION_CSS = "div .salutation";
    private static final String SELECTION = "//a[@title = '%s']";

    public ContactsPage(WebDriver driver) { super(driver); }

    @Override
    public BasePage isPageOpened() { return this; }

    @Override
    public BasePage openPage() {
        driver.get("https://ap17.lightning.force.com/lightning/o/Contact/list?filterName=Recent");
        return this;
    }

    public ContactsPage clickNew() {
        driver.findElement(By.cssSelector(NEW_BUTTON_CSS)).click();
        return this;
    }

    public ContactsPage fillInInputs(Contact contact) {
        new Input(driver, "First Name").write(contact.getFirstName());
        new Input(driver, "Middle Name").write(contact.getMiddleName());
        new Input(driver, "Last Name").write(contact.getLastName());
        new Input(driver, "Suffix").write(contact.getSuffix());
        new Input(driver, "Title").write(contact.getTitle());
        new Input(driver, "Email").write(contact.getEmail());
        new Input(driver, "Phone").write(contact.getPhone());
        new Input(driver, "Mobile").write(contact.getMobile());
        new Input(driver,"Fax").write(contact.getFax());
        new TextArea(driver, "Mailing Street").write(contact.getMailingStreet());
        return this;
    }

    public ContactsPage selectSalutation(String selection) {
        new Select(driver,"Salutation").select(driver, selection);
        return this;
    }

    public ContactsPage fillInAccountName(Contact contact) {
        new Input(driver, "Account Name").write(contact.getAccountName());
        driver.findElement(By.cssSelector(".uiAutocompleteOption")).click();
        return this;
    }

    public void clickSave() {
        driver.findElement(By.cssSelector(SAVE_BUTTON_CSS)).click();
    }
}