package elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Input {
    private static final String LOCATOR = "//article//span[contains(text(),'%s')]/../..//input";

    WebElement element;

    public Input(WebDriver driver, String label) {
        element = driver.findElement(By.xpath(String.format(LOCATOR, label)));
        System.out.println("Looking for element " + element);
    }

    public void write(String text) {
        if (null != text) {
            element.sendKeys(text);
        } else {
            element.clear();
        }
        System.out.println("write text: " + text);
    }
}