package pages;

import elements.Input;
import elements.TextArea;
import models.Account;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountsPage extends BasePage {

    private static final String NEW_BUTTON_CSS = "[title=New]";
    private static final String SAVE_BUTTON_CSS = "[title=Save]";

    public AccountsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AccountsPage isPageOpened() {
        return this;
    }

    @Override
    public AccountsPage openPage() {
        driver.get("https://ap17.lightning.force.com/lightning/o/Account/list?filterName=Recent");
        return this;
    }

    public AccountsPage clickNew() {
        driver.findElement(By.cssSelector(NEW_BUTTON_CSS)).click();
        return this;
    }

    public AccountsPage createAccount(Account account) {
        new Input(driver, "Account Name").write(account.getAccountName());
        new Input(driver, "Phone").write(account.getPhone());
        new TextArea(driver, "Description").write(account.getDescription());
        //тут код чтобы заполгнить все поля
        driver.findElement(By.cssSelector(SAVE_BUTTON_CSS)).click();
        return this;
    }
}

