package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Select {
    private static final String SALUTATION_CSS = "//article//span[contains(text(),'%s')]/../..//div";
    private static final String SELECTION = "//a[@title = '%s']";

    WebElement element;

    public Select(WebDriver driver, String label) {
        element = driver.findElement(By.xpath(String.format(SALUTATION_CSS, label)));
    }

    public void select(WebDriver driver, String salutation) {
        element.click();
        driver.findElement(By.xpath(String.format(SELECTION, salutation))).click();
    }
}